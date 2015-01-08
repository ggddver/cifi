package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierAppraiseFactory
{
    private DesignSupplierAppraiseFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraise getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraise)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E0019B5A") ,com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraise.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraise getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraise)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E0019B5A") ,com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraise.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraise getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraise)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E0019B5A"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraise getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraise)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E0019B5A"));
    }
}