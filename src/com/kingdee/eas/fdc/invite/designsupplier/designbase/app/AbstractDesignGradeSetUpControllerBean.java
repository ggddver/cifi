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
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.fdc.basedata.FDCDataBaseCollection;
import com.kingdee.eas.fdc.basedata.app.FDCDataBaseControllerBean;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo;
import com.kingdee.eas.framework.DataBaseCollection;



public abstract class AbstractDesignGradeSetUpControllerBean extends FDCDataBaseControllerBean implements DesignGradeSetUpController
{
    protected AbstractDesignGradeSetUpControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("3C635C63");
    }

    public DesignGradeSetUpInfo getDesignGradeSetUpInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("849fc151-b87a-42ee-8d7f-b99cf5102b93"), new Object[]{ctx, pk});
            invokeServiceBefore(svcCtx);
            DesignGradeSetUpInfo retValue = (DesignGradeSetUpInfo)_getValue(ctx, pk);
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

    public DesignGradeSetUpInfo getDesignGradeSetUpInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7de15040-9e6c-4073-9ff7-9395ea76e235"), new Object[]{ctx, pk, selector});
            invokeServiceBefore(svcCtx);
            DesignGradeSetUpInfo retValue = (DesignGradeSetUpInfo)_getValue(ctx, pk, selector);
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

    public DesignGradeSetUpInfo getDesignGradeSetUpInfo(Context ctx, String oql) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("0642700d-4099-4395-97d6-cedc3c7a2029"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            DesignGradeSetUpInfo retValue = (DesignGradeSetUpInfo)_getValue(ctx, oql);
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

    public DesignGradeSetUpCollection getDesignGradeSetUpCollection(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("54870791-4f63-451c-92ab-9cb4eaa00e7d"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            DesignGradeSetUpCollection retValue = (DesignGradeSetUpCollection)_getCollection(ctx, svcCtx);
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

    public DesignGradeSetUpCollection getDesignGradeSetUpCollection(Context ctx, EntityViewInfo view) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7f8551ab-4353-4bbb-9ad8-7a16097d53e4"), new Object[]{ctx, view});
            invokeServiceBefore(svcCtx);
            DesignGradeSetUpCollection retValue = (DesignGradeSetUpCollection)_getCollection(ctx, svcCtx, view);
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

    public DesignGradeSetUpCollection getDesignGradeSetUpCollection(Context ctx, String oql) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("67f0cc4d-3b89-424e-901e-95e474687f7e"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            DesignGradeSetUpCollection retValue = (DesignGradeSetUpCollection)_getCollection(ctx, svcCtx, oql);
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

    public FDCDataBaseCollection getFDCDataBaseCollection (Context ctx) throws BOSException
    {
    	return (FDCDataBaseCollection)(getDesignGradeSetUpCollection(ctx).cast(FDCDataBaseCollection.class));
    }
    public FDCDataBaseCollection getFDCDataBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (FDCDataBaseCollection)(getDesignGradeSetUpCollection(ctx, view).cast(FDCDataBaseCollection.class));
    }
    public FDCDataBaseCollection getFDCDataBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (FDCDataBaseCollection)(getDesignGradeSetUpCollection(ctx, oql).cast(FDCDataBaseCollection.class));
    }
    public DataBaseCollection getDataBaseCollection (Context ctx) throws BOSException
    {
    	return (DataBaseCollection)(getDesignGradeSetUpCollection(ctx).cast(DataBaseCollection.class));
    }
    public DataBaseCollection getDataBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (DataBaseCollection)(getDesignGradeSetUpCollection(ctx, view).cast(DataBaseCollection.class));
    }
    public DataBaseCollection getDataBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (DataBaseCollection)(getDesignGradeSetUpCollection(ctx, oql).cast(DataBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx) throws BOSException
    {
    	return (ObjectBaseCollection)(getDesignGradeSetUpCollection(ctx).cast(ObjectBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (ObjectBaseCollection)(getDesignGradeSetUpCollection(ctx, view).cast(ObjectBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (ObjectBaseCollection)(getDesignGradeSetUpCollection(ctx, oql).cast(ObjectBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx) throws BOSException
    {
    	return (CoreBaseCollection)(getDesignGradeSetUpCollection(ctx).cast(CoreBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (CoreBaseCollection)(getDesignGradeSetUpCollection(ctx, view).cast(CoreBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (CoreBaseCollection)(getDesignGradeSetUpCollection(ctx, oql).cast(CoreBaseCollection.class));
    }
}