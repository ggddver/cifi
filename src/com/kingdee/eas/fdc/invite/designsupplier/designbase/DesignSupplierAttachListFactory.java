package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierAttachListFactory
{
    private DesignSupplierAttachListFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignSupplierAttachList getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignSupplierAttachList)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("385849CC") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignSupplierAttachList.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignSupplierAttachList getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignSupplierAttachList)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("385849CC") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignSupplierAttachList.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignSupplierAttachList getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignSupplierAttachList)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("385849CC"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignSupplierAttachList getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesignSupplierAttachList)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("385849CC"));
    }
}