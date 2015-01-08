/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.markesupplier.client;

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
public abstract class AbstractSelectContractUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSelectContractUI.class);
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnOk;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnCancel;
    protected com.kingdee.bos.ctrl.swing.KDButton btnQuery;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDTextField kDTextField1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.bos.ctrl.swing.KDComboBox kDComboBox1;
    protected EntityViewInfo queryF7ContractBillQuery = null;
    protected IMetaDataPK queryF7ContractBillQueryPK;
    /**
     * output class constructor
     */
    public AbstractSelectContractUI() throws Exception
    {
        super();
        this.defaultObjectName = "queryF7ContractBillQuery";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractSelectContractUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        queryF7ContractBillQueryPK = new MetaDataPK("com.kingdee.eas.fdc.invite.markesupplier.app", "F7ContractBillQuery");
        this.kDContainer1 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.btnOk = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnCancel = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnQuery = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTextField1 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDComboBox1 = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDContainer1.setName("kDContainer1");
        this.btnOk.setName("btnOk");
        this.btnCancel.setName("btnCancel");
        this.btnQuery.setName("btnQuery");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDTextField1.setName("kDTextField1");
        this.kDTable1.setName("kDTable1");
        this.kDComboBox1.setName("kDComboBox1");
        // CoreUI
        // kDContainer1		
        this.kDContainer1.setTitle(resHelper.getString("kDContainer1.title"));
        // btnOk		
        this.btnOk.setText(resHelper.getString("btnOk.text"));
        this.btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnOk_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnCancel		
        this.btnCancel.setText(resHelper.getString("btnCancel.text"));
        this.btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnCancel_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnQuery		
        this.btnQuery.setText(resHelper.getString("btnQuery.text"));
        this.btnQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnQuery_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));
        // kDTextField1
        // kDTable1
		String kDTable1StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol12\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol15\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"name\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"contractType.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"partB.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"curProject.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"signDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"respDept.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"respPerson.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"state\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"hasSettled\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"curProject.id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" t:styleID=\"sCol12\" /><t:Column t:key=\"curProject.isEnabled\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"isAmtWithoutCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" /><t:Column t:key=\"contractType.longNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:configured=\"false\" t:styleID=\"sCol15\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:configured=\"false\"><t:Cell t:configured=\"false\">ID</t:Cell><t:Cell t:configured=\"false\">合同编码</t:Cell><t:Cell t:configured=\"false\">合同名称</t:Cell><t:Cell t:configured=\"false\">合同类型</t:Cell><t:Cell t:configured=\"false\">签约乙方</t:Cell><t:Cell t:configured=\"false\">工程项目</t:Cell><t:Cell t:configured=\"false\">签约日期</t:Cell><t:Cell t:configured=\"false\">责任部门</t:Cell><t:Cell t:configured=\"false\">责任人</t:Cell><t:Cell t:configured=\"false\">单据状态</t:Cell><t:Cell t:configured=\"false\">是否结算</t:Cell><t:Cell t:configured=\"false\">合同金额</t:Cell><t:Cell t:configured=\"false\">ID</t:Cell><t:Cell t:configured=\"false\">启用</t:Cell><t:Cell t:configured=\"false\">是否不计成本的金额</t:Cell><t:Cell t:configured=\"false\">长编码</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable1.setFormatXml(resHelper.translateString("kDTable1",kDTable1StrXML));
        this.kDTable1.addKDTMouseListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener() {
            public void tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) {
                try {
                    kDTable1_tableClicked(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
                this.kDTable1.putBindContents("queryF7ContractBillQuery",new String[] {"id","number","name","contractType.name","partB.name","curProject.name","signDate","respDept.name","respPerson.name","state","hasSettled","amount","curProject.id","curProject.isEnabled","isAmtWithoutCost","contractType.longNumber"});

        this.kDTable1.addRequestRowSetListener(new RequestRowSetListener() {
            public void doRequestRowSet(RequestRowSetEvent e) {
                kDTable1_doRequestRowSet(e);
            }
        });

        // kDComboBox1
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
        this.setBounds(new Rectangle(10, 10, 750, 400));
        this.setLayout(null);
        kDContainer1.setBounds(new Rectangle(6, 30, 735, 332));
        this.add(kDContainer1, null);
        btnOk.setBounds(new Rectangle(488, 370, 81, 19));
        this.add(btnOk, null);
        btnCancel.setBounds(new Rectangle(588, 370, 81, 19));
        this.add(btnCancel, null);
        btnQuery.setBounds(new Rectangle(469, 4, 73, 21));
        this.add(btnQuery, null);
        kDLabelContainer1.setBounds(new Rectangle(8, 6, 185, 19));
        this.add(kDLabelContainer1, null);
        kDTextField1.setBounds(new Rectangle(202, 6, 262, 19));
        this.add(kDTextField1, null);
        //kDContainer1
kDContainer1.getContentPane().setLayout(new BorderLayout(0, 0));        kDContainer1.getContentPane().add(kDTable1, BorderLayout.CENTER);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(kDComboBox1);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {
        this.menuBar.add(menuFile);
        this.menuBar.add(menuTool);
        this.menuBar.add(MenuService);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemPageSetup);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemExitCurrent);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
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
        this.toolBar.add(btnPageSetup);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.fdc.invite.markesupplier.app.SelectContractUIHandler";
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
        this.queryF7ContractBillQuery = (EntityViewInfo)ov;
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        dataBinder.loadFields();
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
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
    }

    /**
     * output btnOk_actionPerformed method
     */
    protected void btnOk_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here1
    }

    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here11
    }

    /**
     * output btnQuery_actionPerformed method
     */
    protected void btnQuery_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here1
    }

    /**
     * output kDTable1_tableClicked method
     */
    protected void kDTable1_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        //write your code here1
    }

    /**
     * output kDTable1_doRequestRowSet method
     */
    protected void kDTable1_doRequestRowSet(RequestRowSetEvent e)
    {
        if (this.queryF7ContractBillQuery != null) {
            int start = ((Integer)e.getParam1()).intValue();
            int length = ((Integer)e.getParam2()).intValue() - start + 1;
            try {
                IQueryExecutor exec = this.getQueryExecutor(this.queryF7ContractBillQueryPK, this.queryF7ContractBillQuery);
                IRowSet rowSet = exec.executeQuery(start,length);
                e.setRowSet(rowSet);
                onGetRowSet(rowSet);
            } catch (Exception ee) {
                handUIException(ee);
            }
        }
    }


    /**
     * output getQueryExecutor method
     */
    protected IQueryExecutor getQueryExecutor(IMetaDataPK queryPK,EntityViewInfo viewInfo)
    {
        IQueryExecutor exec = QueryExecutorFactory.getRemoteInstance(queryPK);
        exec.setObjectView(viewInfo);
        return exec;
    }
    /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
        sic.add(new SelectorItemInfo("id"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("contractType.name"));
        sic.add(new SelectorItemInfo("partB.name"));
        sic.add(new SelectorItemInfo("curProject.name"));
        sic.add(new SelectorItemInfo("signDate"));
        sic.add(new SelectorItemInfo("respDept.name"));
        sic.add(new SelectorItemInfo("respPerson.name"));
        sic.add(new SelectorItemInfo("state"));
        sic.add(new SelectorItemInfo("hasSettled"));
        sic.add(new SelectorItemInfo("amount"));
        sic.add(new SelectorItemInfo("curProject.id"));
        sic.add(new SelectorItemInfo("curProject.isEnabled"));
        sic.add(new SelectorItemInfo("isAmtWithoutCost"));
        sic.add(new SelectorItemInfo("contractType.longNumber"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.fdc.invite.markesupplier.client", "SelectContractUI");
    }




}