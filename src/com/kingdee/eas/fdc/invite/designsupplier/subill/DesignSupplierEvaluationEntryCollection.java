package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierEvaluationEntryCollection extends AbstractObjectCollection 
{
    public DesignSupplierEvaluationEntryCollection()
    {
        super(DesignSupplierEvaluationEntryInfo.class);
    }
    public boolean add(DesignSupplierEvaluationEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierEvaluationEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierEvaluationEntryInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierEvaluationEntryInfo get(int index)
    {
        return(DesignSupplierEvaluationEntryInfo)getObject(index);
    }
    public DesignSupplierEvaluationEntryInfo get(Object key)
    {
        return(DesignSupplierEvaluationEntryInfo)getObject(key);
    }
    public void set(int index, DesignSupplierEvaluationEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierEvaluationEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierEvaluationEntryInfo item)
    {
        return super.indexOf(item);
    }
}