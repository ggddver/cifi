package com.kingdee.eas.custom.funds;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FundsApplicationBillFactory
{
    private FundsApplicationBillFactory()
    {
    }
    public static com.kingdee.eas.custom.funds.IFundsApplicationBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplicationBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5A2A70AE") ,com.kingdee.eas.custom.funds.IFundsApplicationBill.class);
    }
    
    public static com.kingdee.eas.custom.funds.IFundsApplicationBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplicationBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5A2A70AE") ,com.kingdee.eas.custom.funds.IFundsApplicationBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.funds.IFundsApplicationBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplicationBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5A2A70AE"));
    }
    public static com.kingdee.eas.custom.funds.IFundsApplicationBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IFundsApplicationBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5A2A70AE"));
    }
}