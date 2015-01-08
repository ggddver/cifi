
package com.kingdee.eas.fdc.invite.designsupplier.subill.app;

import org.apache.log4j.Logger;
import com.kingdee.bos.*;
import com.kingdee.bos.dao.IObjectValue;

import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseFactory;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo;
import com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;

public class DesignSupplierAppraiseControllerBean extends AbstractDesignSupplierAppraiseControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.fdc.invite.designsupplier.subill.app.DesignSupplierAppraiseControllerBean");
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	DesignSupplierAppraiseInfo info = (DesignSupplierAppraiseInfo)model;
    	try {
    		info.setAuditDate(SysUtil.getAppServerTime(ctx));
    		if(ContextUtil.getCurrentUserInfo(ctx)!=null)
    			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
    		info.setState(SupplierStateEnum.YEATAUDIT);
    		if(info.getSupplierNumber()!=null){
    			DesignSupplierStockInfo suppStockInfo = DesignSupplierStockFactory.getLocalInstance(ctx).getDesignSupplierStockInfo(new ObjectUuidPK(info.getSupplierNumber().getId()));
    			suppStockInfo.setIsPass(info.getResults());
    			DesignSupplierStockFactory.getLocalInstance(ctx).update(new ObjectUuidPK(suppStockInfo.getId()), suppStockInfo);
    			if(info.getResults().equals(ResultsEnum.bhg)){
    				String stockNumber = "SJ-"+suppStockInfo.getNumber();
    				DbUtil.execute(ctx, "update T_BD_SUPPLIER set FUsedStatus='0' where fnumber='"+stockNumber+"'");
    			}
    		}
    		DesignSupplierAppraiseFactory.getLocalInstance(ctx).update(new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
    }
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
    	DesignSupplierAppraiseInfo info = (DesignSupplierAppraiseInfo)model;
    	try {
    		info.setAuditDate(null);
    		info.setAuditor(null);
    		info.setState(SupplierStateEnum.SUBMIT);
    		DesignSupplierAppraiseFactory.getLocalInstance(ctx).update(new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
    }
    
    protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
    	DesignSupplierAppraiseInfo info = (DesignSupplierAppraiseInfo)model;
	return super._save(ctx, model);
	}
    
	protected IObjectPK _submit(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		DesignSupplierAppraiseInfo info = (DesignSupplierAppraiseInfo)model;
		info.setState(SupplierStateEnum.SUBMIT);
	return super._submit(ctx, model);
	}
}