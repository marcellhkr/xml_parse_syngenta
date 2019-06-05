package br.com.syngenta.exception;

import br.com.syngenta.message.MessageEnum;
import br.com.syngenta.message.MessageUtils;

public class XMLUtilsBusinessException extends XmlParseSyngentaBusinessException {

    private static final long serialVersionUID = -1715484649640246461L;
    private MessageEnum code;


    public XMLUtilsBusinessException(MessageEnum messageCode, Throwable cause, Object... messageParameters) {

        super(MessageUtils.getMessage(messageCode, messageParameters), cause);

        this.code = messageCode;
    }

    public XMLUtilsBusinessException(MessageEnum messageCode, Object... messageParameters) {

        super(MessageUtils.getMessage(messageCode, messageParameters));

        this.code = messageCode;
    }

    public MessageEnum getCode() {
        return code;
    }

    public void setCode(MessageEnum code) {
        this.code = code;
    }

}
