/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.demotion.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.KDTableHelper;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.org.OrgConstants;
import com.kingdee.eas.basedata.org.OrgStructureInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitCollection;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitFactory;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.cp.bc.BizCollUtil;
import com.kingdee.eas.fdc.basedata.client.FDCClientVerifyHelper;
import com.kingdee.eas.fdc.basedata.client.FDCMsgBox;
import com.kingdee.eas.fdc.invite.InviteTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockCollection;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockLinkPersonCollection;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockLinkPersonFactory;
import com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockSupplierSplAreaEntryInfo;
import com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionEntryInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAccreditationTypeInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaFactory;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignServiceAreaInfo;
import com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseCollection;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseFactory;
import com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo;
import com.kingdee.eas.fdc.invite.designsupplier.uitls.WorkFlow;
import com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 * 供应商升降级编辑界面
 */
public class DemotionEditUI extends AbstractDemotionEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(DemotionEditUI.class);
    
    /**
     * output class constructor
     *构造方法
     */
    public DemotionEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     * 加载过滤
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

    /**
     * output btnAddLine_actionPerformed method
     */
    protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnAddLine_actionPerformed(e);
    }

    /**
     * output menuItemEnterToNextRow_itemStateChanged method
     */
    protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
        super.menuItemEnterToNextRow_itemStateChanged(e);
    }

    /**
     * output prmtsupplierNumber_dataChanged method
     */
  
   


    /**
     * output prmtEvaluationType_dataChanged method
     */
    protected void prmtEvaluationType_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        super.prmtEvaluationType_dataChanged(e);
    }

    /**
     * output prmtsupplierTemple_dataChanged method
     */
    protected void prmtsupplierTemple_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        super.prmtsupplierTemple_dataChanged(e);
    }

    /**
     * output prmtsupplierlastClas_stateChanged method
     * 拟升降供应商等级改变事件
     */
    protected void prmtsupplierlastClas_stateChanged(javax.swing.event.ChangeEvent e) throws Exception
    {
       super.prmtsupplierlastClas_stateChanged(e);
       if(this.prmtsupplierNumber.getValue()!=null){
    	   BOSUuid Id = ((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue()).getId();
    	   DesignSupplierStockInfo SuStockinfo = DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(Id));//当前选中的设计供应商档案
    	   String Ids= SuStockinfo.getPurchaseOrgUnit().getId().toString();//当前供应商所在组织单元
    	   PurchaseOrgUnitInfo beSuStockinfo = PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(Ids));
    	   String purName=beSuStockinfo.getId().toString();
    	   OrgUnitInfo cuInfo = SysContext.getSysContext().getCurrentOrgUnit();
    	   String bNumber= cuInfo.getId().toString();//当前供应商组织编号
    	  
    	   
    	if(this.prmtsupplierlastClas.getValue()!=null){
    		DesignGradeSetUpInfo info = (DesignGradeSetUpInfo)this.prmtsupplierlastClas.getValue();//拟升降供应商等级
    		int infoId= Integer.parseInt(info.getNumber());//拟升降编号
    		String number = "00"+String.valueOf(infoId);
    		DesignGradeSetUpInfo infos = (DesignGradeSetUpInfo)this.prmtsupplierClas.getValue(); //审前供应商等级
    		int beInfoId= Integer.parseInt(infos.getNumber());//审前编号
    		String beNumber = "00"+String.valueOf(beInfoId);
    		

       //当前为事业部
    		 if(!(purName.equals("00000000-0000-0000-0000-000000000000CCE7AED4"))){
    		   if("001".equals(beNumber)){
    			  if("001".equals(number)){
    				  MsgBox.showWarning("当前评审等级已经是"+infos+"不允许进行同级升降");
	  		          this.prmtsupplierlastClas.setValue(null);
    			  } 
    		  }else if("002".equals(beNumber)){
    			  if("004".equals(number)){
    				  MsgBox.showWarning("当前评审等级已经是"+infos+"不允许进行跨级降");
	  		          this.prmtsupplierlastClas.setValue(null);
    			  }
    		  }else if("003".equals(beNumber)){
    			  if("002".equals(number)){
    				  MsgBox.showWarning("当前所属组织是"+beSuStockinfo+"不能降到"+info);
	  		          this.prmtsupplierlastClas.setValue(null); 
    			  }else if("004".equals(number)){
    				  MsgBox.showWarning("当前评审等级已经是"+infos+"不允许进行跨级降");
	  		          this.prmtsupplierlastClas.setValue(null);
    			  }
    		  }else if("004".equals(beNumber)){
    			  if("004".equals(number)){
    				  MsgBox.showWarning("当前评审等级是"+infos+"不允许进行同级升降");
	  		          this.prmtsupplierlastClas.setValue(null);
    			  }else if("002".equals(number)){
    				  MsgBox.showWarning("当前评审等级是"+infos+"不允许升为"+info);
	  		          this.prmtsupplierlastClas.setValue(null);
    			  }
    		  }
    	   }
    		  //当前为集团
    		  else {
    			  if("001".equals(beNumber)){
    				  if("001".equals(number)){
        				  MsgBox.showWarning("当前评审等级已经是"+infos+"不允许进行同级升降");
    	  		          this.prmtsupplierlastClas.setValue(null);
        			  }  
    				  
    			  }else if("002".equals(beNumber)){
    				  if("004".equals(number)){
        				  MsgBox.showWarning("当前评审等级已经是"+infos+"不允许进行跨级降");
    	  		          this.prmtsupplierlastClas.setValue(null);
        			  }else if("002".equals(number)){
        				  MsgBox.showWarning("当前评审等级已经是"+infos+"不允许降为"+info);
    	  		          this.prmtsupplierlastClas.setValue(null);
        			  }
    			  }else if("003".equals(beNumber)){
    				  if("004".equals(number)){
    					  MsgBox.showWarning("当前评审等级已经是"+infos+"不允许进行跨级降"); 
    	  		          this.prmtsupplierlastClas.setValue(null); 
    				  }
    			  }else if("004".equals(beNumber)){
    				  if("004".equals(number)){
    					  MsgBox.showWarning("当前评审等级已经是"+infos+"不允许进行同级升降");
    	  		          this.prmtsupplierlastClas.setValue(null);  
    				    }else if("003".equals(number)){
    				      MsgBox.showWarning("当前评审等级是"+infos+"不允许升为"+info);
	  		              this.prmtsupplierlastClas.setValue(null);
    			      }
    		
    		       }
    			  
    	     }	
     
    	 }
       }
       
    }  
        
        
    
    
    //页面文本框必输项校验
   protected void verifyInput(ActionEvent e)
    throws Exception
  {
    super.verifyInput(e);
    if (UIRuleUtil.isNull(this.prmtsupplierlastClas.getText()))
    {
      com.kingdee.eas.util.client.MsgBox.showWarning("拟升降供应商等级不能为空！");
      SysUtil.abort();
    }
//    if(UIRuleUtil.isNull(this.prmtEvaluationType.getText())){
//    	com.kingdee.eas.util.client.MsgBox.showWarning("评审类型不能为空！");
//    }
  }


    /**
     * output kdtEntrys_editStopping method
     */
    protected void kdtEntrys_editStopping(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
        super.kdtEntrys_editStopping(e);
    }

    /**
     * output kdtEntrys_editStopped method
     */
    protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
        super.kdtEntrys_editStopped(e);
    }

    /**
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }

    /**
     * output actionExitCurrent_actionPerformed
     */
    public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExitCurrent_actionPerformed(e);
    }

    /**
     * output actionHelp_actionPerformed
     */
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHelp_actionPerformed(e);
    }

    /**
     * output actionAbout_actionPerformed
     */
    public void actionAbout_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAbout_actionPerformed(e);
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

    /**
     * output actionSendMessage_actionPerformed
     */
    public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMessage_actionPerformed(e);
    }

    /**
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }

    /**
     * output actionExport_actionPerformed
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }

    /**
     * output actionExportSelected_actionPerformed
     */
    public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelected_actionPerformed(e);
    }

    /**
     * output actionRegProduct_actionPerformed
     */
    public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRegProduct_actionPerformed(e);
    }

    /**
     * output actionPersonalSite_actionPerformed
     */
    public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPersonalSite_actionPerformed(e);
    }

    /**
     * output actionProcductVal_actionPerformed
     */
    public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionProcductVal_actionPerformed(e);
    }

    /**
     * output actionExportSave_actionPerformed
     */
    public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSave_actionPerformed(e);
    }

    /**
     * output actionExportSelectedSave_actionPerformed
     */
    public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelectedSave_actionPerformed(e);
    }

    /**
     * output actionKnowStore_actionPerformed
     */
    public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionKnowStore_actionPerformed(e);
    }

    /**
     * output actionAnswer_actionPerformed
     */
    public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAnswer_actionPerformed(e);
    }

    /**
     * output actionRemoteAssist_actionPerformed
     */
    public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoteAssist_actionPerformed(e);
    }

    /**
     * output actionPopupCopy_actionPerformed
     */
    public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupCopy_actionPerformed(e);
    }

    /**
     * output actionHTMLForMail_actionPerformed
     */
    public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForMail_actionPerformed(e);
    }

    /**
     * output actionExcelForMail_actionPerformed
     */
    public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForMail_actionPerformed(e);
    }

    /**
     * output actionHTMLForRpt_actionPerformed
     */
    public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForRpt_actionPerformed(e);
    }

    /**
     * output actionExcelForRpt_actionPerformed
     */
    public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForRpt_actionPerformed(e);
    }

    /**
     * output actionLinkForRpt_actionPerformed
     */
    public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLinkForRpt_actionPerformed(e);
    }

    /**
     * output actionPopupPaste_actionPerformed
     */
    public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupPaste_actionPerformed(e);
    }
    
  

   
    
    /*
     * 
     */
    protected void verifyInputForSubmit() throws Exception {
    	verifyInputForSave();
    	//评估时间，备注的输入校验
    	//FDCClientVerifyHelper.verifyInput(this, this.kdtEntrys, "IsQualified");
    	//FDCClientVerifyHelper.verifyInput(this, this.kdtEntrys, "Casedescription");
    }
    
    /*
     *保存的方法，校验单元格是否为空
     */
    protected void verifyInputForSave() throws Exception {
    	//FDCClientVerifyHelper.verifyEmpty(this, this.txtNumber);//判断单据编号不为空
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtsupplierNumber);
		FDCClientVerifyHelper.verifyEmpty(this, this.pkBizDate);

		//FDCClientVerifyHelper.verifyEmpty(this, this.prmtEvaluationType);//评审类型
		//FDCClientVerifyHelper.verifyEmpty(this, this.prmtsupplierTemple);//评审模板
		FDCClientVerifyHelper.verifyEmpty(this, this.prmtsupplierlastClas);
		
		
    }
    
    /*
     * 初始化各种控件
     */
