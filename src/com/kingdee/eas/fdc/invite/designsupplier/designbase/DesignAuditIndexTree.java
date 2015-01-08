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
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.TreeBase;

public class DesignAuditIndexTree extends TreeBase implements IDesignAuditIndexTree
{
    public DesignAuditIndexTree()
    {
        super();
        registerInterface(IDesignAuditIndexTree.class, this);
    }
    public DesignAuditIndexTree(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignAuditIndexTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E2B992D2");
    }
    private DesignAuditIndexTreeController getController() throws BOSException
    {
        return (DesignAuditIndexTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DesignAuditIndexTreeInfo getDesignAuditIndexTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAuditIndexTreeInfo(getContext(), pk);
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
    public DesignAuditIndexTreeInfo getDesignAuditIndexTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAuditIndexTreeInfo(getContext(), pk, selector);
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
    public DesignAuditIndexTreeInfo getDesignAuditIndexTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAuditIndexTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DesignAuditIndexTreeCollection getDesignAuditIndexTreeCollection() throws BOSException
    {
        try {
            return getController().getDesignAuditIndexTreeCollection(getContext());
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
    public DesignAuditIndexTreeCollection getDesignAuditIndexTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignAuditIndexTreeCollection(getContext(), view);
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
    public DesignAuditIndexTreeCollection getDesignAuditIndexTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignAuditIndexTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}