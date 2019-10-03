package com.brainlesslabs.momo.common.exceptions;

public class NotSupportedException extends MomoException {
    public NotSupportedException() {
        super(MomoErrorCodes.NOT_SUPPORTED);
    }

    public NotSupportedException(final String message) {
        super(message, MomoErrorCodes.NOT_SUPPORTED);
    }

    public NotSupportedException(final String message, final Throwable cause) {
        super(message, cause, MomoErrorCodes.NOT_SUPPORTED);
    }
}