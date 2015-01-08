/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.designbase.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.fdc.basedata.FDCDataBaseInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignBusinessModeInfo;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class DesignBusinessModeListUI extends AbstractDesignBusinessModeListUI
{
    private static final Logger logger = CoreUIObject.getLogger(DesignBusinessModeListUI.class);
    
    /**
     * output class constructor
     */
    public DesignBusinessModeListUI() throws Exception
    {
        super();
    }
    protected void refresh(ActionEvent e) throws Exception {
		this.tblMain.removeRows();
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
        return com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignBusinessModeFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignBusinessModeInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignBusinessModeInfo();
		
        return objectValue;
    }

	protected FDCDataBaseInfo getBaseDataInfo() {
		return new DesignBusinessModeInfo();
	}

}