//    protected void initProWorkButton(KDContainer container,boolean flse){
//    	KDWorkButton btnAddRowinfo=new KDWorkButton();
//    	KDWorkButton btnInsertRowinfo=new KDWorkButton();
//    	KDWorkButton btnDeleteRowinfo=new KDWorkButton();
//    	btnAddRowinfo.setEnabled((OprtState.EDIT.equals(getOprtState())||OprtState.ADDNEW.equals(getOprtState()))?true:false);
//    	btnInsertRowinfo.setEnabled((OprtState.EDIT.equals(getOprtState())||OprtState.ADDNEW.equals(getOprtState()))?true:false);
//    	btnDeleteRowinfo.setEnabled((OprtState.EDIT.equals(getOprtState())||OprtState.ADDNEW.equals(getOprtState()))?true:false);
//    	btnAddRowinfo.setIcon( EASResource.getIcon("imgTbtn_addline"));
//    	container.addButton(btnAddRowinfo);
//		btnAddRowinfo.setText(getResource("addRow"));
//		btnAddRowinfo.setSize(new Dimension(140, 19));
//		btnAddRowinfo.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent e) {
//            	try {
//					kdtEntrys_detailPanel.actionInsertLine_actionPerformed(e);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//            }
//        });
//		
//		btnInsertRowinfo.setIcon( EASResource.getIcon("imgTbtn_addline"));
//    	container.addButton(btnInsertRowinfo);
//		btnInsertRowinfo.setText(getResource("insertRow"));
//		btnInsertRowinfo.setSize(new Dimension(140, 19));
//		btnInsertRowinfo.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent e) {
//            	try {
//            		kdtEntrys_detailPanel.actionInsertLine_actionPerformed(e);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//            }
//        });
//		
//		btnDeleteRowinfo.setIcon( EASResource.getIcon("imgTbtn_addline"));
//    	container.addButton(btnDeleteRowinfo);
//		btnDeleteRowinfo.setText(getResource("deleteRow"));
//		btnDeleteRowinfo.setSize(new Dimension(140, 19));
//		btnDeleteRowinfo.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent e) {
//            	try {
//            		kdtEntrys_detailPanel.actionRemoveLine_actionPerformed(e);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//            }
//        });
//    }
    
    private String getResource(String msg) {
		return EASResource.getString("com.kingdee.eas.fdc.invite.supplier.SupplierResource", msg);
	}
    
    
    /**
     * output actionSave_actionPerformed
     * 保存事件
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
    	verifyInputForSave();
        super.actionSave_actionPerformed(e);
        
    }
    
    
    /**防止提交之后出现空白单据**/
    protected void afterSubmitAddNew(){
		
	}
    
	protected boolean isContinueAddNew() {
		return false;
	}

    /**
     * output actionSubmit_actionPerformed
     * 提交事件
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
    	
    	verifyInputForSubmit();
    	super.actionSubmit_actionPerformed(e);
    	setOprtState(OprtState.VIEW);//设置提交之后的打开的状态为View
    	//com.kingdee.eas.util.client.MsgBox.showWarning("当前的单据状态是"+editData.getState());
//    	if (getOprtState().equals(OprtState.ADDNEW) || getOprtState().equals(OprtState.EDIT))
//			((ListUI) getUIContext().get(UIContext.OWNER)).getMainTable().removeRows();
    }

    /**
     * output actionCancel_actionPerformed
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
    }

    /**
     * output actionCancelCancel_actionPerformed
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancelCancel_actionPerformed(e);
    }

    /**
     * output actionFirst_actionPerformed
     */
    public void actionFirst_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionFirst_actionPerformed(e);
    }

    /**
     * output actionPre_actionPerformed
     */
    public void actionPre_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPre_actionPerformed(e);
    }

    /**
     * output actionNext_actionPerformed
     */
    public void actionNext_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNext_actionPerformed(e);
    }

    /**
     * output actionLast_actionPerformed
     */
    public void actionLast_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLast_actionPerformed(e);
    }

    /**
     * output actionPrint_actionPerformed
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrint_actionPerformed(e);
    }

    /**
     * output actionPrintPreview_actionPerformed
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrintPreview_actionPerformed(e);
    }

    /**
     * output actionCopy_actionPerformed
     */
    public void actionCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopy_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }

    /**
     * output actionEdit_actionPerformed
     * 修改
     */
  
    public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
    	
    		if(!this.state.getSelectedItem().equals(SupplierStateEnum.SAVE)&&!this.state.getSelectedItem().equals(SupplierStateEnum.SUBMIT)){
    	    		MsgBox.showWarning("当前单据已["+this.state.getSelectedItem().toString()+"]，不能修改！");SysUtil.abort();
    	    	}
    	   	if(editData.getId()!=null)
    	    		WorkFlow.checkBillInWorkflow(this, editData.getId().toString());
    	   	super.actionEdit_actionPerformed(arg0);
    	   	this.actionSave.setEnabled((OprtState.ADDNEW.equals(getOprtState()))?true:false);
    	    
        //修改事件默认控件不可编辑
      	this.txtNumber.setEnabled(false);
    	this.txtDesignType.setEnabled(false);
    	this.txtAuthorizedPer.setEnabled(false);
    	this.txtServiceArea.setEnabled(false);
    	this.txtAuthorizedTel.setEnabled(false);
    	this.txtsupplierName.setEnabled(false);
    	this.txtjob.setEnabled(false);
    	this.prmtsupplierClas.setEnabled(false);
    	this.prmtAuditor.setEnabled(false);
    	this.pkauditDate.setEnabled(false);
    	this.prmtCreator.setEnabled(false);
    	this.prmtLastUpdateUser.setEnabled(false);
        
    }
    
    
    

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemove_actionPerformed(e);
    }

    /**
     * output actionAttachment_actionPerformed
     */
    public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAttachment_actionPerformed(e);
    }

    /**
     * output actionSubmitOption_actionPerformed
     */
    public void actionSubmitOption_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmitOption_actionPerformed(e);
    }

    /**
     * output actionReset_actionPerformed
     * 
     */
    public void actionReset_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionReset_actionPerformed(e);
    }

    /**
     * output actionMsgFormat_actionPerformed
     */
    public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMsgFormat_actionPerformed(e);
    }

    /**
     * output actionAddLine_actionPerformed
     */
    public void actionAddLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddLine_actionPerformed(e);
    }

    /**
     * output actionCopyLine_actionPerformed
     */
    public void actionCopyLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyLine_actionPerformed(e);
    }

    /**
     * output actionInsertLine_actionPerformed
     */
    public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInsertLine_actionPerformed(e);
    }

    /**
     * output actionRemoveLine_actionPerformed
     */
    public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoveLine_actionPerformed(e);
    }

    /**
     * output actionCreateFrom_actionPerformed
     */
    public void actionCreateFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateFrom_actionPerformed(e);
    }

    /**
     * output actionCopyFrom_actionPerformed
     */
    public void actionCopyFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyFrom_actionPerformed(e);
    }

    /**
     * output actionAuditResult_actionPerformed
     */
    public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAuditResult_actionPerformed(e);
    }

    /**
     * output actionTraceUp_actionPerformed
     */
    public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceUp_actionPerformed(e);
    }

    /**
     * output actionTraceDown_actionPerformed
     */
    public void actionTraceDown_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceDown_actionPerformed(e);
    }

    /**
     * output actionViewSubmitProccess_actionPerformed
     */
    public void actionViewSubmitProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSubmitProccess_actionPerformed(e);
    }

    /**
     * output actionViewDoProccess_actionPerformed
     */
    public void actionViewDoProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewDoProccess_actionPerformed(e);
    }

    /**
     * output actionMultiapprove_actionPerformed
     */
    public void actionMultiapprove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMultiapprove_actionPerformed(e);
    }

    /**
     * output actionNextPerson_actionPerformed
     */
    public void actionNextPerson_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNextPerson_actionPerformed(e);
    }

    /**
     * output actionStartWorkFlow_actionPerformed
     */
    public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionStartWorkFlow_actionPerformed(e);
    }

    /**
     * output actionVoucher_actionPerformed
     */
    public void actionVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionVoucher_actionPerformed(e);
    }

    /**
     * output actionDelVoucher_actionPerformed
     */
    public void actionDelVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionDelVoucher_actionPerformed(e);
    }

    /**
     * output actionWorkFlowG_actionPerformed
     */
    public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkFlowG_actionPerformed(e);
    }

    /**
     * output actionCreateTo_actionPerformed
     */
    public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateTo_actionPerformed(e);
    }

    /**
     * output actionSendingMessage_actionPerformed
     */
    public void actionSendingMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendingMessage_actionPerformed(e);
    }

    /**
     * output actionSignature_actionPerformed
     */
    public void actionSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSignature_actionPerformed(e);
    }

    /**
     * output actionWorkflowList_actionPerformed
     */
    public void actionWorkflowList_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkflowList_actionPerformed(e);
    }

    /**
     * output actionViewSignature_actionPerformed
     */
    public void actionViewSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSignature_actionPerformed(e);
    }

    /**
     * output actionSendMail_actionPerformed
     */
    public void actionSendMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMail_actionPerformed(e);
    }

    /**
     * output actionLocate_actionPerformed
     */
    public void actionLocate_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLocate_actionPerformed(e);
    }

    /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAudit_actionPerformed(e);
    }

    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionUnAudit_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     * 
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
    	
        return null;
        
      
    }

    /**
     * output createNewData method
     * 创建一张单据
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
    	 com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionInfo();
         objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		DemotionEntryInfo entryInfo=new DemotionEntryInfo();
		entryInfo.setReview("60");//评估综合得分
		entryInfo.setIndexName(null);//评估结果
		entryInfo.setIsQualified(null);//评估时间
		entryInfo.setCasedescription(null);//备注
		//setOprtState(OprtState.VIEW);
		objectValue.setState(SupplierStateEnum.SAVE);//把单据的状态设置为保存
		if(getUIContext().get("org")!=null){
			try {
			
				PurchaseOrgUnitInfo orgUnitInfo = PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(((OrgStructureInfo) getUIContext().get("org")).getUnit().getId()));
				objectValue.setOrg(orgUnitInfo);   //供应商所属组织过滤
				objectValue.setPusOrg(orgUnitInfo);//供应商所属组织过滤
			} catch (EASBizException e) {
				e.printStackTrace();
			} catch (BOSException e) {
				e.printStackTrace();
			}
		}
	
        return objectValue;
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
		this.txtNumber.setRequired(true);//查询出单据编号
		this.prmtsupplierNumber.setRequired(true);
		this.pkBizDate.setRequired(true);
	
    }
    
    
    /*
     * 初始化界面 
     */
    protected void initUi()
      throws Exception
    {
    	this.txtNumber.setEnabled(false);
    	this.txtDesignType.setEnabled(false);
    	this.txtAuthorizedPer.setEnabled(false);
    	this.txtServiceArea.setEnabled(false);
    	this.txtAuthorizedTel.setEnabled(false);
    	this.txtsupplierName.setEnabled(false);
    	this.txtjob.setEnabled(false);
    	this.prmtsupplierClas.setEnabled(false);
    	this.prmtAuditor.setEnabled(false);
    	this.pkauditDate.setEnabled(false);
    	this.prmtCreator.setEnabled(false);
    	this.prmtLastUpdateUser.setEnabled(false);
    	this.prmtsupplierlastClas.setRequired(true);
    	initControl();
    	
    }
    @Override
    public void onShow() throws Exception {
    	// TODO Auto-generated method stub
    	super.onShow();
    		
    		setF7Filter((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue(), (DesignAccreditationTypeInfo)this.prmtEvaluationType.getValue(), (DesignAppraiseTemplateInfo)this.prmtsupplierTemple.getValue());	
    }
    
    
    
 
    
    /*
     * (non-Javadoc)
     * @see com.kingdee.eas.framework.client.CoreBillEditUI#onLoad()
     */
    public void onLoad()
     throws Exception
    {
    	super.onLoad();
    	initButtonAction();
    	initUi();
    	
    }
    
    private void initControl() throws Exception{
    	this.contLastUpdateUser.setVisible(true);//最后修改者
    	this.contLastUpdateTime.setVisible(true);//最后修改时间
        kDContainer1.getContentPane().add(kdtEntrys, BorderLayout.CENTER);//向控件中添加表（kdtEntry）
    
        
        //向表中添加单元格字段
        this.kdtEntrys.getColumn("Review").getStyleAttributes().setLocked(true);
        this.kdtEntrys.getColumn("IndexName").getStyleAttributes().setLocked(true);
        this.kdtEntrys.getColumn("IsQualified").setRequired(true);
        this.kdtEntrys.getColumn("Casedescription").setRequired(true);
        setF7Filter((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue(), (DesignAccreditationTypeInfo)this.prmtEvaluationType.getValue(), (DesignAppraiseTemplateInfo)this.prmtsupplierTemple.getValue());
        this.contInvTyep.setVisible(false);//设计类别
        this.prmtOrg.setVisible(false);//所属事业部（隐藏）
        this.contIshg.setVisible(false);//是否合格
        this.actionSave.setEnabled((OprtState.ADDNEW.equals(getOprtState()))?true:false);
        this.contdemotionlastClas.setBoundLabelText("拟升降供应商等级");   
        this.contsupplierName.getBoundLabel().setForeground(Color.RED);
    }
    
    
    /*
     * (non-Javadoc)
     * @see com.kingdee.eas.fdc.invite.designsupplier.subill.client.AbstractDesignSupplierEvaluationEditUI#prmtsupplierNumber_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent)
     * 供应商编号选定带出相应的值
     */
     protected void prmtsupplierNumber_dataChanged(DataChangeEvent e)
    		throws Exception {
    	//过滤供应商编码，评审类型，评审前等级
    	setF7Filter((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue(), (DesignAccreditationTypeInfo)this.prmtEvaluationType.getValue(), (DesignAppraiseTemplateInfo)this.prmtsupplierTemple.getValue());
    	
    	OrgUnitInfo cuInfo = SysContext.getSysContext().getCurrentOrgUnit();
    
    	
    	if(this.prmtsupplierNumber.getValue()!=null){
    		BOSUuid Id = ((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue()).getId();//选中的供应商编码
           // System.out.println("选中的供应商编号："+Id);
    		
    		DesignSupplierStockInfo info = DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(Id));//通过id获得选中的供应商
    		PurchaseOrgUnitInfo PurchaseOrginfo = PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(info.getPurchaseOrgUnit().getId()));//获得选中的供应商所属事业部组织
    	
    		InviteTypeInfo InvTypeInfo = com.kingdee.eas.fdc.invite.InviteTypeFactory.getRemoteInstance().getInviteTypeInfo(new ObjectUuidPK(info.getInviteType().getId()));//设计类别
    		//判断供应商级别
			if(info.getGatadeLv()!=null){
				this.prmtsupplierClas.setValue(DesignGradeSetUpFactory.getRemoteInstance().getDesignGradeSetUpInfo(new ObjectUuidPK(info.getGatadeLv().getId())));
			}else{
				this.prmtsupplierClas.setValue(null);
			}
			
			//选中的供应商是否存在授权联系人
			String entryOql = "select * where parent.id ='"+Id.toString()+"' and isDefault='1'";
			DesignSupplierStockLinkPersonCollection entryColl = DesignSupplierStockLinkPersonFactory.getRemoteInstance().getDesignSupplierStockLinkPersonCollection(entryOql);
			if(entryColl.size()>0){
				this.txtAuthorizedPer.setText(entryColl.get(0).getPersonName());//授权联系人
				this.txtAuthorizedTel.setText(entryColl.get(0).getPhone());//授权联系人电话
				this.txtjob.setText(entryColl.get(0).getPosition());//职务
			}else{
				this.txtjob.setText(null);//不存在授权联系人职务默认为空
			}
    		this.txtsupplierName.setText(info.getName());
    		this.txtDesignType.setText(InvTypeInfo.getName());//设计类别
    		
    		this.prmtInvTyep.setValue(InvTypeInfo);
    		this.txtDesignTypeID.setText(InvTypeInfo.getId().toString());
      //    this.txtDesignType.setText(InvTypeInfo.getName());//设计类型
    		this.prmtOrg.setValue(PurchaseOrginfo);//所属事业部
    		String area = "";
    		//遍历供应商服务区域
    		for (int i = 0; i < info.getSupplierSplAreaEntry().size(); i++) {
    			DesignSupplierStockSupplierSplAreaEntryInfo entryInfo = info.getSupplierSplAreaEntry().get(i);//供应商服务区域分录
    			DesignServiceAreaInfo AreaInfo = DesignServiceAreaFactory.getRemoteInstance().getDesignServiceAreaInfo(new ObjectUuidPK(entryInfo.getFdcSplArea().getId())) ;
    			if("".equals(area.trim()))
    				area += AreaInfo.getName();
    			else
    				area += ";"+AreaInfo.getName();
			}
    		this.txtServiceArea.setText(area);//服务区域
    		
    		
    		//供应商编号选定带出后评估信息
    		boolean isChanged = true;
    		isChanged = BizCollUtil.isF7ValueChanged(e);
            if(!isChanged){
            	return;
            }
        		boolean isShowWarn=false;
                boolean isUpdate=false;
                if(this.kdtEntrys.getRowCount()>0){
                	isShowWarn=true;
                }
                if(isShowWarn){
                	if(FDCMsgBox.showConfirm2(this, "供应商编码改变会覆盖供应商后评估数据，是否继续？")== FDCMsgBox.YES){
                		isUpdate=true;
                    }
                }else{
                	isUpdate=true;
                }
                
                if(isUpdate){
                	this.kdtEntrys.removeRows();
 		
    	   //根据选中的供应商编码获得供应商后评估
    		String entryOql1="select * where supplierNumber.id ='"+Id.toString()+"'";
    		DesignSupplierAppraiseCollection entryColl2 = DesignSupplierAppraiseFactory.getRemoteInstance().getDesignSupplierAppraiseCollection(entryOql1);//获得供应商后评估
    		if(entryColl2.size()>0){
    			
    			//存在后评估，在分录中显示
        		for(int i=0;i<entryColl2.size();i++){
        			DesignSupplierAppraiseInfo info2=DesignSupplierAppraiseFactory.getRemoteInstance().getDesignSupplierAppraiseInfo(new ObjectUuidPK(entryColl2.get(i).getId()));//获得供应商后评估信息
        			IRow  irow = kdtEntrys.addRow();
        			irow.getCell("Review").setValue(info2.getGoal());//评估综合得分
        			irow.getCell("IndexName").setValue(info2.getResults());//评估结果
        		//	irow.getCell("IsQualified").setValue(formatter.format(info2.getAuditDate()));//评估时间 
        			irow.getCell("Casedescription").setValue(info2.getRemake());//备注
        			if(info2.getAuditDate()!=null){
        				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        				irow.getCell("IsQualified").setValue(formatter.format(info2.getAuditDate()));//评估时间 
        			}
        		
        			
        		}
    			
    		} 	
    		for (int i = 0; i < kdtEntrys.getRowCount(); i++) {
           	KDTableHelper.autoFitRowHeight(this.kdtEntrys, i);      
           	}
    
    		
                }
    	}
    	
    }

    
    /*
     * 过滤的方法
     */
    protected void setF7Filter(DesignSupplierStockInfo supplier,DesignAccreditationTypeInfo type,DesignAppraiseTemplateInfo template) throws BOSException, EASBizException{
    	prmtsupplierTemple.setEnabled(false);
    	prmtEvaluationType.setEnabled(false);
    	//根据当前所属事业部过滤升降供应商等级
      	
    	EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		Set org=new HashSet();
		
		Set supplierAppraise=new HashSet();//所有后评估
	   	 try {
	   		
	   		 
				DesignSupplierAppraiseCollection entryColl3 = DesignSupplierAppraiseFactory.getRemoteInstance().getDesignSupplierAppraiseCollection();
			
				if(entryColl3.size()>0){
					for(int i=0;i<entryColl3.size();i++){
						String supplierID=entryColl3.get(i).getSupplierNumber().getId().toString();
						supplierAppraise.add(supplierID);//所有后评估id添加到集合中
					}
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
			
		
		if(this.prmtsupplierNumber.getValue()!=null){
	   BOSUuid Id = ((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue()).getId();
	   OrgUnitInfo cuInfo = SysContext.getSysContext().getCurrentOrgUnit();//获得当前组织单元
		
 	   DesignSupplierStockInfo SuStockinfo=null;
 	  PurchaseOrgUnitInfo beSuStockinfo=null;
	try {
		SuStockinfo = DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(Id));
	} catch (EASBizException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}//当前选中的设计供应商档案
	   String Ids= SuStockinfo.getPurchaseOrgUnit().getId().toString();//当前选中的供应商所在组织单元
	   
	   try {
		 beSuStockinfo = PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(Ids));
	} catch (EASBizException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
		if(SuStockinfo.getName()!=null){
			if(!beSuStockinfo.containsKey("集团")){
				org.add(Ids);
				filter.getFilterItems().add(new FilterItemInfo("purchaseOrgUnit.id",org,CompareType.INCLUDE));//过滤当前组织单元
			}
		
			
		}
	
		
		
		filter.getFilterItems().add(new FilterItemInfo("id",supplierAppraise,CompareType.INCLUDE));
		filter.getFilterItems().add(new FilterItemInfo("state",Integer.valueOf(SupplierStateEnum.APPROVE_VALUE)));
		
	//	filter.getFilterItems().add(new FilterItemInfo("purchaseOrgUnit.name",orgs,CompareType.INCLUDE));
		
		
		view.setFilter(filter);
		this.prmtsupplierNumber.setEntityViewInfo(view);//过滤供应商编号信息
	
		
		view = new EntityViewInfo();
		filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("isEnable",Boolean.TRUE));
		view.setFilter(filter);
		this.prmtEvaluationType.setEntityViewInfo(view);//过滤评审类型
		
		view = new EntityViewInfo();
		filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("isEnabled",Boolean.TRUE));
		
		
		
		if(beSuStockinfo.getName().contains("集团")){
			filter.getFilterItems().add(new FilterItemInfo("number","002",CompareType.NOTINCLUDE ));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("number","003",CompareType.NOTINCLUDE ));
		}
		view.setFilter(filter);
		this.prmtsupplierClas.setEntityViewInfo(view);//过滤评审前等级
		this.prmtsupplierlastClas.setEntityViewInfo(view);//过滤拟升降供应商等级
		
		view = new EntityViewInfo();
		filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("isEnable",Boolean.TRUE));
		if(this.prmtEvaluationType.getValue()!=null){
			filter.getFilterItems().add(new FilterItemInfo("AccreditationType.id",((DesignAccreditationTypeInfo)this.prmtEvaluationType.getValue()).getId()));
		}
		view.setFilter(filter);
		this.prmtsupplierTemple.setEntityViewInfo(view);//过滤评审模板
		if(supplier!=null){
	    	prmtEvaluationType.setEnabled(true);
		}if(supplier!=null&&type!=null){
			prmtsupplierTemple.setEnabled(true);
			prmtEvaluationType.setEnabled(true);
		}
	}else {
		if(getUIContext().get("org")!=null){
			
				PurchaseOrgUnitInfo orgUnitInfo = PurchaseOrgUnitFactory.getRemoteInstance().getPurchaseOrgUnitInfo(new ObjectUuidPK(((OrgStructureInfo) getUIContext().get("org")).getUnit().getId()));

			if(orgUnitInfo.getName()!=null){
				if(!orgUnitInfo.getName().contains("集团")){
					org.add(orgUnitInfo.getId().toString());
					filter.getFilterItems().add(new FilterItemInfo("purchaseOrgUnit.id",org,CompareType.INCLUDE));//过滤当前组织单元
				}
			
				
			}
			

			filter.getFilterItems().add(new FilterItemInfo("id",supplierAppraise,CompareType.INCLUDE));
			filter.getFilterItems().add(new FilterItemInfo("state",Integer.valueOf(SupplierStateEnum.APPROVE_VALUE)));
			
		//	filter.getFilterItems().add(new FilterItemInfo("purchaseOrgUnit.name",orgs,CompareType.INCLUDE));
			
			
			view.setFilter(filter);
			this.prmtsupplierNumber.setEntityViewInfo(view);//过滤供应商编号信息
		
	  
		}

      }
    }
    /*
     * 过滤
     */
     private void initF7() {
     	EntityViewInfo view = new EntityViewInfo();
 		FilterInfo filter = new FilterInfo();
	
		BOSUuid Id = ((DesignSupplierStockInfo)this.prmtsupplierNumber.getValue()).getId();//选中的供应商编码
		DesignSupplierStockInfo info;
		try {
			info = DesignSupplierStockFactory.getRemoteInstance().getDesignSupplierStockInfo(new ObjectUuidPK(Id));
			Set infoName=new HashSet();
			if(info!=null){
				infoName.add(info.getPurchaseOrgUnit().getName());//当前所属组织
				MsgBox.showWarning("当前所属组织"+infoName);
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//通过id获得选中的供应商
	
		
	
		
		

		
	
// 		}
// 		org.add(OrgConstants.DEF_CU_ID);
// 		filter.getFilterItems().add(new FilterItemInfo("state",Integer.valueOf(SupplierStateEnum.APPROVE_VALUE)));
// 		filter.getFilterItems().add(new FilterItemInfo("purchaseOrgUnit.id",org,CompareType.INCLUDE));
//// 		filter.getFilterItems().add(new FilterItemInfo("isPass",Integer.valueOf(ResultsEnum.YL_VALUE),CompareType.EQUALS));
//// 		filter.getFilterItems().add(new FilterItemInfo("isPass",Integer.valueOf(ResultsEnum.HG_VALUE),CompareType.EQUALS));
// 		filter.setMaskString("#0 and #1 and (#2 or #3)");
// 		view.setFilter(filter);
// 		this.prmtsupplierNumber.setEntityViewInfo(view);
    	 
    	 //查询供应商单据中是否存在后评估
    	
//    	 try {
//    		
//    		EntityViewInfo views = new EntityViewInfo();
//    		SelectorItemCollection sic = views.getSelector();
//    		sic.add(new SelectorItemInfo("supplierNumber.id"));	
//    		
//			DesignSupplierAppraiseCollection entryColl3 = DesignSupplierAppraiseFactory.getRemoteInstance().getDesignSupplierAppraiseCollection(views);
//			Set supplierAppraise=new HashSet();//所有后评估
//			
//			if(entryColl3.size()>0){
//				for(int i=0;i<entryColl3.size();i++){
//					String supplierID=entryColl3.get(i).getSupplierNumber().getId().toString();
//					supplierAppraise.add(supplierID);//所有后评估id添加到集合中
//				}
//			}
//			filter.getFilterItems().add(new FilterItemInfo("state",Integer.valueOf(SupplierStateEnum.APPROVE_VALUE)));
//			filter.getFilterItems().add(new FilterItemInfo("id",supplierAppraise,CompareType.INCLUDE));
//			view.setFilter(filter);
//			this.prmtsupplierNumber.setEntityViewInfo(view);//过滤供应商编号信息
//		} catch (BOSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

    	 
 	
 		
     }
    

}