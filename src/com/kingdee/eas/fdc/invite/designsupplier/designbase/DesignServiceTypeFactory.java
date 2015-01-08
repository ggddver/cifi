package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignServiceTypeFactory
{
    private DesignServiceTypeFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F83ECBD2") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceType.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F83ECBD2") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceType.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F83ECBD2"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F83ECBD2"));
    }
}