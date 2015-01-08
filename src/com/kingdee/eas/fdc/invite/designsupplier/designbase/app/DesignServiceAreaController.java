package com.kingdee.eas.fdc.invite.designsupplier.designbase.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaInfo;
import com.kingdee.bos.util.*;
import com.kingdee.eas.fdc.basedata.app.FDCDataBaseController;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DesignServiceAreaController extends FDCDataBaseController
{
    public DesignServiceAreaInfo getDesignServiceAreaInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public DesignServiceAreaInfo getDesignServiceAreaInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DesignServiceAreaInfo getDesignServiceAreaInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DesignServiceAreaCollection getDesignServiceAreaCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public DesignServiceAreaCollection getDesignServiceAreaCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DesignServiceAreaCollection getDesignServiceAreaCollection(Context ctx) throws BOSException, RemoteException;
    public void IsNdelete(Context ctx, String areaName) throws BOSException, EASBizException, RemoteException;
}