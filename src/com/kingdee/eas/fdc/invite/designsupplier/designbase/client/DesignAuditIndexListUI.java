/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.designbase.client;

import java.awt.event.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.KDTableHelper;
import com.kingdee.bos.ctrl.swing.tree.DefaultKingdeeTreeNode;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.fdc.basedata.client.FDCMsgBox;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexTreeInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.rptclient.newrpt.util.MsgBox;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.basedata.org.OrgConstants;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class DesignAuditIndexListUI extends AbstractDesignAuditIndexListUI
{
    private static final Logger logger = CoreUIObject.getLogger(DesignAuditIndexListUI.class);
    
    /**
     * output class constructor
     */
    public DesignAuditIndexListUI() throws Exception
    {
        super();
    }

    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
    	/*
    	 * ���Ƿ�Ҷ�ӽڵ㣬�ſ�������ָ��
    	 */
    	if (!SysContext.getSysContext().getCurrentOrgUnit().getId().toString().equals(OrgConstants.DEF_CU_ID)) {
			MsgBox.showWarning(this, getSupplierResources("notAddBase"));
        	SysUtil.abort();
		}
    	if(getTypeSelectedTreeNode().getUserObject() instanceof DesignAuditIndexTreeInfo&&((DesignAuditIndexTreeInfo)getTypeSelectedTreeNode().getUserObject()).isIsLeaf()){
			getUIContext().put("group", ((DesignAuditIndexTreeInfo)getTypeSelectedTreeNode().getUserObject()));
    		super.actionAddNew_actionPerformed(e);
		}else{
			FDCMsgBox.showWarning(this,getResource("leafage"));
		}
    }
    private String getResource(String msg) {
		return EASResource.getString("com.kingdee.eas.fdc.invite.supplier.SupplierResource", msg);
	}
    private String getSupplierResources(String key) {
	    return	EASResource.getString("com.kingdee.eas.fdc.invite.supplier.SupplierResource",key);

	}
    
    public DefaultKingdeeTreeNode getTypeSelectedTreeNode() {
		return (DefaultKingdeeTreeNode) this.treeMain
				.getLastSelectedPathComponent();
	}
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    public void onLoad() throws Exception {
    	super.onLoad();
    	this.actionCancel.setVisible(true);
    	this.actionCancelCancel.setVisible(true);
    	this.actionQuery.setVisible(false);
    	/*
		 * ������񣬽�ѡ��һ��
		 */
		this.tblMain.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		/*
		 * �����·����
		 */
		KDTableHelper.downArrowAutoAddRow(tblMain, false, null);
		/*
		 * ���س�
		 */
		KDTableHelper.updateEnterWithTab(tblMain, false);
		
		/*
		 * �����β˵����ƶ��˵��İ�ť����Ϊ�����Ҳ�����
		 */
		this.actionGroupMoveTree.setVisible(false);
		this.actionGroupMoveTree.setEnabled(false);
    }
    
    public void onShow() throws Exception {
    	super.onShow();
    }
    
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
//    	super.actionCancel_actionPerformed(e);
    	checkSelected();
    	if(MsgBox.showConfirm2("ȷ�Ͻ�����ѡ���ݣ�")==2){
    		return;
    	}
        ArrayList list = this.getSelectedIdValues();
        for (int i = 0; i < list.size(); i++) {
			String id = list.get(i).toString();
			DesignAuditIndexInfo info = DesignAuditIndexFactory.getRemoteInstance().getDesignAuditIndexInfo(new ObjectUuidPK(id));
			info.setIsEnable(false);
			DesignAuditIndexFactory.getRemoteInstance().update(new ObjectUuidPK(info.getId()), info);
		}
        this.refresh(e);
    }
    
    public void actionCancelCancel_actionPerformed(ActionEvent e)
    		throws Exception {
    	checkSelected();
//    	super.actionCancelCancel_actionPerformed(e);
    	if(MsgBox.showConfirm2("ȷ��������ѡ���ݣ�")==2){
    		return;
    	}
        ArrayList list = this.getSelectedIdValues();
        for (int i = 0; i < list.size(); i++) {
			String id = list.get(i).toString();
			DesignAuditIndexInfo info = DesignAuditIndexFactory.getRemoteInstance().getDesignAuditIndexInfo(new ObjectUuidPK(id));
			info.setIsEnable(true);
			DesignAuditIndexFactory.getRemoteInstance().update(new ObjectUuidPK(info.getId()), info);
		}
        this.refresh(e);
    }
    
    /**
     * output tblMain_tableClicked method
     */
    protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        super.tblMain_tableClicked(e);
    }

    /**
     * output tblMain_tableSelectChanged method
     */
    protected void tblMain_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
    {
        super.tblMain_tableSelectChanged(e);
        checkSelected();
    	this.actionCancel.setEnabled(false);
		this.actionCancelCancel.setEnabled(false);
		this.actionRemove.setEnabled(false);
		this.actionEdit.setEnabled(false);
    	String id = this.getSelectedKeyValue();
    	DesignAuditIndexInfo info = DesignAuditIndexFactory.getRemoteInstance().getDesignAuditIndexInfo(new ObjectUuidPK(id));
    	if(info.isIsEnable()){
    		this.actionCancel.setEnabled(true);
    	}else{
    		this.actionCancelCancel.setEnabled(true);
    		this.actionRemove.setEnabled(true);
    		this.actionEdit.setEnabled(true);
    	}
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexFactory.getRemoteInstance();
    }

    /**
     * output getTreeInterface method
     */
    protected ITreeBase getTreeInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexTreeFactory.getRemoteInstance();
    }

    /**
     * output getGroupEditUIName method
     */
    protected String getGroupEditUIName()
    {
        return com.kingdee.eas.fdc.invite.designsupplier.designbase.client.DesignAuditIndexTreeEditUI.class.getName();
    }

    /**
     * output getQueryFieldName method
     */
    protected String getQueryFieldName()
    {
        return "treeid.id";
    }

    /**
     * output getKeyFieldName method
     */
    protected String getKeyFieldName()
    {
        return "id";
    }

    /**
     * output getRootName method
     */
    protected String getRootName()
    {
        return "��Ӧ������ָ��";
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexInfo();
		
        return objectValue;
    }

}