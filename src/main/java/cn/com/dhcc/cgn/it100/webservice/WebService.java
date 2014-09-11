package cn.com.dhcc.cgn.it100.webservice;

import java.util.List;

import cn.com.dhcc.cgn.it100.pojo.AlarmMsg;
import cn.com.dhcc.cgn.it100.pojo.IT100Primary;
import cn.com.dhcc.cgn.it100.pojo.IT100ResourceManageInfo;
import cn.com.dhcc.cgn.it100.pojo.ITIMSResourceInfo;

/**
 * 
 * @author CeDo
 *
 */
public interface WebService {
	/**
	 * 发送告警信息
	 * @param alarmMsg 告警信息
	 * @return 发送成功返回true，否则返回false.
	 * @throws Exception 参数格式错误等错误时返回异常信息
	 */
	boolean sendAlarmMsg(AlarmMsg alarmMsg) throws Exception;
	/**
	 * 得到资产管理信息
	 * @param it100primary IT100资产唯一标识
	 * @return 返回非null对象
	 */
	IT100ResourceManageInfo getResourceInfo(IT100Primary primary);
	/**
	 * 发送ITIMS所有资产信息
	 * @param listInfo
	 * @return 成功返回1，失败返回-1，部分成功返回2,存在异常返回3
	 */
	int sendAllResouceInfo(List<ITIMSResourceInfo> listInfo);
}
