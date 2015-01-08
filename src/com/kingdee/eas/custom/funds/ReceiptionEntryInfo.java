package com.kingdee.eas.custom.funds;

import java.io.Serializable;

public class ReceiptionEntryInfo extends AbstractReceiptionEntryInfo implements Serializable 
{
    public ReceiptionEntryInfo()
    {
        super();
    }
    protected ReceiptionEntryInfo(String pkField)
    {
        super(pkField);
    }
}