package com.kingdee.eas.custom.funds;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.bos.util.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.ICoreBillBase;

public interface IFundsApplication extends ICoreBillBase
{
    public FundsApplicationCollection getFundsApplicationCollection() throws BOSException;
    public FundsApplicationCollection getFundsApplicationCollection(EntityViewInfo view) throws BOSException;
    public FundsApplicationCollection getFundsApplicationCollection(String oql) throws BOSException;
    public FundsApplicationInfo getFundsApplicationInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FundsApplicationInfo getFundsApplicationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FundsApplicationInfo getFundsApplicationInfo(String oql) throws BOSException, EASBizException;
    public void audit(FundsApplicationInfo model) throws BOSException;
    public void unAudit(FundsApplicationInfo model) throws BOSException;
}