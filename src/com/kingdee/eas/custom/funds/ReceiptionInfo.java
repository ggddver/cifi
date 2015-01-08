package com.kingdee.eas.custom.funds;

import java.io.Serializable;

public class ReceiptionInfo extends AbstractReceiptionInfo implements Serializable 
{
    public ReceiptionInfo()
    {
        super();
    }
    protected ReceiptionInfo(String pkField)
    {
        super(pkField);
    }
}