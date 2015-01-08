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

public class DesignQuaLevel extends FDCDataBase implements IDesignQuaLevel
{
    public DesignQuaLevel()
    {
        super();
        registerInterface(IDesignQuaLevel.class, this);
    }
    public DesignQuaLevel(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignQuaLevel.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B1085D64");
    }
    private DesignQuaLevelController getController() throws BOSException
    {
        return (DesignQuaLevelController)getBizController();
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@return
     */
    public DesignQuaLevelInfo getDesignQuaLevelInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignQuaLevelInfo(getContext(), pk);
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
    public DesignQuaLevelInfo getDesignQuaLevelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignQuaLevelInfo(getContext(), pk, selector);
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
    public DesignQuaLevelInfo getDesignQuaLevelInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignQuaLevelInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@return
     */
    public DesignQuaLevelCollection getDesignQuaLevelCollection() throws BOSException
    {
        try {
            return getController().getDesignQuaLevelCollection(getContext());
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
    public DesignQuaLevelCollection getDesignQuaLevelCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignQuaLevelCollection(getContext(), view);
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
    public DesignQuaLevelCollection getDesignQuaLevelCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignQuaLevelCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}