package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractQzInfo extends com.kingdee.eas.fdc.basedata.FDCDataBaseInfo implements Serializable 
{
    public AbstractQzInfo()
    {
        this("id");
    }
    protected AbstractQzInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:Ȩ������'s ����Ȩ�ر�(%)property 
     */
    public java.math.BigDecimal getJtqz()
    {
        return getBigDecimal("jtqz");
    }
    public void setJtqz(java.math.BigDecimal item)
    {
        setBigDecimal("jtqz", item);
    }
    /**
     * Object:Ȩ������'s �ֹ�˾Ȩ�ر�(%)property 
     */
    public java.math.BigDecimal getSybqz()
    {
        return getBigDecimal("sybqz");
    }
    public void setSybqz(java.math.BigDecimal item)
    {
        setBigDecimal("sybqz", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("06672768");
    }
}