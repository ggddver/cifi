package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DirectRuleTreeCollection extends AbstractObjectCollection 
{
    public DirectRuleTreeCollection()
    {
        super(DirectRuleTreeInfo.class);
    }
    public boolean add(DirectRuleTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DirectRuleTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DirectRuleTreeInfo item)
    {
        return removeObject(item);
    }
    public DirectRuleTreeInfo get(int index)
    {
        return(DirectRuleTreeInfo)getObject(index);
    }
    public DirectRuleTreeInfo get(Object key)
    {
        return(DirectRuleTreeInfo)getObject(key);
    }
    public void set(int index, DirectRuleTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DirectRuleTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DirectRuleTreeInfo item)
    {
        return super.indexOf(item);
    }
}