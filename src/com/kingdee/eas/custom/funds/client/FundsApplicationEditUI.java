/**
 * output package name
 */
package com.kingdee.eas.custom.funds.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.attachment.BoAttchAssoCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoFactory;
import com.kingdee.eas.base.attachment.IBoAttchAsso;
import com.kingdee.eas.basedata.assistant.AccountBankCollection;
import com.kingdee.eas.basedata.assistant.AccountBankFactory;
import com.kingdee.eas.basedata.assistant.AccountBankInfo;
import com.kingdee.eas.basedata.assistant.BankFactory;
import com.kingdee.eas.basedata.assistant.BankInfo;
import com.kingdee.eas.basedata.assistant.IAccountBank;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.IAdminOrgUnit;
import com.kingdee.eas.basedata.org.IPurchaseOrgUnit;
import com.kingdee.eas.basedata.org.OrgConstants;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitFactory;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyBizUnitF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.funds.BizState;
import com.kingdee.eas.custom.funds.FundsApplicationEntryCollection;
import com.kingdee.eas.custom.funds.FundsApplicationEntryInfo;
import com.kingdee.eas.fdc.basedata.client.FDCClientUtils;
import com.kingdee.eas.fdc.schedule.framework.util.KDEntityTree;
import com.kingdee.eas.fi.cas.client.BankAccountInitHandler;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IColumn;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDPromptSelector;
import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;

/**
 * output class name
 */
public class FundsApplicationEditUI extends AbstractFundsApplicationEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FundsApplicationEditUI.class);
    
    /**
     * output class constructor
     */
    public FundsApplicationEditUI() throws Exception
    {
        super();
    }
    
    public void onLoad() throws Exception {
    	initKDTableF7Cell(kdtEntrys, "recAccountText", "com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery", 
    			"$BankAccountNumber$", "$BankAccountNumber$", "$BankAccountNumber$","$BankAccountNumber$", null, null, null);
    	initComponent();
    	setKdtEntryCellRequired(kdtEntrys, new String[] {"entryPayUnit","payAccount","recUnit","amount","recAccount","usage"});
    	
    	AdminOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentAdminUnit();
    	final PurchaseOrgUnitInfo purchaseInfo = getComOrgByPurchaseOrg(null, orgInfo.getId().toString());//事业部
        
        kdtEntrys_detailPanel.getAddNewLineButton().removeActionListener(kdtEntrys_detailPanel.getAddNewLineButton().getActionListeners()[0]);
        kdtEntrys_detailPanel.getAddNewLineButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				IRow add = kdtEntrys.addRow();
				add.getCell("recDate").setValue(new Date());
				add.getCell("attachAmount").setValue(0);
//				add.getCell("payIsInputIn").setValue(false);
//				add.getCell("recIsInputIn").setValue(false);
			}
        });
        
        //设置分录付款单位树状
        CompanyBizUnitF7 f7 = new CompanyBizUnitF7(this);
		f7.showCheckBoxOfShowingAllOUs();
		f7.setIsCUFilter(false);
		f7.setRootUnitID(orgInfo.getId().toString());
        //付款单位默认当前区域下的公司以及结算中心
//        String area = purchaseInfo.getName().substring(0, 2);
//		String oqls = "where name like '"+area+"%结算中心%' and isleaf='1'";
//		CompanyOrgUnitInfo costCenter = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(oqls);//结算中心
        EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        evi.setFilter(filter);
        CompanyOrgUnitInfo companyUnit = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(purchaseInfo.getId()));
        filter.getFilterItems().add(new FilterItemInfo("longNumber",companyUnit.getLongNumber()+"%",CompareType.LIKE));
        filter.getFilterItems().add(new FilterItemInfo("isOUSealUp","0",CompareType.EQUALS));
        filter.getFilterItems().add(new FilterItemInfo("level","6",CompareType.EQUALS));
        filter.getFilterItems().add(new FilterItemInfo("name","%历史%",CompareType.NOTLIKE));
