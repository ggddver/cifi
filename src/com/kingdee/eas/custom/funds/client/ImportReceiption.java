package com.kingdee.eas.custom.funds.client;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.bi.model.common.bireport.layout.RCell;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.assistant.ISettlementType;
import com.kingdee.eas.basedata.assistant.SettlementTypeCollection;
import com.kingdee.eas.basedata.assistant.SettlementTypeFactory;
import com.kingdee.eas.basedata.assistant.SettlementTypeInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.funds.BizState;
import com.kingdee.eas.custom.funds.ReceiptionEntryInfo;
import com.kingdee.eas.custom.funds.ReceiptionFactory;
import com.kingdee.eas.custom.funds.ReceiptionInfo;
import com.kingdee.eas.custom.funds.payUnitType;
import com.kingdee.eas.fi.cas.IReceivingBillType;
import com.kingdee.eas.fi.cas.ReceivingBillTypeFactory;
import com.kingdee.eas.fi.cas.ReceivingBillTypeInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.tools.datatask.AbstractDataTransmission;
import com.kingdee.eas.tools.datatask.core.TaskExternalException;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

public class ImportReceiption extends AbstractDataTransmission {

	private Date bizDate;
	private ReceivingBillTypeInfo billTypeInfo;
	private SettlementTypeInfo settlementTypeInfo;
	private String amount = "";
	private String sum = "";
	private ReceiptionInfo receiption;
	private StringBuilder errorMsg = new StringBuilder("");
	@Override
	protected ICoreBase getController(Context ctx)
			throws TaskExternalException {
		try {
			return ReceiptionFactory.getLocalInstance(ctx);
		} catch (BOSException e) {
			throw new TaskExternalException(e.getMessage(), e);
		}
	}

