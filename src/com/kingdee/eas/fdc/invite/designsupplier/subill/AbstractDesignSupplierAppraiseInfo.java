package com.kingdee.eas.fdc.invite.designsupplier.subill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignSupplierAppraiseInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDesignSupplierAppraiseInfo()
    {
        this("id");
    }
    protected AbstractDesignSupplierAppraiseInfo(String pkField)
    {
        super(pkField);
        put("E2", new com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseE2Collection());
        put("entrys", new com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseEntryCollection());
    }
    /**
     * Object: ��Ӧ�̺����� 's ��¼ property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseEntryCollection getEntrys()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseEntryCollection)get("entrys");
    }
    /**
     * Object:��Ӧ�̺�����'s �Ƿ�����ƾ֤property 
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
     * Object: ��Ӧ�̺����� 's ��Ӧ�̱��� property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo getSupplierNumber()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo)get("supplierNumber");
    }
    public void setSupplierNumber(com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo item)
    {
        put("supplierNumber", item);
    }
    /**
     * Object:��Ӧ�̺�����'s ��Ӧ������property 
     */
    public String getSupplierName()
    {
        return getString("supplierName");
    }
    public void setSupplierName(String item)
    {
        setString("supplierName", item);
    }
    /**
     * Object:��Ӧ�̺�����'s �������property 
     */
    public String getDesignType()
    {
        return getString("DesignType");
    }
    public void setDesignType(String item)
    {
        setString("DesignType", item);
    }
    /**
     * Object:��Ӧ�̺�����'s �������IDproperty 
     */
    public String getDesignTypeID()
    {
        return getString("DesignTypeID");
    }
    public void setDesignTypeID(String item)
    {
        setString("DesignTypeID", item);
    }
    /**
     * Object:��Ӧ�̺�����'s ��������property 
     */
    public String getServiceArea()
    {
        return getString("ServiceArea");
    }
    public void setServiceArea(String item)
    {
        setString("ServiceArea", item);
    }
    /**
     * Object:��Ӧ�̺�����'s ְ��property 
     */
    public String getJob()
    {
        return getString("Job");
    }
    public void setJob(String item)
    {
        setString("Job", item);
    }
    /**
     * Object:��Ӧ�̺�����'s ��Ȩ��ϵ��property 
     */
    public String getAuthorizedPer()
    {
        return getString("AuthorizedPer");
    }
    public void setAuthorizedPer(String item)
    {
        setString("AuthorizedPer", item);
    }
    /**
     * Object:��Ӧ�̺�����'s ��Ȩ��ϵ�˵绰property 
     */
    public String getAuthorizedTel()
    {
        return getString("AuthorizedTel");
    }
    public void setAuthorizedTel(String item)
    {
        setString("AuthorizedTel", item);
    }
    /**
     * Object:��Ӧ�̺�����'s ���˵����property 
     */
    public String getRemake()
    {
        return getString("remake");
    }
    public void setRemake(String item)
    {
        setString("remake", item);
    }
    /**
     * Object:��Ӧ�̺�����'s �ۺϵ÷�property 
     */
    public java.math.BigDecimal getGoal()
    {
        return getBigDecimal("goal");
    }
    public void setGoal(java.math.BigDecimal item)
    {
        setBigDecimal("goal", item);
    }
    /**
     * Object:��Ӧ�̺�����'s ������property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum getResults()
    {
        return com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum.getEnum(getString("results"));
    }
    public void setResults(com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum item)
    {
		if (item != null) {
        setString("results", item.getValue());
		}
    }
    /**
     * Object: ��Ӧ�̺����� 's ��2������ property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseE2Collection getE2()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseE2Collection)get("E2");
    }
    /**
     * Object:��Ӧ�̺�����'s �������property 
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
     * Object:��Ӧ�̺�����'s ����״̬property 
     */
    public com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum getState()
    {
        return com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum.getEnum(getInt("state"));
    }
    public void setState(com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum item)
    {
		if (item != null) {
        setInt("state", item.getValue());
		}
    }
    /**
     * Object: ��Ӧ�̺����� 's ������ҵ�� property 
     */
    public com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo getOrg()
    {
        return (com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo)get("Org");
    }
    public void setOrg(com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo item)
    {
        put("Org", item);
    }
    /**
     * Object: ��Ӧ�̺����� 's ������ property 
     */
    public com.kingdee.eas.fdc.invite.InviteTypeInfo getInvTyep()
    {
        return (com.kingdee.eas.fdc.invite.InviteTypeInfo)get("InvTyep");
    }
    public void setInvTyep(com.kingdee.eas.fdc.invite.InviteTypeInfo item)
    {
        put("InvTyep", item);
    }
    /**
     * Object: ��Ӧ�̺����� 's ��Ӧ�̵ȼ� property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo getSupplierLv()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo)get("supplierLv");
    }
    public void setSupplierLv(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo item)
    {
        put("supplierLv", item);
    }
    /**
     * Object:��Ӧ�̺�����'s ��ҵ��Ȩ��%property 
     */
    public java.math.BigDecimal getSybWeight()
    {
        return getBigDecimal("sybWeight");
    }
    public void setSybWeight(java.math.BigDecimal item)
    {
        setBigDecimal("sybWeight", item);
    }
    /**
     * Object:��Ӧ�̺�����'s ����Ȩ��%property 
     */
    public java.math.BigDecimal getJtWeight()
    {
        return getBigDecimal("jtWeight");
    }
    public void setJtWeight(java.math.BigDecimal item)
    {
        setBigDecimal("jtWeight", item);
    }
    /**
     * Object: ��Ӧ�̺����� 's �ɹ���֯ property 
     */
    public com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo getPusOrg()
    {
        return (com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo)get("PusOrg");
    }
    public void setPusOrg(com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo item)
    {
        put("PusOrg", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E0019B5A");
    }
}