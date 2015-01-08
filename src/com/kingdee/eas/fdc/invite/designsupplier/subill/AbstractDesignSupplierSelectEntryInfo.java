package com.kingdee.eas.fdc.invite.designsupplier.subill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignSupplierSelectEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDesignSupplierSelectEntryInfo()
    {
        this("id");
    }
    protected AbstractDesignSupplierSelectEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectInfo getParent()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 邀约供应商 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo getSupplier()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object: 分录 's 供应商级别 property 
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
     * Object:分录's 公司情况property 
     */
    public String getSupplierCompany()
    {
        return getString("supplierCompany");
    }
    public void setSupplierCompany(String item)
    {
        setString("supplierCompany", item);
    }
    /**
     * Object:分录's 人员配置property 
     */
    public String getPeopleCfg()
    {
        return getString("peopleCfg");
    }
    public void setPeopleCfg(String item)
    {
        setString("peopleCfg", item);
    }
    /**
     * Object:分录's 设计质量property 
     */
    public String getDesign()
    {
        return getString("design");
    }
    public void setDesign(String item)
    {
        setString("design", item);
    }
    /**
     * Object:分录's 后期服务property 
     */
    public String getPostService()
    {
        return getString("PostService");
    }
    public void setPostService(String item)
    {
        setString("PostService", item);
    }
    /**
     * Object:分录's 代表项目property 
     */
    public String getPro()
    {
        return getString("Pro");
    }
    public void setPro(String item)
    {
        setString("Pro", item);
    }
    /**
     * Object:分录's 总价property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:分录's 备注property 
     */
    public String getRemake()
    {
        return getString("remake");
    }
    public void setRemake(String item)
    {
        setString("remake", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B6788587");
    }
}