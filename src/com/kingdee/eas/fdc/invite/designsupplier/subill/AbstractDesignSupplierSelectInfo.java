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
     * Object: 供应商选用 's 分录 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectEntryCollection getEntrys()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectEntryCollection)get("entrys");
    }
    /**
     * Object:供应商选用's 是否生成凭证property 
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
     * Object: 供应商选用 's 供应商编码 property 
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
     * Object:供应商选用's 供应商名称property 
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
     * Object:供应商选用's 设计类别property 
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
     * Object:供应商选用's 设计类别IDproperty 
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
     * Object:供应商选用's 服务区域property 
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
     * Object:供应商选用's 职务property 
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
     * Object:供应商选用's 授权联系人property 
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
     * Object:供应商选用's 授权联系人电话property 
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
     * Object: 供应商选用 's 拟合作项目 property 
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
     * Object: 供应商选用 's 供应商级别 property 
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
     * Object:供应商选用's 选用说明：property 
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
     * Object:供应商选用's 审核时间property 
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
     * Object:供应商选用's 单据状态property 
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
     * Object: 供应商选用 's 所属事业部 property 
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
     * Object: 供应商选用 's 设计类别 property 
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
     * Object: 供应商选用 's 文本 property 
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