/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.subill.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JComponent;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.OrgConstants;
import com.kingdee.eas.basedata.org.OrgStructureInfo;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitFactory;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.person.client.PersonPromptBox;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.fdc.basedata.client.FDCClientVerifyHelper;
import com.kingdee.eas.fdc.invite.InviteTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockLinkPersonCollection;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockLinkPersonFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockSupplierSplAreaEntryInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.QzCollection;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.QzFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseE2Info;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseEntryInfo;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationCollection;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationFactory;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierEvaluationInfo;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectCollection;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierSelectFactory;
import com.kingdee.eas.fdc.invite.designsupplier.uitls.PersonHelper;
import com.kingdee.eas.fdc.invite.designsupplier.uitls.WorkFlow;
import com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.ListUI;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.KDTableHelper;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDComboBox;
import com.kingdee.bos.ctrl.swing.KDContainer;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDPromptBox;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 * 设计供应商后评估编辑界面
 */
public class DesignSupplierAppraiseEditUI extends AbstractDesignSupplierAppraiseEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(DesignSupplierAppraiseEditUI.class);
    protected Map listenersMap = new HashMap();
    /**
     * output class constructor
     */
    public DesignSupplierAppraiseEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
    	detachListeners();
    	super.loadFields();
    	attachListeners();
    }
    
    
    protected void attachListeners() {
		addDataChangeListener(this.txtjtWeight);
		addDataChangeListener(this.txtsybWeight);
		addDataChangeListener(this.prmtsupplierNumber);
	}
	protected void detachListeners() {
		removeDataChangeListener(this.txtjtWeight);
		removeDataChangeListener(this.txtsybWeight);
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

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    
    public void onLoad() throws Exception {
    	this.pkauditDate.setEnabled(false);
    	this.txtsupplierName.setEnabled(false);
    	this.txtDesignType.setEnabled(false);
    	this.txtServiceArea.setEnabled(false);
    	this.txtgoal.setEnabled(false);
    	this.txtAuthorizedPer.setEnabled(false);
    	this.txtAuthorizedTel.setEnabled(false);
    	this.txtJob.setEnabled(false);
    	this.results.setEnabled(false); 
    	this.prmtsupplierLv.setEnabled(false); 
    	this.txtsybWeight.setEnabled(false); 
    	this.txtjtWeight.setEnabled(false); 
    	super.onLoad();
    	initF7();//过滤的方法
    	initButtonAction();
    	initControl();
    	initTable();
    	

    	this.chkMenuItemSubmitAndAddNew.setSelected(false);
    	this.chkMenuItemSubmitAndAddNew.setEnabled(false);
    }
    
   /*
    * 过滤
    */
    private void initF7(){
    	EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		Set org=new HashSet();
		
		if(editData.getOrg()!=null){
			org.add(editData.getOrg().getId().toString());  //把单据的所属事业部添加到集合中
		}
		org.add(OrgConstants.DEF_CU_ID);
		filter.getFilterItems().add(new FilterItemInfo("state",Integer.valueOf(SupplierStateEnum.APPROVE_VALUE)));
		filter.getFilterItems().add(new FilterItemInfo("purchaseOrgUnit.id",org,CompareType.INCLUDE));
		
		// by 2014 12 23 ,IT报事，暂时注释掉
//		filter.getFilterItems().add(new FilterItemInfo("isPass",Integer.valueOf(ResultsEnum.YL_VALUE),CompareType.EQUALS));
//		filter.getFilterItems().add(new FilterItemInfo("isPass",Integer.valueOf(ResultsEnum.HG_VALUE),CompareType.EQUALS));
//		filter.setMaskString("#0 and #1 and (#2 or #3)");
		view.setFilter(filter);
		this.prmtsupplierNumber.setEntityViewInfo(view);
    }
    
    /*
     * 初始化各种按钮
     */
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
		this.txtNumber.setRequired(true);
		this.prmtsupplierNumber.setRequired(true);
		this.pkBizDate.setRequired(true);
		this.results.setRequired(true);
    }
    
    private void initControl() throws BOSException{
    	this.contLastUpdateUser.setVisible(true);
    	this.contLastUpdateTime.setVisible(true);
    	this.prmtsupplierLv.setVisible(true);
    	this.contInvTyep.setVisible(false);
    	this.kDContainer1.getContentPane().add(kdtEntrys, BorderLayout.CENTER);
    	this.kDContainer2.getContentPane().add(kdtE2, BorderLayout.CENTER);
    	this.contOrg.setVisible(false);
    	this.prmtOrg.setVisible(false);
    	this.prmtInvTyep.setVisible(false);
        this.txtjtWeight.setRequired(true);
        this.txtsybWeight.setRequired(true);
        this.kdtEntrys.getColumn("Weight").setRequired(true);
        this.kdtEntrys.getColumn("Score").setRequired(true);
        this.kdtEntrys.getColumn("Reviewers").setRequired(true);
        this.kdtE2.getColumn("Weight").setRequired(true);
        this.kdtE2.getColumn("Score").setRequired(true);
        this.kdtE2.getColumn("Reviewers").setRequired(true);
        this.kdtEntrys.getColumn("ReviewersDep").getStyleAttributes().setLocked(true);
        this.kdtEntrys.getColumn("Weight").getStyleAttributes().setHided(true);
        this.kdtE2.getColumn("ReviewersDep").getStyleAttributes().setLocked(true);
        this.kdtE2.getColumn("Weight").getStyleAttributes().setHided(true);
        if(OprtState.ADDNEW.equals(getOprtState())){
        	results.setSelectedItem(null);
        }
        this.contsupplierName.getBoundLabel().setForeground(Color.RED);
        this.contgoal.getBoundLabel().setForeground(Color.RED);
        this.actionSave.setEnabled((OprtState.ADDNEW.equals(getOprtState()))?true:false);
    }
    
    public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
    	if(!this.state.getSelectedItem().equals(SupplierStateEnum.SAVE)&&!this.state.getSelectedItem().equals(SupplierStateEnum.SUBMIT)){
    		MsgBox.showWarning("当前单据已["+this.state.getSelectedItem().toString()+"]，不能修改！");SysUtil.abort();
    	}
    	if(editData.getId()!=null)
    		WorkFlow.checkBillInWorkflow(this, editData.getId().toString());
    	super.actionEdit_actionPerformed(arg0);
    	this.actionSave.setEnabled((OprtState.ADDNEW.equals(getOprtState()))?true:false);
    	kDContainer1.removeAllButton();
    	kDContainer2.removeAllButton();
    	initProWorkButton(this.kDContainer1, false);
    	initProTwoWorkButton(this.kDContainer2, false);
    }
    
    private void initTable(){
    	for (int i = 0; i < kdtEntrys.getRowCount(); i++) {
        	KDTableHelper.autoFitRowHeight(this.kdtEntrys, i);
		}
    	for (int i = 0; i < kdtEntrys.getColumnCount(); i++) {
        	this.kdtEntrys.getColumn(i).getStyleAttributes().setWrapText(true);
		}
    	initProWorkButton(this.kDContainer1, false);
    	initProTwoWorkButton(this.kDContainer2, false);
    	
    	HashMap map = new HashMap();
		map.put("All_Admins", "YES");
		map.put("DEFAULT_SHOW_ALL", "AAA");
		PersonPromptBox select = new PersonPromptBox(this, map);
    	KDBizPromptBox kdtEntrys_Reviewers_PromptBox = new KDBizPromptBox();
        kdtEntrys_Reviewers_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtEntrys_Reviewers_PromptBox.setVisible(true);
        kdtEntrys_Reviewers_PromptBox.setEditable(true);
        kdtEntrys_Reviewers_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_Reviewers_PromptBox.setEditFormat("$number$");
        kdtEntrys_Reviewers_PromptBox.setCommitFormat("$number$");
        kdtEntrys_Reviewers_PromptBox.setSelector(select);
        KDTDefaultCellEditor kdtEntrys_Reviewers_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Reviewers_PromptBox);
        this.kdtEntrys.getColumn("Reviewers").setEditor(kdtEntrys_Reviewers_CellEditor);
        this.kdtE2.getColumn("Reviewers").setEditor(kdtEntrys_Reviewers_CellEditor);
        ObjectValueRender kdtEntrys_Reviewers_OVR = new ObjectValueRender();
        kdtEntrys_Reviewers_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("Reviewers").setRenderer(kdtEntrys_Reviewers_OVR);
        this.kdtE2.getColumn("Reviewers").setRenderer(kdtEntrys_Reviewers_OVR);
    }
    
    protected void verifyInputForSubmit() throws Exception {
    	verifyInputForSave();
    	FDCClientVerifyHelper.verifyInput(this, this.kdtEntrys, "Score");
    	FDCClientVerifyHelper.verifyInput(this, this.kdtEntrys, "Reviewers");
    	FDCClientVerifyHelper.verifyInput(this, this.kdtE2, "Score");
    	FDCClientVerifyHelper.verifyInput(this, this.kdtE2, "Reviewers");
    	FDCClientVerifyHelper.verifyEmpty(this, this.txtjtWeight);
    	FDCClientVerifyHelper.verifyEmpty(this, this.txtsybWeight);
    	if(this.kdtE2.getRowCount()<1){
    		MsgBox.showWarning("请维护分公司评审信息！");SysUtil.abort();
    	}
    }
    
    protected void verifyInputForSave() throws Exception {
    	FDCClientVerifyHelper.verifyEmpty(this, this.txtNumber);
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtsupplierNumber);
		FDCClientVerifyHelper.verifyEmpty(this, this.pkBizDate);
		//FDCClientVerifyHelper.verifyEmpty(this, this.results);
		double a = (this.txtjtWeight.getDoubleValue()!=null)?this.txtjtWeight.getDoubleValue():0;
    	double b = (this.txtsybWeight.getDoubleValue()!=null)?this.txtsybWeight.getDoubleValue():0;
    	if(a+b!=100){MsgBox.showWarning("集团权重与事业部之和必须等于100！");SysUtil.abort();}
    	
    	if(getOprtState().equals(STATUS_GROUP_SCORING))
    	{
    		if(this.kdtEntrys.getRowCount()<1){
    			MsgBox.showWarning("请维护集团评审信息！");SysUtil.abort();
    		}
    		FDCClientVerifyHelper.verifyInput(this, this.kdtEntrys, "Score");
        	FDCClientVerifyHelper.verifyInput(this, this.kdtEntrys, "Reviewers");
    	}
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
					kdtEntrys_detailPanel.actionAddnewLine_actionPerformed(e);
			        for (int i = 0; i < kdtEntrys.getRowCount(); i++) {
			        	if(UIRuleUtil.isNull(kdtEntrys.getCell(i, "Weight").getValue())){
							kdtEntrys.getCell(i, "Weight").getStyleAttributes().setLocked(true);
							kdtEntrys.getCell(i, "Weight").getStyleAttributes().setBackground(new Color(231, 237, 242));
						}
			        }
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
                    for (int i = 0; i < kdtEntrys.getRowCount(); i++) {
                    	if(UIRuleUtil.isNull(kdtEntrys.getCell(i, "Weight").getValue())){
            				kdtEntrys.getCell(i, "Weight").getStyleAttributes().setLocked(true);
            				kdtEntrys.getCell(i, "Weight").getStyleAttributes().setBackground(new Color(231, 237, 242));
            			}
                    }
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
    
    protected void initProTwoWorkButton(KDContainer container,boolean flse){
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
					kdtE2_detailPanel.actionAddnewLine_actionPerformed(e);
					for (int i = 0; i < kdtE2.getRowCount(); i++) {
						if(UIRuleUtil.isNull(kdtE2.getCell(i, "Weight").getValue())){
							kdtE2.getCell(i, "Weight").getStyleAttributes().setLocked(true);
							kdtE2.getCell(i, "Weight").getStyleAttributes().setBackground(new Color(231, 237, 242));
						}
					}
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
            		kdtE2_detailPanel.actionInsertLine_actionPerformed(e);
            		for (int i = 0; i < kdtE2.getRowCount(); i++) {
						if(UIRuleUtil.isNull(kdtE2.getCell(i, "Weight").getValue())){
							kdtE2.getCell(i, "Weight").getStyleAttributes().setLocked(true);
							kdtE2.getCell(i, "Weight").getStyleAttributes().setBackground(new Color(231, 237, 242));
						}
					}
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
            		kdtE2_detailPanel.actionRemoveLine_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        });
    }
    
    /*
     *(non-Javadoc)
     * @see com.kingdee.eas.fdc.invite.designsupplier.subill.client.AbstractDesignSupplierAppraiseEditUI#prmtsupplierNumber_Changed()
     * 选中供应商带出相应的值
     */
    
    public void prmtsupplierNumber_Changed() throws Exception {
    	super.prmtsupplierNumber_Changed();
    	if(this.prmtsupplierNumber.getValue()!=null){
    		BOSUuid Id = ((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue()).getId();
    		DesignSupplierStockInfo info = DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(Id));
    		InviteTypeInfo InvTypeInfo = com.kingdee.eas.fdc.invite.InviteTypeFactory.getRemoteInstance().getInviteTypeInfo(new ObjectUuidPK(info.getInviteType().getId()));
    		PurchaseOrgUnitInfo PurchaseOrginfo = PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(info.getPurchaseOrgUnit().getId()));
    		String oql = "select id where supplierNumber.id='"+Id.toString()+"' and state='7'";
    		DesignSupplierSelectCollection selectColl = DesignSupplierSelectFactory.getRemoteInstance().getDesignSupplierSelectCollection(oql);
    		
    		// by 2014 12 23 ,IT报事，暂时注释掉，
//    		if(selectColl.size()<1){
//    			this.prmtsupplierNumber.setValue(null);
//    			MsgBox.showWarning("当前供应商未被选用，请重新选择！");SysUtil.abort();
//    		}
    		String entryOql = "select * where parent.id ='"+Id.toString()+"' and isDefault='1'";
			DesignSupplierStockLinkPersonCollection entryColl = DesignSupplierStockLinkPersonFactory.getRemoteInstance().getDesignSupplierStockLinkPersonCollection(entryOql);
			if(entryColl.size()>0){
				this.txtAuthorizedPer.setText(entryColl.get(0).getPersonName());
				this.txtAuthorizedTel.setText(entryColl.get(0).getPhone());
				this.txtJob.setText(entryColl.get(0).getPosition());
			} 
			//供应商级别
			if(info.getGatadeLv()!=null){
				this.prmtsupplierLv.setValue(DesignGradeSetUpFactory.getRemoteInstance().getDesignGradeSetUpInfo(new ObjectUuidPK(info.getGatadeLv().getId())));
			}else{
				this.prmtsupplierLv.setValue(null);
			}
    		this.txtsupplierName.setText(info.getName());
    		this.prmtInvTyep.setValue(InvTypeInfo);
    		this.txtDesignTypeID.setText(InvTypeInfo.getId().toString());
    		this.txtDesignType.setText(InvTypeInfo.getName());
    		this.prmtOrg.setValue(PurchaseOrginfo);
    		
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
    
    protected void prmtsupplierNumber_dataChanged(DataChangeEvent e)throws Exception {
    	super.prmtsupplierNumber_dataChanged(e);
    }
    
    private String getResource(String msg) {
		return EASResource.getString("com.kingdee.eas.fdc.invite.supplier.SupplierResource", msg);
	}
    
    public void actionSave_actionPerformed(ActionEvent e) throws Exception {
    	verifyInputForSave();
    	super.actionSave_actionPerformed(e);
    }
    
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
    	verifyInputForSubmit();
    	super.actionSubmit_actionPerformed(e);
    	setOprtState(OprtState.VIEW);
    	if (getOprtState().equals(OprtState.ADDNEW) || getOprtState().equals(OprtState.EDIT))
			((ListUI) getUIContext().get(UIContext.OWNER)).getMainTable().removeRows();
    }

    protected void afterSubmitAddNew(){
    }
	protected boolean isContinueAddNew() {
		return false;
	}

    protected void kdtE2_editStopped(KDTEditEvent e) throws Exception {
    	super.kdtE2_editStopped(e);
    	if(e.getRowIndex()==-1)
    		return;
    	KDTableHelper.autoFitRowHeight(this.kdtE2, e.getRowIndex());
    	if(UIRuleUtil.isNotNull(this.kdtE2.getCell(e.getRowIndex(), "Reviewers").getValue())){
    		PersonInfo perInfo = (PersonInfo)this.kdtE2.getCell(e.getRowIndex(), "Reviewers").getValue();
    		this.kdtE2.getCell(e.getRowIndex(), "ReviewersDep").setValue(PersonHelper.getPosiMemByDeptUser(perInfo));
    	}
    	if(UIRuleUtil.isNotNull(this.kdtE2.getCell(e.getRowIndex(), "Score").getValue())){
    		double a = UIRuleUtil.getDouble(this.kdtE2.getCell(e.getRowIndex(), "Score").getValue().toString());
    		if(a>100){this.kdtE2.getCell(e.getRowIndex(), "Score").setValue(0);MsgBox.showWarning("评分不能大于100！");SysUtil.abort();};
    	}
    	getSumScore();
    }
    
    private void  getSumScore(){
    	double a = (this.txtjtWeight.getDoubleValue()!=null)?this.txtjtWeight.getDoubleValue()/100:0;
    	double b = (this.txtsybWeight.getDoubleValue()!=null)?this.txtsybWeight.getDoubleValue()/100:0;
    	double score = 0;
    	int rowcount = this.kdtE2.getRowCount();
    	for (int i = 0; i < rowcount; i++) {
    		if(UIRuleUtil.isNotNull(this.kdtE2.getCell(i, "Score").getValue()))
    			score += UIRuleUtil.getDouble(this.kdtE2.getCell(i, "Score").getValue().toString());
		}
    	
    	double jtscore = 0;
    	int jtrowcount = this.kdtEntrys.getRowCount();
    	for (int i = 0; i < jtrowcount; i++) {
    		if(UIRuleUtil.isNotNull(this.kdtEntrys.getCell(i, "Score").getValue()))
    			jtscore += UIRuleUtil.getDouble(this.kdtEntrys.getCell(i, "Score").getValue().toString());
		}
    	double sc = ((rowcount!=0)?(score/rowcount*b):0)+((jtrowcount!=0)?(jtscore/jtrowcount*a):0);
    	BigDecimal lastscore = new BigDecimal(String.format("%.2f", sc));
    	this.txtgoal.setValue(lastscore);
    	if(lastscore.doubleValue()>=80){
    		this.results.setSelectedItem(ResultsEnum.yl);
    	}else if(60<=lastscore.doubleValue()&&lastscore.doubleValue()<80){
    		this.results.setSelectedItem(ResultsEnum.hg);
    	}else{
    		this.results.setSelectedItem(ResultsEnum.bhg);
    	}
    }
    
    protected void txtjtWeight_dataChanged(DataChangeEvent e) throws Exception {
    	super.txtjtWeight_dataChanged(e);
    	double a = (this.txtjtWeight.getDoubleValue()!=null)?this.txtjtWeight.getDoubleValue():0;
    	double b = (this.txtsybWeight.getDoubleValue()!=null)?this.txtsybWeight.getDoubleValue():0;
    	if(a+b>100){this.txtjtWeight.setValue(BigDecimal.ZERO);MsgBox.showWarning("集团权重与事业部之和不能大于100！");SysUtil.abort();}
    	getSumScore();
    }
    
    protected void txtsybWeight_dataChanged(DataChangeEvent e) throws Exception {
    	super.txtsybWeight_dataChanged(e);
    	double a = (this.txtjtWeight.getDoubleValue()!=null)?this.txtjtWeight.getDoubleValue():0;
    	double b = (this.txtsybWeight.getDoubleValue()!=null)?this.txtsybWeight.getDoubleValue():0;
    	if(a+b>100){this.txtsybWeight.setValue(BigDecimal.ZERO);MsgBox.showWarning("集团权重与事业部之和不能大于100！");SysUtil.abort();}
    	getSumScore();
    }
    
    
    protected void kdtEntrys_editStopped(KDTEditEvent e) throws Exception {
    	super.kdtEntrys_editStopped(e);
    	if(e.getRowIndex()==-1)
    		return;
    	KDTableHelper.autoFitRowHeight(this.kdtEntrys, e.getRowIndex());
    	if(UIRuleUtil.isNotNull(this.kdtEntrys.getCell(e.getRowIndex(), "Reviewers").getValue())){
    		PersonInfo perInfo = (PersonInfo)this.kdtEntrys.getCell(e.getRowIndex(), "Reviewers").getValue();
    		this.kdtEntrys.getCell(e.getRowIndex(), "ReviewersDep").setValue(PersonHelper.getPosiMemByDeptUser(perInfo));
    	}
    	if(UIRuleUtil.isNotNull(this.kdtEntrys.getCell(e.getRowIndex(), "Score").getValue())){
    		double a = UIRuleUtil.getDouble(this.kdtEntrys.getCell(e.getRowIndex(), "Score").getValue().toString());
    		if(a>100){this.kdtEntrys.getCell(e.getRowIndex(), "Score").setValue(0);MsgBox.showWarning("评分不能大于100！");SysUtil.abort();};
    	}
    	getSumScore();
    }
    
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseFactory.getRemoteInstance();
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
        com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		DesignSupplierAppraiseEntryInfo entryInfo = new DesignSupplierAppraiseEntryInfo();
		entryInfo.setWeight("60");
		DesignSupplierAppraiseE2Info e2Info = new DesignSupplierAppraiseE2Info();
		e2Info.setWeight("40");
		objectValue.getE2().add(e2Info);
//		objectValue.getEntrys().add(entryInfo);
		
		objectValue.setState(SupplierStateEnum.SAVE);
		if(getUIContext().get("org")!=null){
			try {
				QzCollection qzColl = QzFactory.getRemoteInstance().getQzCollection("where isEnabled='1'");
				if(qzColl.size()>0){
					objectValue.setJtWeight(qzColl.get(0).getJtqz());
					objectValue.setSybWeight(qzColl.get(0).getSybqz());
				}
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