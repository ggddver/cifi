package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignAuditIndexCollection extends AbstractObjectCollection 
{
    public DesignAuditIndexCollection()
    {
        super(DesignAuditIndexInfo.class);
    }
    public boolean add(DesignAuditIndexInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignAuditIndexCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignAuditIndexInfo item)
    {
        return removeObject(item);
    }
    public DesignAuditIndexInfo get(int index)
    {
        return(DesignAuditIndexInfo)getObject(index);
    }
    public DesignAuditIndexInfo get(Object key)
    {
        return(DesignAuditIndexInfo)getObject(key);
    }
    public void set(int index, DesignAuditIndexInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignAuditIndexInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignAuditIndexInfo item)
    {
        return super.indexOf(item);
    }
}