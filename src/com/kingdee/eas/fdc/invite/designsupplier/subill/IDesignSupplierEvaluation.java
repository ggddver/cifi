package com.kingdee.eas.fdc.invite.designsupplier.subill;

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
import com.kingdee.eas.framework.ICoreBillBase;

public interface IDesignSupplierEvaluation extends ICoreBillBase
{
    public DesignSupplierEvaluationCollection getDesignSupplierEvaluationCollection() throws BOSException;
    public DesignSupplierEvaluationCollection getDesignSupplierEvaluationCollection(EntityViewInfo view) throws BOSException;
    public DesignSupplierEvaluationCollection getDesignSupplierEvaluationCollection(String oql) throws BOSException;
    public DesignSupplierEvaluationInfo getDesignSupplierEvaluationInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignSupplierEvaluationInfo getDesignSupplierEvaluationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignSupplierEvaluationInfo getDesignSupplierEvaluationInfo(String oql) throws BOSException, EASBizException;
    public void audit(DesignSupplierEvaluationInfo model) throws BOSException;
    public void unAudit(DesignSupplierEvaluationInfo model) throws BOSException;
}