package com.kingdee.eas.fdc.invite.DirectNegotiationApproval;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DirectNegotiationApprovalEntryFactory
{
    private DirectNegotiationApprovalEntryFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApprovalEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApprovalEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4AE3BC4E") ,com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApprovalEntry.class);
    }
    
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApprovalEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApprovalEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4AE3BC4E") ,com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApprovalEntry.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApprovalEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApprovalEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4AE3BC4E"));
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApprovalEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.IDirectNegotiationApprovalEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4AE3BC4E"));
    }
}