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

public class DesignGradeSetUp extends FDCDataBase implements IDesignGradeSetUp
{
    public DesignGradeSetUp()
    {
        super();
        registerInterface(IDesignGradeSetUp.class, this);
    }
    public DesignGradeSetUp(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignGradeSetUp.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3C635C63");
    }
    private DesignGradeSetUpController getController() throws BOSException
    {
        return (DesignGradeSetUpController)getBizController();
    }
    /**
     *getValue-System defined method
     *@param pk pk
     *@return
     */
    public DesignGradeSetUpInfo getDesignGradeSetUpInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignGradeSetUpInfo(getContext(), pk);
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
    public DesignGradeSetUpInfo getDesignGradeSetUpInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignGradeSetUpInfo(getContext(), pk, selector);
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
    public DesignGradeSetUpInfo getDesignGradeSetUpInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignGradeSetUpInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCollection-System defined method
     *@return
     */
    public DesignGradeSetUpCollection getDesignGradeSetUpCollection() throws BOSException
    {
        try {
            return getController().getDesignGradeSetUpCollection(getContext());
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
    public DesignGradeSetUpCollection getDesignGradeSetUpCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignGradeSetUpCollection(getContext(), view);
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
    public DesignGradeSetUpCollection getDesignGradeSetUpCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignGradeSetUpCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}