package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEstimatedAmtTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractEstimatedAmtTreeInfo()
    {
        this("id");
    }
    protected AbstractEstimatedAmtTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 预估金额组别 's 父节点 property 
     */
    public com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.EstimatedAmtTreeInfo getParent()
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.EstimatedAmtTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.EstimatedAmtTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("12E21DA0");
    }
}