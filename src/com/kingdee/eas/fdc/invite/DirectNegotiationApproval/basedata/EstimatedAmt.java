package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata;

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
import com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.app.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.IDataBase;

public class EstimatedAmt extends DataBase implements IEstimatedAmt
{
    public EstimatedAmt()
    {
        super();
        registerInterface(IEstimatedAmt.class, this);
    }
    public EstimatedAmt(Context ctx)
    {
        super(ctx);
        registerInterface(IEstimatedAmt.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("617476E2");
    }
    private EstimatedAmtController getController() throws BOSException
    {
        return (EstimatedAmtController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public EstimatedAmtInfo getEstimatedAmtInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEstimatedAmtInfo(getContext(), pk);
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
    public EstimatedAmtInfo getEstimatedAmtInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEstimatedAmtInfo(getContext(), pk, selector);
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
    public EstimatedAmtInfo getEstimatedAmtInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEstimatedAmtInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public EstimatedAmtCollection getEstimatedAmtCollection() throws BOSException
    {
        try {
            return getController().getEstimatedAmtCollection(getContext());
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
    public EstimatedAmtCollection getEstimatedAmtCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEstimatedAmtCollection(getContext(), view);
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
    public EstimatedAmtCollection getEstimatedAmtCollection(String oql) throws BOSException
    {
        try {
            return getController().getEstimatedAmtCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}