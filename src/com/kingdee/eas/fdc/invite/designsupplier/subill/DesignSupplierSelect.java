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

public class DesignSupplierSelect extends CoreBillBase implements IDesignSupplierSelect
{
    public DesignSupplierSelect()
    {
        super();
        registerInterface(IDesignSupplierSelect.class, this);
    }
    public DesignSupplierSelect(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignSupplierSelect.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9DAB65AB");
    }
    private DesignSupplierSelectController getController() throws BOSException
    {
        return (DesignSupplierSelectController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DesignSupplierSelectCollection getDesignSupplierSelectCollection() throws BOSException
    {
        try {
            return getController().getDesignSupplierSelectCollection(getContext());
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
    public DesignSupplierSelectCollection getDesignSupplierSelectCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignSupplierSelectCollection(getContext(), view);
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
    public DesignSupplierSelectCollection getDesignSupplierSelectCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignSupplierSelectCollection(getContext(), oql);
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
    public DesignSupplierSelectInfo getDesignSupplierSelectInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierSelectInfo(getContext(), pk);
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
    public DesignSupplierSelectInfo getDesignSupplierSelectInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierSelectInfo(getContext(), pk, selector);
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
    public DesignSupplierSelectInfo getDesignSupplierSelectInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierSelectInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(DesignSupplierSelectInfo model) throws BOSException
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
    public void unAudit(DesignSupplierSelectInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}