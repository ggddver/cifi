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
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.custom.funds.BizState;
import com.kingdee.eas.custom.funds.IReceiption;
import com.kingdee.eas.custom.funds.ReceiptionCollection;
import com.kingdee.eas.custom.funds.ReceiptionFactory;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.custom.funds.ReceiptionInfo;

public class ReceiptionControllerBean extends AbstractReceiptionControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.funds.app.ReceiptionControllerBean");
    
    
	protected void _close(Context ctx, IObjectValue model) throws BOSException {
		ReceiptionInfo info = (ReceiptionInfo) model;
    	IReceiption iReceiption = ReceiptionFactory.getLocalInstance(ctx);
    	try {
			info = iReceiption.getReceiptionInfo(new ObjectUuidPK(info.getId()));
			info.setBizState(BizState.close);
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			info.setAuditDate(new Date());
			
			SelectorItemCollection selector = new SelectorItemCollection();
			selector.add("bizState");
			selector.add("auditor");
			selector.add("auditDate");
			updatePartial(ctx, info, selector);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}
	protected void _unclose(Context ctx, IObjectValue model) throws BOSException {
		ReceiptionInfo info = (ReceiptionInfo) model;
    	IReceiption iReceiption = ReceiptionFactory.getLocalInstance(ctx);
    	try {
			info = iReceiption.getReceiptionInfo(new ObjectUuidPK(info.getId()));
			info.setBizState(BizState.audited);
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			info.setAuditDate(new Date());
			
			SelectorItemCollection selector = new SelectorItemCollection();
			selector.add("bizState");
			selector.add("auditor");
			selector.add("auditDate");
			updatePartial(ctx, info, selector);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}
	protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	ReceiptionInfo info = (ReceiptionInfo) model;
    	IReceiption iReceiption = ReceiptionFactory.getLocalInstance(ctx);
    	try {
			info = iReceiption.getReceiptionInfo(new ObjectUuidPK(info.getId()));
			info.setBizState(BizState.audited);
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			info.setAuditDate(new Date());
			
			SelectorItemCollection selector = new SelectorItemCollection();
			selector.add("bizState");
			selector.add("auditor");
			selector.add("auditDate");
			updatePartial(ctx, info, selector);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
    }
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
    	ReceiptionInfo info = (ReceiptionInfo) model;
    	IReceiption iReceiption = ReceiptionFactory.getLocalInstance(ctx);
    	try {
			info = iReceiption.getReceiptionInfo(new ObjectUuidPK(info.getId()));
			info.setBizState(BizState.submited);
			info.setAuditor(null);
			info.setAuditDate(null);
			
			SelectorItemCollection selector = new SelectorItemCollection();
			selector.add("bizState");
			selector.add("auditor");
			selector.add("auditDate");
			updatePartial(ctx, info, selector);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
    }
    @Override
    protected IObjectPK _submit(Context ctx, IObjectValue model)
    		throws BOSException, EASBizException {
    	ReceiptionInfo info = (ReceiptionInfo) model;
    	info.setBizState(BizState.submited);
    	return super._submit(ctx, info);
    }
}