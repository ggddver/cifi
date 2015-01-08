package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierSelectFactory
{
    private DesignSupplierSelectFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelect getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelect)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9DAB65AB") ,com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelect.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelect getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelect)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9DAB65AB") ,com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelect.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelect getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelect)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9DAB65AB"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelect getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.subill.IDesignSupplierSelect)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9DAB65AB"));
    }
}