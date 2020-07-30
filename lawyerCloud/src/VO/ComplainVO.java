package VO;

public class ComplainVO 
{
	private int complainId;
	private String complainSubject;
	private String complainDescription;
	private String complainDateAndTime;
	private String complainStatus;
	private String replyDescription;
	private String name;
	private LoginVO fromLoginVO;
	private LoginVO toLoginVO;
	private String toName;
	/*private ClientRegisterVO clientRegisterVO;*/
	
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public int getComplainId() {
		return complainId;
	}
	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}
	public String getComplainSubject() {
		return complainSubject;
	}
	public void setComplainSubject(String complainSubject) {
		this.complainSubject = complainSubject;
	}
	public String getComplainDescription() {
		return complainDescription;
	}
	public void setComplainDescription(String complainDescription) {
		this.complainDescription = complainDescription;
	}
	
	
	public String getComplainDateAndTime() {
		return complainDateAndTime;
	}
	public void setComplainDateAndTime(String complainDateAndTime) {
		this.complainDateAndTime = complainDateAndTime;
	}
	
	public String getComplainStatus() {
		return complainStatus;
	}
	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReplyDescription() {
		return replyDescription;
	}
	public void setReplyDescription(String replyDescription) {
		this.replyDescription = replyDescription;
	}
	public LoginVO getFromLoginVO() {
		return fromLoginVO;
	}
	public void setFromLoginVO(LoginVO fromLoginVO) {
		this.fromLoginVO = fromLoginVO;
	}
	public LoginVO getToLoginVO() {
		return toLoginVO;
	}
	public void setToLoginVO(LoginVO toLoginVO) {
		this.toLoginVO = toLoginVO;
	}
	
	
	
	/*public ClientRegisterVO getClientRegisterVO() {
		return clientRegisterVO;
	}
	public void setClientRegisterVO(ClientRegisterVO clientRegisterVO) {
		this.clientRegisterVO = clientRegisterVO;
	}*/
	
	
	
	
	
}
