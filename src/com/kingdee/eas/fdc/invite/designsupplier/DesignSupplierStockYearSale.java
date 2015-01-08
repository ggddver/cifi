package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.lang.String;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.fdc.invite.designsupplier.app.*;

public class DesignSupplierStockYearSale extends CoreBillEntryBase implements IDesignSupplierStockYearSale
{
    public DesignSupplierStockYearSale()
    {
        super();
        registerInterface(IDesignSupplierStockYearSale.class, this);
    }
    public DesignSupplierStockYearSale(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignSupplierStockYearSale.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4A82BF16");
    }
    private DesignSupplierStockYearSaleController getController() throws BOSException
    {
        return (DesignSupplierStockYearSaleController)getBizController();
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@return
     */
    public DesignSupplierStockYearSaleInfo getDesignSupplierStockYearSaleInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockYearSaleInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@param selector selector
     *@return
     */
    public DesignSupplierStockYearSaleInfo getDesignSupplierStockYearSaleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockYearSaleInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getValue-System defined method
     *@param oql oql
     *@return
     */
    public DesignSupplierStockYearSaleInfo getDesignSupplierStockYearSaleInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockYearSaleInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@return
     */
    public DesignSupplierStockYearSaleCollection getDesignSupplierStockYearSaleCollection() throws BOSException
    {
        try {
            return getController().getDesignSupplierStockYearSaleCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@param view view
     *@return
     */
    public DesignSupplierStockYearSaleCollection getDesignSupplierStockYearSaleCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignSupplierStockYearSaleCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@param oql oql
     *@return
     */
    public DesignSupplierStockYearSaleCollection getDesignSupplierStockYearSaleCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignSupplierStockYearSaleCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}