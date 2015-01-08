package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierStockYearSaleCollection extends AbstractObjectCollection 
{
    public DesignSupplierStockYearSaleCollection()
    {
        super(DesignSupplierStockYearSaleInfo.class);
    }
    public boolean add(DesignSupplierStockYearSaleInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierStockYearSaleCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierStockYearSaleInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierStockYearSaleInfo get(int index)
    {
        return(DesignSupplierStockYearSaleInfo)getObject(index);
    }
    public DesignSupplierStockYearSaleInfo get(Object key)
    {
        return(DesignSupplierStockYearSaleInfo)getObject(key);
    }
    public void set(int index, DesignSupplierStockYearSaleInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierStockYearSaleInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierStockYearSaleInfo item)
    {
        return super.indexOf(item);
    }
}