/**
 * output package name
 */
package com.kingdee.eas.custom.funds.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.AbstractPrintIntegrationInfo;
import com.kingdee.eas.basedata.assistant.IPrintIntegration;
import com.kingdee.eas.basedata.assistant.PrintIntegrationFactory;
import com.kingdee.eas.basedata.assistant.util.CommonPrintIntegrationDataProvider;
import com.kingdee.eas.basedata.assistant.util.PrintIntegrationManager;
import com.kingdee.eas.basedata.master.cssp.client.F7CustomerSimpleSelector;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.ICompanyOrgUnit;
import com.kingdee.eas.basedata.org.IPositionMember;
import com.kingdee.eas.basedata.org.OrgConstants;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.PositionMemberCollection;
import com.kingdee.eas.basedata.org.PositionMemberFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyBizUnitF7;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.person.client.PersonPromptBox;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.funds.BizState;
import com.kingdee.eas.fdc.sellhouse.ISellProject;
import com.kingdee.eas.fdc.sellhouse.SellProjectCollection;
import com.kingdee.eas.fdc.sellhouse.SellProjectFactory;
import com.kingdee.eas.fdc.sellhouse.SellProjectInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.hr.emp.client.EmployeeMultiF7PromptBox;
import com.kingdee.eas.scm.common.util.MultiDataSourceDataProviderProxy;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.ExtendParser;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.BeforeActionEvent;
import com.kingdee.bos.ctrl.kdf.table.event.BeforeActionListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper;
import com.kingdee.bos.ctrl.reportone.kdrs.exception.KDRSException;
import com.kingdee.bos.ctrl.swing.KDComboBox;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDPromptBox;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class ReceiptionEditUI extends AbstractReceiptionEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(ReceiptionEditUI.class);
    
    /**
     * output class constructor
     */
    public ReceiptionEditUI() throws Exception
    {
        super();
    }
    
    @Override
    public void onLoad() throws Exception {
    	initComponent();
    	super.onLoad();
    	setUITitle("收据");
    	//项目带出公司
    	prmtproject.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(prmtproject.getValue() != null) {
					SellProjectInfo sellProject = (SellProjectInfo) prmtproject.getValue();
					try {
						ICompanyOrgUnit iCompanyOrgUnit = CompanyOrgUnitFactory.getRemoteInstance();
						CompanyOrgUnitInfo company = sellProject.getCompanyOrgUnit();
						company = iCompanyOrgUnit.getCompanyOrgUnitInfo(new ObjectUuidPK(company.getId()));
						prmtcompany.setValue(company);
					} catch (BOSException e) {
						e.printStackTrace();
					} catch (EASBizException e) {
						e.printStackTrace();
					}
				}
			}
    	});
    	
    	//分录删除后触发计算合计
    	kdtEntrys.addAfterActionListener(new BeforeActionListener() {
			@Override
			public void beforeAction(BeforeActionEvent args) {
				if(args.getType() == args.ACTION_REMOVE_ROW) {
					double sum = UIRuleUtil.sum(kdtEntrys, "recAmount");
			    	txtsum.setValue(sum);
				}
			}
    	});
    	
    	payUnitType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosePayUnitComponent(payUnitType);
			}
    	});
    	
    	CompanyBizUnitF7 f7 = new CompanyBizUnitF7(this);
		f7.showCheckBoxOfShowingAllOUs();
		f7.setIsCUFilter(false);
		f7.setRootUnitID(OrgConstants.DEF_CU_ID);
		f7.disablePerm();
		prmtpayUnit.setSelector(f7);		
		
		if(BizState.audited.equals(editData.getBizState())) {
        	btnAudit.setVisible(false);
        	btnUnAudit.setVisible(true);
        } else {
        	btnAudit.setVisible(true);
        	btnUnAudit.setVisible(false);
        }
        if(!editData.getBizState().equals(BizState.addnew) && !editData.getBizState().equals(BizState.saved)) 
        	btnSave.setEnabled(false);
        if(editData.getBizState().equals(BizState.auditing)) {
        	btnSave.setEnabled(false);
        	btnSubmit.setEnabled(false);
        }
