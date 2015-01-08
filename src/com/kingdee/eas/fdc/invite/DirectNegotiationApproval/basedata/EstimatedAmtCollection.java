package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EstimatedAmtCollection extends AbstractObjectCollection 
{
    public EstimatedAmtCollection()
    {
        super(EstimatedAmtInfo.class);
    }
    public boolean add(EstimatedAmtInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EstimatedAmtCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EstimatedAmtInfo item)
    {
        return removeObject(item);
    }
    public EstimatedAmtInfo get(int index)
    {
        return(EstimatedAmtInfo)getObject(index);
    }
    public EstimatedAmtInfo get(Object key)
    {
        return(EstimatedAmtInfo)getObject(key);
    }
    public void set(int index, EstimatedAmtInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EstimatedAmtInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EstimatedAmtInfo item)
    {
        return super.indexOf(item);
    }
}