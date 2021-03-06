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
import com.kingdee.eas.framework.ICoreBillEntryBase;

public interface IDemotionEntry extends ICoreBillEntryBase
{
    public DemotionEntryInfo getDemotionEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DemotionEntryInfo getDemotionEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DemotionEntryInfo getDemotionEntryInfo(String oql) throws BOSException, EASBizException;
    public DemotionEntryCollection getDemotionEntryCollection() throws BOSException;
    public DemotionEntryCollection getDemotionEntryCollection(EntityViewInfo view) throws BOSException;
    public DemotionEntryCollection getDemotionEntryCollection(String oql) throws BOSException;
}