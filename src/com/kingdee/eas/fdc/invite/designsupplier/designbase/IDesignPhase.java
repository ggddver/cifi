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

public interface IDesignPhase extends IDataBase
{
    public DesignPhaseInfo getDesignPhaseInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignPhaseInfo getDesignPhaseInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignPhaseInfo getDesignPhaseInfo(String oql) throws BOSException, EASBizException;
    public DesignPhaseCollection getDesignPhaseCollection() throws BOSException;
    public DesignPhaseCollection getDesignPhaseCollection(EntityViewInfo view) throws BOSException;
    public DesignPhaseCollection getDesignPhaseCollection(String oql) throws BOSException;
}