package br.com.syngenta.exception;

public class XmlParseSyngentaBusinessException extends Exception {

    private static final long serialVersionUID = 3318848329349967395L;

    public XmlParseSyngentaBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public XmlParseSyngentaBusinessException(String message) {
        super(message);
    }

}
