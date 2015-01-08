package com.kingdee.eas.fdc.invite.designsupplier.uitls;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.workflow.ProcessInstInfo;
import com.kingdee.bos.workflow.service.ormrpc.EnactmentServiceFactory;
import com.kingdee.bos.workflow.service.ormrpc.IEnactmentService;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.ExceptionHandler;
import com.kingdee.eas.util.client.MsgBox;

public class WorkFlow {
	/**
	 *
	 * ��������鵥���Ƿ��ڹ�������
	 *
	 * @param ui
	 *            ��ǰUI����ʾ��Ϣʱ��
	 * @param id
	 *            ����ID
	 * @author:liupd ����ʱ�䣺2006-9-29
	 *               <p>
	 */
	public static void checkBillInWorkflow(CoreUIObject ui, String id) {

		ProcessInstInfo instInfo = null;
		ProcessInstInfo[] procInsts = null;
		try {
			IEnactmentService service2 = EnactmentServiceFactory
					.createRemoteEnactService();
			procInsts = service2.getProcessInstanceByHoldedObjectId(id);
		} catch (BOSException e) {
			ExceptionHandler.handle(e);
		}

		for (int i = 0, n = procInsts.length; i < n; i++) {
			// modify by gongyin,���̹���ʱҲ��ʾ����ͼ
			if ("open.running".equals(procInsts[i].getState())
					|| "open.not_running.suspended".equals(procInsts[i]
							.getState())) {
				instInfo = procInsts[i];
			}
		}
		if (instInfo != null) {
			MsgBox.showWarning(ui, EASResource
					.getString(FrameWorkClientUtils.strResource
							+ "Msg_BindWfInstance"));
			SysUtil.abort();
		}
	}
}
