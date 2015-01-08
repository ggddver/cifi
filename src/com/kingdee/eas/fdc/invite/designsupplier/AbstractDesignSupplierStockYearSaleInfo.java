package com.kingdee.eas.fdc.invite.designsupplier;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignSupplierStockYearSaleInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDesignSupplierStockYearSaleInfo()
    {
        this("id");
    }
    protected AbstractDesignSupplierStockYearSaleInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:销售额's 年份property 
     */
    public String getYear()
    {
        return getString("year");
    }
    public void setYear(String item)
    {
        setString("year", item);
    }
    /**
     * Object:销售额's 销售额property 
     */
    public java.math.BigDecimal getSaleCount()
    {
        return getBigDecimal("saleCount");
    }
    public void setSaleCount(java.math.BigDecimal item)
    {
        setBigDecimal("saleCount", item);
    }
    /**
     * Object: 销售额 's 所属单据体 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo getParent()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4A82BF16");
    }
}