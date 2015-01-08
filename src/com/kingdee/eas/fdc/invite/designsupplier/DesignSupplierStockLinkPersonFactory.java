package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierStockLinkPersonFactory
{
    private DesignSupplierStockLinkPersonFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockLinkPerson getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockLinkPerson)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6D66C861") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockLinkPerson.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockLinkPerson getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockLinkPerson)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6D66C861") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockLinkPerson.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockLinkPerson getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockLinkPerson)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6D66C861"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockLinkPerson getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockLinkPerson)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6D66C861"));
    }
}