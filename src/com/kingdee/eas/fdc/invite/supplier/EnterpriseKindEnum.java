/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.supplier;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class EnterpriseKindEnum extends StringEnum
{
    public static final String QT_VALUE = "6";
    public static final String HZQY_VALUE = "5";
    public static final String WZQY_VALUE = "4";
    public static final String GFYXGS_VALUE = "3";
    public static final String MYQY_VALUE = "2";
    public static final String GYQY_VALUE = "1";

    public static final EnterpriseKindEnum QT = new EnterpriseKindEnum("QT", QT_VALUE);
    public static final EnterpriseKindEnum HZQY = new EnterpriseKindEnum("HZQY", HZQY_VALUE);
    public static final EnterpriseKindEnum WZQY = new EnterpriseKindEnum("WZQY", WZQY_VALUE);
    public static final EnterpriseKindEnum GFYXGS = new EnterpriseKindEnum("GFYXGS", GFYXGS_VALUE);
    public static final EnterpriseKindEnum MYQY = new EnterpriseKindEnum("MYQY", MYQY_VALUE);
    public static final EnterpriseKindEnum GYQY = new EnterpriseKindEnum("GYQY", GYQY_VALUE);

    /**
     * construct function
     * @param String enterpriseKindEnum
     */
    private EnterpriseKindEnum(String name, String enterpriseKindEnum)
    {
        super(name, enterpriseKindEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static EnterpriseKindEnum getEnum(String enterpriseKindEnum)
    {
        return (EnterpriseKindEnum)getEnum(EnterpriseKindEnum.class, enterpriseKindEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(EnterpriseKindEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(EnterpriseKindEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(EnterpriseKindEnum.class);
    }
}