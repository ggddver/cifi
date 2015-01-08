package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignPhaseInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDesignPhaseInfo()
    {
        this("id");
    }
    protected AbstractDesignPhaseInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:…Ëº∆Ω◊∂Œ's ∆Ù”√property 
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
        return new BOSObjectType("50EF9BFE");
    }
}