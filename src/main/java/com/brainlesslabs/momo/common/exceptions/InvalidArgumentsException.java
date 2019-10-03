package com.brainlesslabs.momo.common.exceptions;

public class InvalidArgumentsException extends MomoException {
    public InvalidArgumentsException() {
        super(MomoErrorCodes.INVALID_ARGUMENTS);
    }

    public InvalidArgumentsException(final String message) {
        super(message, MomoErrorCodes.INVALID_ARGUMENTS);
    }

    public InvalidArgumentsException(final String message, final Throwable cause) {
        super(message, cause, MomoErrorCodes.INVALID_ARGUMENTS);
    }
}
