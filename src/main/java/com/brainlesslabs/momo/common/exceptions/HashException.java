package com.brainlesslabs.momo.common.exceptions;

public class HashException extends MomoException {
    public HashException() {
        super(MomoErrorCodes.HASH_EXCEPTION);
    }

    public HashException(final String message) {
        super(message, MomoErrorCodes.HASH_EXCEPTION);
    }

    public HashException(final String message, final Throwable cause) {
        super(message, cause, MomoErrorCodes.HASH_EXCEPTION);
    }
}
