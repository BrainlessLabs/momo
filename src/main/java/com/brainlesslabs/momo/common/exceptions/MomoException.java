package com.brainlesslabs.momo.common.exceptions;

public class MomoException extends Exception {
    private final MomoErrorCodes code;

    public MomoException(final MomoErrorCodes code) {
        super();
        this.code = code;
    }

    public MomoException() {
        super();
        this.code = MomoErrorCodes.GENERIC_ERROR;
    }

    public MomoException(final String message) {
        super(message);
        this.code = MomoErrorCodes.GENERIC_ERROR;
    }

    public MomoException(final String message,
                         final Throwable cause,
                         final MomoErrorCodes code) {
        super(message, cause);
        this.code = code;
    }

    public MomoException(final String message,
                         final MomoErrorCodes code) {
        super(message);
        this.code = code;
    }

    public MomoErrorCodes getErrorCode() {
        return code;
    }
}
