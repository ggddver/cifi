package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignGradeSetUpFactory
{
    private DesignGradeSetUpFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignGradeSetUp getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignGradeSetUp)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3C635C63") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignGradeSetUp.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignGradeSetUp getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignGradeSetUp)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3C635C63") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignGradeSetUp.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignGradeSetUp getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignGradeSetUp)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3C635C63"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignGradeSetUp getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignGradeSetUp)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3C635C63"));
    }
}