package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierStockSupplierAttachListEntryCollection extends AbstractObjectCollection 
{
    public DesignSupplierStockSupplierAttachListEntryCollection()
    {
        super(DesignSupplierStockSupplierAttachListEntryInfo.class);
    }
    public boolean add(DesignSupplierStockSupplierAttachListEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierStockSupplierAttachListEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierStockSupplierAttachListEntryInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierStockSupplierAttachListEntryInfo get(int index)
    {
        return(DesignSupplierStockSupplierAttachListEntryInfo)getObject(index);
    }
    public DesignSupplierStockSupplierAttachListEntryInfo get(Object key)
    {
        return(DesignSupplierStockSupplierAttachListEntryInfo)getObject(key);
    }
    public void set(int index, DesignSupplierStockSupplierAttachListEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierStockSupplierAttachListEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierStockSupplierAttachListEntryInfo item)
    {
        return super.indexOf(item);
    }
}