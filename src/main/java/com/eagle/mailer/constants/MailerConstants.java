package com.eagle.mailer.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MailerConstants {

	@UtilityClass
	public class Endpoints {
		public static final String API_V1_END_POINT = "/api/v1";
		public static final String SENDER_END_POINT = API_V1_END_POINT + "/sender";
		public static final String TEMPLATE_END_POINT = API_V1_END_POINT + "/template";
		public static final String RECIPIENT_END_POINT = API_V1_END_POINT + "/recipient";
		public static final String RECEIVER_END_POINT = API_V1_END_POINT + "/receiver";
	}

}
