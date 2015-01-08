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
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;

public interface IDirectRuleTree extends ITreeBase
{
    public DirectRuleTreeInfo getDirectRuleTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DirectRuleTreeInfo getDirectRuleTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DirectRuleTreeInfo getDirectRuleTreeInfo(String oql) throws BOSException, EASBizException;
    public DirectRuleTreeCollection getDirectRuleTreeCollection() throws BOSException;
    public DirectRuleTreeCollection getDirectRuleTreeCollection(EntityViewInfo view) throws BOSException;
    public DirectRuleTreeCollection getDirectRuleTreeCollection(String oql) throws BOSException;
}