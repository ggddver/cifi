package com.kingdee.eas.fdc.invite;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInviteFixInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractInviteFixInfo()
    {
        this("id");
    }
    protected AbstractInviteFixInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ��Ӧ�̵ȼ� property 
     */
    public com.kingdee.eas.fdc.invite.supplier.GradeSetUpInfo getGradeSetUp()
    {
        return (com.kingdee.eas.fdc.invite.supplier.GradeSetUpInfo)get("gradeSetUp");
    }
    public void setGradeSetUp(com.kingdee.eas.fdc.invite.supplier.GradeSetUpInfo item)
    {
        put("gradeSetUp", item);
    }
    /**
     * Object:��¼'s ����ϵ��property 
     */
    public java.math.BigDecimal getFix()
    {
        return getBigDecimal("fix");
    }
    public void setFix(java.math.BigDecimal item)
    {
        setBigDecimal("fix", item);
    }
    /**
     * Object:��¼'s ��עproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object: ��¼ 's ��Χ��Ӧ�� property 
     */
    public com.kingdee.eas.fdc.invite.InviteFixHeadInfo getHead()
    {
        return (com.kingdee.eas.fdc.invite.InviteFixHeadInfo)get("head");
    }
    public void setHead(com.kingdee.eas.fdc.invite.InviteFixHeadInfo item)
    {
        put("head", item);
    }
    /**
     * Object: ��¼ 's ��Ӧ�� property 
     */
    public com.kingdee.eas.fdc.invite.supplier.SupplierStockInfo getSupplier()
    {
        return (com.kingdee.eas.fdc.invite.supplier.SupplierStockInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.fdc.invite.supplier.SupplierStockInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object:��¼'s ����˵��property 
     */
    public com.kingdee.eas.fdc.invite.FixSupCommentEnum getSupComment()
    {
        return com.kingdee.eas.fdc.invite.FixSupCommentEnum.getEnum(getString("supComment"));
    }
    public void setSupComment(com.kingdee.eas.fdc.invite.FixSupCommentEnum item)
    {
		if (item != null) {
        setString("supComment", item.getValue());
		}
    }
    /**
     * Object:��¼'s ˵��property 
     */
    public String getDescription()
    {
        return getString("description");
    }
    public void setDescription(String item)
    {
        setString("description", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B8BA61A8");
    }
}