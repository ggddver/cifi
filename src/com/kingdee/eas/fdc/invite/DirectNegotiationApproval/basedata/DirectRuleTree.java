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
import com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.app.*;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.TreeBase;

public class DirectRuleTree extends TreeBase implements IDirectRuleTree
{
    public DirectRuleTree()
    {
        super();
        registerInterface(IDirectRuleTree.class, this);
    }
    public DirectRuleTree(Context ctx)
    {
        super(ctx);
        registerInterface(IDirectRuleTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("48887139");
    }
    private DirectRuleTreeController getController() throws BOSException
    {
        return (DirectRuleTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DirectRuleTreeInfo getDirectRuleTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDirectRuleTreeInfo(getContext(), pk);
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
    public DirectRuleTreeInfo getDirectRuleTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDirectRuleTreeInfo(getContext(), pk, selector);
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
    public DirectRuleTreeInfo getDirectRuleTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDirectRuleTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DirectRuleTreeCollection getDirectRuleTreeCollection() throws BOSException
    {
        try {
            return getController().getDirectRuleTreeCollection(getContext());
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
    public DirectRuleTreeCollection getDirectRuleTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDirectRuleTreeCollection(getContext(), view);
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
    public DirectRuleTreeCollection getDirectRuleTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getDirectRuleTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}