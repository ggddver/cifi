package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierStockSupplierAttachListEntryFactory
{
    private DesignSupplierStockSupplierAttachListEntryFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierAttachListEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierAttachListEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("91614B11") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierAttachListEntry.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierAttachListEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierAttachListEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("91614B11") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierAttachListEntry.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierAttachListEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierAttachListEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("91614B11"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierAttachListEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierAttachListEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("91614B11"));
    }
}