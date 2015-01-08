package com.kingdee.eas.custom.funds.app;

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
import com.kingdee.eas.custom.funds.FundsApplicationCollection;
import com.kingdee.eas.custom.funds.FundsApplicationInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FundsApplicationController extends CoreBillBaseController
{
    public FundsApplicationCollection getFundsApplicationCollection(Context ctx) throws BOSException, RemoteException;
    public FundsApplicationCollection getFundsApplicationCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FundsApplicationCollection getFundsApplicationCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public FundsApplicationInfo getFundsApplicationInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FundsApplicationInfo getFundsApplicationInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FundsApplicationInfo getFundsApplicationInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, FundsApplicationInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, FundsApplicationInfo model) throws BOSException, RemoteException;
}