/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTMergeManager;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.ctrl.swing.util.CtrlCommonConstant;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.cp.bc.BizCollUtil;
import com.kingdee.eas.fdc.basedata.CurProject;
import com.kingdee.eas.fdc.basedata.CurProjectInfo;
import com.kingdee.eas.fdc.basedata.FDCBillStateEnum;
import com.kingdee.eas.fdc.basedata.FDCSQLBuilder;
import com.kingdee.eas.fdc.basedata.client.ContractTypePromptSelector;
import com.kingdee.eas.fdc.basedata.client.FDCBillEditUI;
import com.kingdee.eas.fdc.basedata.client.FDCClientVerifyHelper;
import com.kingdee.eas.fdc.basedata.client.FDCMsgBox;
import com.kingdee.eas.fdc.basedata.client.FDCTableHelper;
import com.kingdee.eas.fdc.basedata.util.KDDetailedArea;
import com.kingdee.eas.fdc.contract.client.F7ProjectTreeSelectorPromptBox;
import com.kingdee.eas.fdc.contract.programming.ProgrammingContractCollection;
import com.kingdee.eas.fdc.contract.programming.ProgrammingContractInfo;
import com.kingdee.eas.fdc.contract.programming.ProgrammingFactory;
import com.kingdee.eas.fdc.invite.InviteMonthPlanEntrysCollection;
import com.kingdee.eas.fdc.invite.InviteMonthPlanEntrysFactory;
import com.kingdee.eas.fdc.invite.InviteMonthPlanEntrysInfo;
import com.kingdee.eas.fdc.invite.InviteMonthPlanFactory;
import com.kingdee.eas.fdc.invite.InviteProjectEntriesInfo;
import com.kingdee.eas.fdc.invite.InviteProjectFactory;
import com.kingdee.eas.fdc.invite.InviteProjectInfo;
import com.kingdee.eas.fdc.invite.InvitePurchaseModeEnum;
import com.kingdee.eas.fdc.invite.InvitePurchaseModeInfo;
import com.kingdee.eas.fdc.invite.InviteTypeInfo;
import com.kingdee.eas.fdc.invite.PricingModeEnum;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * 招标立项 编辑界面
 */
