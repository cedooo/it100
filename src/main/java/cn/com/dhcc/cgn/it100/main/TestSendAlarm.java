package cn.com.dhcc.cgn.it100.main;

import cn.com.dhcc.cgn.it100.pojo.AlarmMsg;
import cn.com.dhcc.cgn.it100.webservice.impl.WebServiceImpl;
/**
 * 测试向目标发送告警工单
 * @author CeDoo
 *
 */
public class TestSendAlarm {
	public static void main(String[] args) {
		WebServiceImpl webServiceImpl = new WebServiceImpl();
			AlarmMsg msg = new AlarmMsg();
	/*		
			msg.setAlarmId("4435931");
			msg.setPrimaryId(args[0]);
			msg.setAlarmDetail("告警测试 test 123 !@#");
			msg.setIp("12.23.22.1");
			msg.setNoticePople("pcit|chendong");
			msg.setLevel("警告");
			msg.setAlarmTime("2014-10-30 15:31:52");
	*/
			
			msg.setAlarmId("10021");
			msg.setPrimaryId(args[0]);
			msg.setAlarmDetail("alarm test 告警测试");
			msg.setIp("12.23.22.1");
			msg.setNoticePople("pcit|张三;pcit|李四");
			msg.setLevel("严重");
			msg.setAlarmTime("2014-10-30 15:31:52");
			
			/**
			 * {"AlarmId":"10021","NoticePople":"pcit|张三;pcit|李四","PrimaryId":"12","DeviceType":null,"AlarmObject":null,"IP":"10.10.90.11","AlarmDetail":"测试:打印机缺纸","Level":"一般","AlarmTime":"2015/1/29 16:41:55"}
			 */
			/*
			msg.setAlarmId("10021");
			msg.setPrimaryId(args[0]);
			msg.setAlarmDetail("测试:打印机缺纸 -1-29");
			msg.setIp("10.10.90.11");
			msg.setNoticePople("pcit|张三;pcit|李四");
			msg.setLevel("严重");
			msg.setAlarmTime("2015/1/29 16:41:55");
			*/
			try {
				String rt = webServiceImpl.sendAlarmMsg(msg);
				System.out.println(rt);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
