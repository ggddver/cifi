package com.kingdee.eas.custom.funds;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.lang.String;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.funds.app.*;
import com.kingdee.eas.framework.ICoreBillBase;

public class FundsApplication extends CoreBillBase implements IFundsApplication
{
    public FundsApplication()
    {
        super();
        registerInterface(IFundsApplication.class, this);
    }
    public FundsApplication(Context ctx)
    {
        super(ctx);
        registerInterface(IFundsApplication.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3DE23407");
    }
    private FundsApplicationController getController() throws BOSException
    {
        return (FundsApplicationController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FundsApplicationCollection getFundsApplicationCollection() throws BOSException
    {
        try {
            return getController().getFundsApplicationCollection(getContext());
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
    public FundsApplicationCollection getFundsApplicationCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFundsApplicationCollection(getContext(), view);
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
    public FundsApplicationCollection getFundsApplicationCollection(String oql) throws BOSException
    {
        try {
            return getController().getFundsApplicationCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FundsApplicationInfo getFundsApplicationInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFundsApplicationInfo(getContext(), pk);
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
    public FundsApplicationInfo getFundsApplicationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFundsApplicationInfo(getContext(), pk, selector);
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
    public FundsApplicationInfo getFundsApplicationInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFundsApplicationInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审批-User defined method
     *@param model model
     */
    public void audit(FundsApplicationInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审批-User defined method
     *@param model model
     */
    public void unAudit(FundsApplicationInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}