package com.kingdee.eas.fdc.invite.designsupplier.demotion;

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

public interface IDemotion extends ICoreBillBase
{
    public DemotionCollection getDemotionCollection() throws BOSException;
    public DemotionCollection getDemotionCollection(EntityViewInfo view) throws BOSException;
    public DemotionCollection getDemotionCollection(String oql) throws BOSException;
    public DemotionInfo getDemotionInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DemotionInfo getDemotionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DemotionInfo getDemotionInfo(String oql) throws BOSException, EASBizException;
    public void audit(DemotionInfo model) throws BOSException;
    public void unAudit(DemotionInfo model) throws BOSException;
}