package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignQuaLevelCollection extends AbstractObjectCollection 
{
    public DesignQuaLevelCollection()
    {
        super(DesignQuaLevelInfo.class);
    }
    public boolean add(DesignQuaLevelInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignQuaLevelCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignQuaLevelInfo item)
    {
        return removeObject(item);
    }
    public DesignQuaLevelInfo get(int index)
    {
        return(DesignQuaLevelInfo)getObject(index);
    }
    public DesignQuaLevelInfo get(Object key)
    {
        return(DesignQuaLevelInfo)getObject(key);
    }
    public void set(int index, DesignQuaLevelInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignQuaLevelInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignQuaLevelInfo item)
    {
        return super.indexOf(item);
    }
}