package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignAccreditationTypeFactory
{
    private DesignAccreditationTypeFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAccreditationType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAccreditationType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("87E92A97") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAccreditationType.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAccreditationType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAccreditationType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("87E92A97") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAccreditationType.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAccreditationType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAccreditationType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("87E92A97"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAccreditationType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAccreditationType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("87E92A97"));
    }
}