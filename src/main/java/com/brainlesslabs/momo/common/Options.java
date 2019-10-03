package com.brainlesslabs.momo.common;

import com.brainlesslabs.momo.common.consts.CompressionMode;
import com.brainlesslabs.momo.common.consts.CreateOptions;
import com.brainlesslabs.momo.common.consts.EncryptionMode;
import org.slf4j.Logger;

public abstract class Options implements Cloneable {
    private int keySize;
    private int flushDataSize;
    private EncryptionMode encryptionMode;
    private CompressionMode compressionMode;
    private CreateOptions createOptions;
    private Logger logger;

    public int getKeySize() {
        return keySize;
    }

    public void setKeySize(int keySize) {
        this.keySize = keySize;
    }

    public int getFlushDataSize() {
        return flushDataSize;
    }

    public void setFlushDataSize(int flushDataSize) {
        this.flushDataSize = flushDataSize;
    }

    public EncryptionMode getEncryptionMode() {
        return encryptionMode;
    }

    public void setEncryptionMode(EncryptionMode encryptionMode) {
        this.encryptionMode = encryptionMode;
    }

    public CompressionMode getCompressionMode() {
        return compressionMode;
    }

    public void setCompressionMode(CompressionMode compressionMode) {
        this.compressionMode = compressionMode;
    }

    public CreateOptions getCreateOptions() {
        return createOptions;
    }

    public void setCreateOptions(CreateOptions createOptions) {
        this.createOptions = createOptions;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
