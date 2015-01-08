package com.kingdee.eas.fdc.invite.designsupplier.subill.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DesignSupplierSelectController extends CoreBillBaseController
{
    public DesignSupplierSelectCollection getDesignSupplierSelectCollection(Context ctx) throws BOSException, RemoteException;
    public DesignSupplierSelectCollection getDesignSupplierSelectCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DesignSupplierSelectCollection getDesignSupplierSelectCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public DesignSupplierSelectInfo getDesignSupplierSelectInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DesignSupplierSelectInfo getDesignSupplierSelectInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DesignSupplierSelectInfo getDesignSupplierSelectInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, DesignSupplierSelectInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, DesignSupplierSelectInfo model) throws BOSException, RemoteException;
}