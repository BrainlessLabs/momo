package com.brainlesslabs.momo.common.exceptions;

public class NotImplementedException extends MomoException {
    public NotImplementedException() {
        super(MomoErrorCodes.NOT_IMPLEMENTED);
    }

    public NotImplementedException(final String message) {
        super(message, MomoErrorCodes.NOT_IMPLEMENTED);
    }

    public NotImplementedException(final String message, final Throwable cause) {
        super(message, cause, MomoErrorCodes.NOT_IMPLEMENTED);
    }
}
