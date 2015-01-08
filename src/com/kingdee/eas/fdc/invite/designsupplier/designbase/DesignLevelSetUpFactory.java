package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignLevelSetUpFactory
{
    private DesignLevelSetUpFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignLevelSetUp getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignLevelSetUp)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("40A9C4D6") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignLevelSetUp.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignLevelSetUp getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignLevelSetUp)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("40A9C4D6") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignLevelSetUp.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignLevelSetUp getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignLevelSetUp)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("40A9C4D6"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignLevelSetUp getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignLevelSetUp)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("40A9C4D6"));
    }
}