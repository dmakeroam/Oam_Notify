package th.co.cdgs.line.bot.response;

import th.co.cdgs.bot.response.UserProfile;

public class LineUserProfile extends UserProfile {

	private String displayName;

	private String pictureUrl;

	private String statusMessage;

	public LineUserProfile(String userId) {
		super(userId);
	}

	@Override
	public String getUsername() {
		return this.displayName;
	}

	@Override
	public void setUsername(String username) {
		this.displayName = username;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
