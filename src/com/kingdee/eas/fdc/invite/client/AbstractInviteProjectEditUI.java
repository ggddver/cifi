/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.client;

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
public abstract class AbstractInviteProjectEditUI extends com.kingdee.eas.fdc.basedata.client.FDCBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractInviteProjectEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditTime;
    protected com.kingdee.bos.ctrl.swing.KDContainer infoContainer;
    protected com.kingdee.bos.ctrl.swing.KDContainer prjContainer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkAuditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contInviteType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contInviteForm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPriceMode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPaperIsComplete;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton kDRBPCYes;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton kDRBPCNo;
    protected com.kingdee.bos.ctrl.swing.KDButtonGroup btnPC;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contProcurementType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuth;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer prmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPurchaseAuthority;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPurchaseCategory;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contestimatedAmt;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtInviteType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtInviteForm;
    protected com.kingdee.bos.ctrl.swing.KDComboBox combPriceMode;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtPurchaseMode;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtScalingRule;
    protected com.kingdee.bos.ctrl.swing.KDComboBox combProcurementType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox combAuth;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox pbPricingApproach;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmptPurchaseAuthority;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmptPurchaseCategory;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtestimatedAmt;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable prjTable;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRelate;
    protected javax.swing.JToolBar.Separator separator4;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAddPlan;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnInsertPlan;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRemovePlan;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem kdmViewProCont;
    protected com.kingdee.eas.fdc.invite.InviteProjectInfo editData = null;
    protected ActionAddPlan actionAddPlan = null;
    protected ActionRemovePlan actionRemovePlan = null;
    protected ActionInsertPlan actionInsertPlan = null;
    protected ActionRelate actionRelate = null;
    /**
     * output class constructor
     */
    public AbstractInviteProjectEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractInviteProjectEditUI.class.getName());
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
        //actionAddLine
        actionAddLine.setEnabled(true);
        actionAddLine.setDaemonRun(false);

        actionAddLine.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift ctrl N"));
        _tempStr = resHelper.getString("ActionAddLine.SHORT_DESCRIPTION");
        actionAddLine.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAddLine.LONG_DESCRIPTION");
        actionAddLine.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAddLine.NAME");
        actionAddLine.putValue(ItemAction.NAME, _tempStr);
         this.actionAddLine.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAddLine.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionAddLine.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionInsertLine
        actionInsertLine.setEnabled(true);
        actionInsertLine.setDaemonRun(false);

        actionInsertLine.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift I"));
        _tempStr = resHelper.getString("ActionInsertLine.SHORT_DESCRIPTION");
        actionInsertLine.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionInsertLine.LONG_DESCRIPTION");
        actionInsertLine.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionInsertLine.NAME");
        actionInsertLine.putValue(ItemAction.NAME, _tempStr);
         this.actionInsertLine.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionInsertLine.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionInsertLine.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionRemoveLine
        actionRemoveLine.setEnabled(true);
        actionRemoveLine.setDaemonRun(false);

        actionRemoveLine.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift D"));
        _tempStr = resHelper.getString("ActionRemoveLine.SHORT_DESCRIPTION");
        actionRemoveLine.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionRemoveLine.LONG_DESCRIPTION");
        actionRemoveLine.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionRemoveLine.NAME");
        actionRemoveLine.putValue(ItemAction.NAME, _tempStr);
         this.actionRemoveLine.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionRemoveLine.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionRemoveLine.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionAddPlan
        this.actionAddPlan = new ActionAddPlan(this);
        getActionManager().registerAction("actionAddPlan", actionAddPlan);
         this.actionAddPlan.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionRemovePlan
        this.actionRemovePlan = new ActionRemovePlan(this);
        getActionManager().registerAction("actionRemovePlan", actionRemovePlan);
         this.actionRemovePlan.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionInsertPlan
        this.actionInsertPlan = new ActionInsertPlan(this);
        getActionManager().registerAction("actionInsertPlan", actionInsertPlan);
         this.actionInsertPlan.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionRelate
        this.actionRelate = new ActionRelate(this);
        getActionManager().registerAction("actionRelate", actionRelate);
         this.actionRelate.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.infoContainer = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.prjContainer = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkAuditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contInviteType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contInviteForm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPriceMode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPaperIsComplete = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDRBPCYes = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.kDRBPCNo = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.btnPC = new com.kingdee.bos.ctrl.swing.KDButtonGroup();
        this.contProcurementType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuth = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPurchaseAuthority = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPurchaseCategory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contestimatedAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtInviteType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtInviteForm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.combPriceMode = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtPurchaseMode = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtScalingRule = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.combProcurementType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.combAuth = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pbPricingApproach = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmptPurchaseAuthority = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmptPurchaseCategory = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtestimatedAmt = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prjTable = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnRelate = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.separator4 = new javax.swing.JToolBar.Separator();
        this.btnAddPlan = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnInsertPlan = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnRemovePlan = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kdmViewProCont = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contAuditor.setName("contAuditor");
        this.contAuditTime.setName("contAuditTime");
        this.infoContainer.setName("infoContainer");
        this.prjContainer.setName("prjContainer");
        this.prmtCreator.setName("prmtCreator");
        this.pkCreateTime.setName("pkCreateTime");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkAuditTime.setName("pkAuditTime");
        this.contNumber.setName("contNumber");
        this.contName.setName("contName");
        this.contInviteType.setName("contInviteType");
        this.contInviteForm.setName("contInviteForm");
        this.contPriceMode.setName("contPriceMode");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.contPaperIsComplete.setName("contPaperIsComplete");
        this.kDRBPCYes.setName("kDRBPCYes");
        this.kDRBPCNo.setName("kDRBPCNo");
        this.contProcurementType.setName("contProcurementType");
        this.contAuth.setName("contAuth");
        this.prmt.setName("prmt");
        this.contPurchaseAuthority.setName("contPurchaseAuthority");
        this.contPurchaseCategory.setName("contPurchaseCategory");
        this.contestimatedAmt.setName("contestimatedAmt");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.prmtInviteType.setName("prmtInviteType");
        this.prmtInviteForm.setName("prmtInviteForm");
        this.combPriceMode.setName("combPriceMode");
        this.prmtPurchaseMode.setName("prmtPurchaseMode");
        this.prmtScalingRule.setName("prmtScalingRule");
        this.combProcurementType.setName("combProcurementType");
        this.combAuth.setName("combAuth");
        this.pbPricingApproach.setName("pbPricingApproach");
        this.prmptPurchaseAuthority.setName("prmptPurchaseAuthority");
        this.prmptPurchaseCategory.setName("prmptPurchaseCategory");
        this.prmtestimatedAmt.setName("prmtestimatedAmt");
        this.prjTable.setName("prjTable");
        this.btnRelate.setName("btnRelate");
        this.separator4.setName("separator4");
        this.btnAddPlan.setName("btnAddPlan");
        this.btnInsertPlan.setName("btnInsertPlan");
        this.btnRemovePlan.setName("btnRemovePlan");
        this.kdmViewProCont.setName("kdmViewProCont");
        // CoreUI		
        this.setMinimumSize(new Dimension(1000,330));		
        this.setPreferredSize(new Dimension(1000,330));		
        this.menuBiz.setEnabled(false);		
        this.menuBiz.setVisible(false);		
        this.btnAddLine.setText(resHelper.getString("btnAddLine.text"));		
        this.btnAddLine.setToolTipText(resHelper.getString("btnAddLine.toolTipText"));		
        this.btnInsertLine.setText(resHelper.getString("btnInsertLine.text"));		
        this.btnInsertLine.setToolTipText(resHelper.getString("btnInsertLine.toolTipText"));		
        this.btnRemoveLine.setText(resHelper.getString("btnRemoveLine.text"));		
        this.btnRemoveLine.setToolTipText(resHelper.getString("btnRemoveLine.toolTipText"));		
        this.menuItemCreateFrom.setEnabled(false);		
        this.menuItemCreateFrom.setVisible(false);		
        this.menuItemCopyFrom.setEnabled(false);		
        this.menuItemCopyFrom.setVisible(false);		
        this.menuItemAddLine.setText(resHelper.getString("menuItemAddLine.text"));		
        this.menuItemInsertLine.setText(resHelper.getString("menuItemInsertLine.text"));		
        this.menuItemRemoveLine.setText(resHelper.getString("menuItemRemoveLine.text"));		
        this.menuItemCreateTo.setEnabled(false);		
        this.btnAudit.setVisible(false);		
        this.btnAudit.setEnabled(false);		
        this.btnUnAudit.setEnabled(false);		
        this.btnUnAudit.setVisible(false);		
        this.btnCalculator.setVisible(false);		
        this.btnCalculator.setEnabled(false);
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
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contAuditor.setEnabled(false);
        // contAuditTime		
        this.contAuditTime.setBoundLabelText(resHelper.getString("contAuditTime.boundLabelText"));		
        this.contAuditTime.setBoundLabelLength(100);		
        this.contAuditTime.setBoundLabelUnderline(true);		
        this.contAuditTime.setEnabled(false);
        // infoContainer		
        this.infoContainer.setTitle(resHelper.getString("infoContainer.title"));		
        this.infoContainer.setMinimumSize(new Dimension(96,125));		
        this.infoContainer.setPreferredSize(new Dimension(19,125));
        // prjContainer		
        this.prjContainer.setTitle(resHelper.getString("prjContainer.title"));
        // prmtCreator		
        this.prmtCreator.setEnabled(false);		
        this.prmtCreator.setDisplayFormat("$name$");		
        this.prmtCreator.setEditFormat("$number$");		
        this.prmtCreator.setCommitFormat("$number$");
        // pkCreateTime		
        this.pkCreateTime.setEnabled(false);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);		
        this.prmtAuditor.setDisplayFormat("$name$");		
        this.prmtAuditor.setEditFormat("$number$");		
        this.prmtAuditor.setCommitFormat("$number$");
        // pkAuditTime		
        this.pkAuditTime.setEnabled(false);
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // contName		
        this.contName.setBoundLabelText(resHelper.getString("contName.boundLabelText"));		
        this.contName.setBoundLabelLength(100);		
        this.contName.setBoundLabelUnderline(true);
        // contInviteType		
        this.contInviteType.setBoundLabelText(resHelper.getString("contInviteType.boundLabelText"));		
        this.contInviteType.setBoundLabelLength(100);		
        this.contInviteType.setBoundLabelUnderline(true);
        // contInviteForm		
        this.contInviteForm.setBoundLabelText(resHelper.getString("contInviteForm.boundLabelText"));		
        this.contInviteForm.setBoundLabelLength(100);		
        this.contInviteForm.setBoundLabelUnderline(true);
        // contPriceMode		
        this.contPriceMode.setBoundLabelText(resHelper.getString("contPriceMode.boundLabelText"));		
        this.contPriceMode.setBoundLabelLength(100);		
        this.contPriceMode.setBoundLabelUnderline(true);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // contPaperIsComplete		
        this.contPaperIsComplete.setBoundLabelText(resHelper.getString("contPaperIsComplete.boundLabelText"));		
        this.contPaperIsComplete.setBoundLabelUnderline(true);
        // kDRBPCYes		
        this.kDRBPCYes.setText(resHelper.getString("kDRBPCYes.text"));
        // kDRBPCNo		
        this.kDRBPCNo.setText(resHelper.getString("kDRBPCNo.text"));
        // btnPC
        this.btnPC.add(this.kDRBPCYes);
        this.btnPC.add(this.kDRBPCNo);
        // contProcurementType		
        this.contProcurementType.setBoundLabelText(resHelper.getString("contProcurementType.boundLabelText"));		
        this.contProcurementType.setBoundLabelLength(100);		
        this.contProcurementType.setBoundLabelUnderline(true);
        // contAuth		
        this.contAuth.setBoundLabelText(resHelper.getString("contAuth.boundLabelText"));		
        this.contAuth.setBoundLabelLength(100);		
        this.contAuth.setBoundLabelUnderline(true);
        // prmt		
        this.prmt.setBoundLabelText(resHelper.getString("prmt.boundLabelText"));		
        this.prmt.setBoundLabelLength(100);		
        this.prmt.setBoundLabelUnderline(true);
        // contPurchaseAuthority		
        this.contPurchaseAuthority.setBoundLabelText(resHelper.getString("contPurchaseAuthority.boundLabelText"));		
        this.contPurchaseAuthority.setBoundLabelLength(100);		
        this.contPurchaseAuthority.setBoundLabelUnderline(true);
        // contPurchaseCategory		
        this.contPurchaseCategory.setBoundLabelText(resHelper.getString("contPurchaseCategory.boundLabelText"));		
        this.contPurchaseCategory.setBoundLabelLength(100);		
        this.contPurchaseCategory.setBoundLabelUnderline(true);
        // contestimatedAmt		
        this.contestimatedAmt.setBoundLabelText(resHelper.getString("contestimatedAmt.boundLabelText"));		
        this.contestimatedAmt.setBoundLabelLength(100);		
        this.contestimatedAmt.setBoundLabelUnderline(true);		
        this.contestimatedAmt.setVisible(true);
        // txtNumber		
        this.txtNumber.setRequired(true);
        // txtName		
        this.txtName.setRequired(true);
        // prmtInviteType		
        this.prmtInviteType.setQueryInfo("com.kingdee.eas.fdc.invite.app.F7InviteTypeQuery");		
        this.prmtInviteType.setCommitFormat("$name$");		
        this.prmtInviteType.setEditFormat("$name$");		
        this.prmtInviteType.setDisplayFormat("$name$");		
        this.prmtInviteType.setRequired(true);
        this.prmtInviteType.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtInviteType_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        this.prmtInviteType.addSelectorListener(new com.kingdee.bos.ctrl.swing.event.SelectorListener() {
            public void willShow(com.kingdee.bos.ctrl.swing.event.SelectorEvent e) {
                try {
                    prmtInviteType_willShow(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtInviteForm		
        this.prmtInviteForm.setQueryInfo("com.kingdee.eas.fdc.invite.app.InviteFormQuery");		
        this.prmtInviteForm.setRequired(true);
        // combPriceMode		
        this.combPriceMode.addItems(EnumUtils.getEnumList("com.kingdee.eas.fdc.invite.PricingModeEnum").toArray());
        // prmtPurchaseMode		
        this.prmtPurchaseMode.setQueryInfo("com.kingdee.eas.fdc.invite.app.InvitePurchaseModeQuery");		
        this.prmtPurchaseMode.setRequired(true);
        this.prmtPurchaseMode.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtPurchaseMode_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtScalingRule		
        this.prmtScalingRule.setQueryInfo("com.kingdee.eas.fdc.invite.app.ScalingRuleQuery");		
        this.prmtScalingRule.setRequired(true);
        // combProcurementType		
        this.combProcurementType.addItems(EnumUtils.getEnumList("com.kingdee.eas.fdc.invite.ProcurementType").toArray());		
        this.combProcurementType.setRequired(true);
        // combAuth		
        this.combAuth.addItems(EnumUtils.getEnumList("com.kingdee.eas.fdc.invite.InvitePurchaseAuthorization").toArray());		
        this.combAuth.setRequired(true);
        // pbPricingApproach		
        this.pbPricingApproach.setDisplayFormat("$name$");		
        this.pbPricingApproach.setEditFormat("$name$");		
        this.pbPricingApproach.setCommitFormat("$number$");		
        this.pbPricingApproach.setQueryInfo("com.kingdee.eas.custom.purchasebaseinfomation.app.PricingApproachHideQuery");
        // prmptPurchaseAuthority		
        this.prmptPurchaseAuthority.setDisplayFormat("$name$");		
        this.prmptPurchaseAuthority.setEditFormat("$name$");		
        this.prmptPurchaseAuthority.setCommitFormat("$number$");		
        this.prmptPurchaseAuthority.setQueryInfo("com.kingdee.eas.custom.purchasebaseinfomation.app.PurchaseAuthorityQuery");
        // prmptPurchaseCategory		
        this.prmptPurchaseCategory.setDisplayFormat("$name$");		
        this.prmptPurchaseCategory.setEditFormat("$name$");		
        this.prmptPurchaseCategory.setCommitFormat("$number$");		
        this.prmptPurchaseCategory.setQueryInfo("com.kingdee.eas.custom.purchasebaseinfomation.app.PurchaseCategoryHideQuery");
        // prmtestimatedAmt		
        this.prmtestimatedAmt.setQueryInfo("com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.app.EstimatedAmtQuery");		
        this.prmtestimatedAmt.setVisible(true);		
        this.prmtestimatedAmt.setEditable(true);		
        this.prmtestimatedAmt.setDisplayFormat("$name$");		
        this.prmtestimatedAmt.setEditFormat("$number$");		
        this.prmtestimatedAmt.setCommitFormat("$number$");		
        this.prmtestimatedAmt.setRequired(false);
        		prmtestimatedAmt.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.client.EstimatedAmtListUI prmtestimatedAmt_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtestimatedAmt_F7ListUI == null) {
					try {
						prmtestimatedAmt_F7ListUI = new com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.client.EstimatedAmtListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtestimatedAmt_F7ListUI));
					prmtestimatedAmt_F7ListUI.setF7Use(true,ctx);
					prmtestimatedAmt.setSelector(prmtestimatedAmt_F7ListUI);
				}
			}
		});
					
        // prjTable
		String prjTableStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"programmingId\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"programmingName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"issueDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"startDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"period\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"desc\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{programmingId}</t:Cell><t:Cell>$Resource{programmingName}</t:Cell><t:Cell>$Resource{issueDate}</t:Cell><t:Cell>$Resource{startDate}</t:Cell><t:Cell>$Resource{period}</t:Cell><t:Cell>$Resource{desc}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.prjTable.setFormatXml(resHelper.translateString("prjTable",prjTableStrXML));
        this.prjTable.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    prjTable_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
            public void editStarting(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    prjTable_editStarting(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.prjTable.putBindContents("editData",new String[] {"id","project.longNumber","project","programmingContract.id","programmingContract","issueDate","startDate","period","desc"});


        this.prjTable.checkParsed();
        final KDBizPromptBox prjTable_name_PromptBox = new KDBizPromptBox();
        prjTable_name_PromptBox.setQueryInfo("com.kingdee.eas.fdc.basedata.app.F7ProjectForAssActQuery");
        prjTable_name_PromptBox.setVisible(true);
        prjTable_name_PromptBox.setEditable(true);
        prjTable_name_PromptBox.setDisplayFormat("$number$");
        prjTable_name_PromptBox.setEditFormat("$number$");
        prjTable_name_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor prjTable_name_CellEditor = new KDTDefaultCellEditor(prjTable_name_PromptBox);
        this.prjTable.getColumn("name").setEditor(prjTable_name_CellEditor);
        ObjectValueRender prjTable_name_OVR = new ObjectValueRender();
        prjTable_name_OVR.setFormat(new BizDataFormat("$name$"));
        this.prjTable.getColumn("name").setRenderer(prjTable_name_OVR);
        KDDatePicker prjTable_issueDate_DatePicker = new KDDatePicker();
        prjTable_issueDate_DatePicker.setName("prjTable_issueDate_DatePicker");
        prjTable_issueDate_DatePicker.setVisible(true);
        prjTable_issueDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor prjTable_issueDate_CellEditor = new KDTDefaultCellEditor(prjTable_issueDate_DatePicker);
        this.prjTable.getColumn("issueDate").setEditor(prjTable_issueDate_CellEditor);
        KDDatePicker prjTable_startDate_DatePicker = new KDDatePicker();
        prjTable_startDate_DatePicker.setName("prjTable_startDate_DatePicker");
        prjTable_startDate_DatePicker.setVisible(true);
        prjTable_startDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor prjTable_startDate_CellEditor = new KDTDefaultCellEditor(prjTable_startDate_DatePicker);
        this.prjTable.getColumn("startDate").setEditor(prjTable_startDate_CellEditor);
        KDFormattedTextField prjTable_period_TextField = new KDFormattedTextField();
        prjTable_period_TextField.setName("prjTable_period_TextField");
        prjTable_period_TextField.setVisible(true);
        prjTable_period_TextField.setEditable(true);
        prjTable_period_TextField.setHorizontalAlignment(2);
        prjTable_period_TextField.setDataType(1);
        	prjTable_period_TextField.setMinimumValue(new java.math.BigDecimal("-999.9999999999"));
        	prjTable_period_TextField.setMaximumValue(new java.math.BigDecimal("999.9999999999"));
        prjTable_period_TextField.setPrecision(10);
        KDTDefaultCellEditor prjTable_period_CellEditor = new KDTDefaultCellEditor(prjTable_period_TextField);
        this.prjTable.getColumn("period").setEditor(prjTable_period_CellEditor);
        KDTextField prjTable_desc_TextField = new KDTextField();
        prjTable_desc_TextField.setName("prjTable_desc_TextField");
        prjTable_desc_TextField.setMaxLength(250);
        KDTDefaultCellEditor prjTable_desc_CellEditor = new KDTDefaultCellEditor(prjTable_desc_TextField);
        this.prjTable.getColumn("desc").setEditor(prjTable_desc_CellEditor);
        // btnRelate
        this.btnRelate.setAction((IItemAction)ActionProxyFactory.getProxy(actionRelate, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnRelate.setText(resHelper.getString("btnRelate.text"));		
        this.btnRelate.setPreferredSize(new Dimension(42,18));		
        this.btnRelate.setMinimumSize(new Dimension(42,18));		
        this.btnRelate.setVisible(false);		
        this.btnRelate.setEnabled(false);
        // separator4
        // btnAddPlan
        this.btnAddPlan.setAction((IItemAction)ActionProxyFactory.getProxy(actionAddPlan, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAddPlan.setText(resHelper.getString("btnAddPlan.text"));		
        this.btnAddPlan.setVisible(false);
        // btnInsertPlan
        this.btnInsertPlan.setAction((IItemAction)ActionProxyFactory.getProxy(actionInsertPlan, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnInsertPlan.setText(resHelper.getString("btnInsertPlan.text"));		
        this.btnInsertPlan.setVisible(false);
        // btnRemovePlan
        this.btnRemovePlan.setAction((IItemAction)ActionProxyFactory.getProxy(actionRemovePlan, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnRemovePlan.setText(resHelper.getString("btnRemovePlan.text"));		
        this.btnRemovePlan.setVisible(false);
        // kdmViewProCont		
        this.kdmViewProCont.setText(resHelper.getString("kdmViewProCont.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtestimatedAmt}));
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
        this.setBounds(new Rectangle(10, 10, 1000, 330));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1000, 330));
        contCreator.setBounds(new Rectangle(11, 278, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(11, 278, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(365, 278, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(365, 278, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(11, 301, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(11, 301, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditTime.setBounds(new Rectangle(365, 301, 270, 19));
        this.add(contAuditTime, new KDLayout.Constraints(365, 301, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        infoContainer.setBounds(new Rectangle(10, 6, 980, 122));
        this.add(infoContainer, new KDLayout.Constraints(10, 6, 980, 122, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        prjContainer.setBounds(new Rectangle(10, 138, 980, 133));
        this.add(prjContainer, new KDLayout.Constraints(10, 138, 980, 133, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(pkCreateTime);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contAuditTime
        contAuditTime.setBoundEditor(pkAuditTime);
        //infoContainer
        infoContainer.getContentPane().setLayout(new KDLayout());
        infoContainer.getContentPane().putClientProperty("OriginalBounds", new Rectangle(10, 6, 980, 122));        contNumber.setBounds(new Rectangle(2, 4, 242, 19));
        infoContainer.getContentPane().add(contNumber, new KDLayout.Constraints(2, 4, 242, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contName.setBounds(new Rectangle(369, 4, 242, 19));
        infoContainer.getContentPane().add(contName, new KDLayout.Constraints(369, 4, 242, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contInviteType.setBounds(new Rectangle(728, 4, 242, 19));
        infoContainer.getContentPane().add(contInviteType, new KDLayout.Constraints(728, 4, 242, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contInviteForm.setBounds(new Rectangle(2, 26, 242, 19));
        infoContainer.getContentPane().add(contInviteForm, new KDLayout.Constraints(2, 26, 242, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contPriceMode.setBounds(new Rectangle(285, 90, 242, 19));
        infoContainer.getContentPane().add(contPriceMode, new KDLayout.Constraints(285, 90, 242, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer1.setBounds(new Rectangle(369, 26, 242, 19));
        infoContainer.getContentPane().add(kDLabelContainer1, new KDLayout.Constraints(369, 26, 242, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(2, 49, 242, 19));
        infoContainer.getContentPane().add(kDLabelContainer2, new KDLayout.Constraints(2, 49, 242, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contPaperIsComplete.setBounds(new Rectangle(370, 49, 148, 19));
        infoContainer.getContentPane().add(contPaperIsComplete, new KDLayout.Constraints(370, 49, 148, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDRBPCYes.setBounds(new Rectangle(525, 51, 40, 19));
        infoContainer.getContentPane().add(kDRBPCYes, new KDLayout.Constraints(525, 51, 40, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDRBPCNo.setBounds(new Rectangle(569, 51, 40, 19));
        infoContainer.getContentPane().add(kDRBPCNo, new KDLayout.Constraints(569, 51, 40, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contProcurementType.setBounds(new Rectangle(285, 71, 242, 19));
        infoContainer.getContentPane().add(contProcurementType, new KDLayout.Constraints(285, 71, 242, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuth.setBounds(new Rectangle(538, 72, 139, 19));
        infoContainer.getContentPane().add(contAuth, new KDLayout.Constraints(538, 72, 139, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        prmt.setBounds(new Rectangle(728, 26, 242, 19));
        infoContainer.getContentPane().add(prmt, new KDLayout.Constraints(728, 26, 242, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contPurchaseAuthority.setBounds(new Rectangle(728, 69, 242, 19));
        infoContainer.getContentPane().add(contPurchaseAuthority, new KDLayout.Constraints(728, 69, 242, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contPurchaseCategory.setBounds(new Rectangle(728, 47, 242, 19));
        infoContainer.getContentPane().add(contPurchaseCategory, new KDLayout.Constraints(728, 47, 242, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contestimatedAmt.setBounds(new Rectangle(2, 69, 242, 19));
        infoContainer.getContentPane().add(contestimatedAmt, new KDLayout.Constraints(2, 69, 242, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contName
        contName.setBoundEditor(txtName);
        //contInviteType
        contInviteType.setBoundEditor(prmtInviteType);
        //contInviteForm
        contInviteForm.setBoundEditor(prmtInviteForm);
        //contPriceMode
        contPriceMode.setBoundEditor(combPriceMode);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(prmtPurchaseMode);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(prmtScalingRule);
        //contProcurementType
        contProcurementType.setBoundEditor(combProcurementType);
        //contAuth
        contAuth.setBoundEditor(combAuth);
        //prmt
        prmt.setBoundEditor(pbPricingApproach);
        //contPurchaseAuthority
        contPurchaseAuthority.setBoundEditor(prmptPurchaseAuthority);
        //contPurchaseCategory
        contPurchaseCategory.setBoundEditor(prmptPurchaseCategory);
        //contestimatedAmt
        contestimatedAmt.setBoundEditor(prmtestimatedAmt);
        //prjContainer
prjContainer.getContentPane().setLayout(new BorderLayout(0, 0));        prjContainer.getContentPane().add(prjTable, BorderLayout.CENTER);

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
        menuView.add(kdmViewProCont);
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
        this.toolBar.add(btnRelate);
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
        this.toolBar.add(separator4);
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
        this.toolBar.add(btnCopyLine);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnCreateTo);
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
        this.toolBar.add(btnAddPlan);
        this.toolBar.add(btnInsertPlan);
        this.toolBar.add(btnRemovePlan);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkCreateTime, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkAuditTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "text");
		dataBinder.registerBinding("inviteType", com.kingdee.eas.fdc.invite.InviteTypeInfo.class, this.prmtInviteType, "data");
		dataBinder.registerBinding("inviteForm", com.kingdee.eas.fdc.invite.InviteFormInfo.class, this.prmtInviteForm, "data");
		dataBinder.registerBinding("PriceMode", com.kingdee.eas.fdc.invite.PricingModeEnum.class, this.combPriceMode, "selectedItem");
		dataBinder.registerBinding("invitePurchaseMode", com.kingdee.eas.fdc.invite.InvitePurchaseModeInfo.class, this.prmtPurchaseMode, "data");
		dataBinder.registerBinding("scalingRule", com.kingdee.eas.fdc.invite.ScalingRuleInfo.class, this.prmtScalingRule, "data");
		dataBinder.registerBinding("procurementType", com.kingdee.eas.fdc.invite.ProcurementType.class, this.combProcurementType, "selectedItem");
		dataBinder.registerBinding("authorization", com.kingdee.eas.fdc.invite.InvitePurchaseAuthorization.class, this.combAuth, "selectedItem");
		dataBinder.registerBinding("pricingApproach", com.kingdee.eas.custom.purchasebaseinfomation.PricingApproachInfo.class, this.pbPricingApproach, "data");
		dataBinder.registerBinding("purchaseAuthority", com.kingdee.eas.custom.purchasebaseinfomation.PurchaseAuthorInfo.class, this.prmptPurchaseAuthority, "data");
		dataBinder.registerBinding("purchaseCategory", com.kingdee.eas.custom.purchasebaseinfomation.PurchaseCategoryInfo.class, this.prmptPurchaseCategory, "data");
		dataBinder.registerBinding("estimatedAmt", com.kingdee.eas.fdc.invite.DirectNegotiationApproval.basedata.EstimatedAmtInfo.class, this.prmtestimatedAmt, "data");
		dataBinder.registerBinding("entries.id", com.kingdee.bos.util.BOSUuid.class, this.prjTable, "id.text");
		dataBinder.registerBinding("entries", com.kingdee.eas.fdc.invite.InviteProjectEntriesInfo.class, this.prjTable, "userObject");
		dataBinder.registerBinding("entries.programmingContract.id", com.kingdee.bos.util.BOSUuid.class, this.prjTable, "programmingId.text");
		dataBinder.registerBinding("entries.issueDate", java.util.Date.class, this.prjTable, "issueDate.text");
		dataBinder.registerBinding("entries.startDate", java.util.Date.class, this.prjTable, "startDate.text");
		dataBinder.registerBinding("entries.period", java.math.BigDecimal.class, this.prjTable, "period.text");
		dataBinder.registerBinding("entries.desc", String.class, this.prjTable, "desc.text");
		dataBinder.registerBinding("entries.project", com.kingdee.eas.fdc.basedata.CurProjectInfo.class, this.prjTable, "name.text");
		dataBinder.registerBinding("entries.programmingContract", com.kingdee.eas.fdc.contract.programming.ProgrammingContractInfo.class, this.prjTable, "programmingName.text");
		dataBinder.registerBinding("entries.project.longNumber", String.class, this.prjTable, "number.text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.fdc.invite.app.InviteProjectEditUIHandler";
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
        this.prmtestimatedAmt.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.fdc.invite.InviteProjectInfo)ov;
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
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inviteType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inviteForm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceMode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("invitePurchaseMode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("scalingRule", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("procurementType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("authorization", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pricingApproach", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purchaseAuthority", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purchaseCategory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("estimatedAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.programmingContract.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.issueDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.startDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.desc", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.project", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.programmingContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.project.longNumber", ValidateHelper.ON_SAVE);    		
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
     * output prmtInviteType_dataChanged method
     */
    protected void prmtInviteType_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output prmtInviteType_willShow method
     */
    protected void prmtInviteType_willShow(com.kingdee.bos.ctrl.swing.event.SelectorEvent e) throws Exception
    {
    }

    /**
     * output prmtPurchaseMode_dataChanged method
     */
    protected void prmtPurchaseMode_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output prjTable_editStopped method
     */
    protected void prjTable_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output prjTable_editStarting method
     */
    protected void prjTable_editStarting(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
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
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("inviteType.*"));
        sic.add(new SelectorItemInfo("inviteForm.*"));
        sic.add(new SelectorItemInfo("PriceMode"));
        sic.add(new SelectorItemInfo("invitePurchaseMode.*"));
        sic.add(new SelectorItemInfo("scalingRule.*"));
        sic.add(new SelectorItemInfo("procurementType"));
        sic.add(new SelectorItemInfo("authorization"));
        sic.add(new SelectorItemInfo("pricingApproach.*"));
        sic.add(new SelectorItemInfo("purchaseAuthority.*"));
        sic.add(new SelectorItemInfo("purchaseCategory.*"));
        sic.add(new SelectorItemInfo("estimatedAmt.*"));
    sic.add(new SelectorItemInfo("entries.id"));
        sic.add(new SelectorItemInfo("entries.*"));
//        sic.add(new SelectorItemInfo("entries.number"));
    sic.add(new SelectorItemInfo("entries.programmingContract.id"));
    sic.add(new SelectorItemInfo("entries.issueDate"));
    sic.add(new SelectorItemInfo("entries.startDate"));
    sic.add(new SelectorItemInfo("entries.period"));
    sic.add(new SelectorItemInfo("entries.desc"));
        sic.add(new SelectorItemInfo("entries.project.*"));
//        sic.add(new SelectorItemInfo("entries.project.number"));
        sic.add(new SelectorItemInfo("entries.programmingContract.*"));
//        sic.add(new SelectorItemInfo("entries.programmingContract.number"));
    sic.add(new SelectorItemInfo("entries.project.longNumber"));
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
     * output actionAddLine_actionPerformed method
     */
    public void actionAddLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddLine_actionPerformed(e);
    }
    	

    /**
     * output actionInsertLine_actionPerformed method
     */
    public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInsertLine_actionPerformed(e);
    }
    	

    /**
     * output actionRemoveLine_actionPerformed method
     */
    public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoveLine_actionPerformed(e);
    }
    	

    /**
     * output actionAddPlan_actionPerformed method
     */
    public void actionAddPlan_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionRemovePlan_actionPerformed method
     */
    public void actionRemovePlan_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionInsertPlan_actionPerformed method
     */
    public void actionInsertPlan_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionRelate_actionPerformed method
     */
    public void actionRelate_actionPerformed(ActionEvent e) throws Exception
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
	public RequestContext prepareActionAddLine(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionAddLine(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAddLine() {
    	return false;
    }
	public RequestContext prepareActionInsertLine(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionInsertLine(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionInsertLine() {
    	return false;
    }
	public RequestContext prepareActionRemoveLine(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionRemoveLine(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRemoveLine() {
    	return false;
    }
	public RequestContext prepareActionAddPlan(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAddPlan() {
    	return false;
    }
	public RequestContext prepareActionRemovePlan(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRemovePlan() {
    	return false;
    }
	public RequestContext prepareActionInsertPlan(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionInsertPlan() {
    	return false;
    }
	public RequestContext prepareActionRelate(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRelate() {
    	return false;
    }

    /**
     * output ActionAddPlan class
     */     
    protected class ActionAddPlan extends ItemAction {     
    
        public ActionAddPlan()
        {
            this(null);
        }

        public ActionAddPlan(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAddPlan.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAddPlan.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAddPlan.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractInviteProjectEditUI.this, "ActionAddPlan", "actionAddPlan_actionPerformed", e);
        }
    }

    /**
     * output ActionRemovePlan class
     */     
    protected class ActionRemovePlan extends ItemAction {     
    
        public ActionRemovePlan()
        {
            this(null);
        }

        public ActionRemovePlan(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionRemovePlan.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRemovePlan.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRemovePlan.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractInviteProjectEditUI.this, "ActionRemovePlan", "actionRemovePlan_actionPerformed", e);
        }
    }

    /**
     * output ActionInsertPlan class
     */     
    protected class ActionInsertPlan extends ItemAction {     
    
        public ActionInsertPlan()
        {
            this(null);
        }

        public ActionInsertPlan(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionInsertPlan.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionInsertPlan.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionInsertPlan.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractInviteProjectEditUI.this, "ActionInsertPlan", "actionInsertPlan_actionPerformed", e);
        }
    }

    /**
     * output ActionRelate class
     */     
    protected class ActionRelate extends ItemAction {     
    
        public ActionRelate()
        {
            this(null);
        }

        public ActionRelate(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionRelate.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRelate.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRelate.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractInviteProjectEditUI.this, "ActionRelate", "actionRelate_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.fdc.invite.client", "InviteProjectEditUI");
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
        return com.kingdee.eas.fdc.invite.client.InviteProjectEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.InviteProjectFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.InviteProjectInfo objectValue = new com.kingdee.eas.fdc.invite.InviteProjectInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }



    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return prjTable;
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