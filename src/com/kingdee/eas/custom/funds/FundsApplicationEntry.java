package com.kingdee.eas.custom.funds;

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
import com.kingdee.eas.custom.funds.app.*;

public class FundsApplicationEntry extends CoreBillEntryBase implements IFundsApplicationEntry
{
    public FundsApplicationEntry()
    {
        super();
        registerInterface(IFundsApplicationEntry.class, this);
    }
    public FundsApplicationEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFundsApplicationEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EB5050AB");
    }
    private FundsApplicationEntryController getController() throws BOSException
    {
        return (FundsApplicationEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FundsApplicationEntryInfo getFundsApplicationEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFundsApplicationEntryInfo(getContext(), pk);
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
    public FundsApplicationEntryInfo getFundsApplicationEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFundsApplicationEntryInfo(getContext(), pk, selector);
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
    public FundsApplicationEntryInfo getFundsApplicationEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFundsApplicationEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FundsApplicationEntryCollection getFundsApplicationEntryCollection() throws BOSException
    {
        try {
            return getController().getFundsApplicationEntryCollection(getContext());
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
    public FundsApplicationEntryCollection getFundsApplicationEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFundsApplicationEntryCollection(getContext(), view);
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
    public FundsApplicationEntryCollection getFundsApplicationEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFundsApplicationEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}