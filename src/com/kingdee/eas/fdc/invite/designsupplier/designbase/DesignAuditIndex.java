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

public class DesignAuditIndex extends DataBase implements IDesignAuditIndex
{
    public DesignAuditIndex()
    {
        super();
        registerInterface(IDesignAuditIndex.class, this);
    }
    public DesignAuditIndex(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignAuditIndex.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("98AA5514");
    }
    private DesignAuditIndexController getController() throws BOSException
    {
        return (DesignAuditIndexController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DesignAuditIndexInfo getDesignAuditIndexInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAuditIndexInfo(getContext(), pk);
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
    public DesignAuditIndexInfo getDesignAuditIndexInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAuditIndexInfo(getContext(), pk, selector);
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
    public DesignAuditIndexInfo getDesignAuditIndexInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAuditIndexInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DesignAuditIndexCollection getDesignAuditIndexCollection() throws BOSException
    {
        try {
            return getController().getDesignAuditIndexCollection(getContext());
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
    public DesignAuditIndexCollection getDesignAuditIndexCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignAuditIndexCollection(getContext(), view);
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
    public DesignAuditIndexCollection getDesignAuditIndexCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignAuditIndexCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}