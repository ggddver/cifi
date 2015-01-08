package com.kingdee.eas.fdc.invite.designsupplier.demotion;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DemotionEntryFactory
{
    private DemotionEntryFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotionEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotionEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2A0E27C4") ,com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotionEntry.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotionEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotionEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2A0E27C4") ,com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotionEntry.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotionEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotionEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2A0E27C4"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotionEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.demotion.IDemotionEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2A0E27C4"));
    }
}