package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignStorageNumberCollection extends AbstractObjectCollection 
{
    public DesignStorageNumberCollection()
    {
        super(DesignStorageNumberInfo.class);
    }
    public boolean add(DesignStorageNumberInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignStorageNumberCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignStorageNumberInfo item)
    {
        return removeObject(item);
    }
    public DesignStorageNumberInfo get(int index)
    {
        return(DesignStorageNumberInfo)getObject(index);
    }
    public DesignStorageNumberInfo get(Object key)
    {
        return(DesignStorageNumberInfo)getObject(key);
    }
    public void set(int index, DesignStorageNumberInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignStorageNumberInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignStorageNumberInfo item)
    {
        return super.indexOf(item);
    }
}