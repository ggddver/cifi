package com.kingdee.eas.fdc.invite.designsupplier;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignSupplierStockProjectInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDesignSupplierStockProjectInfo()
    {
        this("id");
    }
    protected AbstractDesignSupplierStockProjectInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 代表项目 's null property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo getParent()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:代表项目's 代表项目（简介）property 
     */
    public String getProjectName()
    {
        return getString("projectName");
    }
    public void setProjectName(String item)
    {
        setString("projectName", item);
    }
    /**
     * Object:代表项目's 所获奖项property 
     */
    public String getAwld()
    {
        return getString("awld");
    }
    public void setAwld(String item)
    {
        setString("awld", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A89AFBE7");
    }
}