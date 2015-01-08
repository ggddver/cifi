/**
 * output package name
 */
package com.kingdee.eas.custom.funds.client;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDataRequestManager;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper;
import com.kingdee.bos.ctrl.reportone.kdrs.exception.KDRSException;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.basedata.assistant.AbstractPrintIntegrationInfo;
import com.kingdee.eas.basedata.assistant.IPrintIntegration;
import com.kingdee.eas.basedata.assistant.PrintIntegrationFactory;
import com.kingdee.eas.basedata.assistant.util.CommonPrintIntegrationDataProvider;
import com.kingdee.eas.basedata.assistant.util.PrintIntegrationManager;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.funds.BizState;
import com.kingdee.eas.custom.funds.IReceiption;
import com.kingdee.eas.custom.funds.ReceiptionFactory;
import com.kingdee.eas.custom.funds.ReceiptionInfo;
import com.kingdee.eas.fdc.market.client.TableUtils;
import com.kingdee.eas.fdc.sellhouse.ISellProject;
import com.kingdee.eas.fdc.sellhouse.SellProjectCollection;
import com.kingdee.eas.fdc.sellhouse.SellProjectFactory;
import com.kingdee.eas.fdc.sellhouse.SellProjectInfo;
import com.kingdee.eas.ma.budget.client.LongTimeDialog;
import com.kingdee.eas.scm.common.util.MultiDataSourceDataProviderProxy;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class ReceiptionListUI extends AbstractReceiptionListUI
{
    private static final Logger logger = CoreUIObject.getLogger(ReceiptionListUI.class);
    
    /**
     * output class constructor
     */
    public ReceiptionListUI() throws Exception
    {
        super();
    }
    
    @Override
    public void onLoad() throws Exception {
    	super.onLoad();
    	setUITitle("收据");
    	btnAudit.setVisible(true);
    	btnUnAudit.setVisible(true);
    	btnAudit.setIcon(EASResource.getIcon("imgTbtn_auditing"));
    	btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_fauditing"));
    	btnClose.setIcon(EASResource.getIcon("imgTbtn_blankout"));
    	btnUnColse.setIcon(EASResource.getIcon("imgTbtn_fblankout"));
    	toolBar.addComponentAfterComponent(btnAudit, btnRemove);
    	toolBar.addComponentAfterComponent(btnUnAudit, btnAudit);
    	
    	//新增Excel导入按钮
    	KDWorkButton btnImport = new KDWorkButton("导入");
    	btnImport.setIcon(EASResource.getIcon("imgTbtn_input"));
    	btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action_import(e);
			}
    	});
    	toolBar.addComponentAfterComponent(btnImport, btnUnAudit);
    	this.tblMain.getDataRequestManager().setDataRequestMode(KDTDataRequestManager.REAL_MODE);
    	TableUtils.getFootRow(tblMain, new String[]{"entrys.recAmount"});
    }
    public void onShow() throws Exception {
    	super.onShow();
    	IRow footRow = null;
    	TableUtils.getFootRow(tblMain, new String[]{"entrys.recAmount"});
    	 KDTFootManager footRowManager = tblMain.getFootManager();
    	 footRow = footRowManager.getFootRow(0);
    	 footRow.getCell("entrys.recAmount").setValue(TableUtils.getColumnValueSum(tblMain,"entrys.recAmount"));
    }
    //EXCEL导入功能
    private void action_import(ActionEvent e) {
    	OrgUnitInfo info = SysContext.getSysContext().getCurrentOrgUnit();
		ISellProject iSellProject;
		try {
			iSellProject = SellProjectFactory.getRemoteInstance();
			String oql = "where orgUnit.id = '" + info.getId().toString() + "' and level='1'";
			SellProjectCollection sellProjectCollection = iSellProject.getSellProjectCollection(oql);
			SellProjectInfo sellProject = sellProjectCollection.get(0);
			if(sellProject==null){
				MsgBox.showInfo("当前组织不能进行导入，请切换到项目公司组织!");
				SysUtil.abort();
			}
		} catch (BOSException e2) {
			e2.printStackTrace();
		}
		
		
    	final String fileName = EASExcelHelper.showExcelSelectDlg(this);
    	Window win = SwingUtilities.getWindowAncestor(this);
        LongTimeDialog dialog = null;
        if(win instanceof Frame){
        	dialog = new LongTimeDialog((Frame)win);
        }else if(win instanceof Dialog){
        	dialog = new LongTimeDialog((Dialog)win);
        }
        if(dialog==null){
        	dialog = new LongTimeDialog(new Frame());
        }
        dialog.setLongTimeTask(new ILongTimeTask() {
        	String[] str = new String[3];
            public Object exec()throws Exception{
            	int count;
        		try {
        			StringBuffer sb = new StringBuffer();
        			count = EASExcelHelper.importExcelToTable(fileName,sb, 1);
        			if(!"".equals(sb.toString()))
        				MsgBox.showInfo("已经成功导入" + count + "条数据!\n 还有部分数据未导入成功，请查看详细信息！\n"+ sb.toString());
        			else
        				MsgBox.showInfo("恭喜您，全部成功！\n成功导入" + count + "条数据!\n ");
        		} catch (Exception e1) {
        			e1.printStackTrace();
        		}
             	return null;
            }
            public void afterExec(Object result)throws Exception{
            	
            }
        }
        );
        dialog.show();
        try {
			refresh(null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		IRow footRow = null;
		 KDTFootManager footRowManager = tblMain.getFootManager();
    	 footRow = footRowManager.getFootRow(0);
    	 footRow.getCell("entrys.recAmount").setValue(TableUtils.getColumnValueSum(tblMain,"entrys.recAmount"));
    }
    protected String getEditUIModal() {
    	return UIFactoryName.NEWTAB;
    }
    //检查是否能够打印
    private void checkCanPrint(ArrayList idList) {
    	boolean flag = true;
    	try {
			IReceiption iReceiption = ReceiptionFactory.getRemoteInstance();
			SelectorItemCollection sic = new SelectorItemCollection();
			sic.add(new SelectorItemInfo("id"));
			sic.add(new SelectorItemInfo("bizState"));
			for(int i = 0; i < idList.size(); i++) {
				String id = idList.get(i).toString();
				ReceiptionInfo receiptionInfo = iReceiption.getReceiptionInfo(new ObjectUuidPK(id), sic);
				if(!(receiptionInfo.getBizState() == BizState.audited 
						|| receiptionInfo.getBizState() == BizState.close)) {
					flag = false;
					break;
				}
			}
			if(!flag) {
				MsgBox.showWarning("收据未审批，不能打印!");
				SysUtil.abort();
			}
		} catch (BOSException e) {
			e.printStackTrace();
		} catch (EASBizException e) {
			e.printStackTrace();
		}
    }
    //连续打印
    protected void invokeMultiPrintFunction(List idList, boolean isPrint)
    {
		if(idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
			return;
		StringBuffer failToPrintMsg = new StringBuffer();
		KDNoteHelper tpHelper = new KDNoteHelper();
		try
        {
			int curNum = 1;
			String bosType = getBizInterface().getType().toString();
			IPrintIntegration pinfo = PrintIntegrationFactory.getRemoteInstance();
			List infoList = pinfo.getBillsPrintInfoByList(idList, bosType);
			tpHelper.prepareBizCall(getTDFileName());
			boolean isTimesCtrl = tpHelper.isPrintTimesControllable2(getTDFileName());
			if(getTDFileName() != null && getTDFileName().trim().length() > 0 && isTimesCtrl)
            {
				for(int i = 0; i < infoList.size(); i++)
                {
					logger.info("start the print control!");
					int maxNum = tpHelper.getMaxPrintTimes2(getTDFileName());
					int pnum = ((AbstractPrintIntegrationInfo)infoList.get(i)).getPrintedNumber();
					String billID = ((AbstractPrintIntegrationInfo)infoList.get(i)).getPrintBillID();
					logger.info("Max print number:>>" + maxNum);
					logger.info("Alreadey print number:>>" + pnum);
					logger.info("current print number:>>" + curNum);
					if(pnum >= maxNum)
                    {
						idList.remove(billID);
						String billNumber = pinfo.getBillNumberByBosType(bosType, billID);
						String msgInfo = EASResource.getString("com.kingdee.eas.basedata.assistant.PrintIntegrationResource", "pi.controlinfo1");
						Object objs[] = {
								billNumber, String.valueOf(curNum), String.valueOf(pnum), String.valueOf(maxNum)
                        };
					failToPrintMsg.append(MessageFormat.format(msgInfo, objs) + "\n");
					continue;
                    }
					if(curNum + pnum > maxNum)
                    {
						idList.remove(billID);
						String billNumber = pinfo.getBillNumberByBosType(bosType, billID);
						String msgInfo = EASResource.getString("com.kingdee.eas.basedata.assistant.PrintIntegrationResource", "pi.controlinfo2");
						Object objs[] = {
								billNumber, String.valueOf(curNum), String.valueOf(pnum), String.valueOf(maxNum)
                        };
						failToPrintMsg.append(MessageFormat.format(msgInfo, objs) + "\n");
                    }
                }
				if(failToPrintMsg.toString().trim().length() > 0)
                {
					String error = EASResource.getString("com.kingdee.eas.scm.common.SCMResource", "FailToPrintMsg");
					MsgBox.showDetailAndOK(null, error, failToPrintMsg.toString(), 8188);
                }
            }
        }
		catch(KDRSException e)
        {
			handUIException(e);
        }
		catch(BOSException e)
        {
			handUIException(e);
        }
		catch(Exception e)
        {
			handUIException(e);
        }
		if(idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
			return;
		MultiDataSourceDataProviderProxy data = new MultiDataSourceDataProviderProxy();
		QueryTaoDaDataProvider mainQueryData = new QueryTaoDaDataProvider(idList, "com.kingdee.eas.custom.funds.app.PrintReceiptionQuery");
		mainQueryData.setIds(new HashSet(idList));
		data.put("MainQuery", mainQueryData);
		QueryTaoDaDataProvider PrintReceiptionEntryQuery = new QueryTaoDaDataProvider(idList, "com.kingdee.eas.custom.funds.app.PrintReceiptionEntryQuery");
		PrintReceiptionEntryQuery.setIds(new HashSet(idList));
		data.put("PrintReceiptionEntryQuery", PrintReceiptionEntryQuery);
		BOSObjectType bosType = null;
		try
        {
			bosType = getBizInterface().getType();
			logger.info("current bostype:>>" + bosType.toString());
        }
		catch(Exception e)
        {
			MsgBox.showError(EASResource.getString("com.kingdee.eas.basedata.assistant.PrintIntegrationResource", "pi.remoteerror"));
			SysUtil.abort();
        }
		CommonPrintIntegrationDataProvider printQueryData = new CommonPrintIntegrationDataProvider(bosType.toString(), PrintIntegrationManager.getPrintQueryPK());
		data.put("PrintQuery", printQueryData);
		PrintIntegrationManager.initPrint(tpHelper, bosType, idList, getTDFileName(), "com.kingdee.eas.scm.common.SCMResource", false);
		if(isPrint)
			tpHelper.print(getTDFileName(), data, SwingUtilities.getWindowAncestor(this));
		else
			tpHelper.printPreview(getTDFileName(), data, SwingUtilities.getWindowAncestor(this));
		
		
    }
    //连续打印
    protected void invokeMultiPrintFunction(boolean isPrint)
	{
		checkSelected();
		ArrayList idList = getSelectedIdValues();
		invokeMultiPrintFunction(((List) (idList)), isPrint);
	}
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	String id = getSelectedKeyValue();
    	//检查是否在工作流
		com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, id);
		
    	IReceiption iReceiption = ReceiptionFactory.getRemoteInstance();
    	ReceiptionInfo info = iReceiption.getReceiptionInfo(new ObjectUuidPK(id));
    	if(info.getBizState().equals(BizState.audited)||info.getBizState().equals(BizState.close)) {
    		MsgBox.showWarning(info.getBizState().getAlias()+"单据无法修改!");
    		SysUtil.abort();
    	}
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	ArrayList idlist = getSelectedIdValues();
    	IReceiption iReceiption = ReceiptionFactory.getRemoteInstance();
		
    	for(int i = 0; i < idlist.size(); i++) {
    		String id = idlist.get(i).toString();
    		//检查是否在工作流
    		com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, id);
    		ReceiptionInfo info = iReceiption.getReceiptionInfo(new ObjectUuidPK(id));
    		if(info.getBizState().equals(BizState.audited)||info.getBizState().equals(BizState.close)) {
        		MsgBox.showWarning(info.getBizState().getAlias()+"单据无法删除!");
        		SysUtil.abort();
        	}
    	}
        super.actionRemove_actionPerformed(e);
    }

    /**
     * output actionRefresh_actionPerformed
     */
    public void actionRefresh_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRefresh_actionPerformed(e);
    }

    /**
     * output actionPrint_actionPerformed
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
//        super.actionPrint_actionPerformed(e);
    	checkCanPrint(getSelectedIdValues());
    	invokeMultiPrintFunction(true);
    }

    /**
     * output actionPrintPreview_actionPerformed
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
//        super.actionPrintPreview_actionPerformed(e);
    	checkCanPrint(getSelectedIdValues());
    	invokeMultiPrintFunction(false);
    }

    /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	IReceiption iReceiption = ReceiptionFactory.getRemoteInstance();
    	ArrayList idList = getSelectedIdValues();
    	for(int i = 0; i < idList.size(); i++) {
    		//检查是否在工作流
    		com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, idList.get(i).toString());
    		
    		ReceiptionInfo info = iReceiption.getReceiptionInfo(new ObjectUuidPK(idList.get(i).toString()));
	    	if(!info.getBizState().equals(BizState.submited)) {
	    		MsgBox.showWarning("非提交状态单据无法审批!");
	    		SysUtil.abort();
	    	}
	    	iReceiption.audit(info);
    	}
        refresh(null);
    }

    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	IReceiption iReceiption = ReceiptionFactory.getRemoteInstance();
    	ArrayList idList = getSelectedIdValues();
    	for(int i = 0; i < idList.size(); i++) {
    		//检查是否在工作流
    		com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, idList.get(i).toString());
    		
    		ReceiptionInfo info = iReceiption.getReceiptionInfo(new ObjectUuidPK(idList.get(i).toString()));
	    	if(!info.getBizState().equals(BizState.audited)) {
	    		MsgBox.showWarning("非审批状态单据无法反审批!");
	    		SysUtil.abort();
	    	}
	    	iReceiption.unAudit(info);
    	}
        refresh(null);
    }

    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionClose_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	IReceiption iReceiption = ReceiptionFactory.getRemoteInstance();
    	ArrayList idList = getSelectedIdValues();
    	for(int i = 0; i < idList.size(); i++) {
    		//检查是否在工作流
    		com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, idList.get(i).toString());
    		
    		ReceiptionInfo info = iReceiption.getReceiptionInfo(new ObjectUuidPK(idList.get(i).toString()));
	    	if(!info.getBizState().equals(BizState.audited)) {
	    		MsgBox.showWarning("非审批状态单据无需作废!");
	    		SysUtil.abort();
	    	}
	    	iReceiption.close(info);
    	}
        refresh(null);
    }

    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionUnClose_actionPerformed(ActionEvent e) throws Exception
    {
    	checkSelected();
    	IReceiption iReceiption = ReceiptionFactory.getRemoteInstance();
    	ArrayList idList = getSelectedIdValues();
    	for(int i = 0; i < idList.size(); i++) {
    		//检查是否在工作流
    		com.kingdee.eas.fdc.basedata.client.FDCClientUtils.checkBillInWorkflow(this, idList.get(i).toString());
    		
    		ReceiptionInfo info = iReceiption.getReceiptionInfo(new ObjectUuidPK(idList.get(i).toString()));
	    	if(!info.getBizState().equals(BizState.close)) {
	    		MsgBox.showWarning("非作废状态单据无法反作废!");
	    		SysUtil.abort();
	    	}
	    	iReceiption.unclose(info);
    	}
        refresh(null);
    }
    protected FilterInfo getDefaultFilterForQuery() {
		String cuid = SysContext.getSysContext().getCurrentCtrlUnit().getId().toString();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("cu.id",cuid));
		if("00000000-0000-0000-0000-000000000000CCE7AED4".equals(cuid))
			return null;
		else
			return filter; 
	}
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.funds.ReceiptionFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.funds.ReceiptionInfo objectValue = new com.kingdee.eas.custom.funds.ReceiptionInfo();
		
        return objectValue;
    }

}