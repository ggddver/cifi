package com.kingdee.eas.fdc.invite.designsupplier.demotion;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDemotionEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDemotionEntryInfo()
    {
        this("id");
    }
    protected AbstractDemotionEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionInfo getParent()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ����ά��property 
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
     * Object: ��¼ 's ָ������ property 
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
     * Object:��¼'s �������property 
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
     * Object:��¼'s �ϸ����property 
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
        return new BOSObjectType("2A0E27C4");
    }
}