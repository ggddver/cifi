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

public class DesignPhase extends DataBase implements IDesignPhase
{
    public DesignPhase()
    {
        super();
        registerInterface(IDesignPhase.class, this);
    }
    public DesignPhase(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignPhase.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("50EF9BFE");
    }
    private DesignPhaseController getController() throws BOSException
    {
        return (DesignPhaseController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DesignPhaseInfo getDesignPhaseInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignPhaseInfo(getContext(), pk);
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
    public DesignPhaseInfo getDesignPhaseInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignPhaseInfo(getContext(), pk, selector);
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
    public DesignPhaseInfo getDesignPhaseInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignPhaseInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DesignPhaseCollection getDesignPhaseCollection() throws BOSException
    {
        try {
            return getController().getDesignPhaseCollection(getContext());
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
    public DesignPhaseCollection getDesignPhaseCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignPhaseCollection(getContext(), view);
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
    public DesignPhaseCollection getDesignPhaseCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignPhaseCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}