package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignAppraiseTemplateE1Info extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDesignAppraiseTemplateE1Info()
    {
        this("id");
    }
    protected AbstractDesignAppraiseTemplateE1Info(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 指标分录 's null property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateInfo getParent()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 指标分录 's 指标名称 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexInfo getIndexName()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexInfo)get("IndexName");
    }
    public void setIndexName(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexInfo item)
    {
        put("IndexName", item);
    }
    /**
     * Object:指标分录's 评审维度property 
     */
    public String getAccreditationwd()
    {
        return getString("Accreditationwd");
    }
    public void setAccreditationwd(String item)
    {
        setString("Accreditationwd", item);
    }
    /**
     * Object:指标分录's 3分标准property 
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
     * Object:指标分录's 指标描述property 
     */
    public String getIndexDesc()
    {
        return getString("IndexDesc");
    }
    public void setIndexDesc(String item)
    {
        setString("IndexDesc", item);
    }
    /**
     * Object:指标分录's 评分类别property 
     */
    public com.kingdee.eas.fdc.invite.supplier.AppraiseTypeEnum getScoreType()
    {
        return com.kingdee.eas.fdc.invite.supplier.AppraiseTypeEnum.getEnum(getString("ScoreType"));
    }
    public void setScoreType(com.kingdee.eas.fdc.invite.supplier.AppraiseTypeEnum item)
    {
		if (item != null) {
        setString("ScoreType", item.getValue());
		}
    }
    /**
     * Object:指标分录's 权重%property 
     */
    public java.math.BigDecimal getQz()
    {
        return getBigDecimal("qz");
    }
    public void setQz(java.math.BigDecimal item)
    {
        setBigDecimal("qz", item);
    }
    /**
     * Object:指标分录's 备注property 
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
        return new BOSObjectType("70DF65AE");
    }
}