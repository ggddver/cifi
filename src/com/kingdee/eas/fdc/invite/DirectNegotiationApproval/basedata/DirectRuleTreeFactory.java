package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DirectRuleTreeFactory
{
    private DirectRuleTreeFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRuleTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRuleTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("48887139") ,com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRuleTree.class);
    }
    
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRuleTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRuleTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("48887139") ,com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRuleTree.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRuleTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRuleTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("48887139"));
    }
    public static com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRuleTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.IDirectRuleTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("48887139"));
    }
}