package br.com.syngenta.exception;

import br.com.syngenta.message.MessageEnum;
import br.com.syngenta.message.MessageUtils;

public class XmlParseSyngentaServiceBusinessException extends XmlParseSyngentaBusinessException {

	private static final long serialVersionUID = -2751716919186400449L;
	private MessageEnum code;
	
	
	public XmlParseSyngentaServiceBusinessException(MessageEnum messageCode,Throwable cause, Object... messageParameters) {

		super(MessageUtils.getMessage(messageCode, messageParameters), cause);

		this.code = messageCode;
	}
	
	public XmlParseSyngentaServiceBusinessException(MessageEnum messageCode, Object... messageParameters) {

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
