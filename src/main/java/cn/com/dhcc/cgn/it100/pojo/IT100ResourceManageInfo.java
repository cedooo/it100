package cn.com.dhcc.cgn.it100.pojo;

/**
 * IT100资产管理信息
 * 
 * @author CeDo
 * 
 */
public class IT100ResourceManageInfo {
	/** CI编码 */
	private String CICode = null;
	/** 名称 */
	private String name = null;
	/** 类型 */
	private String type = null;
	/** 子类型 */
	private String sonType = null;
	/** 运行状态 */
	private String doneStatus = null;
	/** 资产编码 */
	private String expCode = null;
	/** 所属公司 */
	private String fmCompany = null;
	/** 用途 */
	private String mkUse = null;
	/** 地点 */
	private String adress = null;

	public String getCICode() {
		return CICode;
	}

	public void setCICode(String cICode) {
		CICode = cICode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSonType() {
		return sonType;
	}

	public void setSonType(String sonType) {
		this.sonType = sonType;
	}

	public String getDoneStatus() {
		return doneStatus;
	}

	public void setDoneStatus(String doneStatus) {
		this.doneStatus = doneStatus;
	}

	public String getExpCode() {
		return expCode;
	}

	public void setExpCode(String expCode) {
		this.expCode = expCode;
	}

	public String getFmCompany() {
		return fmCompany;
	}

	public void setFmCompany(String fmCompany) {
		this.fmCompany = fmCompany;
	}

	public String getMkUse() {
		return mkUse;
	}

	public void setMkUse(String mkUse) {
		this.mkUse = mkUse;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "IT100ResourceManageInfo [CICode=" + CICode + ", name=" + name
				+ ", type=" + type + ", sonType=" + sonType + ", doneStatus="
				+ doneStatus + ", expCode=" + expCode + ", fmCompany="
				+ fmCompany + ", mkUse=" + mkUse + ", adress=" + adress + "]";
	}

}