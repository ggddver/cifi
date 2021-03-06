package com.kingdee.eas.fdc.invite.client;

import java.util.Map;

import com.kingdee.bos.ctrl.kdf.util.render.CellTextRender;
import com.kingdee.eas.fdc.invite.InviteFileItemInfo;

public class CellFileItemRenderImpl extends CellTextRender {
	public String getText(Object obj) {
		if(obj == null)
			return null;
		if(obj instanceof InviteFileItemInfo)
		{
			return ((InviteFileItemInfo)obj).getName();
		}
		else if(obj instanceof Map && ((Map)obj).containsKey("name")){
			return String.valueOf(((Map)obj).get("name"));
		}
		else
			return String.valueOf(obj);
	}
}
