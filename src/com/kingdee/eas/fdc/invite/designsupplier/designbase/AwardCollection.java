package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AwardCollection extends AbstractObjectCollection 
{
    public AwardCollection()
    {
        super(AwardInfo.class);
    }
    public boolean add(AwardInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AwardCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AwardInfo item)
    {
        return removeObject(item);
    }
    public AwardInfo get(int index)
    {
        return(AwardInfo)getObject(index);
    }
    public AwardInfo get(Object key)
    {
        return(AwardInfo)getObject(key);
    }
    public void set(int index, AwardInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AwardInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AwardInfo item)
    {
        return super.indexOf(item);
    }
}