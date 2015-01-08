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
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.eas.custom.funds.ReceiptionCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.funds.ReceiptionInfo;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ReceiptionController extends CoreBillBaseController
{
    public ReceiptionCollection getReceiptionCollection(Context ctx) throws BOSException, RemoteException;
    public ReceiptionCollection getReceiptionCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ReceiptionCollection getReceiptionCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ReceiptionInfo getReceiptionInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ReceiptionInfo getReceiptionInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ReceiptionInfo getReceiptionInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, ReceiptionInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, ReceiptionInfo model) throws BOSException, RemoteException;
    public void close(Context ctx, ReceiptionInfo model) throws BOSException, RemoteException;
    public void unclose(Context ctx, ReceiptionInfo model) throws BOSException, RemoteException;
}