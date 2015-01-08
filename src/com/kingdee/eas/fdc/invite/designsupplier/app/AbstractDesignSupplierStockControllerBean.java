package com.kingdee.eas.fdc.invite.designsupplier.app;

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
import java.util.Map;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import java.util.Set;
import com.kingdee.eas.fdc.basedata.FDCDataBaseCollection;
import java.util.HashSet;
import com.kingdee.eas.fdc.basedata.app.FDCDataBaseControllerBean;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.util.List;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockCollection;



public abstract class AbstractDesignSupplierStockControllerBean extends FDCDataBaseControllerBean implements DesignSupplierStockController
{
    protected AbstractDesignSupplierStockControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("92A3F6D2");
    }

    public DesignSupplierStockInfo getDesignSupplierStockInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b0885b0b-f989-43e0-9e25-663bb96730e4"), new Object[]{ctx, pk});
            invokeServiceBefore(svcCtx);
            DesignSupplierStockInfo retValue = (DesignSupplierStockInfo)_getValue(ctx, pk);
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

    public DesignSupplierStockInfo getDesignSupplierStockInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9be14596-ccb8-4612-b06d-d09a89c3b134"), new Object[]{ctx, pk, selector});
            invokeServiceBefore(svcCtx);
            DesignSupplierStockInfo retValue = (DesignSupplierStockInfo)_getValue(ctx, pk, selector);
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

    public DesignSupplierStockInfo getDesignSupplierStockInfo(Context ctx, String oql) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d756b97f-f3a6-429c-a95b-bfd496f02ab0"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            DesignSupplierStockInfo retValue = (DesignSupplierStockInfo)_getValue(ctx, oql);
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

    public DesignSupplierStockCollection getDesignSupplierStockCollection(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("e29e8abf-9f0a-44e0-bc16-a80be4c55dbe"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            DesignSupplierStockCollection retValue = (DesignSupplierStockCollection)_getCollection(ctx, svcCtx);
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

    public DesignSupplierStockCollection getDesignSupplierStockCollection(Context ctx, EntityViewInfo view) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d1ba9ff6-b47e-4714-a1e9-ee3f7db76f55"), new Object[]{ctx, view});
            invokeServiceBefore(svcCtx);
            DesignSupplierStockCollection retValue = (DesignSupplierStockCollection)_getCollection(ctx, svcCtx, view);
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

    public DesignSupplierStockCollection getDesignSupplierStockCollection(Context ctx, String oql) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("22dd6b26-276f-4637-93c4-c0015cac2bd5"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            DesignSupplierStockCollection retValue = (DesignSupplierStockCollection)_getCollection(ctx, svcCtx, oql);
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

    public Map approve(Context ctx, IObjectPK[] pks) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("6f3591f0-c0a7-4c45-ac72-57cc1141eea3"), new Object[]{ctx, pks});
            invokeServiceBefore(svcCtx);
            Map retValue = (Map)_approve(ctx, pks);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
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
    protected abstract Map _approve(Context ctx, IObjectPK[] pks) throws BOSException, EASBizException;

    public Map unApprove(Context ctx, IObjectPK[] pks) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("38a6b83c-cddd-4a00-9e8a-369e7b73dea1"), new Object[]{ctx, pks});
            invokeServiceBefore(svcCtx);
            Map retValue = (Map)_unApprove(ctx, pks);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
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
    protected abstract Map _unApprove(Context ctx, IObjectPK[] pks) throws BOSException, EASBizException;

    public void submitTwo(Context ctx, IObjectValue supObjectValue) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("6d43d12a-d2cd-484f-8ffe-89f742c4290a"), new Object[]{ctx, supObjectValue});
            invokeServiceBefore(svcCtx);
            _submitTwo(ctx, supObjectValue);
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
    protected abstract void _submitTwo(Context ctx, IObjectValue supObjectValue) throws BOSException, EASBizException;

    public DesignSupplierStockCollection getSupplierDataBase(Context ctx, String supLongNumber) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5fa80274-be57-436b-8ab7-c1f3d38879a4"), new Object[]{ctx, supLongNumber});
            invokeServiceBefore(svcCtx);
            DesignSupplierStockCollection retValue = (DesignSupplierStockCollection)_getSupplierDataBase(ctx, supLongNumber);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
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
    protected abstract IObjectCollection _getSupplierDataBase(Context ctx, String supLongNumber) throws BOSException, EASBizException;

    public Map importDataBase(Context ctx, IObjectCollection objCollection, String typeLongNumber) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9d0a3866-4e37-44e4-a9f1-d4eaa704abce"), new Object[]{ctx, objCollection, typeLongNumber});
            invokeServiceBefore(svcCtx);
            Map retValue = (Map)_importDataBase(ctx, objCollection, typeLongNumber);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
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
    protected abstract Map _importDataBase(Context ctx, IObjectCollection objCollection, String typeLongNumber) throws BOSException, EASBizException;

    public DesignSupplierStockCollection getSericeArea(Context ctx) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5f97a3c0-0346-4296-8e20-9117d9d2d994"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            DesignSupplierStockCollection retValue = (DesignSupplierStockCollection)_getSericeArea(ctx);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
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
    protected abstract IObjectCollection _getSericeArea(Context ctx) throws BOSException, EASBizException;

    public Set getDataBase(Context ctx, List list) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("95c92eb7-55e9-4f2a-8e3d-e93d4b6c7e62"), new Object[]{ctx, list});
            invokeServiceBefore(svcCtx);
            Set retValue = (Set)_getDataBase(ctx, list);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
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
    protected abstract Set _getDataBase(Context ctx, List list) throws BOSException, EASBizException;

    public Set getAHDBValue(Context ctx, List list) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("62eaf7fc-6dba-4c66-a23a-d637f9ef33c9"), new Object[]{ctx, list});
            invokeServiceBefore(svcCtx);
            Set retValue = (Set)_getAHDBValue(ctx, list);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
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
    protected abstract Set _getAHDBValue(Context ctx, List list) throws BOSException, EASBizException;

    public Set getEHDBValue(Context ctx, List list) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("59c5c31f-c189-44b9-99bc-92620d2c94c9"), new Object[]{ctx, list});
            invokeServiceBefore(svcCtx);
            Set retValue = (Set)_getEHDBValue(ctx, list);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
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
    protected abstract Set _getEHDBValue(Context ctx, List list) throws BOSException, EASBizException;

    public Set getSHDBValue(Context ctx, List list) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("83ec7701-3d55-463a-8eab-86945feb246f"), new Object[]{ctx, list});
            invokeServiceBefore(svcCtx);
            Set retValue = (Set)_getSHDBValue(ctx, list);
            svcCtx.setMethodReturnValue(retValue);
            invokeServiceAfter(svcCtx);
            return retValue;
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
    protected abstract Set _getSHDBValue(Context ctx, List list) throws BOSException, EASBizException;

    public boolean getATRFValue(Context ctx, List list) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("8a897ba1-339e-444b-85e8-144a428e47f4"), new Object[]{ctx, list});
            invokeServiceBefore(svcCtx);
            boolean retValue = (boolean)_getATRFValue(ctx, list);
            svcCtx.setMethodReturnValue(new Boolean(retValue));
            invokeServiceAfter(svcCtx);
            return retValue;
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
    protected abstract boolean _getATRFValue(Context ctx, List list) throws BOSException, EASBizException;

    public void updateHisCount(Context ctx, IObjectPK pk, boolean isAudit) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a9e1d7e2-ee95-41d4-aa72-ffe670160fb4"), new Object[]{ctx, pk, new Boolean(isAudit)});
            invokeServiceBefore(svcCtx);
            _updateHisCount(ctx, pk, isAudit);
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
    protected abstract void _updateHisCount(Context ctx, IObjectPK pk, boolean isAudit) throws BOSException, EASBizException;

    public void beachUpdateHisCount(Context ctx, IObjectPK[] pks, boolean isAudit) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b9b7497f-040c-41aa-8c17-ad6b1b6774eb"), new Object[]{ctx, pks, new Boolean(isAudit)});
            invokeServiceBefore(svcCtx);
            _beachUpdateHisCount(ctx, pks, isAudit);
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
    protected abstract void _beachUpdateHisCount(Context ctx, IObjectPK[] pks, boolean isAudit) throws BOSException, EASBizException;

    public void batchAssign2(Context ctx, String cuid, String[] diddata, String[] cuiddata) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("e6e238a2-e276-4eaa-882c-4f61487cda3e"), new Object[]{ctx, cuid, diddata, cuiddata});
            invokeServiceBefore(svcCtx);
            _batchAssign2(ctx, cuid, diddata, cuiddata);
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
    protected abstract void _batchAssign2(Context ctx, String cuid, String[] diddata, String[] cuiddata) throws BOSException, EASBizException;

    public void batchAssign2(Context ctx, String cuid, String sql, HashSet basedata, HashSet cuData) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("f7a37e05-6ec3-48a2-9d0a-2372da22d43b"), new Object[]{ctx, cuid, sql, basedata, cuData});
            invokeServiceBefore(svcCtx);
            _batchAssign2(ctx, cuid, sql, basedata, cuData);
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
    protected abstract void _batchAssign2(Context ctx, String cuid, String sql, HashSet basedata, HashSet cuData) throws BOSException, EASBizException;

    public void addToSysSupplier(Context ctx, IObjectValue objectValue) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9f5b0d11-f408-4e28-9320-79e8fbbec51e"), new Object[]{ctx, objectValue});
            invokeServiceBefore(svcCtx);
            _addToSysSupplier(ctx, objectValue);
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
    protected abstract void _addToSysSupplier(Context ctx, IObjectValue objectValue) throws BOSException, EASBizException;

    public FDCDataBaseCollection getFDCDataBaseCollection (Context ctx) throws BOSException
    {
    	return (FDCDataBaseCollection)(getDesignSupplierStockCollection(ctx).cast(FDCDataBaseCollection.class));
    }
    public FDCDataBaseCollection getFDCDataBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (FDCDataBaseCollection)(getDesignSupplierStockCollection(ctx, view).cast(FDCDataBaseCollection.class));
    }
    public FDCDataBaseCollection getFDCDataBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (FDCDataBaseCollection)(getDesignSupplierStockCollection(ctx, oql).cast(FDCDataBaseCollection.class));
    }
    public DataBaseCollection getDataBaseCollection (Context ctx) throws BOSException
    {
    	return (DataBaseCollection)(getDesignSupplierStockCollection(ctx).cast(DataBaseCollection.class));
    }
    public DataBaseCollection getDataBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (DataBaseCollection)(getDesignSupplierStockCollection(ctx, view).cast(DataBaseCollection.class));
    }
    public DataBaseCollection getDataBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (DataBaseCollection)(getDesignSupplierStockCollection(ctx, oql).cast(DataBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx) throws BOSException
    {
    	return (ObjectBaseCollection)(getDesignSupplierStockCollection(ctx).cast(ObjectBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (ObjectBaseCollection)(getDesignSupplierStockCollection(ctx, view).cast(ObjectBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (ObjectBaseCollection)(getDesignSupplierStockCollection(ctx, oql).cast(ObjectBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx) throws BOSException
    {
    	return (CoreBaseCollection)(getDesignSupplierStockCollection(ctx).cast(CoreBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (CoreBaseCollection)(getDesignSupplierStockCollection(ctx, view).cast(CoreBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (CoreBaseCollection)(getDesignSupplierStockCollection(ctx, oql).cast(CoreBaseCollection.class));
    }
}