//		EmployeeMultiF7PromptBox personF7 = new EmployeeMultiF7PromptBox();
//		prmtrecPerson.setSelector(personF7);
        
        //项目过滤
//		prmtproject.setQueryInfo("com.kingdee.eas.fdc.basedata.app.F7ProjectForAssActQuery");
        AdminOrgUnitInfo adminOrgUnitInfo  = SysContext.getSysContext().getCurrentAdminUnit();
        EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        evi.setFilter(filter);
        filter.getFilterItems().add(new FilterItemInfo("CompanyOrgUnit.longnumber", adminOrgUnitInfo.getLongNumber()+"%", CompareType.LIKE));
        prmtproject.setEntityViewInfo(evi);
        //收款人过滤
//        Set personIds = getPersonIds(null, adminOrgUnitInfo.getId().toString());
//        evi = new EntityViewInfo();
//        filter = new FilterInfo();
//        evi.setFilter(filter);
//        filter.getFilterItems().add(new FilterItemInfo("id", personIds, CompareType.INCLUDE));
//        prmtrecPerson.setEntityViewInfo(evi);
        
//		EmployeeMultiF7PromptBox personF7 = new EmployeeMultiF7PromptBox();
//		prmtrecPerson.setSelector(personF7);
        HashMap map = new HashMap();
		map.put("All_Admins", "YES");
		map.put("DEFAULT_SHOW_ALL", "YES");
		PersonPromptBox select = new PersonPromptBox(this, map);
		prmtrecPerson.setSelector(select);
//		prmtrecPerson.setHasCUDefaultFilter(false);
		
