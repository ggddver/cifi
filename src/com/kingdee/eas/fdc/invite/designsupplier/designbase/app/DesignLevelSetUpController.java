package com.kingdee.eas.fdc.invite.designsupplier.designbase.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignLevelSetUpInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignLevelSetUpCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.eas.fdc.basedata.app.FDCDataBaseController;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DesignLevelSetUpController extends FDCDataBaseController
{
    public DesignLevelSetUpInfo getDesignLevelSetUpInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DesignLevelSetUpInfo getDesignLevelSetUpInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DesignLevelSetUpInfo getDesignLevelSetUpInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public DesignLevelSetUpCollection getDesignLevelSetUpCollection(Context ctx) throws BOSException, RemoteException;
    public DesignLevelSetUpCollection getDesignLevelSetUpCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DesignLevelSetUpCollection getDesignLevelSetUpCollection(Context ctx, String oql) throws BOSException, RemoteException;
}