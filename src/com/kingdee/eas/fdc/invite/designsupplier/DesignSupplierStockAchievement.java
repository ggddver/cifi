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

public class DesignSupplierStockAchievement extends CoreBillEntryBase implements IDesignSupplierStockAchievement
{
    public DesignSupplierStockAchievement()
    {
        super();
        registerInterface(IDesignSupplierStockAchievement.class, this);
    }
    public DesignSupplierStockAchievement(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignSupplierStockAchievement.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("49B428FD");
    }
    private DesignSupplierStockAchievementController getController() throws BOSException
    {
        return (DesignSupplierStockAchievementController)getBizController();
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@return
     */
    public DesignSupplierStockAchievementInfo getDesignSupplierStockAchievementInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockAchievementInfo(getContext(), pk);
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
    public DesignSupplierStockAchievementInfo getDesignSupplierStockAchievementInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockAchievementInfo(getContext(), pk, selector);
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
    public DesignSupplierStockAchievementInfo getDesignSupplierStockAchievementInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierStockAchievementInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@return
     */
    public DesignSupplierStockAchievementCollection getDesignSupplierStockAchievementCollection() throws BOSException
    {
        try {
            return getController().getDesignSupplierStockAchievementCollection(getContext());
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
    public DesignSupplierStockAchievementCollection getDesignSupplierStockAchievementCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignSupplierStockAchievementCollection(getContext(), view);
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
    public DesignSupplierStockAchievementCollection getDesignSupplierStockAchievementCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignSupplierStockAchievementCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}