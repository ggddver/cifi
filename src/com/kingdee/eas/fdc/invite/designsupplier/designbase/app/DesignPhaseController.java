package com.kingdee.eas.fdc.invite.designsupplier.designbase.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignPhaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignPhaseInfo;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DesignPhaseController extends DataBaseController
{
    public DesignPhaseInfo getDesignPhaseInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DesignPhaseInfo getDesignPhaseInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DesignPhaseInfo getDesignPhaseInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public DesignPhaseCollection getDesignPhaseCollection(Context ctx) throws BOSException, RemoteException;
    public DesignPhaseCollection getDesignPhaseCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DesignPhaseCollection getDesignPhaseCollection(Context ctx, String oql) throws BOSException, RemoteException;
}