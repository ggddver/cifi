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

public interface IDesignVisibility extends IDataBase
{
    public DesignVisibilityInfo getDesignVisibilityInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignVisibilityInfo getDesignVisibilityInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignVisibilityInfo getDesignVisibilityInfo(String oql) throws BOSException, EASBizException;
    public DesignVisibilityCollection getDesignVisibilityCollection() throws BOSException;
    public DesignVisibilityCollection getDesignVisibilityCollection(EntityViewInfo view) throws BOSException;
    public DesignVisibilityCollection getDesignVisibilityCollection(String oql) throws BOSException;
}