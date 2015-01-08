package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDirectRuleTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractDirectRuleTreeInfo()
    {
        this("id");
    }
    protected AbstractDirectRuleTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 直接议标编码规则组别 's 父节点 property 
     */
    public com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.DirectRuleTreeInfo getParent()
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.DirectRuleTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.DirectRuleTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("48887139");
    }
}