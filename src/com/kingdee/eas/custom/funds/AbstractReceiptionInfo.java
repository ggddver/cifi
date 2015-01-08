package com.kingdee.eas.custom.funds;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractReceiptionInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractReceiptionInfo()
    {
        this("id");
    }
    protected AbstractReceiptionInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.funds.ReceiptionEntryCollection());
    }
    /**
     * Object: 资金往来收据 's 分录 property 
     */
    public com.kingdee.eas.custom.funds.ReceiptionEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.funds.ReceiptionEntryCollection)get("entrys");
    }
    /**
     * Object:资金往来收据's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 资金往来收据 's 交款单位 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getPayUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("payUnit");
    }
    public void setPayUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("payUnit", item);
    }
    /**
     * Object: 资金往来收据 's 项目名称 property 
     */
    public com.kingdee.eas.fdc.sellhouse.SellProjectInfo getProject()
    {
        return (com.kingdee.eas.fdc.sellhouse.SellProjectInfo)get("project");
    }
    public void setProject(com.kingdee.eas.fdc.sellhouse.SellProjectInfo item)
    {
        put("project", item);
    }
    /**
     * Object:资金往来收据's 合计property 
     */
    public java.math.BigDecimal getSum()
    {
        return getBigDecimal("sum");
    }
    public void setSum(java.math.BigDecimal item)
    {
        setBigDecimal("sum", item);
    }
    /**
     * Object:资金往来收据's 大写金额property 
     */
    public String getUpperAmount()
    {
        return getString("upperAmount");
    }
    public void setUpperAmount(String item)
    {
        setString("upperAmount", item);
    }
    /**
     * Object: 资金往来收据 's 收款人 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getRecPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("recPerson");
    }
    public void setRecPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("recPerson", item);
    }
    /**
     * Object:资金往来收据's 审批时间property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("auditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("auditDate", item);
    }
    /**
     * Object: 资金往来收据 's 房产公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:资金往来收据's 单据状态property 
     */
    public com.kingdee.eas.custom.funds.BizState getBizState()
    {
        return com.kingdee.eas.custom.funds.BizState.getEnum(getString("bizState"));
    }
    public void setBizState(com.kingdee.eas.custom.funds.BizState item)
    {
		if (item != null) {
        setString("bizState", item.getValue());
		}
    }
    /**
     * Object:资金往来收据's 备注property 
     */
    public String getComment()
    {
        return getString("comment");
    }
    public void setComment(String item)
    {
        setString("comment", item);
    }
    /**
     * Object:资金往来收据's 交款单位类型property 
     */
    public com.kingdee.eas.custom.funds.payUnitType getPayUnitType()
    {
        return com.kingdee.eas.custom.funds.payUnitType.getEnum(getString("payUnitType"));
    }
    public void setPayUnitType(com.kingdee.eas.custom.funds.payUnitType item)
    {
		if (item != null) {
        setString("payUnitType", item.getValue());
		}
    }
    /**
     * Object: 资金往来收据 's 交款单位 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object: 资金往来收据 's 交款单位 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getEmployee()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("employee");
    }
    public void setEmployee(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("employee", item);
    }
    /**
     * Object:资金往来收据's 交款单位property 
     */
    public String getOther()
    {
        return getString("other");
    }
    public void setOther(String item)
    {
        setString("other", item);
    }
    /**
     * Object: 资金往来收据 's 供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E0D00475");
    }
}