package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierStockProjectCollection extends AbstractObjectCollection 
{
    public DesignSupplierStockProjectCollection()
    {
        super(DesignSupplierStockProjectInfo.class);
    }
    public boolean add(DesignSupplierStockProjectInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierStockProjectCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierStockProjectInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierStockProjectInfo get(int index)
    {
        return(DesignSupplierStockProjectInfo)getObject(index);
    }
    public DesignSupplierStockProjectInfo get(Object key)
    {
        return(DesignSupplierStockProjectInfo)getObject(key);
    }
    public void set(int index, DesignSupplierStockProjectInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierStockProjectInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierStockProjectInfo item)
    {
        return super.indexOf(item);
    }
}