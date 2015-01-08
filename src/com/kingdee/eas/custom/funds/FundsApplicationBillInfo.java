package com.kingdee.eas.custom.funds;

import java.io.Serializable;

public class FundsApplicationBillInfo extends AbstractFundsApplicationBillInfo implements Serializable 
{
    public FundsApplicationBillInfo()
    {
        super();
    }
    protected FundsApplicationBillInfo(String pkField)
    {
        super(pkField);
    }
}