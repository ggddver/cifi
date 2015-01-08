package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AwardFactory
{
    private AwardFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IAward getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IAward)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1D4164BE") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IAward.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IAward getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IAward)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1D4164BE") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IAward.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IAward getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IAward)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1D4164BE"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IAward getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IAward)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1D4164BE"));
    }
}