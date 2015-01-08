package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignPersonInfo extends com.kingdee.eas.fdc.basedata.FDCDataBaseInfo implements Serializable 
{
    public AbstractDesignPersonInfo()
    {
        this("id");
    }
    protected AbstractDesignPersonInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 职员构成 's 档案分类 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesSupplierFileTypeInfo getSupplierFileType()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesSupplierFileTypeInfo)get("supplierFileType");
    }
    public void setSupplierFileType(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesSupplierFileTypeInfo item)
    {
        put("supplierFileType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CCE15932");
    }
}