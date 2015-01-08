package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DesignSupplierStockYearSaleFactory
{
    private DesignSupplierStockYearSaleFactory()
    {
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockYearSale getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockYearSale)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4A82BF16") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockYearSale.class);
    }
    
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockYearSale getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockYearSale)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4A82BF16") ,com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockYearSale.class, objectCtx);
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockYearSale getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockYearSale)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4A82BF16"));
    }
    public static com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockYearSale getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.fdc.invite.designsupplier.IDesignSupplierStockYearSale)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4A82BF16"));
    }
}