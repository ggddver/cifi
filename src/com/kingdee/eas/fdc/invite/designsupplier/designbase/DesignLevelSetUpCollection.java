package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignLevelSetUpCollection extends AbstractObjectCollection 
{
    public DesignLevelSetUpCollection()
    {
        super(DesignLevelSetUpInfo.class);
    }
    public boolean add(DesignLevelSetUpInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignLevelSetUpCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignLevelSetUpInfo item)
    {
        return removeObject(item);
    }
    public DesignLevelSetUpInfo get(int index)
    {
        return(DesignLevelSetUpInfo)getObject(index);
    }
    public DesignLevelSetUpInfo get(Object key)
    {
        return(DesignLevelSetUpInfo)getObject(key);
    }
    public void set(int index, DesignLevelSetUpInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignLevelSetUpInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignLevelSetUpInfo item)
    {
        return super.indexOf(item);
    }
}