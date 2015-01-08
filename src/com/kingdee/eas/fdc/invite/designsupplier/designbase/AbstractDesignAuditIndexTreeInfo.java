package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignAuditIndexTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractDesignAuditIndexTreeInfo()
    {
        this("id");
    }
    protected AbstractDesignAuditIndexTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 供应商评审指标组别 's 父节点 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexTreeInfo getParent()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E2B992D2");
    }
}