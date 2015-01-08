package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EstimatedAmtTreeFactory
{
    private EstimatedAmtTreeFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmtTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmtTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("12E21DA0") ,com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmtTree.class);
    }
    
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmtTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmtTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("12E21DA0") ,com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmtTree.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmtTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmtTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("12E21DA0"));
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmtTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IEstimatedAmtTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("12E21DA0"));
    }
}