package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignServiceAreaFactory
{
    private DesignServiceAreaFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceArea getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceArea)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F8360D25") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceArea.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceArea getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceArea)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F8360D25") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceArea.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceArea getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceArea)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F8360D25"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceArea getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignServiceArea)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F8360D25"));
    }
}