/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.designbase.client;

import java.awt.event.*;
import java.util.List;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignVisibilityFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignVisibilityInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class DesignVisibilityListUI extends AbstractDesignVisibilityListUI
{
    private static final Logger logger = CoreUIObject.getLogger(DesignVisibilityListUI.class);
    
    /**
     * output class constructor
     */
    public DesignVisibilityListUI() throws Exception
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

    public void onLoad() throws Exception {
    	super.onLoad();
    	this.actionCancel.setVisible(true);
    	this.actionCancelCancel.setVisible(true);
    }

    protected void cancelCancel() throws Exception {
    	super.cancelCancel();
    	
    	this.refresh(null);
    }
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
//    	super.actionCancel_actionPerformed(e);
    	checkSelected();
    	DesignVisibilityInfo info = DesignVisibilityFactory.getRemoteInstance().getDesignVisibilityInfo(new ObjectUuidPK(this.getSelectedKeyForAll()));
    	if(info.isIsEnabled()){
    		info.setIsEnabled(false);
    		DesignVisibilityFactory.getRemoteInstance().update(new ObjectUuidPK(info.getId()), info);
    		this.refresh(null);
    	}
    }
    
	public void actionCancelCancel_actionPerformed(ActionEvent actionevent)
			throws Exception {
//		super.actionCancelCancel_actionPerformed(actionevent);
		checkSelected();
		DesignVisibilityInfo info = DesignVisibilityFactory.getRemoteInstance().getDesignVisibilityInfo(new ObjectUuidPK(this.getSelectedKeyForAll()));
    	if(!info.isIsEnabled()){
    		info.setIsEnabled(true);
    		DesignVisibilityFactory.getRemoteInstance().update(new ObjectUuidPK(info.getId()), info);
    		this.refresh(null);
    	}
	}
	
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();
		List listID = this.getSelectedIdValues();
		for (int i = 0; i < listID.size(); i++) {
			DesignVisibilityInfo info = DesignVisibilityFactory.getRemoteInstance().getDesignVisibilityInfo(new ObjectUuidPK((String)listID.get(i)));
			if(info.isIsEnabled()){
				MsgBox.showInfo("单据已启用，不能执行此操作！");
				SysUtil.abort();
			}
		}
		super.actionEdit_actionPerformed(e);
	}
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();
		List listID = this.getSelectedIdValues();
		for (int i = 0; i < listID.size(); i++) {
			DesignVisibilityInfo info = DesignVisibilityFactory.getRemoteInstance().getDesignVisibilityInfo(new ObjectUuidPK((String)listID.get(i)));
			if(info.isIsEnabled()){
				MsgBox.showInfo("单据已启用，不能执行此操作！");
				SysUtil.abort();
			}
		}
		super.actionRemove_actionPerformed(e);
	}
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignVisibilityFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignVisibilityInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignVisibilityInfo();
		
        return objectValue;
    }

}