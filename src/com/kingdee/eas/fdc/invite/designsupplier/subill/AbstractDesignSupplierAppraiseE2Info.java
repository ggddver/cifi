package com.kingdee.eas.fdc.invite.designsupplier.subill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignSupplierAppraiseE2Info extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDesignSupplierAppraiseE2Info()
    {
        this("id");
    }
    protected AbstractDesignSupplierAppraiseE2Info(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 第2个表体 's null property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo getParent()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:第2个表体's 权重%property 
     */
    public String getWeight()
    {
        return getString("Weight");
    }
    public void setWeight(String item)
    {
        setString("Weight", item);
    }
    /**
     * Object:第2个表体's 情况描述property 
     */
    public String getCaseDeisn()
    {
        return getString("caseDeisn");
    }
    public void setCaseDeisn(String item)
    {
        setString("caseDeisn", item);
    }
    /**
     * Object:第2个表体's 评分(5分制)property 
     */
    public java.math.BigDecimal getScore()
    {
        return getBigDecimal("Score");
    }
    public void setScore(java.math.BigDecimal item)
    {
        setBigDecimal("Score", item);
    }
    /**
     * Object: 第2个表体 's 评审人 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getReviewers()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("Reviewers");
    }
    public void setReviewers(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("Reviewers", item);
    }
    /**
     * Object: 第2个表体 's 评审部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getReviewersDep()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("ReviewersDep");
    }
    public void setReviewersDep(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("ReviewersDep", item);
    }
    /**
     * Object:第2个表体's 备注property 
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
        return new BOSObjectType("E6083567");
    }
}