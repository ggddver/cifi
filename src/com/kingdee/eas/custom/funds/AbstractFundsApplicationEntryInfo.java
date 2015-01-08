package com.kingdee.eas.custom.funds;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFundsApplicationEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFundsApplicationEntryInfo()
    {
        this("id");
    }
    protected AbstractFundsApplicationEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.funds.FundsApplicationInfo getParent()
    {
        return (com.kingdee.eas.custom.funds.FundsApplicationInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.funds.FundsApplicationInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 付款账号 property 
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
     * Object: 分录 's 收款单位 property 
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
     * Object: 分录 's 收款账号 property 
     */
    public com.kingdee.eas.basedata.assistant.AccountBankInfo getRecAccount()
    {
        return (com.kingdee.eas.basedata.assistant.AccountBankInfo)get("recAccount");
    }
    public void setRecAccount(com.kingdee.eas.basedata.assistant.AccountBankInfo item)
    {
        put("recAccount", item);
    }
    /**
     * Object:分录's 申请金额property 
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
     * Object:分录's 大写金额property 
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
     * Object:分录's 到帐时间property 
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
     * Object:分录's 款项用途描述property 
     */
    public String getUsage()
    {
        return getString("usage");
    }
    public void setUsage(String item)
    {
        setString("usage", item);
    }
    /**
     * Object:分录's 附件数property 
     */
    public int getAttachAmount()
    {
        return getInt("attachAmount");
    }
    public void setAttachAmount(int item)
    {
        setInt("attachAmount", item);
    }
    /**
     * Object:分录's 付款账户性质property 
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
     * Object:分录's 收款账号性质property 
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
     * Object:分录's 付款行property 
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
     * Object:分录's 收款行property 
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
     * Object: 分录 's 付款单位 property 
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
     * Object:分录's 收款账号property 
     */
    public String getRecAccountText()
    {
        return getString("recAccountText");
    }
    public void setRecAccountText(String item)
    {
        setString("recAccountText", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EB5050AB");
    }
}