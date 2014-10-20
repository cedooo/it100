package cn.com.dhcc.cgn.it100.webservice.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.Test;

import cn.com.dhcc.cgn.it100.pojo.AlarmMsg;
import cn.com.dhcc.cgn.it100.pojo.IT100Primary;
import cn.com.dhcc.cgn.it100.pojo.IT100ResourceManageInfo;
import cn.com.dhcc.cgn.it100.pojo.ITIMSResourceInfo;

public class WebServiceImplTest {

	private WebServiceImpl webServiceImpl = new WebServiceImpl();
	static private String[] primaries = new String[]{"CI20140001","C31256","CI201400123","CI2014090057"};
	
	//@Test
	public void testGetResourceInfo() {
		IT100Primary primary = new IT100Primary(primaries[0]);
		IT100ResourceManageInfo manageInfo = webServiceImpl.getResourceInfo(primary);
		assertEquals(true,manageInfo.getCICode()!=null);
		System.out.println(manageInfo);
	}

	//@Test
	public void testSendAllResouceInfo() {
		List<ITIMSResourceInfo> listInfo = new ArrayList<ITIMSResourceInfo>();
		ITIMSResourceInfo resInfo = new ITIMSResourceInfo();
		resInfo.setIp("10.200.2.36");
		resInfo.setIpStack("0");
		resInfo.setModel("hh3c-sR8812-V5");
		resInfo.setMOType("101003");
		resInfo.setPrimaryId(primaries[0]);
		resInfo.setStatus("0");
		resInfo.setSysoid("1.3.6.1.4.1.25506.1.187");
		resInfo.setVendor("H3C");
		listInfo.add(resInfo);
		assertEquals(true,webServiceImpl.sendAllResouceInfo(listInfo)==1);
	}

	//@Test
	public void testSendAlarmMsg() {
		AlarmMsg msg = new AlarmMsg();
		msg.setAlarmId("4435931");
		msg.setPrimaryId(primaries[0]);
		msg.setAlarmDetail("告警测试 test 123 !@#");
		msg.setIp("12.23.22.1");
		msg.setNoticePople("pcit|张三;pcit|李四");
		msg.setLevel("警告");
		msg.setAlarmTime("2014-09-16 16:41:52");
		try {
			String rt = webServiceImpl.sendAlarmMsg(msg);
			JSONObject jsObj = new JSONObject(rt);
			System.out.println(jsObj.get("isSuccess"));
			System.out.println(jsObj.get("info"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
