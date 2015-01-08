package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignAuditIndexFactory
{
    private DesignAuditIndexFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndex getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndex)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("98AA5514") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndex.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndex getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndex)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("98AA5514") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndex.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndex getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndex)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("98AA5514"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndex getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAuditIndex)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("98AA5514"));
    }
}