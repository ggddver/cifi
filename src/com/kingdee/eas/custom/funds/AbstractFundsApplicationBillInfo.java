package com.kingdee.eas.custom.funds;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFundsApplicationBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFundsApplicationBillInfo()
    {
        this("id");
    }
    protected AbstractFundsApplicationBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.funds.FundsApplicationBillEntryCollection());
    }
    /**
     * Object: �ʽ������� 's ��¼ property 
     */
    public com.kingdee.eas.custom.funds.FundsApplicationBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.funds.FundsApplicationBillEntryCollection)get("entrys");
    }
    /**
     * Object:�ʽ�������'s �Ƿ�����ƾ֤property 
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
     * Object: �ʽ������� 's ��������˾ property 
     */
    public com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo getAppCompany()
    {
        return (com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo)get("appCompany");
    }
    public void setAppCompany(com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo item)
    {
        put("appCompany", item);
    }
    /**
     * Object:�ʽ�������'s �Ƿ��Ÿ���property 
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
     * Object:�ʽ�������'s ���ʱ��property 
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
     * Object: �ʽ������� 's ����������֯ property 
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
     * Object:�ʽ�������'s ����״̬property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5A2A70AE");
    }
}