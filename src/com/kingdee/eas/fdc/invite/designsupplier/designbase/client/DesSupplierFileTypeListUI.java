/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.designbase.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.fdc.basedata.FDCDataBaseInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesSupplierFileTypeInfo;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class DesSupplierFileTypeListUI extends AbstractDesSupplierFileTypeListUI
{
    private static final Logger logger = CoreUIObject.getLogger(DesSupplierFileTypeListUI.class);
    
    /**
     * output class constructor
     */
    public DesSupplierFileTypeListUI() throws Exception
    {
        super();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    protected void refresh(ActionEvent e) throws Exception {
		this.tblMain.removeRows();
	}

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.designbase.DesSupplierFileTypeFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.designbase.DesSupplierFileTypeInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.designbase.DesSupplierFileTypeInfo();
		
        return objectValue;
    }

	protected FDCDataBaseInfo getBaseDataInfo() {
		return new DesSupplierFileTypeInfo();
	}

}