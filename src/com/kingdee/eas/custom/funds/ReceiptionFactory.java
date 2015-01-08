package com.kingdee.eas.custom.funds;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ReceiptionFactory
{
    private ReceiptionFactory()
    {
    }
    public static com.kingdee.eas.custom.funds.IReceiption getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IReceiption)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E0D00475") ,com.kingdee.eas.custom.funds.IReceiption.class);
    }
    
    public static com.kingdee.eas.custom.funds.IReceiption getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IReceiption)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E0D00475") ,com.kingdee.eas.custom.funds.IReceiption.class, objectCtx);
    }
    public static com.kingdee.eas.custom.funds.IReceiption getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IReceiption)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E0D00475"));
    }
    public static com.kingdee.eas.custom.funds.IReceiption getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IReceiption)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E0D00475"));
    }
}