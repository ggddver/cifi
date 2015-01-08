/**
 * output package name
 */
package com.kingdee.eas.fdc.invite.markesupplier.client;

import java.sql.ResultSetMetaData;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.dao.query.QueryExecutorFactory;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.fdc.contract.ContractBillFactory;
import com.kingdee.eas.fdc.contract.IContractBill;
import com.kingdee.eas.util.client.KDTableUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class SelectContractUI extends AbstractSelectContractUI
{
    private static final Logger logger = CoreUIObject.getLogger(SelectContractUI.class);
    
    private Object obj[] = null;
    
    private IContractBill IContractBill = ContractBillFactory.getRemoteInstance();
    
    /**
     * output class constructor
     */
    public SelectContractUI() throws Exception
    {
        super();
    }

    public void onLoad() throws Exception {
    	super.onLoad();
    	
    	this.kDComboBox1.addItems(new Object[]{"合同名称","合同编码"});
    	
//    	showQueryDate(kDTable1, "com.kingdee.eas.fdc.invite.markesupplier.app.F7ContractBillQuery", new EntityViewInfo());
    }

    /**
     * output btnOk_actionPerformed method
     */
    protected void btnOk_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	int index[] = KDTableUtil.getSelectedRows(kDTable1);
    	
    	obj = new Object[index.length];
    	for (int i = 0; i < index.length; i++) 
    	{
    		String Id = UIRuleUtil.getString(kDTable1.getCell(index[i], "id").getValue());
    		obj[i] = IContractBill.getContractBillInfo(new ObjectUuidPK(Id),getSelectors());
		}
    	
    	getUIWindow().close();
//        super.btnOk_actionPerformed(e);
    }

    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	getUIWindow().close();
//        super.btnCancel_actionPerformed(e);
    }

    /**
     * output btnQuery_actionPerformed method
     */
    protected void btnQuery_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
//        super.btnQuery_actionPerformed(e);
    	
    	if(kDTextField1.getText()==null||"".equals(kDTextField1.getText().trim()))
    		return;
    	
    	String texValue = kDTextField1.getText().trim();
    	
    	EntityViewInfo view = new EntityViewInfo();
    	FilterInfo filInfo = new FilterInfo();
    	
    	if(this.kDComboBox1.getSelectedItem().toString().equals("合同编码"))
    		filInfo.getFilterItems().add(new FilterItemInfo("number","%"+texValue+"%",CompareType.LIKE));
    	else
    		filInfo.getFilterItems().add(new FilterItemInfo("name","%"+texValue+"%",CompareType.LIKE));
    	
//    	PurchaseOrgUnitInfo purOrgInfo = SysContext.getSysContext().getCurrentPurchaseUnit();
    	
//    	if(!purOrgInfo.getId().toString().equals("00000000-0000-0000-0000-000000000000CCE7AED4"))
//    		filInfo.getFilterItems().add(new FilterItemInfo("curProject.fullOrgUnit.longNumber",purOrgInfo.getLongNumber()+"%",CompareType.LIKE));
    	
    	
    	view.setFilter(filInfo);
    	showQueryDate(kDTable1, "com.kingdee.eas.fdc.invite.markesupplier.app.F7ContractBillQuery", view);
    }

    protected void kDTable1_tableClicked(KDTMouseEvent e) throws Exception {
//    	super.kDTable1_tableClicked(e);
    	if(e.getClickCount()==2&&e.getRowIndex()!=-1)
    	{
    		obj = new Object[1];
    		
    		String Id = UIRuleUtil.getString(kDTable1.getCell(e.getRowIndex(), "id").getValue());
    		obj[0] = IContractBill.getContractBillInfo(new ObjectUuidPK(Id),getSelectors());
    	}
    		
    }
    
    public SelectorItemCollection getSelectors() {
    	SelectorItemCollection sel=super.getSelectors();
    	sel.add("id");
    	sel.add("number");
    	sel.add("name");
    	sel.add("amount");
    	
    	return sel;
    }
    
    public Object[] getDate()
    {
    	return obj;
    }
    
    private int showQueryDate(KDTable tblMain,String queryName,EntityViewInfo evi) throws Exception
    {
    	tblMain.setEnabled(false);
    	tblMain.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
    	IMetaDataPK queryPK = new MetaDataPK(queryName);
    	IQueryExecutor exec = QueryExecutorFactory.getRemoteInstance(queryPK );
    	exec.option().isAutoIgnoreZero = true;
    	exec.option().isAutoTranslateBoolean = true;
    	exec.option().isAutoTranslateEnum = true; 
        exec.setObjectView(evi);
    	IRowSet rowSet = exec.executeQuery();
    	IRow row = null;
    	tblMain.removeRows();
    	int maxLevel = 0;
        for(int i=0; rowSet.next(); i++)
        {
        	row = tblMain.addRow();
        	ResultSetMetaData o_dbMd = rowSet.getMetaData();
        	int cols = o_dbMd.getColumnCount(); //取得query的字段数
        	Object[] colname = new Object[cols]; //取得query的字段名称
            for (int j = 1; j < cols+1; j++) {
              colname[j-1] = o_dbMd.getColumnName(j);
              if(colname[j-1]!=null && row.getCell(colname[j-1].toString())!=null
            		  && rowSet.getObject(colname[j-1].toString())!=null)
            		  row.getCell(colname[j-1].toString()).setValue(rowSet.getObject(colname[j-1].toString()));
            }
        }
        return maxLevel+1;
    }

}