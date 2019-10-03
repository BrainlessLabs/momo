package com.brainlesslabs.momo.common.exceptions;

public class InvalidOperationException extends MomoException {
    public InvalidOperationException() {
        super(MomoErrorCodes.INVALID_OPERATION);
    }

    public InvalidOperationException(final String message) {
        super(message, MomoErrorCodes.INVALID_OPERATION);
    }

    public InvalidOperationException(final String message, final Throwable cause) {
        super(message, cause, MomoErrorCodes.INVALID_OPERATION);
    }
}
