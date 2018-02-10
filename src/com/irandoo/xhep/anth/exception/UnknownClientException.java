package com.irandoo.xhep.anth.exception;

import javax.security.auth.login.LoginException;

/**
 * 未知client异常
 * @author lijunf
 *
 */
public class UnknownClientException extends LoginException {

	private static final long serialVersionUID = 804647881052398236L;

	public UnknownClientException() {
        super();
    }

    public UnknownClientException(String msg) {
        super(msg);
    }
}
