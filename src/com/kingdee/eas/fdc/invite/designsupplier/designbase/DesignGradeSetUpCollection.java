package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignGradeSetUpCollection extends AbstractObjectCollection 
{
    public DesignGradeSetUpCollection()
    {
        super(DesignGradeSetUpInfo.class);
    }
    public boolean add(DesignGradeSetUpInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignGradeSetUpCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignGradeSetUpInfo item)
    {
        return removeObject(item);
    }
    public DesignGradeSetUpInfo get(int index)
    {
        return(DesignGradeSetUpInfo)getObject(index);
    }
    public DesignGradeSetUpInfo get(Object key)
    {
        return(DesignGradeSetUpInfo)getObject(key);
    }
    public void set(int index, DesignGradeSetUpInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignGradeSetUpInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignGradeSetUpInfo item)
    {
        return super.indexOf(item);
    }
}