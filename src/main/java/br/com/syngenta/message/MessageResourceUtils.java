package br.com.syngenta.message;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MessageResourceUtils {

    private static final Locale DEFAULT_LOCALE = new Locale("pt", "BR");

    private MessageResourceUtils() {
    }

    protected static ClassLoader getCurrentClassLoader(Object defaultObject) {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        if (loader == null && defaultObject != null) {
            loader = defaultObject.getClass().getClassLoader();
        }

        return loader;
    }

    public static String getMessageResource(String bundleFileName, Enum<?> messageKey, Object[] params) {

        return getMessageResource(bundleFileName, messageKey, params, DEFAULT_LOCALE);
    }

    public static String getMessageResource(String bundleFileName, Enum<?> messageKey, Object[] params, Locale locale) {

        String message = null;

        /* obtem o bundle de mensagens. */
        ResourceBundle bundle = ResourceBundle.getBundle(bundleFileName, locale, getCurrentClassLoader(params));

        if (bundle != null) {
            try {
                /* obtem texto pela chave */
                message = messageKey.name() + " - " + bundle.getString(messageKey.name());

            } catch (MissingResourceException e) {
                message = "?? chave " + messageKey.name() + " não encontrado ??";
            }

            /* formata a mensagem com os parametros associados. */
            if (params != null) {
                MessageFormat mf = new MessageFormat(message, locale);
                message = mf.format(params);
            }
        } else {
            message = "?? Arquivo de bundle " + bundleFileName + "não encontrado ??";
        }

        return message;
    }


}
