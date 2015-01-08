package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignBusinessModeCollection extends AbstractObjectCollection 
{
    public DesignBusinessModeCollection()
    {
        super(DesignBusinessModeInfo.class);
    }
    public boolean add(DesignBusinessModeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignBusinessModeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignBusinessModeInfo item)
    {
        return removeObject(item);
    }
    public DesignBusinessModeInfo get(int index)
    {
        return(DesignBusinessModeInfo)getObject(index);
    }
    public DesignBusinessModeInfo get(Object key)
    {
        return(DesignBusinessModeInfo)getObject(key);
    }
    public void set(int index, DesignBusinessModeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignBusinessModeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignBusinessModeInfo item)
    {
        return super.indexOf(item);
    }
}