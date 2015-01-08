package com.kingdee.eas.fdc.invite.designsupplier.demotion.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
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
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo;
import com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionFactory;
import com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionCollection;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationFactory;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationInfo;
import com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;

public class DemotionControllerBean extends AbstractDemotionControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.fdc.invite.designsupplier.demotion.app.DemotionControllerBean");
    
    
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	DemotionInfo info = (DemotionInfo)model;
    	try {
    		info.setAuditDate(SysUtil.getAppServerTime(ctx));//升降级单据的审核日期
    		if(ContextUtil.getCurrentUserInfo(ctx)!=null)
    			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));//审核人
    		info.setState(SupplierStateEnum.YEATAUDIT);//审核以后关闭单据状态
    		if(info.getSupplierNumber()!=null){
    			DesignSupplierStockInfo suppStockInfo = DesignSupplierStockFactory.getLocalInstance(ctx).getDesignSupplierStockInfo(new ObjectUuidPK(info.getSupplierNumber().getId()));
    			suppStockInfo.setIsPass(info.getResuitl());
    			suppStockInfo.setGatadeLv(info.getSupplierlastClas());
    			DesignSupplierStockFactory.getLocalInstance(ctx).update(new ObjectUuidPK(suppStockInfo.getId()), suppStockInfo);//更新单据信息
    		}
    		DemotionFactory.getLocalInstance(ctx).update(new ObjectUuidPK(info.getId()),info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
    }
    
    
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
    	
    	DemotionInfo info = (DemotionInfo)model;
    	try {
    		info.setAuditDate(null);
    		info.setAuditor(null);
    		info.setState(SupplierStateEnum.SUBMIT);
    		DemotionFactory.getLocalInstance(ctx).update(new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
    }
    
    
    //提交
	protected IObjectPK _submit(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		DemotionInfo info = (DemotionInfo)model;
		info.setState(SupplierStateEnum.SUBMIT);
	return super._submit(ctx, model);
	}
	
	//保存
    protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
    	DemotionInfo info = (DemotionInfo)model;
    	info.setState(SupplierStateEnum.SAVE);
	return super._save(ctx, model);
	}
}