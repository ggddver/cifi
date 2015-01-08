package com.kingdee.eas.custom.funds;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFundsApplicationBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFundsApplicationBillEntryInfo()
    {
        this("id");
    }
    protected AbstractFundsApplicationBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.custom.funds.FundsApplicationBillInfo getParent()
    {
        return (com.kingdee.eas.custom.funds.FundsApplicationBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.funds.FundsApplicationBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ���λ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getEntryPayUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("entryPayUnit");
    }
    public void setEntryPayUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("entryPayUnit", item);
    }
    /**
     * Object: ��¼ 's �����˺� property 
     */
    public com.kingdee.eas.basedata.assistant.AccountBankInfo getPayAccount()
    {
        return (com.kingdee.eas.basedata.assistant.AccountBankInfo)get("payAccount");
    }
    public void setPayAccount(com.kingdee.eas.basedata.assistant.AccountBankInfo item)
    {
        put("payAccount", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public String getPayBank()
    {
        return getString("payBank");
    }
    public void setPayBank(String item)
    {
        setString("payBank", item);
    }
    /**
     * Object:��¼'s �����˻�����property 
     */
    public String getPayAccProperty()
    {
        return getString("payAccProperty");
    }
    public void setPayAccProperty(String item)
    {
        setString("payAccProperty", item);
    }
    /**
     * Object: ��¼ 's �տλ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getRecUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("recUnit");
    }
    public void setRecUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("recUnit", item);
    }
    /**
     * Object:��¼'s �տ��˻�property 
     */
    public String getRecAccountText()
    {
        return getString("recAccountText");
    }
    public void setRecAccountText(String item)
    {
        setString("recAccountText", item);
    }
    /**
     * Object:��¼'s �տ���property 
     */
    public String getRecBank()
    {
        return getString("recBank");
    }
    public void setRecBank(String item)
    {
        setString("recBank", item);
    }
    /**
     * Object:��¼'s �տ��˻�����property 
     */
    public String getRecAccProperty()
    {
        return getString("recAccProperty");
    }
    public void setRecAccProperty(String item)
    {
        setString("recAccProperty", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:��¼'s ��д���property 
     */
    public String getUpperAmount()
    {
        return getString("upperAmount");
    }
    public void setUpperAmount(String item)
    {
        setString("upperAmount", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getRecDate()
    {
        return getDate("recDate");
    }
    public void setRecDate(java.util.Date item)
    {
        setDate("recDate", item);
    }
    /**
     * Object:��¼'s ������;property 
     */
    public String getUsage()
    {
        return getString("usage");
    }
    public void setUsage(String item)
    {
        setString("usage", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BBC6E464");
    }
}