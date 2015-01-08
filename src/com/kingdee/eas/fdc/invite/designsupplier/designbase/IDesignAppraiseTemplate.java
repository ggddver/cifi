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

public interface IDesignAppraiseTemplate extends IDataBase
{
    public DesignAppraiseTemplateInfo getDesignAppraiseTemplateInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignAppraiseTemplateInfo getDesignAppraiseTemplateInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignAppraiseTemplateInfo getDesignAppraiseTemplateInfo(String oql) throws BOSException, EASBizException;
    public DesignAppraiseTemplateCollection getDesignAppraiseTemplateCollection() throws BOSException;
    public DesignAppraiseTemplateCollection getDesignAppraiseTemplateCollection(EntityViewInfo view) throws BOSException;
    public DesignAppraiseTemplateCollection getDesignAppraiseTemplateCollection(String oql) throws BOSException;
    public void audit(DesignAppraiseTemplateInfo model) throws BOSException;
    public void unaudit(DesignAppraiseTemplateInfo model) throws BOSException;
}