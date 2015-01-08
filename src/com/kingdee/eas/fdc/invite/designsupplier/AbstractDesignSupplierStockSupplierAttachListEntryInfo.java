package com.kingdee.eas.fdc.invite.designsupplier;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignSupplierStockSupplierAttachListEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDesignSupplierStockSupplierAttachListEntryInfo()
    {
        this("id");
    }
    protected AbstractDesignSupplierStockSupplierAttachListEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:���������嵥��¼'s ������property 
     */
    public String getNumber()
    {
        return getString("number");
    }
    public void setNumber(String item)
    {
        setString("number", item);
    }
    /**
     * Object:���������嵥��¼'s �������property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    /**
     * Object: ���������嵥��¼ 's ��Ӧ�� property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo getHead()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo)get("head");
    }
    public void setHead(com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo item)
    {
        put("head", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("91614B11");
    }
}