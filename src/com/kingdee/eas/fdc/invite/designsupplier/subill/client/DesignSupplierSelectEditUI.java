/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.subill.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JLabel;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.KDTableHelper;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDContainer;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.org.OrgConstants;
import com.kingdee.eas.basedata.org.OrgStructureInfo;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitFactory;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.cp.bc.BizCollUtil;
import com.kingdee.eas.fdc.basedata.FDCSQLBuilder;
import com.kingdee.eas.fdc.basedata.OperationPhasesFactory;
import com.kingdee.eas.fdc.basedata.client.FDCClientVerifyHelper;
import com.kingdee.eas.fdc.invite.InviteTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSelectSupplierDBCollection;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSelectSupplierDBFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSelectSupplierDBInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockLinkPersonCollection;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockLinkPersonFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockSupplierSplAreaEntryInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationCollection;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationFactory;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationInfo;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectCollection;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectFactory;
import com.kingdee.eas.fdc.invite.designsupplier.uitls.WorkFlow;
import com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum;
import com.kingdee.eas.framework.client.ListUI;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class DesignSupplierSelectEditUI extends AbstractDesignSupplierSelectEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(DesignSupplierSelectEditUI.class);
    String ColumName[] = {"supplierCompany","peopleCfg","design","PostService","Pro","price"};
    /**
     * output class constructor
     */
    public DesignSupplierSelectEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        if(this.kdtEntrys.getRowCount()>0){
        	this.kdtEntrys.getRow(0).getStyleAttributes().setBackground(Color.green);
        	this.kdtEntrys.getCell(0, "supplier").getStyleAttributes().setLocked(true);
        }
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    public void onLoad() throws Exception {
    	this.pkauditDate.setEnabled(false);
    	this.txtsupplierName.setEnabled(false);
    	this.txtDesignType.setEnabled(false);
    	this.txtServiceArea.setEnabled(false);
    	this.prmtsupplierLv.setEnabled(false);
    	this.txtAuthorizedPer.setEnabled(false);
    	this.txtAuthorizedTel.setEnabled(false);
    	this.txtJob.setEnabled(false);
    	super.onLoad();
    	initF7();
    	initButtonAction();
    	initControl();
    	initTable();
    	
    	this.chkMenuItemSubmitAndAddNew.setSelected(false);
    	this.chkMenuItemSubmitAndAddNew.setEnabled(false);
    }
    
    private void initF7(){
    	this.prmtPro.setQueryInfo("com.kingdee.eas.fdc.basedata.app.F7OperationPhasesQuery");	
    	this.prmtsupplierLv.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.designbase.app.DesignGradeSetUpQuery");
    	EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		Set org=new HashSet();
		if(editData.getOrg()!=null){
			org.add(editData.getOrg().getId().toString());
		}
		org.add(OrgConstants.DEF_CU_ID);
		filter.getFilterItems().add(new FilterItemInfo("state",Integer.valueOf(SupplierStateEnum.APPROVE_VALUE)));
		filter.getFilterItems().add(new FilterItemInfo("purchaseOrgUnit.id",org,CompareType.INCLUDE));
		filter.getFilterItems().add(new FilterItemInfo("isPass",Integer.valueOf(ResultsEnum.YL_VALUE),CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("isPass",Integer.valueOf(ResultsEnum.HG_VALUE),CompareType.EQUALS));
		filter.setMaskString("#0 and #1 and (#2 or #3)");
		view.setFilter(filter);
		this.prmtsupplierNumber.setEntityViewInfo(view);
		
		view = new EntityViewInfo();
		filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("isEnabled",Boolean.TRUE));
		view.setFilter(filter);
		this.prmtsupplierLv.setEntityViewInfo(view);
		
		Set<String> set = new HashSet<String>();
		String longNumber = "";
		try {
			String sql =  "SELECT FLONGNUMBER FROM T_ORG_CtrlUnit WHERE FID='"+editData.getOrg().getId().toString()+"'";
			IRowSet rowSet = new FDCSQLBuilder().appendSql(sql).executeQuery();
			while(rowSet.next()){
				longNumber = rowSet.getString("FLONGNUMBER")+"%";
				break;
			}
			StringBuffer sb = new StringBuffer();
			sb.append("/*dialect*/ select distinct a.fid phassId from T_BD_OperationPhases a");
			sb.append(" left join T_FDC_ProjectBase b on b.fid=a.FProjectBaseID");
			sb.append(" left join t_org_ctrlunit c on c.fid=b.FEngineeProjectID");
			sb.append(" where c.flongnumber like '"+longNumber+"%'");
			IRowSet rowSetL = new FDCSQLBuilder().appendSql(sb.toString()).executeQuery();
			while(rowSetL.next()){
				set.add(rowSetL.getString("phassId"));
			}
			view = new EntityViewInfo();
			filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
			view.setFilter(filter);
			this.prmtPro.setEntityViewInfo(view);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
    }
    
    private void initButtonAction(){
    	this.actionAddNew.setVisible(false);//新增
		this.actionRemove.setVisible(false);//删除
		this.actionCopy.setVisible(false);//复制新增
    	this.actionPrint.setVisible(false);//打印
    	this.actionPrintPreview.setVisible(false);//打印预览
		this.actionCreateTo.setVisible(false);//推式生成
		this.actionCreateFrom.setVisible(false);//拉式生成
		this.actionTraceUp.setVisible(false);//上查
		this.actionTraceDown.setVisible(false);//下查 
		this.actionFirst.setVisible(false);//第一
		this.actionPre.setVisible(false);//前一
		this.actionNext.setVisible(false);//后一
		this.actionLast.setVisible(false);//最后一个
		this.contstate.setVisible(false);
		this.contDesignTypeID.setVisible(false);
		this.txtNumber.setRequired(true);
		this.prmtsupplierNumber.setRequired(true);
		this.prmtsupplierLv.setRequired(true);
		this.pkBizDate.setRequired(true);
    }
    
    private void initControl() throws BOSException{
    	this.contLastUpdateUser.setVisible(true);
    	this.contLastUpdateTime.setVisible(true);
        kDContainer1.getContentPane().add(kdtEntrys, BorderLayout.CENTER);
        contOrg.setVisible(false);
        prmtOrg.setVisible(false);
        prmtInvTyep.setVisible(false);
        contDesignTypeID.setVisible(false);
        contDescription.setVisible(false);
        this.prmtPro.setRequired(true);
        this.contsupplierName.getBoundLabel().setForeground(Color.RED);
//        for (int i = 0; i < ColumName.length; i++) {
//    		this.kdtEntrys.getColumn(ColumName[i]).setRequired(true);
//		}
        this.actionSave.setEnabled((OprtState.ADDNEW.equals(getOprtState()))?true:false);
    }
    
    private void initTable(){
    	for (int i = 0; i < kdtEntrys.getRowCount(); i++) {
        	KDTableHelper.autoFitRowHeight(this.kdtEntrys, i);
		}
    	for (int i = 0; i < kdtEntrys.getColumnCount(); i++) {
        	this.kdtEntrys.getColumn(i).getStyleAttributes().setWrapText(true);
		}
    	initProWorkButton(this.kDContainer1, false);
//    	this.kdtEntrys.getColumn("supplier").setRequired(true);
//    	this.kdtEntrys.getColumn("supplierLv").setRequired(true);
    	
    	EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		Set org=new HashSet();
		if(editData.getOrg()!=null){
			org.add(editData.getOrg().getId().toString());
		}
		org.add(OrgConstants.DEF_CU_ID);
		filter.getFilterItems().add(new FilterItemInfo("state",Integer.valueOf(SupplierStateEnum.APPROVE_VALUE)));
		filter.getFilterItems().add(new FilterItemInfo("isPass",Integer.valueOf(ResultsEnum.YL_VALUE),CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("isPass",Integer.valueOf(ResultsEnum.HG_VALUE),CompareType.EQUALS));
		filter.setMaskString("#0 and (#1 or #2)");
		view.setFilter(filter);
    	KDBizPromptBox kdtEntrys_supplier_PromptBox = new KDBizPromptBox();
        kdtEntrys_supplier_PromptBox.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.app.DesignSupplierStockQuery");
        kdtEntrys_supplier_PromptBox.setVisible(true);
        kdtEntrys_supplier_PromptBox.setEditable(true);
        kdtEntrys_supplier_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_supplier_PromptBox.setEditFormat("$number$");
        kdtEntrys_supplier_PromptBox.setCommitFormat("$number$");
        kdtEntrys_supplier_PromptBox.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtEntrys_supplier_CellEditor = new KDTDefaultCellEditor(kdtEntrys_supplier_PromptBox);
        this.kdtEntrys.getColumn("supplier").setEditor(kdtEntrys_supplier_CellEditor);
        ObjectValueRender kdtEntrys_supplier_OVR = new ObjectValueRender();
        kdtEntrys_supplier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("supplier").setRenderer(kdtEntrys_supplier_OVR);
        this.kdtEntrys.getColumn("supplierLv").getStyleAttributes().setLocked(true);
        
        KDFormattedTextField kdtEentry_Achievement_TextField = new KDFormattedTextField();
        kdtEentry_Achievement_TextField.setName("kdtEentry_Achievement_TextField");
        kdtEentry_Achievement_TextField.setVisible(true);
        kdtEentry_Achievement_TextField.setEditable(true);
        kdtEentry_Achievement_TextField.setHorizontalAlignment(2);
        kdtEentry_Achievement_TextField.setDataType(1);
        	kdtEentry_Achievement_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEentry_Achievement_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEentry_Achievement_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEentry_Achievement_CellEditor = new KDTDefaultCellEditor(kdtEentry_Achievement_TextField);
        this.kdtEntrys.getColumn("price").setEditor(kdtEentry_Achievement_CellEditor);
        
        this.kdtEntrys.getHeadRow(0).getCell("price").setValue("合同总价");
    }
    
    protected void kdtEntrys_editStopped(KDTEditEvent e) throws Exception {
    	super.kdtEntrys_editStopped(e);
    	if(e.getRowIndex()==-1)
    		return;
		KDTableHelper.autoFitRowHeight(this.kdtEntrys, e.getRowIndex());
		for (int i = 0; i < this.kdtEntrys.getRowCount(); i++) {
			if(e.getRowIndex()!=i){
				String suId = (UIRuleUtil.isNotNull(this.kdtEntrys.getCell(e.getRowIndex(), "supplier").getValue()))
				?((DesignSupplierStockInfo)this.kdtEntrys.getCell(e.getRowIndex(), "supplier").getValue()).getId().toString():"";
				String lastId = (UIRuleUtil.isNotNull(this.kdtEntrys.getCell(i, "supplier").getValue()))
				?((DesignSupplierStockInfo)this.kdtEntrys.getCell(i, "supplier").getValue()).getId().toString():"";
				if(!"".equals(suId)&&suId.equals(lastId)){
					IRow row = this.kdtEntrys.getRow(e.getRowIndex());
					this.kdtEntrys.getCell(e.getRowIndex(), "supplier").setValue(null);
					row.getCell("supplierCompany").setValue(null);
					row.getCell("peopleCfg").setValue(null);
					row.getCell("design").setValue(null);
					row.getCell("PostService").setValue(null);
					row.getCell("Pro").setValue(null);
					row.getCell("price").setValue(null);
					row.getCell("supplierLv").setValue(null);
					MsgBox.showWarning("当前所选邀约供应商与表体原有数据重复，请重新选择！");SysUtil.abort();
				}
			}
		}
		if(this.kdtEntrys.getColumn(e.getColIndex()).getKey().equals("supplier")&&UIRuleUtil.isNotNull(this.kdtEntrys.getCell(e.getRowIndex(), "supplier").getValue())){
			String suId = ((DesignSupplierStockInfo)this.kdtEntrys.getCell(e.getRowIndex(), "supplier").getValue()).getId().toString();
			SelectorItemCollection sel = new SelectorItemCollection();
			sel.add("gatadeLv.*");
			DesignSupplierStockInfo info = DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(suId),sel);
			if(info.getGatadeLv()!=null)
				this.kdtEntrys.getCell(e.getRowIndex(), "supplierLv").setValue(info.getGatadeLv());
			else
				this.kdtEntrys.getCell(e.getRowIndex(), "supplierLv").setValue(info.getGatadeLv());
			String DbOql = "select * where DesignSupplierId='"+suId+"'";
			DesignSelectSupplierDBCollection dbColl = DesignSelectSupplierDBFactory.getRemoteInstance().getDesignSelectSupplierDBCollection(DbOql);
			IRow row = this.kdtEntrys.getRow(e.getRowIndex());
			if(dbColl.size()>0){
				DesignSelectSupplierDBInfo Info = dbColl.get(0);
				row.getCell("supplierCompany").setValue(Info.getSupplierCompany());
				row.getCell("peopleCfg").setValue(Info.getPeopleCfg());
				row.getCell("design").setValue(Info.getDesign());
				row.getCell("PostService").setValue(Info.getPostService());
				row.getCell("Pro").setValue(Info.getPro());
				row.getCell("price").setValue(Info.getPrice());
			}else if(!(e.getOldValue()!=null?((DesignSupplierStockInfo)e.getOldValue()).getId().toString():"")
					.equals(e.getValue()!=null?((DesignSupplierStockInfo)e.getValue()).getId().toString():"")){
				row.getCell("supplierCompany").setValue(null);
				row.getCell("peopleCfg").setValue(null);
				row.getCell("design").setValue(null);
				row.getCell("PostService").setValue(null);
				row.getCell("Pro").setValue(null);
				row.getCell("price").setValue(null);
			}
		}
    }
    
    protected void verifyInputForSubmit() throws Exception {
    	verifyInputForSave();
    	FDCClientVerifyHelper.verifyInput(this, this.kdtEntrys, "supplier");
    	FDCClientVerifyHelper.verifyInput(this, this.kdtEntrys, "supplierLv");
    	BOSUuid Id = ((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue()).getId();
    	if(this.prmtsupplierNumber.getValue()!=null){
    		BOSUuid GradeId = ((DesignGradeSetUpInfo)this.prmtsupplierLv.getValue()).getId();
    		DesignGradeSetUpInfo desetUpInfo = DesignGradeSetUpFactory.getRemoteInstance().getDesignGradeSetUpInfo(new ObjectUuidPK(GradeId));
    		DesignSupplierStockInfo info = DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(Id));
	    	if(!"00000000-0000-0000-0000-000000000000CCE7AED4".equals(info.getPurchaseOrgUnit().getId().toString())){
				String oql = "select id where supplierNumber.id='"+info.getId().toString()+"' and state='7' and supplierlastClas.id='"+GradeId+"'";
				oql += (editData.getId()!=null)?" and id<>'"+editData.getId().toString()+"'":"";
				DesignSupplierEvaluationCollection desColl = DesignSupplierEvaluationFactory.getRemoteInstance().getDesignSupplierEvaluationCollection(oql);
				if(desColl.size()<1){
					MsgBox.showWarning("当前供应商未做["+desetUpInfo.getName()+"]评定！");SysUtil.abort();
				}
			}
	    	
	    	InviteTypeInfo typeInfo = null;
	    	if(this.prmtInvTyep.getValue()!=null)
	    		typeInfo = (InviteTypeInfo)this.prmtInvTyep.getValue();
	    	if(desetUpInfo.getNumber().equals("001")&&typeInfo.getName().indexOf("其他")==-1){
	    		if(this.kdtEntrys.getRowCount()<3){
	    			MsgBox.showWarning("非战略供应商（主要）选用需邀约3家合格或战略供应商进行比选，请录入表体邀约信息!");SysUtil.abort();
	    		}
	    		if(typeInfo.getName().indexOf("建筑")!=-1 || typeInfo.getName().indexOf("景观")!=-1 || typeInfo.getName().indexOf("室内")!=-1){
	    			boolean hashZL = false;//是否含战略供应商
	    			for (int i = 0; i < kdtEntrys.getRowCount(); i++) {
	    				IRow row = kdtEntrys.getRow(i);
	    				if(row.getStyleAttributes().getBackground().equals(Color.green))
	    					continue;
	    				DesignSupplierStockInfo supplier = (DesignSupplierStockInfo)row.getCell("supplier").getValue();
	    				DesignGradeSetUpInfo  grade = DesignGradeSetUpFactory.getRemoteInstance().getDesignGradeSetUpInfo(new ObjectUuidPK(supplier.getGatadeLv().getId()));
	    				if(supplier!=null && grade.getName().indexOf("战略")!=-1){
	    					hashZL = true;
	    				}
					}
	    			if(!hashZL)
	    			{
	    				MsgBox.showWarning("建筑、室内、景观类供应商,邀约其他两家比选时其中一家必须为战略供方，请重新选择供应商!");SysUtil.abort();
	    			}
	    		}
	    	}
	    	for (int i = 0; i < ColumName.length; i++) {
	    		FDCClientVerifyHelper.verifyInput(this, this.kdtEntrys, ColumName[i]);
	    	}
    	}
    }
    
    protected void verifyInputForSave() throws Exception {
    	FDCClientVerifyHelper.verifyEmpty(this, this.txtNumber);
    	FDCClientVerifyHelper.verifyEmpty(this, this.prmtPro);
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtsupplierNumber);
		FDCClientVerifyHelper.verifyEmpty(this, this.pkBizDate);
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtsupplierLv);
    }
    
    protected void initProWorkButton(KDContainer container,boolean flse){
    	KDWorkButton btnAddRowinfo=new KDWorkButton();
    	KDWorkButton btnDeleteRowinfo=new KDWorkButton();
    	btnAddRowinfo.setEnabled((OprtState.EDIT.equals(getOprtState())||OprtState.ADDNEW.equals(getOprtState()))?true:false);
    	btnDeleteRowinfo.setEnabled((OprtState.EDIT.equals(getOprtState())||OprtState.ADDNEW.equals(getOprtState()))?true:false);
    	btnAddRowinfo.setIcon( EASResource.getIcon("imgTbtn_addline"));
    	container.addButton(btnAddRowinfo);
		btnAddRowinfo.setText(getResource("addRow"));
		btnAddRowinfo.setSize(new Dimension(140, 19));
		btnAddRowinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	try {
					kdtEntrys_detailPanel.actionAddnewLine_actionPerformed(e);
					if(kdtEntrys.getRowCount()>0){
						kdtEntrys.getRow(0).getStyleAttributes().setBackground(Color.green);
						kdtEntrys.getCell(0, "supplier").getStyleAttributes().setLocked(true);
			        }
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        });
		btnDeleteRowinfo.setIcon( EASResource.getIcon("imgTbtn_addline"));
    	container.addButton(btnDeleteRowinfo);
		btnDeleteRowinfo.setText(getResource("deleteRow"));
		btnDeleteRowinfo.setSize(new Dimension(140, 19));
		btnDeleteRowinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	try {
            		if(kdtEntrys.getSelectManager().getActiveRowIndex()==0){
            			MsgBox.showWarning("不能删除当前选用供应商信息！");SysUtil.abort();
            		}
            		kdtEntrys_detailPanel.actionRemoveLine_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        });
    }
    
    public void prmtsupplierNumber_Changed() throws Exception {
    	super.prmtsupplierNumber_Changed();
    	if(this.prmtsupplierNumber.getValue()!=null){
    		BOSUuid Id = ((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue()).getId();
    		DesignSupplierStockInfo info = DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(Id));
    		String oqls = "select id where supplierNumber.id='"+info.getId().toString()+"' and state='7' ";
    		DesignSupplierEvaluationCollection selectColl = DesignSupplierEvaluationFactory.getRemoteInstance().getDesignSupplierEvaluationCollection(oqls);
    		if(selectColl.size()<1){
    			this.prmtsupplierNumber.setValue(null);
    			MsgBox.showWarning("当前供应商未做评定流程或评定流程未审批，请重新选择！");SysUtil.abort();
    		}
    		DesignGradeSetUpInfo setUpInfo = null;
    		if(info.getGatadeLv()!=null){
    			setUpInfo = DesignGradeSetUpFactory.getRemoteInstance().getDesignGradeSetUpInfo(new ObjectUuidPK(info.getGatadeLv().getId()));
				this.prmtsupplierLv.setValue(setUpInfo);
			}else{
				this.prmtsupplierLv.setValue(null);
			}
    		String selectOql = "select * where supplierNumber.id='"+Id.toString()+"' and state='7' ";
    		selectOql += (editData.getId()!=null)?"and id<>'"+editData.getId().toString()+"' order by createTime desc":" order by createTime desc";
    		DesignSupplierSelectCollection designSelectColl = DesignSupplierSelectFactory.getRemoteInstance().getDesignSupplierSelectCollection(selectOql);
    		if(designSelectColl.size()>0){
    			if(designSelectColl.get(0).getPro()!=null&&this.prmtPro.getValue()==null)
    				this.prmtPro.setValue(OperationPhasesFactory.getRemoteInstance().getOperationPhasesInfo(new ObjectUuidPK(designSelectColl.get(0).getPro().getId())));
    		}
    		InviteTypeInfo InvTypeInfo = com.kingdee.eas.fdc.invite.InviteTypeFactory.getRemoteInstance().getInviteTypeInfo(new ObjectUuidPK(info.getInviteType().getId()));
    		PurchaseOrgUnitInfo PurchaseOrginfo = PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(info.getPurchaseOrgUnit().getId()));
    		this.txtsupplierName.setText(info.getName());
    		this.prmtInvTyep.setValue(InvTypeInfo);
    		this.txtDesignTypeID.setText(InvTypeInfo.getId().toString());
    		this.txtDesignType.setText(InvTypeInfo.getName());
    		this.prmtOrg.setValue(PurchaseOrginfo);
    		String entryOql = "select * where parent.id ='"+Id.toString()+"' and isDefault='1'";
			DesignSupplierStockLinkPersonCollection entryColl = DesignSupplierStockLinkPersonFactory.getRemoteInstance().getDesignSupplierStockLinkPersonCollection(entryOql);
			if(entryColl.size()>0){
				this.txtAuthorizedPer.setText(entryColl.get(0).getPersonName());
				this.txtAuthorizedTel.setText(entryColl.get(0).getPhone());
				this.txtJob.setText(entryColl.get(0).getPosition());
			}else{
				this.txtAuthorizedPer.setText(null);
				this.txtAuthorizedTel.setText(null);
				this.txtJob.setText(null);
			}
    		String area = "";
    		for (int i = 0; i < info.getSupplierSplAreaEntry().size(); i++) {
    			DesignSupplierStockSupplierSplAreaEntryInfo entryInfo = info.getSupplierSplAreaEntry().get(i);
    			DesignServiceAreaInfo AreaInfo = DesignServiceAreaFactory.getRemoteInstance().getDesignServiceAreaInfo(new ObjectUuidPK(entryInfo.getFdcSplArea().getId())) ;
    			if("".equals(area.trim()))
    				area += AreaInfo.getName();
    			else
    				area += ";"+AreaInfo.getName();
			}
    		this.txtServiceArea.setText(area);
    		this.kdtEntrys.removeRows();
    		String DbOql = "select * where DesignSupplierId='"+Id.toString()+"'";
			DesignSelectSupplierDBCollection dbColl = DesignSelectSupplierDBFactory.getRemoteInstance().getDesignSelectSupplierDBCollection(DbOql);
			if(dbColl.size()>0){
				DesignSelectSupplierDBInfo Info = dbColl.get(0);
				IRow row = this.kdtEntrys.addRow();
				row.getCell("supplier").setValue(info);
				row.getCell("supplierLv").setValue(setUpInfo);
				row.getCell("supplierCompany").setValue(Info.getSupplierCompany());
				row.getCell("peopleCfg").setValue(Info.getPeopleCfg());
				row.getCell("design").setValue(Info.getDesign());
				row.getCell("PostService").setValue(Info.getPostService());
				row.getCell("Pro").setValue(Info.getPro());
				row.getCell("price").setValue(Info.getPrice());
			}else{
				IRow row = this.kdtEntrys.addRow();
				row.getCell("supplier").setValue(info);
				row.getCell("supplierLv").setValue(setUpInfo);
			}
			if(kdtEntrys.getRowCount()>0){
				kdtEntrys.getRow(0).getStyleAttributes().setBackground(Color.green);
				this.kdtEntrys.getCell(0, "supplier").getStyleAttributes().setLocked(true);
	        }
    	}
    }
    
    public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
    	if(!this.state.getSelectedItem().equals(SupplierStateEnum.SAVE)&&!this.state.getSelectedItem().equals(SupplierStateEnum.SUBMIT)){
    		MsgBox.showWarning("当前单据已["+this.state.getSelectedItem().toString()+"]，不能修改！");SysUtil.abort();
    	}
    	if(editData.getId()!=null)
    		WorkFlow.checkBillInWorkflow(this, editData.getId().toString());
    	super.actionEdit_actionPerformed(arg0);
    	this.actionSave.setEnabled((OprtState.ADDNEW.equals(getOprtState()))?true:false);
    	kDContainer1.removeAllButton();
    	initProWorkButton(this.kDContainer1, false);
    }
    
    private String getResource(String msg) {
		return EASResource.getString("com.kingdee.eas.fdc.invite.supplier.SupplierResource", msg);
	}
    
    public void actionSave_actionPerformed(ActionEvent e) throws Exception {
    	verifyInputForSave();
    	super.actionSave_actionPerformed(e);
    }
    
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
    	verifyInputForSubmit();
    	super.actionSubmit_actionPerformed(e);
    	setOprtState(OprtState.VIEW);
    	if (getOprtState().equals(OprtState.ADDNEW) || getOprtState().equals(OprtState.EDIT))
			((ListUI) getUIContext().get(UIContext.OWNER)).getMainTable().removeRows();
    }

    protected void afterSubmitAddNew(){
    }
	protected boolean isContinueAddNew() {
		return false;
	}
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setState(SupplierStateEnum.SAVE);
        if(getUIContext().get("org")!=null){
			try {
				PurchaseOrgUnitInfo orgUnitInfo = PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(((OrgStructureInfo) getUIContext().get("org")).getUnit().getId()));
				objectValue.setOrg(orgUnitInfo);
				objectValue.setPusOrg(orgUnitInfo);
			} catch (EASBizException e) {
				e.printStackTrace();
			} catch (BOSException e) {
				e.printStackTrace();
			}
		}
        return objectValue;
    }

}