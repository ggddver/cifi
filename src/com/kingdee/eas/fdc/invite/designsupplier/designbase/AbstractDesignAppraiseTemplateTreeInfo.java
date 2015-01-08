package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignAppraiseTemplateTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractDesignAppraiseTemplateTreeInfo()
    {
        this("id");
    }
    protected AbstractDesignAppraiseTemplateTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 供应商评审模板组别 's 父节点 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateTreeInfo getParent()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B6A48460");
    }
}