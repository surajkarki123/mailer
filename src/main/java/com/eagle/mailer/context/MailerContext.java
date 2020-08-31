package com.eagle.mailer.context;

public class MailerContext {

	private static final ThreadLocal<String> CLIENT_ID_CONTEXT = new InheritableThreadLocal<>();

	public static void setClientId(String clientId) {
		CLIENT_ID_CONTEXT.set(clientId);
	}

	public static String getClientId() {
		return CLIENT_ID_CONTEXT.get();
	}

	public static void clear() {
		CLIENT_ID_CONTEXT.remove();
	}
}
