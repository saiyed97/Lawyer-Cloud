package VO;

public class TestimonialVO 
{
	private int testimonialId;
	private String testimonialDescription;
	private String testimonialStatus;
	private String name;
	private String dateAndTime;
	private LoginVO loginVO;
	
	public int getTestimonialId() {
		return testimonialId;
	}
	public void setTestimonialId(int testimonialId) {
		this.testimonialId = testimonialId;
	}
	public String getTestimonialDescription() {
		return testimonialDescription;
	}
	public void setTestimonialDescription(String testimonialDescription) {
		this.testimonialDescription = testimonialDescription;
	}
	public String getTestimonialStatus() {
		return testimonialStatus;
	}
	public void setTestimonialStatus(String testimonialStatus) {
		this.testimonialStatus = testimonialStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	
	
}
