package br.com.syngenta.message;

public class MessageUtils {
	
	private static final String RESOURCE_FILE_FS = "business-message";

	private MessageUtils() {
	}

	public static String getMessage(MessageEnum messageKey, Object... parameters) {
		return MessageResourceUtils.getMessageResource(RESOURCE_FILE_FS, messageKey, parameters);
	}

	public static String getMessage(MessageEnum messageKey) {
		return MessageResourceUtils.getMessageResource(RESOURCE_FILE_FS, messageKey, null);
	}

}
