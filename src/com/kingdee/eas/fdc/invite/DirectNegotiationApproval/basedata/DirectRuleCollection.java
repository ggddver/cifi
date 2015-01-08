package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DirectRuleCollection extends AbstractObjectCollection 
{
    public DirectRuleCollection()
    {
        super(DirectRuleInfo.class);
    }
    public boolean add(DirectRuleInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DirectRuleCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DirectRuleInfo item)
    {
        return removeObject(item);
    }
    public DirectRuleInfo get(int index)
    {
        return(DirectRuleInfo)getObject(index);
    }
    public DirectRuleInfo get(Object key)
    {
        return(DirectRuleInfo)getObject(key);
    }
    public void set(int index, DirectRuleInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DirectRuleInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DirectRuleInfo item)
    {
        return super.indexOf(item);
    }
}