package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierStockAchievementFactory
{
    private DesignSupplierStockAchievementFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAchievement getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAchievement)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("49B428FD") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAchievement.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAchievement getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAchievement)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("49B428FD") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAchievement.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAchievement getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAchievement)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("49B428FD"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAchievement getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockAchievement)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("49B428FD"));
    }
}