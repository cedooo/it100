package cn.com.dhcc.cgn.it100.pojo;

/**
 * 告警信息
 * @author CeDo
 *
 */
public class AlarmMsg {
	/** 告警ID */
	private String alarmId = null;    
	/** IT100唯一标识ID */
	private String primaryId = null;    
	/** 通知人 */
	private String noticePople = null;   
	/** IP */
	private String ip = null;  
	/** 告警详情  */
	private String alarmDetail = null;   
	/** 告警级别 , 不能为null. 只能是:  严重|主要|次要|警告|未知  其中一个*/
	private String level = null;    
	/** 告警时间 (不能为null.ISO8601格式, 如:2014-09-09 11:45:37 )*/
	private String alarmTime = null;    

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}

	public String getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}

	public String getNoticePople() {
		return noticePople;
	}

	public void setNoticePople(String noticePople) {
		this.noticePople = noticePople;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAlarmDetail() {
		return alarmDetail;
	}

	public void setAlarmDetail(String alarmDetail) {
		this.alarmDetail = alarmDetail;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}

}
