package com.kingdee.eas.custom.funds;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ReceiptionEntryFactory
{
    private ReceiptionEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.funds.IReceiptionEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IReceiptionEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C03994FD") ,com.kingdee.eas.custom.funds.IReceiptionEntry.class);
    }
    
    public static com.kingdee.eas.custom.funds.IReceiptionEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IReceiptionEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C03994FD") ,com.kingdee.eas.custom.funds.IReceiptionEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.funds.IReceiptionEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IReceiptionEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C03994FD"));
    }
    public static com.kingdee.eas.custom.funds.IReceiptionEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.funds.IReceiptionEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C03994FD"));
    }
}