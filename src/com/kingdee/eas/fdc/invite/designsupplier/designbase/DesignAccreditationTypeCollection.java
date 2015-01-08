package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignAccreditationTypeCollection extends AbstractObjectCollection 
{
    public DesignAccreditationTypeCollection()
    {
        super(DesignAccreditationTypeInfo.class);
    }
    public boolean add(DesignAccreditationTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignAccreditationTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignAccreditationTypeInfo item)
    {
        return removeObject(item);
    }
    public DesignAccreditationTypeInfo get(int index)
    {
        return(DesignAccreditationTypeInfo)getObject(index);
    }
    public DesignAccreditationTypeInfo get(Object key)
    {
        return(DesignAccreditationTypeInfo)getObject(key);
    }
    public void set(int index, DesignAccreditationTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignAccreditationTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignAccreditationTypeInfo item)
    {
        return super.indexOf(item);
    }
}