package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierAppraiseE2Factory
{
    private DesignSupplierAppraiseE2Factory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseE2 getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseE2)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E6083567") ,com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseE2.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseE2 getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseE2)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E6083567") ,com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseE2.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseE2 getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseE2)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E6083567"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseE2 getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierAppraiseE2)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E6083567"));
    }
}