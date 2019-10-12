package com.brainlesslabs.momo.common;

import com.brainlesslabs.momo.common.exceptions.MomoException;
import com.brainlesslabs.momo.common.options.Options;
import com.brainlesslabs.momo.common.options.ReadOptions;
import com.brainlesslabs.momo.common.options.WriteOptions;
import com.brainlesslabs.momo.common.utils.DbStatus;
import com.brainlesslabs.momo.common.utils.MomoIterator;
import com.brainlesslabs.momo.common.utils.Snapshot;
import lombok.NonNull;

public interface MomoBase {
    void open(@NonNull final Options options, Object... params) throws MomoException;

    void put(@NonNull final WriteOptions writeOptions, @NonNull final byte[] key, @NonNull final byte[] value) throws MomoException;

    byte[] get(@NonNull final ReadOptions readOptions, @NonNull final byte[] key) throws MomoException;

    void delete(@NonNull final WriteOptions writeOptions, @NonNull final byte[] key) throws MomoException;

    MomoIterator getIterator() throws MomoException;

    DbStatus getDbStatus() throws MomoException;

    void close() throws MomoException;

    Snapshot snapshot() throws MomoException;

    void destroyDb() throws MomoException;
}
