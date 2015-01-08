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

public class DesignSupplierAppraiseEntry extends CoreBillEntryBase implements IDesignSupplierAppraiseEntry
{
    public DesignSupplierAppraiseEntry()
    {
        super();
        registerInterface(IDesignSupplierAppraiseEntry.class, this);
    }
    public DesignSupplierAppraiseEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDesignSupplierAppraiseEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("155B8538");
    }
    private DesignSupplierAppraiseEntryController getController() throws BOSException
    {
        return (DesignSupplierAppraiseEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public DesignSupplierAppraiseEntryInfo getDesignSupplierAppraiseEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierAppraiseEntryInfo(getContext(), pk);
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
    public DesignSupplierAppraiseEntryInfo getDesignSupplierAppraiseEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierAppraiseEntryInfo(getContext(), pk, selector);
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
    public DesignSupplierAppraiseEntryInfo getDesignSupplierAppraiseEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDesignSupplierAppraiseEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public DesignSupplierAppraiseEntryCollection getDesignSupplierAppraiseEntryCollection() throws BOSException
    {
        try {
            return getController().getDesignSupplierAppraiseEntryCollection(getContext());
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
    public DesignSupplierAppraiseEntryCollection getDesignSupplierAppraiseEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDesignSupplierAppraiseEntryCollection(getContext(), view);
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
    public DesignSupplierAppraiseEntryCollection getDesignSupplierAppraiseEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDesignSupplierAppraiseEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}