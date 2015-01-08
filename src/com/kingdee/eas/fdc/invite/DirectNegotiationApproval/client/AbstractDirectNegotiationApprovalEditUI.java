/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.DirectNegotiationApproval.client;

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
public abstract class AbstractDirectNegotiationApprovalEditUI extends com.kingdee.eas.fdc.invite.client.BaseInviteEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDirectNegotiationApprovalEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSpecial;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contScope;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contRange;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer1;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane kDScrollPane1;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtSpecial;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane kDScrollPane5;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtScope;
    protected com.kingdee.bos.ctrl.swing.KDComboBox combRange;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane changInviteTypeApplication;
    protected com.kingdee.eas.fdc.invite.DirectNegotiationApproval.DirectNegotiationApprovalInfo editData = null;
    protected ShowProjects showProjects = null;
    /**
     * output class constructor
     */
    public AbstractDirectNegotiationApprovalEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDirectNegotiationApprovalEditUI.class.getName());
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
        this.actionSubmit.setExtendProperty("canForewarn", "true");
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionAudit
        actionAudit.setEnabled(true);
        actionAudit.setDaemonRun(false);

        _tempStr = resHelper.getString("ActionAudit.SHORT_DESCRIPTION");
        actionAudit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAudit.LONG_DESCRIPTION");
        actionAudit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAudit.NAME");
        actionAudit.putValue(ItemAction.NAME, _tempStr);
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionUnAudit
        actionUnAudit.setEnabled(true);
        actionUnAudit.setDaemonRun(false);

        _tempStr = resHelper.getString("ActionUnAudit.SHORT_DESCRIPTION");
        actionUnAudit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionUnAudit.LONG_DESCRIPTION");
        actionUnAudit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionUnAudit.NAME");
        actionUnAudit.putValue(ItemAction.NAME, _tempStr);
        this.actionUnAudit.setBindWorkFlow(true);
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //showProjects
        this.showProjects = new ShowProjects(this);
        getActionManager().registerAction("showProjects", showProjects);
         this.showProjects.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.contSpecial = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contScope = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contRange = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDContainer1 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.kDScrollPane1 = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtSpecial = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.kDScrollPane5 = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtScope = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.combRange = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.changInviteTypeApplication = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.contSpecial.setName("contSpecial");
        this.contScope.setName("contScope");
        this.contRange.setName("contRange");
        this.kDContainer1.setName("kDContainer1");
        this.kDScrollPane1.setName("kDScrollPane1");
        this.txtSpecial.setName("txtSpecial");
        this.kDScrollPane5.setName("kDScrollPane5");
        this.txtScope.setName("txtScope");
        this.combRange.setName("combRange");
        this.changInviteTypeApplication.setName("changInviteTypeApplication");
        // CoreUI		
        this.setMinimumSize(new Dimension(1000,600));		
        this.setPreferredSize(new Dimension(1000,600));		
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contAuditor.setEnabled(false);		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contAuditTime.setBoundLabelText(resHelper.getString("contAuditTime.boundLabelText"));		
        this.contAuditTime.setBoundLabelLength(100);		
        this.contAuditTime.setBoundLabelUnderline(true);		
        this.contAuditTime.setEnabled(false);		
        this.contRespDept.setBoundLabelText(resHelper.getString("contRespDept.boundLabelText"));		
        this.contRespDept.setBoundLabelLength(100);		
        this.contRespDept.setBoundLabelUnderline(true);		
        this.contEntry.setTitle(resHelper.getString("contEntry.title"));		
        this.prmtCreator.setEnabled(false);		
        this.prmtCreator.setCommitFormat("$name$");		
        this.prmtCreator.setDisplayFormat("$name$");		
        this.prmtCreator.setEditFormat("$name$");		
        this.pkCreateTime.setEnabled(false);		
        this.prmtAuditor.setEnabled(false);		
        this.prmtAuditor.setDisplayFormat("$name$");		
        this.prmtAuditor.setEditFormat("$name$");		
        this.prmtAuditor.setCommitFormat("$name$");		
        this.txtNumber.setRequired(true);		
        this.pkAuditTime.setEnabled(false);		
        this.prmtRespDept.setRequired(true);
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"hit\" t:width=\"75\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"supplier\" t:width=\"220\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"bidAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"chooseReason\" t:width=\"300\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"firstAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"secondAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"purchaseDoneAmountEx\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{hit}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{bidAmount}</t:Cell><t:Cell>$Resource{chooseReason}</t:Cell><t:Cell>$Resource{firstAmount}</t:Cell><t:Cell>$Resource{secondAmount}</t:Cell><t:Cell>$Resource{purchaseDoneAmountEx}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));
        this.kdtEntry.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
        });

                this.kdtEntry.putBindContents("editData",new String[] {"hit","supplier","bidAmount","chooseReason","firstAmount","secondAmount","purchaseDoneAmountEx"});


        this.kdtEntry.checkParsed();
        KDCheckBox kdtEntry_hit_CheckBox = new KDCheckBox();
        kdtEntry_hit_CheckBox.setName("kdtEntry_hit_CheckBox");
        KDTDefaultCellEditor kdtEntry_hit_CellEditor = new KDTDefaultCellEditor(kdtEntry_hit_CheckBox);
        this.kdtEntry.getColumn("hit").setEditor(kdtEntry_hit_CellEditor);
        KDFormattedTextField kdtEntry_bidAmount_TextField = new KDFormattedTextField();
        kdtEntry_bidAmount_TextField.setName("kdtEntry_bidAmount_TextField");
        kdtEntry_bidAmount_TextField.setVisible(true);
        kdtEntry_bidAmount_TextField.setEditable(true);
        kdtEntry_bidAmount_TextField.setHorizontalAlignment(2);
        kdtEntry_bidAmount_TextField.setDataType(1);
        	kdtEntry_bidAmount_TextField.setMinimumValue(new java.math.BigDecimal("-999.9999999999"));
        	kdtEntry_bidAmount_TextField.setMaximumValue(new java.math.BigDecimal("999.9999999999"));
        kdtEntry_bidAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_bidAmount_CellEditor = new KDTDefaultCellEditor(kdtEntry_bidAmount_TextField);
        this.kdtEntry.getColumn("bidAmount").setEditor(kdtEntry_bidAmount_CellEditor);
        KDTextField kdtEntry_chooseReason_TextField = new KDTextField();
        kdtEntry_chooseReason_TextField.setName("kdtEntry_chooseReason_TextField");
        kdtEntry_chooseReason_TextField.setMaxLength(2000);
        KDTDefaultCellEditor kdtEntry_chooseReason_CellEditor = new KDTDefaultCellEditor(kdtEntry_chooseReason_TextField);
        this.kdtEntry.getColumn("chooseReason").setEditor(kdtEntry_chooseReason_CellEditor);
        KDFormattedTextField kdtEntry_firstAmount_TextField = new KDFormattedTextField();
        kdtEntry_firstAmount_TextField.setName("kdtEntry_firstAmount_TextField");
        kdtEntry_firstAmount_TextField.setVisible(true);
        kdtEntry_firstAmount_TextField.setEditable(true);
        kdtEntry_firstAmount_TextField.setHorizontalAlignment(2);
        kdtEntry_firstAmount_TextField.setDataType(1);
        	kdtEntry_firstAmount_TextField.setMinimumValue(new java.math.BigDecimal("-999.9999999999"));
        	kdtEntry_firstAmount_TextField.setMaximumValue(new java.math.BigDecimal("999.9999999999"));
        kdtEntry_firstAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_firstAmount_CellEditor = new KDTDefaultCellEditor(kdtEntry_firstAmount_TextField);
        this.kdtEntry.getColumn("firstAmount").setEditor(kdtEntry_firstAmount_CellEditor);
        KDFormattedTextField kdtEntry_secondAmount_TextField = new KDFormattedTextField();
        kdtEntry_secondAmount_TextField.setName("kdtEntry_secondAmount_TextField");
        kdtEntry_secondAmount_TextField.setVisible(true);
        kdtEntry_secondAmount_TextField.setEditable(true);
        kdtEntry_secondAmount_TextField.setHorizontalAlignment(2);
        kdtEntry_secondAmount_TextField.setDataType(1);
        	kdtEntry_secondAmount_TextField.setMinimumValue(new java.math.BigDecimal("-999.9999999999"));
        	kdtEntry_secondAmount_TextField.setMaximumValue(new java.math.BigDecimal("999.9999999999"));
        kdtEntry_secondAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_secondAmount_CellEditor = new KDTDefaultCellEditor(kdtEntry_secondAmount_TextField);
        this.kdtEntry.getColumn("secondAmount").setEditor(kdtEntry_secondAmount_CellEditor);
        KDFormattedTextField kdtEntry_purchaseDoneAmountEx_TextField = new KDFormattedTextField();
        kdtEntry_purchaseDoneAmountEx_TextField.setName("kdtEntry_purchaseDoneAmountEx_TextField");
        kdtEntry_purchaseDoneAmountEx_TextField.setVisible(true);
        kdtEntry_purchaseDoneAmountEx_TextField.setEditable(true);
        kdtEntry_purchaseDoneAmountEx_TextField.setHorizontalAlignment(2);
        kdtEntry_purchaseDoneAmountEx_TextField.setDataType(1);
        	kdtEntry_purchaseDoneAmountEx_TextField.setMinimumValue(new java.math.BigDecimal("-999.9999999999"));
        	kdtEntry_purchaseDoneAmountEx_TextField.setMaximumValue(new java.math.BigDecimal("999.9999999999"));
        kdtEntry_purchaseDoneAmountEx_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_purchaseDoneAmountEx_CellEditor = new KDTDefaultCellEditor(kdtEntry_purchaseDoneAmountEx_TextField);
        this.kdtEntry.getColumn("purchaseDoneAmountEx").setEditor(kdtEntry_purchaseDoneAmountEx_CellEditor);
        // contSpecial		
        this.contSpecial.setBoundLabelText(resHelper.getString("contSpecial.boundLabelText"));		
        this.contSpecial.setBoundLabelLength(100);		
        this.contSpecial.setBoundLabelUnderline(true);
        // contScope		
        this.contScope.setBoundLabelText(resHelper.getString("contScope.boundLabelText"));		
        this.contScope.setBoundLabelLength(100);		
        this.contScope.setBoundLabelUnderline(true);
        // contRange		
        this.contRange.setBoundLabelText(resHelper.getString("contRange.boundLabelText"));		
        this.contRange.setBoundLabelLength(100);		
        this.contRange.setBoundLabelUnderline(true);
        // kDContainer1		
        this.kDContainer1.setTitle(resHelper.getString("kDContainer1.title"));
        // kDScrollPane1
        // txtSpecial		
        this.txtSpecial.setMaxLength(50000);		
        this.txtSpecial.setRequired(true);
        // kDScrollPane5
        // txtScope		
        this.txtScope.setMaxLength(50000);		
        this.txtScope.setRequired(true);
        // combRange		
        this.combRange.setRequired(true);		
        this.combRange.addItems(EnumUtils.getEnumList("com.kingdee.eas.fdc.invite.RangeEnum").toArray());
        // changInviteTypeApplication
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
        this.setBounds(new Rectangle(10, 10, 1000, 600));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1000, 600));
        contCreator.setBounds(new Rectangle(13, 551, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(13, 551, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(365, 551, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(365, 551, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(13, 573, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(13, 573, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(898, 15, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(898, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditTime.setBounds(new Rectangle(365, 573, 270, 19));
        this.add(contAuditTime, new KDLayout.Constraints(365, 573, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contName.setBounds(new Rectangle(363, 9, 270, 19));
        this.add(contName, new KDLayout.Constraints(363, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contRespDept.setBounds(new Rectangle(702, 551, 270, 19));
        this.add(contRespDept, new KDLayout.Constraints(702, 551, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contEntry.setBounds(new Rectangle(13, 224, 959, 174));
        this.add(contEntry, new KDLayout.Constraints(13, 224, 959, 174, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        btnShowProject.setBounds(new Rectangle(702, 10, 166, 19));
        this.add(btnShowProject, new KDLayout.Constraints(702, 10, 166, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contProject.setBounds(new Rectangle(13, 13, 270, 19));
        this.add(contProject, new KDLayout.Constraints(13, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contSpecial.setBounds(new Rectangle(13, 140, 959, 80));
        this.add(contSpecial, new KDLayout.Constraints(13, 140, 959, 80, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contScope.setBounds(new Rectangle(13, 57, 959, 80));
        this.add(contScope, new KDLayout.Constraints(13, 57, 959, 80, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contRange.setBounds(new Rectangle(13, 35, 270, 19));
        this.add(contRange, new KDLayout.Constraints(13, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDContainer1.setBounds(new Rectangle(13, 405, 959, 132));
        this.add(kDContainer1, new KDLayout.Constraints(13, 405, 959, 132, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(pkCreateTime);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contAuditTime
        contAuditTime.setBoundEditor(pkAuditTime);
        //contName
        contName.setBoundEditor(txtName);
        //contRespDept
        contRespDept.setBoundEditor(prmtRespDept);
        //contEntry
contEntry.getContentPane().setLayout(new BorderLayout(0, 0));        contEntry.getContentPane().add(kdtEntry, BorderLayout.CENTER);
        //contProject
        contProject.setBoundEditor(txtProject);
        //contSpecial
        contSpecial.setBoundEditor(kDScrollPane1);
        //kDScrollPane1
        kDScrollPane1.getViewport().add(txtSpecial, null);
        //contScope
        contScope.setBoundEditor(kDScrollPane5);
        //kDScrollPane5
        kDScrollPane5.getViewport().add(txtScope, null);
        //contRange
        contRange.setBoundEditor(combRange);
        //kDContainer1
kDContainer1.getContentPane().setLayout(new BorderLayout(0, 0));        kDContainer1.getContentPane().add(changInviteTypeApplication, BorderLayout.CENTER);

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
        menuBiz.add(menuItemAudit);
        menuBiz.add(menuItemUnAudit);
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
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnSignature);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnCreateTo);
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
        this.toolBar.add(btnCalculator);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkCreateTime, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkAuditTime, "value");
		dataBinder.registerBinding("name", String.class, this.txtName, "text");
		dataBinder.registerBinding("respDept", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtRespDept, "data");
		dataBinder.registerBinding("entrys.hit", boolean.class, this.kdtEntry, "hit.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.fdc.invite.DirectNegotiationApproval.DirectNegotiationApprovalEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("entrys.supplier", com.kingdee.eas.fdc.invite.supplier.SupplierStockInfo.class, this.kdtEntry, "supplier.text");
		dataBinder.registerBinding("entrys.bidAmount", java.math.BigDecimal.class, this.kdtEntry, "bidAmount.text");
		dataBinder.registerBinding("entrys.chooseReason", String.class, this.kdtEntry, "chooseReason.text");
		dataBinder.registerBinding("entrys.firstAmount", java.math.BigDecimal.class, this.kdtEntry, "firstAmount.text");
		dataBinder.registerBinding("entrys.secondAmount", java.math.BigDecimal.class, this.kdtEntry, "secondAmount.text");
		dataBinder.registerBinding("entrys.purchaseDoneAmountEx", java.math.BigDecimal.class, this.kdtEntry, "purchaseDoneAmountEx.text");
		dataBinder.registerBinding("inviteProject.name", String.class, this.txtProject, "text");
		dataBinder.registerBinding("specialNote", String.class, this.txtSpecial, "text");
		dataBinder.registerBinding("scope", String.class, this.txtScope, "text");
		dataBinder.registerBinding("compareAim", com.kingdee.eas.fdc.invite.RangeEnum.class, this.combRange, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.fdc.invite.DirectNegotiationApproval.app.DirectNegotiationApprovalEditUIHandler";
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
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.DirectNegotiationApprovalInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"CostCenter",editData.getString("number"));
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
			protected com.kingdee.eas.basedata.org.OrgType getMainBizOrgType() {
			return com.kingdee.eas.basedata.org.OrgType.getEnum("CostCenter");
		}


    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("CostCenter");
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
	 * ????????��??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("respDept", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.bidAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.chooseReason", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.firstAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.secondAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.purchaseDoneAmountEx", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inviteProject.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("specialNote", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("scope", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("compareAim", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntry_tableSelectChanged method
     */
    protected void kdtEntry_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
    {
    }

    /**
     * output kdtEntry_editStopped method
     */
    protected void kdtEntry_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
        sic.add(new SelectorItemInfo("creator.*"));
        sic.add(new SelectorItemInfo("createTime"));
        sic.add(new SelectorItemInfo("auditor.*"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("respDept.*"));
    sic.add(new SelectorItemInfo("entrys.hit"));
        sic.add(new SelectorItemInfo("entrys.*"));
//        sic.add(new SelectorItemInfo("entrys.number"));
        sic.add(new SelectorItemInfo("entrys.supplier.*"));
//        sic.add(new SelectorItemInfo("entrys.supplier.number"));
    sic.add(new SelectorItemInfo("entrys.bidAmount"));
    sic.add(new SelectorItemInfo("entrys.chooseReason"));
    sic.add(new SelectorItemInfo("entrys.firstAmount"));
    sic.add(new SelectorItemInfo("entrys.secondAmount"));
    sic.add(new SelectorItemInfo("entrys.purchaseDoneAmountEx"));
        sic.add(new SelectorItemInfo("inviteProject.name"));
        sic.add(new SelectorItemInfo("specialNote"));
        sic.add(new SelectorItemInfo("scope"));
        sic.add(new SelectorItemInfo("compareAim"));
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
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAudit_actionPerformed(e);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionUnAudit_actionPerformed(e);
    }
    	

    /**
     * output showProjects_actionPerformed method
     */
    public void showProjects_actionPerformed(ActionEvent e) throws Exception
    {
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
	public RequestContext prepareActionAudit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionAudit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAudit() {
    	return false;
    }
	public RequestContext prepareActionUnAudit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionUnAudit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnAudit() {
    	return false;
    }
	public RequestContext prepareShowProjects(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareShowProjects() {
    	return false;
    }

    /**
     * output ShowProjects class
     */     
    protected class ShowProjects extends ItemAction {     
    
        public ShowProjects()
        {
            this(null);
        }

        public ShowProjects(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ShowProjects.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ShowProjects.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ShowProjects.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDirectNegotiationApprovalEditUI.this, "ShowProjects", "showProjects_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.fdc.invite.DirectNegotiationApproval.client", "DirectNegotiationApprovalEditUI");
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
        return com.kingdee.eas.fdc.invite.DirectNegotiationApproval.client.DirectNegotiationApprovalEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.DirectNegotiationApproval.DirectNegotiationApprovalFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.DirectNegotiationApproval.DirectNegotiationApprovalInfo objectValue = new com.kingdee.eas.fdc.invite.DirectNegotiationApproval.DirectNegotiationApprovalInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/fdc/invite/DirectNegotiationApproval/DirectNegotiationApproval";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.fdc.invite.DirectNegotiationApproval.app.DirectNegotiationApprovalQuery");
	}
    

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}