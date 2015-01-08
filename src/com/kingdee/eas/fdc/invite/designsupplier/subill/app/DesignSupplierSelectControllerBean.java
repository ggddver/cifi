package com.kingdee.eas.fdc.invite.designsupplier.subill.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSelectSupplierDBCollection;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSelectSupplierDBFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSelectSupplierDBInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignStorageNumberInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectEntryCollection;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectEntryFactory;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectEntryInfo;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectFactory;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectInfo;
import com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;

public class DesignSupplierSelectControllerBean extends AbstractDesignSupplierSelectControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.fdc.invite.designsupplier.subill.app.DesignSupplierSelectControllerBean");
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	DesignSupplierSelectInfo info = (DesignSupplierSelectInfo)model;
    	try {
    		info.setAuditDate(SysUtil.getAppServerTime(ctx));
    		if(ContextUtil.getCurrentUserInfo(ctx)!=null)
    			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
    		info.setState(SupplierStateEnum.YEATAUDIT);
    		ctx.put("proId", info.getPro().getId().toString());
    		DesignSupplierSelectFactory.getLocalInstance(ctx).update(new ObjectUuidPK(info.getId()), info);
    		if(info.getSupplierNumber()!=null){
    			DesignSupplierSelectEntryCollection entryColl = info.getEntrys();
    			for (int i = 0; i < entryColl.size(); i++) {
    				DesignSupplierSelectEntryInfo entryInfo = DesignSupplierSelectEntryFactory.getLocalInstance(ctx).getDesignSupplierSelectEntryInfo(new ObjectUuidPK(entryColl.get(i).getId()));
    				if(entryInfo.getSupplier()==null){continue;}
    				String selectOql = "select * where DesignSupplierId='"+entryInfo.getSupplier().getId().toString()+"'";
    				DesignSelectSupplierDBCollection dbColl = DesignSelectSupplierDBFactory.getLocalInstance(ctx).getDesignSelectSupplierDBCollection(selectOql);
    				if(dbColl.size()>0){
    					DesignSelectSupplierDBInfo dbInfo = dbColl.get(0);
    					dbInfo.setSupplierCompany(entryInfo.getSupplierCompany());
    					dbInfo.setPeopleCfg(entryInfo.getPeopleCfg());
    					dbInfo.setDesign(entryInfo.getDesign());
    					dbInfo.setPostService(entryInfo.getPostService());
    					dbInfo.setPro(entryInfo.getPro());
    					dbInfo.setPrice(entryInfo.getPrice());
    					dbInfo.setDesignSupplierId(entryInfo.getSupplier().getId().toString());
    					DesignSelectSupplierDBFactory.getLocalInstance(ctx).update(new ObjectUuidPK(dbInfo.getId()), dbInfo);
    				}else{
    					DesignSelectSupplierDBInfo dbInfo = new DesignSelectSupplierDBInfo();
    					dbInfo.setSupplierCompany(entryInfo.getSupplierCompany());
    					dbInfo.setPeopleCfg(entryInfo.getPeopleCfg());
    					dbInfo.setDesign(entryInfo.getDesign());
    					dbInfo.setPostService(entryInfo.getPostService());
    					dbInfo.setPro(entryInfo.getPro());
    					dbInfo.setPrice(entryInfo.getPrice());
    					dbInfo.setDesignSupplierId(entryInfo.getSupplier().getId().toString());
    					DesignSelectSupplierDBFactory.getLocalInstance(ctx).addnew(dbInfo);
    				}
				}
    			DesignSupplierStockInfo stockInfo = DesignSupplierStockFactory.getLocalInstance(ctx).getDesignSupplierStockInfo(new ObjectUuidPK(info.getSupplierNumber().getId()));
    			ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
    			DesignStorageNumberInfo number=new DesignStorageNumberInfo();
				number.setInviteType(stockInfo.getInviteType());
				number.setPurchaseOrgUnit(stockInfo.getPurchaseOrgUnit());
				String I= iCodingRuleManager.getNumber(number, "X");
				stockInfo.setStorageNumber(I);
				stockInfo.setStorageDate(SysUtil.getAppServerTime(ctx));
				DesignSupplierStockFactory.getLocalInstance(ctx).update(new ObjectUuidPK(stockInfo.getId()), stockInfo);
				DesignSupplierStockFactory.getLocalInstance(ctx).addToSysSupplier(stockInfo);
    		}
		} catch (EASBizException e) {
			e.printStackTrace();
		}
    }
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
    	DesignSupplierSelectInfo info = (DesignSupplierSelectInfo)model;
    	try {
    		info.setAuditDate(null);
    		info.setAuditor(null);
    		info.setState(SupplierStateEnum.SUBMIT);
    		DesignSupplierSelectFactory.getLocalInstance(ctx).update(new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
    }
    
    protected IObjectPK _save(Context ctx, IObjectValue model)throws BOSException, EASBizException {
    	DesignSupplierSelectInfo info = (DesignSupplierSelectInfo)model;
    	info.setState(SupplierStateEnum.SAVE);
	return super._save(ctx, model);
	}
    
	protected IObjectPK _submit(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		DesignSupplierSelectInfo info = (DesignSupplierSelectInfo)model;
		info.setState(SupplierStateEnum.SUBMIT);
	return super._submit(ctx, model);
	}
}