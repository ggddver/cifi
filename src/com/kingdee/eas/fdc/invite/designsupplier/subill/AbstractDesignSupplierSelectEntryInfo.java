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
     * Object: ��¼ 's ����ͷ property 
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
     * Object: ��¼ 's ��Լ��Ӧ�� property 
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
     * Object: ��¼ 's ��Ӧ�̼��� property 
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
     * Object:��¼'s ��˾���property 
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
     * Object:��¼'s ��Ա����property 
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
     * Object:��¼'s �������property 
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
     * Object:��¼'s ���ڷ���property 
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
     * Object:��¼'s ������Ŀproperty 
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
     * Object:��¼'s �ܼ�property 
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
     * Object:��¼'s ��עproperty 
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