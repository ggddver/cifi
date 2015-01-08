package com.kingdee.eas.fdc.invite.DirectNegotiationApproval;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDirectNegotiationApprovalEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDirectNegotiationApprovalEntryInfo()
    {
        this("id");
    }
    protected AbstractDirectNegotiationApprovalEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ֱ�����������¼ 's �б����� property 
     */
    public com.kingdee.eas.fdc.invite.DirectNegotiationApproval.DirectNegotiationApprovalInfo getParent()
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.DirectNegotiationApprovalInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.fdc.invite.DirectNegotiationApproval.DirectNegotiationApprovalInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:ֱ�����������¼'s �б�property 
     */
    public boolean isHit()
    {
        return getBoolean("hit");
    }
    public void setHit(boolean item)
    {
        setBoolean("hit", item);
    }
    /**
     * Object: ֱ�����������¼ 's ��Ӧ�� property 
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
     * Object:ֱ�����������¼'s �б��property 
     */
    public java.math.BigDecimal getBidAmount()
    {
        return getBigDecimal("bidAmount");
    }
    public void setBidAmount(java.math.BigDecimal item)
    {
        setBigDecimal("bidAmount", item);
    }
    /**
     * Object:ֱ�����������¼'s ѡ��õ�λ����property 
     */
    public String getChooseReason()
    {
        return getString("chooseReason");
    }
    public void setChooseReason(String item)
    {
        setString("chooseReason", item);
    }
    /**
     * Object:ֱ�����������¼'s ��һ�α���property 
     */
    public java.math.BigDecimal getFirstAmount()
    {
        return getBigDecimal("firstAmount");
    }
    public void setFirstAmount(java.math.BigDecimal item)
    {
        setBigDecimal("firstAmount", item);
    }
    /**
     * Object:ֱ�����������¼'s �ڶ��α���property 
     */
    public java.math.BigDecimal getSecondAmount()
    {
        return getBigDecimal("secondAmount");
    }
    public void setSecondAmount(java.math.BigDecimal item)
    {
        setBigDecimal("secondAmount", item);
    }
    /**
     * Object:ֱ�����������¼'s ����ɲɹ��ĵ������property 
     */
    public java.math.BigDecimal getPurchaseDoneAmountEx()
    {
        return getBigDecimal("purchaseDoneAmountEx");
    }
    public void setPurchaseDoneAmountEx(java.math.BigDecimal item)
    {
        setBigDecimal("purchaseDoneAmountEx", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4AE3BC4E");
    }
}