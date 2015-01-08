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
     * Object: ������Ŀ 's null property 
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
     * Object:������Ŀ's ������Ŀ����飩property 
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
     * Object:������Ŀ's ������property 
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