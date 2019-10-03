package com.brainlesslabs.momo.common.exceptions;

public class NotFoundException extends MomoException {
    public NotFoundException() {
        super(MomoErrorCodes.NOT_FOUND);
    }

    public NotFoundException(final String message) {
        super(message, MomoErrorCodes.NOT_FOUND);
    }

    public NotFoundException(final String message, final Throwable cause) {
        super(message, cause, MomoErrorCodes.NOT_FOUND);
    }
}
