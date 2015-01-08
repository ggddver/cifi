package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierStockAchievementCollection extends AbstractObjectCollection 
{
    public DesignSupplierStockAchievementCollection()
    {
        super(DesignSupplierStockAchievementInfo.class);
    }
    public boolean add(DesignSupplierStockAchievementInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierStockAchievementCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierStockAchievementInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierStockAchievementInfo get(int index)
    {
        return(DesignSupplierStockAchievementInfo)getObject(index);
    }
    public DesignSupplierStockAchievementInfo get(Object key)
    {
        return(DesignSupplierStockAchievementInfo)getObject(key);
    }
    public void set(int index, DesignSupplierStockAchievementInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierStockAchievementInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierStockAchievementInfo item)
    {
        return super.indexOf(item);
    }
}