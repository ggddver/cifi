/**
 * output package name
 */
package com.kingdee.eas.custom.funds.client;

import org.apache.log4j.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.event.*;
import javax.swing.KeyStroke;

import com.kingdee.bos.ctrl.swing.*;
import com.kingdee.bos.ctrl.kdf.table.*;
import com.kingdee.bos.ctrl.kdf.data.event.*;
import com.kingdee.bos.dao.*;
import com.kingdee.bos.dao.query.*;
import com.kingdee.bos.metadata.*;
import com.kingdee.bos.metadata.entity.*;
import com.kingdee.bos.ui.face.*;
import com.kingdee.bos.ui.util.ResourceBundleHelper;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.enums.EnumUtils;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.swing.event.*;
import com.kingdee.bos.ctrl.kdf.table.event.*;
import com.kingdee.bos.ctrl.extendcontrols.*;
import com.kingdee.bos.ctrl.kdf.util.render.*;
import com.kingdee.bos.ui.face.IItemAction;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.bos.ui.util.IUIActionPostman;
import com.kingdee.bos.appframework.client.servicebinding.ActionProxyFactory;
import com.kingdee.bos.appframework.uistatemanage.ActionStateConst;
import com.kingdee.bos.appframework.validator.ValidateHelper;
import com.kingdee.bos.appframework.uip.UINavigator;


/**
 * output class name
 */
