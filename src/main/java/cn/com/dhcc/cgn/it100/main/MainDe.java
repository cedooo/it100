package cn.com.dhcc.cgn.it100.main;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import cn.com.dhcc.cgn.it100.pojo.IT100Primary;
import cn.com.dhcc.cgn.it100.webservice.client.ServiceForDhccStub;
import cn.com.dhcc.cgn.it100.webservice.client.ServiceForDhccStub.GetConfigurationInfo;
import cn.com.dhcc.cgn.it100.webservice.client.ServiceForDhccStub.GetConfigurationInfoResponse;

public class MainDe {
	public static void main(String[] args) {
		IT100Primary it100Primary = new IT100Primary(args[0]);
		try {
			ServiceForDhccStub stub = new ServiceForDhccStub();
			GetConfigurationInfo configInfo = new GetConfigurationInfo();
			System.out.println(it100Primary);
			configInfo.setCiCode(it100Primary.getPrimaryId());
			GetConfigurationInfoResponse  response = stub.getConfigurationInfo(configInfo);
			System.out.println(response.getGetConfigurationInfoResult());
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
