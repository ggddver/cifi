/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.client;

import java.awt.event.*;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fdc.basecrm.CRMHelper;
import com.kingdee.eas.fdc.invite.BaseInviteEntryInfo;
import com.kingdee.eas.fdc.invite.BaseInviteInfo;
import com.kingdee.eas.fdc.invite.InviteBidEvaluationEntrysCollection;
import com.kingdee.eas.fdc.invite.InviteBidEvaluationEntrysFactory;
import com.kingdee.eas.fdc.invite.InviteBidEvaluationEntrysInfo;
import com.kingdee.eas.fdc.invite.InviteBidEvaluationFactory;
import com.kingdee.eas.fdc.invite.InviteBidEvaluationInfo;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class InviteBidEvaluationEditUI extends AbstractInviteBidEvaluationEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(InviteBidEvaluationEditUI.class);
    public InviteBidEvaluationEditUI() throws Exception
    {
        super();
    }
    public void storeFields()
	{
		super.storeFields();
		storeEntry();
	}
	public void loadFields() {
		detachListeners();
		super.loadFields();
		setSaveActionStatus();
		
		loadEntry();
//		loadOther();
		
		attachListeners();
		setAuditButtonStatus(this.getOprtState());
		
		super.loadFields();
	}
	protected void loadEntry(){
		InviteBidEvaluationEntrysCollection col=editData.getEntry();
		CRMHelper.sortCollection(col, "seq", true);
		this.kdtEntry.removeRows();
		for(int i=0;i<col.size();i++){
			InviteBidEvaluationEntrysInfo entry=col.get(i);
			IRow row=this.kdtEntry.addRow();
			row.setUserObject(entry);
			row.getCell("content").setValue(entry.getContent());
			row.getCell("time").setValue(entry.getTime());
			try {
				row.getCell("attach").setValue(loadAttachment(entry.getId().toString()));
			} catch (BOSException e) {
				e.printStackTrace();
			}
		}
	}	
	protected void storeEntry(){
    	editData.getEntry().clear();
    	for(int i=0;i<this.kdtEntry.getRowCount();i++){
    		IRow row = this.kdtEntry.getRow(i);
    		InviteBidEvaluationEntrysInfo entry=(InviteBidEvaluationEntrysInfo) row.getUserObject();
    		entry.setSeq(i);
    		entry.setContent((String)row.getCell("content").getValue());
    		entry.setTime((Date)row.getCell("time").getValue());
    		editData.getEntry().add(entry);
    	}
    }
	protected ICoreBase getBizInterface() throws Exception {
		return InviteBidEvaluationFactory.getRemoteInstance();
	}
	public SelectorItemCollection getSelectors() {
		SelectorItemCollection sic = super.getSelectors();;
		sic.add(new SelectorItemInfo("state"));
		sic.add(new SelectorItemInfo("orgUnit.*"));
		
		sic.add(new SelectorItemInfo("entry.*"));
		
		sic.add(new SelectorItemInfo("inviteProject.inviteType.*"));
		sic.add(new SelectorItemInfo("inviteProject.programmingContract.*"));
		sic.add(new SelectorItemInfo("inviteProject.project.*"));
		
		sic.add(new SelectorItemInfo("inviteProject.*"));
		
		
		return sic;
	}
	protected void attachListeners() {

	}

	protected void detachListeners() {

	}
	protected String getTDFileName() {
		return "/bim/fdc/invite/InviteBidEvaluationForPrint";
	}
	protected IMetaDataPK getTDQueryPK() {
		return new MetaDataPK(
				"com.kingdee.eas.fdc.invite.app.InviteBidEvaluationForPrintQuery");
	}
	
	protected BaseInviteInfo createNewDate() {
		InviteBidEvaluationInfo info=new InviteBidEvaluationInfo();
		createBaseInvite(info);
		return info;
	}
	protected CoreBillEntryBaseInfo createNewEntryDate() {
		return new InviteBidEvaluationEntrysInfo();
	}
	
	protected void closeDeleteAttachment(){
		if(editData!=null){
			for(int i=0;i<this.editData.getEntry().size();i++){
				try {
					/*if(this.editData.getEntry().get(i).getId() !=null && !InviteBidEvaluationEntrysFactory.getRemoteInstance().exists(new ObjectUuidPK(this.editData.getEntry().get(i).getId().toString()))){
					}*/
					
					if(!BaseInviteEditUI.checkExist("T_INV_InviteBidEvaluationEntry", this.editData.getEntry().get(i).getId().toString())) {
						this.deleteAttachment(this.editData.getEntry().get(i).getId().toString());
					}
				} catch (EASBizException e) {
					e.printStackTrace();
				} catch (BOSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}