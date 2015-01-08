package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignAppraiseTemplateE1Collection extends AbstractObjectCollection 
{
    public DesignAppraiseTemplateE1Collection()
    {
        super(DesignAppraiseTemplateE1Info.class);
    }
    public boolean add(DesignAppraiseTemplateE1Info item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignAppraiseTemplateE1Collection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignAppraiseTemplateE1Info item)
    {
        return removeObject(item);
    }
    public DesignAppraiseTemplateE1Info get(int index)
    {
        return(DesignAppraiseTemplateE1Info)getObject(index);
    }
    public DesignAppraiseTemplateE1Info get(Object key)
    {
        return(DesignAppraiseTemplateE1Info)getObject(key);
    }
    public void set(int index, DesignAppraiseTemplateE1Info item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignAppraiseTemplateE1Info item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignAppraiseTemplateE1Info item)
    {
        return super.indexOf(item);
    }
}