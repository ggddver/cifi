package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDirectRuleInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDirectRuleInfo()
    {
        this("id");
    }
    protected AbstractDirectRuleInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 直接议标编码规则 's 组别 property 
     */
    public com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.DirectRuleTreeInfo getTreeid()
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.DirectRuleTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.DirectRuleTreeInfo item)
    {
        put("treeid", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("79FE7EFB");
    }
}