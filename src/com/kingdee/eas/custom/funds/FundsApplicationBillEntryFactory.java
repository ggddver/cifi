package com.kingdee.eas.custom.funds;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FundsApplicationBillEntryFactory
{
    private FundsApplicationBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.funds.IFundsApplicationBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplicationBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BBC6E464") ,com.kingdee.eas.custom.funds.IFundsApplicationBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.funds.IFundsApplicationBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplicationBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BBC6E464") ,com.kingdee.eas.custom.funds.IFundsApplicationBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.funds.IFundsApplicationBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplicationBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BBC6E464"));
    }
    public static com.kingdee.eas.custom.funds.IFundsApplicationBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplicationBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BBC6E464"));
    }
}