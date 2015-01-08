package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierStockAptitudeFileFactory
{
    private DesignSupplierStockAptitudeFileFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAptitudeFile getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAptitudeFile)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CEF6FE34") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAptitudeFile.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAptitudeFile getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAptitudeFile)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CEF6FE34") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAptitudeFile.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAptitudeFile getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAptitudeFile)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CEF6FE34"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAptitudeFile getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAptitudeFile)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CEF6FE34"));
    }
}