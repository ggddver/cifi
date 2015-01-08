package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierSelectEntryFactory
{
    private DesignSupplierSelectEntryFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelectEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelectEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B6788587") ,com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelectEntry.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelectEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelectEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B6788587") ,com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelectEntry.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelectEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelectEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B6788587"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelectEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelectEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B6788587"));
    }
}