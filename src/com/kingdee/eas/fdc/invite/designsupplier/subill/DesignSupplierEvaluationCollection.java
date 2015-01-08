package com.kingdee.eas.fdc.invite.designsupplier.subill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierEvaluationCollection extends AbstractObjectCollection 
{
    public DesignSupplierEvaluationCollection()
    {
        super(DesignSupplierEvaluationInfo.class);
    }
    public boolean add(DesignSupplierEvaluationInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierEvaluationCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierEvaluationInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierEvaluationInfo get(int index)
    {
        return(DesignSupplierEvaluationInfo)getObject(index);
    }
    public DesignSupplierEvaluationInfo get(Object key)
    {
        return(DesignSupplierEvaluationInfo)getObject(key);
    }
    public void set(int index, DesignSupplierEvaluationInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierEvaluationInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierEvaluationInfo item)
    {
        return super.indexOf(item);
    }
}