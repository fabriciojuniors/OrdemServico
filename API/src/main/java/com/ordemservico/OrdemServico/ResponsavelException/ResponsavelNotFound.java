package com.ordemservico.OrdemServico.ResponsavelException;

public class ResponsavelNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	public ResponsavelNotFound() {
		super();

	}

	public ResponsavelNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ResponsavelNotFound(String message, Throwable cause) {
		super(message, cause);

	}

	public ResponsavelNotFound(String message) {
		super(message);

	}

	public ResponsavelNotFound(Throwable cause) {
		super(cause);
	}

	
}
