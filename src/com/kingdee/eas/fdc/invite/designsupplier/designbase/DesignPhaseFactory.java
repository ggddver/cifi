package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignPhaseFactory
{
    private DesignPhaseFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPhase getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPhase)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("50EF9BFE") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPhase.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPhase getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPhase)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("50EF9BFE") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPhase.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPhase getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPhase)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("50EF9BFE"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPhase getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPhase)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("50EF9BFE"));
    }
}