public class InviteProjectEditUI extends AbstractInviteProjectEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(InviteProjectEditUI.class);
    protected OrgUnitInfo currentOrg = SysContext.getSysContext().getCurrentCostUnit();
    
    public InviteProjectEditUI() throws Exception
    {
        super();
    }
    protected IObjectValue createNewData() {
		InviteProjectInfo info = new InviteProjectInfo();
//		info.setInviteForm(InviteFormEnum.INVITETYPE);
		info.setPaperIsComplete(true);
		info.setScalingRules(true);
		info.setPriceMode(PricingModeEnum.FIXEDPRICEANDUNITPRICE);
		info.setOrgUnit((FullOrgUnitInfo) getUIContext().get("org"));
		info.setInviteType((InviteTypeInfo)(getUIContext().get("type")));
		return info;
	}
    
    public SelectorItemCollection getSelectors() {
    	SelectorItemCollection sel=super.getSelectors();
    	sel.add("orgUnit.*");
    	sel.add("CU.*");
    	sel.add("state");
    	sel.add("paperIsComplete");
    	sel.add("scalingRules");
    	sel.add("entries.*");
    	sel.add("*");
		return sel;
	}
    protected boolean checkCanOperate() {
		boolean flag = false;
		if (editData.getOrgUnit() == null) {
			flag = false;
		}
		String orgId = editData.getOrgUnit() .getId().toString();
		if (currentOrg.getId().toString().equals(orgId)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
	protected void initControl(){
		this.menuTable1.setVisible(false);
		this.btnAddLine.setVisible(false);
		this.btnInsertLine.setVisible(false);
		this.btnRemoveLine.setVisible(false);
		this.actionCreateFrom.setVisible(false);
		this.actionTraceDown.setVisible(false);
		this.actionTraceUp.setVisible(false);
		this.actionCopy.setVisible(false);
		this.actionCopyFrom.setVisible(false);
		
		this.chkMenuItemSubmitAndAddNew.setVisible(false);
		this.chkMenuItemSubmitAndAddNew.setSelected(false);
		this.chkMenuItemSubmitAndPrint.setVisible(false);
		this.chkMenuItemSubmitAndPrint.setSelected(false);
		this.actionPrint.setVisible(true);
		this.actionPrintPreview.setVisible(true);
		this.actionPrint.setEnabled(true);
		this.actionPrintPreview.setEnabled(true);
		
		this.prmtestimatedAmt.setRequired(true);
		
		EntityViewInfo view=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("isEnabled",Boolean.TRUE));
		filter.getFilterItems().add(new FilterItemInfo("fullOrgUnit.id",editData.getOrgUnit().getId().toString()));
		view.setFilter(filter);
		
		KDWorkButton btnAddRowinfo = new KDWorkButton();
		KDWorkButton btnInsertRowinfo = new KDWorkButton();
		KDWorkButton btnDeleteRowinfo = new KDWorkButton();
		
		this.actionAddLine.putValue("SmallIcon", EASResource.getIcon("imgTbtn_addline"));
		btnAddRowinfo = (KDWorkButton)prjContainer.add(this.actionAddLine);
		btnAddRowinfo.setText("新增项目");
		btnAddRowinfo.setSize(new Dimension(140, 19));

		this.actionInsertLine.putValue("SmallIcon", EASResource.getIcon("imgTbtn_insert"));
		btnInsertRowinfo = (KDWorkButton) prjContainer.add(this.actionInsertLine);
		btnInsertRowinfo.setText("插入项目");
		btnInsertRowinfo.setSize(new Dimension(140, 19));

		this.actionRemoveLine.putValue("SmallIcon", EASResource.getIcon("imgTbtn_deleteline"));
		btnDeleteRowinfo = (KDWorkButton) prjContainer.add(this.actionRemoveLine);
		btnDeleteRowinfo.setText("删除项目");
		btnDeleteRowinfo.setSize(new Dimension(140, 19));
		
		KDWorkButton btnAddPlan = new KDWorkButton();
		KDWorkButton btnInsertPlan = new KDWorkButton();
		KDWorkButton btnDeletePlan = new KDWorkButton();
		
		this.actionAddPlan.putValue("SmallIcon", EASResource.getIcon("imgTbtn_addline"));
		btnAddPlan = (KDWorkButton)prjContainer.add(this.actionAddPlan);
		btnAddPlan.setText("新增计划");
		btnAddPlan.setSize(new Dimension(140, 19));

		this.actionInsertPlan.putValue("SmallIcon", EASResource.getIcon("imgTbtn_insert"));
		btnInsertPlan = (KDWorkButton) prjContainer.add(this.actionInsertPlan);
		btnInsertPlan.setText("插入计划");
		btnInsertPlan.setSize(new Dimension(140, 19));

		this.actionRemovePlan.putValue("SmallIcon", EASResource.getIcon("imgTbtn_deleteline"));
		btnDeletePlan = (KDWorkButton) prjContainer.add(this.actionRemovePlan);
		btnDeletePlan.setText("删除计划");
		btnDeletePlan.setSize(new Dimension(140, 19));
		
		if(this.prmtPurchaseMode.getValue() == null ) {
			actionAddLine.setEnabled(false);
			actionInsertLine.setEnabled(false);
			actionRemoveLine.setEnabled(false);
			actionAddPlan.setEnabled(false);
			actionInsertPlan.setEnabled(false);
			actionRemovePlan.setEnabled(false);
		}else{
			InvitePurchaseModeInfo modeInfo = (InvitePurchaseModeInfo) this.prmtPurchaseMode.getValue();
			if(modeInfo.getType()==InvitePurchaseModeEnum.SINGLE) {
				 this.actionAddLine.setEnabled(false);
				 this.actionInsertLine.setEnabled(false);
				 this.actionRemoveLine.setEnabled(false);
				 this.actionAddPlan.setEnabled(true);
				 this.actionRemovePlan.setEnabled(true);
				 this.actionInsertPlan.setEnabled(true);
			}else if(modeInfo.getType()==InvitePurchaseModeEnum.GROUP) {
				 this.actionAddLine.setEnabled(true);
				 this.actionInsertLine.setEnabled(true);
				 this.actionRemoveLine.setEnabled(true);
				 this.actionAddPlan.setEnabled(true);
				 this.actionRemovePlan.setEnabled(true);
				 this.actionInsertPlan.setEnabled(true);
			}else if(modeInfo.getType()==InvitePurchaseModeEnum.STRATEGY) {
				 this.actionAddLine.setEnabled(false);
				 this.actionRemoveLine.setEnabled(false);
				 this.actionInsertLine.setEnabled(false);
				 this.actionAddPlan.setEnabled(false);
				 this.actionRemovePlan.setEnabled(false);
				 this.actionInsertPlan.setEnabled(false);
			}
		}
		if(!checkCanOperate()){
			this.actionAddNew.setEnabled(false);
			this.actionEdit.setEnabled(false);
			this.actionRemove.setEnabled(false);
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
		}
	}
    public void onLoad() throws Exception {
    	this.prjTable.checkParsed();
    	initEditor();
    	super.onLoad();
    	initControl();
    	
    /*	if(this.getOprtState() == OprtState.ADDNEW ) {
    		IRow row = prjTable.addRow();
    		InviteProjectEntriesInfo entry = new InviteProjectEntriesInfo();
    		row.setUserObject(entry);
    	}*/
    }
	protected void attachListeners() {
		addDataChangeListener(this.prmtPurchaseMode);
	}
	protected void detachListeners() {
		 removeDataChangeListener(this.prmtPurchaseMode);
	}
	protected ICoreBase getBizInterface() throws Exception {
		return InviteProjectFactory.getRemoteInstance();
	}
	protected KDTable getDetailTable() {
		return null;
	}
	protected KDTextField getNumberCtrl() {
		return this.txtNumber;
	}
	protected void verifyInputForSave() throws Exception {
		if(getNumberCtrl().isEnabled()) {
			FDCClientVerifyHelper.verifyEmpty(this, getNumberCtrl());
		}
		if(prmtestimatedAmt.getValue() == null) {
			MsgBox.showWarning("预估金额不能为空!");
			SysUtil.abort();
		}
		InvitePurchaseModeInfo modeInfo = (InvitePurchaseModeInfo) this.prmtPurchaseMode.getValue();
		if(modeInfo.getType()!=InvitePurchaseModeEnum.STRATEGY&&prjTable.getRowCount()==0){
			MsgBox.showWarning("分录不能为空！");
			SysUtil.abort();
		}
		checkPrjTableRequired();
		super.verifyInputForSave();
//		FDCClientVerifyHelper.verifyEmpty(this, this.prmtProject);
	}
	
	private void checkPrjTableRequired() throws BOSException, EASBizException {
		for( int i=0; i<prjTable.getRowCount(); i++ ) {
			if(prjTable.getCell(i, "name").getValue()==null  ) {
				MsgBox.showWarning("第" + (i+1) + "行工程项目不能为空");
				SysUtil.abort();
			}
			this.checkPlan=false;
			CurProjectInfo project=(CurProjectInfo) prjTable.getCell(i, "name").getValue();
			FilterInfo filter = new FilterInfo();
			
			EntityViewInfo view = new EntityViewInfo();
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add("*");
			sic.add("parent.*");
			filter.getFilterItems().add(new FilterItemInfo("parent.project.id",project.getId()));
			 
			view.setFilter(filter);
			view.setSelector(sic);
			 
			InviteMonthPlanEntrysCollection coll = InviteMonthPlanEntrysFactory.getRemoteInstance().getInviteMonthPlanEntrysCollection(view);
			ProgrammingContractCollection validPCColl=null;
			try {
				 validPCColl = InviteProjectFactory.getRemoteInstance().getValidProgrammingContract(coll);
				 if(validPCColl.size() <= 0) {
					 filter = new FilterInfo();
					 filter.getFilterItems().add(new FilterItemInfo("project.id",project.getId()));
					 filter.getFilterItems().add(new FilterItemInfo("state",FDCBillStateEnum.AUDITTED_VALUE));
					 if(ProgrammingFactory.getRemoteInstance().exists(filter)){
						 this.checkPlan = true;
					 }
				 }else {
					 this.checkPlan = true;
				 }
			 }catch(EASBizException e1) {
				 this.checkPlan = true;
			 }
//			 if(this.checkPlan&&prjTable.getCell(i, "programmingName").getValue()==null) {
//				MsgBox.showWarning("第" + (i+1) + "行采购计划不能为空");
//				SysUtil.abort();
//			}
		}
	}
	
	protected void verifyInput(ActionEvent e) throws Exception {
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtInviteType);
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtInviteForm);
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtPurchaseMode);
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtScalingRule);
		FDCClientVerifyHelper.verifyEmpty(this, this.combProcurementType);
		FDCClientVerifyHelper.verifyEmpty(this, this.combAuth);
		super.verifyInput(e);
	}
	
	protected void verifyInputForSubmint() throws Exception {
		verifyInputForSave();
	}
	
	private void replaceLongNumberStr( boolean dotToeExclamation) {
		for(int i=0; i<prjTable.getRowCount(); i++ ) {
			String longNumber = (String) prjTable.getCell(i, "number").getValue();
			if(longNumber != null ) {
				if(dotToeExclamation) {
					prjTable.getCell(i, "number").setValue(longNumber.replaceAll(".", "!"));
				}else {
					prjTable.getCell(i, "number").setValue(longNumber.replaceAll("!", "."));
				}
			}
		}
	}
	
	public void loadFields() {
		detachListeners();
		super.loadFields();
		setSaveActionStatus();
		
		if(this.editData.isPaperIsComplete()){
			this.kDRBPCYes.setSelected(true);
		}else{
			this.kDRBPCNo.setSelected(true);
		}
		/*if(this.editData.isScalingRules()){
			this.kDRBSRYes.setSelected(true);
		}else{
			this.kDRBSRNo.setSelected(true);
		}*/
		replaceLongNumberStr(false);
		attachListeners();
		setAuditButtonStatus(this.getOprtState());
		
		if(this.getOprtState() != OprtState.ADDNEW ) {
    		this.mergeBlock();
    	}
	}
	
	public void storeFields() {
		replaceLongNumberStr(true);
		if(this.kDRBPCYes.isSelected()){
			this.editData.setPaperIsComplete(true);
		}else{
			this.editData.setPaperIsComplete(false);
		}
		Set curProject=new HashSet();
		String curProjectName="";
		for(int i=0;i<this.prjTable.getRowCount();i++){
			CurProjectInfo info = (CurProjectInfo) prjTable.getCell(i, "name").getValue();
			if(info==null) continue;
			if(!curProject.contains(info.getId())){
				curProjectName=curProjectName+info.getName()+",";
				curProject.add(info.getId());
			}
		}
		if(curProjectName.indexOf(",")>0){
			curProjectName=curProjectName.substring(0, curProjectName.lastIndexOf(","));
		}else{
			curProjectName=null;
		}
		this.editData.setCurProjectName(curProjectName);
		/*if(this.kDRBSRYes.isSelected()){
			this.editData.setScalingRules(true);
		}else{
			this.editData.setScalingRules(false);
		}*/
		super.storeFields();
	}
	
	private void mergeBlock() {
		KDTMergeManager merge = prjTable.getMergeManager();
		int count = prjTable.getRowCount();
		if(count==0) {
			return;
		}
		
		CurProjectInfo info = (CurProjectInfo) prjTable.getCell(0, "name").getValue();
		int start=0;
		for(int i=1; i<count; i++ ) {
			CurProjectInfo info2 = (CurProjectInfo) prjTable.getCell(i, "name").getValue();
			if( info!=null && info2!=null && info.getId().toString().equals(info2.getId().toString()) ) {
				continue;
			}else {
				merge.mergeBlock(start, 1, i-1, 1);
				merge.mergeBlock(start, 2, i-1, 2);
				start=i;
				info = info2;
			}
		}
		
		merge.mergeBlock(start, 1, count-1, 1);
		merge.mergeBlock(start, 2, count-1, 2);
	}
	
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		super.actionRemove_actionPerformed(e);
		handleCodingRule();
	}
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
		this.setOprtState("VIEW");
		this.actionAudit.setVisible(true);
		this.actionAudit.setEnabled(true);
	}
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		super.actionAudit_actionPerformed(e);
		this.actionUnAudit.setVisible(true);
		this.actionUnAudit.setEnabled(true);
		this.actionAudit.setVisible(false);
		this.actionAudit.setEnabled(false);
	}
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		super.actionUnAudit_actionPerformed(e);
		this.actionUnAudit.setVisible(false);
		this.actionUnAudit.setEnabled(false);
		this.actionAudit.setVisible(true);
		this.actionAudit.setEnabled(true);
	}
	public void setOprtState(String oprtType) {
		super.setOprtState(oprtType);
		if (oprtType.equals(OprtState.VIEW)) {
			this.lockUIForViewStatus();
		} else {
			this.unLockUI();
		}
	}
	
	private void initEditor() throws Exception {
		prjTable.checkParsed();
		KDBizPromptBox prmtCurProject = new KDBizPromptBox();
		prmtCurProject.setSelector(new F7ProjectSelector(this));
		prmtCurProject.setDisplayFormat("$name$");
		prmtCurProject.setEditFormat("$number$");
		prmtCurProject.setCommitFormat("$number$");
		prmtCurProject.setRequired(true);
		
		prmtCurProject.addSelectorListener(new SelectorListener() {
			public void willShow(SelectorEvent e) {
				KDBizPromptBox f7 = (KDBizPromptBox) e.getSource();
				f7.getQueryAgent().resetRuntimeEntityView();
				EntityViewInfo view = new EntityViewInfo();
				FilterInfo filter = new FilterInfo();
				
				filter.getFilterItems().add(new FilterItemInfo("fullOrgUnit.longNumber", editData.getOrgUnit().getLongNumber()+"%",CompareType.LIKE));
//				filter.getFilterItems().add(new FilterItemInfo("isLeaf", "1"));
				view.setFilter(filter);
				f7.setEntityViewInfo(view);
		}});
		prjTable.getColumn("name").setEditor(new KDTDefaultCellEditor(prmtCurProject));
		
		//采购计划。。。
		KDBizPromptBox prmtPlan = new KDBizPromptBox();
		prmtPlan.setDisplayFormat("$name$");
		prmtPlan.setEditFormat("$number$");
		prmtPlan.setCommitFormat("$number$");
		prmtPlan.setRequired(true);
		prmtPlan.setQueryInfo("com.kingdee.eas.fdc.invite.app.F7PurchasePlanQuery");
		prmtPlan.setEnabledMultiSelection(true);
		prmtPlan.getQueryAgent().setEnabledMultiSelection(true);
		
		prmtPlan.addSelectorListener(new SelectorListener() {
			public void willShow(SelectorEvent e) {
				KDBizPromptBox f7 = (KDBizPromptBox) e.getSource();
				f7.getQueryAgent().resetRuntimeEntityView();
				EntityViewInfo view = new EntityViewInfo();
				FilterInfo filter = new FilterInfo();
				
				int rowIndex = prjTable.getSelectManager().getActiveRowIndex();
				
				CurProjectInfo prj = (CurProjectInfo) prjTable.getCell(rowIndex, "name").getValue();
				if(prj == null) {
					MsgBox.showConfirm2("请先选择工程项目");
					SysUtil.abort();
				}
				
				String prjID= prj.getId().toString();
				FDCSQLBuilder sqlBuilder = new FDCSQLBuilder();
				
				sqlBuilder.appendSql("select fid as parentId from T_INV_InviteMonthPlan where fprojectid='" +
						prjID + "' and fstate='4AUDITTED' order by FVersion desc");
				IRowSet rowSet = null;
				String parentId = "";
				try {
					rowSet = sqlBuilder.executeQuery();
					if(rowSet != null && rowSet.size() > 0) {
						while(rowSet.next()){
							parentId = rowSet.getString("parentId");
							break;
						}
					}
				} catch (BOSException e1) {
					handleException(e1);
				} catch (SQLException e2) {
					handleException(e2);
				}
				
				filter.getFilterItems().add(new FilterItemInfo("project.id", prjID));
				filter.getFilterItems().add(new FilterItemInfo("parent.id", parentId));
				view.setFilter(filter);
				f7.setEntityViewInfo(view);
		}});
		prjTable.getColumn("programmingName").setEditor(new KDTDefaultCellEditor(prmtPlan));
		
		String formatString = "yyyy-MM-dd";
		KDDatePicker issueDatePicker = new KDDatePicker();
		prjTable.getColumn("issueDate").setEditor(new KDTDefaultCellEditor(issueDatePicker));
		this.prjTable.getColumn("issueDate").getStyleAttributes().setNumberFormat(formatString);
		
		KDDatePicker startDatePicker = new KDDatePicker();
		prjTable.getColumn("startDate").setEditor(new KDTDefaultCellEditor(startDatePicker));
		this.prjTable.getColumn("startDate").getStyleAttributes().setNumberFormat(formatString);
		
		KDDetailedArea desc = new KDDetailedArea(250, 200);
		desc.setMaxLength(1000);
		prjTable.getColumn("desc").setEditor(new KDTDefaultCellEditor(desc));
	}
	
	/**
	 * 检查某行选择的项目是否已在其他行存在
	 * @param project
	 * @param selectedIndex 
	 * @return
	 */
	private boolean checkProjectExist(CurProjectInfo project, int selectedIndex) {
		String projectId = project.getId().toString();
		for( int i =0; i<prjTable.getRowCount(); i++) {
			if(i==selectedIndex) {
				continue;
			}
			CurProjectInfo prj = (CurProjectInfo) prjTable.getCell(i,"name").getValue();
			if(prj==null) {
				continue;
			}else if(prj.getId().toString().equals(projectId)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 对获取的计划做过滤，去除已选取的计划。
	 */
	private void checkProgrammingContractCollection( ProgrammingContractCollection coll, CurProjectInfo project, int selectedIndex ) {
		int end = this.getProjectEndIndex(project, selectedIndex);
		int start = this.getProjectStartIndex(project, selectedIndex);
		
		Iterator<ProgrammingContractInfo> iter = coll.iterator();
		while(iter.hasNext()){
			ProgrammingContractInfo info = iter.next();
			for( int j=start; j<=end; j++ ) {
				Object id = prjTable.getCell(j, "programmingId").getValue();
				if( j==selectedIndex || id == null) {
					continue;
				}
				if(info.getId().toString().equals(id.toString())) {
					iter.remove();
					break;
				}
			}
		}
	}
	
    private IRow clearPlans( CurProjectInfo project, int selectedIndex ) {
    	int startIndex = this.getProjectStartIndex(project, selectedIndex);
    	int endIndex = this.getProjectEndIndex(project, selectedIndex);
    	if( endIndex>startIndex ) {
    		for(int i=endIndex; i>startIndex; i--) {
    			this.prjTable.removeRow(i);
    		}
    	}
    	return prjTable.getRow(startIndex);
    	
    }
    boolean checkPlan = false;
	protected void prjTable_editStopped( KDTEditEvent e ) throws Exception {
			int colIndex = e.getColIndex();
			IRow row = prjTable.getRow(e.getRowIndex());
			if (row == null ) {
				return;
			}
			String key = prjTable.getColumnKey(colIndex);
			if ("name".equals(key)) { //工程项目名称
				
				CurProjectInfo project = (CurProjectInfo) row.getCell("name").getValue();
				if(project==null) {
					return;
				}else if(!project.isIsLeaf()) {
					row.getCell("name").setValue(null);
					return;
				}
				
				CurProjectInfo oldProject = (CurProjectInfo) e.getOldValue();
				if( oldProject != null && project.getId().equals(oldProject.getId())) {
					return;
				}
				
				if(this.checkProjectExist(project,row.getRowIndex()) ) {
					MsgBox.showConfirm2("所选项目："+project.getName() + "已存在" );
					row.getCell("name").setValue(null);
					return;
				}
				
				if( oldProject != null ) {//若有老值，清除此项目所有行，保留开始行
					removeDataChangeListener(this.prmtPurchaseMode);
				    row.getCell("name").setValue(oldProject);	//设置老值，以便查找开始结束位置
				    row = this.clearPlans(oldProject, e.getRowIndex());
				    row.getCell("name").setValue(project);
				    addDataChangeListener(this.prmtPurchaseMode);
				    
				    int start = prjTable.getColumnIndex("name") + 1;
				    for( int i=start; i<prjTable.getColumnCount(); i++ ) {
				    	row.getCell(i).setValue(null);
				    }
				}
				
				row.getCell("number").setValue(project.getLongNumber().replaceAll("!", "."));
//				row.getCell("name").getStyleAttributes().setLocked(true);
				 for( int i=3; i<prjTable.getColumnCount(); i++ ) {
					 prjTable.getCell(0, i).getStyleAttributes().setLocked(false);
					 prjTable.getCell(0, i).getStyleAttributes().setBackground(Color.WHITE);
				 }
			}else if("programmingName".equals(key)) { //采购计划。。
				Object value = e.getValue();
				if( value instanceof InviteMonthPlanEntrysInfo) {//单选
					InviteMonthPlanEntrysInfo info = (InviteMonthPlanEntrysInfo) value;
					InviteMonthPlanEntrysCollection coll = new InviteMonthPlanEntrysCollection();
					coll.add(info);
					
					ProgrammingContractCollection validPCColl = InviteProjectFactory.getRemoteInstance().getValidProgrammingContract(coll);
					CurProjectInfo project = (CurProjectInfo) row.getCell("name").getValue();
					this.checkProgrammingContractCollection(validPCColl, project, row.getRowIndex());
					if(validPCColl.size()>0) {
						row.getCell("programmingName").setValue(validPCColl.get(0));
						row.getCell("programmingId").setValue(validPCColl.get(0).getId());
					}
				}else if( value instanceof Object[] ) {//多选
//					InviteMonthPlanEntrysInfo[] infos = (InviteMonthPlanEntrysInfo[]) value;
					Object[] valueArray = (Object[]) value;
					InviteMonthPlanEntrysCollection coll = new InviteMonthPlanEntrysCollection();
					for(int i=0; i<valueArray.length; i++) {
						coll.add((InviteMonthPlanEntrysInfo) valueArray[i]);
					}
					
					ProgrammingContractCollection validPCColl=null;
					try {
						validPCColl = InviteProjectFactory.getRemoteInstance().getValidProgrammingContract(coll);
					}catch(EASBizException e1) {
						row.getCell("programmingName").setValue(null);
						row.getCell("programmingId").setValue(null);
						MsgBox.showWarning(e1.getMessage());
						return;
					}
					
					
				
					
					
					 if(validPCColl.size()<coll.size() ) {
//						row.getCell("programmingName").setValue(null);
						MsgBox.showWarning("所选计划中有被其它招标立项引用的计划。");
					}
					
					CurProjectInfo project = (CurProjectInfo) row.getCell("name").getValue();
					this.checkProgrammingContractCollection(validPCColl, project, row.getRowIndex());
					int selectedIndex = row.getRowIndex();
					CurProjectInfo prjInfo = (CurProjectInfo) row.getCell("name").getValue();
					for(int i=0; i<validPCColl.size(); i++) {
						if(i>0) {
							row = prjTable.addRow(selectedIndex);
							InviteProjectEntriesInfo entry = new InviteProjectEntriesInfo();
							row.setUserObject(entry);
						}
						
						row.getCell("number").setValue(prjInfo.getLongNumber().replaceAll("!", "."));
						row.getCell("name").setValue(prjInfo);
						row.getCell("programmingName").setValue(validPCColl.get(i));
						row.getCell("programmingId").setValue(validPCColl.get(i).getId());
					}
					
					if(validPCColl.size() == 0) {
						row.getCell("programmingName").setValue(e.getOldValue());
					}
				}
				
				KDTMergeManager merge = prjTable.getMergeManager();
				CurProjectInfo project = (CurProjectInfo) row.getCell("name").getValue();
				if(project == null) {
					return;
				}
				
				int end = this.getProjectEndIndex(project, row.getRowIndex());
				int start = this.getProjectStartIndex(project, row.getRowIndex());
				merge.mergeBlock(start, 1, end, 1);
				merge.mergeBlock(start, 2, end, 2);
			}
    }
	
	//增加工程项目
	public void actionAddLine_actionPerformed(ActionEvent e) throws Exception {
		IRow row = prjTable.addRow();
		InviteProjectEntriesInfo entry = new InviteProjectEntriesInfo();
		row.setUserObject(entry);
		row.getCell("name").getStyleAttributes().setLocked(false);
	}
	
	/**
	 * 工程项目起始块位置。
	 * @param project
	 * @param selectedIndex
	 * @return
	 */
	private int getProjectStartIndex( CurProjectInfo project, int selectedIndex ) {
		for( int i=selectedIndex-1; i>=0; i-- ) {
			CurProjectInfo prj = (CurProjectInfo) prjTable.getCell(i, "name").getValue();
			if( prj==null || !prj.getId().equals(project.getId()) ) {
				return i+1;
			}
		}
		
		return 0;
	}
	
	private int getProjectEndIndex( CurProjectInfo project, int selectedIndex ) {
		for( int i=selectedIndex+1; i<prjTable.getBody().size(); i++ ) {
			CurProjectInfo prj = (CurProjectInfo) prjTable.getCell(i, "name").getValue();
			if( prj == null || !prj.getId().equals(project.getId()) ) {
				return i-1;
			}
		}
		
		
		return prjTable.getBody().size()-1;
	}
	
	//插入工程项目
	public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception {
		IRow row = null;
		if (this.prjTable.getSelectManager().size() > 0) {
			int top = prjTable.getSelectManager().getActiveRowIndex();
			if (isTableColumnSelected(this.prjTable)) {
				row = this.prjTable.addRow();
			}
			else {
				IRow topRow = this.prjTable.getRow(top);
				CurProjectInfo project = (CurProjectInfo) topRow.getCell("name").getValue();
				if(project==null || top==0) {
					row = this.prjTable.addRow(top);
				}else {
					int projectStartIndex = getProjectStartIndex(project, top);
					projectStartIndex = projectStartIndex==-1?0:projectStartIndex;
					row = this.prjTable.addRow(projectStartIndex);
				}
			}
		} else {
			row = this.prjTable.addRow();
		}
		InviteProjectEntriesInfo entry = new InviteProjectEntriesInfo();
		row.setUserObject(entry);
		row.getCell("name").getStyleAttributes().setLocked(false);
	}
	
	//删除工程项目
	public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception {
		if (this.prjTable.getSelectManager().size() == 0 || isTableColumnSelected(this.prjTable)) {
				FDCMsgBox.showInfo(this, EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_NoneEntry"));
				return;
		}
		 
		int top = this.prjTable.getSelectManager().getActiveRowIndex();
		
		CurProjectInfo prjInfo = (CurProjectInfo) this.prjTable.getCell(top, "name").getValue();
		if(prjInfo==null) {
			this.prjTable.removeRow(top);
			return;
		}
		
		String selectedPrjID = prjInfo.getId().toString();
		int end = this.getProjectEndIndex(prjInfo, top);
		int start = this.getProjectStartIndex(prjInfo, top);
		
		for( int i=end; i>=start; i--) {
			String prjID = ((CurProjectInfo) this.prjTable.getCell(i, "name").getValue()).getId().toString();
			
			if(selectedPrjID.equals(prjID)) {
				this.prjTable.getRow(i).setUserObject(null);
				this.prjTable.removeRow(i);
			}
		}
	 }
	 
	//增加计划
	 public void actionAddPlan_actionPerformed(ActionEvent e) throws Exception {
		 if (this.prjTable.getSelectManager().size() == 0 || isTableColumnSelected(this.prjTable)) {
				FDCMsgBox.showInfo(this, "未选中分录");
				return;
		 }
		 
		 IRow row = FDCTableHelper.getSelectedRow(prjTable);
		 CurProjectInfo project = (CurProjectInfo) row.getCell("name").getValue();
		 if(project==null) {
			 MsgBox.showConfirm2("所选择行未录入工程项目。");
			 SysUtil.abort();
		 }
		 
		 int endIndex = getProjectEndIndex(project, row.getRowIndex());
		 IRow newRow = null;
		 if(endIndex==prjTable.getRowCount()) {
			 newRow = prjTable.addRow();
		 }else {
			 newRow = prjTable.addRow(endIndex+1);
		 }
		 
		 newRow.getCell("name").setValue(project);
		 newRow.getCell("number").setValue(project.getLongNumber().replaceAll("!", "."));
		 
		 InviteProjectEntriesInfo entry = new InviteProjectEntriesInfo();
		 newRow.setUserObject(entry);
	 }
	
	 //插入计划
	 public void actionInsertPlan_actionPerformed(ActionEvent e) throws Exception {
		 if (this.prjTable.getSelectManager().size() == 0 || isTableColumnSelected(this.prjTable)) {
				FDCMsgBox.showInfo(this, "未选中分录");
				return;
		 }
		 
		 IRow row = FDCTableHelper.getSelectedRow(prjTable);
		 CurProjectInfo project = (CurProjectInfo) row.getCell("name").getValue();
		 if(project==null) {
			 MsgBox.showConfirm2("所选择行未录入工程项目。");
			 SysUtil.abort();
		 }
		 
		 IRow newRow = prjTable.addRow(row.getRowIndex());
		 newRow.getCell("name").setValue(project);
		 newRow.getCell("number").setValue(project.getLongNumber().replaceAll("!", "."));
		 
		 InviteProjectEntriesInfo entry = new InviteProjectEntriesInfo();
		 newRow.setUserObject(entry);
	 }
	 
	 
	 //删除计划
	 public void actionRemovePlan_actionPerformed(ActionEvent e) throws Exception {
		 if( prjTable.getRowCount()<=1) {
				MsgBox.showConfirm2("至少有一条工程项目");
				SysUtil.abort();
		 }
		 
		 if (this.prjTable.getSelectManager().size() == 0 || isTableColumnSelected(this.prjTable)) {
				FDCMsgBox.showInfo(this, EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_NoneEntry"));
				return;
		 }
		 
		 int i = prjTable.getSelectManager().getActiveRowIndex();
		 this.prjTable.getRow(i).setUserObject(null);
		 this.prjTable.removeRow(i);
	 }
	 
	 protected void prmtPurchaseMode_dataChanged(DataChangeEvent e) throws Exception {
		 boolean isChanged = true;
		 isChanged = BizCollUtil.isF7ValueChanged(e);
         if(!isChanged){
        	 return;
         }

		 InvitePurchaseModeInfo modeInfo = (InvitePurchaseModeInfo) e.getNewValue();
		 boolean showAlarm = false;
		 if(modeInfo==null) {
			 return;
		 }
		 if(modeInfo.getType()==InvitePurchaseModeEnum.SINGLE) {
			 for(int i =0; i<prjTable.getRowCount(); i++ ) {
				 if( prjTable.getCell(i, "name").getValue() != null ) {
					 showAlarm = true;
					 break;
				 }
			 }
			 
			 if(showAlarm) {
				 int choice = MsgBox.showConfirm2("变更为单向采购会清空所有工程项目");
				 if(choice == 0) {
					 this.editData.getEntries().clear();
				 }else {
					 removeDataChangeListener(this.prmtPurchaseMode);
					 prmtPurchaseMode.setValue(e.getOldValue());
					 addDataChangeListener(this.prmtPurchaseMode);
					 return;
				 } 
			 }
			 prjTable.removeRows();
//			 this.actionAddLine_actionPerformed(null);
//			 prjTable.addRow();
			 
			 this.actionAddLine.setEnabled(true);
			 this.actionInsertLine.setEnabled(true);
			 this.actionRemoveLine.setEnabled(true);
			 this.actionAddPlan.setEnabled(true);
			 this.actionRemovePlan.setEnabled(true);
			 this.actionInsertPlan.setEnabled(true);
			 
			
		 }else if(modeInfo.getType()==InvitePurchaseModeEnum.GROUP) {
			 this.actionAddLine.setEnabled(true);
			 this.actionInsertLine.setEnabled(true);
			 this.actionRemoveLine.setEnabled(true);
			 this.actionAddPlan.setEnabled(true);
			 this.actionRemovePlan.setEnabled(true);
			 this.actionInsertPlan.setEnabled(true);
			 
			 if(prjTable.getRowCount()<=0) {
//				 this.actionAddLine_actionPerformed(null);
			 }
			 
			 for( int i=0; i<prjTable.getRowCount(); i++ ) {
				 for( int j=3; j<prjTable.getColumnCount(); j++ ) {
					 prjTable.getCell(i, j).getStyleAttributes().setBackground(Color.WHITE);
					 prjTable.getCell(i, j).getStyleAttributes().setLocked(false);
				 }
			 }
		 }else if(modeInfo.getType()==InvitePurchaseModeEnum.STRATEGY) {
			 this.actionAddLine.setEnabled(false);
			 this.actionRemoveLine.setEnabled(false);
			 this.actionInsertLine.setEnabled(false);
			 this.actionAddPlan.setEnabled(false);
			 this.actionRemovePlan.setEnabled(false);
			 this.actionInsertPlan.setEnabled(false);
			 
			 for( int i=0; i<prjTable.getRowCount(); i++ ) {
				 if(prjTable.getCell(i, "name").getValue() != null ) {
					 showAlarm = true;
					 break;
				 }
			 }
			 
			 if(showAlarm) {
				 int choice = MsgBox.showConfirm2("变更为战略采购会清空所有工程项目");
				 if(choice == 0) {
					 this.editData.getEntries().clear();
				 }else {
					 removeDataChangeListener(this.prmtPurchaseMode);
					 prmtPurchaseMode.setValue(e.getOldValue());
					 addDataChangeListener(this.prmtPurchaseMode);
					 return;
				 } 
			 }	
			 prjTable.removeRows();
		 }
		 
		 if(modeInfo.getType()==InvitePurchaseModeEnum.GROUP){
			 KDBizPromptBox prmtCurProject = new KDBizPromptBox();
			 prmtCurProject.setSelector(new F7ProjectSelector(this,true));
			 prmtCurProject.setDisplayFormat("$name$");
			 prmtCurProject.setEditFormat("$number$");
			 prmtCurProject.setCommitFormat("$number$");
			 prmtCurProject.setRequired(true);
			 prjTable.getColumn("name").setEditor(new KDTDefaultCellEditor(prmtCurProject));
		 }else{
			 KDBizPromptBox prmtCurProject = new KDBizPromptBox();
			 prmtCurProject.setSelector(new F7ProjectSelector(this,false));
			 prmtCurProject.setDisplayFormat("$name$");
			 prmtCurProject.setEditFormat("$number$");
			 prmtCurProject.setCommitFormat("$number$");
			 prmtCurProject.setRequired(true);
			 prjTable.getColumn("name").setEditor(new KDTDefaultCellEditor(prmtCurProject));
		 }
	 }
	 
	 protected void setComponentEnable( boolean enabled) {
		 this.txtName.setAccessAuthority(CtrlCommonConstant.AUTHORITY_COMMON);
		 this.txtNumber.setAccessAuthority(CtrlCommonConstant.AUTHORITY_COMMON);
		 this.prmtInviteType.setAccessAuthority(CtrlCommonConstant.AUTHORITY_COMMON);
		 this.prmtInviteForm.setAccessAuthority(CtrlCommonConstant.AUTHORITY_COMMON);
		 this.prmtPurchaseMode.setAccessAuthority(CtrlCommonConstant.AUTHORITY_COMMON);
		 this.combPriceMode.setAccessAuthority(CtrlCommonConstant.AUTHORITY_COMMON);
		 this.prmtScalingRule.setAccessAuthority(CtrlCommonConstant.AUTHORITY_COMMON);
		 combProcurementType.setAccessAuthority(CtrlCommonConstant.AUTHORITY_COMMON);
		 combAuth.setAccessAuthority(CtrlCommonConstant.AUTHORITY_COMMON);
		
		 txtName.setEnabled(enabled);
		 txtNumber.setEnabled(false);
		 prmtInviteType.setEditable(false);
		 prmtInviteType.setEnabled(enabled);
		 prmtInviteForm.setEnabled(enabled);
		 prmtPurchaseMode.setEnabled(enabled);
		 combPriceMode.setEnabled(enabled);
		 combProcurementType.setEnabled(enabled);
		 combAuth.setEnabled(enabled);
		 prmtScalingRule.setEnabled(enabled);
		 kDRBPCYes.setEnabled(enabled);
		 kDRBPCNo.setEnabled(enabled);
		 prjTable.getStyleAttributes().setLocked(enabled);
		 
		 this.actionAddLine.setEnabled(enabled);
		 this.actionRemoveLine.setEnabled(enabled);
		 this.actionInsertLine.setEnabled(enabled);
		 this.actionAddPlan.setEnabled(enabled);
		 this.actionRemovePlan.setEnabled(enabled);
		 this.actionInsertPlan.setEnabled(enabled);
		 
	 }
}