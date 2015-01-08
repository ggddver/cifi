package com.kingdee.eas.fdc.invite.DirectNegotiationApproval;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DirectNegotiationApprovalFactory
{
    private DirectNegotiationApprovalFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApproval getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApproval)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DC2CCE84") ,com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApproval.class);
    }
    
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApproval getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApproval)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DC2CCE84") ,com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApproval.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApproval getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApproval)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DC2CCE84"));
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApproval getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApproval)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DC2CCE84"));
    }
}