package VO;

public class RequestLawyerVO 
{
	private int requestLawyerId;
	private LawyerRegisterVO lawyerRegisterVO;
	private LoginVO loginVO;
	private String requestDescription;
	private String mobileNumber;
	private String requestDateAndTime;
	private String requestStatus;
	private String requestReplyDescription;
	private CategoryVO categoryVO;
	
	
	
	
	public CategoryVO getCategoryVO() {
		return categoryVO;
	}
	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}
	public int getRequestLawyerId() {
		return requestLawyerId;
	}
	public void setRequestLawyerId(int requestLawyerId) {
		this.requestLawyerId = requestLawyerId;
	}
	public LawyerRegisterVO getLawyerRegisterVO() {
		return lawyerRegisterVO;
	}
	public void setLawyerRegisterVO(LawyerRegisterVO lawyerRegisterVO) {
		this.lawyerRegisterVO = lawyerRegisterVO;
	}
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	public String getRequestDescription() {
		return requestDescription;
	}
	
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}
	public String getRequestDateAndTime() {
		return requestDateAndTime;
	}
	public void setRequestDateAndTime(String requestDateAndTime) {
		this.requestDateAndTime = requestDateAndTime;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getRequestReplyDescription() {
		return requestReplyDescription;
	}
	public void setRequestReplyDescription(String requestReplyDescription) {
		this.requestReplyDescription = requestReplyDescription;
	}
	
	
}
