package com.kingdee.eas.fdc.invite.DirectNegotiationApproval;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDirectNegotiationApprovalInfo extends com.kingdee.eas.fdc.invite.BaseInviteInfo implements Serializable 
{
    public AbstractDirectNegotiationApprovalInfo()
    {
        this("id");
    }
    protected AbstractDirectNegotiationApprovalInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.fdc.invite.DirectNegotiationApproval.DirectNegotiationApprovalEntryCollection());
    }
    /**
     * Object: ֱ��������� 's ��¼ property 
     */
    public com.kingdee.eas.fdc.invite.DirectNegotiationApproval.DirectNegotiationApprovalEntryCollection getEntrys()
    {
        return (com.kingdee.eas.fdc.invite.DirectNegotiationApproval.DirectNegotiationApprovalEntryCollection)get("entrys");
    }
    /**
     * Object:ֱ���������'s �г�����property 
     */
    public java.math.BigDecimal getMarket()
    {
        return getBigDecimal("market");
    }
    public void setMarket(java.math.BigDecimal item)
    {
        setBigDecimal("market", item);
    }
    /**
     * Object:ֱ���������'s ���property 
     */
    public java.math.BigDecimal getBasePrice()
    {
        return getBigDecimal("basePrice");
    }
    public void setBasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("basePrice", item);
    }
    /**
     * Object:ֱ���������'s �ɱ����ݿ�property 
     */
    public java.math.BigDecimal getCostData()
    {
        return getBigDecimal("costData");
    }
    public void setCostData(java.math.BigDecimal item)
    {
        setBigDecimal("costData", item);
    }
    /**
     * Object:ֱ���������'s Ԥ����ͬ���(����)property 
     */
    public java.math.BigDecimal getContractPrice()
    {
        return getBigDecimal("contractPrice");
    }
    public void setContractPrice(java.math.BigDecimal item)
    {
        setBigDecimal("contractPrice", item);
    }
    /**
     * Object:ֱ���������'s ����property 
     */
    public String getDifference()
    {
        return getString("difference");
    }
    public void setDifference(String item)
    {
        setString("difference", item);
    }
    /**
     * Object:ֱ���������'s �ر�˵��property 
     */
    public String getSpecialNote()
    {
        return getString("specialNote");
    }
    public void setSpecialNote(String item)
    {
        setString("specialNote", item);
    }
    /**
     * Object: ֱ��������� 's ͼֽ��� property 
     */
    public com.kingdee.eas.fdc.invite.DrawingDepthInfo getDrawingDepth()
    {
        return (com.kingdee.eas.fdc.invite.DrawingDepthInfo)get("drawingDepth");
    }
    public void setDrawingDepth(com.kingdee.eas.fdc.invite.DrawingDepthInfo item)
    {
        put("drawingDepth", item);
    }
    /**
     * Object: ֱ��������� 's Ŀ��ɱ����䷽ʽ property 
     */
    public com.kingdee.eas.fdc.invite.DeployTypeInfo getDeployType()
    {
        return (com.kingdee.eas.fdc.invite.DeployTypeInfo)get("deployType");
    }
    public void setDeployType(com.kingdee.eas.fdc.invite.DeployTypeInfo item)
    {
        put("deployType", item);
    }
    /**
     * Object:ֱ���������'s Ŀ��ɱ�property 
     */
    public String getAimCost()
    {
        return getString("aimCost");
    }
    public void setAimCost(String item)
    {
        setString("aimCost", item);
    }
    /**
     * Object:ֱ���������'s �ο���property 
     */
    public String getRefPrice()
    {
        return getString("refPrice");
    }
    public void setRefPrice(String item)
    {
        setString("refPrice", item);
    }
    /**
     * Object:ֱ���������'s Ԥ����ͬ���property 
     */
    public String getConPrice()
    {
        return getString("conPrice");
    }
    public void setConPrice(String item)
    {
        setString("conPrice", item);
    }
    /**
     * Object:ֱ���������'s �а���Χproperty 
     */
    public String getScope()
    {
        return getString("scope");
    }
    public void setScope(String item)
    {
        setString("scope", item);
    }
    /**
     * Object:ֱ���������'s ��Ŀ��ɱ��Ƚ�property 
     */
    public com.kingdee.eas.fdc.invite.RangeEnum getCompareAim()
    {
        return com.kingdee.eas.fdc.invite.RangeEnum.getEnum(getString("compareAim"));
    }
    public void setCompareAim(com.kingdee.eas.fdc.invite.RangeEnum item)
    {
		if (item != null) {
        setString("compareAim", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DC2CCE84");
    }
}