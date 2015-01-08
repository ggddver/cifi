package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierStockProjectFactory
{
    private DesignSupplierStockProjectFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockProject getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockProject)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A89AFBE7") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockProject.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockProject getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockProject)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A89AFBE7") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockProject.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockProject getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockProject)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A89AFBE7"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockProject getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockProject)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A89AFBE7"));
    }
}