package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignStorageNumberFactory
{
    private DesignStorageNumberFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignStorageNumber getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignStorageNumber)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("745AABCC") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignStorageNumber.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignStorageNumber getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignStorageNumber)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("745AABCC") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignStorageNumber.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignStorageNumber getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignStorageNumber)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("745AABCC"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignStorageNumber getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignStorageNumber)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("745AABCC"));
    }
}