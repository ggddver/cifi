/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.subill.client;

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
public abstract class AbstractDesignSupplierAppraiseEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDesignSupplierAppraiseEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDesignTypeID;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditDate;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPusOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDesignTypeID;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuthorizedPer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDesignType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplierNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contServiceArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuthorizedTel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contJob;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplierName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contresults;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremake;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplierLv;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contInvTyep;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtAuthorizedPer;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDesignType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplierNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtServiceArea;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtAuthorizedTel;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtJob;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsupplierName;
    protected com.kingdee.bos.ctrl.swing.KDComboBox results;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneremake;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremake;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplierLv;
    protected com.kingdee.bos.ctrl.swing.KDComboBox state;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtInvTyep;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer1;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjtWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsybWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgoal;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtE2;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtE2_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtjtWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsybWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgoal;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtPusOrg;
    protected com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    public final static String STATUS_GROUP_SCORING = "GROUP_SCORING";
    /**
     * output class constructor
     */
    public AbstractDesignSupplierAppraiseEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDesignSupplierAppraiseEditUI.class.getName());
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
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "false");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "false");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDesignTypeID = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPusOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtDesignTypeID = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkauditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.contAuthorizedPer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDesignType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsupplierNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contServiceArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuthorizedTel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contJob = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsupplierName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contresults = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contremake = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsupplierLv = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contInvTyep = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtAuthorizedPer = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDesignType = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtsupplierNumber = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtServiceArea = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtAuthorizedTel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtJob = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsupplierName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.results = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.scrollPaneremake = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtremake = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.prmtsupplierLv = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.state = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtInvTyep = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDContainer1 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.kDContainer2 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.contjtWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsybWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgoal = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtE2 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtjtWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsybWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgoal = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtPusOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contDesignTypeID.setName("contDesignTypeID");
        this.contauditDate.setName("contauditDate");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.contOrg.setName("contOrg");
        this.contPusOrg.setName("contPusOrg");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.txtDesignTypeID.setName("txtDesignTypeID");
        this.pkauditDate.setName("pkauditDate");
        this.contAuthorizedPer.setName("contAuthorizedPer");
        this.contDesignType.setName("contDesignType");
        this.contNumber.setName("contNumber");
        this.contsupplierNumber.setName("contsupplierNumber");
        this.contServiceArea.setName("contServiceArea");
        this.contAuthorizedTel.setName("contAuthorizedTel");
        this.contBizDate.setName("contBizDate");
        this.contJob.setName("contJob");
        this.contsupplierName.setName("contsupplierName");
        this.contresults.setName("contresults");
        this.contremake.setName("contremake");
        this.contsupplierLv.setName("contsupplierLv");
        this.contstate.setName("contstate");
        this.contInvTyep.setName("contInvTyep");
        this.txtAuthorizedPer.setName("txtAuthorizedPer");
        this.txtDesignType.setName("txtDesignType");
        this.txtNumber.setName("txtNumber");
        this.prmtsupplierNumber.setName("prmtsupplierNumber");
        this.txtServiceArea.setName("txtServiceArea");
        this.txtAuthorizedTel.setName("txtAuthorizedTel");
        this.pkBizDate.setName("pkBizDate");
        this.txtJob.setName("txtJob");
        this.txtsupplierName.setName("txtsupplierName");
        this.results.setName("results");
        this.scrollPaneremake.setName("scrollPaneremake");
        this.txtremake.setName("txtremake");
        this.prmtsupplierLv.setName("prmtsupplierLv");
        this.state.setName("state");
        this.prmtInvTyep.setName("prmtInvTyep");
        this.kDContainer1.setName("kDContainer1");
        this.kDContainer2.setName("kDContainer2");
        this.contjtWeight.setName("contjtWeight");
        this.contsybWeight.setName("contsybWeight");
        this.contgoal.setName("contgoal");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtE2.setName("kdtE2");
        this.txtjtWeight.setName("txtjtWeight");
        this.txtsybWeight.setName("txtsybWeight");
        this.txtgoal.setName("txtgoal");
        this.prmtOrg.setName("prmtOrg");
        this.prmtPusOrg.setName("prmtPusOrg");
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
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // contDesignTypeID		
        this.contDesignTypeID.setBoundLabelText(resHelper.getString("contDesignTypeID.boundLabelText"));		
        this.contDesignTypeID.setBoundLabelLength(100);		
        this.contDesignTypeID.setBoundLabelUnderline(true);		
        this.contDesignTypeID.setVisible(true);
        // contauditDate		
        this.contauditDate.setBoundLabelText(resHelper.getString("contauditDate.boundLabelText"));		
        this.contauditDate.setBoundLabelLength(100);		
        this.contauditDate.setBoundLabelUnderline(true);		
        this.contauditDate.setVisible(true);
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(103,101,98)), resHelper.getString("kDPanel1.border.title")));
        // kDPanel2		
        this.kDPanel2.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel2.border.title")));
        // contOrg		
        this.contOrg.setBoundLabelText(resHelper.getString("contOrg.boundLabelText"));		
        this.contOrg.setBoundLabelLength(100);		
        this.contOrg.setBoundLabelUnderline(true);		
        this.contOrg.setVisible(true);
        // contPusOrg		
        this.contPusOrg.setBoundLabelText(resHelper.getString("contPusOrg.boundLabelText"));		
        this.contPusOrg.setBoundLabelLength(100);		
        this.contPusOrg.setBoundLabelUnderline(true);		
        this.contPusOrg.setVisible(true);
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
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // txtDesignTypeID		
        this.txtDesignTypeID.setHorizontalAlignment(2);		
        this.txtDesignTypeID.setMaxLength(100);		
        this.txtDesignTypeID.setRequired(false);
        // pkauditDate		
        this.pkauditDate.setRequired(false);
        // contAuthorizedPer		
        this.contAuthorizedPer.setBoundLabelText(resHelper.getString("contAuthorizedPer.boundLabelText"));		
        this.contAuthorizedPer.setBoundLabelLength(100);		
        this.contAuthorizedPer.setBoundLabelUnderline(true);		
        this.contAuthorizedPer.setVisible(true);
        // contDesignType		
        this.contDesignType.setBoundLabelText(resHelper.getString("contDesignType.boundLabelText"));		
        this.contDesignType.setBoundLabelLength(100);		
        this.contDesignType.setBoundLabelUnderline(true);		
        this.contDesignType.setVisible(true);
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // contsupplierNumber		
        this.contsupplierNumber.setBoundLabelText(resHelper.getString("contsupplierNumber.boundLabelText"));		
        this.contsupplierNumber.setBoundLabelLength(100);		
        this.contsupplierNumber.setBoundLabelUnderline(true);		
        this.contsupplierNumber.setVisible(true);
        // contServiceArea		
        this.contServiceArea.setBoundLabelText(resHelper.getString("contServiceArea.boundLabelText"));		
        this.contServiceArea.setBoundLabelLength(100);		
        this.contServiceArea.setBoundLabelUnderline(true);		
        this.contServiceArea.setVisible(true);
        // contAuthorizedTel		
        this.contAuthorizedTel.setBoundLabelText(resHelper.getString("contAuthorizedTel.boundLabelText"));		
        this.contAuthorizedTel.setBoundLabelLength(100);		
        this.contAuthorizedTel.setBoundLabelUnderline(true);		
        this.contAuthorizedTel.setVisible(true);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // contJob		
        this.contJob.setBoundLabelText(resHelper.getString("contJob.boundLabelText"));		
        this.contJob.setBoundLabelLength(100);		
        this.contJob.setBoundLabelUnderline(true);		
        this.contJob.setVisible(true);
        // contsupplierName		
        this.contsupplierName.setBoundLabelText(resHelper.getString("contsupplierName.boundLabelText"));		
        this.contsupplierName.setBoundLabelLength(100);		
        this.contsupplierName.setBoundLabelUnderline(true);		
        this.contsupplierName.setVisible(true);
        // contresults		
        this.contresults.setBoundLabelText(resHelper.getString("contresults.boundLabelText"));		
        this.contresults.setBoundLabelLength(100);		
        this.contresults.setBoundLabelUnderline(true);		
        this.contresults.setVisible(true);
        // contremake		
        this.contremake.setBoundLabelText(resHelper.getString("contremake.boundLabelText"));		
        this.contremake.setBoundLabelLength(16);		
        this.contremake.setBoundLabelUnderline(true);		
        this.contremake.setVisible(true);		
        this.contremake.setBoundLabelAlignment(8);
        // contsupplierLv		
        this.contsupplierLv.setBoundLabelText(resHelper.getString("contsupplierLv.boundLabelText"));		
        this.contsupplierLv.setBoundLabelLength(100);		
        this.contsupplierLv.setBoundLabelUnderline(true);		
        this.contsupplierLv.setVisible(true);
        // contstate		
        this.contstate.setBoundLabelText(resHelper.getString("contstate.boundLabelText"));		
        this.contstate.setBoundLabelLength(100);		
        this.contstate.setBoundLabelUnderline(true);		
        this.contstate.setVisible(true);
        // contInvTyep		
        this.contInvTyep.setBoundLabelText(resHelper.getString("contInvTyep.boundLabelText"));		
        this.contInvTyep.setBoundLabelLength(100);		
        this.contInvTyep.setBoundLabelUnderline(true);		
        this.contInvTyep.setVisible(true);
        // txtAuthorizedPer		
        this.txtAuthorizedPer.setHorizontalAlignment(2);		
        this.txtAuthorizedPer.setMaxLength(100);		
        this.txtAuthorizedPer.setRequired(false);
        // txtDesignType		
        this.txtDesignType.setHorizontalAlignment(2);		
        this.txtDesignType.setMaxLength(100);		
        this.txtDesignType.setRequired(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // prmtsupplierNumber		
        this.prmtsupplierNumber.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.app.DesignSupplierStockQuery");		
        this.prmtsupplierNumber.setEditable(true);		
        this.prmtsupplierNumber.setDisplayFormat("$number$");		
        this.prmtsupplierNumber.setEditFormat("$number$");		
        this.prmtsupplierNumber.setCommitFormat("$number$");		
        this.prmtsupplierNumber.setRequired(false);
        prmtsupplierNumber.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtsupplierNumber_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        this.prmtsupplierNumber.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtsupplierNumber_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtServiceArea		
        this.txtServiceArea.setHorizontalAlignment(2);		
        this.txtServiceArea.setMaxLength(100);		
        this.txtServiceArea.setRequired(false);
        // txtAuthorizedTel		
        this.txtAuthorizedTel.setHorizontalAlignment(2);		
        this.txtAuthorizedTel.setMaxLength(100);		
        this.txtAuthorizedTel.setRequired(false);
        // pkBizDate		
        this.pkBizDate.setEnabled(true);
        // txtJob		
        this.txtJob.setHorizontalAlignment(2);		
        this.txtJob.setMaxLength(100);		
        this.txtJob.setRequired(false);
        // txtsupplierName		
        this.txtsupplierName.setHorizontalAlignment(2);		
        this.txtsupplierName.setMaxLength(80);		
        this.txtsupplierName.setRequired(false);
        // results		
        this.results.addItems(EnumUtils.getEnumList("com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum").toArray());		
        this.results.setRequired(false);
        // scrollPaneremake
        // txtremake		
        this.txtremake.setRequired(false);		
        this.txtremake.setMaxLength(1000);
        // prmtsupplierLv		
        this.prmtsupplierLv.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.designbase.app.DesignGradeSetUpQuery");		
        this.prmtsupplierLv.setVisible(false);		
        this.prmtsupplierLv.setEditable(true);		
        this.prmtsupplierLv.setDisplayFormat("$name$");		
        this.prmtsupplierLv.setEditFormat("$number$");		
        this.prmtsupplierLv.setCommitFormat("$number$");		
        this.prmtsupplierLv.setRequired(false);
        // state		
        this.state.addItems(EnumUtils.getEnumList("com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum").toArray());		
        this.state.setRequired(false);
        // prmtInvTyep		
        this.prmtInvTyep.setQueryInfo("com.kingdee.eas.basedata.org.app.PurchaseItemQuery");		
        this.prmtInvTyep.setVisible(false);		
        this.prmtInvTyep.setEditable(true);		
        this.prmtInvTyep.setDisplayFormat("$name$");		
        this.prmtInvTyep.setEditFormat("$number$");		
        this.prmtInvTyep.setCommitFormat("$number$");		
        this.prmtInvTyep.setRequired(false);
        // kDContainer1		
        this.kDContainer1.setTitle(resHelper.getString("kDContainer1.title"));
        // kDContainer2		
        this.kDContainer2.setTitle(resHelper.getString("kDContainer2.title"));
        // contjtWeight		
        this.contjtWeight.setBoundLabelText(resHelper.getString("contjtWeight.boundLabelText"));		
        this.contjtWeight.setBoundLabelLength(100);		
        this.contjtWeight.setBoundLabelUnderline(true);		
        this.contjtWeight.setVisible(true);
        // contsybWeight		
        this.contsybWeight.setBoundLabelText(resHelper.getString("contsybWeight.boundLabelText"));		
        this.contsybWeight.setBoundLabelLength(100);		
        this.contsybWeight.setBoundLabelUnderline(true);		
        this.contsybWeight.setVisible(true);
        // contgoal		
        this.contgoal.setBoundLabelText(resHelper.getString("contgoal.boundLabelText"));		
        this.contgoal.setBoundLabelLength(100);		
        this.contgoal.setBoundLabelUnderline(true);		
        this.contgoal.setVisible(true);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" t:styleID=\"sCol0\" /><t:Column t:key=\"Weight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"caseDescription\" t:width=\"300\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"Score\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" t:styleID=\"sCol3\" /><t:Column t:key=\"Reviewers\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"ReviewersDep\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"remake\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:configured=\"false\"><t:Cell t:configured=\"false\">id</t:Cell><t:Cell t:configured=\"false\">权重%</t:Cell><t:Cell t:configured=\"false\">情况描述</t:Cell><t:Cell t:configured=\"false\">评分(百分制)</t:Cell><t:Cell t:configured=\"false\">评审人</t:Cell><t:Cell t:configured=\"false\">评审部门</t:Cell><t:Cell t:configured=\"false\">备注</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));
        this.kdtEntrys.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtEntrys.putBindContents("editData",new String[] {"id","Weight","caseDescription","Score","Reviewers","ReviewersDep","remake"});


        this.kdtEntrys.checkParsed();
        KDTextField kdtEntrys_Weight_TextField = new KDTextField();
        kdtEntrys_Weight_TextField.setName("kdtEntrys_Weight_TextField");
        kdtEntrys_Weight_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_Weight_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Weight_TextField);
        this.kdtEntrys.getColumn("Weight").setEditor(kdtEntrys_Weight_CellEditor);
        KDTextField kdtEntrys_caseDescription_TextField = new KDTextField();
        kdtEntrys_caseDescription_TextField.setName("kdtEntrys_caseDescription_TextField");
        kdtEntrys_caseDescription_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtEntrys_caseDescription_CellEditor = new KDTDefaultCellEditor(kdtEntrys_caseDescription_TextField);
        this.kdtEntrys.getColumn("caseDescription").setEditor(kdtEntrys_caseDescription_CellEditor);
        KDFormattedTextField kdtEntrys_Score_TextField = new KDFormattedTextField();
        kdtEntrys_Score_TextField.setName("kdtEntrys_Score_TextField");
        kdtEntrys_Score_TextField.setVisible(true);
        kdtEntrys_Score_TextField.setEditable(true);
        kdtEntrys_Score_TextField.setHorizontalAlignment(2);
        kdtEntrys_Score_TextField.setDataType(1);
        	kdtEntrys_Score_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_Score_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_Score_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_Score_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Score_TextField);
        this.kdtEntrys.getColumn("Score").setEditor(kdtEntrys_Score_CellEditor);
        final KDBizPromptBox kdtEntrys_Reviewers_PromptBox = new KDBizPromptBox();
        kdtEntrys_Reviewers_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtEntrys_Reviewers_PromptBox.setVisible(true);
        kdtEntrys_Reviewers_PromptBox.setEditable(true);
        kdtEntrys_Reviewers_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_Reviewers_PromptBox.setEditFormat("$number$");
        kdtEntrys_Reviewers_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_Reviewers_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Reviewers_PromptBox);
        this.kdtEntrys.getColumn("Reviewers").setEditor(kdtEntrys_Reviewers_CellEditor);
        ObjectValueRender kdtEntrys_Reviewers_OVR = new ObjectValueRender();
        kdtEntrys_Reviewers_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("Reviewers").setRenderer(kdtEntrys_Reviewers_OVR);
        final KDBizPromptBox kdtEntrys_ReviewersDep_PromptBox = new KDBizPromptBox();
        kdtEntrys_ReviewersDep_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_ReviewersDep_PromptBox.setVisible(true);
        kdtEntrys_ReviewersDep_PromptBox.setEditable(true);
        kdtEntrys_ReviewersDep_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_ReviewersDep_PromptBox.setEditFormat("$number$");
        kdtEntrys_ReviewersDep_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_ReviewersDep_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ReviewersDep_PromptBox);
        this.kdtEntrys.getColumn("ReviewersDep").setEditor(kdtEntrys_ReviewersDep_CellEditor);
        ObjectValueRender kdtEntrys_ReviewersDep_OVR = new ObjectValueRender();
        kdtEntrys_ReviewersDep_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("ReviewersDep").setRenderer(kdtEntrys_ReviewersDep_OVR);
        KDTextField kdtEntrys_remake_TextField = new KDTextField();
        kdtEntrys_remake_TextField.setName("kdtEntrys_remake_TextField");
        kdtEntrys_remake_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtEntrys_remake_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remake_TextField);
        this.kdtEntrys.getColumn("remake").setEditor(kdtEntrys_remake_CellEditor);
        // kdtE2
		String kdtE2StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" t:styleID=\"sCol0\" /><t:Column t:key=\"Weight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"caseDeisn\" t:width=\"300\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"Score\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" t:styleID=\"sCol3\" /><t:Column t:key=\"Reviewers\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"ReviewersDep\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"remake\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:configured=\"false\"><t:Cell t:configured=\"false\">单据分录序列号</t:Cell><t:Cell t:configured=\"false\">权重%</t:Cell><t:Cell t:configured=\"false\">情况描述</t:Cell><t:Cell t:configured=\"false\">评分(百分制)</t:Cell><t:Cell t:configured=\"false\">评审人</t:Cell><t:Cell t:configured=\"false\">评审部门</t:Cell><t:Cell t:configured=\"false\">备注</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtE2.setFormatXml(resHelper.translateString("kdtE2",kdtE2StrXML));
        this.kdtE2.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtE2_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtE2.putBindContents("editData",new String[] {"seq","Weight","caseDeisn","Score","Reviewers","ReviewersDep","remake"});


        this.kdtE2.checkParsed();
        KDTextField kdtE2_Weight_TextField = new KDTextField();
        kdtE2_Weight_TextField.setName("kdtE2_Weight_TextField");
        kdtE2_Weight_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtE2_Weight_CellEditor = new KDTDefaultCellEditor(kdtE2_Weight_TextField);
        this.kdtE2.getColumn("Weight").setEditor(kdtE2_Weight_CellEditor);
        KDTextField kdtE2_caseDeisn_TextField = new KDTextField();
        kdtE2_caseDeisn_TextField.setName("kdtE2_caseDeisn_TextField");
        kdtE2_caseDeisn_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtE2_caseDeisn_CellEditor = new KDTDefaultCellEditor(kdtE2_caseDeisn_TextField);
        this.kdtE2.getColumn("caseDeisn").setEditor(kdtE2_caseDeisn_CellEditor);
        KDFormattedTextField kdtE2_Score_TextField = new KDFormattedTextField();
        kdtE2_Score_TextField.setName("kdtE2_Score_TextField");
        kdtE2_Score_TextField.setVisible(true);
        kdtE2_Score_TextField.setEditable(true);
        kdtE2_Score_TextField.setHorizontalAlignment(2);
        kdtE2_Score_TextField.setDataType(1);
        	kdtE2_Score_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtE2_Score_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtE2_Score_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtE2_Score_CellEditor = new KDTDefaultCellEditor(kdtE2_Score_TextField);
        this.kdtE2.getColumn("Score").setEditor(kdtE2_Score_CellEditor);
        final KDBizPromptBox kdtE2_Reviewers_PromptBox = new KDBizPromptBox();
        kdtE2_Reviewers_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtE2_Reviewers_PromptBox.setVisible(true);
        kdtE2_Reviewers_PromptBox.setEditable(true);
        kdtE2_Reviewers_PromptBox.setDisplayFormat("$number$");
        kdtE2_Reviewers_PromptBox.setEditFormat("$number$");
        kdtE2_Reviewers_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtE2_Reviewers_CellEditor = new KDTDefaultCellEditor(kdtE2_Reviewers_PromptBox);
        this.kdtE2.getColumn("Reviewers").setEditor(kdtE2_Reviewers_CellEditor);
        ObjectValueRender kdtE2_Reviewers_OVR = new ObjectValueRender();
        kdtE2_Reviewers_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtE2.getColumn("Reviewers").setRenderer(kdtE2_Reviewers_OVR);
        final KDBizPromptBox kdtE2_ReviewersDep_PromptBox = new KDBizPromptBox();
        kdtE2_ReviewersDep_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtE2_ReviewersDep_PromptBox.setVisible(true);
        kdtE2_ReviewersDep_PromptBox.setEditable(true);
        kdtE2_ReviewersDep_PromptBox.setDisplayFormat("$number$");
        kdtE2_ReviewersDep_PromptBox.setEditFormat("$number$");
        kdtE2_ReviewersDep_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtE2_ReviewersDep_CellEditor = new KDTDefaultCellEditor(kdtE2_ReviewersDep_PromptBox);
        this.kdtE2.getColumn("ReviewersDep").setEditor(kdtE2_ReviewersDep_CellEditor);
        ObjectValueRender kdtE2_ReviewersDep_OVR = new ObjectValueRender();
        kdtE2_ReviewersDep_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtE2.getColumn("ReviewersDep").setRenderer(kdtE2_ReviewersDep_OVR);
        KDTextField kdtE2_remake_TextField = new KDTextField();
        kdtE2_remake_TextField.setName("kdtE2_remake_TextField");
        kdtE2_remake_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtE2_remake_CellEditor = new KDTDefaultCellEditor(kdtE2_remake_TextField);
        this.kdtE2.getColumn("remake").setEditor(kdtE2_remake_CellEditor);
        // txtjtWeight		
        this.txtjtWeight.setHorizontalAlignment(2);		
        this.txtjtWeight.setDataType(1);		
        this.txtjtWeight.setSupportedEmpty(true);		
        this.txtjtWeight.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtjtWeight.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtjtWeight.setPrecision(2);		
        this.txtjtWeight.setRequired(false);
        this.txtjtWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txtjtWeight_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        this.txtjtWeight.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtjtWeight_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtsybWeight		
        this.txtsybWeight.setHorizontalAlignment(2);		
        this.txtsybWeight.setDataType(1);		
        this.txtsybWeight.setSupportedEmpty(true);		
        this.txtsybWeight.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtsybWeight.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtsybWeight.setPrecision(2);		
        this.txtsybWeight.setRequired(false);
        this.txtsybWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txtsybWeight_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        this.txtsybWeight.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtsybWeight_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtgoal		
        this.txtgoal.setHorizontalAlignment(2);		
        this.txtgoal.setDataType(1);		
        this.txtgoal.setSupportedEmpty(true);		
        this.txtgoal.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtgoal.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtgoal.setPrecision(2);		
        this.txtgoal.setRequired(false);
        // prmtOrg		
        this.prmtOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.PurchaseItemQuery");		
        this.prmtOrg.setVisible(false);		
        this.prmtOrg.setEditable(true);		
        this.prmtOrg.setDisplayFormat("$name$");		
        this.prmtOrg.setEditFormat("$number$");		
        this.prmtOrg.setCommitFormat("$number$");		
        this.prmtOrg.setRequired(false);
        // prmtPusOrg		
        this.prmtPusOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.PurchaseItemQuery");		
        this.prmtPusOrg.setVisible(false);		
        this.prmtPusOrg.setEditable(true);		
        this.prmtPusOrg.setDisplayFormat("$name$");		
        this.prmtPusOrg.setEditFormat("$number$");		
        this.prmtPusOrg.setCommitFormat("$number$");		
        this.prmtPusOrg.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtsupplierNumber,txtsupplierName,txtDesignType,txtDesignTypeID,txtServiceArea,txtJob,txtAuthorizedPer,txtAuthorizedTel,txtremake,txtgoal,results,pkauditDate,state,prmtOrg,prmtInvTyep,prmtsupplierLv,txtsybWeight,txtjtWeight,txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,prmtPusOrg,kdtE2,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 629));
        contCreator.setBounds(new Rectangle(371, 571, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(371, 571, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(734, 571, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(734, 571, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(371, 596, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(371, 596, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(734, 596, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(734, 596, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(907, 608, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(907, 608, 270, 19, 0));
        contAuditor.setBounds(new Rectangle(8, 571, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(8, 571, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDesignTypeID.setBounds(new Rectangle(861, 609, 270, 19));
        this.add(contDesignTypeID, new KDLayout.Constraints(861, 609, 270, 19, 0));
        contauditDate.setBounds(new Rectangle(8, 596, 270, 19));
        this.add(contauditDate, new KDLayout.Constraints(8, 596, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel1.setBounds(new Rectangle(3, 4, 1008, 210));
        this.add(kDPanel1, new KDLayout.Constraints(3, 4, 1008, 210, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel2.setBounds(new Rectangle(3, 215, 1008, 352));
        this.add(kDPanel2, new KDLayout.Constraints(3, 215, 1008, 352, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contOrg.setBounds(new Rectangle(657, 59, 270, 19));
        this.add(contOrg, new KDLayout.Constraints(657, 59, 270, 19, 0));
        contPusOrg.setBounds(new Rectangle(656, 83, 270, 19));
        this.add(contPusOrg, new KDLayout.Constraints(656, 83, 270, 19, 0));
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(kDDateCreateTime);
        //contLastUpdateUser
        contLastUpdateUser.setBoundEditor(prmtLastUpdateUser);
        //contLastUpdateTime
        contLastUpdateTime.setBoundEditor(kDDateLastUpdateTime);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contDesignTypeID
        contDesignTypeID.setBoundEditor(txtDesignTypeID);
        //contauditDate
        contauditDate.setBoundEditor(pkauditDate);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(3, 4, 1008, 210));        contAuthorizedPer.setBounds(new Rectangle(23, 70, 270, 19));
        kDPanel1.add(contAuthorizedPer, new KDLayout.Constraints(23, 70, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDesignType.setBounds(new Rectangle(23, 44, 270, 19));
        kDPanel1.add(contDesignType, new KDLayout.Constraints(23, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(23, 18, 270, 19));
        kDPanel1.add(contNumber, new KDLayout.Constraints(23, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsupplierNumber.setBounds(new Rectangle(369, 18, 270, 19));
        kDPanel1.add(contsupplierNumber, new KDLayout.Constraints(369, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contServiceArea.setBounds(new Rectangle(369, 44, 270, 19));
        kDPanel1.add(contServiceArea, new KDLayout.Constraints(369, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuthorizedTel.setBounds(new Rectangle(369, 70, 270, 19));
        kDPanel1.add(contAuthorizedTel, new KDLayout.Constraints(369, 70, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(369, 97, 270, 19));
        kDPanel1.add(contBizDate, new KDLayout.Constraints(369, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contJob.setBounds(new Rectangle(716, 70, 270, 19));
        kDPanel1.add(contJob, new KDLayout.Constraints(716, 70, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsupplierName.setBounds(new Rectangle(716, 18, 270, 19));
        kDPanel1.add(contsupplierName, new KDLayout.Constraints(716, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contresults.setBounds(new Rectangle(23, 97, 270, 19));
        kDPanel1.add(contresults, new KDLayout.Constraints(23, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contremake.setBounds(new Rectangle(23, 117, 964, 79));
        kDPanel1.add(contremake, new KDLayout.Constraints(23, 117, 964, 79, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contsupplierLv.setBounds(new Rectangle(716, 44, 270, 19));
        kDPanel1.add(contsupplierLv, new KDLayout.Constraints(716, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstate.setBounds(new Rectangle(646, 14, 270, 19));
        kDPanel1.add(contstate, new KDLayout.Constraints(646, 14, 270, 19, 0));
        contInvTyep.setBounds(new Rectangle(650, 37, 270, 19));
        kDPanel1.add(contInvTyep, new KDLayout.Constraints(650, 37, 270, 19, 0));
        //contAuthorizedPer
        contAuthorizedPer.setBoundEditor(txtAuthorizedPer);
        //contDesignType
        contDesignType.setBoundEditor(txtDesignType);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contsupplierNumber
        contsupplierNumber.setBoundEditor(prmtsupplierNumber);
        //contServiceArea
        contServiceArea.setBoundEditor(txtServiceArea);
        //contAuthorizedTel
        contAuthorizedTel.setBoundEditor(txtAuthorizedTel);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contJob
        contJob.setBoundEditor(txtJob);
        //contsupplierName
        contsupplierName.setBoundEditor(txtsupplierName);
        //contresults
        contresults.setBoundEditor(results);
        //contremake
        contremake.setBoundEditor(scrollPaneremake);
        //scrollPaneremake
        scrollPaneremake.getViewport().add(txtremake, null);
        //contsupplierLv
        contsupplierLv.setBoundEditor(prmtsupplierLv);
        //contstate
        contstate.setBoundEditor(state);
        //contInvTyep
        contInvTyep.setBoundEditor(prmtInvTyep);
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(3, 215, 1008, 352));        kDContainer1.setBounds(new Rectangle(23, 39, 963, 144));
        kDPanel2.add(kDContainer1, new KDLayout.Constraints(23, 39, 963, 144, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDContainer2.setBounds(new Rectangle(23, 183, 963, 156));
        kDPanel2.add(kDContainer2, new KDLayout.Constraints(23, 183, 963, 156, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contjtWeight.setBounds(new Rectangle(332, 18, 270, 19));
        kDPanel2.add(contjtWeight, new KDLayout.Constraints(332, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsybWeight.setBounds(new Rectangle(637, 18, 270, 19));
        kDPanel2.add(contsybWeight, new KDLayout.Constraints(637, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contgoal.setBounds(new Rectangle(28, 18, 270, 19));
        kDPanel2.add(contgoal, new KDLayout.Constraints(28, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDContainer1
kDContainer1.getContentPane().setLayout(new BorderLayout(0, 0));        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseEntryInfo(),null,false);
        kDContainer1.getContentPane().add(kdtEntrys_detailPanel, BorderLayout.CENTER);
        //kDContainer2
kDContainer2.getContentPane().setLayout(new BorderLayout(0, 0));        kdtE2_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtE2,new com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseE2Info(),null,false);
        kDContainer2.getContentPane().add(kdtE2_detailPanel, BorderLayout.CENTER);
        //contjtWeight
        contjtWeight.setBoundEditor(txtjtWeight);
        //contsybWeight
        contsybWeight.setBoundEditor(txtsybWeight);
        //contgoal
        contgoal.setBoundEditor(txtgoal);
        //contOrg
        contOrg.setBoundEditor(prmtOrg);
        //contPusOrg
        contPusOrg.setBoundEditor(prmtPusOrg);

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


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("DesignTypeID", String.class, this.txtDesignTypeID, "text");
		dataBinder.registerBinding("auditDate", java.util.Date.class, this.pkauditDate, "value");
		dataBinder.registerBinding("AuthorizedPer", String.class, this.txtAuthorizedPer, "text");
		dataBinder.registerBinding("DesignType", String.class, this.txtDesignType, "text");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("supplierNumber", com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo.class, this.prmtsupplierNumber, "data");
		dataBinder.registerBinding("ServiceArea", String.class, this.txtServiceArea, "text");
		dataBinder.registerBinding("AuthorizedTel", String.class, this.txtAuthorizedTel, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("Job", String.class, this.txtJob, "text");
		dataBinder.registerBinding("supplierName", String.class, this.txtsupplierName, "text");
		dataBinder.registerBinding("results", com.kingdee.eas.fdc.invite.designsupplier.designbase.ResultsEnum.class, this.results, "selectedItem");
		dataBinder.registerBinding("remake", String.class, this.txtremake, "text");
		dataBinder.registerBinding("supplierLv", com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo.class, this.prmtsupplierLv, "data");
		dataBinder.registerBinding("state", com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum.class, this.state, "selectedItem");
		dataBinder.registerBinding("InvTyep", com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo.class, this.prmtInvTyep, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.Weight", String.class, this.kdtEntrys, "Weight.text");
		dataBinder.registerBinding("entrys.caseDescription", String.class, this.kdtEntrys, "caseDescription.text");
		dataBinder.registerBinding("entrys.Score", java.math.BigDecimal.class, this.kdtEntrys, "Score.text");
		dataBinder.registerBinding("entrys.Reviewers", java.lang.Object.class, this.kdtEntrys, "Reviewers.text");
		dataBinder.registerBinding("entrys.ReviewersDep", java.lang.Object.class, this.kdtEntrys, "ReviewersDep.text");
		dataBinder.registerBinding("entrys.remake", String.class, this.kdtEntrys, "remake.text");
		dataBinder.registerBinding("E2.seq", int.class, this.kdtE2, "seq.text");
		dataBinder.registerBinding("E2", com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseE2Info.class, this.kdtE2, "userObject");
		dataBinder.registerBinding("E2.Weight", String.class, this.kdtE2, "Weight.text");
		dataBinder.registerBinding("E2.caseDeisn", String.class, this.kdtE2, "caseDeisn.text");
		dataBinder.registerBinding("E2.Score", java.math.BigDecimal.class, this.kdtE2, "Score.text");
		dataBinder.registerBinding("E2.Reviewers", java.lang.Object.class, this.kdtE2, "Reviewers.text");
		dataBinder.registerBinding("E2.ReviewersDep", java.lang.Object.class, this.kdtE2, "ReviewersDep.text");
		dataBinder.registerBinding("E2.remake", String.class, this.kdtE2, "remake.text");
		dataBinder.registerBinding("jtWeight", java.math.BigDecimal.class, this.txtjtWeight, "value");
		dataBinder.registerBinding("sybWeight", java.math.BigDecimal.class, this.txtsybWeight, "value");
		dataBinder.registerBinding("goal", java.math.BigDecimal.class, this.txtgoal, "value");
		dataBinder.registerBinding("Org", com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo.class, this.prmtOrg, "data");
		dataBinder.registerBinding("PusOrg", com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo.class, this.prmtPusOrg, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.fdc.invite.designsupplier.subill.app.DesignSupplierAppraiseEditUIHandler";
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
        this.prmtsupplierNumber.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo)ov;
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
	 * ????????У??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DesignTypeID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AuthorizedPer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DesignType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplierNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ServiceArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AuthorizedTel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Job", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplierName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("results", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remake", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplierLv", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("state", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("InvTyep", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Weight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.caseDescription", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Score", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Reviewers", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ReviewersDep", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remake", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("E2.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("E2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("E2.Weight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("E2.caseDeisn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("E2.Score", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("E2.Reviewers", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("E2.ReviewersDep", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("E2.remake", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("jtWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sybWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("goal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Org", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PusOrg", ValidateHelper.ON_SAVE);    		
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
     * output prmtsupplierNumber_dataChanged method
     */
    protected void prmtsupplierNumber_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code heresssss
    }

    /**
     * output kdtEntrys_editStopped method
     */
    protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
        //write your code heressss
    }

    /**
     * output kdtE2_editStopped method
     */
    protected void kdtE2_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
        //write your code hereaaaa
    }

    /**
     * output txtjtWeight_actionPerformed method
     */
    protected void txtjtWeight_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code heresss
    }

    /**
     * output txtjtWeight_dataChanged method
     */
    protected void txtjtWeight_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code heresssa
    }

    /**
     * output txtsybWeight_actionPerformed method
     */
    protected void txtsybWeight_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code heredsss
    }

    /**
     * output txtsybWeight_dataChanged method
     */
    protected void txtsybWeight_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code hereasasas
    }


    /**
     * output prmtsupplierNumber_Changed() method
     */
    public void prmtsupplierNumber_Changed() throws Exception
    {
        System.out.println("prmtsupplierNumber_Changed() Function is executed!");
            txtsupplierName.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsupplierNumber.getData(),"name")));


    }
    /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
        sic.add(new SelectorItemInfo("creator.*"));
        sic.add(new SelectorItemInfo("createTime"));
        sic.add(new SelectorItemInfo("lastUpdateUser.*"));
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("auditor.*"));
        sic.add(new SelectorItemInfo("DesignTypeID"));
        sic.add(new SelectorItemInfo("auditDate"));
        sic.add(new SelectorItemInfo("AuthorizedPer"));
        sic.add(new SelectorItemInfo("DesignType"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("supplierNumber.*"));
        sic.add(new SelectorItemInfo("ServiceArea"));
        sic.add(new SelectorItemInfo("AuthorizedTel"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("Job"));
        sic.add(new SelectorItemInfo("supplierName"));
        sic.add(new SelectorItemInfo("results"));
        sic.add(new SelectorItemInfo("remake"));
        sic.add(new SelectorItemInfo("supplierLv.*"));
        sic.add(new SelectorItemInfo("state"));
        sic.add(new SelectorItemInfo("InvTyep.*"));
    sic.add(new SelectorItemInfo("entrys.id"));
        sic.add(new SelectorItemInfo("entrys.*"));
//        sic.add(new SelectorItemInfo("entrys.number"));
    sic.add(new SelectorItemInfo("entrys.Weight"));
    sic.add(new SelectorItemInfo("entrys.caseDescription"));
    sic.add(new SelectorItemInfo("entrys.Score"));
        sic.add(new SelectorItemInfo("entrys.Reviewers.*"));
//        sic.add(new SelectorItemInfo("entrys.Reviewers.number"));
        sic.add(new SelectorItemInfo("entrys.ReviewersDep.*"));
//        sic.add(new SelectorItemInfo("entrys.ReviewersDep.number"));
    sic.add(new SelectorItemInfo("entrys.remake"));
    sic.add(new SelectorItemInfo("E2.seq"));
        sic.add(new SelectorItemInfo("E2.*"));
//        sic.add(new SelectorItemInfo("E2.number"));
    sic.add(new SelectorItemInfo("E2.Weight"));
    sic.add(new SelectorItemInfo("E2.caseDeisn"));
    sic.add(new SelectorItemInfo("E2.Score"));
        sic.add(new SelectorItemInfo("E2.Reviewers.*"));
//        sic.add(new SelectorItemInfo("E2.Reviewers.number"));
        sic.add(new SelectorItemInfo("E2.ReviewersDep.*"));
//        sic.add(new SelectorItemInfo("E2.ReviewersDep.number"));
    sic.add(new SelectorItemInfo("E2.remake"));
        sic.add(new SelectorItemInfo("jtWeight"));
        sic.add(new SelectorItemInfo("sybWeight"));
        sic.add(new SelectorItemInfo("goal"));
        sic.add(new SelectorItemInfo("Org.*"));
        sic.add(new SelectorItemInfo("PusOrg.*"));
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
        com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractDesignSupplierAppraiseEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractDesignSupplierAppraiseEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.fdc.invite.designsupplier.subill.client", "DesignSupplierAppraiseEditUI");
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
        return com.kingdee.eas.fdc.invite.designsupplier.subill.client.DesignSupplierAppraiseEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.subill.DesignSupplierAppraiseInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/fdc/invite/designsupplier/subill/DesignSupplierAppraise";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.fdc.invite.designsupplier.subill.app.DesignSupplierAppraiseQuery");
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
		vo.put("results","10");
vo.put("state",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}