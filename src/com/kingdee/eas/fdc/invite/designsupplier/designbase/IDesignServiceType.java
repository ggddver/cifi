package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.bos.util.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.fdc.basedata.IFDCTreeBaseData;

public interface IDesignServiceType extends IFDCTreeBaseData
{
    public DesignServiceTypeInfo getDesignServiceTypeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignServiceTypeInfo getDesignServiceTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignServiceTypeInfo getDesignServiceTypeInfo(String oql) throws BOSException, EASBizException;
    public DesignServiceTypeCollection getDesignServiceTypeCollection(String oql) throws BOSException;
    public DesignServiceTypeCollection getDesignServiceTypeCollection() throws BOSException;
    public DesignServiceTypeCollection getDesignServiceTypeCollection(EntityViewInfo view) throws BOSException;
}