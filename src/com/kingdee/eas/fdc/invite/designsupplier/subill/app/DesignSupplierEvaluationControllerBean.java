package com.kingdee.eas.fdc.invite.designsupplier.subill.app;

import org.apache.log4j.Logger;
import com.kingdee.bos.*;
import com.kingdee.bos.dao.IObjectValue;

import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.fdc.contract.ContractException;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationCollection;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationFactory;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationInfo;
import com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class DesignSupplierEvaluationControllerBean extends AbstractDesignSupplierEvaluationControllerBean
{
	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.fdc.invite.designsupplier.subill.app.DesignSupplierEvaluationControllerBean");
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	DesignSupplierEvaluationInfo info = (DesignSupplierEvaluationInfo)model;
    	try {
    		info.setAuditDate(SysUtil.getAppServerTime(ctx));
    		if(ContextUtil.getCurrentUserInfo(ctx)!=null)
    			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
    		info.setState(SupplierStateEnum.YEATAUDIT);
    		if(info.getSupplierNumber()!=null&&!info.getResuitl().equals(ResultsEnum.bhg)){
    			DesignSupplierStockInfo suppStockInfo = DesignSupplierStockFactory.getLocalInstance(ctx).getDesignSupplierStockInfo(new ObjectUuidPK(info.getSupplierNumber().getId()));
    			suppStockInfo.setIsPass(info.getResuitl());
    			suppStockInfo.setGatadeLv(info.getSupplierlastClas());
    			DesignSupplierStockFactory.getLocalInstance(ctx).update(new ObjectUuidPK(suppStockInfo.getId()), suppStockInfo);
    		}
    		DesignSupplierEvaluationFactory.getLocalInstance(ctx).update(new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
    }
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
    	DesignSupplierEvaluationInfo info = (DesignSupplierEvaluationInfo)model;
    	try {
    		info.setAuditDate(null);
    		info.setAuditor(null);
    		info.setState(SupplierStateEnum.SUBMIT);
    		DesignSupplierEvaluationFactory.getLocalInstance(ctx).update(new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
    }
    
    protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
    		EASBizException {
    	super._delete(ctx, pk);
    }
    
    protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
    	DesignSupplierEvaluationInfo info = (DesignSupplierEvaluationInfo)model;
    	info.setState(SupplierStateEnum.SAVE);
	return super._save(ctx, model);
	}
    
	protected IObjectPK _submit(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		DesignSupplierEvaluationInfo info = (DesignSupplierEvaluationInfo)model;
		info.setState(SupplierStateEnum.SUBMIT);
	return super._submit(ctx, model);
	}
}