package th.co.cdgs.line.bot.notify;

import java.io.IOException;
import java.util.Set;

import com.linecorp.bot.client.LineMessagingService;
import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.Multicast;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.profile.UserProfileResponse;
import com.linecorp.bot.model.response.BotApiResponse;

import retrofit2.Response;
import th.co.cdgs.bot.notify.CDGSNotify;
import th.co.cdgs.bot.response.GeneralResponse;
import th.co.cdgs.bot.response.UserProfile;
import th.co.cdgs.line.bot.response.LineUserProfile;

public class LineCDGSNotify implements CDGSNotify {

	private static String ACCESS_TOKEN = "C7fUYKmWMQTZcVPttEoFQrm5wGeOPPHxt62CIl0Eahr8s4ryEKUA6+KVDkXt01UknHdxcqiHvw3RxMZr5joIAwAXD9fPFjOxFWN/ASXCj8+Ixxovirg4INcfqGPRiM1CxC02XH5A8cWyJRgxf1QbvgdB04t89/1O/w1cDnyilFU=";

	private LineMessagingService service ;
	
	private Set<String> recipients;
	
	public LineCDGSNotify(){
		LineMessagingService service = LineMessagingServiceBuilder.create(ACCESS_TOKEN).build();
		
		this.service = service;
	}

	@Override
	public void setAccessToken(String accessToken) {
		LineCDGSNotify.ACCESS_TOKEN = accessToken;
	}

	@Override
	public String getAccessToken() {
		return LineCDGSNotify.ACCESS_TOKEN;
	}

	@Override
	public void setRecipients(Set<String> recipients) {
		this.recipients = recipients;
	}

	@Override
	public Set<String> getRecipients() {
		return this.recipients;
	}

	@Override
	public GeneralResponse sendMessage(String message) {
		GeneralResponse response = null;
		Multicast multicast = new Multicast(this.getRecipients(), new TextMessage(message));
		try{
			Response<BotApiResponse> botApiResponse = service.multicast(multicast).execute();
			if(botApiResponse.isSuccessful()){
				response = new GeneralResponse(Integer.toString(botApiResponse.code()), botApiResponse.message());
			}
		}
		catch(IOException ex){
			
		}
		return response;
	}

	@Override
	public UserProfile getProfile(String userId) {
		UserProfile profile = null;
		try {
			Response<UserProfileResponse> response = service.getProfile(userId).execute();
			if(response.isSuccessful()){
				profile = new LineUserProfile(userId);
				profile.setUsername(response.body().getDisplayName());
				((LineUserProfile)profile).setPictureUrl(response.body().getPictureUrl());
				((LineUserProfile)profile).setStatusMessage(response.body().getStatusMessage());
			}
		} catch (IOException e) {
			
		}
		return profile;
	}

}
