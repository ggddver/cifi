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
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;

public interface IDesignAppraiseTemplateTree extends ITreeBase
{
    public DesignAppraiseTemplateTreeInfo getDesignAppraiseTemplateTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignAppraiseTemplateTreeInfo getDesignAppraiseTemplateTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignAppraiseTemplateTreeInfo getDesignAppraiseTemplateTreeInfo(String oql) throws BOSException, EASBizException;
    public DesignAppraiseTemplateTreeCollection getDesignAppraiseTemplateTreeCollection() throws BOSException;
    public DesignAppraiseTemplateTreeCollection getDesignAppraiseTemplateTreeCollection(EntityViewInfo view) throws BOSException;
    public DesignAppraiseTemplateTreeCollection getDesignAppraiseTemplateTreeCollection(String oql) throws BOSException;
}