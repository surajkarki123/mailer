package com.eagle.mailer.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MailerConstants {

	@UtilityClass
	public class Endpoints {
		public final String API_V1_END_POINT = "/api/v1";
		public final String SENDER_END_POINT = API_V1_END_POINT + "/sender";
	}

}
