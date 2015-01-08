package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignBusinessModeFactory
{
    private DesignBusinessModeFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignBusinessMode getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignBusinessMode)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D2A0B1A0") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignBusinessMode.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignBusinessMode getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignBusinessMode)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D2A0B1A0") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignBusinessMode.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignBusinessMode getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignBusinessMode)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D2A0B1A0"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignBusinessMode getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignBusinessMode)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D2A0B1A0"));
    }
}