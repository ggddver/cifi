package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignAuditIndexTreeFactory
{
    private DesignAuditIndexTreeFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndexTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndexTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E2B992D2") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndexTree.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndexTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndexTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E2B992D2") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndexTree.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndexTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndexTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E2B992D2"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndexTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndexTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E2B992D2"));
    }
}