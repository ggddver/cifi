package com.kingdee.eas.fdc.invite.designsupplier.demotion;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DemotionEntryCollection extends AbstractObjectCollection 
{
    public DemotionEntryCollection()
    {
        super(DemotionEntryInfo.class);
    }
    public boolean add(DemotionEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DemotionEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DemotionEntryInfo item)
    {
        return removeObject(item);
    }
    public DemotionEntryInfo get(int index)
    {
        return(DemotionEntryInfo)getObject(index);
    }
    public DemotionEntryInfo get(Object key)
    {
        return(DemotionEntryInfo)getObject(key);
    }
    public void set(int index, DemotionEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DemotionEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DemotionEntryInfo item)
    {
        return super.indexOf(item);
    }
}