//		F7CustomerSimpleSelector customer = new F7CustomerSimpleSelector(this, prmtcustomer);
//		prmtcustomer.setSelector(customer);
		
		choosePayUnitComponent(payUnitType);
		setTxtOther(prmtpayUnit);
		setTxtOther(prmtcustomer);
		setTxtOther(prmtemployee);
		
		kdtEntrys.getColumn("recType").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.CENTER);
		kdtEntrys.getColumn("settlementType").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.CENTER);
		kdtEntrys.getColumn("recAmount").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		
		//设置分录金额保留两位小数
        KDFormattedTextField kdtEntrys_amount_TextField = new KDFormattedTextField();
        kdtEntrys_amount_TextField.setName("kdtEntrys_amount_TextField");
        kdtEntrys_amount_TextField.setVisible(true);
        kdtEntrys_amount_TextField.setEditable(true);
        kdtEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtEntrys_amount_TextField.setDataType(1);
        kdtEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        kdtEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_amount_TextField.setPrecision(2);
        //收款金额列按下回车键的话新增一行
        kdtEntrys_amount_TextField.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					kdtEntrys.addRow();
			}
			public void keyReleased(KeyEvent e) {
			}
			public void keyTyped(KeyEvent e) {
			}
        });
        KDTDefaultCellEditor kdtEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_amount_TextField);
        this.kdtEntrys.getColumn("recAmount").setEditor(kdtEntrys_amount_CellEditor);
    }
    
    //根据类型确定显示哪个交款单位控件
    private void choosePayUnitComponent(KDComboBox type) {
    	switch (type.getSelectedIndex()) {
		case 0://公司
			prmtpayUnit.setVisible(true);
			prmtcustomer.setVisible(false);
			prmtemployee.setVisible(false);
			prmtsupplier.setVisible(false);
			txtother.setVisible(false);
			break;
		case 1://客户
			prmtpayUnit.setVisible(false);
			prmtcustomer.setVisible(true);
			prmtemployee.setVisible(false);
			prmtsupplier.setVisible(false);
			txtother.setVisible(false);
			break;
		case 2://员工
			prmtpayUnit.setVisible(false);
			prmtcustomer.setVisible(false);
			prmtemployee.setVisible(true);
			prmtsupplier.setVisible(false);
			txtother.setVisible(false);
			break;
		case 3://供应商
			prmtpayUnit.setVisible(false);
			prmtcustomer.setVisible(false);
			prmtemployee.setVisible(false);
			prmtsupplier.setVisible(true);
			txtother.setVisible(false);
			break;
		case 4://其他
			prmtpayUnit.setVisible(false);
			prmtcustomer.setVisible(false);
			prmtemployee.setVisible(false);
			txtother.setVisible(true);
			prmtsupplier.setVisible(false);
			break;
		default:
			break;
		}
	}

    //设置交款单位的名称到txtother控件
    private void setTxtOther(final KDPromptBox prmt) {
    	prmt.addDataChangeListener(new DataChangeListener() {
			@Override
			public void dataChanged(DataChangeEvent event) {
				CoreBaseInfo info = (CoreBaseInfo) prmt.getValue();
				if(info != null) {
					String name = info.get("name").toString();
					txtother.setText(name);
				}
			}
    	});
    }
    //检查是否可以打印(已审批的才能打印)
    private void checkCanPrint() {
    	if(editData.getBizState() != BizState.audited) {
    		MsgBox.showWarning("收据未审批不能打印!");
    		SysUtil.abort();
    	}
    }
    private void initComponent() {
    	bizState.setVisible(false);
    	contDescription.setVisible(false);
    	contCreateTime.setVisible(false);
    	contCreator.setVisible(false);
    	contbizState.setVisible(false);
    	contauditDate.setEnabled(false);
    	contcompany.setEnabled(false);
    	contNumber.setEnabled(false);
    	contAuditor.setVisible(false);
    	contauditDate.setVisible(false);
    	
    	btnNext.setVisible(false);
    	btnPre.setVisible(false);
    	btnFirst.setVisible(false);
    	btnLast.setVisible(false);
    	btnTraceUp.setVisible(false);
    	btnTraceDown.setVisible(false);
    	btnCreateFrom.setVisible(false);
    	btnCreateTo.setVisible(false);
    	
    	prmtpayUnit.setRequired(true);
    	prmtcustomer.setRequired(true);
    	prmtemployee.setRequired(true);
    	prmtsupplier.setRequired(true);
    	txtother.setRequired(true);
    	prmtproject.setRequired(true);
    	prmtrecPerson.setRequired(true);
    	
    	prmtAuditor.setDisplayFormat("$name$");
    	prmtcompany.setDisplayFormat("$Description$");
    	btnAudit.setIcon(EASResource.getIcon("imgTbtn_auditing"));
    	btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_fauditing"));
    	
    	toolBar.addComponentAfterComponent(btnAudit, btnSubmit);
    	toolBar.addComponentAfterComponent(btnUnAudit, btnAudit);
    	
    }
    
    @Override
    protected void verifyInput(ActionEvent actionevent) throws Exception {
    	super.verifyInput(actionevent);
    	verifyPayUnit(payUnitType);
//    	verifyF7(prmtpayUnit,"交款单位");
    	verifyF7(prmtproject,"项目名称");
    	verifyF7(prmtrecPerson,"收款人");
    }
    
    private void verifyF7(KDPromptBox prmt, String msg) {
    	if(prmt == null || prmt.getValue() == null) {
    		MsgBox.showWarning(msg + "不能为空!");
    		SysUtil.abort();
    	}
    }
    
    //根据交款单位类型判断对应的控件是否为空
    private void verifyPayUnit(KDComboBox payUnitType) {
    	switch (payUnitType.getSelectedIndex()) {
    	case 0://公司
    		verifyF7(prmtpayUnit, "交款单位(公司)");
			break;
		case 1://客户
			verifyF7(prmtcustomer, "交款单位(客户)");
			break;
		case 2://员工
			verifyF7(prmtemployee, "交款单位(员工)");
			break;
		case 3://供应商
			verifyF7(prmtsupplier, "交款单位(供应商)");
			break;
		case 4://其他
			if(txtother.getText() == null || txtother.getText().trim().length() == 0) {
				MsgBox.showWarning("交款单位(其他)不能为空!");
				SysUtil.abort();
			}
			break;
		default:
			break;
		}
    }
	/**
	 * 根据行政组织，得到组织下人员ID（Set）
	 * 
	 * */
	public static Set getPersonIds(Context ctx, String adminOrgUnitId)
    throws BOSException
	{
		Set personIds = new HashSet();
//		if(CommonXRHelper.isEmpty(adminOrgUnitId))
//			return personIds;
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("position.adminOrgUnit.id", adminOrgUnitId));
		EntityViewInfo evi = new EntityViewInfo();
		evi.setFilter(filter);
		IPositionMember iPositionMember = null;
		if(ctx == null)
			iPositionMember = PositionMemberFactory.getRemoteInstance();
		else
			iPositionMember = PositionMemberFactory.getLocalInstance(ctx);
		PositionMemberCollection coll = iPositionMember.getPositionMemberCollection(evi);
		if(coll == null || coll.isEmpty())
			return personIds;
		int i = 0;
		for(int size = coll.size(); i < size; i++)
			personIds.add(coll.get(i).getPerson().getId().toString());
		return personIds;
	}
    
    /**
	 * 同步数据库数据到界面,用于审批/反审批后显示审批人,审批日期
	 * @throws Exception
	 */
	protected void syncDataFromDB() throws Exception {
		//由传递过来的ID获取值对象
        if(getUIContext().get(UIContext.ID) == null)
        {
            String s = EASResource.getString(FrameWorkClientUtils.strResource + "Msg_IDIsNull");
            MsgBox.showError(s);
            SysUtil.abort();
        }
        IObjectPK pk = new ObjectUuidPK(BOSUuid.read(getUIContext().get(UIContext.ID).toString()));
        setDataObject(getValue(pk));
        loadFields();
	}
	
	//合计自动计算大写金额
	protected void txtsum_dataChanged(DataChangeEvent e) throws Exception {
		if(txtsum.getText() != null && !txtsum.getText().trim().equals("")) {
			StringBuilder sb = new StringBuilder("");
			String[] arr = txtsum.getText().split(",");
			for(int i = 0; i < arr.length; i++)
				sb.append(arr[i]);
			String upper = com.kingdee.eas.fdc.basedata.client.FDCClientHelper.getChineseFormat(new BigDecimal(sb.toString()), false);
			txtupperAmount.setText(upper);
		}
	}
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output btnAddLine_actionPerformed method
     */
    protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnAddLine_actionPerformed(e);
    }

    /**
     * output menuItemEnterToNextRow_itemStateChanged method
     */
    protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
        super.menuItemEnterToNextRow_itemStateChanged(e);
    }

    /**
     * output kdtEntrys_editStopped method
     */
    protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
        super.kdtEntrys_editStopped(e);
        double sum = UIRuleUtil.sum(kdtEntrys, "recAmount");
    	txtsum.setValue(sum);
