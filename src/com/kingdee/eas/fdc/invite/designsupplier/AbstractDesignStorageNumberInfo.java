package com.kingdee.eas.fdc.invite.designsupplier;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignStorageNumberInfo extends com.kingdee.eas.fdc.invite.markesupplier.MarketSupplierStorageNumberInfo implements Serializable 
{
    public AbstractDesignStorageNumberInfo()
    {
        this("id");
    }
    protected AbstractDesignStorageNumberInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:设计供应商入库编码's nullproperty 
     */
    public com.kingdee.bos.util.BOSUuid getId()
    {
        return getBOSUuid("id");
    }
    public void setId(com.kingdee.bos.util.BOSUuid item)
    {
        setBOSUuid("id", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("745AABCC");
    }
}