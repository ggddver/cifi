package com.kingdee.eas.custom.funds;

import java.io.Serializable;

public class FundsApplicationEntryInfo extends AbstractFundsApplicationEntryInfo implements Serializable 
{
    public FundsApplicationEntryInfo()
    {
        super();
    }
    protected FundsApplicationEntryInfo(String pkField)
    {
        super(pkField);
    }
}