package VO;

public class FeedbackVO 
{
	private int feedbackId;
	private String feedbackSubject;
	private String feedbackDescription;
	private String feedbackDateAndTime;
	private LoginVO loginVO;
	private String name;
	private LoginVO fromLoginVO;
	private LoginVO toLoginVO;
	private String toName;
	
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getFeedbackSubject() {
		return feedbackSubject;
	}
	public void setFeedbackSubject(String feedbackSubject) {
		this.feedbackSubject = feedbackSubject;
	}
	public String getFeedbackDescription() {
		return feedbackDescription;
	}
	public void setFeedbackDescription(String feedbackDescription) {
		this.feedbackDescription = feedbackDescription;
	}
	public String getFeedbackDateAndTime() {
		return feedbackDateAndTime;
	}
	public void setFeedbackDateAndTime(String feedbackDateAndTime) {
		this.feedbackDateAndTime = feedbackDateAndTime;
	}
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	
	
	
	
	
}
