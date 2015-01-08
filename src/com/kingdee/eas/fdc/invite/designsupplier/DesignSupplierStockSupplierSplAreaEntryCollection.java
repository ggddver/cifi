package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierStockSupplierSplAreaEntryCollection extends AbstractObjectCollection 
{
    public DesignSupplierStockSupplierSplAreaEntryCollection()
    {
        super(DesignSupplierStockSupplierSplAreaEntryInfo.class);
    }
    public boolean add(DesignSupplierStockSupplierSplAreaEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierStockSupplierSplAreaEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierStockSupplierSplAreaEntryInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierStockSupplierSplAreaEntryInfo get(int index)
    {
        return(DesignSupplierStockSupplierSplAreaEntryInfo)getObject(index);
    }
    public DesignSupplierStockSupplierSplAreaEntryInfo get(Object key)
    {
        return(DesignSupplierStockSupplierSplAreaEntryInfo)getObject(key);
    }
    public void set(int index, DesignSupplierStockSupplierSplAreaEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierStockSupplierSplAreaEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierStockSupplierSplAreaEntryInfo item)
    {
        return super.indexOf(item);
    }
}