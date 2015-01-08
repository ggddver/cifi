package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DirectRuleFactory
{
    private DirectRuleFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRule getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRule)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("79FE7EFB") ,com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRule.class);
    }
    
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRule getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRule)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("79FE7EFB") ,com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRule.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRule getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRule)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("79FE7EFB"));
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRule getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRule)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("79FE7EFB"));
    }
}