package com.kingdee.eas.fdc.invite.designsupplier.subill;

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

public interface IDesignSupplierAppraise extends ICoreBillBase
{
    public DesignSupplierAppraiseCollection getDesignSupplierAppraiseCollection() throws BOSException;
    public DesignSupplierAppraiseCollection getDesignSupplierAppraiseCollection(EntityViewInfo view) throws BOSException;
    public DesignSupplierAppraiseCollection getDesignSupplierAppraiseCollection(String oql) throws BOSException;
    public DesignSupplierAppraiseInfo getDesignSupplierAppraiseInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignSupplierAppraiseInfo getDesignSupplierAppraiseInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignSupplierAppraiseInfo getDesignSupplierAppraiseInfo(String oql) throws BOSException, EASBizException;
    public void audit(DesignSupplierAppraiseInfo model) throws BOSException;
    public void unAudit(DesignSupplierAppraiseInfo model) throws BOSException;
}