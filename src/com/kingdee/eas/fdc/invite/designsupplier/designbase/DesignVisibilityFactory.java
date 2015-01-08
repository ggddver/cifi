package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignVisibilityFactory
{
    private DesignVisibilityFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignVisibility getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignVisibility)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A8B7EA6F") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignVisibility.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignVisibility getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignVisibility)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A8B7EA6F") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignVisibility.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignVisibility getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignVisibility)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A8B7EA6F"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignVisibility getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignVisibility)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A8B7EA6F"));
    }
}