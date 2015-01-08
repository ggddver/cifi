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

public interface IQz extends IFDCDataBase
{
    public QzInfo getQzInfo(String oql) throws BOSException, EASBizException;
    public QzInfo getQzInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public QzInfo getQzInfo(IObjectPK pk) throws BOSException, EASBizException;
    public QzCollection getQzCollection(String oql) throws BOSException;
    public QzCollection getQzCollection(EntityViewInfo view) throws BOSException;
    public QzCollection getQzCollection() throws BOSException;
    public void IsNdelete(String areaName) throws BOSException, EASBizException;
}