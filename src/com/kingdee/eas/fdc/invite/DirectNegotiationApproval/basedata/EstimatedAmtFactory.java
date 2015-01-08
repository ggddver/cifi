package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EstimatedAmtFactory
{
    private EstimatedAmtFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmt getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmt)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("617476E2") ,com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmt.class);
    }
    
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmt getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmt)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("617476E2") ,com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmt.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmt getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmt)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("617476E2"));
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmt getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmt)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("617476E2"));
    }
}