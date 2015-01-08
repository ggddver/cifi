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

public class DesignSupplierStockSupplierServiceType extends CoreBillEntryBase implements IDesignSupplierStockSupplierServiceType
{
    public DesignSupplierStockSupplierServiceType()
    {
        super();
        registerInterface(IDesignSupplierStockSupplierServiceType.class, this);
    }
    public DesignSupplierStockSupplierServiceType(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignSupplierStockSupplierServiceType.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B61929F1");
    }
    private DesignSupplierStockSupplierServiceTypeController getController() throws BOSException
    {
        return (DesignSupplierStockSupplierServiceTypeController)getBizController();
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@return
     */
    public DesignSupplierStockSupplierServiceTypeInfo getDesignSupplierStockSupplierServiceTypeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockSupplierServiceTypeInfo(getContext(), pk);
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
    public DesignSupplierStockSupplierServiceTypeInfo getDesignSupplierStockSupplierServiceTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockSupplierServiceTypeInfo(getContext(), pk, selector);
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
    public DesignSupplierStockSupplierServiceTypeInfo getDesignSupplierStockSupplierServiceTypeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockSupplierServiceTypeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@return
     */
    public DesignSupplierStockSupplierServiceTypeCollection getDesignSupplierStockSupplierServiceTypeCollection() throws BOSException
    {
        try {
            return getController().getDesignSupplierStockSupplierServiceTypeCollection(getContext());
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
    public DesignSupplierStockSupplierServiceTypeCollection getDesignSupplierStockSupplierServiceTypeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignSupplierStockSupplierServiceTypeCollection(getContext(), view);
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
    public DesignSupplierStockSupplierServiceTypeCollection getDesignSupplierStockSupplierServiceTypeCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignSupplierStockSupplierServiceTypeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}