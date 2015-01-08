package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignAppraiseTemplateFactory
{
    private DesignAppraiseTemplateFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplate getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplate)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0DF83DA2") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplate.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplate getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplate)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0DF83DA2") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplate.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplate getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplate)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0DF83DA2"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplate getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplate)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0DF83DA2"));
    }
}