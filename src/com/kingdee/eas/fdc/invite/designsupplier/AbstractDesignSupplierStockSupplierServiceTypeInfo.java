package com.kingdee.eas.fdc.invite.designsupplier;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignSupplierStockSupplierServiceTypeInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDesignSupplierStockSupplierServiceTypeInfo()
    {
        this("id");
    }
    protected AbstractDesignSupplierStockSupplierServiceTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��Ӧ�̷�������'s ״̬property 
     */
    public String getState()
    {
        return getString("state");
    }
    public void setState(String item)
    {
        setString("state", item);
    }
    /**
     * Object: ��Ӧ�̷������� 's ��Ӧ�� property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo getSupplier()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object: ��Ӧ�̷������� 's �������� property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceTypeInfo getServiceType()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceTypeInfo)get("serviceType");
    }
    public void setServiceType(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceTypeInfo item)
    {
        put("serviceType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B61929F1");
    }
}