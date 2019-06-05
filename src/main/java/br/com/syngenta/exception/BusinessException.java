package br.com.syngenta.exception;

import br.com.syngenta.message.MessageEnum;
import br.com.syngenta.message.MessageUtils;

public class BusinessException extends Exception {

    private static final long serialVersionUID = -894144438515373134L;
    private MessageEnum code;


    public BusinessException(MessageEnum messageCode, Throwable cause, Object... messageParameters) {

        super(MessageUtils.getMessage(messageCode, messageParameters), cause);

        this.code = messageCode;
    }

    public BusinessException(MessageEnum messageCode, Object... messageParameters) {

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
