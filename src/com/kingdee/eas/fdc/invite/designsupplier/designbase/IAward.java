package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.fdc.basedata.IFDCDataBase;
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

public interface IAward extends IFDCDataBase
{
    public AwardInfo getAwardInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AwardInfo getAwardInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AwardInfo getAwardInfo(String oql) throws BOSException, EASBizException;
    public AwardCollection getAwardCollection() throws BOSException;
    public AwardCollection getAwardCollection(EntityViewInfo view) throws BOSException;
    public AwardCollection getAwardCollection(String oql) throws BOSException;
}