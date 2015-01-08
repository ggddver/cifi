package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierAttachListCollection extends AbstractObjectCollection 
{
    public DesignSupplierAttachListCollection()
    {
        super(DesignSupplierAttachListInfo.class);
    }
    public boolean add(DesignSupplierAttachListInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierAttachListCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierAttachListInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierAttachListInfo get(int index)
    {
        return(DesignSupplierAttachListInfo)getObject(index);
    }
    public DesignSupplierAttachListInfo get(Object key)
    {
        return(DesignSupplierAttachListInfo)getObject(key);
    }
    public void set(int index, DesignSupplierAttachListInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierAttachListInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierAttachListInfo item)
    {
        return super.indexOf(item);
    }
}