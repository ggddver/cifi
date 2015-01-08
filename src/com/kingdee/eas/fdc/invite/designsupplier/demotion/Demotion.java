package com.kingdee.eas.fdc.invite.designsupplier.demotion;

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
import com.kingdee.eas.fdc.invite.designsupplier.demotion.app.*;
import com.kingdee.eas.framework.ICoreBillBase;

public class Demotion extends CoreBillBase implements IDemotion
{
    public Demotion()
    {
        super();
        registerInterface(IDemotion.class, this);
    }
    public Demotion(Context ctx)
    {
        super(ctx);
        registerInterface(IDemotion.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EC7E914E");
    }
    private DemotionController getController() throws BOSException
    {
        return (DemotionController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DemotionCollection getDemotionCollection() throws BOSException
    {
        try {
            return getController().getDemotionCollection(getContext());
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
    public DemotionCollection getDemotionCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDemotionCollection(getContext(), view);
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
    public DemotionCollection getDemotionCollection(String oql) throws BOSException
    {
        try {
            return getController().getDemotionCollection(getContext(), oql);
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
    public DemotionInfo getDemotionInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDemotionInfo(getContext(), pk);
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
    public DemotionInfo getDemotionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDemotionInfo(getContext(), pk, selector);
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
    public DemotionInfo getDemotionInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDemotionInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(DemotionInfo model) throws BOSException
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
    public void unAudit(DemotionInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}