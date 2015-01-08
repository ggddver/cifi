/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.designbase.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class ProductTypeEditUI extends AbstractProductTypeEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(ProductTypeEditUI.class);
    
    /**
     * output class constructor
     */
    public ProductTypeEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    public void onLoad() throws Exception {
    	super.onLoad();
    	this.menuBar.setVisible(false);
        this.actionAddNew.setVisible(false);
        this.actionSave.setVisible(false);
        this.actionCopy.setVisible(false);
        this.actionRemove.setVisible(false);
        this.actionCancel.setVisible(false);
        this.actionCancelCancel.setVisible(false);
		this.actionFirst.setVisible(false);//第一
		this.actionPre.setVisible(false);//前一
		this.actionNext.setVisible(false);//后一
		this.actionLast.setVisible(false);//最后一个
    }
    
    public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
    	if(this.chkisEnabled.isSelected()){
    		MsgBox.showInfo("单据已启用，不能执行此操作！");
    		SysUtil.abort();
    	}
    	super.actionEdit_actionPerformed(arg0);
    }
    
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
    	if(this.chkisEnabled.isSelected()){
    		MsgBox.showInfo("单据已启用，不能执行此操作！");
    		SysUtil.abort();
    	}
    	super.actionRemove_actionPerformed(e);
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
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}