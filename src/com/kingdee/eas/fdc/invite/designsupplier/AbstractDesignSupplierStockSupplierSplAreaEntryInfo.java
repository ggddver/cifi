package com.kingdee.eas.fdc.invite.designsupplier;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignSupplierStockSupplierSplAreaEntryInfo extends com.kingdee.eas.framework.CoreBaseInfo implements Serializable 
{
    public AbstractDesignSupplierStockSupplierSplAreaEntryInfo()
    {
        this("id");
    }
    protected AbstractDesignSupplierStockSupplierSplAreaEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 服务区域分录 's 服务区域 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaInfo getFdcSplArea()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaInfo)get("fdcSplArea");
    }
    public void setFdcSplArea(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaInfo item)
    {
        put("fdcSplArea", item);
    }
    /**
     * Object: 服务区域分录 's 供应商 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo getHead()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo)get("head");
    }
    public void setHead(com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo item)
    {
        put("head", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("100778D4");
    }
}