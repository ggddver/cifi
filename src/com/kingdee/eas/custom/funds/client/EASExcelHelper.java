package com.kingdee.eas.custom.funds.client;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.common.LanguageManager;
import com.kingdee.bos.ctrl.kdf.kds.KDSBook;
import com.kingdee.bos.ctrl.kdf.kds.KDSSheet;
import com.kingdee.bos.ctrl.kdf.read.POIXlsReader;
import com.kingdee.bos.ctrl.swing.KDFileChooser;
import com.kingdee.bos.ctrl.swing.util.SimpleFileFilter;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.ISettlementType;
import com.kingdee.eas.basedata.assistant.SettlementTypeFactory;
import com.kingdee.eas.basedata.assistant.SettlementTypeInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.ICompanyOrgUnit;
import com.kingdee.eas.basedata.org.OrgConstants;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.funds.BizState;
import com.kingdee.eas.custom.funds.IReceiption;
import com.kingdee.eas.custom.funds.ReceiptionEntryInfo;
import com.kingdee.eas.custom.funds.ReceiptionFactory;
import com.kingdee.eas.custom.funds.ReceiptionInfo;
import com.kingdee.eas.custom.funds.payUnitType;
import com.kingdee.eas.fdc.sellhouse.ISellProject;
import com.kingdee.eas.fdc.sellhouse.SellProjectCollection;
import com.kingdee.eas.fdc.sellhouse.SellProjectFactory;
import com.kingdee.eas.fdc.sellhouse.SellProjectInfo;
import com.kingdee.eas.fi.cas.ReceivingBillTypeFactory;
import com.kingdee.eas.fi.cas.ReceivingBillTypeInfo;
import com.kingdee.eas.fi.newrpt.client.designer.io.WizzardIO;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

public class EASExcelHelper {
	
	public static String showExcelSelectDlg(CoreUIObject ui) {
		KDFileChooser chsFile = new KDFileChooser();
		String XLS = "xls";
		String Key_File = "Key_File";
		SimpleFileFilter Filter_Excel = new SimpleFileFilter(XLS, "MS Excel" + LanguageManager.getLangMessage(Key_File, WizzardIO.class, "锟斤拷锟斤拷失锟斤拷"));
		chsFile.addChoosableFileFilter(Filter_Excel);
		int ret = chsFile.showOpenDialog(ui);
		if (ret != JFileChooser.APPROVE_OPTION)
			SysUtil.abort();
		File file = chsFile.getSelectedFile();
		String fileName = file.getAbsolutePath();
		return fileName;
	}
	
	public static int importExcelToTable(String fileName,StringBuffer sb, int headRowCount) throws Exception {
		KDSBook kdsbook = null;
		try {
			kdsbook = POIXlsReader.parse2(fileName);
		} catch (Exception e) {
			e.printStackTrace();
			MsgBox.showError("!");
			SysUtil.abort();
		}
		if (kdsbook == null) {
			SysUtil.abort();
		}
		KDSSheet excelSheet = kdsbook.getSheet(new Integer(0));
		Map colNameMap = new HashMap();
		int maxRow = excelSheet.getRowCount();
		int maxColumn = excelSheet.getColumnCount();
		for (int col = 0; col < maxColumn; col++) {
			String excelColName = excelSheet.getCell(0, col, true).getText();
			colNameMap.put(excelColName, new Integer(col));
		}
		int successCount = 0;
		if(checkRecType(sb, excelSheet, 0))
			return 0;
		UserInfo creator = (com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser());
		OrgUnitInfo info = SysContext.getSysContext().getCurrentOrgUnit();
	    UserInfo user = SysContext.getSysContext().getCurrentUserInfo();
	    //默认收款人为当前登陆人
		PersonInfo PersonInfo = user.getPerson();
		PersonInfo = PersonInfo == null ? null : PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(PersonInfo.getId()));
		//设置默认项目
		ISellProject iSellProject = SellProjectFactory.getRemoteInstance();
		String oql = "where orgUnit.id = '" + info.getId().toString() + "' and level='1'";
		SellProjectCollection sellProjectCollection = iSellProject.getSellProjectCollection(oql);
		SellProjectInfo sellProject = sellProjectCollection.get(0);
		//设置房产公司
		ICompanyOrgUnit iCompanyOrgUnit = CompanyOrgUnitFactory.getRemoteInstance();
		CompanyOrgUnitInfo company = sellProject == null ? null : sellProject.getCompanyOrgUnit();
		company = company == null ? null : iCompanyOrgUnit.getCompanyOrgUnitInfo(new ObjectUuidPK(company.getId()));
		ISettlementType  ISettlementType  = SettlementTypeFactory.getRemoteInstance();
		IReceiption IReceiption = ReceiptionFactory.getRemoteInstance();
		ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getRemoteInstance();
		for (int rowIndex = headRowCount; rowIndex < maxRow; rowIndex++) {
			String payPerson = excelSheet.getCell(rowIndex,0, true).getText();//交款人（其他类型）
			String sum = excelSheet.getCell(rowIndex,12, true).getText();//合计
			String comment = excelSheet.getCell(rowIndex,13, true).getText();//备注-对应房号
			String number = excelSheet.getCell(rowIndex,14, true).getText();//编号（要符合编码规则）
			
			ReceiptionInfo rece = new ReceiptionInfo();
			if(IReceiption.exists("where number='"+number+"'"))
				rece = ReceiptionFactory.getRemoteInstance().getReceiptionCollection("where number='"+number+"'").get(0);
//			if(verifyFieldNotNull(sb, rowIndex, "备注(房号)", comment))
//				continue;
			if(verifyFieldNotNull(sb, rowIndex, "编号", number))
				continue;
			if(number.length()<9){
				sb.append("第"+(rowIndex+1)+"行，编号不符合编码规则（公司编码 + ”-“ +8位流水号）！ \n");
				continue;
			}
				
			String number1 = number.substring(0, number.length()-9);//公司编码
			String number2 = number.substring(number.length()-10, number.length());
			if(!iCompanyOrgUnit.exists("where number='"+number1+"'")){
				sb.append("第"+(rowIndex+1)+"行，编号不符合编码规则（公司编码 + ”-“ +8位流水号）！ \n");
				continue;
			}
			
			rece.setNumber(number);
			rece.setSum(UIRuleUtil.getBigDecimal(sum));
			rece.setComment(comment);
			rece.setOther(payPerson);
			StringBuilder sb1 = new StringBuilder("");
			String[] arr = sum.split(",");
			for(int i = 0; i < arr.length; i++)
				sb1.append(arr[i]);
			String upper = com.kingdee.eas.fdc.basedata.client.FDCClientHelper.getChineseFormat(new BigDecimal(sb1.toString()), false);
			rece.setUpperAmount(upper);
			
			String settlementType = excelSheet.getCell(rowIndex,1, true).getText();
			EntityViewInfo viewInfo = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("name", settlementType));
			viewInfo.setFilter(filter);
			SettlementTypeInfo sett = ISettlementType.getSettlementTypeCollection(viewInfo).get(0);
			if(verifyFieldNotNull(sb, rowIndex, "收款方式", sett))
				continue;
			
