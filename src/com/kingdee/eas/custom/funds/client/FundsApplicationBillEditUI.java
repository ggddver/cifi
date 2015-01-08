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
    	//���÷�¼��¼
    	setEntryColRequired(kdtEntrys, new String[] {"entryPayUnit", "payAccount", "recUnit", "recAccountText", "amount", "usage"});
    	/*---------------------------------------------*/
    	AdminOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentAdminUnit();
    	final PurchaseOrgUnitInfo purchaseInfo = getComOrgByPurchaseOrg(null, orgInfo.getId().toString());//��ҵ��
    	/*---------------------------------------------*/
    	//���ø��λ����ѡ��������������ĵĹ���
    	String area = purchaseInfo.getName().substring(0, 2);
    	String oqls = "where name like '%"+area+"%��������%'";
    	if(area.equals("����"))
    		oqls = "where name like '%�Ϻ�%��������%'";
    	if(area.equals("�ȷ�"))
    		oqls = "where name like '%����%��������%'";
    	if(area.equals("���")) 
    		oqls = "where name like '%����%��������%'";
    	if(area.equals("��"))
    		oqls = "where name like '%�Ͼ�%��������%'";
		CompanyOrgUnitInfo costCenter = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(oqls);//��������
    	EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        evi.setFilter(filter);
        CompanyOrgUnitInfo companyUnit = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(orgInfo.getId()));
        filter.getFilterItems().add(new FilterItemInfo("longNumber",companyUnit.getLongNumber()+"%",CompareType.LIKE));
        filter.getFilterItems().add(new FilterItemInfo("isOUSealUp","0",CompareType.EQUALS));
//        filter.getFilterItems().add(new FilterItemInfo("level","6",CompareType.EQUALS));
        filter.getFilterItems().add(new FilterItemInfo("name","%��ʷ%",CompareType.NOTLIKE));
	    filter.getFilterItems().add(new FilterItemInfo("longnumber", costCenter.getLongNumber()+"%", CompareType.LIKE));
