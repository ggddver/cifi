package com.kingdee.eas.custom.funds;

import java.io.Serializable;

public class FundsApplicationInfo extends AbstractFundsApplicationInfo implements Serializable 
{
    public FundsApplicationInfo()
    {
        super();
    }
    protected FundsApplicationInfo(String pkField)
    {
        super(pkField);
    }
}