package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignServiceTypeInfo extends com.kingdee.eas.fdc.basedata.FDCTreeBaseDataInfo implements Serializable 
{
    public AbstractDesignServiceTypeInfo()
    {
        this("id");
    }
    protected AbstractDesignServiceTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 服务类型 's 父节点 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceTypeInfo getParent()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceTypeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceTypeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F83ECBD2");
    }
}