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

public class DesignAppraiseTemplateTree extends TreeBase implements IDesignAppraiseTemplateTree
{
    public DesignAppraiseTemplateTree()
    {
        super();
        registerInterface(IDesignAppraiseTemplateTree.class, this);
    }
    public DesignAppraiseTemplateTree(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignAppraiseTemplateTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B6A48460");
    }
    private DesignAppraiseTemplateTreeController getController() throws BOSException
    {
        return (DesignAppraiseTemplateTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DesignAppraiseTemplateTreeInfo getDesignAppraiseTemplateTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAppraiseTemplateTreeInfo(getContext(), pk);
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
    public DesignAppraiseTemplateTreeInfo getDesignAppraiseTemplateTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAppraiseTemplateTreeInfo(getContext(), pk, selector);
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
    public DesignAppraiseTemplateTreeInfo getDesignAppraiseTemplateTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAppraiseTemplateTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DesignAppraiseTemplateTreeCollection getDesignAppraiseTemplateTreeCollection() throws BOSException
    {
        try {
            return getController().getDesignAppraiseTemplateTreeCollection(getContext());
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
    public DesignAppraiseTemplateTreeCollection getDesignAppraiseTemplateTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignAppraiseTemplateTreeCollection(getContext(), view);
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
    public DesignAppraiseTemplateTreeCollection getDesignAppraiseTemplateTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignAppraiseTemplateTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}