package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignGradeSetUpInfo extends com.kingdee.eas.fdc.basedata.FDCDataBaseInfo implements Serializable 
{
    public AbstractDesignGradeSetUpInfo()
    {
        this("id");
    }
    protected AbstractDesignGradeSetUpInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:等级设置's 是否合格property 
     */
    public com.kingdee.eas.fdc.invite.supplier.IsGradeEnum getISheg()
    {
        return com.kingdee.eas.fdc.invite.supplier.IsGradeEnum.getEnum(getInt("ISheg"));
    }
    public void setISheg(com.kingdee.eas.fdc.invite.supplier.IsGradeEnum item)
    {
		if (item != null) {
        setInt("ISheg", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3C635C63");
    }
}