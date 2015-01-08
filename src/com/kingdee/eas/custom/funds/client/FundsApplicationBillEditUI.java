/**
 * output package name
 */
package com.kingdee.eas.custom.funds.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
import com.kingdee.eas.basedata.assistant.IBank;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.IAdminOrgUnit;
import com.kingdee.eas.basedata.org.ICompanyOrgUnit;
import com.kingdee.eas.basedata.org.IPurchaseOrgUnit;
import com.kingdee.eas.basedata.org.OrgConstants;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitFactory;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyBizUnitF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.funds.BizState;
import com.kingdee.eas.custom.funds.FundsApplicationBillEntryCollection;
import com.kingdee.eas.custom.funds.FundsApplicationBillEntryInfo;
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
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.KDPromptSelector;
import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;

/**
 * output class name
 */
public class FundsApplicationBillEditUI extends AbstractFundsApplicationBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FundsApplicationBillEditUI.class);
    
    /**
     * output class constructor
     */
    public FundsApplicationBillEditUI() throws Exception
    {
        super();
    }
    
    public void onLoad() throws Exception {
    	initComponent();
    	/*---------------------------------------------*/
    	//设置分录必录
    	setEntryColRequired(kdtEntrys, new String[] {"entryPayUnit", "payAccount", "recUnit", "recAccountText", "amount", "usage"});
    	/*---------------------------------------------*/
    	AdminOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentAdminUnit();
    	final PurchaseOrgUnitInfo purchaseInfo = getComOrgByPurchaseOrg(null, orgInfo.getId().toString());//事业部
    	/*---------------------------------------------*/
    	//设置付款单位可以选到本区域结算中心的过滤
    	String area = purchaseInfo.getName().substring(0, 2);
    	String oqls = "where name like '%"+area+"%结算中心%'";
    	if(area.equals("嘉兴"))
    		oqls = "where name like '%上海%结算中心%'";
    	if(area.equals("廊坊"))
    		oqls = "where name like '%北京%结算中心%'";
    	if(area.equals("旭辉")) 
    		oqls = "where name like '%集团%结算中心%'";
    	if(area.equals("镇江"))
    		oqls = "where name like '%南京%结算中心%'";
		CompanyOrgUnitInfo costCenter = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(oqls);//结算中心
    	EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        evi.setFilter(filter);
        CompanyOrgUnitInfo companyUnit = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(orgInfo.getId()));
        filter.getFilterItems().add(new FilterItemInfo("longNumber",companyUnit.getLongNumber()+"%",CompareType.LIKE));
        filter.getFilterItems().add(new FilterItemInfo("isOUSealUp","0",CompareType.EQUALS));
//        filter.getFilterItems().add(new FilterItemInfo("level","6",CompareType.EQUALS));
        filter.getFilterItems().add(new FilterItemInfo("name","%历史%",CompareType.NOTLIKE));
	    filter.getFilterItems().add(new FilterItemInfo("longnumber", costCenter.getLongNumber()+"%", CompareType.LIKE));
