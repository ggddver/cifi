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
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSelectSupplierDBInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.app.CoreBaseControllerBean;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSelectSupplierDBCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.metadata.entity.SorterItemCollection;



public abstract class AbstractDesignSelectSupplierDBControllerBean extends CoreBaseControllerBean implements DesignSelectSupplierDBController
{
    protected AbstractDesignSelectSupplierDBControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("EE370A3E");
    }

    public boolean exists(Context ctx, IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("09831565-ac5d-4a09-9cb2-bc89207f094f"), new Object[]{ctx, pk});
            invokeServiceBefore(svcCtx);
            boolean retValue = (boolean)_exists(ctx, pk);
            svcCtx.setMethodReturnValue(new Boolean(retValue));
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
    protected boolean _exists(Context ctx, IObjectPK pk) throws BOSException, EASBizException
    {
        return super._exists(ctx, pk);
    }

    public boolean exists(Context ctx, FilterInfo filter) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5fb453e3-2ae8-4db3-a1de-0d21c3941499"), new Object[]{ctx, filter});
            invokeServiceBefore(svcCtx);
            boolean retValue = (boolean)_exists(ctx, filter);
            svcCtx.setMethodReturnValue(new Boolean(retValue));
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
    protected boolean _exists(Context ctx, FilterInfo filter) throws BOSException, EASBizException
    {
        return super._exists(ctx, filter);
    }

    public boolean exists(Context ctx, String oql) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7375cfd1-9ec2-485b-b1a5-e1053ce336a5"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            boolean retValue = (boolean)_exists(ctx, oql);
            svcCtx.setMethodReturnValue(new Boolean(retValue));
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
    protected boolean _exists(Context ctx, String oql) throws BOSException, EASBizException
    {
        return super._exists(ctx, oql);
    }

    public DesignSelectSupplierDBInfo getDesignSelectSupplierDBInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3661cc80-5773-4db1-908f-b5e637f54cca"), new Object[]{ctx, pk});
            invokeServiceBefore(svcCtx);
            DesignSelectSupplierDBInfo retValue = (DesignSelectSupplierDBInfo)_getValue(ctx, pk);
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

    public DesignSelectSupplierDBInfo getDesignSelectSupplierDBInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("71dc142f-6a00-4b9d-a227-eae5bd295fb6"), new Object[]{ctx, pk, selector});
            invokeServiceBefore(svcCtx);
            DesignSelectSupplierDBInfo retValue = (DesignSelectSupplierDBInfo)_getValue(ctx, pk, selector);
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

    public DesignSelectSupplierDBInfo getDesignSelectSupplierDBInfo(Context ctx, String oql) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3065adfb-2860-4361-9d1e-4178472fecc5"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            DesignSelectSupplierDBInfo retValue = (DesignSelectSupplierDBInfo)_getValue(ctx, oql);
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

    public IObjectPK addnew(Context ctx, DesignSelectSupplierDBInfo model) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5cbfa1d0-9f6f-4be6-a252-66e1deacbd78"), new Object[]{ctx, model});
            invokeServiceBefore(svcCtx);
            IObjectPK retValue = (IObjectPK)_addnew(ctx, model);
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
    protected IObjectPK _addnew(Context ctx, IObjectValue model) throws BOSException, EASBizException
    {
        return super._addnew(ctx, model);
    }

    public void addnew(Context ctx, IObjectPK pk, DesignSelectSupplierDBInfo model) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7161abff-9195-4123-97a2-9c6795712460"), new Object[]{ctx, pk, model});
            invokeServiceBefore(svcCtx);
            _addnew(ctx, pk, model);
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
    protected void _addnew(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException
    {
        super._addnew(ctx, pk, model);
    }

    public void update(Context ctx, IObjectPK pk, DesignSelectSupplierDBInfo model) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("fc2bd0fc-6ce7-4986-9260-c2287f94bab5"), new Object[]{ctx, pk, model});
            invokeServiceBefore(svcCtx);
            _update(ctx, pk, model);
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
    protected void _update(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException
    {
        super._update(ctx, pk, model);
    }

    public void updatePartial(Context ctx, DesignSelectSupplierDBInfo model, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("2fa00267-7bae-4b06-a5ff-a64aff23fcc1"), new Object[]{ctx, model, selector});
            invokeServiceBefore(svcCtx);
            _updatePartial(ctx, model, selector);
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
    protected void _updatePartial(Context ctx, IObjectValue model, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        super._updatePartial(ctx, model, selector);
    }

    public void updateBigObject(Context ctx, IObjectPK pk, DesignSelectSupplierDBInfo model) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("1376e202-23c0-4e9d-aa3d-328025558b11"), new Object[]{ctx, pk, model});
            invokeServiceBefore(svcCtx);
            _updateBigObject(ctx, pk, model);
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _updateBigObject(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException
    {
        innerUpdateBigObject(ctx, pk, model);
    }

    public void delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("1c5d2901-6fb3-4b99-9f19-9c10955f93b1"), new Object[]{ctx, pk});
            invokeServiceBefore(svcCtx);
            _delete(ctx, pk);
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
    protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException
    {
        super._delete(ctx, pk);
    }

    public IObjectPK[] getPKList(Context ctx) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("94e26408-a914-46de-a3e4-14c6c81618f2"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            IObjectPK[] retValue = (IObjectPK[])_getPKList(ctx);
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
    protected IObjectPK[] _getPKList(Context ctx) throws BOSException, EASBizException
    {
        return super._getPKList(ctx);
    }

    public IObjectPK[] getPKList(Context ctx, String oql) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("20460a01-c920-434e-9fd0-68a794bbc091"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            IObjectPK[] retValue = (IObjectPK[])_getPKList(ctx, oql);
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
    protected IObjectPK[] _getPKList(Context ctx, String oql) throws BOSException, EASBizException
    {
        return super._getPKList(ctx, oql);
    }

    public IObjectPK[] getPKList(Context ctx, FilterInfo filter, SorterItemCollection sorter) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("bb2513e2-9867-4f6c-9867-e96284209f65"), new Object[]{ctx, filter, sorter});
            invokeServiceBefore(svcCtx);
            IObjectPK[] retValue = (IObjectPK[])_getPKList(ctx, filter, sorter);
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
    protected IObjectPK[] _getPKList(Context ctx, FilterInfo filter, SorterItemCollection sorter) throws BOSException, EASBizException
    {
        return super._getPKList(ctx, filter, sorter);
    }

    public DesignSelectSupplierDBCollection getDesignSelectSupplierDBCollection(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("910c2f9e-4d4f-4eab-aabd-77a5d23d3d59"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            DesignSelectSupplierDBCollection retValue = (DesignSelectSupplierDBCollection)_getCollection(ctx, svcCtx);
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

    public DesignSelectSupplierDBCollection getDesignSelectSupplierDBCollection(Context ctx, EntityViewInfo view) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("507f142a-cf13-40a9-882d-452f653d3f94"), new Object[]{ctx, view});
            invokeServiceBefore(svcCtx);
            DesignSelectSupplierDBCollection retValue = (DesignSelectSupplierDBCollection)_getCollection(ctx, svcCtx, view);
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

    public DesignSelectSupplierDBCollection getDesignSelectSupplierDBCollection(Context ctx, String oql) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3a1f82d0-1edc-4049-8b9e-6b3f5746e49c"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            DesignSelectSupplierDBCollection retValue = (DesignSelectSupplierDBCollection)_getCollection(ctx, svcCtx, oql);
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

    public IObjectPK[] delete(Context ctx, FilterInfo filter) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("94db8831-8525-41f8-b1e3-1145b88c498e"), new Object[]{ctx, filter});
            invokeServiceBefore(svcCtx);
            IObjectPK[] retValue = (IObjectPK[])_delete(ctx, filter);
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
    protected IObjectPK[] _delete(Context ctx, FilterInfo filter) throws BOSException, EASBizException
    {
        return super._delete(ctx, filter);
    }

    public IObjectPK[] delete(Context ctx, String oql) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("73054026-3613-4c07-90b5-281838d2bdc6"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            IObjectPK[] retValue = (IObjectPK[])_delete(ctx, oql);
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
    protected IObjectPK[] _delete(Context ctx, String oql) throws BOSException, EASBizException
    {
        return super._delete(ctx, oql);
    }

    public void delete(Context ctx, IObjectPK[] arrayPK) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("e86044e3-433e-444c-9769-d88c518180f8"), new Object[]{ctx, arrayPK});
            invokeServiceBefore(svcCtx);
            _delete(ctx, arrayPK);
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
    protected void _delete(Context ctx, IObjectPK[] arrayPK) throws BOSException, EASBizException
    {
        super._delete(ctx, arrayPK);
    }

    public CoreBaseCollection getCollection (Context ctx) throws BOSException
    {
    	return (CoreBaseCollection)(getDesignSelectSupplierDBCollection(ctx).cast(CoreBaseCollection.class));
    }
    public CoreBaseCollection getCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (CoreBaseCollection)(getDesignSelectSupplierDBCollection(ctx, view).cast(CoreBaseCollection.class));
    }
    public CoreBaseCollection getCollection (Context ctx, String oql) throws BOSException
    {
    	return (CoreBaseCollection)(getDesignSelectSupplierDBCollection(ctx, oql).cast(CoreBaseCollection.class));
    }
}