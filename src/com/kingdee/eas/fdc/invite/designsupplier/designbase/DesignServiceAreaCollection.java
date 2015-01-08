package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignServiceAreaCollection extends AbstractObjectCollection 
{
    public DesignServiceAreaCollection()
    {
        super(DesignServiceAreaInfo.class);
    }
    public boolean add(DesignServiceAreaInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignServiceAreaCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignServiceAreaInfo item)
    {
        return removeObject(item);
    }
    public DesignServiceAreaInfo get(int index)
    {
        return(DesignServiceAreaInfo)getObject(index);
    }
    public DesignServiceAreaInfo get(Object key)
    {
        return(DesignServiceAreaInfo)getObject(key);
    }
    public void set(int index, DesignServiceAreaInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignServiceAreaInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignServiceAreaInfo item)
    {
        return super.indexOf(item);
    }
}