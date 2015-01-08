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
public class payUnitType extends StringEnum
{
    public static final String COMPANY_VALUE = "0";
    public static final String CUSTOMER_VALUE = "1";
    public static final String EMPLOYEE_VALUE = "2";
    public static final String SUPPLIER_VALUE = "4";
    public static final String OTHER_VALUE = "3";

    public static final payUnitType company = new payUnitType("company", COMPANY_VALUE);
    public static final payUnitType customer = new payUnitType("customer", CUSTOMER_VALUE);
    public static final payUnitType employee = new payUnitType("employee", EMPLOYEE_VALUE);
    public static final payUnitType supplier = new payUnitType("supplier", SUPPLIER_VALUE);
    public static final payUnitType other = new payUnitType("other", OTHER_VALUE);

    /**
     * construct function
     * @param String payUnitType
     */
    private payUnitType(String name, String payUnitType)
    {
        super(name, payUnitType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static payUnitType getEnum(String payUnitType)
    {
        return (payUnitType)getEnum(payUnitType.class, payUnitType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(payUnitType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(payUnitType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(payUnitType.class);
    }
}