//	    filter.setMaskString("#0 and #1 and #2 and #3 or #4");
	    filter.setMaskString("#0 and #1 and #2 or #3");
	    
	    //设置分录付款单位树状
        CompanyBizUnitF7 payCompanyF7Tree = getCompanyBizUnitF7(orgInfo.getId().toString());
        KDBizPromptBox entryPayUnit = null;
        if(purchaseInfo.getNumber().equals("G")) {
        	entryPayUnit = buildKDTableF7Col(kdtEntrys, "entryPayUnit", "com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct", 
        		"$Description$", "$Description$", "$Description$", "$Description$", null, payCompanyF7Tree);
        }
        else
        	entryPayUnit = buildKDTableF7Col(kdtEntrys, "entryPayUnit", "com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct", 
            		"$Description$", "$Description$", "$Description$", "$Description$", null, null);
        entryPayUnit.setEntityViewInfo(evi);
        //付款单位值改变
        entryPayUnit.addDataChangeListener(getDataChangeListener("entryPayUnit"));
        
        //设置分录收款单位树状
        CompanyBizUnitF7 recCompanyF7Tree = getCompanyBizUnitF7(OrgConstants.DEF_CU_ID);
        KDBizPromptBox recUnit = buildKDTableF7Col(kdtEntrys, "recUnit", "com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct", 
        		"$Description$", "$Description$", "$Description$", "$Description$", null, recCompanyF7Tree);
        //收款单位值改变
        recUnit.addDataChangeListener(getDataChangeListener("recUnit"));
        
        //格式化分录文本字段收款账号为F7
    	KDBizPromptBox recAccountBox = buildKDTableF7Col(kdtEntrys, "recAccountText", "com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery", 
    			"$name$", "$name$", "$name$", "$name$", null, null);
    	recAccountBox.addSelectorListener(getSelectorListener("recUnit", "请先选择收款单位!"));
    	//格式化分录付款账号
    	KDBizPromptBox payAccountBox = buildKDTableF7Col(kdtEntrys, "payAccount", "com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery", 
    			"$name$", "$name$", "$name$", "$name$", null, null);
    	payAccountBox.addSelectorListener(getSelectorListener("entryPayUnit", "请先选择付款单位!"));
    	/*---------------------------------------------*/
    	initKDEntryAddNewLineButton(false);
    	super.onLoad();
    	setButtonState();
    }
    //初始化控件
    private void initComponent() {
    	//控件是否显示
    	contNumber.setVisible(false);
    	contBizDate.setVisible(false);
    	contDescription.setVisible(false);
    	contCreateTime.setVisible(false);
    	contCreator.setVisible(false);
    	//控件是否可编辑
    	contappCompany.setEnabled(false);
    	contauditDate.setEnabled(false);
    	contbizState.setVisible(false);
    	contauditOrg.setEnabled(false);
    	//按钮是否可见
    	btnNext.setVisible(false);
    	btnPre.setVisible(false);
    	btnFirst.setVisible(false);
    	btnLast.setVisible(false);
    	btnTraceUp.setVisible(false);
    	btnTraceDown.setVisible(false);
    	btnCreateFrom.setVisible(false);
    	btnCreateTo.setVisible(false);
    	//按钮图标
    	btnAudit.setIcon(EASResource.getIcon("imgTbtn_auditing"));
    	btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_fauditing"));
    	//构建分录附件数
        IColumn col = kdtEntrys.addColumn();
        col.setKey("attCount");
        col.getStyleAttributes().setLocked(true);
        col.getStyleAttributes().setHorizontalAlign(HorizontalAlignment.CENTER);
        kdtEntrys.getHeadRow(0).getCell("attCount").setValue("附件数");
    }
    //设置按钮状态
    private void setButtonState() {
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
    }
    //设置分录列必录
    private void setEntryColRequired(KDTable table, String[] cols) {
    	for(int i = 0; i < cols.length; i++) {
    		table.getColumn(cols[i]).setRequired(true);
    	}
    }
    //为分录F7添加DataChangeListener
    private DataChangeListener getDataChangeListener(final String col) {
    	DataChangeListener dataChangeListener = new DataChangeListener() {
			public void dataChanged(DataChangeEvent arg) {
				IRow row = kdtEntrys.getRow(kdtEntrys.getSelectManager().getActiveRowIndex());
				CompanyOrgUnitInfo companyNew = (CompanyOrgUnitInfo) arg.getNewValue();
				CompanyOrgUnitInfo companyOld = (CompanyOrgUnitInfo) arg.getOldValue();
				//付款单位
				if(col.equals("entryPayUnit")) {
					//清空付款单位时清空相关账户信息
//					if(companyNew == null) {
//						row.getCell("payAccount").setValue(null);//付款账号
//						row.getCell("payBank").setValue(null);//付款行
//						row.getCell("payAccProperty").setValue(null);//付款账户性质
//					}
					//付款单位实际发生变化时清空相关账户信息
					if(companyNew == null || companyNew != null && companyOld != null && !companyNew.getNumber().equals(companyOld.getNumber())) {
						row.getCell("payAccount").setValue(null);//付款账号
						row.getCell("payBank").setValue(null);//付款行
						row.getCell("payAccProperty").setValue(null);//付款账户性质
					}
				}
				//收款单位
				if(col.equals("recUnit")) {
					//清空收款单位时清空相关账户信息
//					if(companyNew == null) {
//						row.getCell("recAccountText").setValue(null);//收款账号
//						row.getCell("recBank").setValue(null);//收款行
//						row.getCell("recAccProperty").setValue(null);//收款账户性质
//					}
					//收款单位实际发生变化时清空相关账户信息
					if(companyNew == null || companyNew != null && companyOld != null && !companyNew.getNumber().equals(companyOld.getNumber())) {
						row.getCell("recAccountText").setValue(null);//收款账号
						row.getCell("recBank").setValue(null);//收款行
						row.getCell("recAccProperty").setValue(null);//收款账户性质
					}
				}
			}
    	};
    	return dataChangeListener;
    }
    //为分录某个F7单元格设置SelectorListener
    private SelectorListener getSelectorListener(final String cell, final String warningMsg) {
    	SelectorListener selectorListener = new SelectorListener() {
			public void willShow(SelectorEvent arg) {
				int index = kdtEntrys.getSelectManager().getActiveRowIndex();
				IRow row = kdtEntrys.getRow(index);
        		if(row.getCell(cell).getValue() == null) {
        			MsgBox.showWarning(warningMsg);
        			SysUtil.abort();
        		}
			}
    	};
    	return selectorListener;
    }
    //获取财务组织树状条件
    private CompanyBizUnitF7 getCompanyBizUnitF7(String RootId) {
    	CompanyBizUnitF7 companyBizUnitF7 = new CompanyBizUnitF7(this);
    	companyBizUnitF7.showCheckBoxOfShowingAllOUs();
    	companyBizUnitF7.setIsCUFilter(false);
    	companyBizUnitF7.setRootUnitID(RootId);
    	companyBizUnitF7.disablePerm();
    	return companyBizUnitF7;
    }
    /**
     * 分录新增按钮
     * @param isGroup 是否集团付款
     * 集团付款默认带出付款单位为集团，以及集团下的账号，银行等
     */
    private void initKDEntryAddNewLineButton(boolean isGroup) {
    	kdtEntrys_detailPanel.getAddNewLineButton().removeActionListener(kdtEntrys_detailPanel.getAddNewLineButton().getActionListeners()[0]);
    	if(!isGroup) {
	        kdtEntrys_detailPanel.getAddNewLineButton().addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					IRow add = kdtEntrys.addRow();
					add.getCell("recDate").setValue(new Date());
				}
	        });
    	} else {
    		kdtEntrys_detailPanel.getAddNewLineButton().addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionevent) {
					IRow add = kdtEntrys.addRow();
					add.getCell("recDate").setValue(new Date());
					AccountBankInfo groupAccount = getDefaultAccountBankInfo("002.021.001.01");//集团下的账号 编码待定
					BankInfo bankInfo = getBankInfoFromAccount(groupAccount);
					CompanyOrgUnitInfo cifiGroup = getCompanyOrgUnitInfo("A");//旭辉集团股份有限公司
					add.getCell("entryPayUnit").setValue(cifiGroup);//付款公司
					add.getCell("payAccount").setValue(groupAccount);//付款账号
					add.getCell("payBank").setValue(bankInfo.getName());//付款行
					add.getCell("payAccProperty").setValue(groupAccount.getDescription());//付款账户性质
					
					//集团付款时默认带出收款单位为本区域的结算中心
					PurchaseOrgUnitInfo purchaseOrgUnit = getCurPurchaseOrgUnitInfo();
					String area = purchaseOrgUnit.getName().substring(0, 2);
//					String oql = "where name like '%"+area+"%结算中心%' and isleaf='1'";
					String oql = "where name like '%"+area+"%结算中心%'";
					if(area.equals("旭辉")) 
						oql = "where name like '%集团%结算中心%'";
					if(area.equals("嘉兴"))
						oql = "where name like '%上海%结算中心%'";
			    	if(area.equals("廊坊"))
			    		oql = "where name like '%北京%结算中心%'";
			    	if(area.equals("镇江"))
			    		oql = "where name like '%南京%结算中心%'";
					try {
						CompanyOrgUnitInfo costCenter = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(oql);
						AccountBankInfo costCenterAccountBankInfo = getCostCenterAccountBankInfo(costCenter);
						BankInfo costCenterBankInfo = getBankInfoFromAccount(costCenterAccountBankInfo);
						add.getCell("recUnit").setValue(costCenter);//收款单位 结算中心
						add.getCell("recAccountText").setValue(costCenterAccountBankInfo); //结算中心账号
						add.getCell("recBank").setValue(costCenterBankInfo); //收款银行
						add.getCell("recAccProperty").setValue(costCenterAccountBankInfo.getDescription()); //收款行性质
					} catch (EASBizException e) {
						e.printStackTrace();
					} catch (BOSException e) {
						e.printStackTrace();
					}
				}
    		});
    	}
    }
    //根据结算中心获取结算中心下的银行账号
    private AccountBankInfo getCostCenterAccountBankInfo(CompanyOrgUnitInfo costCenter) {
    	AccountBankInfo accountBankInfo = null;
    	try {
			IAccountBank iAccountBank = AccountBankFactory.getRemoteInstance();
			EntityViewInfo evi = new EntityViewInfo();
	        FilterInfo filter = new FilterInfo();
	        evi.setFilter(filter);
	        filter.getFilterItems().add(new FilterItemInfo("Company.longnumber", costCenter.getLongNumber()+"%", CompareType.LIKE));
	        filter.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//非注销账号
	        AccountBankCollection accountBankCollection = iAccountBank.getAccountBankCollection(evi);
	        accountBankInfo = accountBankCollection.get(0);
		} catch (BOSException e) {
			e.printStackTrace();
		}
		return accountBankInfo;
    }
    /**
     * 获取当前登陆组织的采购组织(事业部)
     */
    private PurchaseOrgUnitInfo getCurPurchaseOrgUnitInfo() {
    	AdminOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentAdminUnit();
    	PurchaseOrgUnitInfo purchaseInfo = null;
    	try {
    		purchaseInfo = getComOrgByPurchaseOrg(null, orgInfo.getId().toString());//事业部
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
		return purchaseInfo;
    }
    /**
     * 判断收款单位是否是当前区域下的公司
     * (集团以及结算中心除外)
     * @param parent
     * @param child
     * @return
     */
    private boolean isChildCompany(CompanyOrgUnitInfo parent, CompanyOrgUnitInfo child) {
    	boolean flag = true;
    	if(child.getNumber().equals("A") || child.getName().contains("结算中心"))
    		return true;
    	String plongNumber = parent.getLongNumber();
    	String clongNumber = child.getLongNumber();
    	if(clongNumber.indexOf(plongNumber) < 0)
    		flag = false;
    	return flag;
    }
    /**
     * 根据采购组织获取对应的财务组织
     * @param purchaseInfo
     * @return
     */
    private CompanyOrgUnitInfo getCompanyInfoFromPurchase(PurchaseOrgUnitInfo purchaseInfo) {
    	CompanyOrgUnitInfo companyOrgUnitInfo = null;
    	try {
			ICompanyOrgUnit iCompanyOrgUnit = CompanyOrgUnitFactory.getRemoteInstance();
			companyOrgUnitInfo = iCompanyOrgUnit.getCompanyOrgUnitInfo(new ObjectUuidPK(purchaseInfo.getId()));
		} catch (BOSException e) {
			e.printStackTrace();
		} catch (EASBizException e) {
			e.printStackTrace();
		}
    	return companyOrgUnitInfo;
    }
    /**
     * loadFields恢复分录收款账号控件是F7还是文本
     */
    private void restoreKDEntryF7Cell() {
    	AdminOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentAdminUnit();
    	PurchaseOrgUnitInfo purchaseInfo = null;
    	try {
    		purchaseInfo = getComOrgByPurchaseOrg(null, orgInfo.getId().toString());//事业部
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
		CompanyOrgUnitInfo pCompany = getCompanyInfoFromPurchase(purchaseInfo);
		
    	FundsApplicationBillEntryCollection entrys = editData.getEntrys();
    	for(int i = 0; i < entrys.size(); i++) {
    		final IRow row = kdtEntrys.getRow(i);
    		FundsApplicationBillEntryInfo entryInfo = entrys.get(i);
    		CompanyOrgUnitInfo recUnit = entryInfo.getRecUnit();
    		recUnit = getCompanyOrgUnitInfo(recUnit.getNumber());
    		CompanyOrgUnitInfo entryPayUnit = entryInfo.getEntryPayUnit();
    		entryPayUnit = getCompanyOrgUnitInfo(entryPayUnit.getNumber());
    		//格式化分录付款账号,添加过滤条件
        	KDBizPromptBox payAccountBox = buildKDTableF7Col(kdtEntrys, "payAccount", "com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery", 
        			"$name$", "$name$", "$name$", "$name$", null, null);
        	EntityViewInfo evip = getEntityViewInfoFromCompany(entryPayUnit);
	        payAccountBox.setEntityViewInfo(evip);
	        payAccountBox.addSelectorListener(getSelectorListener("entryPayUnit", "请先选择付款单位!"));
	        
    		if(!isChildCompany(pCompany, recUnit)) {
    			buildTableRowTextCell(row, "recAccountText");
    		} else {
    			KDBizPromptBox recAccountBox = buildTableRowF7Cell(row, "recAccountText", "com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery", 
    	    			"$name$", "$name$", "$name$", "$name$", null, null);
    			EntityViewInfo evi = getEntityViewInfoFromCompany(recUnit);
    	        recAccountBox.setEntityViewInfo(evi);
    	        recAccountBox.addDataChangeListener(new DataChangeListener() {
					public void dataChanged(DataChangeEvent arg) {
						Object newValue = arg.getNewValue();
						if(newValue instanceof AccountBankInfo) {
							AccountBankInfo accountBankInfo = (AccountBankInfo) arg.getNewValue();
							if(accountBankInfo != null) {
								BankInfo bankInfo = getBankInfoFromAccount(accountBankInfo);
								row.getCell("recBank").setValue(bankInfo.getName());//收款行
								row.getCell("recAccProperty").setValue(accountBankInfo.getDescription());//收款账户性质
							} else {
								row.getCell("recBank").setValue(null);//收款行
								row.getCell("recAccProperty").setValue(null);//收款账户性质
							}
						} else if(newValue == null) {
							row.getCell("recBank").setValue(null);//收款行
							row.getCell("recAccProperty").setValue(null);//收款账户性质
						}
					}
    	        });
    		}
    	}
    	if(chkisGroup.isSelected()) {
    		//集团付款时,收款单位只能选到结算中心
    		KDBizPromptBox recUnit = buildKDTableF7Col(kdtEntrys, "recUnit", "com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct", 
            		"$name$", "$name$", "$name$", "$name$", null, null);
    		EntityViewInfo evi = new EntityViewInfo();
    		FilterInfo filter = new FilterInfo();
    		evi.setFilter(filter);
    		filter.getFilterItems().add(new FilterItemInfo("name", "%结算中心%", CompareType.LIKE));
			filter.getFilterItems().add(new FilterItemInfo("isleaf", "1", CompareType.EQUALS));
			recUnit.setEntityViewInfo(evi);
			recUnit.addDataChangeListener(getDataChangeListener("recUnit"));
    	}
    }
    /**
     * loadFields恢复附件数
     */
    private void restoreAttachmentCount() {
    	try {
			IBoAttchAsso iBoAttchAsso = BoAttchAssoFactory.getRemoteInstance();
			FundsApplicationBillEntryCollection entryColl = editData.getEntrys();
			for(int i = 0; i < entryColl.size(); i++) {
    			FundsApplicationBillEntryInfo info = entryColl.get(i);
    			if(info == null || info.getId() == null)
        			continue;
    			String oql = "where boID='" + info.getId().toString() + "'";
    			BoAttchAssoCollection attcoll = iBoAttchAsso.getBoAttchAssoCollection(oql);
    			if(attcoll != null) {
    				kdtEntrys.getRow(i).getCell("attCount").setValue(attcoll.size());
    			}
    		}
		} catch (BOSException e) {
			e.printStackTrace();
		}
    }
    //根据收付款单位获取收付款账号过滤条件
    private EntityViewInfo getEntityViewInfoFromCompany(CompanyOrgUnitInfo company) {
    	EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        evi.setFilter(filter);
        filter.getFilterItems().add(new FilterItemInfo("Company.longnumber", company.getLongNumber()+"%", CompareType.LIKE));
        filter.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//非注销账号
        
        return evi;
    }
    /**
     * loadFields恢复分录新增按钮(是否集团付款)
     * @param number
     * @return
     */
    private void restoreKDEntryAddNewLineButton() {
    	if(chkisGroup.isSelected())
    		initKDEntryAddNewLineButton(true);
    	else
    		initKDEntryAddNewLineButton(false);
    }
    //获取集团默认账号
    private AccountBankInfo getDefaultAccountBankInfo(String number) {
    	AccountBankInfo accountBankInfo = null;
    	try {
			IAccountBank iAccountBank = AccountBankFactory.getRemoteInstance();
			AccountBankCollection accountBankCollection = iAccountBank.getAccountBankCollection("where number='"+number+"'");
			if(accountBankCollection.size() > 0) 
				accountBankInfo = accountBankCollection.get(0);
		} catch (BOSException e) {
			e.printStackTrace();
		}
    	return accountBankInfo;
    }
    //根据编码获取财务组织
    private CompanyOrgUnitInfo getCompanyOrgUnitInfo(String number) {
    	CompanyOrgUnitInfo company = null;
    	try {
			ICompanyOrgUnit iCompanyOrgUnit = CompanyOrgUnitFactory.getRemoteInstance();
			company = iCompanyOrgUnit.getCompanyOrgUnitInfo("where number='"+number+"'");
		} catch (BOSException e) {
			e.printStackTrace();
		} catch (EASBizException e) {
			e.printStackTrace();
		}
		return company;
    }
    //根据银行账户获取银行信息
    private BankInfo getBankInfoFromAccount(AccountBankInfo accountBankInfo) {
    	BankInfo bankInfo = null;
    	bankInfo = accountBankInfo.getBank();
    	try {
    		IBank iBank = BankFactory.getRemoteInstance();
			bankInfo = iBank.getBankInfo(new ObjectUuidPK(bankInfo.getId()));
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
    	return bankInfo;
    }
    //校验分录字段是否为空
    private void checkEntryRequriedCell(KDTable table, String[] cols) {
    	IRow headRow = table.getHeadRow(0);
    	for(int i = 0; i < table.getRowCount(); i++) {
    		IRow row = table.getRow(i);
    		for(int j = 0; j < cols.length; j++) {
    			if(row.getCell(cols[j]).getValue() == null) {
    				MsgBox.showWarning("分录第"+(i+1)+"行,"+headRow.getCell(cols[j]).getValue()+" 不能为空!");
    				SysUtil.abort();
    			}
    		}
    	}
    }
    //校验分录收款单位 (集团与区域公司不能共存, 结算中心目前默认可以与集团共存)
    private void checkRecUnitValid() {
    	List recUnitList = new LinkedList();
    	for(int i = 0; i < kdtEntrys.getRowCount(); i++) {
    		IRow row = kdtEntrys.getRow(i);
    		CompanyOrgUnitInfo recUnit = (CompanyOrgUnitInfo) row.getCell("recUnit").getValue();
    		if(recUnit.getNumber().equals("A") || recUnit.getName().contains("结算中心"))
    			continue;
    		else
    			recUnitList.add(recUnit.getName());
    	}
    	if(recUnitList.size() > 0 && recUnitList.size() != kdtEntrys.getRowCount()) {
    		MsgBox.showWarning("分录收款单位:\n旭辉集团股份有限公司或者结算中心不能与其他公司共存!");
    		SysUtil.abort();
    	}
    }
    //校验分录收款账户性质 (可动用不能与其他性质共存, 非可动用只能与受监管共存)
    private void checkAccPropertyValid() {
    	Set recAccPropertySet = new HashSet();
    	for(int i = 0; i < kdtEntrys.getRowCount(); i++) {
    		IRow row = kdtEntrys.getRow(i);
    		Object recAccProperty = row.getCell("recAccProperty").getValue();
    		if(recAccProperty != null)
    			recAccPropertySet.add(recAccProperty);
    	}
    	if(recAccPropertySet.contains("可动用") &&  recAccPropertySet.size() > 1) {
    		MsgBox.showWarning("分录收款账户性质:\n银行账户性质可动用不能与其他性质共存!");
    		SysUtil.abort();
    	}
    		
    }
    //校验事件
    protected void verifyInput(ActionEvent e) throws Exception {
    	super.verifyInput(e);
    	checkEntryRequriedCell(kdtEntrys, new String[] {"entryPayUnit", "payAccount", "recUnit", "recAccountText", "amount", "usage"});
    	checkRecUnitValid();
    	checkAccPropertyValid();
    }
    //是否集团付款
    protected void chkisGroup_actionPerformed(ActionEvent e) throws Exception {
    	kdtEntrys.removeRows();
    	if(chkisGroup.isSelected()) {
    		initKDEntryAddNewLineButton(true);
    		//集团付款时,收款单位只能选到结算中心
    		KDBizPromptBox recUnit = buildKDTableF7Col(kdtEntrys, "recUnit", "com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct", 
            		"$name$", "$name$", "$name$", "$name$", null, null);
    		EntityViewInfo evi = new EntityViewInfo();
    		FilterInfo filter = new FilterInfo();
    		evi.setFilter(filter);
    		filter.getFilterItems().add(new FilterItemInfo("name", "%结算中心%", CompareType.LIKE));
			filter.getFilterItems().add(new FilterItemInfo("isleaf", "1", CompareType.EQUALS));
			recUnit.setEntityViewInfo(evi);
			recUnit.addDataChangeListener(getDataChangeListener("recUnit"));
    	} else {
    		initKDEntryAddNewLineButton(false);
    		//设置分录收款单位树状
            CompanyBizUnitF7 recCompanyF7Tree = getCompanyBizUnitF7(OrgConstants.DEF_CU_ID);
            KDBizPromptBox recUnit = buildKDTableF7Col(kdtEntrys, "recUnit", "com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct", 
            		"$Description$", "$Description$", "$Description$", "$Description$", null, recCompanyF7Tree);
            //收款单位值改变
            recUnit.addDataChangeListener(getDataChangeListener("recUnit"));
    	}
    }
    //分录点击事件
    protected void kdtEntrys_tableClicked(KDTMouseEvent e) throws Exception {
    	super.kdtEntrys_tableClicked(e);
    	restoreAttachmentCount();
    }
    //分录编辑停止事件
    protected void kdtEntrys_editStopped(KDTEditEvent e) throws Exception {
    	super.kdtEntrys_editStopped(e);
    	AdminOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentAdminUnit();
    	final PurchaseOrgUnitInfo purchaseInfo = getComOrgByPurchaseOrg(null, orgInfo.getId().toString());//事业部
    	CompanyOrgUnitInfo pCompany = getCompanyInfoFromPurchase(purchaseInfo);
    	
    	final IRow row = kdtEntrys.getRow(e.getRowIndex());
    	CompanyOrgUnitInfo recUnit = (CompanyOrgUnitInfo) row.getCell("recUnit").getValue();
    	CompanyOrgUnitInfo entryPayUnit = (CompanyOrgUnitInfo) row.getCell("entryPayUnit").getValue();
    	
    	if(entryPayUnit != null) {
    		KDBizPromptBox payAccountBox = buildTableRowF7Cell(row, "payAccount", "com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery", 
	    			"$name$", "$name$", "$name$", "$name$", null, null);
    		//根据付款单位设置付款账号过滤条件
    		EntityViewInfo evi = new EntityViewInfo();
	        FilterInfo filter = new FilterInfo();
	        evi.setFilter(filter);
	        filter.getFilterItems().add(new FilterItemInfo("Company.longnumber", entryPayUnit.getLongNumber()+"%", CompareType.LIKE));
	        filter.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//非注销账号
	        payAccountBox.setEntityViewInfo(evi);
	        payAccountBox.addSelectorListener(getSelectorListener("entryPayUnit", "请先选择付款单位"));
	        
	        //付款单位为集团 自动带出集团账户相关信息
    		if(entryPayUnit.getNumber().equals("A")) {
				AccountBankInfo groupAccount = getDefaultAccountBankInfo("002.021.001.01");//集团下的账号 
				BankInfo bankInfo = getBankInfoFromAccount(groupAccount);
				row.getCell("payAccount").setValue(groupAccount);//付款账号
				row.getCell("payBank").setValue(bankInfo.getName());//付款行
				row.getCell("payAccProperty").setValue(groupAccount.getDescription());//付款账户性质
			}
    		if(entryPayUnit.getName().contains("结算中心")) {
    			AccountBankInfo costCenterAccountBankInfo = getCostCenterAccountBankInfo(entryPayUnit);
				BankInfo costCenterBankInfo = getBankInfoFromAccount(costCenterAccountBankInfo);
				row.getCell("payAccount").setValue(costCenterAccountBankInfo); //结算中心账号
				row.getCell("payBank").setValue(costCenterBankInfo); //付款行
				row.getCell("payAccProperty").setValue(costCenterAccountBankInfo.getDescription()); //付款账户性质
    		}
    	}
    	if(recUnit != null) {
    		if(!isChildCompany(pCompany, recUnit)) {
    			buildTableRowTextCell(row, "recAccountText");//收款单位非本区域的公司时，收款账号手动输入
    		} else {
    			KDBizPromptBox recAccountBox = buildTableRowF7Cell(row, "recAccountText", "com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery", 
    	    			"$name$", "$name$", "$name$", "$name$", null, null);
    			
    			EntityViewInfo evi = new EntityViewInfo();
    	        FilterInfo filter = new FilterInfo();
    	        evi.setFilter(filter);
    	        filter.getFilterItems().add(new FilterItemInfo("Company.longnumber", recUnit.getLongNumber()+"%", CompareType.LIKE));
    	        filter.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//非注销账号
    	        recAccountBox.setEntityViewInfo(evi);
    	        
    	        recAccountBox.addSelectorListener(getSelectorListener("recUnit", "请先选择收款单位!"));
    	        recAccountBox.addDataChangeListener(new DataChangeListener() {
					public void dataChanged(DataChangeEvent arg) {
						Object newValue = arg.getNewValue();
						if(newValue instanceof AccountBankInfo) {
							AccountBankInfo accountBankInfo = (AccountBankInfo) arg.getNewValue();
							if(accountBankInfo != null) {
								BankInfo bankInfo = getBankInfoFromAccount(accountBankInfo);
								row.getCell("recBank").setValue(bankInfo.getName());//收款行
								row.getCell("recAccProperty").setValue(accountBankInfo.getDescription());//收款账户性质
							} else {
								row.getCell("recBank").setValue(null);//收款行
								row.getCell("recAccProperty").setValue(null);//收款账户性质
							}
						} else if(newValue == null) {
							row.getCell("recBank").setValue(null);//收款行
							row.getCell("recAccProperty").setValue(null);//收款账户性质
						}
					}
    	        });
    		}
    		//收款单位为集团 自动带出集团账户相关信息
    		if(recUnit.getNumber().equals("A")) {
				AccountBankInfo groupAccount = getDefaultAccountBankInfo("002.021.001.01");//集团下的账号 
				BankInfo bankInfo = getBankInfoFromAccount(groupAccount);
				row.getCell("recAccountText").setValue(groupAccount);//付款账号
				row.getCell("recBank").setValue(bankInfo.getName());//付款行
				row.getCell("recAccProperty").setValue(groupAccount.getDescription());//付款账户性质
			}
    		if(recUnit.getName().contains("结算中心")) {
    			AccountBankInfo costCenterAccountBankInfo = getCostCenterAccountBankInfo(recUnit);
				BankInfo costCenterBankInfo = getBankInfoFromAccount(costCenterAccountBankInfo);
				row.getCell("recAccountText").setValue(costCenterAccountBankInfo); //结算中心账号
				row.getCell("recBank").setValue(costCenterBankInfo); //收款银行
				row.getCell("recAccProperty").setValue(costCenterAccountBankInfo.getDescription()); //收款行性质
    		}
    	}
    	//自动计算大写金额
    	if(row.getCell("amount").getValue() != null) {
    		String upper = com.kingdee.eas.fdc.basedata.client.FDCClientHelper.getChineseFormat(new BigDecimal(row.getCell("amount").getValue().toString()), false);
    		row.getCell("upperAmount").setValue(upper);
    	}
    }
    //提交后设置UI按钮等状态锁定
    private void setUILocked() {
//    	lockUIAndAction();
    	lockUIComponent();
		setOprtState(OprtState.VIEW);
		kdtEntrys.getStyleAttributes().setLocked(true);
		kdtEntrys_detailPanel.getAddNewLineButton().setEnabled(false);
		kdtEntrys_detailPanel.getInsertLineButton().setEnabled(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setEnabled(false);
    }
    //新增
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.funds.FundsApplicationBillInfo objectValue = new com.kingdee.eas.custom.funds.FundsApplicationBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizState(BizState.addnew);
        objectValue.setBizDate(new Date());
    	AdminOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentAdminUnit();
    	if(!orgInfo.isIsPurchaseOrgUnit()) {
    		MsgBox.showWarning("只能在事业部下面新增单据");
    		SysUtil.abort();
    	}
    	try {
			PurchaseOrgUnitInfo purchaseInfo = getComOrgByPurchaseOrg(null, orgInfo.getId().toString());
			objectValue.setAppCompany(purchaseInfo);
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
        return objectValue;
    }
    //修改
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
    //审核
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
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
        setOprtState(OprtState.VIEW);
    }
    //反审核
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
    	if(!editData.getBizState().equals(BizState.audited)) {
    		MsgBox.showWarning("非已审批单据无法反审批!");
    		SysUtil.abort();
    	}
    	//检查单据是否在工作流中
    	com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, getSelectBOID());
    	super.actionUnAudit_actionPerformed(e);
    	btnUnAudit.setVisible(false);
    	btnAudit.setVisible(true);
    	syncDataFromDB();
    }
    //提交
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
//		if (!(editData.getBizState().equals(BizState.submited) || editData
//				.getBizState().equals(BizState.saved))) 
//		{
//			MsgBox.showWarning("非保存或提交状态单据无法提交!");
//			SysUtil.abort();
//		}
		//检查单据是否在工作流中
    	com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, getSelectBOID());
		super.actionSubmit_actionPerformed(e);
		btnAudit.setVisible(true);
		btnSave.setEnabled(false);
		syncDataFromDB();
		setUILocked();
    }
    //保存
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
    	if(editData.getBizState().equals(BizState.submited) || editData.getBizState().equals(BizState.audited)) {
    		MsgBox.showWarning("非新增或者保存状态单据无法保存!");
    		SysUtil.abort();
    	}
    	this.editData.setBizState(BizState.saved);
    	bizState.setSelectedItem(BizState.saved);
    	super.actionSave_actionPerformed(e);
    }
    //删除
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
     * 重新构建分录某列F7字段
     */
    private KDBizPromptBox buildKDTableF7Col(KDTable table, String col, String queryInfo, String displayFormat,
    									   String editFormat, String commitFormat, String bizDataFormat,
    									   EntityViewInfo evi, KDPromptSelector selector) {
    	KDBizPromptBox promptBox = new KDBizPromptBox();
    	promptBox.setQueryInfo(queryInfo);
    	promptBox.setVisible(true);
    	promptBox.setEditable(true);
    	promptBox.setDisplayFormat(displayFormat);
    	promptBox.setEditFormat(editFormat);
    	promptBox.setCommitFormat(commitFormat);
    	promptBox.setSelector(selector);
    	promptBox.setEntityViewInfo(evi);
    	KDTDefaultCellEditor defaultCellEditor = new KDTDefaultCellEditor(promptBox);
    	table.getColumn(col).setEditor(defaultCellEditor);
    	ObjectValueRender objectValueRender = new ObjectValueRender();
    	objectValueRender.setFormat(new BizDataFormat(bizDataFormat));
        table.getColumn(col).setRenderer(objectValueRender);
        
    	return promptBox;
    }
    /**
     * 重构分录某行的单元格为F7
     */
    private KDBizPromptBox buildTableRowF7Cell(IRow row, String cell, String queryInfo, String displayFormat,
    									   String editFormat, String commitFormat, String bizDataFormat,
    									   EntityViewInfo evi, KDPromptSelector selector) {
    	KDBizPromptBox promptBox = new KDBizPromptBox();
    	promptBox.setQueryInfo(queryInfo);
    	promptBox.setVisible(true);
    	promptBox.setEditable(true);
    	promptBox.setDisplayFormat(displayFormat);
    	promptBox.setEditFormat(editFormat);
    	promptBox.setCommitFormat(commitFormat);
    	promptBox.setSelector(selector);
    	promptBox.setEntityViewInfo(evi);
    	KDTDefaultCellEditor defaultCellEditor = new KDTDefaultCellEditor(promptBox);
    	row.getCell(cell).setEditor(defaultCellEditor);
    	ObjectValueRender objectValueRender = new ObjectValueRender();
    	objectValueRender.setFormat(new BizDataFormat(bizDataFormat));
    	row.getCell(cell).setRenderer(objectValueRender);
    	
    	return promptBox;
    }
    /**
     * 重构分录某列为文本字段
     */
    private KDTextField buildKDTableTextCol(KDTable table, String col) {
    	KDTextField kDTextField = new KDTextField();
    	kDTextField.setName(col);
    	kDTextField.setMaxLength(80);
    	KDTDefaultCellEditor cellEditor = new KDTDefaultCellEditor(kDTextField);
    	table.getColumn(col).setEditor(cellEditor);
    	
    	return kDTextField;
    }
    /**
     * 重构分录某行单元格为文本字段
     */
    private KDTextField buildTableRowTextCell(IRow row, String cell) {
    	KDTextField kDTextField = new KDTextField();
    	kDTextField.setName(cell);
    	kDTextField.setMaxLength(80);
    	KDTDefaultCellEditor cellEditor = new KDTDefaultCellEditor(kDTextField);
    	row.getCell(cell).setEditor(cellEditor);
    	
    	return kDTextField;
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
        //恢复分录控件样式
        restoreKDEntryF7Cell();
        //恢复分录新增按钮(是否是集团付款)
        restoreKDEntryAddNewLineButton();
        //恢复分录附件数
        restoreAttachmentCount();
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.funds.FundsApplicationBillFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }
}