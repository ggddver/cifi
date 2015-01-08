package com.kingdee.eas.custom.funds.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import java.lang.String;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.custom.funds.BizState;
import com.kingdee.eas.custom.funds.FundsApplicationCollection;
import com.kingdee.eas.custom.funds.FundsApplicationFactory;
import com.kingdee.eas.custom.funds.FundsApplicationInfo;
import com.kingdee.eas.custom.funds.IFundsApplication;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;

public class FundsApplicationControllerBean extends AbstractFundsApplicationControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.funds.app.FundsApplicationControllerBean");
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	FundsApplicationInfo info = (FundsApplicationInfo) model;
    	IFundsApplication iFundsApplication = FundsApplicationFactory.getLocalInstance(ctx);
    	try {
			info = iFundsApplication.getFundsApplicationInfo(new ObjectUuidPK(info.getId().toString()));
			info.setBizState(BizState.audited);
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			info.setAuditOrg(ContextUtil.getCurrentAdminUnit(ctx));
			info.setAuditDate(new Date());
			iFundsApplication.update(new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
    }
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
    	FundsApplicationInfo info = (FundsApplicationInfo) model;
    	IFundsApplication iFundsApplication = FundsApplicationFactory.getLocalInstance(ctx);
    	try {
			info = iFundsApplication.getFundsApplicationInfo(new ObjectUuidPK(info.getId().toString()));
			info.setBizState(BizState.submited);
			info.setAuditDate(null);
			info.setAuditor(null);
			info.setAuditOrg(null);
			iFundsApplication.update(new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
    }

    @Override
    protected IObjectPK _submit(Context ctx, IObjectValue model)
    		throws BOSException, EASBizException {
    	FundsApplicationInfo info = (FundsApplicationInfo)model;
    	info.setBizState(BizState.submited);
    	return super._submit(ctx, model);
    }
}