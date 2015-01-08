package com.kingdee.eas.fdc.invite.designsupplier.subill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignSupplierSelectInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDesignSupplierSelectInfo()
    {
        this("id");
    }
    protected AbstractDesignSupplierSelectInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectEntryCollection());
    }
    /**
     * Object: ��Ӧ��ѡ�� 's ��¼ property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectEntryCollection getEntrys()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectEntryCollection)get("entrys");
    }
    /**
     * Object:��Ӧ��ѡ��'s �Ƿ�����ƾ֤property 
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
     * Object: ��Ӧ��ѡ�� 's ��Ӧ�̱��� property 
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
     * Object:��Ӧ��ѡ��'s ��Ӧ������property 
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
     * Object:��Ӧ��ѡ��'s ������property 
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
     * Object:��Ӧ��ѡ��'s ������IDproperty 
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
     * Object:��Ӧ��ѡ��'s ��������property 
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
     * Object:��Ӧ��ѡ��'s ְ��property 
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
     * Object:��Ӧ��ѡ��'s ��Ȩ��ϵ��property 
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
     * Object:��Ӧ��ѡ��'s ��Ȩ��ϵ�˵绰property 
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
     * Object: ��Ӧ��ѡ�� 's �������Ŀ property 
     */
    public com.kingdee.eas.fdc.basedata.OperationPhasesInfo getPro()
    {
        return (com.kingdee.eas.fdc.basedata.OperationPhasesInfo)get("Pro");
    }
    public void setPro(com.kingdee.eas.fdc.basedata.OperationPhasesInfo item)
    {
        put("Pro", item);
    }
    /**
     * Object: ��Ӧ��ѡ�� 's ��Ӧ�̼��� property 
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
     * Object:��Ӧ��ѡ��'s ѡ��˵����property 
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
     * Object:��Ӧ��ѡ��'s ���ʱ��property 
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
     * Object:��Ӧ��ѡ��'s ����״̬property 
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
     * Object: ��Ӧ��ѡ�� 's ������ҵ�� property 
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
     * Object: ��Ӧ��ѡ�� 's ������ property 
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
     * Object: ��Ӧ��ѡ�� 's �ı� property 
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
        return new BOSObjectType("9DAB65AB");
    }
}