package com.brainlesslabs.momo.common.policies;

import com.brainlesslabs.momo.common.exceptions.MomoException;
import com.brainlesslabs.momo.common.options.Options;
import com.brainlesslabs.momo.common.options.ReadOptions;
import com.brainlesslabs.momo.common.options.WriteOptions;
import com.brainlesslabs.momo.common.utils.ByteSlice;
import com.brainlesslabs.momo.common.utils.MomoIterator;
import com.brainlesslabs.momo.common.utils.Snapshot;
import lombok.NonNull;

public interface StoragePolicy {
    void put(@NonNull final WriteOptions writeOptions, @NonNull final ByteSlice key, @NonNull final ByteSlice value) throws MomoException;

    ByteSlice get(@NonNull final ReadOptions readOptions, @NonNull final ByteSlice key) throws MomoException;

    void open(final Options options, Object... params) throws MomoException;

    void delete(@NonNull final WriteOptions writeOptions, @NonNull final byte[] key) throws MomoException;

    void close() throws MomoException;

    void destroyDb() throws MomoException;

    MomoIterator getIterator() throws MomoException;

    Snapshot snapshot() throws MomoException;
}
