package com.brainlesslabs.momo.common.exceptions;

public class OperationIncompleteException extends MomoException {
    public OperationIncompleteException() {
        super(MomoErrorCodes.OPERATION_INCOMPLETE);
    }

    public OperationIncompleteException(final String message) {
        super(message, MomoErrorCodes.OPERATION_INCOMPLETE);
    }

    public OperationIncompleteException(final String message, final Throwable cause) {
        super(message, cause, MomoErrorCodes.OPERATION_INCOMPLETE);
    }
}
