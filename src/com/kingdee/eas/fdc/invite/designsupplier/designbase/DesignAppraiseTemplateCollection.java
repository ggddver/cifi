package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignAppraiseTemplateCollection extends AbstractObjectCollection 
{
    public DesignAppraiseTemplateCollection()
    {
        super(DesignAppraiseTemplateInfo.class);
    }
    public boolean add(DesignAppraiseTemplateInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignAppraiseTemplateCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignAppraiseTemplateInfo item)
    {
        return removeObject(item);
    }
    public DesignAppraiseTemplateInfo get(int index)
    {
        return(DesignAppraiseTemplateInfo)getObject(index);
    }
    public DesignAppraiseTemplateInfo get(Object key)
    {
        return(DesignAppraiseTemplateInfo)getObject(key);
    }
    public void set(int index, DesignAppraiseTemplateInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignAppraiseTemplateInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignAppraiseTemplateInfo item)
    {
        return super.indexOf(item);
    }
}