public abstract class AbstractFundsApplicationEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFundsApplicationEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpayUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contappCompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbizState;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditOrg;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisGroup;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsingleMaxAmount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpayUnit;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtappCompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox bizState;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtauditOrg;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsingleMaxAmount;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.custom.funds.FundsApplicationInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractFundsApplicationEditUI() throws Exception
    {
        super();
        this.defaultObjectName = "editData";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractFundsApplicationEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionSubmit
        String _tempStr = null;
        actionSubmit.setEnabled(true);
        actionSubmit.setDaemonRun(false);

        actionSubmit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
        _tempStr = resHelper.getString("ActionSubmit.SHORT_DESCRIPTION");
        actionSubmit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.LONG_DESCRIPTION");
        actionSubmit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.NAME");
        actionSubmit.putValue(ItemAction.NAME, _tempStr);
        this.actionSubmit.setBindWorkFlow(true);
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrint
        actionPrint.setEnabled(true);
        actionPrint.setDaemonRun(false);

        actionPrint.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl P"));
        _tempStr = resHelper.getString("ActionPrint.SHORT_DESCRIPTION");
        actionPrint.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.LONG_DESCRIPTION");
        actionPrint.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.NAME");
        actionPrint.putValue(ItemAction.NAME, _tempStr);
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrintPreview
        actionPrintPreview.setEnabled(true);
        actionPrintPreview.setDaemonRun(false);

        actionPrintPreview.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift ctrl P"));
        _tempStr = resHelper.getString("ActionPrintPreview.SHORT_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.LONG_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.NAME");
        actionPrintPreview.putValue(ItemAction.NAME, _tempStr);
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setBindWorkFlow(true);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "false");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setBindWorkFlow(true);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "false");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contpayUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contappCompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbizState = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisGroup = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contsingleMaxAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpayUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtappCompany = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkauditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.bizState = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtauditOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtsingleMaxAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.kdtEntrys.setName("kdtEntrys");
        this.contpayUnit.setName("contpayUnit");
        this.contappCompany.setName("contappCompany");
        this.contauditDate.setName("contauditDate");
        this.contbizState.setName("contbizState");
        this.contauditOrg.setName("contauditOrg");
        this.chkisGroup.setName("chkisGroup");
        this.contsingleMaxAmount.setName("contsingleMaxAmount");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtpayUnit.setName("prmtpayUnit");
        this.txtappCompany.setName("txtappCompany");
        this.pkauditDate.setName("pkauditDate");
        this.bizState.setName("bizState");
        this.prmtauditOrg.setName("prmtauditOrg");
        this.txtsingleMaxAmount.setName("txtsingleMaxAmount");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        // CoreUI		
        this.btnAddLine.setVisible(false);		
        this.btnCopyLine.setVisible(false);		
        this.btnInsertLine.setVisible(false);		
        this.btnRemoveLine.setVisible(false);		
        this.btnTraceUp.setVisible(false);		
        this.btnTraceDown.setVisible(false);		
        this.btnAuditResult.setVisible(false);		
        this.separator1.setVisible(false);		
        this.separator3.setVisible(false);		
        this.menuItemTraceUp.setVisible(false);		
        this.menuItemTraceDown.setVisible(false);		
        this.menuItemViewSubmitProccess.setVisible(false);		
        this.menuItemViewDoProccess.setVisible(false);		
        this.menuItemAuditResult.setVisible(false);		
        this.menuTable1.setVisible(false);		
        this.menuItemAddLine.setVisible(false);		
        this.menuItemInsertLine.setVisible(false);		
        this.menuItemRemoveLine.setVisible(false);		
        this.btnCreateTo.setVisible(true);		
        this.menuItemCreateTo.setVisible(true);		
        this.menuItemCopyLine.setVisible(false);
        // contCreator		
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);
        // contCreateTime		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);
        // contLastUpdateUser		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(false);
        // contLastUpdateTime		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(false);
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"entryPayUnit\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"payAccount\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"payBank\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"payAccProperty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"recUnit\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"recAccount\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"recAccountText\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"recBank\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"recAccProperty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"upperAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"recDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"usage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"attachAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{entryPayUnit}</t:Cell><t:Cell>$Resource{payAccount}</t:Cell><t:Cell>$Resource{payBank}</t:Cell><t:Cell>$Resource{payAccProperty}</t:Cell><t:Cell>$Resource{recUnit}</t:Cell><t:Cell>$Resource{recAccount}</t:Cell><t:Cell>$Resource{recAccountText}</t:Cell><t:Cell>$Resource{recBank}</t:Cell><t:Cell>$Resource{recAccProperty}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{upperAmount}</t:Cell><t:Cell>$Resource{recDate}</t:Cell><t:Cell>$Resource{usage}</t:Cell><t:Cell>$Resource{attachAmount}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));
        kdtEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        this.kdtEntrys.addKDTMouseListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener() {
            public void tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) {
                try {
                    kdtEntrys_tableClicked(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        this.kdtEntrys.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtEntrys.putBindContents("editData",new String[] {"id","entryPayUnit","payAccount","payBank","payAccProperty","recUnit","recAccount","recAccountText","recBank","recAccProperty","amount","upperAmount","recDate","usage","attachAmount"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_entryPayUnit_PromptBox = new KDBizPromptBox();
        kdtEntrys_entryPayUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");
        kdtEntrys_entryPayUnit_PromptBox.setVisible(true);
        kdtEntrys_entryPayUnit_PromptBox.setEditable(true);
        kdtEntrys_entryPayUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_entryPayUnit_PromptBox.setEditFormat("$number$");
        kdtEntrys_entryPayUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_entryPayUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_entryPayUnit_PromptBox);
        this.kdtEntrys.getColumn("entryPayUnit").setEditor(kdtEntrys_entryPayUnit_CellEditor);
        ObjectValueRender kdtEntrys_entryPayUnit_OVR = new ObjectValueRender();
        kdtEntrys_entryPayUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("entryPayUnit").setRenderer(kdtEntrys_entryPayUnit_OVR);
        final KDBizPromptBox kdtEntrys_payAccount_PromptBox = new KDBizPromptBox();
        kdtEntrys_payAccount_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery");
        kdtEntrys_payAccount_PromptBox.setVisible(true);
        kdtEntrys_payAccount_PromptBox.setEditable(true);
        kdtEntrys_payAccount_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_payAccount_PromptBox.setEditFormat("$number$");
        kdtEntrys_payAccount_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_payAccount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_payAccount_PromptBox);
        this.kdtEntrys.getColumn("payAccount").setEditor(kdtEntrys_payAccount_CellEditor);
        ObjectValueRender kdtEntrys_payAccount_OVR = new ObjectValueRender();
        kdtEntrys_payAccount_OVR.setFormat(new BizDataFormat("$bankAccountNumber$"));
        this.kdtEntrys.getColumn("payAccount").setRenderer(kdtEntrys_payAccount_OVR);
        KDTextField kdtEntrys_payBank_TextField = new KDTextField();
        kdtEntrys_payBank_TextField.setName("kdtEntrys_payBank_TextField");
        kdtEntrys_payBank_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_payBank_CellEditor = new KDTDefaultCellEditor(kdtEntrys_payBank_TextField);
        this.kdtEntrys.getColumn("payBank").setEditor(kdtEntrys_payBank_CellEditor);
        KDTextField kdtEntrys_payAccProperty_TextField = new KDTextField();
        kdtEntrys_payAccProperty_TextField.setName("kdtEntrys_payAccProperty_TextField");
        kdtEntrys_payAccProperty_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_payAccProperty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_payAccProperty_TextField);
        this.kdtEntrys.getColumn("payAccProperty").setEditor(kdtEntrys_payAccProperty_CellEditor);
        final KDBizPromptBox kdtEntrys_recUnit_PromptBox = new KDBizPromptBox();
        kdtEntrys_recUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");
        kdtEntrys_recUnit_PromptBox.setVisible(true);
        kdtEntrys_recUnit_PromptBox.setEditable(true);
        kdtEntrys_recUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_recUnit_PromptBox.setEditFormat("$number$");
        kdtEntrys_recUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_recUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_recUnit_PromptBox);
        this.kdtEntrys.getColumn("recUnit").setEditor(kdtEntrys_recUnit_CellEditor);
        ObjectValueRender kdtEntrys_recUnit_OVR = new ObjectValueRender();
        kdtEntrys_recUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("recUnit").setRenderer(kdtEntrys_recUnit_OVR);
        final KDBizPromptBox kdtEntrys_recAccount_PromptBox = new KDBizPromptBox();
        kdtEntrys_recAccount_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7AccountBankQuery");
        kdtEntrys_recAccount_PromptBox.setVisible(true);
        kdtEntrys_recAccount_PromptBox.setEditable(true);
        kdtEntrys_recAccount_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_recAccount_PromptBox.setEditFormat("$number$");
        kdtEntrys_recAccount_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_recAccount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_recAccount_PromptBox);
        this.kdtEntrys.getColumn("recAccount").setEditor(kdtEntrys_recAccount_CellEditor);
        ObjectValueRender kdtEntrys_recAccount_OVR = new ObjectValueRender();
        kdtEntrys_recAccount_OVR.setFormat(new BizDataFormat("$bankAccountNumber$"));
        this.kdtEntrys.getColumn("recAccount").setRenderer(kdtEntrys_recAccount_OVR);
        KDTextField kdtEntrys_recAccountText_TextField = new KDTextField();
        kdtEntrys_recAccountText_TextField.setName("kdtEntrys_recAccountText_TextField");
        kdtEntrys_recAccountText_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_recAccountText_CellEditor = new KDTDefaultCellEditor(kdtEntrys_recAccountText_TextField);
        this.kdtEntrys.getColumn("recAccountText").setEditor(kdtEntrys_recAccountText_CellEditor);
        KDTextField kdtEntrys_recBank_TextField = new KDTextField();
        kdtEntrys_recBank_TextField.setName("kdtEntrys_recBank_TextField");
        kdtEntrys_recBank_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_recBank_CellEditor = new KDTDefaultCellEditor(kdtEntrys_recBank_TextField);
        this.kdtEntrys.getColumn("recBank").setEditor(kdtEntrys_recBank_CellEditor);
        KDTextField kdtEntrys_recAccProperty_TextField = new KDTextField();
        kdtEntrys_recAccProperty_TextField.setName("kdtEntrys_recAccProperty_TextField");
        kdtEntrys_recAccProperty_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_recAccProperty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_recAccProperty_TextField);
        this.kdtEntrys.getColumn("recAccProperty").setEditor(kdtEntrys_recAccProperty_CellEditor);
        KDFormattedTextField kdtEntrys_amount_TextField = new KDFormattedTextField();
        kdtEntrys_amount_TextField.setName("kdtEntrys_amount_TextField");
        kdtEntrys_amount_TextField.setVisible(true);
        kdtEntrys_amount_TextField.setEditable(true);
        kdtEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtEntrys_amount_TextField.setDataType(1);
        	kdtEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_amount_TextField);
        this.kdtEntrys.getColumn("amount").setEditor(kdtEntrys_amount_CellEditor);
        KDTextField kdtEntrys_upperAmount_TextField = new KDTextField();
        kdtEntrys_upperAmount_TextField.setName("kdtEntrys_upperAmount_TextField");
        kdtEntrys_upperAmount_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_upperAmount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_upperAmount_TextField);
        this.kdtEntrys.getColumn("upperAmount").setEditor(kdtEntrys_upperAmount_CellEditor);
        KDDatePicker kdtEntrys_recDate_DatePicker = new KDDatePicker();
        kdtEntrys_recDate_DatePicker.setName("kdtEntrys_recDate_DatePicker");
        kdtEntrys_recDate_DatePicker.setVisible(true);
        kdtEntrys_recDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_recDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_recDate_DatePicker);
        this.kdtEntrys.getColumn("recDate").setEditor(kdtEntrys_recDate_CellEditor);
        KDTextField kdtEntrys_usage_TextField = new KDTextField();
        kdtEntrys_usage_TextField.setName("kdtEntrys_usage_TextField");
        kdtEntrys_usage_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtEntrys_usage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_usage_TextField);
        this.kdtEntrys.getColumn("usage").setEditor(kdtEntrys_usage_CellEditor);
        KDFormattedTextField kdtEntrys_attachAmount_TextField = new KDFormattedTextField();
        kdtEntrys_attachAmount_TextField.setName("kdtEntrys_attachAmount_TextField");
        kdtEntrys_attachAmount_TextField.setVisible(true);
        kdtEntrys_attachAmount_TextField.setEditable(true);
        kdtEntrys_attachAmount_TextField.setHorizontalAlignment(2);
        kdtEntrys_attachAmount_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_attachAmount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_attachAmount_TextField);
        this.kdtEntrys.getColumn("attachAmount").setEditor(kdtEntrys_attachAmount_CellEditor);
        // contpayUnit		
        this.contpayUnit.setBoundLabelText(resHelper.getString("contpayUnit.boundLabelText"));		
        this.contpayUnit.setBoundLabelLength(100);		
        this.contpayUnit.setBoundLabelUnderline(true);		
        this.contpayUnit.setVisible(true);
        // contappCompany		
        this.contappCompany.setBoundLabelText(resHelper.getString("contappCompany.boundLabelText"));		
        this.contappCompany.setBoundLabelLength(100);		
        this.contappCompany.setBoundLabelUnderline(true);		
        this.contappCompany.setVisible(true);
        // contauditDate		
        this.contauditDate.setBoundLabelText(resHelper.getString("contauditDate.boundLabelText"));		
        this.contauditDate.setBoundLabelLength(100);		
        this.contauditDate.setBoundLabelUnderline(true);		
        this.contauditDate.setVisible(true);
        // contbizState		
        this.contbizState.setBoundLabelText(resHelper.getString("contbizState.boundLabelText"));		
        this.contbizState.setBoundLabelLength(100);		
        this.contbizState.setBoundLabelUnderline(true);		
        this.contbizState.setVisible(true);
        // contauditOrg		
        this.contauditOrg.setBoundLabelText(resHelper.getString("contauditOrg.boundLabelText"));		
        this.contauditOrg.setBoundLabelLength(100);		
        this.contauditOrg.setBoundLabelUnderline(true);		
        this.contauditOrg.setVisible(true);
        // chkisGroup		
        this.chkisGroup.setText(resHelper.getString("chkisGroup.text"));		
        this.chkisGroup.setHorizontalAlignment(2);
        // contsingleMaxAmount		
        this.contsingleMaxAmount.setBoundLabelText(resHelper.getString("contsingleMaxAmount.boundLabelText"));		
        this.contsingleMaxAmount.setBoundLabelLength(100);		
        this.contsingleMaxAmount.setBoundLabelUnderline(true);		
        this.contsingleMaxAmount.setVisible(true);
        // prmtCreator		
        this.prmtCreator.setEnabled(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // pkBizDate		
        this.pkBizDate.setEnabled(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtpayUnit		
        this.prmtpayUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtpayUnit.setEditable(true);		
        this.prmtpayUnit.setDisplayFormat("$name$");		
        this.prmtpayUnit.setEditFormat("$number$");		
        this.prmtpayUnit.setCommitFormat("$number$");		
        this.prmtpayUnit.setRequired(false);
        prmtpayUnit.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtpayUnit_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtappCompany		
        this.txtappCompany.setHorizontalAlignment(2);		
        this.txtappCompany.setMaxLength(80);		
        this.txtappCompany.setRequired(false);
        // pkauditDate		
        this.pkauditDate.setRequired(false);
        // bizState		
        this.bizState.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.funds.BizState").toArray());		
        this.bizState.setRequired(false);
        // prmtauditOrg		
        this.prmtauditOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtauditOrg.setEditable(true);		
        this.prmtauditOrg.setDisplayFormat("$name$");		
        this.prmtauditOrg.setEditFormat("$number$");		
        this.prmtauditOrg.setCommitFormat("$number$");		
        this.prmtauditOrg.setRequired(false);
        // txtsingleMaxAmount		
        this.txtsingleMaxAmount.setHorizontalAlignment(2);		
        this.txtsingleMaxAmount.setDataType(1);		
        this.txtsingleMaxAmount.setSupportedEmpty(true);		
        this.txtsingleMaxAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsingleMaxAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsingleMaxAmount.setPrecision(2);		
        this.txtsingleMaxAmount.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtpayUnit,txtappCompany,pkauditDate,bizState,prmtauditOrg,chkisGroup,txtsingleMaxAmount,txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,kdtEntrys}));
        this.setFocusCycleRoot(true);
		//Register control's property binding
		registerBindings();
		registerUIState();


    }

	public com.kingdee.bos.ctrl.swing.KDToolBar[] getUIMultiToolBar(){
		java.util.List list = new java.util.ArrayList();
		com.kingdee.bos.ctrl.swing.KDToolBar[] bars = super.getUIMultiToolBar();
		if (bars != null) {
			list.addAll(java.util.Arrays.asList(bars));
		}
		return (com.kingdee.bos.ctrl.swing.KDToolBar[])list.toArray(new com.kingdee.bos.ctrl.swing.KDToolBar[list.size()]);
	}




    /**
     * output initUIContentLayout method
     */
    public void initUIContentLayout()
    {
        this.setBounds(new Rectangle(0, 0, 1013, 450));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 450));
        contCreator.setBounds(new Rectangle(431, 561, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(431, 561, 270, 19, 0));
        contCreateTime.setBounds(new Rectangle(716, 560, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(716, 560, 270, 19, 0));
        contLastUpdateUser.setBounds(new Rectangle(434, 583, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(434, 583, 270, 19, 0));
        contLastUpdateTime.setBounds(new Rectangle(715, 583, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(715, 583, 270, 19, 0));
        contNumber.setBounds(new Rectangle(715, 520, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(715, 520, 270, 19, 0));
        contBizDate.setBounds(new Rectangle(430, 540, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(430, 540, 270, 19, 0));
        contDescription.setBounds(new Rectangle(722, 539, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(722, 539, 270, 19, 0));
        contAuditor.setBounds(new Rectangle(16, 405, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(16, 405, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(16, 46, 974, 339));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.funds.FundsApplicationEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(16, 46, 974, 339, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contpayUnit.setBounds(new Rectangle(716, 16, 270, 19));
        this.add(contpayUnit, new KDLayout.Constraints(716, 16, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contappCompany.setBounds(new Rectangle(16, 13, 270, 19));
        this.add(contappCompany, new KDLayout.Constraints(16, 13, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditDate.setBounds(new Rectangle(720, 405, 270, 19));
        this.add(contauditDate, new KDLayout.Constraints(720, 405, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbizState.setBounds(new Rectangle(637, 7, 270, 19));
        this.add(contbizState, new KDLayout.Constraints(637, 7, 270, 19, 0));
        contauditOrg.setBounds(new Rectangle(368, 405, 270, 19));
        this.add(contauditOrg, new KDLayout.Constraints(368, 405, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisGroup.setBounds(new Rectangle(305, 13, 117, 19));
        this.add(chkisGroup, new KDLayout.Constraints(305, 13, 117, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsingleMaxAmount.setBounds(new Rectangle(429, 19, 270, 19));
        this.add(contsingleMaxAmount, new KDLayout.Constraints(429, 19, 270, 19, 0));
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(kDDateCreateTime);
        //contLastUpdateUser
        contLastUpdateUser.setBoundEditor(prmtLastUpdateUser);
        //contLastUpdateTime
        contLastUpdateTime.setBoundEditor(kDDateLastUpdateTime);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contpayUnit
        contpayUnit.setBoundEditor(prmtpayUnit);
        //contappCompany
        contappCompany.setBoundEditor(txtappCompany);
        //contauditDate
        contauditDate.setBoundEditor(pkauditDate);
        //contbizState
        contbizState.setBoundEditor(bizState);
        //contauditOrg
        contauditOrg.setBoundEditor(prmtauditOrg);
        //contsingleMaxAmount
        contsingleMaxAmount.setBoundEditor(txtsingleMaxAmount);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {
        this.menuBar.add(menuFile);
        this.menuBar.add(menuEdit);
        this.menuBar.add(MenuService);
        this.menuBar.add(menuView);
        this.menuBar.add(menuBiz);
        this.menuBar.add(menuTable1);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuWorkflow);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemSubmit);
        menuFile.add(menuSubmitOption);
        menuFile.add(rMenuItemSubmit);
        menuFile.add(rMenuItemSubmitAndAddNew);
        menuFile.add(rMenuItemSubmitAndPrint);
        menuFile.add(separatorFile1);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator6);
        menuFile.add(menuItemSendMail);
        menuFile.add(kDSeparator3);
        menuFile.add(menuItemExitCurrent);
        //menuSubmitOption
        menuSubmitOption.add(chkMenuItemSubmitAndAddNew);
        menuSubmitOption.add(chkMenuItemSubmitAndPrint);
        //menuEdit
        menuEdit.add(menuItemCopy);
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(kDSeparator4);
        menuEdit.add(menuItemReset);
        menuEdit.add(separator1);
        menuEdit.add(menuItemCreateFrom);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemCopyFrom);
        menuEdit.add(separatorEdit1);
        menuEdit.add(menuItemEnterToNextRow);
        menuEdit.add(separator2);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemFirst);
        menuView.add(menuItemPre);
        menuView.add(menuItemNext);
        menuView.add(menuItemLast);
        menuView.add(separator3);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemTraceDown);
        menuView.add(kDSeparator7);
        menuView.add(menuItemLocate);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        //menuTable1
        menuTable1.add(menuItemAddLine);
        menuTable1.add(menuItemCopyLine);
        menuTable1.add(menuItemInsertLine);
        menuTable1.add(menuItemRemoveLine);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemCalculator);
        //menuWorkflow
        menuWorkflow.add(menuItemStartWorkFlow);
        menuWorkflow.add(separatorWF1);
        menuWorkflow.add(menuItemViewSubmitProccess);
        menuWorkflow.add(menuItemViewDoProccess);
        menuWorkflow.add(MenuItemWFG);
        menuWorkflow.add(menuItemWorkFlowList);
        menuWorkflow.add(separatorWF2);
        menuWorkflow.add(menuItemMultiapprove);
        menuWorkflow.add(menuItemNextPerson);
        menuWorkflow.add(menuItemAuditResult);
        menuWorkflow.add(kDSeparator5);
        menuWorkflow.add(kDMenuItemSendMessage);
        //menuHelp
        menuHelp.add(menuItemHelp);
        menuHelp.add(kDSeparator12);
        menuHelp.add(menuItemRegPro);
        menuHelp.add(menuItemPersonalSite);
        menuHelp.add(helpseparatorDiv);
        menuHelp.add(menuitemProductval);
        menuHelp.add(kDSeparatorProduct);
        menuHelp.add(menuItemAbout);

    }

    /**
     * output initUIToolBarLayout method
     */
    public void initUIToolBarLayout()
    {
        this.toolBar.add(btnAddNew);
        this.toolBar.add(btnEdit);
        this.toolBar.add(btnSave);
        this.toolBar.add(btnReset);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnFirst);
        this.toolBar.add(btnPre);
        this.toolBar.add(btnNext);
        this.toolBar.add(btnLast);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnCopyLine);
        this.toolBar.add(btnInsertLine);
        this.toolBar.add(btnRemoveLine);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.funds.FundsApplicationEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.payAccount", java.lang.Object.class, this.kdtEntrys, "payAccount.text");
		dataBinder.registerBinding("entrys.recUnit", java.lang.Object.class, this.kdtEntrys, "recUnit.text");
		dataBinder.registerBinding("entrys.recAccount", java.lang.Object.class, this.kdtEntrys, "recAccount.text");
		dataBinder.registerBinding("entrys.amount", java.math.BigDecimal.class, this.kdtEntrys, "amount.text");
		dataBinder.registerBinding("entrys.upperAmount", String.class, this.kdtEntrys, "upperAmount.text");
		dataBinder.registerBinding("entrys.recDate", java.util.Date.class, this.kdtEntrys, "recDate.text");
		dataBinder.registerBinding("entrys.usage", String.class, this.kdtEntrys, "usage.text");
		dataBinder.registerBinding("entrys.attachAmount", int.class, this.kdtEntrys, "attachAmount.text");
		dataBinder.registerBinding("entrys.payAccProperty", String.class, this.kdtEntrys, "payAccProperty.text");
		dataBinder.registerBinding("entrys.recAccProperty", String.class, this.kdtEntrys, "recAccProperty.text");
		dataBinder.registerBinding("entrys.payBank", String.class, this.kdtEntrys, "payBank.text");
		dataBinder.registerBinding("entrys.recBank", String.class, this.kdtEntrys, "recBank.text");
		dataBinder.registerBinding("entrys.entryPayUnit", java.lang.Object.class, this.kdtEntrys, "entryPayUnit.text");
		dataBinder.registerBinding("entrys.recAccountText", String.class, this.kdtEntrys, "recAccountText.text");
		dataBinder.registerBinding("isGroup", boolean.class, this.chkisGroup, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("payUnit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtpayUnit, "data");
		dataBinder.registerBinding("appCompany", String.class, this.txtappCompany, "text");
		dataBinder.registerBinding("auditDate", java.util.Date.class, this.pkauditDate, "value");
		dataBinder.registerBinding("bizState", com.kingdee.eas.custom.funds.BizState.class, this.bizState, "selectedItem");
		dataBinder.registerBinding("auditOrg", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtauditOrg, "data");
		dataBinder.registerBinding("singleMaxAmount", java.math.BigDecimal.class, this.txtsingleMaxAmount, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.funds.app.FundsApplicationEditUIHandler";
	}
	public IUIActionPostman prepareInit() {
		IUIActionPostman clientHanlder = super.prepareInit();
		if (clientHanlder != null) {
			RequestContext request = new RequestContext();
    		request.setClassName(getUIHandlerClassName());
			clientHanlder.setRequestContext(request);
		}
		return clientHanlder;
    }
	
	public boolean isPrepareInit() {
    	return false;
    }
    protected void initUIP() {
        super.initUIP();
    }


    /**
     * output onShow method
     */
    public void onShow() throws Exception
    {
        super.onShow();
        this.prmtpayUnit.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.funds.FundsApplicationInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"NONE",editData.getString("number"));
    }
    
    protected void recycleNumberByOrg(IObjectValue editData,String orgType,String number) {
        if (!StringUtils.isEmpty(number))
        {
            try {
            	String companyID = null;            
            	com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID =com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}				
				if (!StringUtils.isEmpty(companyID) && iCodingRuleManager.isExist(editData, companyID) && iCodingRuleManager.isUseIntermitNumber(editData, companyID)) {
					iCodingRuleManager.recycleNumber(editData,companyID,number);					
				}
            }
            catch (Exception e)
            {
                handUIException(e);
            }
        }
    }
    protected void setAutoNumberByOrg(String orgType) {
    	if (editData == null) return;
		if (editData.getNumber() == null) {
            try {
            	String companyID = null;
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}
				com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
		        if (iCodingRuleManager.isExist(editData, companyID)) {
		            if (iCodingRuleManager.isAddView(editData, companyID)) {
		            	editData.setNumber(iCodingRuleManager.getNumber(editData,companyID));
		            }
	                txtNumber.setEnabled(false);
		        }
            }
            catch (Exception e) {
                handUIException(e);
                this.oldData = editData;
                com.kingdee.eas.util.SysUtil.abort();
            } 
        } 
        else {
            if (editData.getNumber().trim().length() > 0) {
                txtNumber.setText(editData.getNumber());
            }
        }
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("NONE");
        dataBinder.loadFields();
    }
		protected void setOrgF7(KDBizPromptBox f7,com.kingdee.eas.basedata.org.OrgType orgType) throws Exception
		{
			com.kingdee.bos.ctrl.extendcontrols.ext.OrgUnitFilterInfoProducer oufip=(com.kingdee.bos.ctrl.extendcontrols.ext.OrgUnitFilterInfoProducer)com.kingdee.bos.ctrl.extendcontrols.ext.FilterInfoProducerFactory.getOrgUnitFilterInfoProducer(orgType);
			oufip.getModel().setIsCUFilter(true);
			f7.setFilterInfoProducer(oufip);
		}

    /**
     * output storeFields method
     */
    public void storeFields()
    {
		dataBinder.storeFields();
    }

	/**
	 * ????????§µ??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.payAccount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.recUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.recAccount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.upperAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.recDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.usage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.attachAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.payAccProperty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.recAccProperty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.payBank", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.recBank", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.entryPayUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.recAccountText", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("payUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("appCompany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizState", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("singleMaxAmount", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
        } else if (STATUS_EDIT.equals(this.oprtState)) {
        } else if (STATUS_VIEW.equals(this.oprtState)) {
        } else if (STATUS_FINDVIEW.equals(this.oprtState)) {
        }
    }

    /**
     * output kdtEntrys_editStopped method
     */
    protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output kdtEntrys_tableClicked method
     */
    protected void kdtEntrys_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
    }


    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("payAccount".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"payAccProperty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"payAccount").getValue(),"description")));

}

    if ("payAccount".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"payBank").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"payAccount").getValue(),"bank.name")));

}

    if ("recAccount".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"recAccProperty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"recAccount").getValue(),"description")));

}

    if ("recAccount".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"recBank").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"recAccount").getValue(),"bank.name")));

}


    }

    /**
     * output prmtpayUnit_Changed() method
     */
    public void prmtpayUnit_Changed() throws Exception
    {
        System.out.println("prmtpayUnit_Changed() Function is executed!");
            txtappCompany.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtpayUnit.getData(),"name")));


    }
    /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
    sic.add(new SelectorItemInfo("entrys.id"));
        sic.add(new SelectorItemInfo("entrys.*"));
