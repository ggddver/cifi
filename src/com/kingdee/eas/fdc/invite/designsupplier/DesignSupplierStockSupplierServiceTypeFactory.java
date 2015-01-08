package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierStockSupplierServiceTypeFactory
{
    private DesignSupplierStockSupplierServiceTypeFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierServiceType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierServiceType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B61929F1") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierServiceType.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierServiceType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierServiceType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B61929F1") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierServiceType.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierServiceType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierServiceType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B61929F1"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierServiceType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockSupplierServiceType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B61929F1"));
    }
}