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
import com.kingdee.eas.framework.DataBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.IDataBase;

public class DesignAppraiseTemplate extends DataBase implements IDesignAppraiseTemplate
{
    public DesignAppraiseTemplate()
    {
        super();
        registerInterface(IDesignAppraiseTemplate.class, this);
    }
    public DesignAppraiseTemplate(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignAppraiseTemplate.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0DF83DA2");
    }
    private DesignAppraiseTemplateController getController() throws BOSException
    {
        return (DesignAppraiseTemplateController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public DesignAppraiseTemplateInfo getDesignAppraiseTemplateInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAppraiseTemplateInfo(getContext(), pk);
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
    public DesignAppraiseTemplateInfo getDesignAppraiseTemplateInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAppraiseTemplateInfo(getContext(), pk, selector);
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
    public DesignAppraiseTemplateInfo getDesignAppraiseTemplateInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignAppraiseTemplateInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public DesignAppraiseTemplateCollection getDesignAppraiseTemplateCollection() throws BOSException
    {
        try {
            return getController().getDesignAppraiseTemplateCollection(getContext());
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
    public DesignAppraiseTemplateCollection getDesignAppraiseTemplateCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignAppraiseTemplateCollection(getContext(), view);
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
    public DesignAppraiseTemplateCollection getDesignAppraiseTemplateCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignAppraiseTemplateCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����-User defined method
     *@param model model
     */
    public void audit(DesignAppraiseTemplateInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������-User defined method
     *@param model model
     */
    public void unaudit(DesignAppraiseTemplateInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}