package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierStockSupplierPersonEntryCollection extends AbstractObjectCollection 
{
    public DesignSupplierStockSupplierPersonEntryCollection()
    {
        super(DesignSupplierStockSupplierPersonEntryInfo.class);
    }
    public boolean add(DesignSupplierStockSupplierPersonEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierStockSupplierPersonEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierStockSupplierPersonEntryInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierStockSupplierPersonEntryInfo get(int index)
    {
        return(DesignSupplierStockSupplierPersonEntryInfo)getObject(index);
    }
    public DesignSupplierStockSupplierPersonEntryInfo get(Object key)
    {
        return(DesignSupplierStockSupplierPersonEntryInfo)getObject(key);
    }
    public void set(int index, DesignSupplierStockSupplierPersonEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierStockSupplierPersonEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierStockSupplierPersonEntryInfo item)
    {
        return super.indexOf(item);
    }
}