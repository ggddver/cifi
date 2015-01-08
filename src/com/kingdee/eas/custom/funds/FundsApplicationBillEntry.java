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

public class FundsApplicationBillEntry extends CoreBillEntryBase implements IFundsApplicationBillEntry
{
    public FundsApplicationBillEntry()
    {
        super();
        registerInterface(IFundsApplicationBillEntry.class, this);
    }
    public FundsApplicationBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFundsApplicationBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BBC6E464");
    }
    private FundsApplicationBillEntryController getController() throws BOSException
    {
        return (FundsApplicationBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FundsApplicationBillEntryInfo getFundsApplicationBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFundsApplicationBillEntryInfo(getContext(), pk);
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
    public FundsApplicationBillEntryInfo getFundsApplicationBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFundsApplicationBillEntryInfo(getContext(), pk, selector);
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
    public FundsApplicationBillEntryInfo getFundsApplicationBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFundsApplicationBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FundsApplicationBillEntryCollection getFundsApplicationBillEntryCollection() throws BOSException
    {
        try {
            return getController().getFundsApplicationBillEntryCollection(getContext());
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
    public FundsApplicationBillEntryCollection getFundsApplicationBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFundsApplicationBillEntryCollection(getContext(), view);
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
    public FundsApplicationBillEntryCollection getFundsApplicationBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFundsApplicationBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}