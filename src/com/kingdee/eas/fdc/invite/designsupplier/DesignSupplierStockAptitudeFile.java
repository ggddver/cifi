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

public class DesignSupplierStockAptitudeFile extends CoreBillEntryBase implements IDesignSupplierStockAptitudeFile
{
    public DesignSupplierStockAptitudeFile()
    {
        super();
        registerInterface(IDesignSupplierStockAptitudeFile.class, this);
    }
    public DesignSupplierStockAptitudeFile(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignSupplierStockAptitudeFile.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CEF6FE34");
    }
    private DesignSupplierStockAptitudeFileController getController() throws BOSException
    {
        return (DesignSupplierStockAptitudeFileController)getBizController();
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@return
     */
    public DesignSupplierStockAptitudeFileInfo getDesignSupplierStockAptitudeFileInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockAptitudeFileInfo(getContext(), pk);
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
    public DesignSupplierStockAptitudeFileInfo getDesignSupplierStockAptitudeFileInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockAptitudeFileInfo(getContext(), pk, selector);
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
    public DesignSupplierStockAptitudeFileInfo getDesignSupplierStockAptitudeFileInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockAptitudeFileInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@return
     */
    public DesignSupplierStockAptitudeFileCollection getDesignSupplierStockAptitudeFileCollection() throws BOSException
    {
        try {
            return getController().getDesignSupplierStockAptitudeFileCollection(getContext());
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
    public DesignSupplierStockAptitudeFileCollection getDesignSupplierStockAptitudeFileCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignSupplierStockAptitudeFileCollection(getContext(), view);
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
    public DesignSupplierStockAptitudeFileCollection getDesignSupplierStockAptitudeFileCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignSupplierStockAptitudeFileCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}