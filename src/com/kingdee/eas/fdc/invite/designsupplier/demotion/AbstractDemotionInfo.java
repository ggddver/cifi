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
     * Object: 供应商升降级 's 分录 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionEntryCollection getEntrys()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionEntryCollection)get("entrys");
    }
    /**
     * Object:供应商升降级's 是否生成凭证property 
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
     * Object: 供应商升降级 's 供应商编码 property 
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
     * Object:供应商升降级's 供应商名称property 
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
     * Object:供应商升降级's 设计类别property 
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
     * Object:供应商升降级's 设计类别IDproperty 
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
     * Object:供应商升降级's 服务区域property 
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
     * Object:供应商升降级's 职务property 
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
     * Object:供应商升降级's 授权联系人property 
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
     * Object:供应商升降级's 授权联系人电话property 
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
     * Object: 供应商升降级 's 评审类型 property 
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
     * Object: 供应商升降级 's 评审模板 property 
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
     * Object:供应商升降级's 审核时间property 
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
     * Object:供应商升降级's 情况说明：property 
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
     * Object: 供应商升降级 's 拟合作项目 property 
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
     * Object: 供应商升降级 's 评审前等级 property 
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
     * Object: 供应商升降级 's 供应商等级 property 
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
     * Object:供应商升降级's 是否合格property 
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
     * Object:供应商升降级's 单据状态property 
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
     * Object: 供应商升降级 's 所属事业部 property 
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
     * Object: 供应商升降级 's 设计类别 property 
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
     * Object:供应商升降级's 是否合格property 
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
     * Object: 供应商升降级 's 文本 property 
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