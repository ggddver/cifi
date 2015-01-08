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

public interface IReceiption extends ICoreBillBase
{
    public ReceiptionCollection getReceiptionCollection() throws BOSException;
    public ReceiptionCollection getReceiptionCollection(EntityViewInfo view) throws BOSException;
    public ReceiptionCollection getReceiptionCollection(String oql) throws BOSException;
    public ReceiptionInfo getReceiptionInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ReceiptionInfo getReceiptionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ReceiptionInfo getReceiptionInfo(String oql) throws BOSException, EASBizException;
    public void audit(ReceiptionInfo model) throws BOSException;
    public void unAudit(ReceiptionInfo model) throws BOSException;
    public void close(ReceiptionInfo model) throws BOSException;
    public void unclose(ReceiptionInfo model) throws BOSException;
}