	@Override
	public CoreBaseInfo transmit(Hashtable table, Context ctx)
			throws TaskExternalException {
		amount = table.get("FEntrys_recAmount").toString().trim();
		sum = table.get("FSum").toString().trim();
		if(table.get("FNumber") == null || table.get("FNumber") != null && table.get("FNumber").toString().trim().length() == 0)
			throw new TaskExternalException("单据编号不能为空!");
		try {
			IReceivingBillType iReceivingBillType = ReceivingBillTypeFactory.getLocalInstance(ctx);
			ISettlementType iSettlementType = SettlementTypeFactory.getLocalInstance(ctx);
			String number = table.get("FNumber").toString().trim();
			if(table.get("FEntrys$recType_name_l2") != null) {
				String recType = table.get("FEntrys$recType_name_l2").toString();
				boolean flag = iReceivingBillType.exists("where name='" + table.get("FEntrys$recType_name_l2").toString().trim() + "'");
				if(flag)
					billTypeInfo = iReceivingBillType.getReceivingBillTypeInfo("where name='" + table.get("FEntrys$recType_name_l2").toString().trim() + "'");
				else {
					billTypeInfo = null;
					errorMsg.append("单据编号为"+number+"的单据,分录中收款类别\""+recType+"\"系统未找到, 置为空值，请手动修改\n");
				}
			}
			if(table.get("FEntrys$settlementType_name_l2") != null) {
				String settlement = table.get("FEntrys$settlementType_name_l2").toString();
				EntityViewInfo evi = new EntityViewInfo();
				FilterInfo filter = new FilterInfo();
				evi.setFilter(filter);
				filter.getFilterItems().add(new FilterItemInfo("name", table.get("FEntrys$settlementType_name_l2").toString().trim(), CompareType.EQUALS));
				SettlementTypeCollection settlementTypeCollection = iSettlementType.getSettlementTypeCollection(evi);
				if(settlementTypeCollection.size() > 0) 
					settlementTypeInfo = settlementTypeCollection.get(0);
				else {
					settlementTypeInfo = null;
					errorMsg.append("单据编号为"+number+"的单据,分录中收款方式\""+settlement+"\"系统未找到, 置为空值，请手动修改\n");
				}
			}
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
		table.remove("FEntrys$recType_name_l2");
		table.remove("FEntrys$settlementType_name_l2");
		table.remove("FEntrys_recAmount");
		return null;
	}

	@Override
	public void submit(CoreBaseInfo coreBaseInfo, Context ctx)
			throws TaskExternalException {
		ReceiptionInfo receiptionInfo = (ReceiptionInfo) coreBaseInfo;
		receiptionInfo.setBizState(BizState.saved);
		receiptionInfo.setPayUnitType(payUnitType.other);
		String upper = getChineseFormat(new BigDecimal(sum), false);//大写金额
		receiptionInfo.setUpperAmount(upper);
		if(receiption != null && receiption.getNumber().equals(receiptionInfo.getNumber())) {
			receiptionInfo = receiption;
			ReceiptionEntryInfo entryInfo = new ReceiptionEntryInfo();
			entryInfo.setRecAmount(new BigDecimal(amount));
			entryInfo.setRecType(billTypeInfo);
			entryInfo.setSettlementType(settlementTypeInfo);
			receiptionInfo.getEntrys().add(entryInfo);
		} else {
			ReceiptionEntryInfo entryInfo = new ReceiptionEntryInfo();
			entryInfo.setRecAmount(new BigDecimal(amount));
			entryInfo.setRecType(billTypeInfo);
			entryInfo.setSettlementType(settlementTypeInfo);
			receiptionInfo.getEntrys().add(entryInfo);
		}
		receiption = receiptionInfo;
		super.submit(receiptionInfo, ctx);
	}
	
	//数字金额转中文大写
	private static String getChineseName(String key) {
        return EASResource.getString("com.kingdee.eas.fi.gl.GLResource", key);
    }
	private static Properties getDecimalUnitMapping() {
        Properties decimalCurrencyUomb = new Properties();
        decimalCurrencyUomb.setProperty("0", getChineseName("jiao"));
        decimalCurrencyUomb.setProperty("1", getChineseName("fen"));
        decimalCurrencyUomb.setProperty("2", getChineseName("li"));

        return decimalCurrencyUomb;
    }
	private static Properties getIntegerUnitMapping(boolean flag) {
        Properties integerCurrencyUomb = new Properties();
        if (flag)
            integerCurrencyUomb.setProperty("0", "*" + getChineseName("money")); // needed
        // unit
        else
            integerCurrencyUomb.setProperty("0", "*"); // needed
        // unit
        integerCurrencyUomb.setProperty("1", getChineseName("ten"));
        integerCurrencyUomb.setProperty("2", getChineseName("handred"));
        integerCurrencyUomb.setProperty("3", getChineseName("thrasand"));
        integerCurrencyUomb.setProperty("4", "*" + getChineseName("tenshand")); // needed
        // unit
        integerCurrencyUomb.setProperty("5", getChineseName("ten"));
        integerCurrencyUomb.setProperty("6", getChineseName("handred"));
        integerCurrencyUomb.setProperty("7", getChineseName("thrasand"));
        integerCurrencyUomb.setProperty("8", "*" + getChineseName("handredmill")); // needed
        // unit
        integerCurrencyUomb.setProperty("9", getChineseName("ten"));
        integerCurrencyUomb.setProperty("10", getChineseName("handred"));
        integerCurrencyUomb.setProperty("11", getChineseName("thrasand"));
        integerCurrencyUomb.setProperty("12", getChineseName("tenshand"));
        integerCurrencyUomb.setProperty("13", getChineseName("handredmill"));
        integerCurrencyUomb.setProperty("14", getChineseName("ten"));

        return integerCurrencyUomb;
    }
	private static Properties getNumberMapping() {
        Properties numberMapping = new Properties();
        numberMapping.setProperty("0", getChineseName("zero"));
        numberMapping.setProperty("1", getChineseName("one"));
        numberMapping.setProperty("2", getChineseName("two"));
        numberMapping.setProperty("3", getChineseName("three"));
        numberMapping.setProperty("4", getChineseName("four"));
        numberMapping.setProperty("5", getChineseName("five"));
        numberMapping.setProperty("6", getChineseName("six"));
        numberMapping.setProperty("7", getChineseName("seven"));
        numberMapping.setProperty("8", getChineseName("eight"));
        numberMapping.setProperty("9", getChineseName("nine"));

        return numberMapping;
    }
	// 金额到角的话根据参数hasFull,设置“整”
    public static String getChineseFormat(BigDecimal number, boolean hasFull) {
        if (number == null) {
            return "";
        }

        String nagative = "";
        String nagVirText = "";
        boolean isNagativeB = false;
        if (number.toString().indexOf("-") >= 0) {
            nagative = getChineseName("nagative");
            isNagativeB = true;
        }

        Properties decimalPro = getDecimalUnitMapping();
        Properties integerPro = getIntegerUnitMapping(true);
        Properties numberPro = getNumberMapping();

        String valTemp = number.toString();
        
        /** 若是有负数,则去掉 "- "号 * */
        if (isNagativeB) {
            valTemp = valTemp.replace('-', ' ').trim();
        }

        int dotIndex = valTemp.indexOf(".");
        
        /** 整数部分 * */
        String integerStr = "";
        String integerTempStr = null;
        
        /** 小数部分 * */
        String decimalStr = "";
        String decimalTempStr = null;
        
        /** 1: **/
        if (dotIndex == -1) {
            integerTempStr = valTemp;
        } else {
            integerTempStr = valTemp.substring(0, dotIndex);
            decimalTempStr = valTemp.substring(dotIndex + 1);
        }

        /** 2: 整数部分的处理 * */

        if (integerTempStr != null) {
            int integerLen = integerTempStr.length() - 1;
            boolean zeroAttached = false; // Jacket:

            boolean hasTem = true;

            for (int i = integerLen; i >= 0; i--) {
                String index = String.valueOf(i);
                String str = String.valueOf(integerTempStr.charAt(integerLen - i));
                String numStr = numberPro.getProperty(str);
                String uombStr = integerPro.getProperty(index);

                boolean needed = false;
                if (uombStr.startsWith("*")) {
                    needed = true;
                    uombStr = uombStr.substring(1);
                    if (hasTem && i == 4 && integerLen >= 8) {
                        //uombStr = "";
                        if((('0' == integerTempStr.charAt(0) && '0' == integerTempStr.charAt(1)
                        		&& '0' == integerTempStr.charAt(2) && '0' == integerTempStr.charAt(3)
                        		&& '0' == integerTempStr.charAt(integerLen-8) &&'0' == integerTempStr.charAt(integerLen-7)
                        		&& '0' == integerTempStr.charAt(integerLen-6) && '0' == integerTempStr.charAt(integerLen-5))
                        		) && (('0' != integerTempStr.charAt(integerLen-4) || '0' != integerTempStr.charAt(integerLen-3)
                        		||  '0' != integerTempStr.charAt(integerLen-2)|| '0' != integerTempStr.charAt(integerLen-1)) )){
                        	uombStr = getChineseName("zero");
                        }else if(('0' != integerTempStr.charAt(integerLen-4))){
                        	//uombStr = getChineseName("zero");
                        }else{
                        	uombStr = "";
                        }
                        hasTem = false;
                    }                   
                }
                if ("0".equals(str)) {
                    if (zeroAttached) {
                        numStr = "";
                        if (needed) {
                            zeroAttached = false;
                            integerStr = integerStr.substring(0, integerStr.length() - 1);

                        } else {
                            uombStr = "";
                        }
                    } else {
                        if (!needed) {
                            zeroAttached = true;
                            uombStr = "";
                        } else {
                            zeroAttached = false;
                            numStr = "";
                        }
                    }
                } else {
                    if (i <= 7 && i >= 4) {
                        hasTem = false;
                    }
                    zeroAttached = false;
                }

                integerStr += numStr + uombStr;
            }
        }

        boolean integerEmpty = integerStr.length() < 2 ? true : false;
        if (integerEmpty) {
            integerStr = "";
        }

        boolean decimalEmpty = true;
        boolean hasJiao = false;
        
        /** 3: 小数部分的处理 * */
        if (decimalTempStr != null) {
            int decimalLen = decimalTempStr.length();
            int n = decimalPro.size();
            n = decimalLen > n ? n : decimalLen;
            boolean zeroAttached = false; // Jacket:
            boolean ignoreLeadingZero = true;
            for (int j = 0; j < n; j++) {
                String index = String.valueOf(j);
                String str = String.valueOf(decimalTempStr.charAt(j));
                String numStr = numberPro.getProperty(str);
                String uombStr = decimalPro.getProperty(index);

                if ("0".equals(str)) {
                    if (zeroAttached) {
                        numStr = "";
                        uombStr = "";
                        if (j == n - 1) {
                            decimalStr = decimalStr.substring(0, decimalStr.length() - 1);
                        }
                    } else {
                        if (j < n - 1 && !ignoreLeadingZero) {
                            zeroAttached = true;
                        } else {
                            numStr = "";
                        }
                        uombStr = "";
                    }
                } else {
                    if (j == 0) {
                        hasJiao = true;
                    } else {
                        hasJiao = false;
                    }
                    zeroAttached = false;
                    ignoreLeadingZero = false;
                }
                String temp = numStr + uombStr ;
                decimalStr = decimalStr + temp;
            }

            decimalEmpty = decimalStr.length() < 2 ? true : false;
            if (decimalEmpty) {
                decimalStr = "";
            }

            String unDescriptable = ""; // 无法用币别单位表达的小数位
            int index = -1; // 最后一个非零小数位
            for (int i = n; i < decimalLen; i++) {
                char c = decimalTempStr.charAt(i);
                String numStr = numberPro.getProperty(String.valueOf(c));
                unDescriptable += numStr;
                if ('0' != c) {
                    index = i;
                }
            }
            if (index >= 0) {
                decimalEmpty = false;
                if ('0' == decimalTempStr.charAt(n - 1)) {
                    decimalStr += getChineseName("zero") + decimalPro.getProperty(String.valueOf(n - 1));
                }

                decimalStr += unDescriptable.substring(0, index - n + 1);
            }else{
                if ('0' == decimalTempStr.charAt(0) && '0' != decimalTempStr.charAt(1)) {
                    decimalStr = getChineseName("zero") + decimalStr;
                }
            }
        }

        if (integerEmpty && decimalEmpty) {
            integerStr = getChineseName("zero") + getChineseName("money"); // "零元";
        }

        // 金额到分的话不应该有“整”
        // 金额到角的话根据参数设置“整”
        String value = nagative + nagVirText + integerStr + decimalStr;
        
//        if( decimalStr.length() == 1 && ! ( hasJiao)){
//            value = value +getChineseName("zero") ;
//        }
        
        value = nagative + nagVirText + integerStr + decimalStr;
        
        if ((decimalStr == null || decimalStr.length() == 0 || decimalStr.length() == 1) || ( hasJiao)) {
            value = value + getChineseName("full");
        }
        /** 4: 整合负数标识,整数和小数.* */
        return value;
    }
}
