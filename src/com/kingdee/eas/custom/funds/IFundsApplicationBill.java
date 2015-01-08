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

public interface IFundsApplicationBill extends ICoreBillBase
{
    public FundsApplicationBillCollection getFundsApplicationBillCollection() throws BOSException;
    public FundsApplicationBillCollection getFundsApplicationBillCollection(EntityViewInfo view) throws BOSException;
    public FundsApplicationBillCollection getFundsApplicationBillCollection(String oql) throws BOSException;
    public FundsApplicationBillInfo getFundsApplicationBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FundsApplicationBillInfo getFundsApplicationBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FundsApplicationBillInfo getFundsApplicationBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(FundsApplicationBillInfo model) throws BOSException;
    public void unAudit(FundsApplicationBillInfo model) throws BOSException;
}