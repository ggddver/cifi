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

public class DesignSupplierStockLinkPerson extends CoreBillEntryBase implements IDesignSupplierStockLinkPerson
{
    public DesignSupplierStockLinkPerson()
    {
        super();
        registerInterface(IDesignSupplierStockLinkPerson.class, this);
    }
    public DesignSupplierStockLinkPerson(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignSupplierStockLinkPerson.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6D66C861");
    }
    private DesignSupplierStockLinkPersonController getController() throws BOSException
    {
        return (DesignSupplierStockLinkPersonController)getBizController();
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@return
     */
    public DesignSupplierStockLinkPersonInfo getDesignSupplierStockLinkPersonInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockLinkPersonInfo(getContext(), pk);
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
    public DesignSupplierStockLinkPersonInfo getDesignSupplierStockLinkPersonInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockLinkPersonInfo(getContext(), pk, selector);
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
    public DesignSupplierStockLinkPersonInfo getDesignSupplierStockLinkPersonInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockLinkPersonInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@return
     */
    public DesignSupplierStockLinkPersonCollection getDesignSupplierStockLinkPersonCollection() throws BOSException
    {
        try {
            return getController().getDesignSupplierStockLinkPersonCollection(getContext());
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
    public DesignSupplierStockLinkPersonCollection getDesignSupplierStockLinkPersonCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignSupplierStockLinkPersonCollection(getContext(), view);
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
    public DesignSupplierStockLinkPersonCollection getDesignSupplierStockLinkPersonCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignSupplierStockLinkPersonCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}