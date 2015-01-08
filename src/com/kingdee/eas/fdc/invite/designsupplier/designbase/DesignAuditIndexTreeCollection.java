package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignAuditIndexTreeCollection extends AbstractObjectCollection 
{
    public DesignAuditIndexTreeCollection()
    {
        super(DesignAuditIndexTreeInfo.class);
    }
    public boolean add(DesignAuditIndexTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignAuditIndexTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignAuditIndexTreeInfo item)
    {
        return removeObject(item);
    }
    public DesignAuditIndexTreeInfo get(int index)
    {
        return(DesignAuditIndexTreeInfo)getObject(index);
    }
    public DesignAuditIndexTreeInfo get(Object key)
    {
        return(DesignAuditIndexTreeInfo)getObject(key);
    }
    public void set(int index, DesignAuditIndexTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignAuditIndexTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignAuditIndexTreeInfo item)
    {
        return super.indexOf(item);
    }
}