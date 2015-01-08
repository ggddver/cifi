package com.kingdee.eas.fdc.invite.designsupplier.designbase;

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
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.fdc.basedata.IFDCTreeBaseData;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.fdc.basedata.FDCTreeBaseData;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.app.*;
import com.kingdee.bos.framework.*;

public class DesignServiceType extends FDCTreeBaseData implements IDesignServiceType
{
    public DesignServiceType()
    {
        super();
        registerInterface(IDesignServiceType.class, this);
    }
    public DesignServiceType(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignServiceType.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F83ECBD2");
    }
    private DesignServiceTypeController getController() throws BOSException
    {
        return (DesignServiceTypeController)getBizController();
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@return
     */
    public DesignServiceTypeInfo getDesignServiceTypeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignServiceTypeInfo(getContext(), pk);
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
    public DesignServiceTypeInfo getDesignServiceTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignServiceTypeInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getValue-System defined method
     *@param oql oql
     *@return
     */
    public DesignServiceTypeInfo getDesignServiceTypeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignServiceTypeInfo(getContext(), oql);
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
    public DesignServiceTypeCollection getDesignServiceTypeCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignServiceTypeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@return
     */
    public DesignServiceTypeCollection getDesignServiceTypeCollection() throws BOSException
    {
        try {
            return getController().getDesignServiceTypeCollection(getContext());
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
    public DesignServiceTypeCollection getDesignServiceTypeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignServiceTypeCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}