//    	if(e.getColIndex() == 3) {
//    		if(kdtEntrys.getRow(e.getRowIndex()).getCell(3).getValue() != null) {
//    			kdtEntrys.addRow();
//    		}
//    	}
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
     * output actionSave_actionPerformed
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
    	if(editData.getBizState().equals(BizState.submited) || editData.getBizState().equals(BizState.audited)) {
    		MsgBox.showWarning("非新增或者保存状态单据无法保存!");
    		SysUtil.abort();
    	}
    	this.editData.setBizState(BizState.saved);
    	bizState.setSelectedItem(BizState.saved);
//    	//设置编码规则
//		CompanyOrgUnitInfo info = (CompanyOrgUnitInfo) prmtcompany.getValue();
//		ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getRemoteInstance();
//		String number = iCodingRuleManager.readNumber(editData, OrgConstants.DEF_CU_ID);
//		txtNumber.setText(info.getNumber()+"-"+number);
        super.actionSave_actionPerformed(e);
        syncDataFromDB();
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(editData.getBizState() == BizState.audited) {
    		MsgBox.showWarning("已审批单据无法提交!");
    		SysUtil.abort();
    	}
//    	this.editData.setBizState(BizState.submited);
//    	bizState.setSelectedItem(BizState.submited);
        super.actionSubmit_actionPerformed(e);
        btnAudit.setVisible(true);
        btnSave.setEnabled(false);
        syncDataFromDB();
    }

    //阻止连续提交
    protected boolean isContinueAddNew() {
    	return false;
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
     * output actionFirst_actionPerformed
     */
    public void actionFirst_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionFirst_actionPerformed(e);
    }

    /**
     * output actionPre_actionPerformed
     */
    public void actionPre_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPre_actionPerformed(e);
    }

    /**
     * output actionNext_actionPerformed
     */
    public void actionNext_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNext_actionPerformed(e);
    }

    /**
     * output actionLast_actionPerformed
     */
    public void actionLast_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLast_actionPerformed(e);
    }

    /**
     * 打印(支持连续打印)
     * @param idList
     * @param isPrint
     */
    protected void invokeMultiPrintFunction(List idList, boolean isPrint)
    {
    	if(idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
    		return;
    	StringBuffer failToPrintMsg = new StringBuffer();
    	KDNoteHelper tpHelper = new KDNoteHelper();
    	try
    	{
    		int curNum = 1;
    		String bosType = getBizInterface().getType().toString();
    		IPrintIntegration pinfo = PrintIntegrationFactory.getRemoteInstance();
    		List infoList = pinfo.getBillsPrintInfoByList(idList, bosType);
    		tpHelper.prepareBizCall(getTDFileName());
    		boolean isTimesCtrl = tpHelper.isPrintTimesControllable2(getTDFileName());
    		if(getTDFileName() != null && getTDFileName().trim().length() > 0 && isTimesCtrl)
    		{
    			for(int i = 0; i < infoList.size(); i++)
    			{
    				logger.info("start the print control!");
    				int maxNum = tpHelper.getMaxPrintTimes2(getTDFileName());
    				int pnum = ((AbstractPrintIntegrationInfo)infoList.get(i)).getPrintedNumber();
    				String billID = ((AbstractPrintIntegrationInfo)infoList.get(i)).getPrintBillID();
    				logger.info("Max print number:>>" + maxNum);
    				logger.info("Alreadey print number:>>" + pnum);
    				logger.info("current print number:>>" + curNum);
    				if(pnum >= maxNum)
    				{
    					idList.remove(billID);
    					String billNumber = pinfo.getBillNumberByBosType(bosType, billID);
    					String msgInfo = EASResource.getString("com.kingdee.eas.basedata.assistant.PrintIntegrationResource", "pi.controlinfo1");
    					Object objs[] = {
    							billNumber, String.valueOf(curNum), String.valueOf(pnum), String.valueOf(maxNum)
    					};
    					failToPrintMsg.append(MessageFormat.format(msgInfo, objs) + "\n");
    					continue;
    				}
    				if(curNum + pnum > maxNum)
    				{
    					idList.remove(billID);
    					String billNumber = pinfo.getBillNumberByBosType(bosType, billID);
    					String msgInfo = EASResource.getString("com.kingdee.eas.basedata.assistant.PrintIntegrationResource", "pi.controlinfo2");
    					Object objs[] = {
    							billNumber, String.valueOf(curNum), String.valueOf(pnum), String.valueOf(maxNum)
    					};
    					failToPrintMsg.append(MessageFormat.format(msgInfo, objs) + "\n");
    				}
    			}
    			if(failToPrintMsg.toString().trim().length() > 0)
    			{
    				String error = EASResource.getString("com.kingdee.eas.scm.common.SCMResource", "FailToPrintMsg");
    				MsgBox.showDetailAndOK(null, error, failToPrintMsg.toString(), 8188);
    			}
    		}
    	}
    	catch(KDRSException e)
    	{
    		handUIException(e);
    	}
    	catch(BOSException e)
    	{
    		handUIException(e);
    	}
    	catch(Exception e)
    	{
    		handUIException(e);
    	}
    	if(idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
    		return;
    	MultiDataSourceDataProviderProxy data = new MultiDataSourceDataProviderProxy();
    	QueryTaoDaDataProvider mainQueryData = new QueryTaoDaDataProvider(idList, "com.kingdee.eas.custom.funds.app.PrintReceiptionQuery");
    	mainQueryData.setIds(new HashSet(idList));
    	data.put("MainQuery", mainQueryData);
    	QueryTaoDaDataProvider PrintReceiptionEntryQuery = new QueryTaoDaDataProvider(idList, "com.kingdee.eas.custom.funds.app.PrintReceiptionEntryQuery");
    	PrintReceiptionEntryQuery.setIds(new HashSet(idList));
    	data.put("PrintReceiptionEntryQuery", PrintReceiptionEntryQuery);
    	BOSObjectType bosType = null;
    	try
    	{
    		bosType = getBizInterface().getType();
    		logger.info("current bostype:>>" + bosType.toString());
    	}
    	catch(Exception e)
    	{
    		MsgBox.showError(EASResource.getString("com.kingdee.eas.basedata.assistant.PrintIntegrationResource", "pi.remoteerror"));
    		SysUtil.abort();
    	}
    	CommonPrintIntegrationDataProvider printQueryData = new CommonPrintIntegrationDataProvider(bosType.toString(), PrintIntegrationManager.getPrintQueryPK());
    	data.put("PrintQuery", printQueryData);
    	PrintIntegrationManager.initPrint(tpHelper, bosType, idList, getTDFileName(), "com.kingdee.eas.scm.common.SCMResource", false);
    	if(isPrint)
    		tpHelper.print(getTDFileName(), data, SwingUtilities.getWindowAncestor(this));
    	else
    		tpHelper.printPreview(getTDFileName(), data, SwingUtilities.getWindowAncestor(this));
    }
    /**
     * output actionPrint_actionPerformed
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
    	checkCanPrint();
//        super.actionPrint_actionPerformed(e);
    	ArrayList idList = new ArrayList();
    	idList.add(editData.getId());
    	invokeMultiPrintFunction(idList, false);
    }
    

    /**
     * output actionPrintPreview_actionPerformed
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
    	checkCanPrint();
//        super.actionPrintPreview_actionPerformed(e);
    	ArrayList idList = new ArrayList();
    	idList.add(editData.getId());
    	invokeMultiPrintFunction(idList, false);
    }

    /**
     * output actionCopy_actionPerformed
     */
    public void actionCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopy_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }

    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(!(editData.getBizState().equals(BizState.saved) || editData.getBizState().equals(BizState.submited))) {
    		MsgBox.showWarning("非保存或者提交状态单据无法修改!");
    		SysUtil.abort();
    	}
    	//检查单据是否在工作流中
    	com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, getSelectBOID());
        super.actionEdit_actionPerformed(e);
        if(!editData.getBizState().equals(BizState.saved))
        	btnSave.setEnabled(false);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
    	if(editData.getBizState().equals(BizState.audited)) {
    		MsgBox.showWarning("已审批单据无法删除");
    		SysUtil.abort();
    	}
    	//检查单据是否在工作流中
    	com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, getSelectBOID());
        super.actionRemove_actionPerformed(e);
    }

    /**
     * output actionAttachment_actionPerformed
     */
    public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAttachment_actionPerformed(e);
    }

    /**
     * output actionSubmitOption_actionPerformed
     */
    public void actionSubmitOption_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmitOption_actionPerformed(e);
    }

    /**
     * output actionReset_actionPerformed
     */
    public void actionReset_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionReset_actionPerformed(e);
    }

    /**
     * output actionMsgFormat_actionPerformed
     */
    public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMsgFormat_actionPerformed(e);
    }

    /**
     * output actionAddLine_actionPerformed
     */
    public void actionAddLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddLine_actionPerformed(e);
    }

    /**
     * output actionCopyLine_actionPerformed
     */
    public void actionCopyLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyLine_actionPerformed(e);
    }

    /**
     * output actionInsertLine_actionPerformed
     */
    public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInsertLine_actionPerformed(e);
    }

    /**
     * output actionRemoveLine_actionPerformed
     */
    public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoveLine_actionPerformed(e);
    }

    /**
     * output actionCreateFrom_actionPerformed
     */
    public void actionCreateFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateFrom_actionPerformed(e);
    }

    /**
     * output actionCopyFrom_actionPerformed
     */
    public void actionCopyFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyFrom_actionPerformed(e);
    }

    /**
     * output actionAuditResult_actionPerformed
     */
    public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAuditResult_actionPerformed(e);
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
     * output actionViewSubmitProccess_actionPerformed
     */
    public void actionViewSubmitProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSubmitProccess_actionPerformed(e);
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
     * output actionStartWorkFlow_actionPerformed
     */
    public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionStartWorkFlow_actionPerformed(e);
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
     * output actionWorkFlowG_actionPerformed
     */
    public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkFlowG_actionPerformed(e);
    }

    /**
     * output actionCreateTo_actionPerformed
     */
    public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateTo_actionPerformed(e);
    }

    /**
     * output actionSendingMessage_actionPerformed
     */
    public void actionSendingMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendingMessage_actionPerformed(e);
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
     * output actionViewSignature_actionPerformed
     */
    public void actionViewSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSignature_actionPerformed(e);
    }

    /**
     * output actionSendMail_actionPerformed
     */
    public void actionSendMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMail_actionPerformed(e);
    }

    /**
     * output actionLocate_actionPerformed
     */
    public void actionLocate_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLocate_actionPerformed(e);
    }

    /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(!editData.getBizState().equals(BizState.submited)) {
    		MsgBox.showWarning("非提交单据无法审批!");
    		SysUtil.abort();
    	}
    	//检查单据是否在工作流中
    	com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, getSelectBOID());
    	
    	super.actionAudit_actionPerformed(e);
        btnAudit.setVisible(false);
        btnUnAudit.setVisible(true);
    	super.actionAudit_actionPerformed(e);
    	syncDataFromDB();
    }

    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	//检查单据是否在工作流中
    	com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, getSelectBOID());
    	
    	super.actionUnAudit_actionPerformed(e);
    	btnUnAudit.setVisible(false);
    	btnAudit.setVisible(true);
    	syncDataFromDB();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.funds.ReceiptionFactory.getRemoteInstance();
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
        com.kingdee.eas.custom.funds.ReceiptionInfo objectValue = new com.kingdee.eas.custom.funds.ReceiptionInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        OrgUnitInfo info = SysContext.getSysContext().getCurrentOrgUnit();
        UserInfo user = SysContext.getSysContext().getCurrentUserInfo();
