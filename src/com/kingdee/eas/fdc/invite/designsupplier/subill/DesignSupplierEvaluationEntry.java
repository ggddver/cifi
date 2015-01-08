package com.kingdee.eas.fdc.invite.designsupplier.subill;

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
import com.kingdee.eas.fdc.invite.designsupplier.subill.app.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;

public class DesignSupplierEvaluationEntry extends CoreBillEntryBase implements IDesignSupplierEvaluationEntry
{
    public DesignSupplierEvaluationEntry()
    {
        super();
        registerInterface(IDesignSupplierEvaluationEntry.class, this);
    }
    public DesignSupplierEvaluationEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignSupplierEvaluationEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("95E15AC7");
    }
    private DesignSupplierEvaluationEntryController getController() throws BOSException
    {
        return (DesignSupplierEvaluationEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DesignSupplierEvaluationEntryInfo getDesignSupplierEvaluationEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierEvaluationEntryInfo(getContext(), pk);
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
    public DesignSupplierEvaluationEntryInfo getDesignSupplierEvaluationEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierEvaluationEntryInfo(getContext(), pk, selector);
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
    public DesignSupplierEvaluationEntryInfo getDesignSupplierEvaluationEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierEvaluationEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DesignSupplierEvaluationEntryCollection getDesignSupplierEvaluationEntryCollection() throws BOSException
    {
        try {
            return getController().getDesignSupplierEvaluationEntryCollection(getContext());
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
    public DesignSupplierEvaluationEntryCollection getDesignSupplierEvaluationEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignSupplierEvaluationEntryCollection(getContext(), view);
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
    public DesignSupplierEvaluationEntryCollection getDesignSupplierEvaluationEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignSupplierEvaluationEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}