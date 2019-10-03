package com.brainlesslabs.momo.common.exceptions;

public class IOErrorException extends MomoException {
    public IOErrorException() {
        super(MomoErrorCodes.IO_ERROR);
    }

    public IOErrorException(final String message) {
        super(message, MomoErrorCodes.IO_ERROR);
    }

    public IOErrorException(final String message, final Throwable cause) {
        super(message, cause, MomoErrorCodes.IO_ERROR);
    }
}
