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

public class Qz extends FDCDataBase implements IQz
{
    public Qz()
    {
        super();
        registerInterface(IQz.class, this);
    }
    public Qz(Context ctx)
    {
        super(ctx);
        registerInterface(IQz.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("06672768");
    }
    private QzController getController() throws BOSException
    {
        return (QzController)getBizController();
    }
    /**
     *getValue-System defined method
     *@param oql oql
     *@return
     */
    public QzInfo getQzInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getQzInfo(getContext(), oql);
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
    public QzInfo getQzInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getQzInfo(getContext(), pk, selector);
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
    public QzInfo getQzInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getQzInfo(getContext(), pk);
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
    public QzCollection getQzCollection(String oql) throws BOSException
    {
        try {
            return getController().getQzCollection(getContext(), oql);
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
    public QzCollection getQzCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getQzCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@return
     */
    public QzCollection getQzCollection() throws BOSException
    {
        try {
            return getController().getQzCollection(getContext());
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