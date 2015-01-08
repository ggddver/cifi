/**
 * output package name
 */
package com.kingdee.eas.custom.funds;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class BizState extends StringEnum
{
    public static final String ADDNEW_VALUE = "0";
    public static final String SAVED_VALUE = "1";
    public static final String SUBMITED_VALUE = "2";
    public static final String AUDITING_VALUE = "3";
    public static final String AUDITED_VALUE = "4";
    public static final String CLOSE_VALUE = "5";

    public static final BizState addnew = new BizState("addnew", ADDNEW_VALUE);
    public static final BizState saved = new BizState("saved", SAVED_VALUE);
    public static final BizState submited = new BizState("submited", SUBMITED_VALUE);
    public static final BizState auditing = new BizState("auditing", AUDITING_VALUE);
    public static final BizState audited = new BizState("audited", AUDITED_VALUE);
    public static final BizState close = new BizState("close", CLOSE_VALUE);

    /**
     * construct function
     * @param String bizState
     */
    private BizState(String name, String bizState)
    {
        super(name, bizState);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BizState getEnum(String bizState)
    {
        return (BizState)getEnum(BizState.class, bizState);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BizState.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BizState.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BizState.class);
    }
}