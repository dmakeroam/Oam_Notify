package th.co.cdgs.bot.notify;

import java.util.Set;

import th.co.cdgs.bot.response.GeneralResponse;
import th.co.cdgs.bot.response.UserProfile;

public interface CDGSNotify {
	
	public void setAccessToken(String accessToken);
	
	public String getAccessToken();

	public void setRecipients(Set<String> recipients);

	public Set<String> getRecipients();
	
	public GeneralResponse sendMessage(String message);
	
	public UserProfile getProfile(String userId);
}