//        sic.add(new SelectorItemInfo("entrys.number"));
        sic.add(new SelectorItemInfo("entrys.payAccount.*"));
//        sic.add(new SelectorItemInfo("entrys.payAccount.number"));
        sic.add(new SelectorItemInfo("entrys.recUnit.*"));
//        sic.add(new SelectorItemInfo("entrys.recUnit.number"));
        sic.add(new SelectorItemInfo("entrys.recAccount.*"));
//        sic.add(new SelectorItemInfo("entrys.recAccount.number"));
    sic.add(new SelectorItemInfo("entrys.amount"));
    sic.add(new SelectorItemInfo("entrys.upperAmount"));
    sic.add(new SelectorItemInfo("entrys.recDate"));
    sic.add(new SelectorItemInfo("entrys.usage"));
    sic.add(new SelectorItemInfo("entrys.attachAmount"));
    sic.add(new SelectorItemInfo("entrys.payAccProperty"));
    sic.add(new SelectorItemInfo("entrys.recAccProperty"));
    sic.add(new SelectorItemInfo("entrys.payBank"));
    sic.add(new SelectorItemInfo("entrys.recBank"));
        sic.add(new SelectorItemInfo("entrys.entryPayUnit.*"));
//        sic.add(new SelectorItemInfo("entrys.entryPayUnit.number"));
    sic.add(new SelectorItemInfo("entrys.recAccountText"));
        sic.add(new SelectorItemInfo("isGroup"));
        sic.add(new SelectorItemInfo("creator.*"));
        sic.add(new SelectorItemInfo("createTime"));
        sic.add(new SelectorItemInfo("lastUpdateUser.*"));
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("auditor.*"));
        sic.add(new SelectorItemInfo("payUnit.*"));
        sic.add(new SelectorItemInfo("appCompany"));
        sic.add(new SelectorItemInfo("auditDate"));
        sic.add(new SelectorItemInfo("bizState"));
        sic.add(new SelectorItemInfo("auditOrg.*"));
        sic.add(new SelectorItemInfo("singleMaxAmount"));
        return sic;
    }        
    	

    /**
     * output actionSubmit_actionPerformed method
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }
    	

    /**
     * output actionPrint_actionPerformed method
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
    	if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionPrintPreview_actionPerformed method
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
        if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.funds.FundsApplicationFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.funds.FundsApplicationFactory.getRemoteInstance().unAudit(editData);
    }
	public RequestContext prepareActionSubmit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionSubmit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSubmit() {
    	return false;
    }
	public RequestContext prepareActionPrint(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrint(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrint() {
    	return false;
    }
	public RequestContext prepareActionPrintPreview(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrintPreview(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrintPreview() {
    	return false;
    }
	public RequestContext prepareActionAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAudit() {
    	return false;
    }
	public RequestContext prepareActionUnAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnAudit() {
    	return false;
    }

    /**
     * output ActionAudit class
     */     
    protected class ActionAudit extends ItemAction {     
    
        public ActionAudit()
        {
            this(null);
        }

        public ActionAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFundsApplicationEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionUnAudit class
     */     
    protected class ActionUnAudit extends ItemAction {     
    
        public ActionUnAudit()
        {
            this(null);
        }

        public ActionUnAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUnAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFundsApplicationEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.funds.client", "FundsApplicationEditUI");
    }
    /**
     * output isBindWorkFlow method
     */
    public boolean isBindWorkFlow()
    {
        return true;
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.funds.client.FundsApplicationEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.funds.FundsApplicationFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.funds.FundsApplicationInfo objectValue = new com.kingdee.eas.custom.funds.FundsApplicationInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/funds/FundsApplication";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.funds.app.FundsApplicationQuery");
	}
    

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntrys;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("bizState","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}