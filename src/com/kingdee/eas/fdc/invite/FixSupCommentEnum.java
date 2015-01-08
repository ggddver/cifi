/**
 * output package name
 */
package com.kingdee.eas.fdc.invite;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class FixSupCommentEnum extends StringEnum
{
    public static final String YES_VALUE = "1";
    public static final String NO_VALUE = "2";

    public static final FixSupCommentEnum YES = new FixSupCommentEnum("YES", YES_VALUE);
    public static final FixSupCommentEnum NO = new FixSupCommentEnum("NO", NO_VALUE);

    /**
     * construct function
     * @param String fixSupCommentEnum
     */
    private FixSupCommentEnum(String name, String fixSupCommentEnum)
    {
        super(name, fixSupCommentEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FixSupCommentEnum getEnum(String fixSupCommentEnum)
    {
        return (FixSupCommentEnum)getEnum(FixSupCommentEnum.class, fixSupCommentEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FixSupCommentEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FixSupCommentEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FixSupCommentEnum.class);
    }
}