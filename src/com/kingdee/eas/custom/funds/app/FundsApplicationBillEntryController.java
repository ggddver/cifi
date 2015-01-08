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
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.funds.FundsApplicationBillEntryInfo;
import com.kingdee.eas.custom.funds.FundsApplicationBillEntryCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FundsApplicationBillEntryController extends CoreBillEntryBaseController
{
    public FundsApplicationBillEntryInfo getFundsApplicationBillEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FundsApplicationBillEntryInfo getFundsApplicationBillEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FundsApplicationBillEntryInfo getFundsApplicationBillEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public FundsApplicationBillEntryCollection getFundsApplicationBillEntryCollection(Context ctx) throws BOSException, RemoteException;
    public FundsApplicationBillEntryCollection getFundsApplicationBillEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FundsApplicationBillEntryCollection getFundsApplicationBillEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}