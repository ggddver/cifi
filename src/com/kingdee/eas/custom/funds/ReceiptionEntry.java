package com.kingdee.eas.custom.funds;

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
import com.kingdee.eas.custom.funds.app.*;

public class ReceiptionEntry extends CoreBillEntryBase implements IReceiptionEntry
{
    public ReceiptionEntry()
    {
        super();
        registerInterface(IReceiptionEntry.class, this);
    }
    public ReceiptionEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IReceiptionEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C03994FD");
    }
    private ReceiptionEntryController getController() throws BOSException
    {
        return (ReceiptionEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public ReceiptionEntryInfo getReceiptionEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getReceiptionEntryInfo(getContext(), pk);
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
    public ReceiptionEntryInfo getReceiptionEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getReceiptionEntryInfo(getContext(), pk, selector);
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
    public ReceiptionEntryInfo getReceiptionEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getReceiptionEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ReceiptionEntryCollection getReceiptionEntryCollection() throws BOSException
    {
        try {
            return getController().getReceiptionEntryCollection(getContext());
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
    public ReceiptionEntryCollection getReceiptionEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getReceiptionEntryCollection(getContext(), view);
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
    public ReceiptionEntryCollection getReceiptionEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getReceiptionEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}