package th.co.cdgs.bot.response;

public class UserProfile {
	private String userId;
	private String username;

	public UserProfile(String userId){
		super();
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
