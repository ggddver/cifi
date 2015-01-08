package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierStockSupplierPersonEntryFactory
{
    private DesignSupplierStockSupplierPersonEntryFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierPersonEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierPersonEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0E3B0C7F") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierPersonEntry.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierPersonEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierPersonEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0E3B0C7F") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierPersonEntry.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierPersonEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierPersonEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0E3B0C7F"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierPersonEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierPersonEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0E3B0C7F"));
    }
}