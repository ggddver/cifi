package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSelectSupplierDBFactory
{
    private DesignSelectSupplierDBFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSelectSupplierDB getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSelectSupplierDB)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EE370A3E") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSelectSupplierDB.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSelectSupplierDB getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSelectSupplierDB)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EE370A3E") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSelectSupplierDB.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSelectSupplierDB getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSelectSupplierDB)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EE370A3E"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSelectSupplierDB getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSelectSupplierDB)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EE370A3E"));
    }
}