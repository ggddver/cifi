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
import com.kingdee.eas.framework.ICoreBillEntryBase;

public interface IFundsApplicationBillEntry extends ICoreBillEntryBase
{
    public FundsApplicationBillEntryInfo getFundsApplicationBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FundsApplicationBillEntryInfo getFundsApplicationBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FundsApplicationBillEntryInfo getFundsApplicationBillEntryInfo(String oql) throws BOSException, EASBizException;
    public FundsApplicationBillEntryCollection getFundsApplicationBillEntryCollection() throws BOSException;
    public FundsApplicationBillEntryCollection getFundsApplicationBillEntryCollection(EntityViewInfo view) throws BOSException;
    public FundsApplicationBillEntryCollection getFundsApplicationBillEntryCollection(String oql) throws BOSException;
}