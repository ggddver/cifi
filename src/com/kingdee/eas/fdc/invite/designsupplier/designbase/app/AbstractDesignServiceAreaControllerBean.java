package com.kingdee.eas.fdc.invite.designsupplier.designbase.app;

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
import com.kingdee.eas.framework.Result;
import com.kingdee.eas.framework.LineResult;
import com.kingdee.eas.framework.exception.EASMultiException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;

import java.lang.String;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.fdc.basedata.FDCDataBaseCollection;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaInfo;
import com.kingdee.eas.fdc.basedata.app.FDCDataBaseControllerBean;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;



public abstract class AbstractDesignServiceAreaControllerBean extends FDCDataBaseControllerBean implements DesignServiceAreaController
{
    protected AbstractDesignServiceAreaControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("F8360D25");
    }

    public DesignServiceAreaInfo getDesignServiceAreaInfo(Context ctx, String oql) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("31aa0681-325e-4bb2-ac68-dc32b9cd4fc5"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            DesignServiceAreaInfo retValue = (DesignServiceAreaInfo)_getValue(ctx, oql);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectValue _getValue(Context ctx, String oql) throws BOSException, EASBizException
    {
        return super._getValue(ctx, oql);
    }

    public DesignServiceAreaInfo getDesignServiceAreaInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5a8ce88c-f0ef-4705-a192-f0a69708d301"), new Object[]{ctx, pk, selector});
            invokeServiceBefore(svcCtx);
            DesignServiceAreaInfo retValue = (DesignServiceAreaInfo)_getValue(ctx, pk, selector);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectValue _getValue(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        return super._getValue(ctx, pk, selector);
    }

    public DesignServiceAreaInfo getDesignServiceAreaInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("6691119b-516d-4d9b-9d47-11c1b6739b23"), new Object[]{ctx, pk});
            invokeServiceBefore(svcCtx);
            DesignServiceAreaInfo retValue = (DesignServiceAreaInfo)_getValue(ctx, pk);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectValue _getValue(Context ctx, IObjectPK pk) throws BOSException, EASBizException
    {
        return super._getValue(ctx, pk);
    }

    public DesignServiceAreaCollection getDesignServiceAreaCollection(Context ctx, String oql) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d07184ae-17e5-4413-8f3c-741b2da1afa3"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            DesignServiceAreaCollection retValue = (DesignServiceAreaCollection)_getCollection(ctx, svcCtx, oql);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectCollection _getCollection(Context ctx, IServiceContext svcCtx, String oql) throws BOSException
    {
        return super._getCollection(ctx, svcCtx, oql);
    }

    public DesignServiceAreaCollection getDesignServiceAreaCollection(Context ctx, EntityViewInfo view) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3ec8c4a2-4313-48d3-aa21-711a816c7a7a"), new Object[]{ctx, view});
            invokeServiceBefore(svcCtx);
            DesignServiceAreaCollection retValue = (DesignServiceAreaCollection)_getCollection(ctx, svcCtx, view);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectCollection _getCollection(Context ctx, IServiceContext svcCtx, EntityViewInfo view) throws BOSException
    {
        return super._getCollection(ctx, svcCtx, view);
    }

    public DesignServiceAreaCollection getDesignServiceAreaCollection(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9a70a150-49d1-4d8e-a39b-9b413c10353b"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            DesignServiceAreaCollection retValue = (DesignServiceAreaCollection)_getCollection(ctx, svcCtx);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectCollection _getCollection(Context ctx, IServiceContext svcCtx) throws BOSException
    {
        return super._getCollection(ctx, svcCtx);
    }

    public void IsNdelete(Context ctx, String areaName) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3866dfba-0163-4d7a-be8d-9bf1b47c10f8"), new Object[]{ctx, areaName});
            invokeServiceBefore(svcCtx);
            _IsNdelete(ctx, areaName);
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } catch (EASBizException ex0) {
            this.setRollbackOnly();
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _IsNdelete(Context ctx, String areaName) throws BOSException, EASBizException;

    public FDCDataBaseCollection getFDCDataBaseCollection (Context ctx) throws BOSException
    {
    	return (FDCDataBaseCollection)(getDesignServiceAreaCollection(ctx).cast(FDCDataBaseCollection.class));
    }
    public FDCDataBaseCollection getFDCDataBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (FDCDataBaseCollection)(getDesignServiceAreaCollection(ctx, view).cast(FDCDataBaseCollection.class));
    }
    public FDCDataBaseCollection getFDCDataBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (FDCDataBaseCollection)(getDesignServiceAreaCollection(ctx, oql).cast(FDCDataBaseCollection.class));
    }
    public DataBaseCollection getDataBaseCollection (Context ctx) throws BOSException
    {
    	return (DataBaseCollection)(getDesignServiceAreaCollection(ctx).cast(DataBaseCollection.class));
    }
    public DataBaseCollection getDataBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (DataBaseCollection)(getDesignServiceAreaCollection(ctx, view).cast(DataBaseCollection.class));
    }
    public DataBaseCollection getDataBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (DataBaseCollection)(getDesignServiceAreaCollection(ctx, oql).cast(DataBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx) throws BOSException
    {
    	return (ObjectBaseCollection)(getDesignServiceAreaCollection(ctx).cast(ObjectBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (ObjectBaseCollection)(getDesignServiceAreaCollection(ctx, view).cast(ObjectBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (ObjectBaseCollection)(getDesignServiceAreaCollection(ctx, oql).cast(ObjectBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx) throws BOSException
    {
    	return (CoreBaseCollection)(getDesignServiceAreaCollection(ctx).cast(CoreBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (CoreBaseCollection)(getDesignServiceAreaCollection(ctx, view).cast(CoreBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (CoreBaseCollection)(getDesignServiceAreaCollection(ctx, oql).cast(CoreBaseCollection.class));
    }
}