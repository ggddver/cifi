package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EstimatedAmtTreeCollection extends AbstractObjectCollection 
{
    public EstimatedAmtTreeCollection()
    {
        super(EstimatedAmtTreeInfo.class);
    }
    public boolean add(EstimatedAmtTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EstimatedAmtTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EstimatedAmtTreeInfo item)
    {
        return removeObject(item);
    }
    public EstimatedAmtTreeInfo get(int index)
    {
        return(EstimatedAmtTreeInfo)getObject(index);
    }
    public EstimatedAmtTreeInfo get(Object key)
    {
        return(EstimatedAmtTreeInfo)getObject(key);
    }
    public void set(int index, EstimatedAmtTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EstimatedAmtTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EstimatedAmtTreeInfo item)
    {
        return super.indexOf(item);
    }
}