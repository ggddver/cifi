package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSelectSupplierDBCollection extends AbstractObjectCollection 
{
    public DesignSelectSupplierDBCollection()
    {
        super(DesignSelectSupplierDBInfo.class);
    }
    public boolean add(DesignSelectSupplierDBInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSelectSupplierDBCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSelectSupplierDBInfo item)
    {
        return removeObject(item);
    }
    public DesignSelectSupplierDBInfo get(int index)
    {
        return(DesignSelectSupplierDBInfo)getObject(index);
    }
    public DesignSelectSupplierDBInfo get(Object key)
    {
        return(DesignSelectSupplierDBInfo)getObject(key);
    }
    public void set(int index, DesignSelectSupplierDBInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSelectSupplierDBInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSelectSupplierDBInfo item)
    {
        return super.indexOf(item);
    }
}