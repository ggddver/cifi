package com.kingdee.eas.custom.funds;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractReceiptionEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractReceiptionEntryInfo()
    {
        this("id");
    }
    protected AbstractReceiptionEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.funds.ReceiptionInfo getParent()
    {
        return (com.kingdee.eas.custom.funds.ReceiptionInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.funds.ReceiptionInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 收款类别 property 
     */
    public com.kingdee.eas.fi.cas.ReceivingBillTypeInfo getRecType()
    {
        return (com.kingdee.eas.fi.cas.ReceivingBillTypeInfo)get("recType");
    }
    public void setRecType(com.kingdee.eas.fi.cas.ReceivingBillTypeInfo item)
    {
        put("recType", item);
    }
    /**
     * Object:分录's 收款金额property 
     */
    public java.math.BigDecimal getRecAmount()
    {
        return getBigDecimal("recAmount");
    }
    public void setRecAmount(java.math.BigDecimal item)
    {
        setBigDecimal("recAmount", item);
    }
    /**
     * Object: 分录 's 收款方式 property 
     */
    public com.kingdee.eas.basedata.assistant.SettlementTypeInfo getSettlementType()
    {
        return (com.kingdee.eas.basedata.assistant.SettlementTypeInfo)get("settlementType");
    }
    public void setSettlementType(com.kingdee.eas.basedata.assistant.SettlementTypeInfo item)
    {
        put("settlementType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C03994FD");
    }
}