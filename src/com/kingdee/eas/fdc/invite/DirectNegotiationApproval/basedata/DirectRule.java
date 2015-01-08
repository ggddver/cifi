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
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.app.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.IDataBase;

public class DirectRule extends DataBase implements IDirectRule
{
    public DirectRule()
    {
        super();
        registerInterface(IDirectRule.class, this);
    }
    public DirectRule(Context ctx)
    {
        super(ctx);
        registerInterface(IDirectRule.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("79FE7EFB");
    }
    private DirectRuleController getController() throws BOSException
    {
        return (DirectRuleController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DirectRuleInfo getDirectRuleInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDirectRuleInfo(getContext(), pk);
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
    public DirectRuleInfo getDirectRuleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDirectRuleInfo(getContext(), pk, selector);
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
    public DirectRuleInfo getDirectRuleInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDirectRuleInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DirectRuleCollection getDirectRuleCollection() throws BOSException
    {
        try {
            return getController().getDirectRuleCollection(getContext());
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
    public DirectRuleCollection getDirectRuleCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDirectRuleCollection(getContext(), view);
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
    public DirectRuleCollection getDirectRuleCollection(String oql) throws BOSException
    {
        try {
            return getController().getDirectRuleCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}