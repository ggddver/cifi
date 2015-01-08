package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProductTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractProductTypeInfo()
    {
        this("id");
    }
    protected AbstractProductTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:适用产品类型's 启用property 
     */
    public boolean isIsEnabled()
    {
        return getBoolean("isEnabled");
    }
    public void setIsEnabled(boolean item)
    {
        setBoolean("isEnabled", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2EAF9E6A");
    }
}