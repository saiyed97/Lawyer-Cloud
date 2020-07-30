package VO;

public class ContactUsVO 
{
	private int contactUsId;
	private String name;
	private String email;
	private String mobileNumber;
	private CategoryVO categoryVO;
	private String description;
	
	public int getContactUsId() {
		return contactUsId;
	}
	public void setContactUsId(int contactUsId) {
		this.contactUsId = contactUsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public CategoryVO getCategoryVO() {
		return categoryVO;
	}
	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
