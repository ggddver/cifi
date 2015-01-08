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

public class DesignSupplierEvaluation extends CoreBillBase implements IDesignSupplierEvaluation
{
    public DesignSupplierEvaluation()
    {
        super();
        registerInterface(IDesignSupplierEvaluation.class, this);
    }
    public DesignSupplierEvaluation(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignSupplierEvaluation.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FEE2486B");
    }
    private DesignSupplierEvaluationController getController() throws BOSException
    {
        return (DesignSupplierEvaluationController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public DesignSupplierEvaluationCollection getDesignSupplierEvaluationCollection() throws BOSException
    {
        try {
            return getController().getDesignSupplierEvaluationCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public DesignSupplierEvaluationCollection getDesignSupplierEvaluationCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignSupplierEvaluationCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public DesignSupplierEvaluationCollection getDesignSupplierEvaluationCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignSupplierEvaluationCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public DesignSupplierEvaluationInfo getDesignSupplierEvaluationInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierEvaluationInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public DesignSupplierEvaluationInfo getDesignSupplierEvaluationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierEvaluationInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public DesignSupplierEvaluationInfo getDesignSupplierEvaluationInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierEvaluationInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(DesignSupplierEvaluationInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����-User defined method
     *@param model model
     */
    public void unAudit(DesignSupplierEvaluationInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}