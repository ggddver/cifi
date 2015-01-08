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
     *ȡֵ-System defined method
     *@param pk ȡֵ
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
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
     *ȡֵ-System defined method
     *@param oql ȡֵ
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
     *ȡ����-System defined method
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
     *ȡ����-System defined method
     *@param view ȡ����
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
     *ȡ����-System defined method
     *@param oql ȡ����
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