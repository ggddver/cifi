package com.kingdee.eas.fdc.invite.DirectNegotiationApproval;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DirectNegotiationApprovalEntryCollection extends AbstractObjectCollection 
{
    public DirectNegotiationApprovalEntryCollection()
    {
        super(DirectNegotiationApprovalEntryInfo.class);
    }
    public boolean add(DirectNegotiationApprovalEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DirectNegotiationApprovalEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DirectNegotiationApprovalEntryInfo item)
    {
        return removeObject(item);
    }
    public DirectNegotiationApprovalEntryInfo get(int index)
    {
        return(DirectNegotiationApprovalEntryInfo)getObject(index);
    }
    public DirectNegotiationApprovalEntryInfo get(Object key)
    {
        return(DirectNegotiationApprovalEntryInfo)getObject(key);
    }
    public void set(int index, DirectNegotiationApprovalEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DirectNegotiationApprovalEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DirectNegotiationApprovalEntryInfo item)
    {
        return super.indexOf(item);
    }
}