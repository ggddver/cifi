package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;

public interface IDirectRule extends IDataBase
{
    public DirectRuleInfo getDirectRuleInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DirectRuleInfo getDirectRuleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DirectRuleInfo getDirectRuleInfo(String oql) throws BOSException, EASBizException;
    public DirectRuleCollection getDirectRuleCollection() throws BOSException;
    public DirectRuleCollection getDirectRuleCollection(EntityViewInfo view) throws BOSException;
    public DirectRuleCollection getDirectRuleCollection(String oql) throws BOSException;
}