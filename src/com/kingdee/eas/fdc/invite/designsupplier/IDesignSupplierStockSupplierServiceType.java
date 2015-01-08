package com.kingdee.eas.fdc.invite.designsupplier;

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

public interface IDesignSupplierStockSupplierServiceType extends ICoreBillEntryBase
{
    public DesignSupplierStockSupplierServiceTypeInfo getDesignSupplierStockSupplierServiceTypeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignSupplierStockSupplierServiceTypeInfo getDesignSupplierStockSupplierServiceTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignSupplierStockSupplierServiceTypeInfo getDesignSupplierStockSupplierServiceTypeInfo(String oql) throws BOSException, EASBizException;
    public DesignSupplierStockSupplierServiceTypeCollection getDesignSupplierStockSupplierServiceTypeCollection() throws BOSException;
    public DesignSupplierStockSupplierServiceTypeCollection getDesignSupplierStockSupplierServiceTypeCollection(EntityViewInfo view) throws BOSException;
    public DesignSupplierStockSupplierServiceTypeCollection getDesignSupplierStockSupplierServiceTypeCollection(String oql) throws BOSException;
}