package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesSupplierFileTypeInfo extends com.kingdee.eas.fdc.basedata.FDCDataBaseInfo implements Serializable 
{
    public AbstractDesSupplierFileTypeInfo()
    {
        this("id");
    }
    protected AbstractDesSupplierFileTypeInfo(String pkField)
    {
        super(pkField);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6202BD95");
    }
}