package com.kingdee.eas.fdc.invite.designsupplier.demotion;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDemotionInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDemotionInfo()
    {
        this("id");
    }
    protected AbstractDemotionInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionEntryCollection());
    }
    /**
     * Object: ��Ӧ�������� 's ��¼ property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionEntryCollection getEntrys()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionEntryCollection)get("entrys");
    }
    /**
     * Object:��Ӧ��������'s �Ƿ�����ƾ֤property 
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
     * Object: ��Ӧ�������� 's ��Ӧ�̱��� property 
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
     * Object:��Ӧ��������'s ��Ӧ������property 
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
     * Object:��Ӧ��������'s ������property 
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
     * Object:��Ӧ��������'s ������IDproperty 
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
     * Object:��Ӧ��������'s ��������property 
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
     * Object:��Ӧ��������'s ְ��property 
     */
    public String getJob()
    {
        return getString("job");
    }
    public void setJob(String item)
    {
        setString("job", item);
    }
    /**
     * Object:��Ӧ��������'s ��Ȩ��ϵ��property 
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
     * Object:��Ӧ��������'s ��Ȩ��ϵ�˵绰property 
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
     * Object: ��Ӧ�������� 's �������� property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAccreditationTypeInfo getEvaluationType()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAccreditationTypeInfo)get("EvaluationType");
    }
    public void setEvaluationType(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAccreditationTypeInfo item)
    {
        put("EvaluationType", item);
    }
    /**
     * Object: ��Ӧ�������� 's ����ģ�� property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateInfo getSupplierTemple()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateInfo)get("supplierTemple");
    }
    public void setSupplierTemple(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateInfo item)
    {
        put("supplierTemple", item);
    }
    /**
     * Object:��Ӧ��������'s ���ʱ��property 
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
     * Object:��Ӧ��������'s ���˵����property 
     */
    public String getRemkae()
    {
        return getString("remkae");
    }
    public void setRemkae(String item)
    {
        setString("remkae", item);
    }
    /**
     * Object: ��Ӧ�������� 's �������Ŀ property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo getPro()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo)get("Pro");
    }
    public void setPro(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo item)
    {
        put("Pro", item);
    }
    /**
     * Object: ��Ӧ�������� 's ����ǰ�ȼ� property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo getSupplierClas()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo)get("supplierClas");
    }
    public void setSupplierClas(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo item)
    {
        put("supplierClas", item);
    }
    /**
     * Object: ��Ӧ�������� 's ��Ӧ�̵ȼ� property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo getSupplierlastClas()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo)get("supplierlastClas");
    }
    public void setSupplierlastClas(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo item)
    {
        put("supplierlastClas", item);
    }
    /**
     * Object:��Ӧ��������'s �Ƿ�ϸ�property 
     */
    public com.kingdee.eas.fdc.invite.supplier.IsGradeEnum getIshg()
    {
        return com.kingdee.eas.fdc.invite.supplier.IsGradeEnum.getEnum(getInt("Ishg"));
    }
    public void setIshg(com.kingdee.eas.fdc.invite.supplier.IsGradeEnum item)
    {
		if (item != null) {
        setInt("Ishg", item.getValue());
		}
    }
    /**
     * Object:��Ӧ��������'s ����״̬property 
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
     * Object: ��Ӧ�������� 's ������ҵ�� property 
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
     * Object: ��Ӧ�������� 's ������ property 
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
     * Object:��Ӧ��������'s �Ƿ�ϸ�property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum getResuitl()
    {
        return com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum.getEnum(getString("resuitl"));
    }
    public void setResuitl(com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum item)
    {
		if (item != null) {
        setString("resuitl", item.getValue());
		}
    }
    /**
     * Object: ��Ӧ�������� 's �ı� property 
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
        return new BOSObjectType("EC7E914E");
    }
}