package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierStockFactory
{
    private DesignSupplierStockFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStock getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStock)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("92A3F6D2") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStock.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStock getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStock)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("92A3F6D2") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStock.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStock getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStock)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("92A3F6D2"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStock getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStock)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("92A3F6D2"));
    }
}