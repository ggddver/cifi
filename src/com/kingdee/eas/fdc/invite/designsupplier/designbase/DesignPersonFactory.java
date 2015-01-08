package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignPersonFactory
{
    private DesignPersonFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPerson getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPerson)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CCE15932") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPerson.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPerson getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPerson)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CCE15932") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPerson.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPerson getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPerson)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CCE15932"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPerson getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignPerson)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CCE15932"));
    }
}