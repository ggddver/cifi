/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.subill.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.event.ChangeEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.KDTableHelper;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.KDComboBox;
import com.kingdee.bos.ctrl.swing.KDContainer;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDPromptBox;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.org.OrgConstants;
import com.kingdee.eas.basedata.org.OrgStructureInfo;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitFactory;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.cp.bc.BizCollUtil;
import com.kingdee.eas.fdc.basedata.client.FDCClientVerifyHelper;
import com.kingdee.eas.fdc.basedata.client.FDCMsgBox;
import com.kingdee.eas.fdc.invite.InviteTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockLinkPersonCollection;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockLinkPersonFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockSupplierSplAreaEntryInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAccreditationTypeCollection;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAccreditationTypeFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAccreditationTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateE1Collection;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateE1Factory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateE1Info;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAuditIndexInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationCollection;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationFactory;
import com.kingdee.eas.fdc.invite.designsupplier.uitls.WorkFlow;
import com.kingdee.eas.fdc.invite.supplier.IsGradeEnum;
import com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum;
import com.kingdee.eas.framework.client.ListUI;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 * 供应商评定
 */
public class DesignSupplierEvaluationEditUI extends AbstractDesignSupplierEvaluationEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(DesignSupplierEvaluationEditUI.class);
    protected Map listenersMap = new HashMap();
    /**
     * output class constructor
     */
    public DesignSupplierEvaluationEditUI() throws Exception
    {
        super();
    }
    
    public void onLoad() throws Exception {
    	this.pkauditDate.setEnabled(false);
    	this.txtsupplierName.setEnabled(false);
    	this.txtDesignType.setEnabled(false);
    	this.prmtsupplierClas.setEnabled(false);
    	this.txtServiceArea.setEnabled(false);
    	this.Ishg.setEnabled(false);
    	this.txtAuthorizedPer.setEnabled(false);
    	this.txtAuthorizedTel.setEnabled(false);
    	this.txtjob.setEnabled(false);
    	super.onLoad();
    	initF7();
    	initButtonAction();
    	initControl();
    	initTable();
    	

    	this.chkMenuItemSubmitAndAddNew.setSelected(false);
    	this.chkMenuItemSubmitAndAddNew.setEnabled(false);
    }
    
    private void initF7() throws BOSException{
    	this.prmtsupplierTemple.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.designbase.app.DesignAppraiseTemplateQuery");		
        this.prmtsupplierTemple.setEditable(true);		
        this.prmtsupplierTemple.setDisplayFormat("$name$");		
        this.prmtsupplierTemple.setEditFormat("$number$");		
        this.prmtsupplierTemple.setCommitFormat("$number$");
    	this.contsupplierClas.setBoundLabelText("评定前等级");
    	if(OprtState.ADDNEW.equals(getOprtState())){
    		String oql = "select * order by number asc";
    		DesignAccreditationTypeCollection  coll = DesignAccreditationTypeFactory.getRemoteInstance().getDesignAccreditationTypeCollection(oql);
    		this.prmtEvaluationType.setValue((coll.size()>0)?coll.get(0):null);
    	}
    }
    
    private void initButtonAction(){
    	this.actionAddNew.setVisible(false);//新增
		this.actionRemove.setVisible(false);//删除
		this.actionCopy.setVisible(false);//复制新增
    	this.actionPrint.setVisible(false);//打印
    	this.actionPrintPreview.setVisible(false);//打印预览
		this.actionCreateTo.setVisible(false);//推式生成
		this.actionCreateFrom.setVisible(false);//拉式生成
		this.actionTraceUp.setVisible(false);//上查
		this.actionTraceDown.setVisible(false);//下查 
		this.actionFirst.setVisible(false);//第一
		this.actionPre.setVisible(false);//前一
		this.actionNext.setVisible(false);//后一
		this.actionLast.setVisible(false);//最后一个
		this.contstate.setVisible(false);
		this.contDesignTypeID.setVisible(false);
		this.txtNumber.setRequired(true);//给单据编号
		this.prmtsupplierNumber.setRequired(true);
		this.pkBizDate.setRequired(true);
		this.prmtEvaluationType.setRequired(true);
		this.prmtsupplierTemple.setRequired(true);
		this.prmtsupplierlastClas.setRequired(true);
		this.resuitl.setRequired(true);
    }
    
    public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
    	if(!this.state.getSelectedItem().equals(SupplierStateEnum.SAVE)&&!this.state.getSelectedItem().equals(SupplierStateEnum.SUBMIT)){
    		MsgBox.showWarning("当前单据已["+this.state.getSelectedItem().toString()+"]，不能修改！");SysUtil.abort();
    	}
    	if(editData.getId()!=null)
    		WorkFlow.checkBillInWorkflow(this, editData.getId().toString());
    	super.actionEdit_actionPerformed(arg0);
    	this.actionSave.setEnabled((OprtState.ADDNEW.equals(getOprtState()))?true:false);
    }
    
    private void initControl() throws BOSException{
    	this.contLastUpdateUser.setVisible(true);
    	this.contLastUpdateTime.setVisible(true);
        kDContainer1.getContentPane().add(kdtEntrys, BorderLayout.CENTER);
        if(OprtState.ADDNEW.equals(getOprtState())){
        	this.resuitl.setSelectedItem(null);
        }
        this.kdtEntrys.getColumn("Review").getStyleAttributes().setLocked(true);
        this.kdtEntrys.getColumn("IndexName").getStyleAttributes().setLocked(true);
        this.kdtEntrys.getColumn("IsQualified").setRequired(true);
        this.kdtEntrys.getColumn("Casedescription").setRequired(true);
        setF7Filter((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue(), (DesignAccreditationTypeInfo)this.prmtEvaluationType.getValue(), (DesignAppraiseTemplateInfo)this.prmtsupplierTemple.getValue());
        this.contInvTyep.setVisible(false);
        this.contIshg.setVisible(false);
        this.actionSave.setEnabled((OprtState.ADDNEW.equals(getOprtState()))?true:false);
        this.contsupplierlastClas.setBoundLabelText("拟评定供应商等级");
        this.resuitl.removeItem(ResultsEnum.yl);
        this.contsupplierName.getBoundLabel().setForeground(Color.RED);
    }
    
    private void initTable(){
    	for (int i = 0; i < kdtEntrys.getRowCount(); i++) {
        	KDTableHelper.autoFitRowHeight(this.kdtEntrys, i);
		}
    	this.kdtEntrys.getColumn("Casedescription").getStyleAttributes().setWrapText(true);
    }
    protected void verifyInputForSubmit() throws Exception {
    	verifyInputForSave();
    	//合格与否，情况描述的输入校验
    	FDCClientVerifyHelper.verifyInput(this, this.kdtEntrys, "IsQualified");
    	FDCClientVerifyHelper.verifyInput(this, this.kdtEntrys, "Casedescription");
    }
    
    
    /*
     * (non-Javadoc)
     * @see com.kingdee.eas.fdc.invite.designsupplier.subill.client.AbstractDesignSupplierEvaluationEditUI#prmtsupplierNumber_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent)
     * 供应商编号选定带出相应的值
     */
    protected void prmtsupplierNumber_dataChanged(DataChangeEvent e)
    		throws Exception {
    	  setF7Filter((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue(), (DesignAccreditationTypeInfo)this.prmtEvaluationType.getValue(), (DesignAppraiseTemplateInfo)this.prmtsupplierTemple.getValue());
    	if(this.prmtsupplierNumber.getValue()!=null){
    		BOSUuid Id = ((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue()).getId();
    		DesignSupplierStockInfo info = DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(Id));
    		PurchaseOrgUnitInfo PurchaseOrginfo = PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(info.getPurchaseOrgUnit().getId()));
    		InviteTypeInfo InvTypeInfo = com.kingdee.eas.fdc.invite.InviteTypeFactory.getRemoteInstance().getInviteTypeInfo(new ObjectUuidPK(info.getInviteType().getId()));
			if(info.getGatadeLv()!=null){
				this.prmtsupplierClas.setValue(DesignGradeSetUpFactory.getRemoteInstance().getDesignGradeSetUpInfo(new ObjectUuidPK(info.getGatadeLv().getId())));
			}else{
				this.prmtsupplierClas.setValue(null);
			}
			String entryOql = "select * where parent.id ='"+Id.toString()+"' and isDefault='1'";
			DesignSupplierStockLinkPersonCollection entryColl = DesignSupplierStockLinkPersonFactory.getRemoteInstance().getDesignSupplierStockLinkPersonCollection(entryOql);
			if(entryColl.size()>0){
				this.txtAuthorizedPer.setText(entryColl.get(0).getPersonName());
				this.txtAuthorizedTel.setText(entryColl.get(0).getPhone());
				this.txtjob.setText(entryColl.get(0).getPosition());
			}else{
				this.txtjob.setText(null);
			}
    		this.txtsupplierName.setText(info.getName());//供应商名字
    		this.prmtInvTyep.setValue(InvTypeInfo);
    		this.txtDesignTypeID.setText(InvTypeInfo.getId().toString());
    		this.txtDesignType.setText(InvTypeInfo.getName());
    		this.prmtOrg.setValue(PurchaseOrginfo);
    		this.prmtsupplierlastClas.setValue(null);
    		String area = "";
    		for (int i = 0; i < info.getSupplierSplAreaEntry().size(); i++) {
    			DesignSupplierStockSupplierSplAreaEntryInfo entryInfo = info.getSupplierSplAreaEntry().get(i);
    			DesignServiceAreaInfo AreaInfo = DesignServiceAreaFactory.getRemoteInstance().getDesignServiceAreaInfo(new ObjectUuidPK(entryInfo.getFdcSplArea().getId())) ;
    			if("".equals(area.trim()))
    				area += AreaInfo.getName();
    			else
    				area += ";"+AreaInfo.getName();
			}
    		this.txtServiceArea.setText(area);
    	}
    }
    
    //加载过滤
    public void loadFields() {
    	DesignGradeSetUpInfo info = editData.getSupplierlastClas();
    	DesignGradeSetUpInfo info1 = editData.getSupplierClas();
    	SupplierStateEnum State = editData.getState();
    	ResultsEnum States = editData.getResuitl();
    	IsGradeEnum S = editData.getIshg();
    	PurchaseOrgUnitInfo Org = editData.getOrg();
    	PurchaseOrgUnitInfo PusOrg = editData.getPusOrg();
    	InviteTypeInfo  InvoIceInfo = editData.getInvTyep();
    	String  remake = editData.getRemkae();
    	detachListeners();
    	super.loadFields();
    	attachListeners();
    	editData.setSupplierClas(info1);
    	editData.setSupplierlastClas(info);
    	editData.setState(State);
    	editData.setOrg(Org);
    	editData.setInvTyep(InvoIceInfo);
    	editData.setPusOrg(PusOrg);
    	editData.setRemkae(remake);
    	this.prmtsupplierClas.setValue(info1);
    	this.prmtsupplierlastClas.setValue(info);
    	this.state.setSelectedItem(State);
    	this.resuitl.setSelectedItem(States);
    	this.Ishg.setSelectedItem(S);
    	this.prmtOrg.setValue(Org);
    	this.prmtInvTyep.setValue(InvoIceInfo);
    	this.prmtPusOrg.setValue(PusOrg);
    	this.txtremkae.setText(remake);
    }
    
    protected void attachListeners() {
		addDataChangeListener(this.prmtsupplierlastClas);
		addDataChangeListener(this.prmtsupplierNumber);
	}
	protected void detachListeners() {
		removeDataChangeListener(this.prmtsupplierlastClas);
		removeDataChangeListener(this.prmtsupplierNumber);
	}
    protected void addDataChangeListener(JComponent com) {
    	EventListener[] listeners = (EventListener[] )listenersMap.get(com);
    	if(listeners!=null && listeners.length>0){
	    	if(com instanceof KDPromptBox){
	    		for(int i=0;i<listeners.length;i++){
	    			((KDPromptBox)com).addDataChangeListener((DataChangeListener)listeners[i]);
	    		}
	    	}else if(com instanceof KDFormattedTextField){
	    		for(int i=0;i<listeners.length;i++){
	    			((KDFormattedTextField)com).addDataChangeListener((DataChangeListener)listeners[i]);
	    		}
	    	}else if(com instanceof KDDatePicker){
	    		for(int i=0;i<listeners.length;i++){
	    			((KDDatePicker)com).addDataChangeListener((DataChangeListener)listeners[i]);
	    		}
	    	} else if(com instanceof KDComboBox){
	    		for(int i=0;i<listeners.length;i++){
	    			((KDComboBox)com).addItemListener((ItemListener)listeners[i]);
	    		}
	    	}
    	}
    }
    protected void removeDataChangeListener(JComponent com) {
		EventListener[] listeners = null;	
		if(com instanceof KDPromptBox){
			listeners = com.getListeners(DataChangeListener.class);	
    		for(int i=0;i<listeners.length;i++){
    			((KDPromptBox)com).removeDataChangeListener((DataChangeListener)listeners[i]);
    		}
    	}else if(com instanceof KDFormattedTextField){
    		listeners = com.getListeners(DataChangeListener.class);	
    		for(int i=0;i<listeners.length;i++){
    			((KDFormattedTextField)com).removeDataChangeListener((DataChangeListener)listeners[i]);
    		}
    	}else if(com instanceof KDDatePicker){
    		listeners = com.getListeners(DataChangeListener.class);	
    		for(int i=0;i<listeners.length;i++){
    			((KDDatePicker)com).removeDataChangeListener((DataChangeListener)listeners[i]);
    		}
    	}else if(com instanceof KDComboBox){
    		listeners = com.getListeners(ItemListener.class);	
    		for(int i=0;i<listeners.length;i++){
    			((KDComboBox)com).removeItemListener((ItemListener)listeners[i]);
    		}
    	} 
		if(listeners!=null && listeners.length>0){
			listenersMap.put(com,listeners );
		}
    }
    
    public void storeFields() {
    	super.storeFields();
    }
    
    protected void prmtEvaluationType_dataChanged(DataChangeEvent e)throws Exception {
    	super.prmtEvaluationType_dataChanged(e);
    	if(e!=null){
			boolean isChanged = BizCollUtil.isF7ValueChanged(e);
			if(!isChanged){
				return;
			}
			this.prmtsupplierTemple.setValue(null);
		}
    	setF7Filter((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue(), (DesignAccreditationTypeInfo)this.prmtEvaluationType.getValue(), (DesignAppraiseTemplateInfo)this.prmtsupplierTemple.getValue());
    }
    
    
   //评审模板改变带出相应的值
    protected void prmtsupplierTemple_dataChanged(DataChangeEvent e)
    		throws Exception {
    	setF7Filter((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue(), (DesignAccreditationTypeInfo)this.prmtEvaluationType.getValue(), (DesignAppraiseTemplateInfo)this.prmtsupplierTemple.getValue());
    	boolean isChanged = true;
		isChanged = BizCollUtil.isF7ValueChanged(e);
        if(!isChanged){
        	return;
        }
    	if(this.prmtsupplierTemple.getValue()!=null){
    		DesignAppraiseTemplateInfo TempInfo = (DesignAppraiseTemplateInfo)this.prmtsupplierTemple.getValue();
    		boolean isShowWarn=false;
            boolean isUpdate=false;
            if(this.kdtEntrys.getRowCount()>0){
            	isShowWarn=true;
            }
            if(isShowWarn){
            	if(FDCMsgBox.showConfirm2(this, "评审模板改变会覆盖供应商评审数据，是否继续？")== FDCMsgBox.YES){
            		isUpdate=true;
                }
            }else{
            	isUpdate=true;
            }
            
            if(isUpdate){
            	this.kdtEntrys.removeRows();
            	if(TempInfo!=null){
            		this.storeFields();
            		TempInfo = DesignAppraiseTemplateFactory.getRemoteInstance().getDesignAppraiseTemplateInfo(new ObjectUuidPK(TempInfo.getId()));
            		DesignAppraiseTemplateE1Collection guideEntry=TempInfo.getE1();
            		for(int i=0;i<guideEntry.size();i++){
            			DesignAppraiseTemplateE1Info e1info = DesignAppraiseTemplateE1Factory.getRemoteInstance().getDesignAppraiseTemplateE1Info(new ObjectUuidPK(guideEntry.get(i).getId()));
            			DesignAuditIndexInfo IndexInfo = DesignAuditIndexFactory.getRemoteInstance().getDesignAuditIndexInfo(new ObjectUuidPK(e1info.getIndexName().getId()));
            			IRow  irow = kdtEntrys.addRow();
            			irow.getCell("Review").setValue(e1info.getAccreditationwd());
            			irow.getCell("IndexName").setValue(IndexInfo);
            			irow.getCell("Casedescription").setValue(e1info.getIndexDesc());
            		}
            	}
            	for (int i = 0; i < kdtEntrys.getRowCount(); i++) {
                	KDTableHelper.autoFitRowHeight(this.kdtEntrys, i);
        		}
            }
    	}
    }
    
    protected void kdtEntrys_editStopped(KDTEditEvent e) throws Exception {
    	super.kdtEntrys_editStopped(e);
    	if(e.getRowIndex()!=-1)
			KDTableHelper.autoFitRowHeight(this.kdtEntrys, e.getRowIndex());
    }
    
    /*
     * (non-Javadoc)
     * @see com.kingdee.eas.fdc.invite.designsupplier.subill.client.AbstractDesignSupplierEvaluationEditUI#prmtsupplierlastClas_stateChanged(javax.swing.event.ChangeEvent)
     * 供应商等级评定改变事件
     */
    protected void prmtsupplierlastClas_stateChanged(ChangeEvent e)
    		throws Exception {
    	super.prmtsupplierlastClas_stateChanged(e);
//    	if(this.prmtsupplierlastClas.getValue()!=null){
//    		DesignGradeSetUpInfo info = (DesignGradeSetUpInfo)this.prmtsupplierlastClas.getValue();
//    		this.Ishg.setSelectedItem(info.getISheg());
//    		if(this.prmtsupplierNumber.getValue()!=null){
//        		BOSUuid Id = ((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue()).getId();
//        		DesignSupplierStockInfo SuStockinfo = DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(Id));
////    			String id     = (this.prmtsupplierClas.getValue()!=null)?((DesignGradeSetUpInfo)this.prmtsupplierClas.getValue()).getId().toString():"";
////    			String lastid = (this.prmtsupplierlastClas.getValue()!=null)?((DesignGradeSetUpInfo)this.prmtsupplierlastClas.getValue()).getId().toString():"";
////        		if(id.equals(lastid)&&!SuStockinfo.getIsPass().equals(ResultsEnum.bhg)){
////    	    		MsgBox.showWarning("当前供应商已经是 ["+((DesignGradeSetUpInfo)this.prmtsupplierlastClas.getValue()).getName()+"]供应商，请重新选择供应商级别进行评定！");
////    	    		this.prmtsupplierlastClas.setValue(null);SysUtil.abort();
////    			}
//    			if(!"00000000-0000-0000-0000-000000000000CCE7AED4".equals(SuStockinfo.getPurchaseOrgUnit().getId().toString())&&!"001".equals(info.getNumber())){
//    				int valueNmber = Integer.parseInt(info.getNumber());
//    				String oqldesig = "select * where supplierNumber.id='"+Id.toString()+"'";
//    				oqldesig += (editData.getId()!=null)?"and id <>'"+editData.getId().toString()+"' and state='7' ":" and state='7'";
//    				boolean flse = true;
//    				DesignSupplierEvaluationCollection EvalColl = DesignSupplierEvaluationFactory.getRemoteInstance().getDesignSupplierEvaluationCollection(oqldesig);
//    				for (int i = 0; i < EvalColl.size(); i++) {
//    					int Number = Integer.parseInt(DesignGradeSetUpFactory.getRemoteInstance().getDesignGradeSetUpInfo(new ObjectUuidPK(EvalColl.get(i).getSupplierlastClas().getId())).getNumber());
//    					if(valueNmber-1==Number){
//    						flse = false;
//    					}
//    				}
//    				if(flse){
//    					this.prmtsupplierlastClas.setValue(null);
//    					String number = "00"+String.valueOf(valueNmber-1);
//    					String Name = DesignGradeSetUpFactory.getRemoteInstance().getDesignGradeSetUpInfo("where number='"+number+"' and isEnabled='1'").getName();
//    					MsgBox.showWarning("当前供应商为事业部层面发起供应商，需要按照合格->事业部战略->集团战略的层级进行评定，不可跨级评定,当前供应商未做["+Name+"]评定或未审批！");SysUtil.abort();
//    				}
//    			}
//        	}else{
//        		this.prmtsupplierlastClas.setValue(null);
//        		MsgBox.showWarning("请先选择供应商！");SysUtil.abort();
//        	}
//    	}else{
//    		this.Ishg.setSelectedItem(null);
//    	}
    	
    	if(this.prmtsupplierNumber.getValue()!=null){
    		BOSUuid Id=((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue()).getId();
    		DesignSupplierStockInfo supplierInfo=DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(Id));
    		String purOrg=supplierInfo.getPurchaseOrgUnit().getId().toString();
    		PurchaseOrgUnitInfo purOrgInfo=PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(purOrg) );
    		String purOrgInfos=purOrgInfo.getId().toString();//当前的供应商组织
    		
    		if(this.prmtsupplierlastClas.getValue()!=null){
    		  
    		   DesignGradeSetUpInfo info = (DesignGradeSetUpInfo)this.prmtsupplierlastClas.getValue();//拟升降供应商等级
      		   int infoId= Integer.parseInt(info.getNumber());//后评估编号
      		   String number = "00"+String.valueOf(infoId);
    		

           if(this.prmtsupplierClas.getValue()!=null){
        	   
        	   DesignGradeSetUpInfo infos = (DesignGradeSetUpInfo)this.prmtsupplierClas.getValue(); //审前供应商等级
    		   int beInfoId= Integer.parseInt(infos.getNumber());//审前编号
    		   String beNumber = "00"+String.valueOf(beInfoId);
    			 //当前为事业部
       		   if(!(purOrgInfos.equals("00000000-0000-0000-0000-000000000000CCE7AED4"))){
       			   if("001".equals(beNumber)){
       				  if("003".equals(number)){
       				   MsgBox.showWarning("当前所属组织是"+purOrgInfo+"不能升到"+info);
	  		           this.prmtsupplierlastClas.setValue(null); 
       				 }
       			 }else if("002".equals(beNumber)){
       				 if("003".equals(number)){
       				  MsgBox.showWarning("当前所属组织是"+purOrgInfo+"不能升到"+info);
  	  		          this.prmtsupplierlastClas.setValue(null);
       				 }else if("004".equals(number)){
       					MsgBox.showWarning("当前评审等级不允许进行跨级评定");
  	  		          this.prmtsupplierlastClas.setValue(null); 
       				 }
       				 
       			 }else if("004".equals(beNumber)){
       				if("002".equals(number)||"003".equals(number)){
        				MsgBox.showWarning("当前评审等级不允许进行跨级评定");
    	  		          this.prmtsupplierlastClas.setValue(null);
        		  }
       			 }
       		 }
       		 else if(purOrgInfos.equals("00000000-0000-0000-0000-000000000000CCE7AED4")){
       			if("001".equals(beNumber)){
       				if("002".equals(number)){
       				  MsgBox.showWarning("当前所属组织是"+purOrgInfo+"不能降到"+info);
	  		          this.prmtsupplierlastClas.setValue(null); 
       				}
       			}else if("003".equals(beNumber)){
       				if("004".equals(number)){
       				  MsgBox.showWarning("当前评审等级不允许进行跨级评定");
  	  		          this.prmtsupplierlastClas.setValue(null);
       				}else if("002".equals(number)){
       					MsgBox.showWarning("当前评审等级不允许进行跨级评定");
    	  		        this.prmtsupplierlastClas.setValue(null);
       				}
       			}else if("004".equals(beNumber)){
       				if("002".equals(number)||"003".equals(number)){
       				 MsgBox.showWarning("当前评审等级不允许进行跨级评定");
 	  		         this.prmtsupplierlastClas.setValue(null);
       				}
       			}
       		 }
    	  }else {
    		   if("002".equals(number)||"003".equals(number)){
 				  MsgBox.showWarning("当前评审等级不允许进行跨级升");
	  		          this.prmtsupplierlastClas.setValue(null);
    		    }
    		   
            }
    	}
     }
    }
    
    protected void setF7Filter(DesignSupplierStockInfo supplier,DesignAccreditationTypeInfo type,DesignAppraiseTemplateInfo template) throws BOSException{
    	prmtsupplierTemple.setEnabled(false);
    	prmtEvaluationType.setEnabled(false);
    	EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		Set org=new HashSet();
		if(editData.getOrg()!=null){
			org.add(editData.getOrg().getId().toString());
		}
		org.add(OrgConstants.DEF_CU_ID);
		filter.getFilterItems().add(new FilterItemInfo("state",Integer.valueOf(SupplierStateEnum.APPROVE_VALUE)));
		filter.getFilterItems().add(new FilterItemInfo("purchaseOrgUnit.id",org,CompareType.INCLUDE));
		view.setFilter(filter);
		this.prmtsupplierNumber.setEntityViewInfo(view);
		
		view = new EntityViewInfo();
		filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("isEnable",Boolean.TRUE));
		view.setFilter(filter);
		this.prmtEvaluationType.setEntityViewInfo(view);
		
		view = new EntityViewInfo();
		filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("isEnabled",Boolean.TRUE));
		view.setFilter(filter);
		this.prmtsupplierClas.setEntityViewInfo(view);
		this.prmtsupplierlastClas.setEntityViewInfo(view);
		
		view = new EntityViewInfo();
		filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("isEnable",Boolean.TRUE));
		if(this.prmtEvaluationType.getValue()!=null){
			filter.getFilterItems().add(new FilterItemInfo("AccreditationType.id",((DesignAccreditationTypeInfo)this.prmtEvaluationType.getValue()).getId()));
		}
		view.setFilter(filter);
		this.prmtsupplierTemple.setEntityViewInfo(view);
		if(supplier!=null){
	    	prmtEvaluationType.setEnabled(true);
		}if(supplier!=null&&type!=null){
			prmtsupplierTemple.setEnabled(true);
			prmtEvaluationType.setEnabled(true);
		}
	}
    
    protected void verifyInputForSave() throws Exception {
    	FDCClientVerifyHelper.verifyEmpty(this, this.txtNumber);//判断单据编号不为空
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtsupplierNumber);
		FDCClientVerifyHelper.verifyEmpty(this, this.pkBizDate);
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtEvaluationType);
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtsupplierTemple);
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtsupplierlastClas);
		FDCClientVerifyHelper.verifyEmpty(this, this.resuitl);
    }
    
    protected void initProWorkButton(KDContainer container,boolean flse){
    	KDWorkButton btnAddRowinfo=new KDWorkButton();
    	KDWorkButton btnInsertRowinfo=new KDWorkButton();
    	KDWorkButton btnDeleteRowinfo=new KDWorkButton();
    	btnAddRowinfo.setEnabled((OprtState.EDIT.equals(getOprtState())||OprtState.ADDNEW.equals(getOprtState()))?true:false);
    	btnInsertRowinfo.setEnabled((OprtState.EDIT.equals(getOprtState())||OprtState.ADDNEW.equals(getOprtState()))?true:false);
    	btnDeleteRowinfo.setEnabled((OprtState.EDIT.equals(getOprtState())||OprtState.ADDNEW.equals(getOprtState()))?true:false);
    	btnAddRowinfo.setIcon( EASResource.getIcon("imgTbtn_addline"));
    	container.addButton(btnAddRowinfo);
		btnAddRowinfo.setText(getResource("addRow"));
		btnAddRowinfo.setSize(new Dimension(140, 19));
		btnAddRowinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	try {
					kdtEntrys_detailPanel.actionInsertLine_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        });
		
		btnInsertRowinfo.setIcon( EASResource.getIcon("imgTbtn_addline"));
    	container.addButton(btnInsertRowinfo);
		btnInsertRowinfo.setText(getResource("insertRow"));
		btnInsertRowinfo.setSize(new Dimension(140, 19));
		btnInsertRowinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	try {
            		kdtEntrys_detailPanel.actionInsertLine_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        });
		
		btnDeleteRowinfo.setIcon( EASResource.getIcon("imgTbtn_addline"));
    	container.addButton(btnDeleteRowinfo);
		btnDeleteRowinfo.setText(getResource("deleteRow"));
		btnDeleteRowinfo.setSize(new Dimension(140, 19));
		btnDeleteRowinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	try {
            		kdtEntrys_detailPanel.actionRemoveLine_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        });
    }
    
    private String getResource(String msg) {
		return EASResource.getString("com.kingdee.eas.fdc.invite.supplier.SupplierResource", msg);
	}
    
    public void actionSave_actionPerformed(ActionEvent e) throws Exception {
    	verifyInputForSave();
    	super.actionSave_actionPerformed(e);
    }
    
    /*
     * (non-Javadoc)
     * @see com.kingdee.eas.fdc.invite.designsupplier.subill.client.AbstractDesignSupplierEvaluationEditUI#actionSubmit_actionPerformed(java.awt.event.ActionEvent)
     * 提交的方法
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
    	verifyInputForSubmit();
    	super.actionSubmit_actionPerformed(e);
    	setOprtState(OprtState.VIEW);
    	com.kingdee.eas.util.client.MsgBox.showWarning("当前的单据状态是"+editData.getState());
    	if (getOprtState().equals(OprtState.ADDNEW) || getOprtState().equals(OprtState.EDIT))
			((ListUI) getUIContext().get(UIContext.OWNER)).getMainTable().removeRows();
    }
    
    protected void afterSubmitAddNew(){
    	
    }
	protected boolean isContinueAddNew() {
		return false;
	}

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     * 创建单据
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setState(SupplierStateEnum.SAVE);
        if(getUIContext().get("org")!=null){
			try {
				PurchaseOrgUnitInfo orgUnitInfo = PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(((OrgStructureInfo) getUIContext().get("org")).getUnit().getId()));
				objectValue.setOrg(orgUnitInfo);
				objectValue.setPusOrg(orgUnitInfo);
			} catch (EASBizException e) {
				e.printStackTrace();
			} catch (BOSException e) {
				e.printStackTrace();
			}
		}
        return objectValue;
    }

}