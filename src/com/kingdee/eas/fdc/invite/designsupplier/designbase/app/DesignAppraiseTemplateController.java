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
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateInfo;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DesignAppraiseTemplateController extends DataBaseController
{
    public DesignAppraiseTemplateInfo getDesignAppraiseTemplateInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DesignAppraiseTemplateInfo getDesignAppraiseTemplateInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DesignAppraiseTemplateInfo getDesignAppraiseTemplateInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public DesignAppraiseTemplateCollection getDesignAppraiseTemplateCollection(Context ctx) throws BOSException, RemoteException;
    public DesignAppraiseTemplateCollection getDesignAppraiseTemplateCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DesignAppraiseTemplateCollection getDesignAppraiseTemplateCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, DesignAppraiseTemplateInfo model) throws BOSException, RemoteException;
    public void unaudit(Context ctx, DesignAppraiseTemplateInfo model) throws BOSException, RemoteException;
}