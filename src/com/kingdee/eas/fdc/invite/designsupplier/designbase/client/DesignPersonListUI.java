/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.designbase.client;

import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.swing.tree.DefaultKingdeeTreeNode;
import com.kingdee.bos.ctrl.swing.tree.KingdeeTreeModel;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.fdc.basecrm.CRMHelper;
import com.kingdee.eas.fdc.basedata.FDCDataBaseInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesSupplierFileTypeCollection;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesSupplierFileTypeFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesSupplierFileTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignPersonInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.tree.KDTreeNode;

/**
 * output class name
 */
public class DesignPersonListUI extends AbstractDesignPersonListUI
{
    private static final Logger logger = CoreUIObject.getLogger(DesignPersonListUI.class);
    private DesSupplierFileTypeInfo supplierFileType=null;
    /**
     * output class constructor
     */
    public DesignPersonListUI() throws Exception
    {
        super();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignPersonFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignPersonInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignPersonInfo();
		
        return objectValue;
    }

    protected void initTree() throws Exception {
		KDTreeNode root = new KDTreeNode("µµ∞∏∑÷¿‡");
		KingdeeTreeModel mode=new KingdeeTreeModel(root);
		FilterInfo filter = new FilterInfo();
		EntityViewInfo view=new EntityViewInfo();
		filter.getFilterItems().add(new FilterItemInfo("isEnabled", Boolean.TRUE));	
		view.setFilter(filter);
		DesSupplierFileTypeCollection col=DesSupplierFileTypeFactory.getRemoteInstance().getDesSupplierFileTypeCollection(view);
		CRMHelper.sortCollection(col, "number", true);
		for(int i=0;i<col.size();i++){
			KDTreeNode child = new KDTreeNode(col.get(i).getName());
			child.setUserObject(col.get(i));
			root.add(child);
		}
		mode.setRoot(root);
		this.treeMain.setModel(mode);
	}
    protected boolean isIgnoreCUFilter() {
		return true;
	}
    protected void refresh(ActionEvent e) throws Exception {
		this.tblMain.removeRows();
	}
    protected void prepareUIContext(UIContext uiContext, ActionEvent e) {
		super.prepareUIContext(uiContext, e);
		uiContext.put("supplierFileType", supplierFileType);
	}
	public void onLoad() throws Exception {
		initTree();
		super.onLoad();
		this.treeMain.setSelectionRow(0);
	}
    protected void treeMain_valueChanged(javax.swing.event.TreeSelectionEvent e) throws Exception {
		DefaultKingdeeTreeNode node = (DefaultKingdeeTreeNode) treeMain.getLastSelectedPathComponent();
		if (node == null) {
			return;
		}
		if(node!=null&&node.getUserObject() instanceof DesSupplierFileTypeInfo){
			supplierFileType=(DesSupplierFileTypeInfo)node.getUserObject();
			this.actionAddNew.setEnabled(true);
		}else{
			supplierFileType=null;
			this.actionAddNew.setEnabled(false);
		}
		this.execQuery();
	}
    protected IQueryExecutor getQueryExecutor(IMetaDataPK queryPK, EntityViewInfo viewInfo) {
		DefaultKingdeeTreeNode node = (DefaultKingdeeTreeNode) treeMain.getLastSelectedPathComponent();
		try {
			FilterInfo filter = new FilterInfo();
			if(node!=null&&node.getUserObject() instanceof DesSupplierFileTypeInfo){
				filter.getFilterItems().add(new FilterItemInfo("supplierFileType.id", supplierFileType.getId().toString()));	
			}
			viewInfo = (EntityViewInfo) this.mainQuery.clone();
			if (viewInfo.getFilter() != null)
			{
				viewInfo.getFilter().mergeFilter(filter, "and");
			} else
			{
				viewInfo.setFilter(filter);
			}
		} catch (BOSException e) {
			handleException(e);
		}
		return super.getQueryExecutor(queryPK, viewInfo);
	}

	protected FDCDataBaseInfo getBaseDataInfo() {
		return new DesignPersonInfo();
	}


}