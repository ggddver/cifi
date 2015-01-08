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

public interface IDesignSupplierStockYearSale extends ICoreBillEntryBase
{
    public DesignSupplierStockYearSaleInfo getDesignSupplierStockYearSaleInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignSupplierStockYearSaleInfo getDesignSupplierStockYearSaleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignSupplierStockYearSaleInfo getDesignSupplierStockYearSaleInfo(String oql) throws BOSException, EASBizException;
    public DesignSupplierStockYearSaleCollection getDesignSupplierStockYearSaleCollection() throws BOSException;
    public DesignSupplierStockYearSaleCollection getDesignSupplierStockYearSaleCollection(EntityViewInfo view) throws BOSException;
    public DesignSupplierStockYearSaleCollection getDesignSupplierStockYearSaleCollection(String oql) throws BOSException;
}