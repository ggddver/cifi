/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.designsupplier.demotion.client;

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
public abstract class AbstractDemotionEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDemotionEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDesignTypeID;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPro;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPusOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contIshg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplierTemple;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contInvTyep;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDesignTypeID;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuthorizedTel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuthorizedPer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contjob;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contServiceArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDesignType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplierName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplierNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contEvaluationType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremkae;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtAuthorizedTel;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtAuthorizedPer;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtjob;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtServiceArea;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDesignType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsupplierName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplierNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtEvaluationType;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneremkae;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremkae;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplierClas;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdemotionlastClas;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplierClas;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplierlastClas;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtPusOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtOrg;
    protected com.kingdee.bos.ctrl.swing.KDComboBox Ishg;
    protected com.kingdee.bos.ctrl.swing.KDComboBox state;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplierTemple;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtInvTyep;
    protected com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractDemotionEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDemotionEditUI.class.getName());
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
        this.contPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDContainer1 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.contPusOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contIshg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsupplierTemple = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contInvTyep = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtDesignTypeID = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkauditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtPro = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contAuthorizedTel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuthorizedPer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contjob = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contServiceArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDesignType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsupplierName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsupplierNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contEvaluationType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contremkae = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtAuthorizedTel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtAuthorizedPer = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtjob = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtServiceArea = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDesignType = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsupplierName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtsupplierNumber = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtEvaluationType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.scrollPaneremkae = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtremkae = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.contsupplierClas = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdemotionlastClas = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtsupplierClas = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsupplierlastClas = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtPusOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.Ishg = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.state = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtsupplierTemple = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtInvTyep = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contDesignTypeID.setName("contDesignTypeID");
        this.contauditDate.setName("contauditDate");
        this.contPro.setName("contPro");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDContainer1.setName("kDContainer1");
        this.contPusOrg.setName("contPusOrg");
        this.contOrg.setName("contOrg");
        this.contIshg.setName("contIshg");
        this.contstate.setName("contstate");
        this.contsupplierTemple.setName("contsupplierTemple");
        this.contInvTyep.setName("contInvTyep");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.txtDesignTypeID.setName("txtDesignTypeID");
        this.pkauditDate.setName("pkauditDate");
        this.prmtPro.setName("prmtPro");
        this.contAuthorizedTel.setName("contAuthorizedTel");
        this.contAuthorizedPer.setName("contAuthorizedPer");
        this.contjob.setName("contjob");
        this.contServiceArea.setName("contServiceArea");
        this.contDesignType.setName("contDesignType");
        this.contsupplierName.setName("contsupplierName");
        this.contsupplierNumber.setName("contsupplierNumber");
        this.contBizDate.setName("contBizDate");
        this.contNumber.setName("contNumber");
        this.contEvaluationType.setName("contEvaluationType");
        this.contremkae.setName("contremkae");
        this.txtAuthorizedTel.setName("txtAuthorizedTel");
        this.txtAuthorizedPer.setName("txtAuthorizedPer");
        this.txtjob.setName("txtjob");
        this.txtServiceArea.setName("txtServiceArea");
        this.txtDesignType.setName("txtDesignType");
        this.txtsupplierName.setName("txtsupplierName");
        this.prmtsupplierNumber.setName("prmtsupplierNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtNumber.setName("txtNumber");
        this.prmtEvaluationType.setName("prmtEvaluationType");
        this.scrollPaneremkae.setName("scrollPaneremkae");
        this.txtremkae.setName("txtremkae");
        this.contsupplierClas.setName("contsupplierClas");
        this.contdemotionlastClas.setName("contdemotionlastClas");
        this.prmtsupplierClas.setName("prmtsupplierClas");
        this.prmtsupplierlastClas.setName("prmtsupplierlastClas");
        this.kdtEntrys.setName("kdtEntrys");
        this.prmtPusOrg.setName("prmtPusOrg");
        this.prmtOrg.setName("prmtOrg");
        this.Ishg.setName("Ishg");
        this.state.setName("state");
        this.prmtsupplierTemple.setName("prmtsupplierTemple");
        this.prmtInvTyep.setName("prmtInvTyep");
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
        // contPro		
        this.contPro.setBoundLabelText(resHelper.getString("contPro.boundLabelText"));		
        this.contPro.setBoundLabelLength(100);		
        this.contPro.setBoundLabelUnderline(true);		
        this.contPro.setVisible(true);
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
        // kDPanel2		
        this.kDPanel2.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel2.border.title")));
        // kDContainer1		
        this.kDContainer1.setTitle(resHelper.getString("kDContainer1.title"));
        // contPusOrg		
        this.contPusOrg.setBoundLabelText(resHelper.getString("contPusOrg.boundLabelText"));		
        this.contPusOrg.setBoundLabelLength(100);		
        this.contPusOrg.setBoundLabelUnderline(true);		
        this.contPusOrg.setVisible(true);
        // contOrg		
        this.contOrg.setBoundLabelText(resHelper.getString("contOrg.boundLabelText"));		
        this.contOrg.setBoundLabelLength(100);		
        this.contOrg.setBoundLabelUnderline(true);		
        this.contOrg.setVisible(false);
        // contIshg		
        this.contIshg.setBoundLabelText(resHelper.getString("contIshg.boundLabelText"));		
        this.contIshg.setBoundLabelLength(100);		
        this.contIshg.setBoundLabelUnderline(true);		
        this.contIshg.setVisible(true);
        // contstate		
        this.contstate.setBoundLabelText(resHelper.getString("contstate.boundLabelText"));		
        this.contstate.setBoundLabelLength(100);		
        this.contstate.setBoundLabelUnderline(true);		
        this.contstate.setVisible(true);
        // contsupplierTemple		
        this.contsupplierTemple.setBoundLabelText(resHelper.getString("contsupplierTemple.boundLabelText"));		
        this.contsupplierTemple.setBoundLabelLength(100);		
        this.contsupplierTemple.setBoundLabelUnderline(true);		
        this.contsupplierTemple.setVisible(true);
        // contInvTyep		
        this.contInvTyep.setBoundLabelText(resHelper.getString("contInvTyep.boundLabelText"));		
        this.contInvTyep.setBoundLabelLength(100);		
        this.contInvTyep.setBoundLabelUnderline(true);		
        this.contInvTyep.setVisible(true);
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
        this.txtDesignTypeID.setVisible(false);
        // pkauditDate		
        this.pkauditDate.setRequired(false);
        // prmtPro		
        this.prmtPro.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.designbase.app.DesignGradeSetUpQuery");		
        this.prmtPro.setEditable(true);		
        this.prmtPro.setDisplayFormat("$name$");		
        this.prmtPro.setEditFormat("$number$");		
        this.prmtPro.setCommitFormat("$number$");		
        this.prmtPro.setRequired(false);
        // contAuthorizedTel		
        this.contAuthorizedTel.setBoundLabelText(resHelper.getString("contAuthorizedTel.boundLabelText"));		
        this.contAuthorizedTel.setBoundLabelLength(100);		
        this.contAuthorizedTel.setBoundLabelUnderline(true);		
        this.contAuthorizedTel.setVisible(true);
        // contAuthorizedPer		
        this.contAuthorizedPer.setBoundLabelText(resHelper.getString("contAuthorizedPer.boundLabelText"));		
        this.contAuthorizedPer.setBoundLabelLength(100);		
        this.contAuthorizedPer.setBoundLabelUnderline(true);		
        this.contAuthorizedPer.setVisible(true);
        // contjob		
        this.contjob.setBoundLabelText(resHelper.getString("contjob.boundLabelText"));		
        this.contjob.setBoundLabelLength(100);		
        this.contjob.setBoundLabelUnderline(true);		
        this.contjob.setVisible(true);
        // contServiceArea		
        this.contServiceArea.setBoundLabelText(resHelper.getString("contServiceArea.boundLabelText"));		
        this.contServiceArea.setBoundLabelLength(100);		
        this.contServiceArea.setBoundLabelUnderline(true);		
        this.contServiceArea.setVisible(true);
        // contDesignType		
        this.contDesignType.setBoundLabelText(resHelper.getString("contDesignType.boundLabelText"));		
        this.contDesignType.setBoundLabelLength(100);		
        this.contDesignType.setBoundLabelUnderline(true);		
        this.contDesignType.setVisible(true);
        // contsupplierName		
        this.contsupplierName.setBoundLabelText(resHelper.getString("contsupplierName.boundLabelText"));		
        this.contsupplierName.setBoundLabelLength(100);		
        this.contsupplierName.setBoundLabelUnderline(true);		
        this.contsupplierName.setVisible(true);
        // contsupplierNumber		
        this.contsupplierNumber.setBoundLabelText(resHelper.getString("contsupplierNumber.boundLabelText"));		
        this.contsupplierNumber.setBoundLabelLength(100);		
        this.contsupplierNumber.setBoundLabelUnderline(true);		
        this.contsupplierNumber.setVisible(true);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // contEvaluationType		
        this.contEvaluationType.setBoundLabelText(resHelper.getString("contEvaluationType.boundLabelText"));		
        this.contEvaluationType.setBoundLabelLength(100);		
        this.contEvaluationType.setBoundLabelUnderline(true);		
        this.contEvaluationType.setVisible(true);
        // contremkae		
        this.contremkae.setBoundLabelText(resHelper.getString("contremkae.boundLabelText"));		
        this.contremkae.setBoundLabelLength(16);		
        this.contremkae.setBoundLabelUnderline(true);		
        this.contremkae.setVisible(true);		
        this.contremkae.setBoundLabelAlignment(8);
        // txtAuthorizedTel		
        this.txtAuthorizedTel.setHorizontalAlignment(2);		
        this.txtAuthorizedTel.setMaxLength(100);		
        this.txtAuthorizedTel.setRequired(false);
        // txtAuthorizedPer		
        this.txtAuthorizedPer.setHorizontalAlignment(2);		
        this.txtAuthorizedPer.setMaxLength(100);		
        this.txtAuthorizedPer.setRequired(false);
        // txtjob		
        this.txtjob.setHorizontalAlignment(2);		
        this.txtjob.setMaxLength(100);		
        this.txtjob.setRequired(false);
        // txtServiceArea		
        this.txtServiceArea.setHorizontalAlignment(2);		
        this.txtServiceArea.setMaxLength(100);		
        this.txtServiceArea.setRequired(false);
        // txtDesignType		
        this.txtDesignType.setHorizontalAlignment(2);		
        this.txtDesignType.setMaxLength(100);		
        this.txtDesignType.setRequired(false);
        // txtsupplierName		
        this.txtsupplierName.setHorizontalAlignment(2);		
        this.txtsupplierName.setMaxLength(100);		
        this.txtsupplierName.setRequired(false);
        // prmtsupplierNumber		
        this.prmtsupplierNumber.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.app.DesignSupplierStockQuery");		
        this.prmtsupplierNumber.setEditable(true);		
        this.prmtsupplierNumber.setDisplayFormat("$number$");		
        this.prmtsupplierNumber.setEditFormat("$number$");		
        this.prmtsupplierNumber.setCommitFormat("$number$");		
        this.prmtsupplierNumber.setRequired(false);
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
        // pkBizDate		
        this.pkBizDate.setEnabled(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // prmtEvaluationType		
        this.prmtEvaluationType.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.designbase.app.DesignAccreditationTypeQuery");		
        this.prmtEvaluationType.setEditable(true);		
        this.prmtEvaluationType.setDisplayFormat("$name$");		
        this.prmtEvaluationType.setEditFormat("$number$");		
        this.prmtEvaluationType.setCommitFormat("$number$");		
        this.prmtEvaluationType.setRequired(false);
        this.prmtEvaluationType.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtEvaluationType_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // scrollPaneremkae
        // txtremkae		
        this.txtremkae.setRequired(false);		
        this.txtremkae.setMaxLength(1000);
        // contsupplierClas		
        this.contsupplierClas.setBoundLabelText(resHelper.getString("contsupplierClas.boundLabelText"));		
        this.contsupplierClas.setBoundLabelLength(100);		
        this.contsupplierClas.setBoundLabelUnderline(true);		
        this.contsupplierClas.setVisible(true);
        // contdemotionlastClas		
        this.contdemotionlastClas.setBoundLabelText(resHelper.getString("contdemotionlastClas.boundLabelText"));		
        this.contdemotionlastClas.setBoundLabelLength(100);		
        this.contdemotionlastClas.setBoundLabelUnderline(true);		
        this.contdemotionlastClas.setVisible(true);
        // prmtsupplierClas		
        this.prmtsupplierClas.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.designbase.app.DesignGradeSetUpQuery");		
        this.prmtsupplierClas.setEditable(true);		
        this.prmtsupplierClas.setDisplayFormat("$name$");		
        this.prmtsupplierClas.setEditFormat("$number$");		
        this.prmtsupplierClas.setCommitFormat("$number$");		
        this.prmtsupplierClas.setRequired(false);
        // prmtsupplierlastClas		
        this.prmtsupplierlastClas.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.designbase.app.DesignGradeSetUpQuery");		
        this.prmtsupplierlastClas.setEditable(true);		
        this.prmtsupplierlastClas.setDisplayFormat("$name$");		
        this.prmtsupplierlastClas.setEditFormat("$number$");		
        this.prmtsupplierlastClas.setCommitFormat("$number$");		
        this.prmtsupplierlastClas.setRequired(false);
        this.prmtsupplierlastClas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent e) {
                try {
                    prmtsupplierlastClas_stateChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"Review\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"IndexName\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"IsQualified\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"Casedescription\" t:width=\"300\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{Review}</t:Cell><t:Cell>$Resource{IndexName}</t:Cell><t:Cell>$Resource{IsQualified}</t:Cell><t:Cell>$Resource{Casedescription}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));
        this.kdtEntrys.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopping(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStopping(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

        

        this.kdtEntrys.checkParsed();
        // prmtPusOrg		
        this.prmtPusOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.PurchaseItemQuery");		
        this.prmtPusOrg.setVisible(false);		
        this.prmtPusOrg.setEditable(true);		
        this.prmtPusOrg.setDisplayFormat("$name$");		
        this.prmtPusOrg.setEditFormat("$number$");		
        this.prmtPusOrg.setCommitFormat("$number$");		
        this.prmtPusOrg.setRequired(false);
        // prmtOrg		
        this.prmtOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.PurchaseItemQuery");		
        this.prmtOrg.setEditable(true);		
        this.prmtOrg.setDisplayFormat("$name$");		
        this.prmtOrg.setEditFormat("$number$");		
        this.prmtOrg.setCommitFormat("$number$");		
        this.prmtOrg.setRequired(false);		
        this.prmtOrg.setVisible(false);
        // Ishg		
        this.Ishg.addItems(EnumUtils.getEnumList("com.kingdee.eas.fdc.invite.supplier.IsGradeEnum").toArray());		
        this.Ishg.setRequired(false);
        // state		
        this.state.addItems(EnumUtils.getEnumList("com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum").toArray());		
        this.state.setRequired(false);		
        this.state.setVisible(false);
        // prmtsupplierTemple		
        this.prmtsupplierTemple.setQueryInfo("com.kingdee.eas.fdc.invite.designsupplier.designbase.app.DesignAppraiseTemplateQuery");		
        this.prmtsupplierTemple.setEditable(true);		
        this.prmtsupplierTemple.setDisplayFormat("$name$");		
        this.prmtsupplierTemple.setEditFormat("$number$");		
        this.prmtsupplierTemple.setCommitFormat("$number$");		
        this.prmtsupplierTemple.setRequired(false);
        		prmtsupplierTemple.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.fdc.invite.designsupplier.designbase.client.DesignAppraiseTemplateListUI prmtsupplierTemple_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtsupplierTemple_F7ListUI == null) {
					try {
						prmtsupplierTemple_F7ListUI = new com.kingdee.eas.fdc.invite.designsupplier.designbase.client.DesignAppraiseTemplateListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtsupplierTemple_F7ListUI));
					prmtsupplierTemple_F7ListUI.setF7Use(true,ctx);
					prmtsupplierTemple.setSelector(prmtsupplierTemple_F7ListUI);
				}
			}
		});
					
        this.prmtsupplierTemple.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtsupplierTemple_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtInvTyep		
        this.prmtInvTyep.setQueryInfo("com.kingdee.eas.basedata.org.app.PurchaseItemQuery");		
        this.prmtInvTyep.setEditable(true);		
        this.prmtInvTyep.setDisplayFormat("$name$");		
        this.prmtInvTyep.setEditFormat("$number$");		
        this.prmtInvTyep.setCommitFormat("$number$");		
        this.prmtInvTyep.setRequired(false);		
        this.prmtInvTyep.setVisible(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtsupplierNumber,txtsupplierName,txtDesignType,txtDesignTypeID,txtServiceArea,txtjob,txtAuthorizedPer,txtAuthorizedTel,prmtEvaluationType,prmtsupplierTemple,pkauditDate,txtremkae,prmtPro,prmtsupplierClas,prmtsupplierlastClas,Ishg,state,prmtOrg,prmtInvTyep,txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,prmtPusOrg,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1025, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1025, 629));
        contCreator.setBounds(new Rectangle(372, 576, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(372, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(718, 576, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(718, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(372, 601, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(372, 601, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(719, 599, 273, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(719, 599, 273, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(769, 633, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(769, 633, 270, 19, 0));
        contAuditor.setBounds(new Rectangle(4, 576, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(4, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDesignTypeID.setBounds(new Rectangle(1055, 395, 50, 19));
        this.add(contDesignTypeID, new KDLayout.Constraints(1055, 395, 50, 19, 0));
        contauditDate.setBounds(new Rectangle(4, 601, 270, 19));
        this.add(contauditDate, new KDLayout.Constraints(4, 601, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contPro.setBounds(new Rectangle(747, 668, 270, 19));
        this.add(contPro, new KDLayout.Constraints(747, 668, 270, 19, 0));
        kDPanel1.setBounds(new Rectangle(3, 3, 1013, 206));
        this.add(kDPanel1, new KDLayout.Constraints(3, 3, 1013, 206, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel2.setBounds(new Rectangle(3, 210, 1012, 59));
        this.add(kDPanel2, new KDLayout.Constraints(3, 210, 1012, 59, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDContainer1.setBounds(new Rectangle(3, 270, 1009, 301));
        this.add(kDContainer1, new KDLayout.Constraints(3, 270, 1009, 301, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contPusOrg.setBounds(new Rectangle(1092, 136, 59, 19));
        this.add(contPusOrg, new KDLayout.Constraints(1092, 136, 59, 19, 0));
        contOrg.setBounds(new Rectangle(1096, 50, 47, 19));
        this.add(contOrg, new KDLayout.Constraints(1096, 50, 47, 19, 0));
        contIshg.setBounds(new Rectangle(1095, 90, 57, 19));
        this.add(contIshg, new KDLayout.Constraints(1095, 90, 57, 19, 0));
        contstate.setBounds(new Rectangle(1111, 195, 45, 19));
        this.add(contstate, new KDLayout.Constraints(1111, 195, 45, 19, 0));
        contsupplierTemple.setBounds(new Rectangle(1083, 258, 65, 19));
        this.add(contsupplierTemple, new KDLayout.Constraints(1083, 258, 65, 19, 0));
        contInvTyep.setBounds(new Rectangle(1042, 323, 90, 19));
        this.add(contInvTyep, new KDLayout.Constraints(1042, 323, 90, 19, 0));
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
        //contPro
        contPro.setBoundEditor(prmtPro);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(3, 3, 1013, 206));        contAuthorizedTel.setBounds(new Rectangle(369, 69, 270, 19));
        kDPanel1.add(contAuthorizedTel, new KDLayout.Constraints(369, 69, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuthorizedPer.setBounds(new Rectangle(16, 69, 270, 19));
        kDPanel1.add(contAuthorizedPer, new KDLayout.Constraints(16, 69, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contjob.setBounds(new Rectangle(723, 69, 270, 19));
        kDPanel1.add(contjob, new KDLayout.Constraints(723, 69, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contServiceArea.setBounds(new Rectangle(369, 43, 270, 19));
        kDPanel1.add(contServiceArea, new KDLayout.Constraints(369, 43, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDesignType.setBounds(new Rectangle(16, 43, 270, 19));
        kDPanel1.add(contDesignType, new KDLayout.Constraints(16, 43, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsupplierName.setBounds(new Rectangle(719, 20, 270, 19));
        kDPanel1.add(contsupplierName, new KDLayout.Constraints(719, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsupplierNumber.setBounds(new Rectangle(369, 17, 270, 19));
        kDPanel1.add(contsupplierNumber, new KDLayout.Constraints(369, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(723, 43, 270, 19));
        kDPanel1.add(contBizDate, new KDLayout.Constraints(723, 43, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(16, 17, 270, 19));
        kDPanel1.add(contNumber, new KDLayout.Constraints(16, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contEvaluationType.setBounds(new Rectangle(16, 95, 270, 19));
        kDPanel1.add(contEvaluationType, new KDLayout.Constraints(16, 95, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contremkae.setBounds(new Rectangle(16, 116, 978, 74));
        kDPanel1.add(contremkae, new KDLayout.Constraints(16, 116, 978, 74, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contAuthorizedTel
        contAuthorizedTel.setBoundEditor(txtAuthorizedTel);
        //contAuthorizedPer
        contAuthorizedPer.setBoundEditor(txtAuthorizedPer);
        //contjob
        contjob.setBoundEditor(txtjob);
        //contServiceArea
        contServiceArea.setBoundEditor(txtServiceArea);
        //contDesignType
        contDesignType.setBoundEditor(txtDesignType);
        //contsupplierName
        contsupplierName.setBoundEditor(txtsupplierName);
        //contsupplierNumber
        contsupplierNumber.setBoundEditor(prmtsupplierNumber);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contEvaluationType
        contEvaluationType.setBoundEditor(prmtEvaluationType);
        //contremkae
        contremkae.setBoundEditor(scrollPaneremkae);
        //scrollPaneremkae
        scrollPaneremkae.getViewport().add(txtremkae, null);
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(3, 210, 1012, 59));        contsupplierClas.setBounds(new Rectangle(20, 19, 270, 19));
        kDPanel2.add(contsupplierClas, new KDLayout.Constraints(20, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdemotionlastClas.setBounds(new Rectangle(670, 16, 270, 19));
        kDPanel2.add(contdemotionlastClas, new KDLayout.Constraints(670, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contsupplierClas
        contsupplierClas.setBoundEditor(prmtsupplierClas);
        //contdemotionlastClas
        contdemotionlastClas.setBoundEditor(prmtsupplierlastClas);
        //kDContainer1
kDContainer1.getContentPane().setLayout(new BorderLayout(0, 0));        kDContainer1.getContentPane().add(kdtEntrys, BorderLayout.CENTER);
        //contPusOrg
        contPusOrg.setBoundEditor(prmtPusOrg);
        //contOrg
        contOrg.setBoundEditor(prmtOrg);
        //contIshg
        contIshg.setBoundEditor(Ishg);
        //contstate
        contstate.setBoundEditor(state);
        //contsupplierTemple
        contsupplierTemple.setBoundEditor(prmtsupplierTemple);
        //contInvTyep
        contInvTyep.setBoundEditor(prmtInvTyep);

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
		dataBinder.registerBinding("Pro", com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo.class, this.prmtPro, "data");
		dataBinder.registerBinding("AuthorizedTel", String.class, this.txtAuthorizedTel, "text");
		dataBinder.registerBinding("AuthorizedPer", String.class, this.txtAuthorizedPer, "text");
		dataBinder.registerBinding("job", String.class, this.txtjob, "text");
		dataBinder.registerBinding("ServiceArea", String.class, this.txtServiceArea, "text");
		dataBinder.registerBinding("DesignType", String.class, this.txtDesignType, "text");
		dataBinder.registerBinding("supplierName", String.class, this.txtsupplierName, "text");
		dataBinder.registerBinding("supplierNumber", com.kingdee.eas.fdc.invite.designsupplier.DesignSupplierStockInfo.class, this.prmtsupplierNumber, "data");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("EvaluationType", com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAccreditationTypeInfo.class, this.prmtEvaluationType, "data");
		dataBinder.registerBinding("remkae", String.class, this.txtremkae, "text");
		dataBinder.registerBinding("supplierClas", com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo.class, this.prmtsupplierClas, "data");
		dataBinder.registerBinding("supplierlastClas", com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignGradeSetUpInfo.class, this.prmtsupplierlastClas, "data");
		dataBinder.registerBinding("PusOrg", com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo.class, this.prmtPusOrg, "data");
		dataBinder.registerBinding("Org", com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo.class, this.prmtOrg, "data");
		dataBinder.registerBinding("Ishg", com.kingdee.eas.fdc.invite.supplier.IsGradeEnum.class, this.Ishg, "selectedItem");
		dataBinder.registerBinding("state", com.kingdee.eas.fdc.invite.supplier.SupplierStateEnum.class, this.state, "selectedItem");
		dataBinder.registerBinding("supplierTemple", com.kingdee.eas.fdc.invite.designsupplier.designbase.DesignAppraiseTemplateInfo.class, this.prmtsupplierTemple, "data");
		dataBinder.registerBinding("InvTyep", com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo.class, this.prmtInvTyep, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.fdc.invite.designsupplier.demotion.app.DemotionEditUIHandler";
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
        this.editData = (com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionInfo)ov;
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
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DesignTypeID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Pro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AuthorizedTel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AuthorizedPer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("job", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ServiceArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DesignType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplierName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplierNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EvaluationType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remkae", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplierClas", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplierlastClas", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PusOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Org", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Ishg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("state", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplierTemple", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("InvTyep", ValidateHelper.ON_SAVE);    		
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
        //write your code heresss
    }

    /**
     * output prmtEvaluationType_dataChanged method
     */
    protected void prmtEvaluationType_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code heresss
    }

    /**
     * output prmtsupplierlastClas_stateChanged method
     */
    protected void prmtsupplierlastClas_stateChanged(javax.swing.event.ChangeEvent e) throws Exception
    {
        //write your code heressss
    }

    /**
     * output kdtEntrys_editStopping method
     */
    protected void kdtEntrys_editStopping(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output kdtEntrys_editStopped method
     */
    protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
        //write your code heressss
    }

    /**
     * output prmtsupplierTemple_dataChanged method
     */
    protected void prmtsupplierTemple_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code heresss
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
        sic.add(new SelectorItemInfo("Pro.*"));
        sic.add(new SelectorItemInfo("AuthorizedTel"));
        sic.add(new SelectorItemInfo("AuthorizedPer"));
        sic.add(new SelectorItemInfo("job"));
        sic.add(new SelectorItemInfo("ServiceArea"));
        sic.add(new SelectorItemInfo("DesignType"));
        sic.add(new SelectorItemInfo("supplierName"));
        sic.add(new SelectorItemInfo("supplierNumber.*"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("EvaluationType.*"));
        sic.add(new SelectorItemInfo("remkae"));
        sic.add(new SelectorItemInfo("supplierClas.*"));
        sic.add(new SelectorItemInfo("supplierlastClas.*"));
        sic.add(new SelectorItemInfo("PusOrg.*"));
        sic.add(new SelectorItemInfo("Org.*"));
        sic.add(new SelectorItemInfo("Ishg"));
        sic.add(new SelectorItemInfo("state"));
        sic.add(new SelectorItemInfo("supplierTemple.*"));
        sic.add(new SelectorItemInfo("InvTyep.*"));
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
        com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractDemotionEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractDemotionEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.fdc.invite.designsupplier.demotion.client", "DemotionEditUI");
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
        return com.kingdee.eas.fdc.invite.designsupplier.demotion.client.DemotionEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionInfo objectValue = new com.kingdee.eas.fdc.invite.designsupplier.demotion.DemotionInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/fdc/invite/designsupplier/demotion/Demotion";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.fdc.invite.designsupplier.demotion.app.DemotionQuery");
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
		vo.put("Ishg",new Integer(1));
vo.put("state",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}