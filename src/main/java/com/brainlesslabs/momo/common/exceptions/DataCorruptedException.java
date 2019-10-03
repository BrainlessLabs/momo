package com.brainlesslabs.momo.common.exceptions;

public class DataCorruptedException extends MomoException {
    public DataCorruptedException() {
        super(MomoErrorCodes.DATA_CORRUPTED);
    }

    public DataCorruptedException(final String message) {
        super(message, MomoErrorCodes.DATA_CORRUPTED);
    }

    public DataCorruptedException(final String message, final Throwable cause) {
        super(message, cause, MomoErrorCodes.DATA_CORRUPTED);
    }
}
