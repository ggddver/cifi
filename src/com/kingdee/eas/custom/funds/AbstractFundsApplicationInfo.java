package com.kingdee.eas.custom.funds;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFundsApplicationInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFundsApplicationInfo()
    {
        this("id");
    }
    protected AbstractFundsApplicationInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.funds.FundsApplicationEntryCollection());
    }
    /**
     * Object: 资金往来申请单 's 分录 property 
     */
    public com.kingdee.eas.custom.funds.FundsApplicationEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.funds.FundsApplicationEntryCollection)get("entrys");
    }
    /**
     * Object:资金往来申请单's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 资金往来申请单 's 付款单位 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getPayUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("payUnit");
    }
    public void setPayUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("payUnit", item);
    }
    /**
     * Object:资金往来申请单's 申请区域公司property 
     */
    public String getAppCompany()
    {
        return getString("appCompany");
    }
    public void setAppCompany(String item)
    {
        setString("appCompany", item);
    }
    /**
     * Object:资金往来申请单's 审批时间property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("auditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("auditDate", item);
    }
    /**
     * Object:资金往来申请单's 单据状态property 
     */
    public com.kingdee.eas.custom.funds.BizState getBizState()
    {
        return com.kingdee.eas.custom.funds.BizState.getEnum(getString("bizState"));
    }
    public void setBizState(com.kingdee.eas.custom.funds.BizState item)
    {
		if (item != null) {
        setString("bizState", item.getValue());
		}
    }
    /**
     * Object: 资金往来申请单 's 所属行政组织 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getAuditOrg()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("auditOrg");
    }
    public void setAuditOrg(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("auditOrg", item);
    }
    /**
     * Object:资金往来申请单's 是否集团付款property 
     */
    public boolean isIsGroup()
    {
        return getBoolean("isGroup");
    }
    public void setIsGroup(boolean item)
    {
        setBoolean("isGroup", item);
    }
    /**
     * Object:资金往来申请单's 单笔最大金额property 
     */
    public java.math.BigDecimal getSingleMaxAmount()
    {
        return getBigDecimal("singleMaxAmount");
    }
    public void setSingleMaxAmount(java.math.BigDecimal item)
    {
        setBigDecimal("singleMaxAmount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3DE23407");
    }
}