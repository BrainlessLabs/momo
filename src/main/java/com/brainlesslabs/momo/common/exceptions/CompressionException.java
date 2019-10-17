package com.brainlesslabs.momo.common.exceptions;

public class CompressionException extends MomoException {
    public CompressionException() {
        super(MomoErrorCodes.COMPRESSION_EXCEPTION);
    }

    public CompressionException(final String message) {
        super(message, MomoErrorCodes.COMPRESSION_EXCEPTION);
    }

    public CompressionException(final String message, final Throwable cause) {
        super(message, cause, MomoErrorCodes.COMPRESSION_EXCEPTION);
    }
}