//        filter.getFilterItems().add(new FilterItemInfo("id", costCenter.getId().toString(), CompareType.EQUALS));
//        filter.setMaskString("#0 and #1 and #2 or #3");
        DataChangeListener listener = new DataChangeListener() {
			public void dataChanged(DataChangeEvent arg0) {
				IRow row = kdtEntrys.getRow(kdtEntrys.getSelectManager().getActiveRowIndex());
				CompanyOrgUnitInfo entryPayUnit = (CompanyOrgUnitInfo) arg0.getNewValue();
				if(entryPayUnit != null) {
					if(entryPayUnit.getName().trim().equals("旭辉集团股份有限公司")) {
						//勾选集团付款后 默认带出集团账号（暂注释，默认账号未拿到）
						AccountBankCollection bankAccount;
						try {
							bankAccount = AccountBankFactory.getRemoteInstance().getAccountBankCollection("where number='001.021.001.01'");
							AccountBankInfo accountBankInfo = bankAccount.get(0);
							row.getCell("payAccount").setValue(accountBankInfo);//付款账号
							BankInfo bank = accountBankInfo.getBank();
							bank = BankFactory.getRemoteInstance().getBankInfo(new ObjectUuidPK(bank.getId()));
							row.getCell("payBank").setValue(bank.getName());//付款行
							row.getCell("payAccProperty").setValue(accountBankInfo.getDescription());//收款账户性质
						} catch (BOSException e1) {
							e1.printStackTrace();
						} catch (EASBizException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
        };
        initKDTableF7Cell(kdtEntrys, "entryPayUnit", "com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct", 
        		"$Description$", "$Description$", "$Description$", "$Description$", evi, null, listener);
		
		//构建附件数列
        prmtAuditor.setDisplayFormat("$name$");
        IColumn col = kdtEntrys.addColumn();
        col.setKey("attCount");
        col.getStyleAttributes().setLocked(true);
        col.getStyleAttributes().setHorizontalAlign(HorizontalAlignment.CENTER);
        kdtEntrys.getHeadRow(0).getCell("attCount").setValue("附件数");
        kdtEntrys.getColumn("attachAmount").getStyleAttributes().setHided(true);
        kdtEntrys.getColumn("attachAmount").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.CENTER);
        
        super.onLoad();
        
        if(editData.getBizState().equals(BizState.audited)) {
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
        
        prmtpayUnit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(prmtpayUnit.getValue() != null) {
					txtappCompany.setText(purchaseInfo.getName());//设置区域申请公司为事业部
					CompanyOrgUnitInfo company = (CompanyOrgUnitInfo) prmtpayUnit.getValue();
					EntityViewInfo evi = new EntityViewInfo();
			        FilterInfo filter = new FilterInfo();
			        evi.setFilter(filter);
			        filter.getFilterItems().add(new FilterItemInfo("Company.longnumber", company.getLongNumber()+"%", CompareType.LIKE));
			        filter.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//非注销账号
					initKDTableF7Cell(kdtEntrys, "payAccount", "com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery", "$BankAccountNumber$", "$BankAccountNumber$", "$BankAccountNumber$","$BankAccountNumber$", evi, null, null);
				}
			}
        });

        //设置分录收款单位树状
        CompanyBizUnitF7 allF7 = new CompanyBizUnitF7(this);
		allF7.showCheckBoxOfShowingAllOUs();
		allF7.setIsCUFilter(false);
		allF7.setRootUnitID(OrgConstants.DEF_CU_ID);
		allF7.disablePerm();
		//设置分录收款单位显示
        final KDBizPromptBox kdtEntrys_recUnit_PromptBox = new KDBizPromptBox();
        kdtEntrys_recUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");
        kdtEntrys_recUnit_PromptBox.setVisible(true);
        kdtEntrys_recUnit_PromptBox.setEditable(true);
        kdtEntrys_recUnit_PromptBox.setDisplayFormat("$Description$");
        kdtEntrys_recUnit_PromptBox.setEditFormat("$Description$");
        kdtEntrys_recUnit_PromptBox.setCommitFormat("$Description$");
        kdtEntrys_recUnit_PromptBox.setSelector(allF7);//设置收款单位树状显示
        KDTDefaultCellEditor kdtEntrys_recUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_recUnit_PromptBox);
        this.kdtEntrys.getColumn("recUnit").setEditor(kdtEntrys_recUnit_CellEditor);
        ObjectValueRender kdtEntrys_recUnit_OVR = new ObjectValueRender();
        kdtEntrys_recUnit_OVR.setFormat(new BizDataFormat("$Description$"));
        this.kdtEntrys.getColumn("recUnit").setRenderer(kdtEntrys_recUnit_OVR);
        kdtEntrys_recUnit_PromptBox.addDataChangeListener(new DataChangeListener() {
			public void dataChanged(DataChangeEvent arg0) {
				IRow row = kdtEntrys.getRow(kdtEntrys.getSelectManager().getActiveRowIndex());
				CompanyOrgUnitInfo recUnit = (CompanyOrgUnitInfo) arg0.getNewValue();
				if(recUnit != null) {
					if(recUnit.getName().trim().equals("旭辉集团股份有限公司")) {
						//勾选集团付款后 默认带出集团账号（暂注释，默认账号未拿到）
						AccountBankCollection bankAccount;
						try {
							bankAccount = AccountBankFactory.getRemoteInstance().getAccountBankCollection("where number='001.021.001.01'");
							AccountBankInfo accountBankInfo = bankAccount.get(0);
							row.getCell("recAccount").setValue(accountBankInfo);//收款账号
							BankInfo bank = accountBankInfo.getBank();
							bank = BankFactory.getRemoteInstance().getBankInfo(new ObjectUuidPK(bank.getId()));
							row.getCell("recBank").setValue(bank.getName());//收款行
							row.getCell("recAccProperty").setValue(accountBankInfo.getDescription());//收款账户性质
						} catch (BOSException e1) {
							e1.printStackTrace();
						} catch (EASBizException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
        });

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
        KDTDefaultCellEditor kdtEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_amount_TextField);
        this.kdtEntrys.getColumn("amount").setEditor(kdtEntrys_amount_CellEditor);

        //付款账号，收款账号设置提示
        final KDBizPromptBox kdtEntrys_PromptBox = new KDBizPromptBox();
        kdtEntrys_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery");
        kdtEntrys_PromptBox.setVisible(true);
        kdtEntrys_PromptBox.setEditable(true);
        kdtEntrys_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_PromptBox.setEditFormat("$number$");
        kdtEntrys_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_CellEditor = new KDTDefaultCellEditor(kdtEntrys_PromptBox);
        this.kdtEntrys.getColumn("recAccount").setEditor(kdtEntrys_CellEditor);//当前行的收款账号设置条件
        this.kdtEntrys.getColumn("payAccount").setEditor(kdtEntrys_CellEditor);//当前行的付款账号设置条件
        ObjectValueRender kdtEntrys_OVR = new ObjectValueRender();
        kdtEntrys_OVR.setFormat(new BizDataFormat("$bankAccountNumber$"));
        this.kdtEntrys.getColumn("recAccount").setRenderer(kdtEntrys_OVR);
        this.kdtEntrys.getColumn("payAccount").setRenderer(kdtEntrys_OVR);
        kdtEntrys_PromptBox.addSelectorListener(new SelectorListener() {
			public void willShow(SelectorEvent event) {
				int index = kdtEntrys.getSelectManager().getActiveRowIndex();
				int colIndex = kdtEntrys.getSelectManager().getActiveColumnIndex();
				IRow row = kdtEntrys.getRow(index);
				if(kdtEntrys.getColumn(colIndex).getKey().equals("recAccount") && row.getCell("recUnit").getValue() == null) {
					MsgBox.showWarning("请先选择收款单位!");
					SysUtil.abort();
				}
				if(kdtEntrys.getColumn(colIndex).getKey().equals("payAccount") && row.getCell("entryPayUnit").getValue() == null) {
					MsgBox.showWarning("请先选择付款单位!");
					SysUtil.abort();
				}
			}
        });
        
        initFilter();
        //是否集团付款
        chkisGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kdtEntrys.removeRows();
				kdtEntrys_detailPanel.getAddNewLineButton().removeActionListener(kdtEntrys_detailPanel.getAddNewLineButton().getActionListeners()[0]);
		        kdtEntrys_detailPanel.getAddNewLineButton().addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						IRow add = kdtEntrys.addRow();
						add.getCell("recDate").setValue(new Date());
						add.getCell("attachAmount").setValue(0);
//						add.getCell("recIsInputIn").setValue(false);
//						add.getCell("payIsInputIn").setValue(false);
						if(chkisGroup.isSelected()) {
							//勾选集团付款的话，默认付款单位为股份公司
							String oql = "where number='A'";
							CompanyOrgUnitInfo companyOrgUnitInfo;
							AccountBankInfo accountBankInfo;
							try {
								companyOrgUnitInfo = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(oql);
								add.getCell("entryPayUnit").setValue(companyOrgUnitInfo);
								
								//勾选集团付款后 默认带出集团账号（暂注释，默认账号未拿到）
								AccountBankCollection bankAccount = AccountBankFactory.getRemoteInstance()
																				.getAccountBankCollection("where number='001.021.001.01'");
								accountBankInfo = bankAccount.get(0);
								add.getCell("payAccount").setValue(accountBankInfo);//付款账号
								BankInfo bank = accountBankInfo.getBank();
								bank = BankFactory.getRemoteInstance().getBankInfo(new ObjectUuidPK(bank.getId()));
								add.getCell("payBank").setValue(bank.getName());//付款行
								add.getCell("payAccProperty").setValue(accountBankInfo.getDescription());//账户性质
								
								//勾选了集团付款后 默认带出收款单位为本区域的结算中心
								String area = purchaseInfo.getName().substring(0, 2);
								String oqls = "where name like '"+area+"%结算中心%' and isleaf='1'";
								CompanyOrgUnitInfo costCenter = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(oqls);
								add.getCell("recUnit").setValue(costCenter);
								accountBankInfo = getAccountBankInfo(costCenter);
								bank = accountBankInfo.getBank();
								bank = BankFactory.getRemoteInstance().getBankInfo(new ObjectUuidPK(bank.getId()));
								add.getCell("recBank").setValue(bank.getName());//收款行
								add.getCell("recAccProperty").setValue(accountBankInfo.getDescription());//收款账户性质
							} catch (EASBizException e1) {
								e1.printStackTrace();
							} catch (BOSException e1) {
								e1.printStackTrace();
							}
//							勾选集团付款，收款单位只能选择结算中心
							EntityViewInfo evi = new EntityViewInfo();
							FilterInfo filter = new FilterInfo();
							filter.getFilterItems().add(new FilterItemInfo("name", "%结算中心%", CompareType.LIKE));
							filter.getFilterItems().add(new FilterItemInfo("isleaf", "1", CompareType.EQUALS));
							evi.setFilter(filter);
							initKDTableF7Cell(kdtEntrys, "recUnit", "com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct", "$Description$", "$Description$", "$Description$","$Description$", evi, null, null);
						} else {
							//设置分录收款单位树状
					        CompanyBizUnitF7 allF7 = new CompanyBizUnitF7();
							allF7.showCheckBoxOfShowingAllOUs();
							allF7.setIsCUFilter(false);
							allF7.setRootUnitID(OrgConstants.DEF_CU_ID);
							allF7.disablePerm();					        
					        DataChangeListener listener = new DataChangeListener() {
								public void dataChanged(DataChangeEvent arg0) {
									IRow row = kdtEntrys.getRow(kdtEntrys.getSelectManager().getActiveRowIndex());
									CompanyOrgUnitInfo recUnit = (CompanyOrgUnitInfo) arg0.getNewValue();
									if(recUnit != null) {
										if(recUnit.getName().trim().equals("旭辉集团股份有限公司")) {
											//勾选集团付款后 默认带出集团账号（暂注释，默认账号未拿到）
											AccountBankCollection bankAccount;
											try {
												bankAccount = AccountBankFactory.getRemoteInstance().getAccountBankCollection("where number='001.021.001.01'");
												AccountBankInfo accountBankInfo = bankAccount.get(0);
												row.getCell("recAccount").setValue(accountBankInfo);//收款账号
												BankInfo bank = accountBankInfo.getBank();
												bank = BankFactory.getRemoteInstance().getBankInfo(new ObjectUuidPK(bank.getId()));
												row.getCell("recBank").setValue(bank.getName());//收款行
												row.getCell("recAccProperty").setValue(accountBankInfo.getDescription());//收款账户性质
											} catch (BOSException e1) {
												e1.printStackTrace();
											} catch (EASBizException e1) {
												e1.printStackTrace();
											}
										}
									}
								}
					        };
					        //构建分录收款单位
					        initKDTableF7Cell(kdtEntrys, "recUnit", "com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct", 
					        									"$Description$", "$Description$", "$Description$","$Description$", null, allF7, listener);
						}
					}
		        });
			}
        });

    }
    
    //根据结算中心获取结算中心下的银行账号
    private AccountBankInfo getAccountBankInfo(CompanyOrgUnitInfo costCenter) {
    	AccountBankInfo accountBankInfo = null;
    	try {
			IAccountBank iAccountBank = AccountBankFactory.getRemoteInstance();
			EntityViewInfo evi1 = new EntityViewInfo();
	        FilterInfo filter1 = new FilterInfo();
	        evi1.setFilter(filter1);
	        filter1.getFilterItems().add(new FilterItemInfo("Company.longnumber", costCenter.getLongNumber()+"%", CompareType.LIKE));
	        filter1.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//非注销账号
	        AccountBankCollection accountBankCollection = iAccountBank.getAccountBankCollection(evi1);
	        accountBankInfo = accountBankCollection.get(0);
		} catch (BOSException e) {
			e.printStackTrace();
		}
		return accountBankInfo;
    }
    private void initFilter() {
    	//付款账号根据付款单位过滤
        if(prmtpayUnit.getValue() != null) {
        	CompanyOrgUnitInfo company = (CompanyOrgUnitInfo) prmtpayUnit.getValue();
			EntityViewInfo evi1 = new EntityViewInfo();
	        FilterInfo filter1 = new FilterInfo();
	        evi1.setFilter(filter1);
	        filter1.getFilterItems().add(new FilterItemInfo("Company.longnumber", company.getLongNumber()+"%", CompareType.LIKE));
	        filter1.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//非注销账号
			initKDTableF7Cell(kdtEntrys, "payAccount", "com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery", "$BankAccountNumber$", "$BankAccountNumber$", "$BankAccountNumber$","$BankAccountNumber$", evi1, null, null);
        }
        //收款账号
        final KDBizPromptBox kdtEntrys_recAccount_PromptBox = new KDBizPromptBox();
        kdtEntrys_recAccount_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery");
        kdtEntrys_recAccount_PromptBox.setVisible(true);
        kdtEntrys_recAccount_PromptBox.setEditable(true);
        kdtEntrys_recAccount_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_recAccount_PromptBox.setEditFormat("$number$");
        kdtEntrys_recAccount_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_recAccount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_recAccount_PromptBox);
       
        //付款账号
        final KDBizPromptBox kdtEntrys_payAccount_PromptBox = new KDBizPromptBox();
        kdtEntrys_payAccount_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery");
        kdtEntrys_payAccount_PromptBox.setVisible(true);
        kdtEntrys_payAccount_PromptBox.setEditable(true);
        kdtEntrys_payAccount_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_payAccount_PromptBox.setEditFormat("$number$");
        kdtEntrys_payAccount_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_payAccount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_payAccount_PromptBox);
        
        for(int i = 0; i < kdtEntrys.getRowCount(); i++) {
        	IRow row = kdtEntrys.getRow(i);
        	if(row.getCell("recUnit").getValue() != null) {
        		//为编辑行的收款账号添加过滤条件(收款公司下的账号)
                row.getCell("recAccount").setEditor(kdtEntrys_recAccount_CellEditor);//当前行的单元格设置条件
                ObjectValueRender kdtEntrys_recAccount_OVR = new ObjectValueRender();
                kdtEntrys_recAccount_OVR.setFormat(new BizDataFormat("$bankAccountNumber$"));
                row.getCell("recAccount").setRenderer(kdtEntrys_recAccount_OVR);
                CompanyOrgUnitInfo company = (CompanyOrgUnitInfo) row.getCell("recUnit").getValue();
    			EntityViewInfo evi = new EntityViewInfo();
    	        FilterInfo filter = new FilterInfo();
    	        evi.setFilter(filter);
    	        filter.getFilterItems().add(new FilterItemInfo("Company.longnumber", company.getLongNumber()+"%", CompareType.LIKE));
    	        filter.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//非注销账号
    	        kdtEntrys_recAccount_PromptBox.setEntityViewInfo(evi);
    	        kdtEntrys_recAccount_PromptBox.addSelectorListener(new SelectorListener() {
    				public void willShow(SelectorEvent event) {
    					int index = kdtEntrys.getSelectManager().getActiveRowIndex();
    					IRow row = kdtEntrys.getRow(index);
    					if(row.getCell("recUnit").getValue() == null) {
    						MsgBox.showWarning("请先选择收款单位!");
    						SysUtil.abort();
    					}
    				}
    	        });
        	}
        	//为编辑行的付款账号添加过滤条件(收款公司下的账号)
        	if(row.getCell("entryPayUnit").getValue() != null) {
        		row.getCell("payAccount").setEditor(kdtEntrys_payAccount_CellEditor);//当前行的单元格设置条件
                ObjectValueRender kdtEntrys_payAccount_OVR = new ObjectValueRender();
                kdtEntrys_payAccount_OVR.setFormat(new BizDataFormat("$bankAccountNumber$"));
                row.getCell("payAccount").setRenderer(kdtEntrys_payAccount_OVR);
                CompanyOrgUnitInfo company = (CompanyOrgUnitInfo) row.getCell("entryPayUnit").getValue();
    			EntityViewInfo evi = new EntityViewInfo();
    	        FilterInfo filter = new FilterInfo();
    	        evi.setFilter(filter);
    	        filter.getFilterItems().add(new FilterItemInfo("Company.longnumber", company.getLongNumber()+"%", CompareType.LIKE));
    	        filter.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//非注销账号
    	        kdtEntrys_payAccount_PromptBox.setEntityViewInfo(evi);
    	        kdtEntrys_payAccount_PromptBox.addSelectorListener(new SelectorListener() {
    	        	public void willShow(SelectorEvent arg0) {
    	        		int index = kdtEntrys.getSelectManager().getActiveRowIndex();
    					IRow row = kdtEntrys.getRow(index);
    	        		if(row.getCell("entryPayUnit").getValue() == null) {
    	        			MsgBox.showWarning("请先选择付款单位!");
    	        			SysUtil.abort();
    	        		}
    	        	}
    	        });
        	}
        }
    }
    @Override
    protected void verifyInput(ActionEvent e) throws Exception {
    	super.verifyInput(e);
    	verifyEntryCell(kdtEntrys, new String[] {"entryPayUnit","payAccount","recUnit","recAccount","amount","usage"});
    	if(!checkBankAccount(kdtEntrys)) {
    		MsgBox.showWarning("收款账号性质：可动用不能与其他性质共存,请修改!");
    		SysUtil.abort();
    	}
    	if(!checkRecUnitValid(kdtEntrys)) {
    		MsgBox.showWarning("收款单位：旭辉集团股份有限公司不能与其他共存,请修改!");
    		SysUtil.abort();
    	}
    }
    //分录单笔最大金额
    private void setSingleMaxAmount() {
    	BigDecimal max = new BigDecimal("0");
    	for(int i = 0; i < kdtEntrys.getRowCount(); i++) {
    		BigDecimal value = (BigDecimal)kdtEntrys.getRow(i).getCell("amount").getValue();
    		BigDecimal amount = (value == null) ? new BigDecimal("0") : (BigDecimal) kdtEntrys.getRow(i).getCell("amount").getValue();
    		max = max.max(amount);
    	}
    	this.txtsingleMaxAmount.setValue(max);
    	this.editData.setSingleMaxAmount(max);
    }
    //检查收款单位
    private boolean checkRecUnitValid(KDTable table) {
    	boolean flag = true;
    	if(table.getRowCount() == 1) 
    		return flag;
    	Set set = new HashSet();
    	for(int i = 0; i < table.getRowCount(); i++) {
    		IRow row = table.getRow(i);
    		String recUnitName = row.getCell("recUnit").getValue().toString().trim();
    		set.add(recUnitName);
    	}
    	if(set.contains("旭辉集团股份有限公司") && set.size() > 1)
    		flag = false;
    	return flag;
    }
    //检查收款银行账号性质(可动用不能与其他性质共存;不可动用与受监管可共存)
    private boolean checkBankAccount(KDTable table) {
    	boolean flag = true;
    	if(table.getRowCount() == 1)
    		return flag;
    	Set set = new HashSet();
    	for(int i = 0; i < table.getRowCount(); i++) {
    		IRow row = table.getRow(i);
//    		String payAccProperty = row.getCell("payAccProperty").getValue().toString().trim();
    		String recAccProperty = row.getCell("recAccProperty").getValue().toString().trim();//收款账号性质
//    		set.add(payAccProperty);
    		set.add(recAccProperty);
    	}
    	if(set.contains("可动用") && set.size() > 1)
    		flag = false;
    	return flag;
    }
    private void verifyEntryCell(KDTable table, String[] cols) {
    	IRow head = table.getHeadRow(0);
    	for(int i = 0; i < table.getRowCount(); i++) {
    		IRow row = table.getRow(i);
    		for(int j = 0; j < cols.length; j++) {
    			if(row.getCell(cols[j]).getValue() == null || row.getCell(cols[j]).getValue().toString().length() == 0) {
    				MsgBox.showWarning("分录第"+ (i+1) + "行," + /*map.get(cols[j])*/head.getCell(cols[j]).getValue() + "不能为空");
    				SysUtil.abort();
    			}
    		}
    	}
    }
    private void setKdtEntryCellRequired(KDTable table, String[] cols) {
    	for(int i = 0; i < cols.length; i++)
    		table.getColumn(cols[i]).setRequired(true);
    }
    private boolean checkAccountBankIsValid(AccountBankInfo bankInfo) throws Exception {
    	boolean flag = true;
    	IAccountBank iAccountBank = AccountBankFactory.getRemoteInstance();
    	String oql = "where name='" + bankInfo.getName() + "'";
    	AccountBankCollection accBankColl = iAccountBank.getAccountBankCollection(oql);
    	Set attrSet = new HashSet();
    	if(accBankColl != null) {
    		for(int i = 0; i < accBankColl.size(); i++) {
    			AccountBankInfo info = accBankColl.get(i);
    			if(info.getDescription() != null && !info.getDescription().trim().equals(""))
    				attrSet.add(info.getDescription());
    		}
    		if(attrSet.contains("可动用") && attrSet.size() > 1) 
    			flag = false;
    	}
    	return flag;
    }
    @Override
    public void prmtpayUnit_Changed() throws Exception {
    }
    private void initComponent() {
    	contNumber.setVisible(false);
    	contBizDate.setVisible(false);
    	contDescription.setVisible(false);
    	contCreateTime.setVisible(false);
    	contCreator.setVisible(false);
    	contappCompany.setEnabled(false);
    	contauditDate.setEnabled(false);
    	contbizState.setVisible(false);
    	contauditOrg.setEnabled(false);
    	contsingleMaxAmount.setVisible(false);
    	
    	btnNext.setVisible(false);
    	btnPre.setVisible(false);
    	btnFirst.setVisible(false);
    	btnLast.setVisible(false);
    	btnTraceUp.setVisible(false);
    	btnTraceDown.setVisible(false);
    	btnCreateFrom.setVisible(false);
    	btnCreateTo.setVisible(false);
    	
//    	prmtpayUnit.setRequired(true);
//		prmtpayUnit.setDisplayFormat("$name$");
		contpayUnit.setVisible(false);
		
    	btnAudit.setIcon(EASResource.getIcon("imgTbtn_auditing"));
    	btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_fauditing"));
    	
    	toolBar.addComponentAfterComponent(btnAudit, btnSubmit);
    	toolBar.addComponentAfterComponent(btnUnAudit, btnAudit);
    }
    
    //分录checkBox字段添加listener
    private void initCheckBoxAction(IRow row, String checkBox, String hideCell, String dispalyCell) {
    	if(row.getCell(checkBox).getValue().equals(true)) {
    		row.getCell(hideCell).getStyleAttributes().setHided(true);
    		row.getCell(dispalyCell).getStyleAttributes().setHided(false);
    	} else {
    		row.getCell(hideCell).getStyleAttributes().setHided(false);
    		row.getCell(dispalyCell).getStyleAttributes().setHided(true);
    	}
    }
    //初始化分录文本字段
    private void initKDTableRowTextCell(IRow row, String cellName, String BizDataFormat) {
    	final KDTextField textField = new KDTextField();
    	textField.setName(cellName);
    	textField.setMaxLength(80);
    	KDTDefaultCellEditor cellEditor = new KDTDefaultCellEditor(textField);
    	row.getCell(cellName).setEditor(cellEditor);
    	ObjectValueRender kdtEntrys_recUnit_OVR = new ObjectValueRender();
        kdtEntrys_recUnit_OVR.setFormat(new BizDataFormat(BizDataFormat));
        row.getCell(cellName).setRenderer(kdtEntrys_recUnit_OVR);
    }
    //初始化分录某行F7控件
    private void initKDTableRowF7Cell(IRow row, String cellName, String queryInfo, 
    							   String displayFormat, String editFormat, String commitFormat, String bizDataFormat,
    							   EntityViewInfo evi, KDPromptSelector selector, DataChangeListener listener) {
    	final KDBizPromptBox cell = new KDBizPromptBox();
    	cell.setQueryInfo(queryInfo);
    	cell.setVisible(true);
    	cell.setEditable(true);
    	cell.setDisplayFormat(displayFormat);
    	cell.setEditFormat(editFormat);
    	cell.setCommitFormat(commitFormat);
    	cell.setSelector(selector);
    	cell.setEntityViewInfo(evi);
    	KDTDefaultCellEditor cellEditor = new KDTDefaultCellEditor(cell);
    	row.getCell(cellName).setEditor(cellEditor);
    	if(listener != null)
    		cell.addDataChangeListener(listener);
    	ObjectValueRender kdtEntrys_recUnit_OVR = new ObjectValueRender();
        kdtEntrys_recUnit_OVR.setFormat(new BizDataFormat(bizDataFormat));
        row.getCell(cellName).setRenderer(kdtEntrys_recUnit_OVR);
    }
    //初始化分录F7控件
    private void initKDTableF7Cell(KDTable table, String cellName, String queryInfo, 
    							   String displayFormat, String editFormat, String commitFormat, String bizDataFormat,
    							   EntityViewInfo evi, KDPromptSelector selector, DataChangeListener listener) {
    	final KDBizPromptBox cell = new KDBizPromptBox();
    	cell.setQueryInfo(queryInfo);
    	cell.setVisible(true);
    	cell.setEditable(true);
    	cell.setDisplayFormat(displayFormat);
    	cell.setEditFormat(editFormat);
    	cell.setCommitFormat(commitFormat);
    	cell.setSelector(selector);
    	cell.setEntityViewInfo(evi);
    	KDTDefaultCellEditor cellEditor = new KDTDefaultCellEditor(cell);
    	table.getColumn(cellName).setEditor(cellEditor);
    	if(listener != null)
    		cell.addDataChangeListener(listener);
    	ObjectValueRender kdtEntrys_recUnit_OVR = new ObjectValueRender();
        kdtEntrys_recUnit_OVR.setFormat(new BizDataFormat(bizDataFormat));
        table.getColumn(cellName).setRenderer(kdtEntrys_recUnit_OVR);
    }
    
    /**
	 * 由部门得到采购组织
	 */
	public static PurchaseOrgUnitInfo getComOrgByPurchaseOrg(Context ctx,
			String adminOrgUnitId) throws EASBizException,
			BOSException {
		if(adminOrgUnitId==null||"".equals(adminOrgUnitId.trim())){return null;}
		PurchaseOrgUnitInfo costCenterOrgUnitInfo = null;
		AdminOrgUnitInfo parentCost = null;
		if(ctx!=null)
			parentCost = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(new ObjectUuidPK(adminOrgUnitId));
		else
			parentCost = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(adminOrgUnitId));
		do { 
			if (parentCost == null)
				break;
			if (parentCost.isIsPurchaseOrgUnit()) {
				String id = parentCost.getId().toString();
				if (id == null)
					continue;
				IPurchaseOrgUnit iCompanyOrgUnit = null;
				if(ctx!=null)
					iCompanyOrgUnit = PurchaseOrgUnitFactory.getLocalInstance(ctx);
				else
					iCompanyOrgUnit = PurchaseOrgUnitFactory.getRemoteInstance();
				costCenterOrgUnitInfo = (PurchaseOrgUnitInfo) iCompanyOrgUnit.getValue(new ObjectUuidPK(id));
				break;
			}
			parentCost = parentCost.getParent();
			if (parentCost != null) {
				String id = parentCost.getId().toString();
				if (id != null) {
					IAdminOrgUnit iAdmin = null;
					if (ctx!=null) 
						iAdmin = AdminOrgUnitFactory.getLocalInstance(ctx);
					else
						iAdmin = AdminOrgUnitFactory.getRemoteInstance();
					parentCost = (AdminOrgUnitInfo) iAdmin.getValue(new ObjectUuidPK(id));
				}
			}
		} while (true);
		return costCenterOrgUnitInfo;
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
    
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        //显示附件数
        try {
    		IBoAttchAsso iBoAttchAsso = BoAttchAssoFactory.getRemoteInstance();
    		FundsApplicationEntryCollection entryColl = editData.getEntrys();
    		for(int i = 0; i < entryColl.size(); i++) {
    			FundsApplicationEntryInfo info = entryColl.get(i);
    			String oql = "where boID='" + info.getId().toString() + "'";
    			BoAttchAssoCollection attcoll = iBoAttchAsso.getBoAttchAssoCollection(oql);
    			if(attcoll != null) {
    				kdtEntrys.getRow(i).getCell("attCount").setValue(attcoll.size());
    			}
    		}
    	} catch (BOSException e) {
    		e.printStackTrace();
    	}
        refreshFootROw(kdtEntrys);
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
    	IRow row = kdtEntrys.getRow(e.getRowIndex());
    	if(row.getCell("amount").getValue() != null) {
    		String upper = com.kingdee.eas.fdc.basedata.client.FDCClientHelper.getChineseFormat(new BigDecimal(row.getCell("amount").getValue().toString()), false);
    		row.getCell("upperAmount").setValue(upper);
    	}

    	//如果付款单位变化清空收款账号(新增时不删除，付款单位清空的时候删除 )
    	if(kdtEntrys.getColumn(e.getColIndex()).getKey().equals("entryPayUnit")/* && row.getCell("payIsInputIn").getValue().equals(false)*/) {
	    	CompanyOrgUnitInfo old = (CompanyOrgUnitInfo) e.getOldValue();
	    	CompanyOrgUnitInfo newValue = (CompanyOrgUnitInfo) row.getCell("entryPayUnit").getValue();
	    	if(newValue == null || old != null && !old.getId().equals(newValue.getId())) {
				row.getCell("payAccount").setValue(null);
				row.getCell("payBank").setValue(null);
				row.getCell("payAccProperty").setValue(null);
	    	}
    	}
    	//如果收款单位变化清空收款账号(新增时不删除，收款单位清空的时候删除 )
    	if(kdtEntrys.getColumn(e.getColIndex()).getKey().equals("recUnit")/* && row.getCell("recIsInputIn").getValue().equals(false)*/) {
	    	CompanyOrgUnitInfo old = (CompanyOrgUnitInfo) e.getOldValue();
	    	CompanyOrgUnitInfo newValue = (CompanyOrgUnitInfo) row.getCell("recUnit").getValue();
	    	if(newValue == null || old != null && !old.getId().equals(newValue.getId())) {
				row.getCell("recAccount").setValue(null);
				row.getCell("recBank").setValue(null);
				row.getCell("recAccProperty").setValue(null);
	    	}
    	}      
        if(row.getCell("entryPayUnit").getValue() != null) {
        	//为编辑行的付款账号添加过滤条件(付款公司下的账号)
        	final KDBizPromptBox kdtEntrys_payAccount_PromptBox = new KDBizPromptBox();
            kdtEntrys_payAccount_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery");
            kdtEntrys_payAccount_PromptBox.setVisible(true);
            kdtEntrys_payAccount_PromptBox.setEditable(true);
            kdtEntrys_payAccount_PromptBox.setDisplayFormat("$number$");
            kdtEntrys_payAccount_PromptBox.setEditFormat("$number$");
            kdtEntrys_payAccount_PromptBox.setCommitFormat("$number$");
            KDTDefaultCellEditor kdtEntrys_payAccount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_payAccount_PromptBox);
            row.getCell("payAccount").setEditor(kdtEntrys_payAccount_CellEditor);//当前行的单元格设置条件
            ObjectValueRender kdtEntrys_payAccount_OVR = new ObjectValueRender();
            kdtEntrys_payAccount_OVR.setFormat(new BizDataFormat("$bankAccountNumber$"));
            row.getCell("payAccount").setRenderer(kdtEntrys_payAccount_OVR);
            if(!chkisGroup.isSelected()) {//非集团付款无需过滤
	            CompanyOrgUnitInfo company = (CompanyOrgUnitInfo) row.getCell("entryPayUnit").getValue();
				EntityViewInfo evi = new EntityViewInfo();
		        FilterInfo filter = new FilterInfo();
		        evi.setFilter(filter);
		        filter.getFilterItems().add(new FilterItemInfo("Company.longnumber", company.getLongNumber()+"%", CompareType.LIKE));
		        filter.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//非注销账号
		        kdtEntrys_payAccount_PromptBox.setEntityViewInfo(evi);
            }
	        kdtEntrys_payAccount_PromptBox.addSelectorListener(new SelectorListener() {
	        	@Override
	        	public void willShow(SelectorEvent arg0) {
	        		int index = kdtEntrys.getSelectManager().getActiveRowIndex();
					IRow row = kdtEntrys.getRow(index);
	        		if(row.getCell("entryPayUnit").getValue() == null) {
	        			MsgBox.showWarning("请先选择付款单位!");
	        			SysUtil.abort();
	        		}
	        	}
	        });
        }
    	if(row.getCell("recUnit").getValue() != null) {
    		//为编辑行的收款账号添加过滤条件(收款公司下的账号)
            final KDBizPromptBox kdtEntrys_recAccount_PromptBox = new KDBizPromptBox();
            kdtEntrys_recAccount_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery");
            kdtEntrys_recAccount_PromptBox.setVisible(true);
            kdtEntrys_recAccount_PromptBox.setEditable(true);
            kdtEntrys_recAccount_PromptBox.setDisplayFormat("$number$");
            kdtEntrys_recAccount_PromptBox.setEditFormat("$number$");
            kdtEntrys_recAccount_PromptBox.setCommitFormat("$number$");
            KDTDefaultCellEditor kdtEntrys_recAccount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_recAccount_PromptBox);
            row.getCell("recAccount").setEditor(kdtEntrys_recAccount_CellEditor);//当前行的单元格设置条件
            ObjectValueRender kdtEntrys_recAccount_OVR = new ObjectValueRender();
            kdtEntrys_recAccount_OVR.setFormat(new BizDataFormat("$bankAccountNumber$"));
            row.getCell("recAccount").setRenderer(kdtEntrys_recAccount_OVR);
