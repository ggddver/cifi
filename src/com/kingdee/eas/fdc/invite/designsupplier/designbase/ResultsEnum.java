/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class ResultsEnum extends StringEnum
{
    public static final String YL_VALUE = "10";
    public static final String HG_VALUE = "20";
    public static final String BHG_VALUE = "30";

    public static final ResultsEnum yl = new ResultsEnum("yl", YL_VALUE);
    public static final ResultsEnum hg = new ResultsEnum("hg", HG_VALUE);
    public static final ResultsEnum bhg = new ResultsEnum("bhg", BHG_VALUE);

    /**
     * construct function
     * @param String resultsEnum
     */
    private ResultsEnum(String name, String resultsEnum)
    {
        super(name, resultsEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ResultsEnum getEnum(String resultsEnum)
    {
        return (ResultsEnum)getEnum(ResultsEnum.class, resultsEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ResultsEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ResultsEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ResultsEnum.class);
    }
}