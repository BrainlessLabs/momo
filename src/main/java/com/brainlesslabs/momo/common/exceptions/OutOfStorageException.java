package com.brainlesslabs.momo.common.exceptions;

public class OutOfStorageException extends MomoException {
    public OutOfStorageException() {
        super(MomoErrorCodes.OUT_OF_STORAGE);
    }

    public OutOfStorageException(final String message) {
        super(message, MomoErrorCodes.OUT_OF_STORAGE);
    }

    public OutOfStorageException(final String message, final Throwable cause) {
        super(message, cause, MomoErrorCodes.OUT_OF_STORAGE);
    }
}
