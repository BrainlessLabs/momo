package com.brainlesslabs.momo.common.policies;

import com.brainlesslabs.momo.common.exceptions.MomoException;
import com.brainlesslabs.momo.common.options.Options;
import com.brainlesslabs.momo.common.options.WriteOptions;
import com.brainlesslabs.momo.common.utils.ByteSlice;
import lombok.NonNull;

public interface StoragePolicy {
    void put(@NonNull final ByteSlice key, @NonNull final ByteSlice value) throws MomoException;

    ByteSlice get(@NonNull final ByteSlice key) throws MomoException;

    void open(final Options options, Object... params) throws MomoException;

    void delete(@NonNull final WriteOptions writeOptions, @NonNull final byte[] key) throws MomoException;

    void close() throws MomoException;

    void destroyDb() throws MomoException;
}
