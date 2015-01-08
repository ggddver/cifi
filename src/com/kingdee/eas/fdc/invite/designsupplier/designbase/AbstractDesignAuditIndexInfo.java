package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignAuditIndexInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDesignAuditIndexInfo()
    {
        this("id");
    }
    protected AbstractDesignAuditIndexInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 供应商评审指标 's 组别 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexTreeInfo getTreeid()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 供应商评审指标 's 评审维度 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexTreeInfo getAccreditationWD()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexTreeInfo)get("AccreditationWD");
    }
    public void setAccreditationWD(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexTreeInfo item)
    {
        put("AccreditationWD", item);
    }
    /**
     * Object:供应商评审指标's 3分标准property 
     */
    public String getThreeStandard()
    {
        return getString("threeStandard");
    }
    public void setThreeStandard(String item)
    {
        setString("threeStandard", item);
    }
    /**
     * Object:供应商评审指标's 描述property 
     */
    public String getRemake()
    {
        return getString("remake");
    }
    public void setRemake(String item)
    {
        setString("remake", item);
    }
    /**
     * Object:供应商评审指标's 是否启用property 
     */
    public boolean isIsEnable()
    {
        return getBoolean("isEnable");
    }
    public void setIsEnable(boolean item)
    {
        setBoolean("isEnable", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("98AA5514");
    }
}