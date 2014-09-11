package cn.com.dhcc.cgn.it100.webservice.impl;

import java.rmi.RemoteException;
import java.util.List;

import org.apache.axis2.AxisFault;
import org.json.JSONException;
import org.json.JSONObject;

import cn.com.dhcc.cgn.it100.pojo.AlarmMsg;
import cn.com.dhcc.cgn.it100.pojo.AlarmMsgUtils;
import cn.com.dhcc.cgn.it100.pojo.IT100Primary;
import cn.com.dhcc.cgn.it100.pojo.IT100ResourceManageInfo;
import cn.com.dhcc.cgn.it100.pojo.ITIMSResourceInfo;
import cn.com.dhcc.cgn.it100.webservice.WebService;
import cn.com.dhcc.cgn.it100.webservice.client.ServiceForDhccStub;
import cn.com.dhcc.cgn.it100.webservice.client.ServiceForDhccStub.GetConfigurationInfo;
import cn.com.dhcc.cgn.it100.webservice.client.ServiceForDhccStub.GetConfigurationInfoResponse;
import cn.com.dhcc.cgn.it100.webservice.client.ServiceForDhccStub.ReceiveAlarmInfo;
import cn.com.dhcc.cgn.it100.webservice.client.ServiceForDhccStub.ReceiveAlarmInfoResponse;
import cn.com.dhcc.cgn.it100.webservice.client.ServiceForDhccStub.VerifyConfigurationInfo;
import cn.com.dhcc.cgn.it100.webservice.client.ServiceForDhccStub.VerifyConfigurationInfoResponse;

