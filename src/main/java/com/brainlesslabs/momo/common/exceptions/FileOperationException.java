package com.brainlesslabs.momo.common.exceptions;

public class FileOperationException extends MomoException {
    public FileOperationException() {
        super(MomoErrorCodes.FILE_OPERATION_EXCEPTION);
    }

    public FileOperationException(final String message) {
        super(message, MomoErrorCodes.FILE_OPERATION_EXCEPTION);
    }

    public FileOperationException(final String message, final Throwable cause) {
        super(message, cause, MomoErrorCodes.FILE_OPERATION_EXCEPTION);
    }
}
