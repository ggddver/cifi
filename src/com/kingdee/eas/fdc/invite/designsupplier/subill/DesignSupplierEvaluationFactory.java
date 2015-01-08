package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierEvaluationFactory
{
    private DesignSupplierEvaluationFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluation getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluation)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FEE2486B") ,com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluation.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluation getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluation)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FEE2486B") ,com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluation.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluation getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluation)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FEE2486B"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluation getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierEvaluation)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FEE2486B"));
    }
}