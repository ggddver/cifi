package com.kingdee.eas.fdc.invite.designsupplier.demotion;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.lang.String;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.fdc.invite.designsupplier.demotion.app.*;

public class DemotionEntry extends CoreBillEntryBase implements IDemotionEntry
{
    public DemotionEntry()
    {
        super();
        registerInterface(IDemotionEntry.class, this);
    }
    public DemotionEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDemotionEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2A0E27C4");
    }
    private DemotionEntryController getController() throws BOSException
    {
        return (DemotionEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DemotionEntryInfo getDemotionEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDemotionEntryInfo(getContext(), pk);
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
    public DemotionEntryInfo getDemotionEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDemotionEntryInfo(getContext(), pk, selector);
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
    public DemotionEntryInfo getDemotionEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDemotionEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DemotionEntryCollection getDemotionEntryCollection() throws BOSException
    {
        try {
            return getController().getDemotionEntryCollection(getContext());
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
    public DemotionEntryCollection getDemotionEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDemotionEntryCollection(getContext(), view);
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
    public DemotionEntryCollection getDemotionEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDemotionEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}