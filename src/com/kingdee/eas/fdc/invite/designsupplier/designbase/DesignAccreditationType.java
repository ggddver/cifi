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

public class DesignAccreditationType extends DataBase implements IDesignAccreditationType
{
    public DesignAccreditationType()
    {
        super();
        registerInterface(IDesignAccreditationType.class, this);
    }
    public DesignAccreditationType(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignAccreditationType.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("87E92A97");
    }
    private DesignAccreditationTypeController getController() throws BOSException
    {
        return (DesignAccreditationTypeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DesignAccreditationTypeInfo getDesignAccreditationTypeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAccreditationTypeInfo(getContext(), pk);
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
    public DesignAccreditationTypeInfo getDesignAccreditationTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAccreditationTypeInfo(getContext(), pk, selector);
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
    public DesignAccreditationTypeInfo getDesignAccreditationTypeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAccreditationTypeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DesignAccreditationTypeCollection getDesignAccreditationTypeCollection() throws BOSException
    {
        try {
            return getController().getDesignAccreditationTypeCollection(getContext());
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
    public DesignAccreditationTypeCollection getDesignAccreditationTypeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignAccreditationTypeCollection(getContext(), view);
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
    public DesignAccreditationTypeCollection getDesignAccreditationTypeCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignAccreditationTypeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}