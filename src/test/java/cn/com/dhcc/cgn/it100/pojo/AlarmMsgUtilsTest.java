package cn.com.dhcc.cgn.it100.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlarmMsgUtilsTest {

	@Test
	public void testValid() {
		AlarmMsg msg = new AlarmMsg();
		try {
			msg.setAlarmDetail("");
			msg.setAlarmId("");
			msg.setAlarmTime("2014-09-09 10:17:07");
			msg.setIp("1.1.1.24");
			msg.setLevel("警告");
			msg.setNoticePople("");
			msg.setPrimaryId("");
			assertEquals(true,AlarmMsgUtils.valid(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