//        if(info.isIsPurchaseOrgUnit()) {
//        	MsgBox.showWarning("请切换到实体财务组织进行单据操作!");
//        	SysUtil.abort();
//        }
		try {
			//设置编码
			ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getRemoteInstance();
			String number = iCodingRuleManager.getNumber(objectValue, OrgConstants.DEF_CU_ID);
			objectValue.setNumber(info.getNumber()+"-"+number);
			//默认收款人为当前登陆人
			PersonInfo PersonInfo = user.getPerson();
			PersonInfo = PersonInfo == null ? null : PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(PersonInfo.getId()));
			objectValue.setRecPerson(PersonInfo);
			//设置默认项目
			ISellProject iSellProject = SellProjectFactory.getRemoteInstance();
			String oql = "where orgUnit.id = '" + info.getId().toString() + "' and level='1'";
			SellProjectCollection sellProjectCollection = iSellProject.getSellProjectCollection(oql);
			SellProjectInfo sellProject = sellProjectCollection.get(0);
			objectValue.setProject(sellProject);
			//设置房产公司
			ICompanyOrgUnit iCompanyOrgUnit = CompanyOrgUnitFactory.getRemoteInstance();
			CompanyOrgUnitInfo company = sellProject == null ? null : sellProject.getCompanyOrgUnit();
			company = company == null ? null : iCompanyOrgUnit.getCompanyOrgUnitInfo(new ObjectUuidPK(company.getId()));
			objectValue.setCompany(company);
		} catch (BOSException e) {
			e.printStackTrace();
		} catch (EASBizException e) {
			e.printStackTrace();
		}
        return objectValue;
    }

}