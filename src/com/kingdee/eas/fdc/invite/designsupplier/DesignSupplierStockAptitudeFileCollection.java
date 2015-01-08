package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierStockAptitudeFileCollection extends AbstractObjectCollection 
{
    public DesignSupplierStockAptitudeFileCollection()
    {
        super(DesignSupplierStockAptitudeFileInfo.class);
    }
    public boolean add(DesignSupplierStockAptitudeFileInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierStockAptitudeFileCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierStockAptitudeFileInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierStockAptitudeFileInfo get(int index)
    {
        return(DesignSupplierStockAptitudeFileInfo)getObject(index);
    }
    public DesignSupplierStockAptitudeFileInfo get(Object key)
    {
        return(DesignSupplierStockAptitudeFileInfo)getObject(key);
    }
    public void set(int index, DesignSupplierStockAptitudeFileInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierStockAptitudeFileInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierStockAptitudeFileInfo item)
    {
        return super.indexOf(item);
    }
}