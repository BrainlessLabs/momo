package com.brainlesslabs.momo.common.exceptions;

public class FailedException extends MomoException {
    public FailedException() {
        super(MomoErrorCodes.FAILED);
    }

    public FailedException(final String message) {
        super(message, MomoErrorCodes.FAILED);
    }

    public FailedException(final String message, final Throwable cause) {
        super(message, cause, MomoErrorCodes.FAILED);
    }
}
