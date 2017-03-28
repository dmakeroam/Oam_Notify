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

package dev.oam.bot.notify;

import java.util.Set;

import dev.oam.bot.response.GeneralResponse;
import dev.oam.bot.response.UserProfile;

public interface OamNotify {
	
	public void setAccessToken(String accessToken);
	
	public String getAccessToken();

	public void setRecipients(Set<String> recipients);

	public Set<String> getRecipients();
	
	public GeneralResponse sendMessage(String message);
	
	public UserProfile getProfile(String userId);
}
