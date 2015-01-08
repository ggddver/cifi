package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import java.io.Serializable;

public class DesignAuditIndexInfo extends AbstractDesignAuditIndexInfo implements Serializable 
{
    public DesignAuditIndexInfo()
    {
        super();
    }
    protected DesignAuditIndexInfo(String pkField)
    {
        super(pkField);
    }
}