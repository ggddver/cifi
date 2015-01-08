package com.kingdee.eas.fdc.invite.designsupplier.demotion;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DemotionFactory
{
    private DemotionFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotion getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotion)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EC7E914E") ,com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotion.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotion getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotion)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EC7E914E") ,com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotion.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotion getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotion)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EC7E914E"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotion getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotion)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EC7E914E"));
    }
}