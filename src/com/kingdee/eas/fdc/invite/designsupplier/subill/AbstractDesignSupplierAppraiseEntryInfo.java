package com.kingdee.eas.fdc.invite.designsupplier.subill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignSupplierAppraiseEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDesignSupplierAppraiseEntryInfo()
    {
        this("id");
    }
    protected AbstractDesignSupplierAppraiseEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
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
     * Object:��¼'s Ȩ��%property 
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
     * Object:��¼'s �������property 
     */
    public String getCaseDescription()
    {
        return getString("caseDescription");
    }
    public void setCaseDescription(String item)
    {
        setString("caseDescription", item);
    }
    /**
     * Object:��¼'s ����(5����)property 
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
     * Object: ��¼ 's ������ property 
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
     * Object: ��¼ 's ������ property 
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
     * Object:��¼'s ˵��property 
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
        return new BOSObjectType("155B8538");
    }
}