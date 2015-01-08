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
import com.kingdee.eas.framework.ICoreBillEntryBase;

public interface IDesignSupplierEvaluationEntry extends ICoreBillEntryBase
{
    public DesignSupplierEvaluationEntryInfo getDesignSupplierEvaluationEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DesignSupplierEvaluationEntryInfo getDesignSupplierEvaluationEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DesignSupplierEvaluationEntryInfo getDesignSupplierEvaluationEntryInfo(String oql) throws BOSException, EASBizException;
    public DesignSupplierEvaluationEntryCollection getDesignSupplierEvaluationEntryCollection() throws BOSException;
    public DesignSupplierEvaluationEntryCollection getDesignSupplierEvaluationEntryCollection(EntityViewInfo view) throws BOSException;
    public DesignSupplierEvaluationEntryCollection getDesignSupplierEvaluationEntryCollection(String oql) throws BOSException;
}