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

public interface IDesignServiceArea extends IFDCDataBase
{
    public DesignServiceAreaInfo getDesignServiceAreaInfo(String oql) throws BOSException, EASBizException;
    public DesignServiceAreaInfo getDesignServiceAreaInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignServiceAreaInfo getDesignServiceAreaInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignServiceAreaCollection getDesignServiceAreaCollection(String oql) throws BOSException;
    public DesignServiceAreaCollection getDesignServiceAreaCollection(EntityViewInfo view) throws BOSException;
    public DesignServiceAreaCollection getDesignServiceAreaCollection() throws BOSException;
    public void IsNdelete(String areaName) throws BOSException, EASBizException;
}