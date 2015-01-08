/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.client;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.TreeModel;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemCollection;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.QueryInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ctrl.kdf.table.KDTDataRequestManager;
import com.kingdee.bos.ctrl.swing.KDDialog;
import com.kingdee.bos.ctrl.swing.KDFrame;
import com.kingdee.bos.ctrl.swing.KDTree;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ctrl.swing.tree.DefaultKingdeeTreeNode;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.dao.query.QueryExecutorFactory;
import com.kingdee.eas.base.attachment.util.UICreator;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.uiframe.client.UIFactoryHelper;
import com.kingdee.eas.basedata.framework.client.DListClientControlStrategy;
import com.kingdee.eas.basedata.master.batch.DlgGeneralBatch;
import com.kingdee.eas.basedata.master.batch.GeneralBatchLog;
import com.kingdee.eas.basedata.master.cssp.CustomerSupplierException;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.cssp.client.CSUtils;
import com.kingdee.eas.basedata.org.NewOrgUtils;
import com.kingdee.eas.basedata.org.OrgConstants;
import com.kingdee.eas.basedata.org.OrgStructureInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgViewType;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitFactory;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.fdc.basedata.FDCDataBaseInfo;
import com.kingdee.eas.fdc.basedata.FDCHelper;
import com.kingdee.eas.fdc.basedata.FDCSQLBuilder;
import com.kingdee.eas.fdc.basedata.client.FDCClientHelper;
import com.kingdee.eas.fdc.basedata.client.FDCClientUtils;
import com.kingdee.eas.fdc.basedata.client.FDCMsgBox;
import com.kingdee.eas.fdc.invite.InviteTypeFactory;
import com.kingdee.eas.fdc.invite.InviteTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo;
import com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStock;
import com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum;
import com.kingdee.eas.ma.budget.client.LongTimeDialog;
import com.kingdee.eas.tools.datatask.DatataskMode;
import com.kingdee.eas.tools.datatask.DatataskParameter;
import com.kingdee.eas.tools.datatask.client.DatataskCaller;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class DesignSupplierStockListUI extends AbstractDesignSupplierStockListUI
{
    private static final Logger logger = CoreUIObject.getLogger(DesignSupplierStockListUI.class);
    
    /**
     * output class constructor
     */
    public DesignSupplierStockListUI() throws Exception
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
    protected MetaDataPK getQueryPKFromEntity()throws Exception{
		String queryName = "com.kingdee.eas.basedata.master.cssp.app.F7SupplierQueryForDefaultAssign";
		MetaDataPK queryPK = new MetaDataPK(queryName);
		return queryPK;
	}
	QueryInfo qiQuery=null;
	protected QueryInfo getQueryInfoFromQueryPK()throws Exception{
		if(qiQuery == null)
			qiQuery = MetaDataLoaderFactory.getRemoteMetaDataLoader().getQuery(getQueryPKFromEntity());
		return qiQuery;
	}
	String sqlQuery=null;
	protected String getQuerySqlFromQueryPK()throws Exception{
		 if(sqlQuery == null){
			 IQueryExecutor qe = QueryExecutorFactory.getRemoteInstance(getQueryPKFromEntity());
			 sqlQuery = qe.getSQL();
		 }
		 return sqlQuery;
	}
	protected DListClientControlStrategy cStrategy;
    public void actionBathAssign_actionPerformed(ActionEvent e)
    		throws Exception {
    	checkSelected();
		Set supplierId=new HashSet();
		supplierId.add("999999999999");
		ArrayList id = getSelectedIdValues();
		SelectorItemCollection sel=new SelectorItemCollection();
		sel.add("sysSupplier.id");
		for(int i = 0; i < id.size(); i++){
			DesignSupplierStockInfo info=DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(id.get(i).toString()),sel);
			if(info.getSysSupplier()!=null)
				supplierId.add(info.getSysSupplier().getId().toString());
		}
		
		UIContext uictx = new UIContext(this);
		uictx.put("QueryPK", getQueryPKFromEntity());
		uictx.put("pkQueryOnlySltID", null);
		uictx.put("QueryInfo", getQueryInfoFromQueryPK());
		uictx.put("QuerySql", getQuerySqlFromQueryPK());
		uictx.put("QuerySqlOnlySltID", null);
		uictx.put("BizInterface", SupplierFactory.getRemoteInstanceWithObjectContext(getMainOrgContext()));
		uictx.put("CurrentCtrlUnit", SysContext.getSysContext().getCurrentCtrlUnit());
		uictx.put("isSubordinateAssign", true);
		uictx.put("isReferDataBaseDChkBoxVisble", true);
		uictx.put("bosType", new SupplierInfo().getBOSType().toString());
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("id",supplierId,CompareType.INCLUDE));
		uictx.put("defaultDataFilter", filter);
		String uimode = UIFactoryName.MODEL;
		UICreator.create(com.kingdee.eas.basedata.master.cssp.client.SupplierAssignmentUI.class.getName(), uimode, uictx);
	}
    
    protected void getRowSetBeforeFillTable(IRowSet rowSet) {
		super.getRowSetBeforeFillTable(rowSet);
		try {
			rowSet.beforeFirst();
			IDesignSupplierStock iProductDefectSet = DesignSupplierStockFactory.getRemoteInstance();
			while(rowSet.next()){
				String id = rowSet.getString("id");
				DesignSupplierStockInfo info = iProductDefectSet.getDesignSupplierStockInfo(new ObjectUuidPK(id));
			    rowSet.updateObject("isPass", (info.getIsPass()!=null)?info.getIsPass().getAlias():"");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
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
    		DesignSupplierStockInfo info = DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(idList.get(i).toString()));
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
    		DesignSupplierStockInfo info = DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(idList.get(i).toString()));
			if(info.getState().getValue() > 2 ){
				FDCMsgBox.showWarning(this,getResource("notRemove"));
				SysUtil.abort();
			}
		}
        super.actionRemove_actionPerformed(e);
    }
    
    
    public void onLoad() throws Exception {
		super.onLoad();
		actionEditLevel.setVisible(false);
		actionImport.setVisible(false);
		this.tblMain.getDataRequestManager().setDataRequestMode(KDTDataRequestManager.REAL_MODE);
		FDCClientHelper.addSqlMenu(this, this.menuEdit);
		buildOrgTree();
		buildInviteTypeTree();
		this.btnSupplierState.setVisible(false);
		this.actionReview.setVisible(false);
		this.actionConstract.setVisible(false);
		this.actionAppraise.setVisible(false);
		this.actionInfoChange.setVisible(false);
		this.actionEnterHis.setVisible(false);
		this.actionConstractHis.setVisible(false);
		this.actionAppraiseHis.setVisible(false);
		this.actionChangeHis.setVisible(false);
		this.actionMaterialInfo.setVisible(false);
		this.actionAddNew.setVisible(true);
		this.actionView.setVisible(true);
		this.actionEdit.setVisible(true);
		this.actionRemove.setVisible(true);
		this.actionAudit.setEnabled(true);
		this.actionUnAudit.setEnabled(true);
		this.actionMultiSubmit.setEnabled(true);
		this.actionImport.setEnabled(true);
		this.actionAddToSysSupplier.setEnabled(true);
		this.btnEditLevel.setEnabled(true);
//		this.actionAddToSysSupplier.setVisible(false);
		
		this.btnMultiSubmit.setIcon(EASResource.getIcon("imgTbtn_submit"));
		this.btnImport.setIcon(EASResource.getIcon("imgTbtn_input"));
		this.btnAddToSysSupplier.setIcon(EASResource.getIcon("imgTbtn_synchronization"));
		this.audit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.unAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		this.btnEditLevel.setIcon(EASResource.getIcon("imgTbtn_rename"));
		
		this.actionImportFormDataBase.setVisible(false);
//		this.actionBathAssign.setVisible(false);
		this.actionBathAssign.setEnabled(true);
		this.btnBathAssign.setIcon(EASResource.getIcon("imgTbtn_distribute"));
		this.actionViewAssign.setVisible(false);
		tblMain.getHead().getRow(0).getCell(tblMain.getColumnIndex("level.name")).setValue("供应商级别");
		tblMain.getHead().getRow(0).getCell(tblMain.getColumnIndex("quaLevel.name")).setValue("供应商等级");
		
		if(!SysContext.getSysContext().getCurrentOrgUnit().isIsPurchaseOrgUnit()){
			this.actionAddNew.setEnabled(false);
			this.actionEdit.setEnabled(false);
			this.actionRemove.setEnabled(false);
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
			this.actionMultiSubmit.setEnabled(false);
			this.actionImport.setEnabled(false);
			this.actionAddToSysSupplier.setEnabled(false);
			this.btnEditLevel.setEnabled(false);
		}
		
		if(SysContext.getSysContext().getCurrentUserInfo().getNumber().equals("ppl")){
			KDWorkButton btnUpdate=new KDWorkButton();
			btnUpdate.setText("数据升级（服务区域）");
//			this.toolBar.add(btnUpdate);
			btnUpdate.setIcon(EASResource.getIcon("imgTbtn_organiselist"));
			btnUpdate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
		                beforeActionPerformed(e);
		                try {
		                	btnUpdate_actionPerformed(e);
		                } catch (Exception exc) {
		                    handUIException(exc);
		                } finally {
		                    afterActionPerformed(e);
		                }
		            }
		        });
		}
		
		
		
		
		this.actionAttachment.setVisible(true);
		
	}
    protected String getEditUIModal() {
		return UIFactoryName.NEWTAB;
	}
	
    protected void btnUpdate_actionPerformed(ActionEvent e) throws Exception {
		if (FDCMsgBox.showConfirm2(this,"是否数据升级？") != MsgBox.OK) {
			return;
		}
		int m=0;
		FDCSQLBuilder sqlBuilder = new FDCSQLBuilder();
		sqlBuilder.appendSql("select fid from T_FDC_SupplierStock where FSplArea is null");
		IRowSet rs = sqlBuilder.executeQuery();
		SelectorItemCollection sel=new SelectorItemCollection();
		sel.add("supplierSplAreaEntry.fdcSplArea.name");
		
		SelectorItemCollection updatesel=new SelectorItemCollection();
		updatesel.add("splArea");
		while(rs.next()){
			String id=rs.getString("fid");
			String splArea="";
			DesignSupplierStockInfo info = DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(id),sel);
			for(int i=0;i<info.getSupplierSplAreaEntry().size();i++){
				if(info.getSupplierSplAreaEntry().get(i).getFdcSplArea()==null) continue;
				splArea=splArea+info.getSupplierSplAreaEntry().get(i).getFdcSplArea().getName()+";";
			}
			info.setSplArea(splArea);
			DesignSupplierStockFactory.getRemoteInstance().updatePartial(info, updatesel);
			m++;
		}
		FDCMsgBox.showInfo(this,m+"条供应商档案登记成功升级！");
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
	protected void kDSupplierTypeTree_valueChanged(TreeSelectionEvent e)
			throws Exception {
		super.kDSupplierTypeTree_valueChanged(e);
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
		this.refresh(null);
	}
	private FilterInfo getTreeFilter() throws Exception {
		FilterInfo filter = new FilterInfo();
    	FilterItemCollection filterItems = filter.getFilterItems();
    	DefaultKingdeeTreeNode TypeNode = this.getSelectedTreeNode(supplierTypeTree);
    	DefaultKingdeeTreeNode orgNode = this.getSelectedTreeNode(orgTree);
    	Object TypeInfo = null;
    	String orgName = null;
    	//是否选中
    	if(TypeNode != null && TypeNode.getUserObject() != null){
    		TypeInfo = TypeNode.getUserObject();
    	}
    	if (TypeInfo instanceof InviteTypeInfo) {
		    String longNumber = ((InviteTypeInfo)TypeInfo).getLongNumber();
			filterItems.add(new FilterItemInfo("inviteType.longNumber", longNumber+"%",CompareType.LIKE));
		}else{
			filterItems.add(new FilterItemInfo("id", null,CompareType.ISNOT));
		}
    	
    	if(orgNode.getUserObject() instanceof OrgStructureInfo){
    		SelectorItemCollection sel=new SelectorItemCollection();
    		sel.add("longNumber");
    		PurchaseOrgUnitInfo org=PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(((OrgStructureInfo)orgNode.getUserObject()).getUnit().getId()),sel);
    		String longNumber=org.getLongNumber();
    		filterItems.add(new FilterItemInfo("purchaseOrgUnit.longNumber", longNumber+"%",CompareType.LIKE));
    	}else{
    		filterItems.add(new FilterItemInfo("id", null,CompareType.ISNOT));
		}
    	filterItems.add(new FilterItemInfo("purchaseOrgUnit.id",OrgConstants.DEF_CU_ID));
    	
    	filter.setMaskString("(#0 and #1) or #2");
    	
    	return filter;
	}
	/**
	 * @description		查询
	 * @author			杜余		
	 * @createDate		2010-11-6
	 * @param	
	 * @return					
	 *	
	 * @version			EAS7.0
	 * @see						
	 */
	protected IQueryExecutor getQueryExecutor(IMetaDataPK queryPK,EntityViewInfo viewInfo) {
		try {
			FilterInfo filter = getTreeFilter();
			if(filter==null){
				filter = new FilterInfo();
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
		return super.getQueryExecutor(queryPK, viewInfo);
	}
	/**
	 * @description		核准
	 * @author			杜余		
	 * @createDate		2010-11-8
	 * @param	
	 * @return					
	 *	
	 * @version			EAS7.0
	 * @see						
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();
        IObjectPK pks[];
        IDesignSupplierStock  iSupplierStock = (IDesignSupplierStock)getBizInterface();
        String ids[] = CSUtils.getSelectRowFieldValue(tblMain, "id");
        if(ids.length == 1){
        	DesignSupplierStockInfo info = iSupplierStock.getDesignSupplierStockInfo(new ObjectUuidPK(ids[0]));
        	/*
        	 * 不是提交不能审核
        	 */
        	if(!info.getState().equals(SupplierStateEnum.SUBMIT)){
        		MsgBox.showWarning(this,getResource("notAudit"));
        		SysUtil.abort();
        	}
        }
        /*
         * 将id数组转成objectPK数组
         */
        pks = CSUtils.convertStringToObjectPK(ids);
        /*
         * 核准返回核准成功与否信息map
         */
        Map mapInfo = iSupplierStock.approve(pks);
        if(((Boolean)mapInfo.get("status")).booleanValue())
        {
            GeneralBatchLog log = (GeneralBatchLog)mapInfo.get("info");
            if(SwingUtilities.getWindowAncestor(this) instanceof KDFrame)
            {
                DlgGeneralBatch dlgLog = new DlgGeneralBatch((KDFrame)SwingUtilities.getWindowAncestor(this), log);
                dlgLog.setModal(true);
                dlgLog.show();
                dlgLog.dispose();
            }
            if(SwingUtilities.getWindowAncestor(this) instanceof KDDialog)
            {
                DlgGeneralBatch dlgLog = new DlgGeneralBatch((KDDialog)SwingUtilities.getWindowAncestor(this), log);
                dlgLog.setModal(true);
                dlgLog.show();
                dlgLog.dispose();
            }
        } else
        {
            CustomerSupplierException exception = new CustomerSupplierException(CustomerSupplierException.CSSP_MSGAPPROVE_PARTSUCCESS, new String[] {
                ""
            });
            MsgBox.showInfo(this, exception.getMessage());
        }
        refresh(null);
	}
	/**
	 * @description		反核准
	 * @author			杜余		
	 * @createDate		2010-11-8
	 * @param	
	 * @return					
	 *	
	 * @version			EAS7.0
	 * @see						
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
        checkSelected();
        IObjectPK pks[];
        IDesignSupplierStock iSupplierStock = (IDesignSupplierStock)getBizInterface();
        /*
         * 得到选中的id数组集合
         */
        String ids[] = CSUtils.getSelectRowFieldValue(tblMain, "id");
        /*
         * 只选中一条进行反核准时,判断状态能不能核准,避免弹出的框框不符合人机交互
         */
        if(ids.length == 1){
        	DesignSupplierStockInfo info = iSupplierStock.getDesignSupplierStockInfo(new ObjectUuidPK(ids[0]));
        	if(!info.getState().equals(SupplierStateEnum.APPROVE)){
        		MsgBox.showWarning(this,getResource("notUnAudit"));
        		SysUtil.abort();
        	}
        }
        pks = CSUtils.convertStringToObjectPK(ids);
        /*
         * 调用远程方法批量反核准,返回把核准成功与否的map
         */
        Map mapInfo = iSupplierStock.unApprove(pks);
        if(((Boolean)mapInfo.get("status")).booleanValue())
        {
            GeneralBatchLog log = (GeneralBatchLog)mapInfo.get("info");
            if(SwingUtilities.getWindowAncestor(this) instanceof KDFrame)
            {
                DlgGeneralBatch dlgLog = new DlgGeneralBatch((KDFrame)SwingUtilities.getWindowAncestor(this), log);
                dlgLog.setModal(true);
                dlgLog.show();
                dlgLog.dispose();
            }
            if(SwingUtilities.getWindowAncestor(this) instanceof KDDialog)
            {
                DlgGeneralBatch dlgLog = new DlgGeneralBatch((KDDialog)SwingUtilities.getWindowAncestor(this), log);
                dlgLog.setModal(true);
                dlgLog.show();
                dlgLog.dispose();
            }
        } else
        {
            CustomerSupplierException exception = new CustomerSupplierException(CustomerSupplierException.CSSP_MSGUNAPPROVE_PARTSUCCESS, new String[] {
                ""
            });
            MsgBox.showInfo(this, exception.getMessage());
        }
        refresh(null);
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
					UIContext uiContext = new UIContext(this);
    			    uiContext.put("ID", id.get(i).toString());
    			    DesignSupplierStockEditUI ui=(DesignSupplierStockEditUI) UIFactoryHelper.initUIObject(DesignSupplierStockEditUI.class.getName(), uiContext, null,OprtState.EDIT);
    			    SupplierStateEnum state = DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(((DesignSupplierStockInfo)ui.getEditData()).getId())).getState();
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
	public void actionImport_actionPerformed(ActionEvent e) throws Exception {
		DatataskCaller task = new DatataskCaller();
        task.setParentComponent(this);
        DatataskParameter param = new DatataskParameter();
        String solutionName = "eas.fdc.supplier.MarketSupplierStock";
        param.solutionName = solutionName;
        ArrayList paramList = new ArrayList();
        paramList.add(param);
        task.invoke(paramList, DatataskMode.UPDATE, true);
        this.refresh(null);
    }
	public void actionAddToSysSupplier_actionPerformed(ActionEvent e) throws Exception {
		UIContext uiContext = new UIContext(this);
		IUIWindow uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(DesignAddToSysSupplierUI.class.getName(), uiContext, null, OprtState.VIEW);
		uiWindow.show();
	}
	public void actionEditLevel_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();
		ArrayList id = getSelectedIdValues();
		UIContext uiContext = new UIContext(this);
		uiContext.put("id", id);
		IUIWindow uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(DesignSupplierLevelUI.class.getName(), uiContext, null, OprtState.VIEW);
		uiWindow.show();
		
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
        return com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo();
		
        return objectValue;
    }

	protected FDCDataBaseInfo getBaseDataInfo() {
		return new DesignSupplierStockInfo();
	}

}