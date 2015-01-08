package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignVisibilityCollection extends AbstractObjectCollection 
{
    public DesignVisibilityCollection()
    {
        super(DesignVisibilityInfo.class);
    }
    public boolean add(DesignVisibilityInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignVisibilityCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignVisibilityInfo item)
    {
        return removeObject(item);
    }
    public DesignVisibilityInfo get(int index)
    {
        return(DesignVisibilityInfo)getObject(index);
    }
    public DesignVisibilityInfo get(Object key)
    {
        return(DesignVisibilityInfo)getObject(key);
    }
    public void set(int index, DesignVisibilityInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignVisibilityInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignVisibilityInfo item)
    {
        return super.indexOf(item);
    }
}