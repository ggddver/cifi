package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignQuaLevelFactory
{
    private DesignQuaLevelFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignQuaLevel getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignQuaLevel)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B1085D64") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignQuaLevel.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignQuaLevel getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignQuaLevel)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B1085D64") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignQuaLevel.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignQuaLevel getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignQuaLevel)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B1085D64"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignQuaLevel getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignQuaLevel)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B1085D64"));
    }
}