/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.designbase.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.ProductTypeFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.ProductTypeInfo;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class ProductTypeListUI extends AbstractProductTypeListUI
{
    private static final Logger logger = CoreUIObject.getLogger(ProductTypeListUI.class);
    
    /**
     * output class constructor
     */
    public ProductTypeListUI() throws Exception
    {
        super();
    }
    protected boolean isIgnoreCUFilter() {
		return true;
	}
    protected void refresh(ActionEvent e) throws Exception {
		this.tblMain.removeRows();
	}
    
    
    public void onLoad() throws Exception {
    	super.onLoad();
    	this.actionCancel.setVisible(true);
    	this.actionCancelCancel.setVisible(true);
    }
    
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
    	checkSelected();
    	ProductTypeInfo info = ProductTypeFactory.getRemoteInstance().getProductTypeInfo(new ObjectUuidPK(this.getSelectedKeyForAll()));
    	if(info.isIsEnabled()){
    		info.setIsEnabled(false);
    		ProductTypeFactory.getRemoteInstance().update(new ObjectUuidPK(info.getId()), info);
    		this.refresh(null);
    	}
    }
    
	public void actionCancelCancel_actionPerformed(ActionEvent actionevent)
			throws Exception {
		checkSelected();
		ProductTypeInfo info = ProductTypeFactory.getRemoteInstance().getProductTypeInfo(new ObjectUuidPK(this.getSelectedKeyForAll()));
    	if(!info.isIsEnabled()){
    		info.setIsEnabled(true);
    		ProductTypeFactory.getRemoteInstance().update(new ObjectUuidPK(info.getId()), info);
    		this.refresh(null);
    	}
	}
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }


    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.designbase.ProductTypeFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.designbase.ProductTypeInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.designbase.ProductTypeInfo();
		
        return objectValue;
    }

}