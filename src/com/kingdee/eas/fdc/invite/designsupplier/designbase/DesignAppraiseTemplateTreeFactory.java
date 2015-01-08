package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignAppraiseTemplateTreeFactory
{
    private DesignAppraiseTemplateTreeFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B6A48460") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateTree.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B6A48460") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateTree.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B6A48460"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignAppraiseTemplateTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B6A48460"));
    }
}