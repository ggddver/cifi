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

public interface IEstimatedAmt extends IDataBase
{
    public EstimatedAmtInfo getEstimatedAmtInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EstimatedAmtInfo getEstimatedAmtInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EstimatedAmtInfo getEstimatedAmtInfo(String oql) throws BOSException, EASBizException;
    public EstimatedAmtCollection getEstimatedAmtCollection() throws BOSException;
    public EstimatedAmtCollection getEstimatedAmtCollection(EntityViewInfo view) throws BOSException;
    public EstimatedAmtCollection getEstimatedAmtCollection(String oql) throws BOSException;
}