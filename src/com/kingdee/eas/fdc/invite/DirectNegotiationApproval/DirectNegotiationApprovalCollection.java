package com.kingdee.eas.fdc.invite.DirectNegotiationApproval;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DirectNegotiationApprovalCollection extends AbstractObjectCollection 
{
    public DirectNegotiationApprovalCollection()
    {
        super(DirectNegotiationApprovalInfo.class);
    }
    public boolean add(DirectNegotiationApprovalInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DirectNegotiationApprovalCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DirectNegotiationApprovalInfo item)
    {
        return removeObject(item);
    }
    public DirectNegotiationApprovalInfo get(int index)
    {
        return(DirectNegotiationApprovalInfo)getObject(index);
    }
    public DirectNegotiationApprovalInfo get(Object key)
    {
        return(DirectNegotiationApprovalInfo)getObject(key);
    }
    public void set(int index, DirectNegotiationApprovalInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DirectNegotiationApprovalInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DirectNegotiationApprovalInfo item)
    {
        return super.indexOf(item);
    }
}