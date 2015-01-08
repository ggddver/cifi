package com.kingdee.eas.custom.funds;

import java.io.Serializable;

public class FundsApplicationBillEntryInfo extends AbstractFundsApplicationBillEntryInfo implements Serializable 
{
    public FundsApplicationBillEntryInfo()
    {
        super();
    }
    protected FundsApplicationBillEntryInfo(String pkField)
    {
        super(pkField);
    }
}