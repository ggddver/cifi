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
     * Object: ��¼ 's ����ͷ property 
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
     * Object: ��¼ 's �տ���� property 
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
     * Object:��¼'s �տ���property 
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
     * Object: ��¼ 's �տʽ property 
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