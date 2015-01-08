package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QzFactory
{
    private QzFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IQz getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IQz)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("06672768") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IQz.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IQz getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IQz)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("06672768") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IQz.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IQz getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IQz)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("06672768"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IQz getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IQz)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("06672768"));
    }
}