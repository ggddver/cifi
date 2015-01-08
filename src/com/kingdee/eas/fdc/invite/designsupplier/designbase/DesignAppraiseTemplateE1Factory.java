package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignAppraiseTemplateE1Factory
{
    private DesignAppraiseTemplateE1Factory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateE1 getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateE1)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("70DF65AE") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateE1.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateE1 getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateE1)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("70DF65AE") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateE1.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateE1 getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateE1)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("70DF65AE"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateE1 getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateE1)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("70DF65AE"));
    }
}