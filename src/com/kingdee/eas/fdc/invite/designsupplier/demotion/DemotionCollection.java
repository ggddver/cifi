package com.kingdee.eas.fdc.invite.designsupplier.demotion;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DemotionCollection extends AbstractObjectCollection 
{
    public DemotionCollection()
    {
        super(DemotionInfo.class);
    }
    public boolean add(DemotionInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DemotionCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DemotionInfo item)
    {
        return removeObject(item);
    }
    public DemotionInfo get(int index)
    {
        return(DemotionInfo)getObject(index);
    }
    public DemotionInfo get(Object key)
    {
        return(DemotionInfo)getObject(key);
    }
    public void set(int index, DemotionInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DemotionInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DemotionInfo item)
    {
        return super.indexOf(item);
    }
}