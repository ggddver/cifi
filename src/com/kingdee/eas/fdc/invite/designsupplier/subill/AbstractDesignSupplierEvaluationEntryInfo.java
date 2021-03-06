package com.kingdee.eas.fdc.invite.designsupplier.subill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignSupplierEvaluationEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDesignSupplierEvaluationEntryInfo()
    {
        this("id");
    }
    protected AbstractDesignSupplierEvaluationEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationInfo getParent()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 评审维度property 
     */
    public String getReview()
    {
        return getString("Review");
    }
    public void setReview(String item)
    {
        setString("Review", item);
    }
    /**
     * Object: 分录 's 指标名称 property 
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
     * Object:分录's 情况描述property 
     */
    public String getCasedescription()
    {
        return getString("Casedescription");
    }
    public void setCasedescription(String item)
    {
        setString("Casedescription", item);
    }
    /**
     * Object:分录's 合格与否property 
     */
    public com.kingdee.eas.fdc.invite.supplier.IsGradeEnum getIsQualified()
    {
        return com.kingdee.eas.fdc.invite.supplier.IsGradeEnum.getEnum(getInt("IsQualified"));
    }
    public void setIsQualified(com.kingdee.eas.fdc.invite.supplier.IsGradeEnum item)
    {
		if (item != null) {
        setInt("IsQualified", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("95E15AC7");
    }
}