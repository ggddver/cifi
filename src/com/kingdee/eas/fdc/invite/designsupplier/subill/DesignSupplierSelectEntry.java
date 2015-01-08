package com.kingdee.eas.fdc.invite.designsupplier.subill;

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
import com.kingdee.eas.fdc.invite.designsupplier.subill.app.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;

public class DesignSupplierSelectEntry extends CoreBillEntryBase implements IDesignSupplierSelectEntry
{
    public DesignSupplierSelectEntry()
    {
        super();
        registerInterface(IDesignSupplierSelectEntry.class, this);
    }
    public DesignSupplierSelectEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignSupplierSelectEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B6788587");
    }
    private DesignSupplierSelectEntryController getController() throws BOSException
    {
        return (DesignSupplierSelectEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public DesignSupplierSelectEntryInfo getDesignSupplierSelectEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierSelectEntryInfo(getContext(), pk);
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
    public DesignSupplierSelectEntryInfo getDesignSupplierSelectEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierSelectEntryInfo(getContext(), pk, selector);
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
    public DesignSupplierSelectEntryInfo getDesignSupplierSelectEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierSelectEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public DesignSupplierSelectEntryCollection getDesignSupplierSelectEntryCollection() throws BOSException
    {
        try {
            return getController().getDesignSupplierSelectEntryCollection(getContext());
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
    public DesignSupplierSelectEntryCollection getDesignSupplierSelectEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignSupplierSelectEntryCollection(getContext(), view);
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
    public DesignSupplierSelectEntryCollection getDesignSupplierSelectEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignSupplierSelectEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}