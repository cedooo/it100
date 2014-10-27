package cn.com.dhcc.cgn.it100.main;

import cn.com.dhcc.cgn.it100.pojo.IT100Primary;
import cn.com.dhcc.cgn.it100.pojo.IT100ResourceManageInfo;
import cn.com.dhcc.cgn.it100.webservice.impl.WebServiceImpl;

public class Main {
	public static void main(String[] args) {
		WebServiceImpl webServiceImpl = new WebServiceImpl();
		IT100Primary primary = new IT100Primary(args[0]);
		IT100ResourceManageInfo manageInfo = webServiceImpl.getResourceInfo(primary);
		System.out.println(manageInfo);
	}
}
