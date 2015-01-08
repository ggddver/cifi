package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.DirectRuleTreeInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.bos.util.*;
import com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.DirectRuleTreeCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DirectRuleTreeController extends TreeBaseController
{
    public DirectRuleTreeInfo getDirectRuleTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DirectRuleTreeInfo getDirectRuleTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DirectRuleTreeInfo getDirectRuleTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public DirectRuleTreeCollection getDirectRuleTreeCollection(Context ctx) throws BOSException, RemoteException;
    public DirectRuleTreeCollection getDirectRuleTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DirectRuleTreeCollection getDirectRuleTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}