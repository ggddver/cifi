package com.kingdee.eas.fdc.invite.designsupplier;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDesignSupplierStockSupplierPersonEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDesignSupplierStockSupplierPersonEntryInfo()
    {
        this("id");
    }
    protected AbstractDesignSupplierStockSupplierPersonEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:职员构成分录's 类别名称property 
     */
    public String getName()
    {
        return getName((Locale)null);
    }
    public void setName(String item)
    {
		setName(item,(Locale)null);
    }
    public String getName(Locale local)
    {
        return TypeConversionUtils.objToString(get("name", local));
    }
    public void setName(String item, Locale local)
    {
        put("name", item, local);
    }
    /**
     * Object: 职员构成分录 's 供应商 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo getHead()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo)get("head");
    }
    public void setHead(com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo item)
    {
        put("head", item);
    }
    /**
     * Object:职员构成分录's 联系方式property 
     */
    public String getLinkType()
    {
        return getString("linkType");
    }
    public void setLinkType(String item)
    {
        setString("linkType", item);
    }
    /**
     * Object:职员构成分录's 简历property 
     */
    public String getResume()
    {
        return getString("resume");
    }
    public void setResume(String item)
    {
        setString("resume", item);
    }
    /**
     * Object: 职员构成分录 's 职业资质 property 
     */
    public com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignLevelSetUpInfo getOccupationLevel()
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignLevelSetUpInfo)get("occupationLevel");
    }
    public void setOccupationLevel(com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignLevelSetUpInfo item)
    {
        put("occupationLevel", item);
    }
    /**
     * Object:职员构成分录's 代表项目property 
     */
    public String getProjectName()
    {
        return getString("projectName");
    }
    public void setProjectName(String item)
    {
        setString("projectName", item);
    }
    /**
     * Object:职员构成分录's 职位property 
     */
    public String getPosition()
    {
        return getString("position");
    }
    public void setPosition(String item)
    {
        setString("position", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0E3B0C7F");
    }
}