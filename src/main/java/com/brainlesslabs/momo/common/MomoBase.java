package com.brainlesslabs.momo.common;

import com.brainlesslabs.momo.common.exceptions.MomoException;
import com.brainlesslabs.momo.common.options.Options;
import com.brainlesslabs.momo.common.options.ReadOptions;
import com.brainlesslabs.momo.common.options.WriteOptions;
import com.brainlesslabs.momo.common.policies.CompressionPolicy;
import com.brainlesslabs.momo.common.policies.StoragePolicy;
import com.brainlesslabs.momo.common.utils.ByteSlice;
import com.brainlesslabs.momo.common.utils.DbStatus;
import com.brainlesslabs.momo.common.utils.MomoIterator;
import com.brainlesslabs.momo.common.utils.Snapshot;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public abstract class MomoBase {
    private StoragePolicy storagePolicy;
    private Options options;
    private CompressionPolicy compressionPolicy;

    void open(Object... params) throws MomoException {
        storagePolicy.open(options, params);
    }

    void put(@NonNull final WriteOptions writeOptions,
             @NonNull final byte[] key,
             @NonNull final byte[] value) throws MomoException {
        ByteSlice keySlice = new ByteSlice(key, key.length);
        ByteSlice valueSlice = new ByteSlice(value, value.length);
        if (isCompressionEnabled()) {
            valueSlice = compressionPolicy.compress(valueSlice);
        }
        storagePolicy.put(writeOptions, keySlice, valueSlice);
    }

    byte[] get(@NonNull final ReadOptions readOptions, @NonNull final byte[] key) throws MomoException {
        ByteSlice keySlice = new ByteSlice(key, key.length);
        ByteSlice valueSlice = storagePolicy.get(readOptions, keySlice);
        if(isCompressionEnabled()) {
            valueSlice = compressionPolicy.decompress(valueSlice);
        }
        return valueSlice.getBytes();
    }

    void delete(@NonNull final WriteOptions writeOptions, @NonNull final byte[] key) throws MomoException {
        storagePolicy.delete(writeOptions, key);
    }

    MomoIterator getIterator() throws MomoException {
        return storagePolicy.getIterator();
    }

    DbStatus getDbStatus() throws MomoException {
        return null;
    }

    void close() throws MomoException {
        storagePolicy.close();
    }

    Snapshot snapshot() throws MomoException {
        return storagePolicy.snapshot();
    }

    void destroyDb() throws MomoException {
        storagePolicy.destroyDb();
    }

    private boolean isCompressionEnabled() {
        boolean result;
        switch (options.getCompressionMode()) {
            case DEFAULT:
            case DO_NOT_COMPRESS:
                result  = false;
                break;
            case COMPRESS:
            default:
                result = true;
        }
        return result;
    }
}
