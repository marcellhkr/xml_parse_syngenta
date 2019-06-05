package br.com.syngenta.exception;

import br.com.syngenta.message.MessageEnum;
import br.com.syngenta.message.MessageUtils;

public class PDFUtilsBusinessException extends XmlParseSyngentaBusinessException {

    private static final long serialVersionUID = -5856535507976145418L;
    private MessageEnum code;


    public PDFUtilsBusinessException(MessageEnum messageCode, Throwable cause, Object... messageParameters) {

        super(MessageUtils.getMessage(messageCode, messageParameters), cause);

        this.code = messageCode;
    }

    public PDFUtilsBusinessException(MessageEnum messageCode, Object... messageParameters) {

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