public class WebServiceImpl implements WebService{
	/**发送失败时，重发次数*/
	private static final int RE_SEND_COUNT = 3;   
	/**发送告警返回[成功]*/
	private static final String REGEX_SEND_ALARM_SUCCESS = "^Success.*";
	/**发送告警返回[异常]*/
	private static final String REGEX_SEND_ALARM_EXCEPTION = "^exception.*";
	/**接受资产信息成功*/
	private static final String REGEX_GET_RESOURCES_SUCCESS = "^success.*";
	/**发送资产信息成功*/
	private static final String REGEX_SEND_RESOURCES_SUCCESS = "^success$";
	/**获取管理资产信息返回成功与否的key*/
	private static final String GET_IT100_MANAGE_INFO_RESULT_KEY = "IsSuccess";   
	/**获取管理资产信息 返回的管理对象name*/
	private static final String GET_IT100_MANAGE_INFO_RESULT_OBJ = "Obj";   
	@Override
	public IT100ResourceManageInfo getResourceInfo(
			IT100Primary it100Primary) {
		IT100ResourceManageInfo manageInfo = new IT100ResourceManageInfo();
		if(it100Primary!=null){
			try {
				ServiceForDhccStub stub = new ServiceForDhccStub();
				GetConfigurationInfo configInfo = new GetConfigurationInfo();
				configInfo.setCiCode(it100Primary.getPrimaryId());
System.out.println(it100Primary);
				try {
					int getCount = 0;
					do {
						GetConfigurationInfoResponse  response = stub.getConfigurationInfo(configInfo);
						try{
							JSONObject rtJson = new JSONObject(response.getGetConfigurationInfoResult());
							String success = rtJson.getString(GET_IT100_MANAGE_INFO_RESULT_KEY);
							Object manageObj = rtJson.get(GET_IT100_MANAGE_INFO_RESULT_OBJ);
							if(success!=null&&success.matches(REGEX_GET_RESOURCES_SUCCESS)){
								//{"Name":"路由器001","MkUse":"联网","SonType":"路由器","DoneStatus":"","Type":"网络通信设备","Address":"大亚湾专家学校22104","FmCompany":"中国广核电力股份有限公司","CICode":"C31256","ExpCode":"010212"}
								JSONObject manageJson = new JSONObject(manageObj.toString());
								String name = manageJson.getString("Name");
								String mkUse = manageJson.getString("MkUse");
								String type = manageJson.getString("Type");
								String sonType = manageJson.getString("SonType");
								String doneStatus = manageJson.getString("DoneStatus");
								String address = manageJson.getString("Address");
								String fmCompany = manageJson.getString("FmCompany");
								String ciCode = manageJson.getString("CICode");
								String expCode = manageJson.getString("ExpCode");
								manageInfo.setName(name);
								manageInfo.setMkUse(mkUse);
								manageInfo.setType(type);
								manageInfo.setSonType(sonType);
								manageInfo.setDoneStatus(doneStatus);
								manageInfo.setAdress(address);
								manageInfo.setFmCompany(fmCompany);
								manageInfo.setCICode(ciCode);
								manageInfo.setExpCode(expCode);
								break;
							}else{
System.out.println("第"  + (getCount+1) + "次获取资产信息失败:" + success);							
								continue;
							}
						}catch(JSONException je){
							je.printStackTrace();
						}
					}while(++getCount<RE_SEND_COUNT);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			} catch (AxisFault e) {
				e.printStackTrace();
			}
		}
		return manageInfo;
	}

	@Override
	public int sendAllResouceInfo(List<ITIMSResourceInfo> listInfo) {
		if(listInfo!=null){
			try {
				ServiceForDhccStub stub = new ServiceForDhccStub();
				int sendSuccessCount = 0;
				for (ITIMSResourceInfo itimsResourceInfo : listInfo) {
					VerifyConfigurationInfo verifyInfo = new VerifyConfigurationInfo();
					JSONObject jsonObject = new JSONObject(itimsResourceInfo);
					verifyInfo.setJsonConfigurationInfo(jsonObject.toString());
System.out.println(jsonObject.toString());
					try {
						for (int i = 0; i < RE_SEND_COUNT; i++) {
							VerifyConfigurationInfoResponse verifyResponse = stub.verifyConfigurationInfo(verifyInfo);
							String verStr = verifyResponse.getVerifyConfigurationInfoResult();
System.out.println(verStr);
							boolean sendSuccess = verStr!=null&& verStr.matches(REGEX_SEND_RESOURCES_SUCCESS);
							if(sendSuccess){
								sendSuccessCount++;
								break;
							}else{
								continue;
							}
						}
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				return sendSuccessCount==listInfo.size()?1:    //成功返回1
							(
								sendSuccessCount==0?-1:     //发送0条返回-1
								(sendSuccessCount>0&&sendSuccessCount<listInfo.size()?2:3)    //部分成功,返回2
							);
			} catch (AxisFault e) {
				e.printStackTrace();
			}
		}
		return 1;
	}

	@Override
	public boolean sendAlarmMsg(AlarmMsg alarmMsg) throws Exception {
		boolean formatIsRight = AlarmMsgUtils.valid(alarmMsg);
		if(formatIsRight){
			try {
				ServiceForDhccStub stub = new ServiceForDhccStub();
				ReceiveAlarmInfo receiveAlarmInfo = new ReceiveAlarmInfo();
				JSONObject jsonObj = new JSONObject(alarmMsg);
				String dataJson = jsonObj.toString();
System.out.println(dataJson);
				receiveAlarmInfo.setJsonAlarmInfo(dataJson);
				int sendCount = 0;
				do{
					boolean sendSuccess = false;
					try {
						ReceiveAlarmInfoResponse  response = stub.receiveAlarmInfo(receiveAlarmInfo);
						String resStr = response.getReceiveAlarmInfoResult();
						sendSuccess = resStr!=null&&resStr.matches(REGEX_SEND_ALARM_SUCCESS);
						if(resStr!=null&&resStr.matches(REGEX_SEND_ALARM_EXCEPTION)){
							System.out.println("发送告警异常：" + resStr);
						}
System.out.println("第" + (sendCount+1)  + "次发送告警信息结果：" + resStr);
					} catch (RemoteException e) {
						e.printStackTrace();
					} finally{
						if(sendSuccess){
							return true;
						}
					}
				}while(++sendCount<RE_SEND_COUNT);
			} catch (AxisFault e) {
				e.printStackTrace();
				throw e;
			} 
		}else{
			throw new Exception("告警信息格式错误");
		}
		return false;
	}
	
}
