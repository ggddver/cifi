/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.demotion.client;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Set;

import javax.swing.tree.TreeModel;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.KDTDataRequestManager;
import com.kingdee.bos.ctrl.swing.KDTree;
import com.kingdee.bos.ctrl.swing.tree.DefaultKingdeeTreeNode;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemCollection;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.NewOrgUtils;
import com.kingdee.eas.basedata.org.OrgStructureInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgViewType;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitFactory;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.fdc.basedata.FDCHelper;
import com.kingdee.eas.fdc.basedata.client.FDCClientHelper;
import com.kingdee.eas.fdc.basedata.client.FDCMsgBox;
import com.kingdee.eas.fdc.invite.InviteTypeFactory;
import com.kingdee.eas.fdc.invite.InviteTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionCollection;
import com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionFactory;
import com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionInfo;
import com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotion;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationCollection;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationFactory;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationInfo;
import com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraise;
import com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluation;
import com.kingdee.eas.fdc.invite.designsupplier.uitls.WorkFlow;
import com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 * 供应商升降级列表界面
 */
public class DemotionListUI extends AbstractDemotionListUI
{
    private static final Logger logger = CoreUIObject.getLogger(DemotionListUI.class);
    
    /**
     * output class constructor
     */
    public DemotionListUI() throws Exception
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
    }

    /**
     * output menuItemImportData_actionPerformed method
     */
    protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemImportData_actionPerformed(e);
    }
    /*
     * 创建组织类型树
     */
    protected void buildOrgTree() throws Exception{
		OrgUnitInfo cuInfo = SysContext.getSysContext().getCurrentOrgUnit();//获得当前组织单元
		if (!cuInfo.isIsPurchaseOrgUnit()) {
			MsgBox.showInfo(this, "非采购组织不能操作");
			SysUtil.abort();
		}
		TreeModel orgTreeModel = NewOrgUtils.getTreeModel(OrgViewType.PURCHASE,"", cuInfo.getId().toString(), null, FDCHelper.getActionPK(this.actionOnLoad));
		this.orgTree.setModel(orgTreeModel);
		this.orgTree.setSelectionRow(0);
	}
    /*
     * 创建设计类型树
     */
	protected void buildInviteTypeTree() throws Exception {
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("isEnabled", Boolean.TRUE));
		filter.getFilterItems().add(new FilterItemInfo("longNumber","7%",CompareType.LIKE));
		TreeModel model = FDCClientHelper.createDataTree(InviteTypeFactory.getRemoteInstance(), filter, "设计类别");
		this.supplierTypeTree.setModel(model);
		this.supplierTypeTree.setSelectionRow(0);
	}
    
    protected void refresh(ActionEvent e) throws Exception{
		this.tblMain.removeRows();
	}

    /**
     * output orgTree_valueChanged method
     * 组织树
     */
    protected void orgTree_valueChanged(javax.swing.event.TreeSelectionEvent e) throws Exception
    {
        super.orgTree_valueChanged(e);
        this.refresh(null);
    }

    /**
     * output supplierTypeTree_valueChanged method
     * 供应商类别树
     */
    protected void supplierTypeTree_valueChanged(javax.swing.event.TreeSelectionEvent e) throws Exception
    {
    	super.supplierTypeTree_valueChanged(e);
		DefaultKingdeeTreeNode TypeNode = this.getSelectedTreeNode(supplierTypeTree); //获得供应商类别树形控件的节点
    	if(TypeNode != null && TypeNode.getUserObject() != null){
    		//设置容器的title
    		kDSupplierCont.setTitle(TypeNode.getText());//设置右边容器的title
    		
    	}
    	this.refresh(null);
    }
    
      //获得树形控件的节点
    protected DefaultKingdeeTreeNode getSelectedTreeNode(KDTree selectTree) {
		if (selectTree.getLastSelectedPathComponent() != null) {
			DefaultKingdeeTreeNode treeNode = (DefaultKingdeeTreeNode) selectTree.getLastSelectedPathComponent();
			return treeNode;
		}
		return null;
	}
    
    
    private FilterInfo getTreeFilter() throws Exception {
		FilterInfo filter = new FilterInfo();
    	FilterItemCollection filterItems = filter.getFilterItems();
    	DefaultKingdeeTreeNode TypeNode = this.getSelectedTreeNode(supplierTypeTree);//获得选中的供应商类型树节点
    	DefaultKingdeeTreeNode orgNode = this.getSelectedTreeNode(orgTree);//获得选中的所属事业部组织树节点
    	
    	//com.kingdee.eas.util.client.MsgBox.showWarning("选中的树形控件的节点是："+orgNode);
    	Object TypeInfo = null;
    	String orgName = null;
    	//是否选中
    	if(TypeNode != null && TypeNode.getUserObject() != null){
    		TypeInfo = TypeNode.getUserObject();//选中的供应商树节点对象
    	}
    	if (TypeInfo instanceof InviteTypeInfo) {
		    String longNumber = ((InviteTypeInfo)TypeInfo).getLongNumber();//根据设计类别
			filterItems.add(new FilterItemInfo("InvTyep.longNumber", longNumber+"%",CompareType.LIKE));//根据设计类别节点编码进行过滤查询
			
		}
    	if(orgNode.getUserObject() instanceof OrgStructureInfo){
    		SelectorItemCollection sel=new SelectorItemCollection();
    		sel.add("longNumber");
    		PurchaseOrgUnitInfo org=PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(((OrgStructureInfo)orgNode.getUserObject()).getUnit().getId()),sel);
    		String longNumber=org.getLongNumber();//根据所属事业部过滤
    		filterItems.add(new FilterItemInfo("PusOrg.longNumber", longNumber+"%",CompareType.LIKE));
    	}
    	return filter;
	}
    
    
    //根据选中的节点进行过滤
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
		this.tblMain.getColumn("Org.name").getStyleAttributes().setHided(false);//显示所属事业部
		return super.getQueryExecutor(queryPK, viewInfo);
	}
 
    
    
    /*
     * (non-Javadoc)
     * @see com.kingdee.eas.framework.client.CoreBillListUI#onLoad()
     * 页面加载的方法
     */
    public void onLoad() throws Exception {
		super.onLoad();
		this.tblMain.getDataRequestManager().setDataRequestMode(KDTDataRequestManager.REAL_MODE);
		FDCClientHelper.addSqlMenu(this, this.menuEdit);
		buildOrgTree();
		buildInviteTypeTree();
		this.kDSplitPane2.setDividerLocation(250);
		this.actionAddNew.setVisible(true);
		this.actionView.setVisible(true);
		this.actionEdit.setVisible(true);
		this.actionRemove.setVisible(true);
		this.actionAudit.setEnabled(true);//审核
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
			this.kDSupplierCont.setTitle("供应商升降级");
		}
	}
    
    
  
	
	/*
	 * (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.CoreBillListUI#prepareUIContext(com.kingdee.eas.common.client.UIContext, java.awt.event.ActionEvent)
	 * 把选中的节点在节点对象中是否存在
	 */
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
	 
	 



    /**
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }

    /**
     * output actionExitCurrent_actionPerformed
     */
    public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExitCurrent_actionPerformed(e);
    }

    /**
     * output actionHelp_actionPerformed
     */
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHelp_actionPerformed(e);
    }

    /**
     * output actionAbout_actionPerformed
     */
    public void actionAbout_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAbout_actionPerformed(e);
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

    /**
     * output actionSendMessage_actionPerformed
     */
    public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMessage_actionPerformed(e);
    }

    /**
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }

    /**
     * output actionExport_actionPerformed
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }

    /**
     * output actionExportSelected_actionPerformed
     */
    public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelected_actionPerformed(e);
    }

    /**
     * output actionRegProduct_actionPerformed
     */
    public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRegProduct_actionPerformed(e);
    }

    /**
     * output actionPersonalSite_actionPerformed
     */
    public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPersonalSite_actionPerformed(e);
    }

    /**
     * output actionProcductVal_actionPerformed
     */
    public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionProcductVal_actionPerformed(e);
    }

    /**
     * output actionExportSave_actionPerformed
     */
    public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSave_actionPerformed(e);
    }

    /**
     * output actionExportSelectedSave_actionPerformed
     */
    public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelectedSave_actionPerformed(e);
    }

    /**
     * output actionKnowStore_actionPerformed
     */
    public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionKnowStore_actionPerformed(e);
    }

    /**
     * output actionAnswer_actionPerformed
     */
    public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAnswer_actionPerformed(e);
    }

    /**
     * output actionRemoteAssist_actionPerformed
     */
    public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoteAssist_actionPerformed(e);
    }

    /**
     * output actionPopupCopy_actionPerformed
     */
    public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupCopy_actionPerformed(e);
    }

    /**
     * output actionHTMLForMail_actionPerformed
     */
    public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForMail_actionPerformed(e);
    }

    /**
     * output actionExcelForMail_actionPerformed
     */
    public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForMail_actionPerformed(e);
    }

    /**
     * output actionHTMLForRpt_actionPerformed
     */
    public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForRpt_actionPerformed(e);
    }

    /**
     * output actionExcelForRpt_actionPerformed
     */
    public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForRpt_actionPerformed(e);
    }

    /**
     * output actionLinkForRpt_actionPerformed
     */
    public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLinkForRpt_actionPerformed(e);
    }

    /**
     * output actionPopupPaste_actionPerformed
     */
    public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupPaste_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }

    /**
     * output actionView_actionPerformed
     */
    public void actionView_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionView_actionPerformed(e);
    }

    /**
     * output actionEdit_actionPerformed
     * 列表界面不能修改
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	List idList = this.getSelectedIdValues();
    	for (int i = 0; i < idList.size(); i++) {
    		WorkFlow.checkBillInWorkflow(this, idList.get(i).toString());
    		DemotionInfo info = DemotionFactory.getRemoteInstance().getDemotionInfo(new ObjectUuidPK(idList.get(i).toString()));
    		
			if(info.getState().getValue() > 2 ){
				FDCMsgBox.showWarning(this,getResource("notEdit"));
	    		return;
			}
		 	
			//com.kingdee.eas.util.client.MsgBox.showWarning("当前的单据状态是"+info.getState());
		}
   
        super.actionEdit_actionPerformed(e);
    }
    
	private String getResource(String msg) {
		return EASResource.getString("com.kingdee.eas.fdc.invite.supplier.SupplierResource", msg);
	}

    /**
     * output actionRemove_actionPerformed
     * 删除
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	List idList = this.getSelectedIdValues();
    	for (int i = 0; i < idList.size(); i++) {
    		WorkFlow.checkBillInWorkflow(this, idList.get(i).toString());
    		DemotionInfo info = DemotionFactory.getRemoteInstance().getDemotionInfo(new ObjectUuidPK(idList.get(i).toString()));
			if(info.getState().getValue() > 2 ){
				FDCMsgBox.showWarning(this,getResource("notRemove"));
				SysUtil.abort();
			}
		}
        super.actionRemove_actionPerformed(e);
    }

    /**
     * output actionRefresh_actionPerformed
     */
    public void actionRefresh_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRefresh_actionPerformed(e);
    }

    /**
     * output actionPrint_actionPerformed
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrint_actionPerformed(e);
    }

    /**
     * output actionPrintPreview_actionPerformed
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrintPreview_actionPerformed(e);
    }

    /**
     * output actionLocate_actionPerformed
     */
    public void actionLocate_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLocate_actionPerformed(e);
    }

    /**
     * output actionQuery_actionPerformed
     */
    public void actionQuery_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionQuery_actionPerformed(e);
    }

    /**
     * output actionImportData_actionPerformed
     */
    public void actionImportData_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionImportData_actionPerformed(e);
    }

    /**
     * output actionAttachment_actionPerformed
     */
    public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAttachment_actionPerformed(e);
    }

    /**
     * output actionExportData_actionPerformed
     */
    public void actionExportData_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportData_actionPerformed(e);
    }

    /**
     * output actionToExcel_actionPerformed
     */
    public void actionToExcel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToExcel_actionPerformed(e);
    }

    /**
     * output actionStartWorkFlow_actionPerformed
     */
    public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionStartWorkFlow_actionPerformed(e);
    }

    /**
     * output actionPublishReport_actionPerformed
     */
    public void actionPublishReport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPublishReport_actionPerformed(e);
    }

    /**
     * output actionCancel_actionPerformed
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
    }

    /**
     * output actionCancelCancel_actionPerformed
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancelCancel_actionPerformed(e);
    }

    /**
     * output actionQueryScheme_actionPerformed
     */
    public void actionQueryScheme_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionQueryScheme_actionPerformed(e);
    }

    /**
     * output actionCreateTo_actionPerformed
     */
    public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateTo_actionPerformed(e);
    }

    /**
     * output actionCopyTo_actionPerformed
     */
    public void actionCopyTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyTo_actionPerformed(e);
    }

    /**
     * output actionTraceUp_actionPerformed
     */
    public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceUp_actionPerformed(e);
    }

    /**
     * output actionTraceDown_actionPerformed
     */
    public void actionTraceDown_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceDown_actionPerformed(e);
    }

    /**
     * output actionVoucher_actionPerformed
     */
    public void actionVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionVoucher_actionPerformed(e);
    }

    /**
     * output actionDelVoucher_actionPerformed
     */
    public void actionDelVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionDelVoucher_actionPerformed(e);
    }

    /**
     * output actionAuditResult_actionPerformed
     */
    public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAuditResult_actionPerformed(e);
    }

    /**
     * output actionViewDoProccess_actionPerformed
     */
    public void actionViewDoProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewDoProccess_actionPerformed(e);
    }

    /**
     * output actionMultiapprove_actionPerformed
     */
    public void actionMultiapprove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMultiapprove_actionPerformed(e);
    }

    /**
     * output actionNextPerson_actionPerformed
     */
    public void actionNextPerson_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNextPerson_actionPerformed(e);
    }

    /**
     * output actionWorkFlowG_actionPerformed
     */
    public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkFlowG_actionPerformed(e);
    }

    /**
     * output actionSendSmsMessage_actionPerformed
     */
    public void actionSendSmsMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendSmsMessage_actionPerformed(e);
    }

    /**
     * output actionSignature_actionPerformed
     */
    public void actionSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSignature_actionPerformed(e);
    }

    /**
     * output actionWorkflowList_actionPerformed
     */
    public void actionWorkflowList_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkflowList_actionPerformed(e);
    }

    /**
     * output actoinViewSignature_actionPerformed
     */
    public void actoinViewSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actoinViewSignature_actionPerformed(e);
    }

    /**
     * output actionTDPrint_actionPerformed
     */
    public void actionTDPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTDPrint_actionPerformed(e);
    }

    /**
     * output actionTDPrintPreview_actionPerformed
     */
    public void actionTDPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTDPrintPreview_actionPerformed(e);
    }
    


    /**
     * output actionAudit_actionPerformed
     * 审核
     */
 
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	
    	checkSelected();
    	WorkFlow.checkBillInWorkflow(this, this.getSelectedKeyValue());
    	
    	IDemotion IEval = (IDemotion)getBizInterface();//获得接口
    	DemotionInfo info = IEval.getDemotionInfo(new ObjectUuidPK(this.getSelectedKeyValue()));
    	//如果当前单据状态是已审批不能做审批操作
    	if(!info.getState().equals(SupplierStateEnum.SUBMIT)){
    		FDCMsgBox.showWarning(this,"当前所选单据状态为["+info.getState().getAlias()+"],不能审批！");SysUtil.abort();
    	}
    	super.actionAudit_actionPerformed(e);
    	FDCMsgBox.showWarning(this,"审批成功！");
    	refresh(e);
    }

    /**
     * output actionUnAudit_actionPerformed
     * 反审核
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
       	checkSelected();
    	WorkFlow.checkBillInWorkflow(this, this.getSelectedKeyValue());
    	IDemotion IEval = (IDemotion)getBizInterface();//获得接口
    	DemotionInfo info = IEval.getDemotionInfo(new ObjectUuidPK(this.getSelectedKeyValue()));
    	DesignGradeSetUpInfo deGradeInfo = DesignGradeSetUpFactory.getRemoteInstance().getDesignGradeSetUpInfo(new ObjectUuidPK(info.getSupplierlastClas().getId()));
//    	if(!"00000000-0000-0000-0000-000000000000CCE7AED4".equals(info.getOrg().getId().toString())){
//			int valueNmber = Integer.parseInt(deGradeInfo.getNumber());
//			String oql = "select * where supplierNumber.id='"+info.getSupplierNumber().getId().toString()+"' and id <>'"+this.getSelectedKeyValue()+"'";
//			boolean flse = false;
//			DemotionCollection Coll = DemotionFactory.getRemoteInstance().getDemotionCollection(oql);
//			for (int i = 0; i < Coll.size(); i++) {
//				int Number = Integer.parseInt(DesignGradeSetUpFactory.getRemoteInstance().getDesignGradeSetUpInfo(new ObjectUuidPK(Coll.get(i).getSupplierlastClas().getId())).getNumber());
//				if(valueNmber<Number){
//					flse = true;break;
//				}
//			}
//			if(flse){
//				String number = "00"+String.valueOf(valueNmber+1);
//				String Name = DesignGradeSetUpFactory.getRemoteInstance().getDesignGradeSetUpInfo("where number='"+number+"' and isEnabled='1'").getName();
//				MsgBox.showWarning("当前供应商已做["+Name+"]评定，请先删除["+Name+"]评定！");SysUtil.abort();
//			}
//		}
    	
    	if(!info.getState().equals(SupplierStateEnum.YEATAUDIT)){
    		FDCMsgBox.showWarning(this,"当前所选单据状态为["+info.getState().getAlias()+"],不能反审批！");SysUtil.abort();
    	}
    	super.actionUnAudit_actionPerformed(e);
    	FDCMsgBox.showWarning(this,"反审批成功！");
    	refresh(e);
    }

    /**
     * output actionMultiSubmit_actionPerformed
     *批量提交
     */
    public void actionMultiSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMultiSubmit_actionPerformed(e);
        
        
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionInfo();
		
        return objectValue;
    }
    
    
    //页面展示隐藏各种
    public void onShow() throws Exception {
		super.onShow();
		this.actionCancel.setVisible(false);
		this.actionCancelCancel.setVisible(false);
		this.btnCancel.setVisible(false);
		this.btnCancelCancel.setVisible(false);
	}

}