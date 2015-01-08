package com.kingdee.eas.fdc.invite.designsupplier.uitls;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.IPositionMember;
import com.kingdee.eas.basedata.org.PositionInfo;
import com.kingdee.eas.basedata.org.PositionMemberCollection;
import com.kingdee.eas.basedata.org.PositionMemberFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;

public class PersonHelper {

	/**
	 *  ���ְԱ_��ְ��� ��Ҫְλ�Ĳ�����Ϣ
	 * @return
	 */
	public static AdminOrgUnitInfo getPosiMemByDeptUser(PersonInfo person) {
		
		AdminOrgUnitInfo workDept = null;
		PositionMemberCollection positMems = getPositionMemberByUser(person);
		
		if (positMems == null)	
			return workDept;
		
		for (int i = 0; i < positMems.size(); i++) {
			if (positMems.get(i).isIsPrimary()) {
				workDept = positMems.get(i).getPosition().getAdminOrgUnit();
				return workDept;
			}
		}
		return workDept;
	}
	
    /**
	 * ����personId ��ȡԱ��ְλ
	 * */
	public  PositionInfo getPositionByPersonId( String personId)
	    throws BOSException, EASBizException
	{
	    PositionInfo info = null;
	    String oql = "select position.* where isPrimary = 1 and person.id = '" + personId + "'";
	    IPositionMember ipp = null;
	    ipp = PositionMemberFactory.getRemoteInstance();
	    PositionMemberCollection c = ipp.getPositionMemberCollection(oql);
	    if(c.size() > 0)
	        info = c.get(0).getPosition();
	    return info;
	}
	/**
	 * �����û� ���ְԱ_��ְ��� ְλ�б�
	 * 
	 * @param person
	 * 
	 * @return
	 */
	public static  PositionMemberCollection getPositionMemberByUser(PersonInfo person) {
		
		try {
			String oql = "select *, person.*, position.adminOrgUnit.* where person.id = '" + person.getId() + "'" ;
			return PositionMemberFactory.getRemoteInstance().getPositionMemberCollection(oql);
		} catch (Exception e1) {
		}
		return null;
	}
}
