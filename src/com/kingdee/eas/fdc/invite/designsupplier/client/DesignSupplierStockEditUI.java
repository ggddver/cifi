/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.ItemAction;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.attachment.BizobjectFacadeFactory;
import com.kingdee.eas.base.attachment.BoAttchAssoCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoFactory;
import com.kingdee.eas.base.attachment.client.AttachmentUIContextInfo;
import com.kingdee.eas.base.attachment.common.AttachmentClientManager;
import com.kingdee.eas.base.attachment.common.AttachmentManagerFactory;
import com.kingdee.eas.base.codingrule.CodingRuleException;
import com.kingdee.eas.base.uiframe.client.UIFactoryHelper;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.org.OrgStructureInfo;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitFactory;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.cp.bc.BizCollUtil;
import com.kingdee.eas.fdc.basecrm.CRMHelper;
import com.kingdee.eas.fdc.basedata.FDCBasedataException;
import com.kingdee.eas.fdc.basedata.FDCCommonServerHelper;
import com.kingdee.eas.fdc.basedata.FDCDataBaseInfo;
import com.kingdee.eas.fdc.basedata.FDCHelper;
import com.kingdee.eas.fdc.basedata.client.FDCBaseDataClientUtils;
import com.kingdee.eas.fdc.basedata.client.FDCClientVerifyHelper;
import com.kingdee.eas.fdc.basedata.client.FDCMsgBox;
import com.kingdee.eas.fdc.basedata.client.FDCUIWeightWorker;
import com.kingdee.eas.fdc.basedata.client.IFDCWork;
import com.kingdee.eas.fdc.invite.InviteTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockLinkPersonCollection;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockLinkPersonInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockSupplierAttachListEntryCollection;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockSupplierAttachListEntryInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockSupplierPersonEntryCollection;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockSupplierPersonEntryInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockSupplierServiceTypeCollection;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockSupplierServiceTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockSupplierSplAreaEntryCollection;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockSupplierSplAreaEntryInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesSupplierFileTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAccreditationTypeFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignLevelSetUpFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignLevelSetUpInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignPhaseFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignPhaseInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceTypeFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignSupplierAttachListCollection;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignSupplierAttachListFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignSupplierAttachListInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.ProductTypeFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.ProductTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraise;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseCollection;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseFactory;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationCollection;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationFactory;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectCollection;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectFactory;
import com.kingdee.eas.fdc.invite.designsupplier.subill.client.DesignSupplierAppraiseListUI;
import com.kingdee.eas.fdc.invite.designsupplier.subill.client.DesignSupplierEvaluationListUI;
import com.kingdee.eas.fdc.invite.designsupplier.subill.client.DesignSupplierSelectListUI;
import com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.formatter.Formatter;
import com.kingdee.bos.ctrl.kdf.servertable.KDTStyleConstants;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.ctrl.swing.KDComboBox;
import com.kingdee.bos.ctrl.swing.KDContainer;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDPromptBox;
import com.kingdee.bos.ctrl.swing.KDScrollPane;
import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class DesignSupplierStockEditUI extends AbstractDesignSupplierStockEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(DesignSupplierStockEditUI.class);
    protected Map listenersMap = new HashMap();
    /**
     * output class constructor
     */
    public DesignSupplierStockEditUI() throws Exception
    {
        super();
    }
    public void onLoad() throws Exception {
    	initTable();
		super.onLoad();
		initF7();
		initControl();
		kDPanel3.setVisible(false);
		this.actionRemove.setVisible(false);
		contRegisterMoney.setVisible(false);
		contCurrency.setVisible(false);
		contDesignJD.setVisible(false);
		contServiceType.setVisible(false);
		contpodutId.setVisible(false);
		contRecommended.setVisible(false);
		contVisibility.setVisible(false);
		contserverfees.setVisible(false);
		contPostNumber.setVisible(false);
		kDTabbedPane1.add(panelBill, "评定信息");
		kDContainer1.getContentPane().setLayout(new BorderLayout(0, 0));        
        kDContainer1.getContentPane().add(kdtProject, BorderLayout.CENTER);
        this.kdtProject.getColumn("seq").getStyleAttributes().setHided(true);
        this.actionAttachment.setVisible(true);
        this.btnAttachment.setEnabled(true);
	}
    public SelectorItemCollection getSelectors() {
    	SelectorItemCollection sel=super.getSelectors();
    	sel.add("supplierServiceType.*");
    	sel.add("supplierServiceType.serviceType.*");
    	sel.add("supplierSplAreaEntry.*");
    	sel.add("supplierSplAreaEntry.fdcSplArea.*");
    	sel.add("supplierPersonEntry.*");
    	sel.add("supplierAttachListEntry.*");
    	sel.add("linkPerson.*");
    	sel.add("state");
    	sel.add("adminCU.*");
    	sel.add("sysSupplier.*");
    	sel.add("*");
		return sel;
	}
    public void storeFields()
    {
    	this.storeSupplierAttachList();
    	this.storeSupplierLinkPerson();
    	this.storeSupplierPerson();
    	this.storeSupplierServiceType();
    	this.storeSupplierSplArea();
    	this.storeDesignType();
        super.storeFields();
    }
    public void loadFields() {
    	detachListeners();
    	super.loadFields();
    	this.loadSupplierLinkPerson();
    	this.loadSupplierPerson();
    	this.loadSupplierServiceType();
    	this.loadSupplierSplArea();
    	this.loadSupplierAttachList();
    	this.loadDesignType();
    	attachListeners();
    	
    	if(!SysContext.getSysContext().getCurrentOrgUnit().isIsPurchaseOrgUnit()){
			this.actionAddNew.setEnabled(false);
			this.actionEdit.setEnabled(false);
			this.actionRemove.setEnabled(false);
		}
    }
    
	protected void initControl(){
		this.txtNumber.setMaxLength(80);
		this.txtName.setMaxLength(80);
		this.txtLinkPhone.setMaxLength(50);
		this.txtLinkFax.setMaxLength(50);
		this.txtAddress.setMaxLength(80);
		this.txtLinkMail.setMaxLength(80);
		this.txtWebSite.setMaxLength(80);
		this.txtStorageNumber.setVisible(false);
		this.kDLabelContainer1.setVisible(false);
    	this.chkMenuItemSubmitAndAddNew.setSelected(false);
		this.chkMenuItemSubmitAndAddNew.setVisible(false);
//		this.kdtSupplierAttachList.getColumn("attachment").setRequired(true);
		
    	this.actionSubmit.putValue("SmallIcon", EASResource.getIcon("imgTbtn_submit"));
    	this.actionSave.putValue("SmallIcon", EASResource.getIcon("imgTbtn_save"));
    	
    	this.actionCopy.setVisible(true);
    	this.actionCancel.setVisible(false);
    	this.actionCancelCancel.setVisible(false);
    	
    	this.menuView.setVisible(false);
    	
    	this.menuItemSave.setVisible(true);
    	this.menuItemSave.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
    	this.menuItemSubmit.setVisible(true);
    	this.menuItemSubmit.setAccelerator(KeyStroke.getKeyStroke("ctrl T"));
    	this.menuItemAddNew.setAccelerator(null);
    	
		if(!SupplierStateEnum.SAVE.equals(this.editData.getState())&&!SupplierStateEnum.SUBMIT.equals(this.editData.getState())){
			this.actionEdit.setEnabled(false);
			this.actionRemove.setEnabled(false);
		}
		if(SupplierStateEnum.SUBMIT.equals(this.editData.getState())){
			this.actionSave.setEnabled(false);
		}
		this.actionAddNew.setVisible(false);
		
		try {
			FDCHelper.handleCodingRule(this.txtNumber, this.oprtState, editData, this.getBizInterface(),null);
		} catch (CodingRuleException e) {
			e.printStackTrace();
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.prmtInviteType.setRequired(true);
		this.prmtVisibility.setRequired(true);
		this.kDTextField1.setRequired(true);
		this.txtEnterpriseMaster.setRequired(true);
		this.prmtSupplierFileType.setRequired(true);
		this.prmtSupplierSplAreaEntry.setRequired(true);
		this.prmtSupplierBusinessMode.setRequired(true);
		this.txtAbility.setRequired(true);
		this.txtBusinessNum.setRequired(true);
		
		if(this.txtRecommended.getText()!=null&&!this.txtRecommended.getText().trim().equals("")){
			this.txtRecommended.setEnabled(false);
		}
		if(!SysContext.getSysContext().getCurrentOrgUnit().isIsPurchaseOrgUnit()){
			this.actionAddNew.setEnabled(false);
			this.actionEdit.setEnabled(false);
			this.actionRemove.setEnabled(false);
			this.actionCopy.setEnabled(false);
		}
		this.txtPeopleCount.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                	if(txtPeopleCount.getIntegerValue()!=null)
                		txtPeopleCount.setValue(Math.abs(txtPeopleCount.getIntegerValue()));
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
		loadReviewGatherUI();
    }
    protected void loadReviewGatherUI(){
    	try {
    		Set set = new HashSet<String>();
    		set.add("999999999");
    		Set Selectset = new HashSet<String>();
    		Selectset.add("999999999");
    		Set Appraiseset = new HashSet<String>();
    		Appraiseset.add("999999999");
			if(editData.getId()!=null){
				EntityViewInfo view=new EntityViewInfo();
				FilterInfo filter=new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("supplierNumber.id" , editData.getId().toString()));
				view.setFilter(filter);
				DesignSupplierEvaluationCollection col= DesignSupplierEvaluationFactory.getRemoteInstance().getDesignSupplierEvaluationCollection(view);
				for(int i=0;i<col.size();i++){
					set.add(col.get(i).getId().toString());
				}
				DesignSupplierSelectCollection Selectcol= DesignSupplierSelectFactory.getRemoteInstance().getDesignSupplierSelectCollection(view);
				for(int i=0;i<Selectcol.size();i++){
					Selectset.add(Selectcol.get(i).getId().toString());
				}
				DesignSupplierAppraiseCollection Appraisecol= DesignSupplierAppraiseFactory.getRemoteInstance().getDesignSupplierAppraiseCollection(view);
				for(int i=0;i<Appraisecol.size();i++){
					Appraiseset.add(Appraisecol.get(i).getId().toString());
				}
			}
			KDScrollPane panel=new KDScrollPane();
			panel.setMinimumSize(new Dimension(1013,600));		
			panel.setPreferredSize(new Dimension(1013,600));
	        this.kDTabbedPane2.add(panel,"供应商评定");
	        UIContext uiContext = new UIContext(this);
	        uiContext.put("IDSET", set);
			panel.setViewportView((DesignSupplierEvaluationListUI) UIFactoryHelper.initUIObject(DesignSupplierEvaluationListUI.class.getName(), uiContext, null,OprtState.VIEW));
			panel.setKeyBoardControl(true);
			panel.setEnabled(false);
			
			panel=new KDScrollPane();
			panel.setMinimumSize(new Dimension(1013,600));		
			panel.setPreferredSize(new Dimension(1013,600));
			this.kDTabbedPane2.add(panel,"供应商选用");
			uiContext = new UIContext(this);
			uiContext.put("IDSET", Selectset);
			panel.setViewportView((DesignSupplierSelectListUI) UIFactoryHelper.initUIObject(DesignSupplierSelectListUI.class.getName(), uiContext, null,OprtState.VIEW));
			panel.setKeyBoardControl(true);
			panel.setEnabled(false);
			
			panel=new KDScrollPane();
			panel.setMinimumSize(new Dimension(1013,600));		
			panel.setPreferredSize(new Dimension(1013,600));
			this.kDTabbedPane2.add(panel,"供应商后评估");
			uiContext = new UIContext(this);
			uiContext.put("IDSET", Appraiseset);
			panel.setViewportView((DesignSupplierAppraiseListUI) UIFactoryHelper.initUIObject(DesignSupplierAppraiseListUI.class.getName(), uiContext, null,OprtState.VIEW));
			panel.setKeyBoardControl(true);
			panel.setEnabled(false);
		}catch (BOSException e) {
			e.printStackTrace();
		}
    }
    public void setOprtState(String oprtType) {
		super.setOprtState(oprtType);
		if(oprtType.equals(OprtState.VIEW)){
			this.actionPersonAddLine.setEnabled(false);
			this.actionPersonInsertLine.setEnabled(false);
			this.actionPersonRemoveLine.setEnabled(false);
			this.actionLinkPersonAddLine.setEnabled(false);
			this.actionLinkPersonInsertLine.setEnabled(false);
			this.actionLinkPersonRemoveLine.setEnabled(false);
			this.actionAttachListAddLine.setEnabled(false);
			this.actionAttachListInsertLine.setEnabled(false);
			this.actionAttachListRemoveLine.setEnabled(false);
		}else{
			this.actionPersonAddLine.setEnabled(true);
			this.actionPersonInsertLine.setEnabled(true);
			this.actionPersonRemoveLine.setEnabled(true);
			this.actionLinkPersonAddLine.setEnabled(true);
			this.actionLinkPersonInsertLine.setEnabled(true);
			this.actionLinkPersonRemoveLine.setEnabled(true);
			this.actionAttachListAddLine.setEnabled(true);
			this.actionAttachListInsertLine.setEnabled(true);
			this.actionAttachListRemoveLine.setEnabled(true);
		}
	}
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		super.actionEdit_actionPerformed(e);
		this.kDContainer1.removeAllButton();
		initProWorkButton(this.kDContainer1,false);
		if(SupplierStateEnum.SUBMIT.equals(this.editData.getState())){
			this.actionSave.setEnabled(false);
		}
	}
	
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		verifyInputForSave();
		super.actionSave_actionPerformed(e);
		FDCUIWeightWorker.getInstance().addWork(new IFDCWork(){
			public void run() {
				storeFields();
				initOldData(editData);
			}
		});
	}
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		verifyInputForSubmit();
		super.actionSubmit_actionPerformed(e);
		setOprtState(OprtState.VIEW);
		if(SupplierStateEnum.SUBMIT.equals(this.editData.getState())){
			this.actionSave.setEnabled(false);
		}
		FDCUIWeightWorker.getInstance().addWork(new IFDCWork(){
			public void run() {
				storeFields();
				initOldData(editData);
			}
		});
		
		FDCHelper.handleCodingRule(this.txtNumber, this.oprtState, editData, this.getBizInterface(),null);
	}
    protected void storeSupplierSplArea(){
    	editData.getSupplierSplAreaEntry().clear();
    	Object[] value=(Object[]) this.prmtSupplierSplAreaEntry.getValue();
    	String splArea="";
    	if(value!=null&&value.length>0){
    		for(int i=0;i<value.length;i++){
    			DesignServiceAreaInfo info = (DesignServiceAreaInfo) value[i];
    			if(info==null){continue;}
    			DesignSupplierStockSupplierSplAreaEntryInfo entry = new DesignSupplierStockSupplierSplAreaEntryInfo();
				entry.setFdcSplArea(info);
				splArea=splArea+info.getName()+";";
				editData.getSupplierSplAreaEntry().add(entry);
    		}
    	}
    	editData.setSplArea(splArea);
    }
    
    protected void storeDesignType(){
    	this.txtDesignJD.setText(null);
    	this.txtpodutId.setText(null);
    	Object[] Phasevalue=(Object[]) this.prmtdesignPhase.getValue();
    	Object[] Produvalue=(Object[]) this.prmtproductType.getValue();
    	String Phase="";
    	String Produ="";
    	for (int i = 0; i < Phasevalue.length; i++) {
    		DesignPhaseInfo info = (DesignPhaseInfo)Phasevalue[i];
			if("".equals(Phase.trim()))
				Phase += info.getId().toString();
			else
				Phase += "#"+info.getId().toString();
		}
    	for (int i = 0; i < Produvalue.length; i++) {
    		ProductTypeInfo info = (ProductTypeInfo)Produvalue[i];
    		if("".equals(Produ.trim()))
    			Produ += info.getId().toString();
			else
				Produ += "#"+info.getId().toString();
		}
    	this.txtDesignJD.setText(Phase);
    	this.txtpodutId.setText(Produ);
    }
    
    protected void storeSupplierServiceType(){
    	editData.getSupplierServiceType().clear();
    	Object[] value=(Object[]) this.prmtServiceType.getValue();
    	if(value!=null&&value.length>0){
    		for(int i=0;i<value.length;i++){
    			DesignServiceTypeInfo info = (DesignServiceTypeInfo) value[i];
    			DesignSupplierStockSupplierServiceTypeInfo entry = new DesignSupplierStockSupplierServiceTypeInfo();
				entry.setServiceType(info);
				editData.getSupplierServiceType().add(entry);
    		}
    	}
    }
    protected void storeSupplierLinkPerson(){
    	editData.getLinkPerson().clear();
    	for(int i=0;i<this.kdtLinkPerson.getRowCount();i++){
    		IRow row = this.kdtLinkPerson.getRow(i);
    		DesignSupplierStockLinkPersonInfo entry=new DesignSupplierStockLinkPersonInfo();
    		if(row.getUserObject()!=null){
    			entry=(DesignSupplierStockLinkPersonInfo) row.getUserObject();
    		}
    		entry.setSeq(i);
    		entry.setPersonName((String)row.getCell("personName").getValue());
    		entry.setPosition((String)row.getCell("position").getValue());
    		entry.setPhone((String)row.getCell("phone").getValue());
    		entry.setWorkPhone((String)row.getCell("workPhone").getValue());
    		entry.setPersonFax((String)row.getCell("personFax").getValue());
    		entry.setEmail((String)row.getCell("email").getValue());
			entry.setIsDefault(((Boolean)row.getCell("isDefault").getValue()).booleanValue());
    		editData.getLinkPerson().add(entry);
    	}
    }
    protected void storeSupplierPerson(){
    	editData.getSupplierPersonEntry().clear();
    	for(int i=0;i<this.kdtSupplierPerson.getRowCount();i++){
    		IRow row = this.kdtSupplierPerson.getRow(i);
    		DesignSupplierStockSupplierPersonEntryInfo entry=new DesignSupplierStockSupplierPersonEntryInfo();
    		if(row.getUserObject()!=null){
    			entry=(DesignSupplierStockSupplierPersonEntryInfo) row.getUserObject();
    		}
    		entry.setSeq(i);
    		entry.setName((String)row.getCell("name").getValue());
    		entry.setPosition((String)row.getCell("position").getValue());
    		entry.setLinkType((String)row.getCell("linkType").getValue());
    		entry.setResume((String)row.getCell("resume").getValue());
    		entry.setProjectName((String)row.getCell("projectName").getValue());
    		if(UIRuleUtil.isNotNull(row.getCell("occupationLevel").getValue())){
    			DesignLevelSetUpInfo info =(DesignLevelSetUpInfo)row.getCell("occupationLevel").getValue();
    			entry.setOccupationLevel(info);
    		}
    		editData.getSupplierPersonEntry().add(entry);
    	}
    		
    }
    protected void storeSupplierAttachList(){
    	editData.getSupplierAttachListEntry().clear();
    	for(int i=0;i<this.kdtSupplierAttachList.getRowCount();i++){
    		IRow row = this.kdtSupplierAttachList.getRow(i);
    		DesignSupplierStockSupplierAttachListEntryInfo entry=new DesignSupplierStockSupplierAttachListEntryInfo();
    		if(row.getUserObject()!=null){
    			entry=(DesignSupplierStockSupplierAttachListEntryInfo) row.getUserObject();
    		}
    		entry.setSeq(i);
    		entry.setNumber((String)row.getCell("number").getValue());
    		entry.setName((String)row.getCell("name").getValue());
    		editData.getSupplierAttachListEntry().add(entry);
    	}
    }
	protected void loadSupplierSplArea(){
		DesignSupplierStockSupplierSplAreaEntryCollection  col=editData.getSupplierSplAreaEntry();
    	if(col.size()>0){
    		Object[] value=new Object[col.size()];
    		for(int i=0;i<col.size();i++) {
    			DesignSupplierStockSupplierSplAreaEntryInfo entry = col.get(i);
    			if(entry.getFdcSplArea()!=null)
					try {
						DesignServiceAreaInfo info = DesignServiceAreaFactory.getRemoteInstance().getDesignServiceAreaInfo(new ObjectUuidPK(entry.getFdcSplArea().getId())) ;
						value[i]=info;
					} catch (EASBizException e) {
						e.printStackTrace();
					} catch (BOSException e) {
						e.printStackTrace();
					}
				else
    				value[i] = null;
    		}
    		this.prmtSupplierSplAreaEntry.setValue(value);
    	}else{
    		this.prmtSupplierSplAreaEntry.setValue(null);
    	}
    }
	protected void loadSupplierServiceType(){
		DesignSupplierStockSupplierServiceTypeCollection col=editData.getSupplierServiceType();
		if(col.size()>0){
    		Object[] value=new Object[col.size()];
    		for(int i=0;i<col.size();i++) {
    			DesignSupplierStockSupplierServiceTypeInfo entry = col.get(i);
				try {
					if(entry.getServiceType()!=null)
						value[i] = DesignServiceTypeFactory.getRemoteInstance().getDesignServiceTypeInfo(new ObjectUuidPK(entry.getServiceType().getId()));
					else
						value[i]=null;
				} catch (EASBizException e) {
					e.printStackTrace();
				} catch (BOSException e) {
					e.printStackTrace();
				}
    		}
    		this.prmtServiceType.setValue(value);
    	}else{
    		this.prmtServiceType.setValue(null);
    	}
	}
	
	protected void loadDesignType() {
		try {
			if(this.txtDesignJD.getText()!=null&&!"".equals(this.txtDesignJD.getText().trim())){
				String DesignId[] = editData.getDesignJD().split("#");
				DesignPhaseInfo DesignValue[] = new DesignPhaseInfo[DesignId.length];
				for (int i = 0; i < DesignId.length; i++) {
					DesignValue[i] = DesignPhaseFactory.getRemoteInstance().getDesignPhaseInfo(new ObjectUuidPK(DesignId[i]));
				}
				this.prmtdesignPhase.setValue(DesignValue);
			}
			if(this.txtpodutId.getText()!=null&&!"".equals(this.txtpodutId.getText().trim())){
				String PodutId [] = editData.getPodutId().split("#");
				ProductTypeInfo PodutIdValue[] = new ProductTypeInfo[PodutId.length];
				for (int i = 0; i < PodutId.length; i++) {
					PodutIdValue[i] = ProductTypeFactory.getRemoteInstance().getProductTypeInfo(new ObjectUuidPK(PodutId[i]));
				}
				this.prmtproductType.setValue(PodutIdValue);
			}
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
	}
	
	protected void loadSupplierLinkPerson(){
		DesignSupplierStockLinkPersonCollection col=editData.getLinkPerson();
		CRMHelper.sortCollection(col, "seq", true);
		this.kdtLinkPerson.removeRows();
		for(int i=0;i<col.size();i++){
			DesignSupplierStockLinkPersonInfo entry=col.get(i);
			IRow row=this.kdtLinkPerson.addRow();
			row.setUserObject(entry);
			row.getCell("personName").setValue(entry.getPersonName());
			row.getCell("position").setValue(entry.getPosition());
			row.getCell("phone").setValue(entry.getPhone());
			row.getCell("workPhone").setValue(entry.getWorkPhone());
			row.getCell("personFax").setValue(entry.getPersonFax());
			row.getCell("email").setValue(entry.getEmail());
			row.getCell("isDefault").setValue(Boolean.valueOf(entry.isIsDefault()));
		}
	}
	protected void loadSupplierPerson(){
		DesignSupplierStockSupplierPersonEntryCollection col=editData.getSupplierPersonEntry();
		CRMHelper.sortCollection(col, "seq", true);
		this.kdtSupplierPerson.removeRows();
		for(int i=0;i<col.size();i++){
			DesignSupplierStockSupplierPersonEntryInfo entry=col.get(i);
			IRow row=this.kdtSupplierPerson.addRow();
			row.setUserObject(entry);
			row.getCell("name").setValue(entry.getName());
			row.getCell("position").setValue(entry.getPosition());
			row.getCell("linkType").setValue(entry.getLinkType());
			row.getCell("resume").setValue(entry.getResume());
			if(entry.getOccupationLevel()!=null){
				try {
					row.getCell("occupationLevel").setValue(DesignLevelSetUpFactory.getRemoteInstance().getDesignLevelSetUpInfo(new ObjectUuidPK(entry.getOccupationLevel().getId())));
				} catch (EASBizException e) {
					e.printStackTrace();
				} catch (BOSException e) {
					e.printStackTrace();
				}
			}
			row.getCell("projectName").setValue(entry.getProjectName());
		}
	}
	protected void loadSupplierAttachList(){
		DesignSupplierStockSupplierAttachListEntryCollection col=editData.getSupplierAttachListEntry();
		CRMHelper.sortCollection(col, "seq", true);
		this.kdtSupplierAttachList.removeRows();
		for(int i=0;i<col.size();i++){
			DesignSupplierStockSupplierAttachListEntryInfo entry=col.get(i);
			IRow row=this.kdtSupplierAttachList.addRow();
			row.setUserObject(entry);
			row.getCell("number").setValue(entry.getNumber());
			row.getCell("name").setValue(entry.getName());
			try {
				if(entry.getId()!=null){
					row.getCell("attachment").setValue(loadAttachment(entry.getId().toString()));
				}
			} catch (BOSException e) {
				e.printStackTrace();
			}
		}
	}	
	protected void prmtProvince_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    	EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		
		ProvinceInfo pinfo = (ProvinceInfo) prmtProvince.getValue();
		if(pinfo!=null){
			filter.getFilterItems().add(new FilterItemInfo("province.id" , pinfo.getId().toString()));
		}
		view.setFilter(filter);
		this.prmtCity.setEntityViewInfo(view);
    }

    protected void prmtSupplierFileType_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    	 boolean isChanged = true;
		 isChanged = BizCollUtil.isF7ValueChanged(e);
         if(!isChanged){
        	 return;
         }
         DesSupplierFileTypeInfo fileType=(DesSupplierFileTypeInfo)this.prmtSupplierFileType.getValue();
         boolean isShowWarn=false;
         boolean isUpdate=false;
         if(this.kdtSupplierPerson.getRowCount()>0||this.kdtSupplierAttachList.getRowCount()>0){
        	 isShowWarn=true;
         }
         if(isShowWarn){
        	 if(FDCMsgBox.showConfirm2(this, "档案分类改变会覆盖附件清单数据，是否继续？")== FDCMsgBox.YES){
        		 isUpdate=true;
             }
         }else{
        	 isUpdate=true;
         }
         if(isUpdate){
        	 this.kdtSupplierPerson.removeRows();
        	 this.kdtSupplierAttachList.removeRows();
        	 
        	 if(fileType!=null){
        		 SorterItemCollection sort=new SorterItemCollection();
        		 sort.add(new SorterItemInfo("number"));
        		 EntityViewInfo view=new EntityViewInfo();
            	 FilterInfo filter = new FilterInfo();
                 filter.getFilterItems().add(new FilterItemInfo("supplierFileType.id" , fileType.getId().toString()));
                 filter.getFilterItems().add(new FilterItemInfo("isEnabled" , Boolean.TRUE));
                 view.setFilter(filter);
                 view.setSorter(sort);
                 DesignSupplierAttachListCollection alCol=DesignSupplierAttachListFactory.getRemoteInstance().getDesignSupplierAttachListCollection(view);
                 for(int i=0;i<alCol.size();i++){
                	 DesignSupplierAttachListInfo at=alCol.get(i);
                	 IRow row=this.kdtSupplierAttachList.addRow();
                	 DesignSupplierStockSupplierAttachListEntryInfo info=new DesignSupplierStockSupplierAttachListEntryInfo();
     				 info.setId(BOSUuid.create(info.getBOSType()));
     				 row.setUserObject(info);
                	 row.getCell("number").setValue(at.getNumber());
                	 row.getCell("name").setValue(at.getName());
                 }
        	 }
         }
    }
    protected void initF7(){
    	this.prmtdesignPhase.setRequired(true);
		this.prmtproductType.setRequired(true);
    	//服务区域
    	prmtSupplierSplAreaEntry.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.designbase.app.DesignServiceAreaQuery");
    	//服务类型
    	prmtServiceType.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.designbase.app.DesignServiceTypeQuery");
    	//档案分类
    	prmtSupplierFileType.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.designbase.app.DesSupplierFileTypeQuery");
    	//经营模式
    	prmtSupplierBusinessMode.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.designbase.app.DesignBusinessModeQuery");
    	//资格等级
    	prmtQuaLevel.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.designbase.app.DesignQuaLevelQuery");
    	
    	EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("isLeaf",Boolean.TRUE));
		filter.getFilterItems().add(new FilterItemInfo("isEnabled",Boolean.TRUE));
		view.setFilter(filter);
		this.prmtServiceType.setEntityViewInfo(view);
		
		view = new EntityViewInfo();
		filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("isLeaf",Boolean.TRUE));
		filter.getFilterItems().add(new FilterItemInfo("isEnabled",Boolean.TRUE));
		filter.getFilterItems().add(new FilterItemInfo("longNumber","7%",CompareType.LIKE));
		view.setFilter(filter);
		this.prmtInviteType.setEntityViewInfo(view);
		
		view = new EntityViewInfo();
		filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("isEnabled",Boolean.TRUE));
		view.setFilter(filter);
		this.prmtSupplierFileType.setEntityViewInfo(view);
		this.prmtSupplierBusinessMode.setEntityViewInfo(view);
		this.prmtSupplierSplAreaEntry.setEntityViewInfo(view);
		this.prmtdesignPhase.setEntityViewInfo(view);
		this.prmtproductType.setEntityViewInfo(view);
		this.prmtQuaLevel.setEntityViewInfo(view);
    }
    protected void initWorkButton(ItemAction add,ItemAction insert,ItemAction remove,KDContainer container){
    	KDWorkButton btnAddRowinfo=new KDWorkButton();
    	KDWorkButton btnInsertRowinfo=new KDWorkButton();
    	KDWorkButton btnDeleteRowinfo=new KDWorkButton();
    	
    	add.putValue("SmallIcon", EASResource.getIcon("imgTbtn_addline"));
		btnAddRowinfo = (KDWorkButton)container.add(add);
		btnAddRowinfo.setText(getResource("addRow"));
		btnAddRowinfo.setSize(new Dimension(140, 19));
		
		insert.putValue("SmallIcon", EASResource.getIcon("imgTbtn_insert"));
		btnInsertRowinfo = (KDWorkButton)container.add(insert);
		btnInsertRowinfo.setText(getResource("insertRow"));
		btnInsertRowinfo.setSize(new Dimension(140, 19));
		
		remove.putValue("SmallIcon", EASResource.getIcon("imgTbtn_deleteline"));
		btnDeleteRowinfo = (KDWorkButton)container.add(remove);
		btnDeleteRowinfo.setText(getResource("deleteRow"));
		btnDeleteRowinfo.setSize(new Dimension(140, 19));
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
					kdtProject_detailPanel.actionAddnewLine_actionPerformed(e);
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
					kdtProject_detailPanel.actionInsertLine_actionPerformed(e);
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
					kdtProject_detailPanel.actionRemoveLine_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        });
    }
    
    protected void initTable(){
    	this.prmtPurchaseOrgUnit.setEnabled(false);
    	this.prmtgatadeLv.setEnabled(false);
    	initWorkButton(this.actionLinkPersonAddLine,this.actionLinkPersonInsertLine,this.actionLinkPersonRemoveLine,this.contLinkPerson);
    	initWorkButton(this.actionAttachListAddLine,this.actionAttachListInsertLine,this.actionAttachListRemoveLine,this.contSupplierAttachList);
    	initWorkButton(this.actionPersonAddLine,this.actionPersonInsertLine,this.actionPersonRemoveLine,this.kDContainer2);
    	initProWorkButton(this.kDContainer1,false);
    	prmtServiceType.setEnabled(false);
    	KDTextField testField = new KDTextField();
    	testField.setMaxLength(80);
		KDTDefaultCellEditor editorSize = new KDTDefaultCellEditor(testField);
		kDTextField1.setMaxLength(80);
		KDTextField testField1 = new KDTextField();
    	testField.setMaxLength(255);
		KDTDefaultCellEditor editorSize1 = new KDTDefaultCellEditor(testField1);
		
		KDFormattedTextField peopleC = new KDFormattedTextField(KDFormattedTextField.DECIMAL);
		peopleC.setPrecision(0);
		peopleC.setDataVerifierType(12);
		KDTDefaultCellEditor peopleCount = new KDTDefaultCellEditor(peopleC);
		
    	this.kdtLinkPerson.checkParsed();
 	    this.kdtLinkPerson.getColumn("personName").setEditor(editorSize);
 		this.kdtLinkPerson.getColumn("position").setEditor(editorSize);
 		this.kdtLinkPerson.getColumn("phone").setEditor(editorSize);
 		this.kdtLinkPerson.getColumn("workPhone").setEditor(editorSize);
 		this.kdtLinkPerson.getColumn("personFax").setEditor(editorSize);
 		this.kdtLinkPerson.getColumn("email").setEditor(editorSize);
 		KDCheckBox isAutidor = new KDCheckBox();
 		isAutidor.setSelected(false);
 		KDTDefaultCellEditor editor = new KDTDefaultCellEditor(isAutidor);
 		this.kdtLinkPerson.getColumn("isDefault").setEditor(editor);
 		
 		this.kdtSupplierPerson.checkParsed();
  		this.kdtSupplierPerson.getColumn("name").setEditor(editorSize1);
  		
  		EntityViewInfo view = new EntityViewInfo();
  		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("isEnabled",Boolean.TRUE));
		view.setFilter(filter);
  		KDBizPromptBox kdtEntrys_Reviewers_PromptBox = new KDBizPromptBox();
        kdtEntrys_Reviewers_PromptBox.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.designbase.app.DesignLevelSetUpQuery");
        kdtEntrys_Reviewers_PromptBox.setVisible(true);
        kdtEntrys_Reviewers_PromptBox.setEditable(true);
        kdtEntrys_Reviewers_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_Reviewers_PromptBox.setEditFormat("$number$");
        kdtEntrys_Reviewers_PromptBox.setCommitFormat("$number$");
        kdtEntrys_Reviewers_PromptBox.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtEntrys_Reviewers_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Reviewers_PromptBox);
        this.kdtSupplierPerson.getColumn("occupationLevel").setEditor(kdtEntrys_Reviewers_CellEditor);
        ObjectValueRender kdtEntrys_Reviewers_OVR = new ObjectValueRender();
        kdtEntrys_Reviewers_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtSupplierPerson.getColumn("occupationLevel").setRenderer(kdtEntrys_Reviewers_OVR);
 		
 		this.kdtSupplierAttachList.checkParsed();
 		this.kdtSupplierAttachList.getColumn("number").setEditor(editorSize);
  		this.kdtSupplierAttachList.getColumn("name").setEditor(editorSize1);
  		this.kdtSupplierAttachList.getColumn("attachment").getStyleAttributes().setLocked(true);
  		this.kdtSupplierAttachList.getColumn("attachment").getStyleAttributes().setFontColor(Color.BLUE);
  		this.kdtSupplierAttachList.getColumn("attachment").setWidth(400);
  		this.kdtProject.getColumn("projectName").setRequired(true);
		this.kdtProject.getColumn("awld").setRequired(true);
		this.kdtSupplierPerson.getColumn("name").setRequired(true);
		this.kdtSupplierPerson.getColumn("occupationLevel").setRequired(true);
		this.kdtSupplierPerson.getColumn("projectName").setRequired(true);
    }
    
	public void actionAttachListAddLine_actionPerformed(ActionEvent e) throws Exception {
		kdTableAddRow(this.kdtSupplierAttachList);
	}
	public void actionAttachListInsertLine_actionPerformed(ActionEvent e) throws Exception {
		kdTableInsertLine(this.kdtSupplierAttachList);
	}
	public void actionAttachListRemoveLine_actionPerformed(ActionEvent e) throws Exception {
		kdTableDeleteRow(this.kdtSupplierAttachList);
	}
	public void actionLinkPersonAddLine_actionPerformed(ActionEvent e) throws Exception {
		kdTableAddRow(this.kdtLinkPerson);
	}
	public void actionLinkPersonInsertLine_actionPerformed(ActionEvent e) throws Exception {
		kdTableInsertLine(this.kdtLinkPerson);
	}
	public void actionLinkPersonRemoveLine_actionPerformed(ActionEvent e) throws Exception {
		kdTableDeleteRow(this.kdtLinkPerson);
	}
	public void actionPersonAddLine_actionPerformed(ActionEvent e) throws Exception {
		kdTableAddRow(this.kdtSupplierPerson);
	}
	public void actionPersonInsertLine_actionPerformed(ActionEvent e) throws Exception {
		kdTableInsertLine(this.kdtSupplierPerson);
	}
	public void actionPersonRemoveLine_actionPerformed(ActionEvent e) throws Exception {
		kdTableDeleteRow(this.kdtSupplierPerson);
	}
	protected void kdtLinkPerson_editStopped(KDTEditEvent e) throws Exception {
		int index = e.getRowIndex();
		int size = this.kdtLinkPerson.getRowCount();
	    IRow row = this.kdtLinkPerson.getRow(index);
	    Boolean b=(Boolean) row.getCell("isDefault").getValue();
	    /*
	     * 这里是合并手机与办公电话到一列中去,序时薄上要把手机和办公电话显示到一起.暂用这种方式做
	     */
	    for(int j = 0 ; j<size ; j++){
	    	if(null != this.kdtLinkPerson.getRow(j).getCell("contact").getValue()){
	    		this.kdtLinkPerson.getRow(j).getCell("contact").setValue(null);
	    	}
	    	if(null != this.kdtLinkPerson.getRow(j).getCell("phone").getValue()){
	    		if(null != this.kdtLinkPerson.getRow(j).getCell("workPhone").getValue()){
	    			this.kdtLinkPerson.getRow(j).getCell("contact").setValue(this.kdtLinkPerson.getRow(j).getCell("phone").getValue()+";"+this.kdtLinkPerson.getRow(j).getCell("workPhone").getValue());
	    		}else{
	    			this.kdtLinkPerson.getRow(j).getCell("contact").setValue(this.kdtLinkPerson.getRow(j).getCell("phone").getValue().toString());
	    		}
	    	}else if(null != this.kdtLinkPerson.getRow(j).getCell("workPhone").getValue()){
	    		this.kdtLinkPerson.getRow(j).getCell("contact").setValue(this.kdtLinkPerson.getRow(j).getCell("workPhone").getValue().toString());
	    	}else{
	    		continue;
	    	}
	    }
	    /*
	     * 处理只能勾选一个人为默认联系.新增第一行时为空 则返回
	     */
	    if(null == b ){
	    	return ;
	    }
	    if(b.booleanValue()){
			for( int i = 0 ; i< size ;i++){
				if(i ==index ){
					continue;
				}
				this.kdtLinkPerson.getRow(i).getCell("isDefault").setValue(Boolean.FALSE);
			}
	    }
	}
	protected void kdtSupplierAttachList_tableClicked(KDTMouseEvent e) throws Exception {
		if (e.getType() == KDTStyleConstants.BODY_ROW && e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2&&
				this.kdtSupplierAttachList.getColumnKey(e.getColIndex()).equals("attachment")) {
			if(((DesignSupplierStockSupplierAttachListEntryInfo)this.kdtSupplierAttachList.getRow(e.getRowIndex()).getUserObject()).getId()==null){return;};
			String id=((DesignSupplierStockSupplierAttachListEntryInfo)this.kdtSupplierAttachList.getRow(e.getRowIndex()).getUserObject()).getId().toString();
			AttachmentClientManager acm = AttachmentManagerFactory.getClientManager();
	        boolean isEdit = false;
	        if(OprtState.EDIT.equals(getOprtState()) || OprtState.ADDNEW.equals(getOprtState()))
	            isEdit = true;
	        AttachmentUIContextInfo info = new AttachmentUIContextInfo();
	        info.setBoID(id);
	        info.setEdit(isEdit);
	        String multi = (String)getUIContext().get("MultiapproveAttachment");
	        if(multi != null && multi.equals("true")){
	        	acm.showAttachmentListUIByBoIDNoAlready(this, info);
	        }else{
	        	acm.showAttachmentListUIByBoID(this, info);
	        }
	        this.kdtSupplierAttachList.getRow(e.getRowIndex()).getCell("attachment").setValue(loadAttachment(id));
		}
	}
	protected String loadAttachment(String id) throws BOSException{
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("boID", id));
		view.setFilter(filter);
		SelectorItemCollection sels = new SelectorItemCollection();
		sels.add("attachment.name");
		view.setSelector(sels);
		BoAttchAssoCollection col = BoAttchAssoFactory.getRemoteInstance().getBoAttchAssoCollection(view);
		String name="";
		for(int i=0;i<col.size();i++){
			name=name+col.get(i).getAttachment().getName()+" ";
		}
		return name;
	}


	protected void attachListeners() {
		addDataChangeListener(this.prmtSupplierFileType);
		addDataChangeListener(this.prmtProvince);
		addDataChangeListener(this.prmtSupplierSplAreaEntry);
	}
	protected void detachListeners() {
		removeDataChangeListener(this.prmtSupplierFileType);
		removeDataChangeListener(this.prmtProvince);
		removeDataChangeListener(this.prmtSupplierSplAreaEntry);
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
    private void kdTableAddRow(KDTable table) {
		if(!getOprtState().equals(OprtState.VIEW)){
			IRow row=table.addRow();
			if(table.equals(this.kdtSupplierAttachList)){
				DesignSupplierStockSupplierAttachListEntryInfo info=new DesignSupplierStockSupplierAttachListEntryInfo();
				info.setId(BOSUuid.create(info.getBOSType()));
				row.setUserObject(info);
			}else if(table.equals(this.kdtLinkPerson)){
				DesignSupplierStockLinkPersonInfo info=new DesignSupplierStockLinkPersonInfo();
				row.setUserObject(info);
				if(this.kdtLinkPerson.getRowCount()==1){
					row.getCell("isDefault").setValue(Boolean.TRUE);
				}else{
					row.getCell("isDefault").setValue(Boolean.FALSE);
				}
			}
		}
			
	}
	private void kdTableInsertLine(KDTable table){
		if(!getOprtState().equals(OprtState.VIEW)){
			if(table == null)
	            return;
	        IRow row = null;
	        if(table.getSelectManager().size() > 0)
	        {
	            int top = table.getSelectManager().get().getTop();
	            if(isTableColumnSelected(table))
	                row = table.addRow();
	            else
	                row = table.addRow(top);
	        } else
	        {
	            row = table.addRow();
	        }
	        if(table.equals(this.kdtSupplierAttachList)&&row!=null){
	        	DesignSupplierStockSupplierAttachListEntryInfo info=new DesignSupplierStockSupplierAttachListEntryInfo();
				info.setId(BOSUuid.create(info.getBOSType()));
				row.setUserObject(info);
			}else if(table.equals(this.kdtLinkPerson)){
				DesignSupplierStockLinkPersonInfo info=new DesignSupplierStockLinkPersonInfo();
				row.setUserObject(info);
				if(this.kdtLinkPerson.getRowCount()==1){
					row.getCell("isDefault").setValue(Boolean.TRUE);
				}else{
					row.getCell("isDefault").setValue(Boolean.FALSE);
				}
			}
		}
	}
	protected final boolean isTableColumnSelected(KDTable table)
    {
        if(table.getSelectManager().size() > 0)
        {
            KDTSelectBlock block = table.getSelectManager().get();
            if(block.getMode() == 4 || block.getMode() == 8)
                return true;
        }
        return false;
    }
	private boolean confirmRemove(Component comp){
		return FDCMsgBox.isYes(FDCMsgBox.showConfirm2(comp, EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Confirm_Delete")));
	}
	private void kdTableDeleteRow(KDTable table) {
		if(!getOprtState().equals(OprtState.VIEW)){
	        if(table.getSelectManager().size() == 0 || isTableColumnSelected(table)){
	            FDCMsgBox.showInfo(this, EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_NoneEntry"));
	            return;
	        }
	        if(confirmRemove(this)){
	            int top = table.getSelectManager().get().getBeginRow();
	            int bottom = table.getSelectManager().get().getEndRow();
	            for(int i = top; i <= bottom; i++){
	                if(table.getRow(top) == null)
	                {
	                    FDCMsgBox.showInfo(this, EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_NoneEntry"));
	                    return;
	                }
	                if(table.equals(this.kdtSupplierAttachList)){
	                	try {
	                		deleteAttachment(((DesignSupplierStockSupplierAttachListEntryInfo)table.getRow(top).getUserObject()).getId().toString());
	                	} catch (BOSException e) {
							e.printStackTrace();
						} catch (EASBizException e) {
							e.printStackTrace();
						}
	                }
	                table.removeRow(top);
	            }
	        }
		}
	}
	protected void deleteAttachment(String id) throws BOSException, EASBizException{
		EntityViewInfo view=new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		
		filter.getFilterItems().add(new FilterItemInfo("boID" , id));
		view.setFilter(filter);
		BoAttchAssoCollection col=BoAttchAssoFactory.getRemoteInstance().getBoAttchAssoCollection(view);
		if(col.size()>0){
			for(int i=0;i<col.size();i++){
				EntityViewInfo attview=new EntityViewInfo();
				FilterInfo attfilter = new FilterInfo();
				
				attfilter.getFilterItems().add(new FilterItemInfo("attachment.id" , col.get(i).getAttachment().getId().toString()));
				attview.setFilter(attfilter);
				BoAttchAssoCollection attcol=BoAttchAssoFactory.getRemoteInstance().getBoAttchAssoCollection(attview);
				if(attcol.size()==1){
					BizobjectFacadeFactory.getRemoteInstance().delTempAttachment(id);
				}else if(attcol.size()>1){
					BoAttchAssoFactory.getRemoteInstance().delete(filter);
				}
			}
		}
	}
	private String getResource(String msg) {
		return EASResource.getString("com.kingdee.eas.fdc.invite.supplier.SupplierResource", msg);
	}
	protected void showSaveSuccess() {
		setMessageText(getClassAlise() + " " + EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_Save_OK"));
	    setNextMessageText(getClassAlise() + " " + EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_Edit"));
	    setShowMessagePolicy(0);
	    setIsShowTextOnly(false);
	    showMessage();
	}
	protected void showSubmitSuccess() {
		setMessageText(getClassAlise() + " " + EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_Submit_OK"));
	    if(chkMenuItemSubmitAndAddNew.isSelected())
	        setNextMessageText(getClassAlise() + " " + EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_AddNew"));
	    else
	    if(!chkMenuItemSubmitAndPrint.isSelected() && chkMenuItemSubmitAndAddNew.isSelected())
	        setNextMessageText(getClassAlise() + " " + EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_AddNew"));
	    else
	        setNextMessageText(getClassAlise() + " " + EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_Edit"));
	    setIsShowTextOnly(false);
	    setShowMessagePolicy(0);
	    showMessage();
	}
	
	protected void verifyInput(ActionEvent e) throws Exception {
		verifyInputForSave();
		// 编码是否为空
		KDTextField txtNumber = this.getNumberCtrl();
		if (txtNumber.getText() == null || txtNumber.getText().trim().length() < 1) {
			txtNumber.requestFocus(true);
			throw new FDCBasedataException(FDCBasedataException.NUMBER_IS_EMPTY);
		}
		// 名称是否为空
		KDBizMultiLangBox txtName = getNameCtrl();
		boolean flag = FDCBaseDataClientUtils.isMultiLangBoxInputNameEmpty(txtName, getEditData(), "name");
		if (flag) {
			txtName.requestFocus(true);
			throw new FDCBasedataException(FDCBasedataException.NAME_IS_EMPTY);
		}
	}
	
	protected void verifyInputForSubmit() throws Exception {
		FDCClientVerifyHelper.verifyEmpty(this, getNumberCtrl());
		FDCClientVerifyHelper.verifyEmpty(this, getNameCtrl());
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtInviteType);
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtPurchaseOrgUnit);
		FDCClientVerifyHelper.verifyEmpty(this, this.txtEnterpriseMaster);
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtSupplierSplAreaEntry);
		FDCClientVerifyHelper.verifyEmpty(this, this.txtBusinessNum);
		FDCClientVerifyHelper.verifyEmpty(this, this.kDTextField1);
		boolean isDefault=true;
		for(int i=0;i<this.kdtLinkPerson.getRowCount();i++){
			IRow row=this.kdtLinkPerson.getRow(i);
			if(((Boolean)row.getCell("isDefault").getValue()).booleanValue()){
				isDefault=false;
				if(row.getCell("personName").getValue()==null||row.getCell("personName").getValue().toString().trim().equals("")){
					FDCMsgBox.showWarning(this,"授权联系人姓名不能为空！");
					SysUtil.abort();
				}
				if(row.getCell("phone").getValue()==null||row.getCell("phone").getValue().toString().trim().equals("")){
					FDCMsgBox.showWarning(this,"授权联系人手机不能为空！");
					SysUtil.abort();
				}
			}
		}
		FDCClientVerifyHelper.verifyInput(this, kdtProject, "projectName");
		FDCClientVerifyHelper.verifyInput(this, kdtProject, "awld");
		FDCClientVerifyHelper.verifyInput(this, kdtSupplierPerson, "name");
		FDCClientVerifyHelper.verifyInput(this, kdtSupplierPerson, "occupationLevel");
		FDCClientVerifyHelper.verifyInput(this, kdtSupplierPerson, "projectName");
		if(isDefault){
			FDCMsgBox.showWarning(this,"授权联系人不能为空！");
			SysUtil.abort();
		}
		boolean isYValueAttact = true;
		boolean isSValueAttact = true;
		boolean isZValueAttact = true;
		for (int i = 0; i < kdtSupplierAttachList.getRowCount(); i++) {
			if((UIRuleUtil.getString(kdtSupplierAttachList.getCell(i, "name").getValue()).equals("营业执照"))
					&&UIRuleUtil.isNotNull(kdtSupplierAttachList.getCell(i, "attachment").getValue())&&
					!"".equals(UIRuleUtil.getString(kdtSupplierAttachList.getCell(i, "attachment").getValue()))){
				isYValueAttact = false;
			}if((UIRuleUtil.getString(kdtSupplierAttachList.getCell(i, "name").getValue()).equals("税务登记证"))
					&&UIRuleUtil.isNotNull(kdtSupplierAttachList.getCell(i, "attachment").getValue())&&
					!"".equals(UIRuleUtil.getString(kdtSupplierAttachList.getCell(i, "attachment").getValue()))){
				isSValueAttact = false;
			}if((UIRuleUtil.getString(kdtSupplierAttachList.getCell(i, "name").getValue()).equals("组织机构代码证"))
					&&UIRuleUtil.isNotNull(kdtSupplierAttachList.getCell(i, "attachment").getValue())&&
					!"".equals(UIRuleUtil.getString(kdtSupplierAttachList.getCell(i, "attachment").getValue()))){
				isZValueAttact = false;
			}
		}
		if(isYValueAttact||isSValueAttact||isZValueAttact){
			FDCMsgBox.showWarning(this,"附件清单必须要有营业执照、税务登记证、组织机构代码证的附件！");
			SysUtil.abort();
		}
	
	}
	
	protected void verifyInputForSave() throws Exception {
		FDCClientVerifyHelper.verifyEmpty(this, getNumberCtrl());
		FDCClientVerifyHelper.verifyEmpty(this, getNameCtrl());
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtInviteType);
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtPurchaseOrgUnit);
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtdesignPhase);
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtproductType);
	}
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
    	super.actionCopy_actionPerformed(e);
    	FDCHelper.handleCodingRule(this.txtNumber, this.oprtState, editData, this.getBizInterface(),null);
    	this.txtStorageNumber.setText(null);
    	this.pkStorageDate.setValue(null);
    	
    	this.cbIsPass.setSelectedItem(null);
    	this.prmtCreator.setValue(null);
    	this.prmtAuditor.setValue(null);
    	this.pkCreateTime.setValue(null);
    	this.pkAuditDate.setValue(null);
    	this.prmtgatadeLv.setValue(null);
    	this.kDTabbedPane2.removeAll();
    	
    	this.editData.setSysSupplier(null);
    	this.editData.setLevel(null);
    	this.editData.setGrade(null);
    	this.editData.put("isPass", null);
    	this.editData.put("sysSupplier", null);
    	this.editData.put("storageNumber", null);
    	this.editData.put("storageDate", null);
    	
    	for (int i = 0; i < editData.getSupplierAttachListEntry().size(); i++) {
    		DesignSupplierStockSupplierAttachListEntryInfo  info = editData.getSupplierAttachListEntry().get(i);
    		info.setId(BOSUuid.create(info.getBOSType()));
		}
    	
    	this.kDContainer1.removeAllButton();
		initProWorkButton(this.kDContainer1,false);
    }
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockFactory.getRemoteInstance();
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
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        if(getUIContext().get("type")!=null){
        	objectValue.setInviteType((InviteTypeInfo)getUIContext().get("type"));
		}
		if(getUIContext().get("org")!=null){
			try {
				PurchaseOrgUnitInfo orgUnitInfo = PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(((OrgStructureInfo) getUIContext().get("org")).getUnit().getId()));
				objectValue.setPurchaseOrgUnit(orgUnitInfo);
			} catch (EASBizException e) {
				e.printStackTrace();
			} catch (BOSException e) {
				e.printStackTrace();
			}
		}
		try {
			objectValue.setCreateTime(FDCCommonServerHelper.getServerTimeStamp());
			SorterItemCollection sort=new SorterItemCollection();
   		 	sort.add(new SorterItemInfo("number"));
   		 	EntityViewInfo view=new EntityViewInfo();
   		 	FilterInfo filter = new FilterInfo();
            filter.getFilterItems().add(new FilterItemInfo("isEnabled" , Boolean.TRUE));
            view.setFilter(filter);
            view.setSorter(sort);
	        DesignSupplierAttachListCollection alCol=DesignSupplierAttachListFactory.getRemoteInstance().getDesignSupplierAttachListCollection(view);
	        for(int i=0;i<alCol.size();i++){
		       	DesignSupplierAttachListInfo at=alCol.get(i);
		       	DesignSupplierStockSupplierAttachListEntryInfo info=new DesignSupplierStockSupplierAttachListEntryInfo();
				info.setId(BOSUuid.create(info.getBOSType()));
				info.setNumber(at.getNumber());
				info.setName(at.getName());
				objectValue.getSupplierAttachListEntry().add(info);
	        }
		} catch (BOSException e1) {
			e1.printStackTrace();
		}
		objectValue.setHasCreatedSupplierBill(false);
		objectValue.setCreator(SysContext.getSysContext().getCurrentUserInfo());
		objectValue.setAdminCU(SysContext.getSysContext().getCurrentCtrlUnit());
		
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