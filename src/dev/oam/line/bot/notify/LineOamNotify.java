/*
 * Copyright (C) 2017 Oam Notify Bot Open Source Project
 * 
 * Written by Sirinat Paphatsirinatthi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package dev.oam.line.bot.notify;

import java.io.IOException;
import java.util.Set;

import com.linecorp.bot.client.LineMessagingService;
import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.Multicast;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.profile.UserProfileResponse;
import com.linecorp.bot.model.response.BotApiResponse;

import retrofit2.Response;
import dev.oam.bot.notify.OamNotify;
import dev.oam.bot.response.GeneralResponse;
import dev.oam.bot.response.UserProfile;
import dev.oam.line.bot.response.LineUserProfile;

public class LineOamNotify implements OamNotify {

	private static String ACCESS_TOKEN = "<Insert your access token>";

	private LineMessagingService service ;
	
	private Set<String> recipients;
	
	public LineOamNotify(){
		LineMessagingService service = LineMessagingServiceBuilder.create(ACCESS_TOKEN).build();
		
		this.service = service;
	}

	@Override
	public void setAccessToken(String accessToken) {
		LineOamNotify.ACCESS_TOKEN = accessToken;
	}

	@Override
	public String getAccessToken() {
		return LineOamNotify.ACCESS_TOKEN;
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
