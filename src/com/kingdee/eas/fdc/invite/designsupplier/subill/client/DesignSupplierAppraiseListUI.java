/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.subill.client;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.TreeModel;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemCollection;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.KDTDataRequestManager;
import com.kingdee.bos.ctrl.swing.KDTree;
import com.kingdee.bos.ctrl.swing.tree.DefaultKingdeeTreeNode;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.uiframe.client.UIFactoryHelper;
import com.kingdee.eas.basedata.org.FullOrgUnitFactory;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.basedata.org.NewOrgUtils;
import com.kingdee.eas.basedata.org.OrgStructureInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgViewType;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitFactory;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.fdc.basedata.FDCHelper;
import com.kingdee.eas.fdc.basedata.client.FDCClientHelper;
import com.kingdee.eas.fdc.basedata.client.FDCClientUtils;
import com.kingdee.eas.fdc.basedata.client.FDCMsgBox;
import com.kingdee.eas.fdc.invite.InviteTypeFactory;
import com.kingdee.eas.fdc.invite.InviteTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseFactory;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo;
import com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraise;
import com.kingdee.eas.fdc.invite.designsupplier.uitls.WorkFlow;
import com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.ma.budget.client.LongTimeDialog;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class DesignSupplierAppraiseListUI extends AbstractDesignSupplierAppraiseListUI
{
    private static final Logger logger = CoreUIObject.getLogger(DesignSupplierAppraiseListUI.class);
    
    /**
     * output class constructor
     */
    public DesignSupplierAppraiseListUI() throws Exception
    {
        super();
    }

    protected void prepareUIContext(UIContext uiContext, ActionEvent e) {
		super.prepareUIContext(uiContext, e);
		DefaultKingdeeTreeNode TypeNode = this.getSelectedTreeNode(supplierTypeTree);
    	DefaultKingdeeTreeNode OrgNode = this.getSelectedTreeNode(orgTree);
		if(TypeNode!=null&&TypeNode.getUserObject()!=null){
			if(TypeNode.getUserObject() instanceof InviteTypeInfo&&((InviteTypeInfo) TypeNode.getUserObject()).isIsLeaf()){
				uiContext.put("type", TypeNode.getUserObject());
			}else{
				uiContext.put("type", null);
			}
		}
		if(OrgNode!=null&&OrgNode.getUserObject()!=null){
			if(OrgNode.getUserObject() instanceof OrgStructureInfo){
				uiContext.put("org", OrgNode.getUserObject());
			}else{
				MsgBox.showWarning("请先选择左边事业部！");SysUtil.abort();
				uiContext.put("org", null);
			}
		}
	}
    protected DefaultKingdeeTreeNode getSelectedTreeNode(KDTree selectTree) {
		if (selectTree.getLastSelectedPathComponent() != null) {
			DefaultKingdeeTreeNode treeNode = (DefaultKingdeeTreeNode) selectTree.getLastSelectedPathComponent();
			return treeNode;
		}
		return null;
	}
    
    
    
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	List idList = this.getSelectedIdValues();
    	for (int i = 0; i < idList.size(); i++) {
    		WorkFlow.checkBillInWorkflow(this, idList.get(i).toString());
    		DesignSupplierAppraiseInfo info = DesignSupplierAppraiseFactory.getRemoteInstance().getDesignSupplierAppraiseInfo(new ObjectUuidPK(idList.get(i).toString()));
			if(info.getState().getValue() > 2 ){
				FDCMsgBox.showWarning(this,getResource("notEdit"));
	    		return;
			}
		}
        super.actionEdit_actionPerformed(e);
    }
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	List idList = this.getSelectedIdValues();
    	for (int i = 0; i < idList.size(); i++) {
    		WorkFlow.checkBillInWorkflow(this, idList.get(i).toString());
    		DesignSupplierAppraiseInfo info = DesignSupplierAppraiseFactory.getRemoteInstance().getDesignSupplierAppraiseInfo(new ObjectUuidPK(idList.get(i).toString()));
			if(info.getState().getValue() > 2 ){
				FDCMsgBox.showWarning(this,getResource("notRemove"));
				SysUtil.abort();
			}
		}
        super.actionRemove_actionPerformed(e);
    }
    
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
    	checkSelected();
    	WorkFlow.checkBillInWorkflow(this, this.getSelectedKeyValue());
    	IDesignSupplierAppraise IEval = (IDesignSupplierAppraise)getBizInterface();
    	DesignSupplierAppraiseInfo info = IEval.getDesignSupplierAppraiseInfo(new ObjectUuidPK(this.getSelectedKeyValue()));
    	if(!info.getState().equals(SupplierStateEnum.YEATAUDIT)){
    		FDCMsgBox.showWarning(this,"当前所选单据状态为["+info.getState().getAlias()+"],不能反审批！");SysUtil.abort();
    	}
    	super.actionUnAudit_actionPerformed(e);
    	FDCMsgBox.showWarning(this,"反审批成功！");
    	refresh(e);
    }
    
    
    /*
     * (non-Javadoc)
     * @see com.kingdee.eas.fdc.invite.designsupplier.subill.client.AbstractDesignSupplierAppraiseListUI#actionAudit_actionPerformed(java.awt.event.ActionEvent)
     * 审核
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
    	checkSelected();
    	WorkFlow.checkBillInWorkflow(this, this.getSelectedKeyValue());
    	IDesignSupplierAppraise IEval = (IDesignSupplierAppraise)getBizInterface();
    	DesignSupplierAppraiseInfo info = IEval.getDesignSupplierAppraiseInfo(new ObjectUuidPK(this.getSelectedKeyValue()));
    	if(!info.getState().equals(SupplierStateEnum.SUBMIT)){
    		FDCMsgBox.showWarning(this,"当前所选单据状态为["+info.getState().getAlias()+"],不能审批！");SysUtil.abort();
    	}
    	super.actionAudit_actionPerformed(e);
    	FDCMsgBox.showWarning(this,"审批成功！");
    	refresh(e);
    }
    
    public void onLoad() throws Exception {
		super.onLoad();
		this.tblMain.getDataRequestManager().setDataRequestMode(KDTDataRequestManager.REAL_MODE);
		FDCClientHelper.addSqlMenu(this, this.menuEdit);
		buildOrgTree();
		buildInviteTypeTree();
		this.actionAddNew.setVisible(true);
		this.actionView.setVisible(true);
		this.actionEdit.setVisible(true);
		this.actionRemove.setVisible(true);
		this.actionAudit.setEnabled(true);
		this.actionUnAudit.setEnabled(true);
		this.actionMultiSubmit.setEnabled(true);
		this.actionPrint.setVisible(false);//打印
    	this.actionPrintPreview.setVisible(false);//打印预览
		this.actionCreateTo.setVisible(false);//推式生成
		this.actionTraceUp.setVisible(false);//上查
		this.actionTraceDown.setVisible(false);//下查 
		
		this.btnMultiSubmit.setIcon(EASResource.getIcon("imgTbtn_submit"));
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		this.kDSplitPane2.setDividerLocation(250);
		if(!SysContext.getSysContext().getCurrentOrgUnit().isIsPurchaseOrgUnit()){
			this.actionAddNew.setEnabled(false);
			this.actionEdit.setEnabled(false);
			this.actionRemove.setEnabled(false);
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
			this.actionMultiSubmit.setEnabled(false);
		}
		this.actionAttachment.setVisible(true);
		if(this.getUIContext().get("IDSET")!=null){
			kDSplitPane1.setDividerLocation(0);
			this.kDSupplierCont.setTitle("供应商选用");
		}
	}
    protected String getEditUIModal() {
		return UIFactoryName.NEWTAB;
	}
    
    public void onShow() throws Exception {
		super.onShow();
		this.actionCancel.setVisible(false);
		this.actionCancelCancel.setVisible(false);
		this.btnCancel.setVisible(false);
		this.btnCancelCancel.setVisible(false);
	}
    
    
	protected void buildInviteTypeTree() throws Exception {
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("isEnabled", Boolean.TRUE));
		filter.getFilterItems().add(new FilterItemInfo("longNumber","7%",CompareType.LIKE));
		TreeModel model = FDCClientHelper.createDataTree(InviteTypeFactory.getRemoteInstance(), filter, "设计类别");
		this.supplierTypeTree.setModel(model);
		this.supplierTypeTree.setSelectionRow(0);
	}
	/**
	 * 采购类别树
	 */
	protected void supplierTypeTree_valueChanged(TreeSelectionEvent e)
			throws Exception {
		super.supplierTypeTree_valueChanged(e);
		DefaultKingdeeTreeNode TypeNode = this.getSelectedTreeNode(supplierTypeTree);
    	if(TypeNode != null && TypeNode.getUserObject() != null){
    		//设置容器的title
    		kDSupplierCont.setTitle(TypeNode.getText());
    	}
    	this.refresh(null);
	}
	protected void buildOrgTree() throws Exception{
		OrgUnitInfo cuInfo = SysContext.getSysContext().getCurrentOrgUnit();
		if (!cuInfo.isIsPurchaseOrgUnit()) {
			MsgBox.showInfo(this, "非采购组织不能操作");
			SysUtil.abort();
		}
		TreeModel orgTreeModel = NewOrgUtils.getTreeModel(OrgViewType.PURCHASE,"", cuInfo.getId().toString(), null, FDCHelper.getActionPK(this.actionOnLoad));
		this.orgTree.setModel(orgTreeModel);
		this.orgTree.setSelectionRow(0);
	}
	protected void refresh(ActionEvent e) throws Exception{
		this.tblMain.removeRows();
	}
	/**
	 * 组织树
	 */
	protected void orgTree_valueChanged(TreeSelectionEvent e) throws Exception {
		super.orgTree_valueChanged(e);
		this.refresh(null);
	}
	private FilterInfo getTreeFilter() throws Exception {
		FilterInfo filter = new FilterInfo();
    	FilterItemCollection filterItems = filter.getFilterItems();
    	DefaultKingdeeTreeNode TypeNode = this.getSelectedTreeNode(supplierTypeTree);//供应商类型树
    	DefaultKingdeeTreeNode orgNode = this.getSelectedTreeNode(orgTree);//组织树
    	Object TypeInfo = null;
    	String orgName = null;
    	//是否选中
    	if(TypeNode != null && TypeNode.getUserObject() != null){
    		TypeInfo = TypeNode.getUserObject();
    	}
    	if (TypeInfo instanceof InviteTypeInfo) {
		    String longNumber = ((InviteTypeInfo)TypeInfo).getLongNumber();
			filterItems.add(new FilterItemInfo("InvTyep.longNumber", longNumber+"%",CompareType.LIKE));
		}
    	if(orgNode.getUserObject() instanceof OrgStructureInfo){
    		SelectorItemCollection sel=new SelectorItemCollection();
    		sel.add("longNumber");
    		PurchaseOrgUnitInfo org=PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(((OrgStructureInfo)orgNode.getUserObject()).getUnit().getId()),sel);
    		String longNumber=org.getLongNumber();
    		filterItems.add(new FilterItemInfo("PusOrg.longNumber", longNumber+"%",CompareType.LIKE));
    	}
    	return filter;
	}
	
    protected boolean isIgnoreCUFilter() {
		return true;
	}

	protected IQueryExecutor getQueryExecutor(IMetaDataPK queryPK,EntityViewInfo viewInfo) {
		try {
			FilterInfo filter = new FilterInfo();
			if(this.getUIContext().get("IDSET")!=null){
				filter.getFilterItems().add(new FilterItemInfo("id", (Set)this.getUIContext().get("IDSET"),CompareType.INCLUDE));
			}else{
				filter = getTreeFilter();
				if(filter==null){
					filter = new FilterInfo();
				}
			}
			viewInfo = (EntityViewInfo) this.mainQuery.clone();
			if (viewInfo.getFilter() != null)
			{
				viewInfo.getFilter().mergeFilter(filter, "and");
				
			} else
			{
				viewInfo.setFilter(filter);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		this.tblMain.getColumn("Org.name").getStyleAttributes().setHided(true);
		return super.getQueryExecutor(queryPK, viewInfo);
	}
	/**
	 * 批量提交
	 * @param e
	 * @throws Exception
	 */
	public void actionMultiSubmit_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();
		Window win = SwingUtilities.getWindowAncestor(this);
		LongTimeDialog dialog = null;
		if(win instanceof Frame)
			dialog = new LongTimeDialog((Frame)win);
		else
			if(win instanceof Dialog)
				dialog = new LongTimeDialog((Dialog)win);
		dialog.setLongTimeTask(new ILongTimeTask() {
			public Object exec()throws Exception{
				ArrayList id = getSelectedIdValues();
				for(int i = 0; i < id.size(); i++){
					WorkFlow.checkBillInWorkflow(null, id.get(i).toString());
					UIContext uiContext = new UIContext(this);
    			    uiContext.put("ID", id.get(i).toString());
    			    DesignSupplierAppraiseEditUI ui=(DesignSupplierAppraiseEditUI) UIFactoryHelper.initUIObject(DesignSupplierAppraiseEditUI.class.getName(), uiContext, null,OprtState.EDIT);
    			    SupplierStateEnum state = DesignSupplierAppraiseFactory.getRemoteInstance().getDesignSupplierAppraiseInfo(new ObjectUuidPK(((DesignSupplierAppraiseInfo)ui.getEditData()).getId())).getState();
    			    FDCClientUtils.checkBillInWorkflow(ui, ui.getEditData().getId().toString());
    			    
    			    if(state==null||!(SupplierStateEnum.SAVE.equals(state)||SupplierStateEnum.SUBMIT.equals(state))){
    			    	MsgBox.showWarning("不是保存或者提交状态，不能进行提交操作！");
    					SysUtil.abort();
    			    }
    			    ui.verifyInputForSubmit();
    			    ui.runSubmit();
    			    ui.destroyWindow();
    		    }
                return new Boolean(true);
            }
            public void afterExec(Object result)throws Exception{
            	FDCMsgBox.showWarning("操作成功！");
            }
       }
	);
		dialog.show();
		this.refresh(null);
	}

	private String getResource(String msg) {
		return EASResource.getString("com.kingdee.eas.fdc.invite.supplier.SupplierResource", msg);
	}

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo();
		
        return objectValue;
    }

}