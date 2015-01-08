package com.kingdee.eas.fdc.invite.designsupplier.designbase;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.fdc.basedata.IFDCDataBase;
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

public interface IDesignLevelSetUp extends IFDCDataBase
{
    public DesignLevelSetUpInfo getDesignLevelSetUpInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignLevelSetUpInfo getDesignLevelSetUpInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignLevelSetUpInfo getDesignLevelSetUpInfo(String oql) throws BOSException, EASBizException;
    public DesignLevelSetUpCollection getDesignLevelSetUpCollection() throws BOSException;
    public DesignLevelSetUpCollection getDesignLevelSetUpCollection(EntityViewInfo view) throws BOSException;
    public DesignLevelSetUpCollection getDesignLevelSetUpCollection(String oql) throws BOSException;
}