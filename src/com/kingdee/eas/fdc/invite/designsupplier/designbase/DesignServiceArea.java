package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.lang.String;
import com.kingdee.eas.fdc.basedata.IFDCDataBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.fdc.basedata.FDCDataBase;

public class DesignServiceArea extends FDCDataBase implements IDesignServiceArea
{
    public DesignServiceArea()
    {
        super();
        registerInterface(IDesignServiceArea.class, this);
    }
    public DesignServiceArea(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignServiceArea.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F8360D25");
    }
    private DesignServiceAreaController getController() throws BOSException
    {
        return (DesignServiceAreaController)getBizController();
    }
    /**
     *getValue-System defined method
     *@param oql oql
     *@return
     */
    public DesignServiceAreaInfo getDesignServiceAreaInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignServiceAreaInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@param selector selector
     *@return
     */
    public DesignServiceAreaInfo getDesignServiceAreaInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignServiceAreaInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@return
     */
    public DesignServiceAreaInfo getDesignServiceAreaInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignServiceAreaInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@param oql oql
     *@return
     */
    public DesignServiceAreaCollection getDesignServiceAreaCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignServiceAreaCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@param view view
     *@return
     */
    public DesignServiceAreaCollection getDesignServiceAreaCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignServiceAreaCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@return
     */
    public DesignServiceAreaCollection getDesignServiceAreaCollection() throws BOSException
    {
        try {
            return getController().getDesignServiceAreaCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *是否删除区域名称-User defined method
     *@param areaName 区域名称
     */
    public void IsNdelete(String areaName) throws BOSException, EASBizException
    {
        try {
            getController().IsNdelete(getContext(), areaName);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}