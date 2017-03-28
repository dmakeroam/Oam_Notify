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

package dev.oam.line.bot.response;

import dev.oam.bot.response.UserProfile;

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