//            kdtEntrys_recAccount_PromptBox = (KDBizPromptBox) row.getCell("recAccount").getEditor().getComponent();
            CompanyOrgUnitInfo company = (CompanyOrgUnitInfo) row.getCell("recUnit").getValue();
			EntityViewInfo evi = new EntityViewInfo();
	        FilterInfo filter = new FilterInfo();
	        evi.setFilter(filter);
	        filter.getFilterItems().add(new FilterItemInfo("Company.longnumber", company.getLongNumber()+"%", CompareType.LIKE));
	        filter.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//非注销账号
	        kdtEntrys_recAccount_PromptBox.setEntityViewInfo(evi);
	        kdtEntrys_recAccount_PromptBox.addSelectorListener(new SelectorListener() {
				public void willShow(SelectorEvent event) {
					int index = kdtEntrys.getSelectManager().getActiveRowIndex();
					IRow row = kdtEntrys.getRow(index);
					if(row.getCell("recUnit").getValue() == null) {
						MsgBox.showWarning("请先选择收款单位!");
						SysUtil.abort();
					}
				}
	        });
	        CompanyOrgUnitInfo com = (CompanyOrgUnitInfo) row.getCell("recUnit").getValue();
	        AdminOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentAdminUnit();
	    	final PurchaseOrgUnitInfo purchaseInfo = getComOrgByPurchaseOrg(null, orgInfo.getId().toString());//事业部
	    	CompanyOrgUnitInfo orgUnitInfo = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(purchaseInfo.getId()));//事业部对应的财务组织
	    	if(!com.getLongNumber().contains(orgUnitInfo.getLongNumber()) && !com.getNumber().equals("A")) {
	    		initKDTableRowTextCell(row, "recAccountText", "$name$");
	    	}
    	}
    }

    /**
     * output kdtEntrys_tableClicked method
     */
    protected void kdtEntrys_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
    	super.kdtEntrys_tableClicked(e);
		IBoAttchAsso iBoAttchAsso = BoAttchAssoFactory.getRemoteInstance();
		FundsApplicationEntryCollection entryColl = editData.getEntrys();
    	for(int i = 0; i < entryColl.size(); i++) {
    		FundsApplicationEntryInfo info = entryColl.get(i);
    		if(info == null || info.getId() == null)
    			continue;
	    	String oql = "where boID='" + info.getId().toString() + "'";
	    	BoAttchAssoCollection attcoll = iBoAttchAsso.getBoAttchAssoCollection(oql);
	    	if(attcoll != null && attcoll.size() > 0) {
	    		kdtEntrys.getRow(i).getCell("attCount").setValue(attcoll.size());
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
     * output actionSave_actionPerformed
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
    	if(editData.getBizState().equals(BizState.submited) || editData.getBizState().equals(BizState.audited)) {
    		MsgBox.showWarning("非新增或者保存状态单据无法保存!");
    		SysUtil.abort();
    	}
    	setSingleMaxAmount();
    	this.editData.setBizState(BizState.saved);
    	bizState.setSelectedItem(BizState.saved);
        super.actionSave_actionPerformed(e);
//        setOprtState(OprtState.VIEW);
//        btnSave.setEnabled(true);
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
//    	if(!(editData.getBizState().equals(BizState.submited) || editData.getBizState().equals(BizState.saved))) {
//    		MsgBox.showWarning("非保存或提交状态单据无法提交!");
//    		SysUtil.abort();
//    	}
    	setSingleMaxAmount();
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
        return com.kingdee.eas.custom.funds.FundsApplicationFactory.getRemoteInstance();
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
        com.kingdee.eas.custom.funds.FundsApplicationInfo objectValue = new com.kingdee.eas.custom.funds.FundsApplicationInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizState(BizState.addnew);
    	AdminOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentAdminUnit();
    	try {
			PurchaseOrgUnitInfo purchaseInfo = getComOrgByPurchaseOrg(null, orgInfo.getId().toString());
			objectValue.setAppCompany(purchaseInfo.getName());
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
        return objectValue;
    }

}