			Map map = getRecType(excelSheet, rowIndex);
			rece.getEntrys().clear();
			for (int i = 2; i < 11; i++) {
				String recAmount = excelSheet.getCell(rowIndex,i, true).getText();
				if("".equals(recAmount))
					continue;
				ReceiptionEntryInfo entry = new ReceiptionEntryInfo ();
				entry.setRecType((ReceivingBillTypeInfo)map.get(i));
				entry.setRecAmount(UIRuleUtil.getBigDecimal(recAmount));
				entry.setSettlementType(sett);
				rece.getEntrys().add(entry);
			}
			rece.setPayUnitType(payUnitType.other);
			
			rece.setCreator(creator);
			rece.setBizDate(new Date());
			rece.setRecPerson(PersonInfo);
			rece.setProject(sellProject);
			rece.setCompany(company);
			rece.setBizState(BizState.submited);
			ReceiptionFactory.getRemoteInstance().save(rece);
			
			successCount++;
		}
		return successCount;
	}
	
	private static boolean checkRecType(StringBuffer sb, KDSSheet excelSheet,int rowIndex){
		boolean flag = false;
		for (int i = 2; i < 11; i++) {
			String recType = excelSheet.getCell(0,i, true).getText();
			if(!"".equals(recType)){
				EntityViewInfo viewInfo = new EntityViewInfo();
				FilterInfo filter = new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("name", recType));
				viewInfo.setFilter(filter);
				ReceivingBillTypeInfo recTypeInfo;
				try {
					recTypeInfo = ReceivingBillTypeFactory.getRemoteInstance().getReceivingBillTypeCollection(viewInfo).get(0);
					if(isNull(recTypeInfo)){
				    	sb.append( "收款类别-"+recType+"不能为空或者在基础资料没有找到，请把"+recType+"修改正确！ \n");
				    	return true;
				    }
				} catch (BOSException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	private static Map getRecType(KDSSheet excelSheet,int rowIndex){
		Map map = new HashMap();
		for (int i = 2; i < 11; i++) {
			String recType = excelSheet.getCell(0,i, true).getText();
			EntityViewInfo viewInfo = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("name", recType));
			viewInfo.setFilter(filter);
			try {
				ReceivingBillTypeInfo recTypeInfo = ReceivingBillTypeFactory.getRemoteInstance().getReceivingBillTypeCollection(viewInfo).get(0);
				map.put(i, recTypeInfo);
			} catch (BOSException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	private static boolean verifyFieldNotNull(StringBuffer sb,int i,String name, Object value)
	{
	    if(isNull(value)){
	    	sb.append("第"+(i+1)+"行"+name+"不能为空或者在基础资料没有找到，请到对应菜单下维护相应信息！ \n");
	    	return true;
	    }
	    else
	        return false;
	}
	
	private static boolean isNull(Object o)
	{
	    if(o == null)
	        return true;
	    if(o instanceof String)
	        return o.equals("");
	    else
	        return false;
	}
}
