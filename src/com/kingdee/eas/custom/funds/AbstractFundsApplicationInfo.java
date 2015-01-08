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
     * Object: �ʽ��������뵥 's ��¼ property 
     */
    public com.kingdee.eas.custom.funds.FundsApplicationEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.funds.FundsApplicationEntryCollection)get("entrys");
    }
    /**
     * Object:�ʽ��������뵥's �Ƿ�����ƾ֤property 
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
     * Object: �ʽ��������뵥 's ���λ property 
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
     * Object:�ʽ��������뵥's ��������˾property 
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
     * Object:�ʽ��������뵥's ����ʱ��property 
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
     * Object:�ʽ��������뵥's ����״̬property 
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
     * Object: �ʽ��������뵥 's ����������֯ property 
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
     * Object:�ʽ��������뵥's �Ƿ��Ÿ���property 
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
     * Object:�ʽ��������뵥's ���������property 
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