//	    filter.setMaskString("#0 and #1 and #2 and #3 or #4");
	    filter.setMaskString("#0 and #1 and #2 or #3");
	    
	    //���÷�¼���λ��״
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
        //���λֵ�ı�
        entryPayUnit.addDataChangeListener(getDataChangeListener("entryPayUnit"));
        
        //���÷�¼�տλ��״
        CompanyBizUnitF7 recCompanyF7Tree = getCompanyBizUnitF7(OrgConstants.DEF_CU_ID);
        KDBizPromptBox recUnit = buildKDTableF7Col(kdtEntrys, "recUnit", "com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct", 
        		"$Description$", "$Description$", "$Description$", "$Description$", null, recCompanyF7Tree);
        //�տλֵ�ı�
        recUnit.addDataChangeListener(getDataChangeListener("recUnit"));
        
        //��ʽ����¼�ı��ֶ��տ��˺�ΪF7
    	KDBizPromptBox recAccountBox = buildKDTableF7Col(kdtEntrys, "recAccountText", "com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery", 
    			"$name$", "$name$", "$name$", "$name$", null, null);
    	recAccountBox.addSelectorListener(getSelectorListener("recUnit", "����ѡ���տλ!"));
    	//��ʽ����¼�����˺�
    	KDBizPromptBox payAccountBox = buildKDTableF7Col(kdtEntrys, "payAccount", "com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery", 
    			"$name$", "$name$", "$name$", "$name$", null, null);
    	payAccountBox.addSelectorListener(getSelectorListener("entryPayUnit", "����ѡ�񸶿λ!"));
    	/*---------------------------------------------*/
    	initKDEntryAddNewLineButton(false);
    	super.onLoad();
    	setButtonState();
    }
    //��ʼ���ؼ�
    private void initComponent() {
    	//�ؼ��Ƿ���ʾ
    	contNumber.setVisible(false);
    	contBizDate.setVisible(false);
    	contDescription.setVisible(false);
    	contCreateTime.setVisible(false);
    	contCreator.setVisible(false);
    	//�ؼ��Ƿ�ɱ༭
    	contappCompany.setEnabled(false);
    	contauditDate.setEnabled(false);
    	contbizState.setVisible(false);
    	contauditOrg.setEnabled(false);
    	//��ť�Ƿ�ɼ�
    	btnNext.setVisible(false);
    	btnPre.setVisible(false);
    	btnFirst.setVisible(false);
    	btnLast.setVisible(false);
    	btnTraceUp.setVisible(false);
    	btnTraceDown.setVisible(false);
    	btnCreateFrom.setVisible(false);
    	btnCreateTo.setVisible(false);
    	//��ťͼ��
    	btnAudit.setIcon(EASResource.getIcon("imgTbtn_auditing"));
    	btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_fauditing"));
    	//������¼������
        IColumn col = kdtEntrys.addColumn();
        col.setKey("attCount");
        col.getStyleAttributes().setLocked(true);
        col.getStyleAttributes().setHorizontalAlign(HorizontalAlignment.CENTER);
        kdtEntrys.getHeadRow(0).getCell("attCount").setValue("������");
    }
    //���ð�ť״̬
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
    //���÷�¼�б�¼
    private void setEntryColRequired(KDTable table, String[] cols) {
    	for(int i = 0; i < cols.length; i++) {
    		table.getColumn(cols[i]).setRequired(true);
    	}
    }
    //Ϊ��¼F7���DataChangeListener
    private DataChangeListener getDataChangeListener(final String col) {
    	DataChangeListener dataChangeListener = new DataChangeListener() {
			public void dataChanged(DataChangeEvent arg) {
				IRow row = kdtEntrys.getRow(kdtEntrys.getSelectManager().getActiveRowIndex());
				CompanyOrgUnitInfo companyNew = (CompanyOrgUnitInfo) arg.getNewValue();
				CompanyOrgUnitInfo companyOld = (CompanyOrgUnitInfo) arg.getOldValue();
				//���λ
				if(col.equals("entryPayUnit")) {
					//��ո��λʱ�������˻���Ϣ
//					if(companyNew == null) {
//						row.getCell("payAccount").setValue(null);//�����˺�
//						row.getCell("payBank").setValue(null);//������
//						row.getCell("payAccProperty").setValue(null);//�����˻�����
//					}
					//���λʵ�ʷ����仯ʱ�������˻���Ϣ
					if(companyNew == null || companyNew != null && companyOld != null && !companyNew.getNumber().equals(companyOld.getNumber())) {
						row.getCell("payAccount").setValue(null);//�����˺�
						row.getCell("payBank").setValue(null);//������
						row.getCell("payAccProperty").setValue(null);//�����˻�����
					}
				}
				//�տλ
				if(col.equals("recUnit")) {
					//����տλʱ�������˻���Ϣ
//					if(companyNew == null) {
//						row.getCell("recAccountText").setValue(null);//�տ��˺�
//						row.getCell("recBank").setValue(null);//�տ���
//						row.getCell("recAccProperty").setValue(null);//�տ��˻�����
//					}
					//�տλʵ�ʷ����仯ʱ�������˻���Ϣ
					if(companyNew == null || companyNew != null && companyOld != null && !companyNew.getNumber().equals(companyOld.getNumber())) {
						row.getCell("recAccountText").setValue(null);//�տ��˺�
						row.getCell("recBank").setValue(null);//�տ���
						row.getCell("recAccProperty").setValue(null);//�տ��˻�����
					}
				}
			}
    	};
    	return dataChangeListener;
    }
    //Ϊ��¼ĳ��F7��Ԫ������SelectorListener
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
    //��ȡ������֯��״����
    private CompanyBizUnitF7 getCompanyBizUnitF7(String RootId) {
    	CompanyBizUnitF7 companyBizUnitF7 = new CompanyBizUnitF7(this);
    	companyBizUnitF7.showCheckBoxOfShowingAllOUs();
    	companyBizUnitF7.setIsCUFilter(false);
    	companyBizUnitF7.setRootUnitID(RootId);
    	companyBizUnitF7.disablePerm();
    	return companyBizUnitF7;
    }
    /**
     * ��¼������ť
     * @param isGroup �Ƿ��Ÿ���
     * ���Ÿ���Ĭ�ϴ������λΪ���ţ��Լ������µ��˺ţ����е�
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
					AccountBankInfo groupAccount = getDefaultAccountBankInfo("002.021.001.01");//�����µ��˺� �������
					BankInfo bankInfo = getBankInfoFromAccount(groupAccount);
					CompanyOrgUnitInfo cifiGroup = getCompanyOrgUnitInfo("A");//��Լ��Źɷ����޹�˾
					add.getCell("entryPayUnit").setValue(cifiGroup);//���˾
					add.getCell("payAccount").setValue(groupAccount);//�����˺�
					add.getCell("payBank").setValue(bankInfo.getName());//������
					add.getCell("payAccProperty").setValue(groupAccount.getDescription());//�����˻�����
					
					//���Ÿ���ʱĬ�ϴ����տλΪ������Ľ�������
					PurchaseOrgUnitInfo purchaseOrgUnit = getCurPurchaseOrgUnitInfo();
					String area = purchaseOrgUnit.getName().substring(0, 2);
//					String oql = "where name like '%"+area+"%��������%' and isleaf='1'";
					String oql = "where name like '%"+area+"%��������%'";
					if(area.equals("���")) 
						oql = "where name like '%����%��������%'";
					if(area.equals("����"))
						oql = "where name like '%�Ϻ�%��������%'";
			    	if(area.equals("�ȷ�"))
			    		oql = "where name like '%����%��������%'";
			    	if(area.equals("��"))
			    		oql = "where name like '%�Ͼ�%��������%'";
					try {
						CompanyOrgUnitInfo costCenter = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(oql);
						AccountBankInfo costCenterAccountBankInfo = getCostCenterAccountBankInfo(costCenter);
						BankInfo costCenterBankInfo = getBankInfoFromAccount(costCenterAccountBankInfo);
						add.getCell("recUnit").setValue(costCenter);//�տλ ��������
						add.getCell("recAccountText").setValue(costCenterAccountBankInfo); //���������˺�
						add.getCell("recBank").setValue(costCenterBankInfo); //�տ�����
						add.getCell("recAccProperty").setValue(costCenterAccountBankInfo.getDescription()); //�տ�������
					} catch (EASBizException e) {
						e.printStackTrace();
					} catch (BOSException e) {
						e.printStackTrace();
					}
				}
    		});
    	}
    }
    //���ݽ������Ļ�ȡ���������µ������˺�
    private AccountBankInfo getCostCenterAccountBankInfo(CompanyOrgUnitInfo costCenter) {
    	AccountBankInfo accountBankInfo = null;
    	try {
			IAccountBank iAccountBank = AccountBankFactory.getRemoteInstance();
			EntityViewInfo evi = new EntityViewInfo();
	        FilterInfo filter = new FilterInfo();
	        evi.setFilter(filter);
	        filter.getFilterItems().add(new FilterItemInfo("Company.longnumber", costCenter.getLongNumber()+"%", CompareType.LIKE));
	        filter.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//��ע���˺�
	        AccountBankCollection accountBankCollection = iAccountBank.getAccountBankCollection(evi);
	        accountBankInfo = accountBankCollection.get(0);
		} catch (BOSException e) {
			e.printStackTrace();
		}
		return accountBankInfo;
    }
    /**
     * ��ȡ��ǰ��½��֯�Ĳɹ���֯(��ҵ��)
     */
    private PurchaseOrgUnitInfo getCurPurchaseOrgUnitInfo() {
    	AdminOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentAdminUnit();
    	PurchaseOrgUnitInfo purchaseInfo = null;
    	try {
    		purchaseInfo = getComOrgByPurchaseOrg(null, orgInfo.getId().toString());//��ҵ��
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
		return purchaseInfo;
    }
    /**
     * �ж��տλ�Ƿ��ǵ�ǰ�����µĹ�˾
     * (�����Լ��������ĳ���)
     * @param parent
     * @param child
     * @return
     */
    private boolean isChildCompany(CompanyOrgUnitInfo parent, CompanyOrgUnitInfo child) {
    	boolean flag = true;
    	if(child.getNumber().equals("A") || child.getName().contains("��������"))
    		return true;
    	String plongNumber = parent.getLongNumber();
    	String clongNumber = child.getLongNumber();
    	if(clongNumber.indexOf(plongNumber) < 0)
    		flag = false;
    	return flag;
    }
    /**
     * ���ݲɹ���֯��ȡ��Ӧ�Ĳ�����֯
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
     * loadFields�ָ���¼�տ��˺ſؼ���F7�����ı�
     */
    private void restoreKDEntryF7Cell() {
    	AdminOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentAdminUnit();
    	PurchaseOrgUnitInfo purchaseInfo = null;
    	try {
    		purchaseInfo = getComOrgByPurchaseOrg(null, orgInfo.getId().toString());//��ҵ��
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
    		//��ʽ����¼�����˺�,��ӹ�������
        	KDBizPromptBox payAccountBox = buildKDTableF7Col(kdtEntrys, "payAccount", "com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery", 
        			"$name$", "$name$", "$name$", "$name$", null, null);
        	EntityViewInfo evip = getEntityViewInfoFromCompany(entryPayUnit);
	        payAccountBox.setEntityViewInfo(evip);
	        payAccountBox.addSelectorListener(getSelectorListener("entryPayUnit", "����ѡ�񸶿λ!"));
	        
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
								row.getCell("recBank").setValue(bankInfo.getName());//�տ���
								row.getCell("recAccProperty").setValue(accountBankInfo.getDescription());//�տ��˻�����
							} else {
								row.getCell("recBank").setValue(null);//�տ���
								row.getCell("recAccProperty").setValue(null);//�տ��˻�����
							}
						} else if(newValue == null) {
							row.getCell("recBank").setValue(null);//�տ���
							row.getCell("recAccProperty").setValue(null);//�տ��˻�����
						}
					}
    	        });
    		}
    	}
    	if(chkisGroup.isSelected()) {
    		//���Ÿ���ʱ,�տλֻ��ѡ����������
    		KDBizPromptBox recUnit = buildKDTableF7Col(kdtEntrys, "recUnit", "com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct", 
            		"$name$", "$name$", "$name$", "$name$", null, null);
    		EntityViewInfo evi = new EntityViewInfo();
    		FilterInfo filter = new FilterInfo();
    		evi.setFilter(filter);
    		filter.getFilterItems().add(new FilterItemInfo("name", "%��������%", CompareType.LIKE));
			filter.getFilterItems().add(new FilterItemInfo("isleaf", "1", CompareType.EQUALS));
			recUnit.setEntityViewInfo(evi);
			recUnit.addDataChangeListener(getDataChangeListener("recUnit"));
    	}
    }
    /**
     * loadFields�ָ�������
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
    //�����ո��λ��ȡ�ո����˺Ź�������
    private EntityViewInfo getEntityViewInfoFromCompany(CompanyOrgUnitInfo company) {
    	EntityViewInfo evi = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        evi.setFilter(filter);
        filter.getFilterItems().add(new FilterItemInfo("Company.longnumber", company.getLongNumber()+"%", CompareType.LIKE));
        filter.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//��ע���˺�
        
        return evi;
    }
    /**
     * loadFields�ָ���¼������ť(�Ƿ��Ÿ���)
     * @param number
     * @return
     */
    private void restoreKDEntryAddNewLineButton() {
    	if(chkisGroup.isSelected())
    		initKDEntryAddNewLineButton(true);
    	else
    		initKDEntryAddNewLineButton(false);
    }
    //��ȡ����Ĭ���˺�
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
    //���ݱ����ȡ������֯
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
    //���������˻���ȡ������Ϣ
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
    //У���¼�ֶ��Ƿ�Ϊ��
    private void checkEntryRequriedCell(KDTable table, String[] cols) {
    	IRow headRow = table.getHeadRow(0);
    	for(int i = 0; i < table.getRowCount(); i++) {
    		IRow row = table.getRow(i);
    		for(int j = 0; j < cols.length; j++) {
    			if(row.getCell(cols[j]).getValue() == null) {
    				MsgBox.showWarning("��¼��"+(i+1)+"��,"+headRow.getCell(cols[j]).getValue()+" ����Ϊ��!");
    				SysUtil.abort();
    			}
    		}
    	}
    }
    //У���¼�տλ (����������˾���ܹ���, ��������ĿǰĬ�Ͽ����뼯�Ź���)
    private void checkRecUnitValid() {
    	List recUnitList = new LinkedList();
    	for(int i = 0; i < kdtEntrys.getRowCount(); i++) {
    		IRow row = kdtEntrys.getRow(i);
    		CompanyOrgUnitInfo recUnit = (CompanyOrgUnitInfo) row.getCell("recUnit").getValue();
    		if(recUnit.getNumber().equals("A") || recUnit.getName().contains("��������"))
    			continue;
    		else
    			recUnitList.add(recUnit.getName());
    	}
    	if(recUnitList.size() > 0 && recUnitList.size() != kdtEntrys.getRowCount()) {
    		MsgBox.showWarning("��¼�տλ:\n��Լ��Źɷ����޹�˾���߽������Ĳ�����������˾����!");
    		SysUtil.abort();
    	}
    }
    //У���¼�տ��˻����� (�ɶ��ò������������ʹ���, �ǿɶ���ֻ�����ܼ�ܹ���)
    private void checkAccPropertyValid() {
    	Set recAccPropertySet = new HashSet();
    	for(int i = 0; i < kdtEntrys.getRowCount(); i++) {
    		IRow row = kdtEntrys.getRow(i);
    		Object recAccProperty = row.getCell("recAccProperty").getValue();
    		if(recAccProperty != null)
    			recAccPropertySet.add(recAccProperty);
    	}
    	if(recAccPropertySet.contains("�ɶ���") &&  recAccPropertySet.size() > 1) {
    		MsgBox.showWarning("��¼�տ��˻�����:\n�����˻����ʿɶ��ò������������ʹ���!");
    		SysUtil.abort();
    	}
    		
    }
    //У���¼�
    protected void verifyInput(ActionEvent e) throws Exception {
    	super.verifyInput(e);
    	checkEntryRequriedCell(kdtEntrys, new String[] {"entryPayUnit", "payAccount", "recUnit", "recAccountText", "amount", "usage"});
    	checkRecUnitValid();
    	checkAccPropertyValid();
    }
    //�Ƿ��Ÿ���
    protected void chkisGroup_actionPerformed(ActionEvent e) throws Exception {
    	kdtEntrys.removeRows();
    	if(chkisGroup.isSelected()) {
    		initKDEntryAddNewLineButton(true);
    		//���Ÿ���ʱ,�տλֻ��ѡ����������
    		KDBizPromptBox recUnit = buildKDTableF7Col(kdtEntrys, "recUnit", "com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct", 
            		"$name$", "$name$", "$name$", "$name$", null, null);
    		EntityViewInfo evi = new EntityViewInfo();
    		FilterInfo filter = new FilterInfo();
    		evi.setFilter(filter);
    		filter.getFilterItems().add(new FilterItemInfo("name", "%��������%", CompareType.LIKE));
			filter.getFilterItems().add(new FilterItemInfo("isleaf", "1", CompareType.EQUALS));
			recUnit.setEntityViewInfo(evi);
			recUnit.addDataChangeListener(getDataChangeListener("recUnit"));
    	} else {
    		initKDEntryAddNewLineButton(false);
    		//���÷�¼�տλ��״
            CompanyBizUnitF7 recCompanyF7Tree = getCompanyBizUnitF7(OrgConstants.DEF_CU_ID);
            KDBizPromptBox recUnit = buildKDTableF7Col(kdtEntrys, "recUnit", "com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct", 
            		"$Description$", "$Description$", "$Description$", "$Description$", null, recCompanyF7Tree);
            //�տλֵ�ı�
            recUnit.addDataChangeListener(getDataChangeListener("recUnit"));
    	}
    }
    //��¼����¼�
    protected void kdtEntrys_tableClicked(KDTMouseEvent e) throws Exception {
    	super.kdtEntrys_tableClicked(e);
    	restoreAttachmentCount();
    }
    //��¼�༭ֹͣ�¼�
    protected void kdtEntrys_editStopped(KDTEditEvent e) throws Exception {
    	super.kdtEntrys_editStopped(e);
    	AdminOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentAdminUnit();
    	final PurchaseOrgUnitInfo purchaseInfo = getComOrgByPurchaseOrg(null, orgInfo.getId().toString());//��ҵ��
    	CompanyOrgUnitInfo pCompany = getCompanyInfoFromPurchase(purchaseInfo);
    	
    	final IRow row = kdtEntrys.getRow(e.getRowIndex());
    	CompanyOrgUnitInfo recUnit = (CompanyOrgUnitInfo) row.getCell("recUnit").getValue();
    	CompanyOrgUnitInfo entryPayUnit = (CompanyOrgUnitInfo) row.getCell("entryPayUnit").getValue();
    	
    	if(entryPayUnit != null) {
    		KDBizPromptBox payAccountBox = buildTableRowF7Cell(row, "payAccount", "com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery", 
	    			"$name$", "$name$", "$name$", "$name$", null, null);
    		//���ݸ��λ���ø����˺Ź�������
    		EntityViewInfo evi = new EntityViewInfo();
	        FilterInfo filter = new FilterInfo();
	        evi.setFilter(filter);
	        filter.getFilterItems().add(new FilterItemInfo("Company.longnumber", entryPayUnit.getLongNumber()+"%", CompareType.LIKE));
	        filter.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//��ע���˺�
	        payAccountBox.setEntityViewInfo(evi);
	        payAccountBox.addSelectorListener(getSelectorListener("entryPayUnit", "����ѡ�񸶿λ"));
	        
	        //���λΪ���� �Զ����������˻������Ϣ
    		if(entryPayUnit.getNumber().equals("A")) {
				AccountBankInfo groupAccount = getDefaultAccountBankInfo("002.021.001.01");//�����µ��˺� 
				BankInfo bankInfo = getBankInfoFromAccount(groupAccount);
				row.getCell("payAccount").setValue(groupAccount);//�����˺�
				row.getCell("payBank").setValue(bankInfo.getName());//������
				row.getCell("payAccProperty").setValue(groupAccount.getDescription());//�����˻�����
			}
    		if(entryPayUnit.getName().contains("��������")) {
    			AccountBankInfo costCenterAccountBankInfo = getCostCenterAccountBankInfo(entryPayUnit);
				BankInfo costCenterBankInfo = getBankInfoFromAccount(costCenterAccountBankInfo);
				row.getCell("payAccount").setValue(costCenterAccountBankInfo); //���������˺�
				row.getCell("payBank").setValue(costCenterBankInfo); //������
				row.getCell("payAccProperty").setValue(costCenterAccountBankInfo.getDescription()); //�����˻�����
    		}
    	}
    	if(recUnit != null) {
    		if(!isChildCompany(pCompany, recUnit)) {
    			buildTableRowTextCell(row, "recAccountText");//�տλ�Ǳ�����Ĺ�˾ʱ���տ��˺��ֶ�����
    		} else {
    			KDBizPromptBox recAccountBox = buildTableRowF7Cell(row, "recAccountText", "com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery", 
    	    			"$name$", "$name$", "$name$", "$name$", null, null);
    			
    			EntityViewInfo evi = new EntityViewInfo();
    	        FilterInfo filter = new FilterInfo();
    	        evi.setFilter(filter);
    	        filter.getFilterItems().add(new FilterItemInfo("Company.longnumber", recUnit.getLongNumber()+"%", CompareType.LIKE));
    	        filter.getFilterItems().add(new FilterItemInfo("IsClosed", false, CompareType.EQUALS));//��ע���˺�
    	        recAccountBox.setEntityViewInfo(evi);
    	        
    	        recAccountBox.addSelectorListener(getSelectorListener("recUnit", "����ѡ���տλ!"));
    	        recAccountBox.addDataChangeListener(new DataChangeListener() {
					public void dataChanged(DataChangeEvent arg) {
						Object newValue = arg.getNewValue();
						if(newValue instanceof AccountBankInfo) {
							AccountBankInfo accountBankInfo = (AccountBankInfo) arg.getNewValue();
							if(accountBankInfo != null) {
								BankInfo bankInfo = getBankInfoFromAccount(accountBankInfo);
								row.getCell("recBank").setValue(bankInfo.getName());//�տ���
								row.getCell("recAccProperty").setValue(accountBankInfo.getDescription());//�տ��˻�����
							} else {
								row.getCell("recBank").setValue(null);//�տ���
								row.getCell("recAccProperty").setValue(null);//�տ��˻�����
							}
						} else if(newValue == null) {
							row.getCell("recBank").setValue(null);//�տ���
							row.getCell("recAccProperty").setValue(null);//�տ��˻�����
						}
					}
    	        });
    		}
    		//�տλΪ���� �Զ����������˻������Ϣ
    		if(recUnit.getNumber().equals("A")) {
				AccountBankInfo groupAccount = getDefaultAccountBankInfo("002.021.001.01");//�����µ��˺� 
				BankInfo bankInfo = getBankInfoFromAccount(groupAccount);
				row.getCell("recAccountText").setValue(groupAccount);//�����˺�
				row.getCell("recBank").setValue(bankInfo.getName());//������
				row.getCell("recAccProperty").setValue(groupAccount.getDescription());//�����˻�����
			}
    		if(recUnit.getName().contains("��������")) {
    			AccountBankInfo costCenterAccountBankInfo = getCostCenterAccountBankInfo(recUnit);
				BankInfo costCenterBankInfo = getBankInfoFromAccount(costCenterAccountBankInfo);
				row.getCell("recAccountText").setValue(costCenterAccountBankInfo); //���������˺�
				row.getCell("recBank").setValue(costCenterBankInfo); //�տ�����
				row.getCell("recAccProperty").setValue(costCenterAccountBankInfo.getDescription()); //�տ�������
    		}
    	}
    	//�Զ������д���
    	if(row.getCell("amount").getValue() != null) {
    		String upper = com.kingdee.eas.fdc.basedata.client.FDCClientHelper.getChineseFormat(new BigDecimal(row.getCell("amount").getValue().toString()), false);
    		row.getCell("upperAmount").setValue(upper);
    	}
    }
    //�ύ������UI��ť��״̬����
    private void setUILocked() {
//    	lockUIAndAction();
    	lockUIComponent();
		setOprtState(OprtState.VIEW);
		kdtEntrys.getStyleAttributes().setLocked(true);
		kdtEntrys_detailPanel.getAddNewLineButton().setEnabled(false);
		kdtEntrys_detailPanel.getInsertLineButton().setEnabled(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setEnabled(false);
    }
    //����
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.funds.FundsApplicationBillInfo objectValue = new com.kingdee.eas.custom.funds.FundsApplicationBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizState(BizState.addnew);
        objectValue.setBizDate(new Date());
    	AdminOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentAdminUnit();
    	if(!orgInfo.isIsPurchaseOrgUnit()) {
    		MsgBox.showWarning("ֻ������ҵ��������������");
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
    //�޸�
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(!(editData.getBizState().equals(BizState.saved) || editData.getBizState().equals(BizState.submited))) {
    		MsgBox.showWarning("�Ǳ�������ύ״̬�����޷��޸�!");
    		SysUtil.abort();
    	}
    	//��鵥���Ƿ��ڹ�������
    	com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, getSelectBOID());
        super.actionEdit_actionPerformed(e);
        if(!editData.getBizState().equals(BizState.saved))
        	btnSave.setEnabled(false);
    }
    //���
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
    	if(!editData.getBizState().equals(BizState.submited)) {
    		MsgBox.showWarning("���ύ�����޷�����!");
    		SysUtil.abort();
    	}
    	//��鵥���Ƿ��ڹ�������
    	com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, getSelectBOID());
    	
    	super.actionAudit_actionPerformed(e);
        btnAudit.setVisible(false);
        btnUnAudit.setVisible(true);
        syncDataFromDB();
        setOprtState(OprtState.VIEW);
    }
    //�����
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
    	if(!editData.getBizState().equals(BizState.audited)) {
    		MsgBox.showWarning("�������������޷�������!");
    		SysUtil.abort();
    	}
    	//��鵥���Ƿ��ڹ�������
    	com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, getSelectBOID());
    	super.actionUnAudit_actionPerformed(e);
    	btnUnAudit.setVisible(false);
    	btnAudit.setVisible(true);
    	syncDataFromDB();
    }
    //�ύ
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
//		if (!(editData.getBizState().equals(BizState.submited) || editData
//				.getBizState().equals(BizState.saved))) 
//		{
//			MsgBox.showWarning("�Ǳ�����ύ״̬�����޷��ύ!");
//			SysUtil.abort();
//		}
		//��鵥���Ƿ��ڹ�������
    	com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, getSelectBOID());
		super.actionSubmit_actionPerformed(e);
		btnAudit.setVisible(true);
		btnSave.setEnabled(false);
		syncDataFromDB();
		setUILocked();
    }
    //����
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
    	if(editData.getBizState().equals(BizState.submited) || editData.getBizState().equals(BizState.audited)) {
    		MsgBox.showWarning("���������߱���״̬�����޷�����!");
    		SysUtil.abort();
    	}
    	this.editData.setBizState(BizState.saved);
    	bizState.setSelectedItem(BizState.saved);
    	super.actionSave_actionPerformed(e);
    }
    //ɾ��
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
    	if(editData.getBizState().equals(BizState.audited)) {
    		MsgBox.showWarning("�����������޷�ɾ��");
    		SysUtil.abort();
    	}
    	//��鵥���Ƿ��ڹ�������
    	com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, getSelectBOID());
        super.actionRemove_actionPerformed(e);
    }
    /**
     * ���¹�����¼ĳ��F7�ֶ�
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
     * �ع���¼ĳ�еĵ�Ԫ��ΪF7
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
     * �ع���¼ĳ��Ϊ�ı��ֶ�
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
     * �ع���¼ĳ�е�Ԫ��Ϊ�ı��ֶ�
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
	 * �ɲ��ŵõ��ɹ���֯
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
	 * ͬ�����ݿ����ݵ�����,��������/����������ʾ������,��������
	 * @throws Exception
	 */
	protected void syncDataFromDB() throws Exception {
		//�ɴ��ݹ�����ID��ȡֵ����
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
        //�ָ���¼�ؼ���ʽ
        restoreKDEntryF7Cell();
        //�ָ���¼������ť(�Ƿ��Ǽ��Ÿ���)
        restoreKDEntryAddNewLineButton();
        //�ָ���¼������
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