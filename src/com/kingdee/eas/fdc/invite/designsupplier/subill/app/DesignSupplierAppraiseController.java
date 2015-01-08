package com.kingdee.eas.fdc.invite.designsupplier.subill.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DesignSupplierAppraiseController extends CoreBillBaseController
{
    public DesignSupplierAppraiseCollection getDesignSupplierAppraiseCollection(Context ctx) throws BOSException, RemoteException;
    public DesignSupplierAppraiseCollection getDesignSupplierAppraiseCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DesignSupplierAppraiseCollection getDesignSupplierAppraiseCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public DesignSupplierAppraiseInfo getDesignSupplierAppraiseInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DesignSupplierAppraiseInfo getDesignSupplierAppraiseInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DesignSupplierAppraiseInfo getDesignSupplierAppraiseInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, DesignSupplierAppraiseInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, DesignSupplierAppraiseInfo model) throws BOSException, RemoteException;
}