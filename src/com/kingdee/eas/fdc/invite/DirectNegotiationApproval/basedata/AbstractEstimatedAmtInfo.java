package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEstimatedAmtInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractEstimatedAmtInfo()
    {
        this("id");
    }
    protected AbstractEstimatedAmtInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 预估金额 's 组别 property 
     */
    public com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.EstimatedAmtTreeInfo getTreeid()
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.EstimatedAmtTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.EstimatedAmtTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:预估金额's 启用property 
     */
    public boolean isUse()
    {
        return getBoolean("use");
    }
    public void setUse(boolean item)
    {
        setBoolean("use", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("617476E2");
    }
}