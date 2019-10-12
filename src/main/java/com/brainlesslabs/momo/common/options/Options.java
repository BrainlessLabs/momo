package com.brainlesslabs.momo.common.options;

import com.brainlesslabs.momo.common.consts.CompressionMode;
import com.brainlesslabs.momo.common.consts.CreateOptions;
import com.brainlesslabs.momo.common.consts.EncryptionMode;
import com.brainlesslabs.momo.common.policies.CompressionPolicy;
import com.brainlesslabs.momo.common.policies.HashPolicy;
import com.brainlesslabs.momo.common.policies.StoragePolicy;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.slf4j.Logger;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode
public abstract class Options implements Cloneable {
    private int keySize;
    private int flushDataSize;
    private EncryptionMode encryptionMode;
    private CompressionMode compressionMode;
    private CreateOptions createOptions;
    private Logger logger;

    private HashPolicy hashPolicy;
    private CompressionPolicy compressionPolicy;
    private StoragePolicy storagePolicy;

    public abstract boolean ok();
}
