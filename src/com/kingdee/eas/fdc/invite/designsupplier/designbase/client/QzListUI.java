/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.designbase.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.fdc.basedata.FDCDataBaseInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.QzCollection;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.QzFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.QzInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class QzListUI extends AbstractQzListUI
{
    private static final Logger logger = CoreUIObject.getLogger(QzListUI.class);
    
    /**
     * output class constructor
     */
    public QzListUI() throws Exception
    {
        super();
    }

    public void actionCancelCancel_actionPerformed(ActionEvent e)
    		throws Exception {
    	QzCollection qzColl = QzFactory.getRemoteInstance().getQzCollection("where isEnabled='1'");
		if(qzColl.size()>0){
			MsgBox.showWarning("已经有启用的数据，不能重复启用！");
			SysUtil.abort();
		}
    	super.actionCancelCancel_actionPerformed(e);
    }
    
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
    	super.actionCancel_actionPerformed(e);
    }
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.designbase.QzFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.designbase.QzInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.designbase.QzInfo();
		
        return objectValue;
    }

	protected FDCDataBaseInfo getBaseDataInfo() {
		return new QzInfo();
	}

}