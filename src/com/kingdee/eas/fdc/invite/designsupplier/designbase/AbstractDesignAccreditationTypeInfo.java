package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignAccreditationTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDesignAccreditationTypeInfo()
    {
        this("id");
    }
    protected AbstractDesignAccreditationTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:供应商评审类型's 是否启用property 
     */
    public boolean isIsEnable()
    {
        return getBoolean("isEnable");
    }
    public void setIsEnable(boolean item)
    {
        setBoolean("isEnable", item);
    }
    /**
     * Object:供应商评审类型's 描述property 
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
        return new BOSObjectType("87E92A97");
    }
}