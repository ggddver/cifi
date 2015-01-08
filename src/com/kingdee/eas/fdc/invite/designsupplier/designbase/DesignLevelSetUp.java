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

public class DesignLevelSetUp extends FDCDataBase implements IDesignLevelSetUp
{
    public DesignLevelSetUp()
    {
        super();
        registerInterface(IDesignLevelSetUp.class, this);
    }
    public DesignLevelSetUp(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignLevelSetUp.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("40A9C4D6");
    }
    private DesignLevelSetUpController getController() throws BOSException
    {
        return (DesignLevelSetUpController)getBizController();
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@return
     */
    public DesignLevelSetUpInfo getDesignLevelSetUpInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignLevelSetUpInfo(getContext(), pk);
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
    public DesignLevelSetUpInfo getDesignLevelSetUpInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignLevelSetUpInfo(getContext(), pk, selector);
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
    public DesignLevelSetUpInfo getDesignLevelSetUpInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignLevelSetUpInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@return
     */
    public DesignLevelSetUpCollection getDesignLevelSetUpCollection() throws BOSException
    {
        try {
            return getController().getDesignLevelSetUpCollection(getContext());
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
    public DesignLevelSetUpCollection getDesignLevelSetUpCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignLevelSetUpCollection(getContext(), view);
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
    public DesignLevelSetUpCollection getDesignLevelSetUpCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignLevelSetUpCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}