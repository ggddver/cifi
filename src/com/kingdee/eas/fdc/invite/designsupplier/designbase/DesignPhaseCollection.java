package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignPhaseCollection extends AbstractObjectCollection 
{
    public DesignPhaseCollection()
    {
        super(DesignPhaseInfo.class);
    }
    public boolean add(DesignPhaseInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignPhaseCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignPhaseInfo item)
    {
        return removeObject(item);
    }
    public DesignPhaseInfo get(int index)
    {
        return(DesignPhaseInfo)getObject(index);
    }
    public DesignPhaseInfo get(Object key)
    {
        return(DesignPhaseInfo)getObject(key);
    }
    public void set(int index, DesignPhaseInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignPhaseInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignPhaseInfo item)
    {
        return super.indexOf(item);
    }
}