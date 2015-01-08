package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.lang.String;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.IDataBase;

public class DesignVisibility extends DataBase implements IDesignVisibility
{
    public DesignVisibility()
    {
        super();
        registerInterface(IDesignVisibility.class, this);
    }
    public DesignVisibility(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignVisibility.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A8B7EA6F");
    }
    private DesignVisibilityController getController() throws BOSException
    {
        return (DesignVisibilityController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DesignVisibilityInfo getDesignVisibilityInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignVisibilityInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
     *@return
     */
    public DesignVisibilityInfo getDesignVisibilityInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignVisibilityInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param oql 取值
     *@return
     */
    public DesignVisibilityInfo getDesignVisibilityInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignVisibilityInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DesignVisibilityCollection getDesignVisibilityCollection() throws BOSException
    {
        try {
            return getController().getDesignVisibilityCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param view 取集合
     *@return
     */
    public DesignVisibilityCollection getDesignVisibilityCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignVisibilityCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param oql 取集合
     *@return
     */
    public DesignVisibilityCollection getDesignVisibilityCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignVisibilityCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}