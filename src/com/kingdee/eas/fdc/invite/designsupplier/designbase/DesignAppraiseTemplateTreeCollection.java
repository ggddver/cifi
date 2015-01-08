package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignAppraiseTemplateTreeCollection extends AbstractObjectCollection 
{
    public DesignAppraiseTemplateTreeCollection()
    {
        super(DesignAppraiseTemplateTreeInfo.class);
    }
    public boolean add(DesignAppraiseTemplateTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignAppraiseTemplateTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignAppraiseTemplateTreeInfo item)
    {
        return removeObject(item);
    }
    public DesignAppraiseTemplateTreeInfo get(int index)
    {
        return(DesignAppraiseTemplateTreeInfo)getObject(index);
    }
    public DesignAppraiseTemplateTreeInfo get(Object key)
    {
        return(DesignAppraiseTemplateTreeInfo)getObject(key);
    }
    public void set(int index, DesignAppraiseTemplateTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignAppraiseTemplateTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignAppraiseTemplateTreeInfo item)
    {
        return super.indexOf(item);
    }
}