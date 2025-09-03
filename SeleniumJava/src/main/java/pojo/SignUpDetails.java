package pojo;

public class SignUpDetails {
	private String userName;
	private String password;
	private String languagePreference;
	private String favouriteCtegory;
	private boolean enableMyList;
	private boolean enableMyBanner;
	private CustomerDetails customerDetails;
	public SignUpDetails(String userName, String password, String languagePreference, String favouriteCtegory,
			boolean enableMyList, boolean enableMyBanner, CustomerDetails customerDetails) {
		super();
		this.userName = userName;
		this.password = password;
		this.languagePreference = languagePreference;
		this.favouriteCtegory = favouriteCtegory;
		this.enableMyList = enableMyList;
		this.enableMyBanner = enableMyBanner;
		this.customerDetails = customerDetails;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLanguagePreference() {
		return languagePreference;
	}
	public void setLanguagePreference(String languagePreference) {
		this.languagePreference = languagePreference;
	}
	public String getFavouriteCtegory() {
		return favouriteCtegory;
	}
	public void setFavouriteCtegory(String favouriteCtegory) {
		this.favouriteCtegory = favouriteCtegory;
	}
	public boolean isEnableMyList() {
		return enableMyList;
	}
	public void setEnableMyList(boolean enableMyList) {
		this.enableMyList = enableMyList;
	}
	public boolean isEnableMyBanner() {
		return enableMyBanner;
	}
	public void setEnableMyBanner(boolean enableMyBanner) {
		this.enableMyBanner = enableMyBanner;
	}
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	
}
