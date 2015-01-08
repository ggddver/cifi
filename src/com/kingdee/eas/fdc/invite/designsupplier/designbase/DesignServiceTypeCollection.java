package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignServiceTypeCollection extends AbstractObjectCollection 
{
    public DesignServiceTypeCollection()
    {
        super(DesignServiceTypeInfo.class);
    }
    public boolean add(DesignServiceTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignServiceTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignServiceTypeInfo item)
    {
        return removeObject(item);
    }
    public DesignServiceTypeInfo get(int index)
    {
        return(DesignServiceTypeInfo)getObject(index);
    }
    public DesignServiceTypeInfo get(Object key)
    {
        return(DesignServiceTypeInfo)getObject(key);
    }
    public void set(int index, DesignServiceTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignServiceTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignServiceTypeInfo item)
    {
        return super.indexOf(item);
    }
}