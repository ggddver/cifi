package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierStockCollection extends AbstractObjectCollection 
{
    public DesignSupplierStockCollection()
    {
        super(DesignSupplierStockInfo.class);
    }
    public boolean add(DesignSupplierStockInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierStockCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierStockInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierStockInfo get(int index)
    {
        return(DesignSupplierStockInfo)getObject(index);
    }
    public DesignSupplierStockInfo get(Object key)
    {
        return(DesignSupplierStockInfo)getObject(key);
    }
    public void set(int index, DesignSupplierStockInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierStockInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierStockInfo item)
    {
        return super.indexOf(item);
    }
}