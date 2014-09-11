package cn.com.dhcc.cgn.it100.pojo;

/**
 * 
 * @author CeDo
 * ITIMS资源信息
 *
 */
public class ITIMSResourceInfo {
	/**唯一标识*/
	private String primaryId = null;    
	/**网元类型*/
	private String MOType = null;    
	/**网元IP*/
	private String ip = null;    
	/**厂商*/
	private String vendor = null;    
	/**设备的sysoid，对于多数厂商的设备（尤其是网络设备），sysoid是可以准确确认设备型号的*/
	private String sysoid = null;    
	/**区分IPv4/IPv6的标识*/
	private String ipStack = null;    
	/**设备状态*/
	private String status = null;    
	/**设备型号*/
	private String model = null;    

	public String getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}

	public String getMOType() {
		return MOType;
	}

	public void setMOType(String mOType) {
		MOType = mOType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getSysoid() {
		return sysoid;
	}

	public void setSysoid(String sysoid) {
		this.sysoid = sysoid;
	}

	public String getIpStack() {
		return ipStack;
	}

	public void setIpStack(String ipStack) {
		this.ipStack = ipStack;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "ITIMSResourceInfo [primaryId=" + primaryId + ", MOType="
				+ MOType + ", ip=" + ip + ", vendor=" + vendor + ", sysoid="
				+ sysoid + ", ipStack=" + ipStack + ", status=" + status
				+ ", model=" + model + "]";
	}

}
