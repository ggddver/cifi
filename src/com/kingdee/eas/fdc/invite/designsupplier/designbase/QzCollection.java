package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class QzCollection extends AbstractObjectCollection 
{
    public QzCollection()
    {
        super(QzInfo.class);
    }
    public boolean add(QzInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(QzCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(QzInfo item)
    {
        return removeObject(item);
    }
    public QzInfo get(int index)
    {
        return(QzInfo)getObject(index);
    }
    public QzInfo get(Object key)
    {
        return(QzInfo)getObject(key);
    }
    public void set(int index, QzInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(QzInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(QzInfo item)
    {
        return super.indexOf(item);
    }
}