/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.designbase.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox;
import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.fdc.basedata.FDCDataBaseInfo;
import com.kingdee.eas.fdc.basedata.client.FDCClientVerifyHelper;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class QzEditUI extends AbstractQzEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(QzEditUI.class);
    
    /**
     * output class constructor
     */
    public QzEditUI() throws Exception
    {
        super();
    }
    
    public void onLoad() throws Exception {
    	super.onLoad();
    	this.txtjtqz.setRequired(true);
    	this.txtsybqz.setRequired(true);
    	this.actionCancel.setVisible(false);
    	this.actionCancelCancel.setVisible(false);
    }
    protected void verifyInput(ActionEvent e) throws Exception {
    	super.verifyInput(e);
    	FDCClientVerifyHelper.verifyEmpty(this, this.txtjtqz);
    	FDCClientVerifyHelper.verifyEmpty(this, this.txtsybqz);
    	double a = (this.txtjtqz.getDoubleValue()!=null)?this.txtjtqz.getDoubleValue():0;
    	double b = (this.txtsybqz.getDoubleValue()!=null)?this.txtsybqz.getDoubleValue():0;
    	if(a+b!=100){MsgBox.showWarning("集团权重比与分公司权重比之和必须等于100！");SysUtil.abort();}
    
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
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

    protected FDCDataBaseInfo getEditData() {
		return this.editData;
	}
	protected KDBizMultiLangBox getNameCtrl() {
		return this.txtName;
	}
	protected KDTextField getNumberCtrl() {
		return this.txtNumber;
	}

}