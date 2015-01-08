package com.kingdee.eas.fdc.invite.designsupplier;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignSelectSupplierDBInfo extends com.kingdee.eas.framework.CoreBaseInfo implements Serializable 
{
    public AbstractDesignSelectSupplierDBInfo()
    {
        this("id");
    }
    protected AbstractDesignSelectSupplierDBInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:null's nullproperty 
     */
    public com.kingdee.bos.util.BOSUuid getId()
    {
        return getBOSUuid("id");
    }
    public void setId(com.kingdee.bos.util.BOSUuid item)
    {
        setBOSUuid("id", item);
    }
    /**
     * Object:null's ��Ŀ����IDproperty 
     */
    public String getProId()
    {
        return getString("ProId");
    }
    public void setProId(String item)
    {
        setString("ProId", item);
    }
    /**
     * Object:null's ��˾���property 
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
     * Object:null's ��Ա����property 
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
     * Object:null's �������property 
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
     * Object:null's ���ڷ���property 
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
     * Object:null's ������Ŀproperty 
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
     * Object:null's ���񱨼�property 
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
     * Object:null's nullproperty 
     */
    public String getDesignSupplierId()
    {
        return getString("DesignSupplierId");
    }
    public void setDesignSupplierId(String item)
    {
        setString("DesignSupplierId", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EE370A3E");
    }
}