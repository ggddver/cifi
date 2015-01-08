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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;

public interface IDesignAccreditationType extends IDataBase
{
    public DesignAccreditationTypeInfo getDesignAccreditationTypeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignAccreditationTypeInfo getDesignAccreditationTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignAccreditationTypeInfo getDesignAccreditationTypeInfo(String oql) throws BOSException, EASBizException;
    public DesignAccreditationTypeCollection getDesignAccreditationTypeCollection() throws BOSException;
    public DesignAccreditationTypeCollection getDesignAccreditationTypeCollection(EntityViewInfo view) throws BOSException;
    public DesignAccreditationTypeCollection getDesignAccreditationTypeCollection(String oql) throws BOSException;
}