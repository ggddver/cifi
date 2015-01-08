package com.kingdee.eas.fdc.invite.designsupplier;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DesignSupplierStockLinkPersonCollection extends AbstractObjectCollection 
{
    public DesignSupplierStockLinkPersonCollection()
    {
        super(DesignSupplierStockLinkPersonInfo.class);
    }
    public boolean add(DesignSupplierStockLinkPersonInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DesignSupplierStockLinkPersonCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DesignSupplierStockLinkPersonInfo item)
    {
        return removeObject(item);
    }
    public DesignSupplierStockLinkPersonInfo get(int index)
    {
        return(DesignSupplierStockLinkPersonInfo)getObject(index);
    }
    public DesignSupplierStockLinkPersonInfo get(Object key)
    {
        return(DesignSupplierStockLinkPersonInfo)getObject(key);
    }
    public void set(int index, DesignSupplierStockLinkPersonInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DesignSupplierStockLinkPersonInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DesignSupplierStockLinkPersonInfo item)
    {
        return super.indexOf(item);
    }
}