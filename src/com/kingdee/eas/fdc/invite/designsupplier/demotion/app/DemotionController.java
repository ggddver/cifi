package com.kingdee.eas.fdc.invite.designsupplier.demotion.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DemotionController extends CoreBillBaseController
{
    public DemotionCollection getDemotionCollection(Context ctx) throws BOSException, RemoteException;
    public DemotionCollection getDemotionCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DemotionCollection getDemotionCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public DemotionInfo getDemotionInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DemotionInfo getDemotionInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DemotionInfo getDemotionInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, DemotionInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, DemotionInfo model) throws BOSException, RemoteException;
}