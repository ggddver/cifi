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
import com.kingdee.eas.framework.ICoreBillEntryBase;

public interface IDesignSupplierAppraiseEntry extends ICoreBillEntryBase
{
    public DesignSupplierAppraiseEntryInfo getDesignSupplierAppraiseEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignSupplierAppraiseEntryInfo getDesignSupplierAppraiseEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignSupplierAppraiseEntryInfo getDesignSupplierAppraiseEntryInfo(String oql) throws BOSException, EASBizException;
    public DesignSupplierAppraiseEntryCollection getDesignSupplierAppraiseEntryCollection() throws BOSException;
    public DesignSupplierAppraiseEntryCollection getDesignSupplierAppraiseEntryCollection(EntityViewInfo view) throws BOSException;
    public DesignSupplierAppraiseEntryCollection getDesignSupplierAppraiseEntryCollection(String oql) throws BOSException;
}