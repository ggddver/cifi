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

public class Receiption extends CoreBillBase implements IReceiption
{
    public Receiption()
    {
        super();
        registerInterface(IReceiption.class, this);
    }
    public Receiption(Context ctx)
    {
        super(ctx);
        registerInterface(IReceiption.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E0D00475");
    }
    private ReceiptionController getController() throws BOSException
    {
        return (ReceiptionController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ReceiptionCollection getReceiptionCollection() throws BOSException
    {
        try {
            return getController().getReceiptionCollection(getContext());
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
    public ReceiptionCollection getReceiptionCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getReceiptionCollection(getContext(), view);
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
    public ReceiptionCollection getReceiptionCollection(String oql) throws BOSException
    {
        try {
            return getController().getReceiptionCollection(getContext(), oql);
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
    public ReceiptionInfo getReceiptionInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getReceiptionInfo(getContext(), pk);
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
    public ReceiptionInfo getReceiptionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getReceiptionInfo(getContext(), pk, selector);
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
    public ReceiptionInfo getReceiptionInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getReceiptionInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����-User defined method
     *@param model model
     */
    public void audit(ReceiptionInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������-User defined method
     *@param model model
     */
    public void unAudit(ReceiptionInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����-User defined method
     *@param model ����
     */
    public void close(ReceiptionInfo model) throws BOSException
    {
        try {
            getController().close(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������-User defined method
     *@param model ����
     */
    public void unclose(ReceiptionInfo model) throws BOSException
    {
        try {
            getController().unclose(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}