package com.kingdee.eas.custom.funds;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FundsApplicationEntryFactory
{
    private FundsApplicationEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.funds.IFundsApplicationEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplicationEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EB5050AB") ,com.kingdee.eas.custom.funds.IFundsApplicationEntry.class);
    }
    
    public static com.kingdee.eas.custom.funds.IFundsApplicationEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplicationEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EB5050AB") ,com.kingdee.eas.custom.funds.IFundsApplicationEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.funds.IFundsApplicationEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplicationEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EB5050AB"));
    }
    public static com.kingdee.eas.custom.funds.IFundsApplicationEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplicationEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EB5050AB"));
    }
}