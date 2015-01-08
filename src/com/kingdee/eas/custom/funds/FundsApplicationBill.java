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

public class FundsApplicationBill extends CoreBillBase implements IFundsApplicationBill
{
    public FundsApplicationBill()
    {
        super();
        registerInterface(IFundsApplicationBill.class, this);
    }
    public FundsApplicationBill(Context ctx)
    {
        super(ctx);
        registerInterface(IFundsApplicationBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5A2A70AE");
    }
    private FundsApplicationBillController getController() throws BOSException
    {
        return (FundsApplicationBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FundsApplicationBillCollection getFundsApplicationBillCollection() throws BOSException
    {
        try {
            return getController().getFundsApplicationBillCollection(getContext());
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
    public FundsApplicationBillCollection getFundsApplicationBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFundsApplicationBillCollection(getContext(), view);
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
    public FundsApplicationBillCollection getFundsApplicationBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getFundsApplicationBillCollection(getContext(), oql);
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
    public FundsApplicationBillInfo getFundsApplicationBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFundsApplicationBillInfo(getContext(), pk);
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
    public FundsApplicationBillInfo getFundsApplicationBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFundsApplicationBillInfo(getContext(), pk, selector);
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
    public FundsApplicationBillInfo getFundsApplicationBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFundsApplicationBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(FundsApplicationBillInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(FundsApplicationBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}