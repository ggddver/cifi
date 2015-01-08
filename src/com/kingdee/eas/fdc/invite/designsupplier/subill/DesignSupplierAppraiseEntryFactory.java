package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierAppraiseEntryFactory
{
    private DesignSupplierAppraiseEntryFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("155B8538") ,com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseEntry.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("155B8538") ,com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseEntry.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("155B8538"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("155B8538"));
    }
}