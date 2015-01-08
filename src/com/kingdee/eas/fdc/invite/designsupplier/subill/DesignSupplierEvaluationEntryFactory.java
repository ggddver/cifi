package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierEvaluationEntryFactory
{
    private DesignSupplierEvaluationEntryFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluationEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluationEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("95E15AC7") ,com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluationEntry.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluationEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluationEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("95E15AC7") ,com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluationEntry.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluationEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluationEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("95E15AC7"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluationEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluationEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("95E15AC7"));
    }
}