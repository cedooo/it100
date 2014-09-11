package cn.com.dhcc.cgn.it100.pojo;
/**
 * 告警工具类
 * @author CeDo
 *
 */
public class AlarmMsgUtils {
	/** ISO8601 日期正则表达式 */
	static final String REGEX_ISO_8601 = "^(19[0-9]{2}|[2-9][0-9]{3})-((0(1|3|5|7|8)|10|12)-(0[1-9]|1[0-9]|2[0-9]|3[0-1])|(0(4|6|9)|11)-(0[1-9]|1[0-9]|2[0-9]|30)|(02)-(0[1-9]|1[0-9]|2[0-9]))\\x20(0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9]){2}$";
	/** 告警级别正则表达式  */
	static final String REGEX_LEVEL = "^严重|主要|次要|警告|未知$";
	/** IPV4 地址正则表达式*/
	static final String REGEX_IP_V4 = "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";
	static final String REGEX_NOTICE_PEOPLE = "^.*$";
	static final String REGEX_DETAIL = "^.*$";
	static final String REGEX_ALARM_ID = "^.*$";
	static final String REGEX_PRIMARY = "^.*$";
	/**
	 * 验证告警格式
	 * @param msg
	 * @return 格式正确返回true
	 * @throws Exception
	 */
	static public boolean valid(AlarmMsg msg) throws Exception{
		if(msg!=null){
			if(msg.getAlarmTime()==null || msg.getAlarmTime().matches(REGEX_ISO_8601)==false){
				throw new Exception("时间格式错误");
			}
			if(msg.getLevel()==null || msg.getLevel().matches(REGEX_LEVEL)==false){
				throw new Exception("告警级别格式错误");
			}
			if(msg.getIp()!=null &&  msg.getIp().matches(REGEX_IP_V4)==false){
				throw new Exception("IP地址格式错误");
			}
			if(msg.getNoticePople()!=null && msg.getNoticePople().matches(REGEX_NOTICE_PEOPLE)==false){
				throw new Exception("通知人格式错误");
			}
			if(msg.getAlarmDetail()!=null && msg.getAlarmDetail().matches(REGEX_DETAIL)==false){
				throw new Exception("告警详细格式错误");
			}
			if(msg.getAlarmId()!=null &&  msg.getAlarmId().matches(REGEX_ALARM_ID)==false){
				throw new Exception("告警ID格式错误");
			}
			if(msg.getPrimaryId()!=null &&  msg.getPrimaryId().matches(REGEX_PRIMARY)==false){
				throw new Exception("唯一标识格式错误");
			}
			return true;
		}else {
			return false;
		}
	}
}
