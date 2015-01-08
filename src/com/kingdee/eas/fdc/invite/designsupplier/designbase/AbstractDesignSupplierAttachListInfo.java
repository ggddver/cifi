package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignSupplierAttachListInfo extends com.kingdee.eas.fdc.basedata.FDCDataBaseInfo implements Serializable 
{
    public AbstractDesignSupplierAttachListInfo()
    {
        this("id");
    }
    protected AbstractDesignSupplierAttachListInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 档案附件清单 's 档案分类 property 
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
        return new BOSObjectType("385849CC");
    }
}