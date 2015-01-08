package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProductTypeFactory
{
    private ProductTypeFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IProductType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IProductType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2EAF9E6A") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IProductType.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IProductType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IProductType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2EAF9E6A") ,com.kingdee.eas.fdc.invite.designsupplier.designbase.IProductType.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IProductType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IProductType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2EAF9E6A"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.designbase.IProductType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.designbase.IProductType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2EAF9E6A"));
    }
}