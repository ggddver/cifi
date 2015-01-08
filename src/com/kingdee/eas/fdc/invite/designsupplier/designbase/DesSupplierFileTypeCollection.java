package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesSupplierFileTypeCollection extends AbstractObjectCollection 
{
    public DesSupplierFileTypeCollection()
    {
        super(DesSupplierFileTypeInfo.class);
    }
    public boolean add(DesSupplierFileTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesSupplierFileTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesSupplierFileTypeInfo item)
    {
        return removeObject(item);
    }
    public DesSupplierFileTypeInfo get(int index)
    {
        return(DesSupplierFileTypeInfo)getObject(index);
    }
    public DesSupplierFileTypeInfo get(Object key)
    {
        return(DesSupplierFileTypeInfo)getObject(key);
    }
    public void set(int index, DesSupplierFileTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesSupplierFileTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesSupplierFileTypeInfo item)
    {
        return super.indexOf(item);
    }
}