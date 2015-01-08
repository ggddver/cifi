package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesSupplierFileTypeFactory
{
    private DesSupplierFileTypeFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesSupplierFileType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesSupplierFileType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6202BD95") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesSupplierFileType.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesSupplierFileType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesSupplierFileType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6202BD95") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesSupplierFileType.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesSupplierFileType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesSupplierFileType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6202BD95"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesSupplierFileType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IDesSupplierFileType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6202BD95"));
    }
}