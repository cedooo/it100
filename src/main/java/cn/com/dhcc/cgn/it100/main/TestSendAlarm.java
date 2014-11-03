package cn.com.dhcc.cgn.it100.main;

import cn.com.dhcc.cgn.it100.pojo.AlarmMsg;
import cn.com.dhcc.cgn.it100.webservice.impl.WebServiceImpl;

public class TestSendAlarm {
	public static void main(String[] args) {
		WebServiceImpl webServiceImpl = new WebServiceImpl();
			AlarmMsg msg = new AlarmMsg();
	/*		msg.setAlarmId("4435931");
			msg.setPrimaryId(args[0]);
			msg.setAlarmDetail("告警测试 test 123 !@#");
			msg.setIp("12.23.22.1");
			msg.setNoticePople("pcit|chendong");
			msg.setLevel("警告");
			msg.setAlarmTime("2014-10-30 15:31:52");*/
			msg.setAlarmId("4435931");
			msg.setPrimaryId(args[0]);
			msg.setAlarmDetail("alarm test");
			msg.setIp("12.23.22.1");
			msg.setNoticePople("pcit|chendong");
			msg.setLevel("警告");
			msg.setAlarmTime("2014-10-30 15:31:52");
			try {
				String rt = webServiceImpl.sendAlarmMsg(msg);
				System.out.println(rt);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
