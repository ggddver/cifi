package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.lang.String;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.fdc.invite.designsupplier.subill.app.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;

public class DesignSupplierAppraise extends CoreBillBase implements IDesignSupplierAppraise
{
    public DesignSupplierAppraise()
    {
        super();
        registerInterface(IDesignSupplierAppraise.class, this);
    }
    public DesignSupplierAppraise(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignSupplierAppraise.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E0019B5A");
    }
    private DesignSupplierAppraiseController getController() throws BOSException
    {
        return (DesignSupplierAppraiseController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DesignSupplierAppraiseCollection getDesignSupplierAppraiseCollection() throws BOSException
    {
        try {
            return getController().getDesignSupplierAppraiseCollection(getContext());
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
    public DesignSupplierAppraiseCollection getDesignSupplierAppraiseCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignSupplierAppraiseCollection(getContext(), view);
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
    public DesignSupplierAppraiseCollection getDesignSupplierAppraiseCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignSupplierAppraiseCollection(getContext(), oql);
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
    public DesignSupplierAppraiseInfo getDesignSupplierAppraiseInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierAppraiseInfo(getContext(), pk);
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
    public DesignSupplierAppraiseInfo getDesignSupplierAppraiseInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierAppraiseInfo(getContext(), pk, selector);
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
    public DesignSupplierAppraiseInfo getDesignSupplierAppraiseInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierAppraiseInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(DesignSupplierAppraiseInfo model) throws BOSException
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
    public void unAudit(DesignSupplierAppraiseInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}