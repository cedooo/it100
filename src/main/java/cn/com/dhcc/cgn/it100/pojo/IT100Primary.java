package cn.com.dhcc.cgn.it100.pojo;

/**
 * IT100唯一标识
 * @author CeDo
 *
 */
public class IT100Primary {
	/** IT100唯一标识ID */
	private String primaryId = null;     
	
	public IT100Primary(String primaryId){
		this.primaryId = primaryId;
	}
	
	public String getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}

	@Override
	public String toString() {
		return "IT100Primary [primaryId=" + primaryId + "]";
	}
	
}
