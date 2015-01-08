package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierStockSupplierSplAreaEntryFactory
{
    private DesignSupplierStockSupplierSplAreaEntryFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierSplAreaEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierSplAreaEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("100778D4") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierSplAreaEntry.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierSplAreaEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierSplAreaEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("100778D4") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierSplAreaEntry.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierSplAreaEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierSplAreaEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("100778D4"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierSplAreaEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierSplAreaEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("100778D4"));
    }
}