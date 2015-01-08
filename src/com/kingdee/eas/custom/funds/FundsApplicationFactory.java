package com.kingdee.eas.custom.funds;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FundsApplicationFactory
{
    private FundsApplicationFactory()
    {
    }
    public static com.kingdee.eas.custom.funds.IFundsApplication getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplication)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3DE23407") ,com.kingdee.eas.custom.funds.IFundsApplication.class);
    }
    
    public static com.kingdee.eas.custom.funds.IFundsApplication getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplication)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3DE23407") ,com.kingdee.eas.custom.funds.IFundsApplication.class, objectCtx);
    }
    public static com.kingdee.eas.custom.funds.IFundsApplication getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplication)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3DE23407"));
    }
    public static com.kingdee.eas.custom.funds.IFundsApplication getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplication)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3DE23407"));
    }
}