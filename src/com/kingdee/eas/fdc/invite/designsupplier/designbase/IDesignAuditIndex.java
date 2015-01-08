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

public interface IDesignAuditIndex extends IDataBase
{
    public DesignAuditIndexInfo getDesignAuditIndexInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignAuditIndexInfo getDesignAuditIndexInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignAuditIndexInfo getDesignAuditIndexInfo(String oql) throws BOSException, EASBizException;
    public DesignAuditIndexCollection getDesignAuditIndexCollection() throws BOSException;
    public DesignAuditIndexCollection getDesignAuditIndexCollection(EntityViewInfo view) throws BOSException;
    public DesignAuditIndexCollection getDesignAuditIndexCollection(String oql) throws BOSException;
}