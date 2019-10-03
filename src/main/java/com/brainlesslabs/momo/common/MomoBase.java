package com.brainlesslabs.momo.common;

import com.brainlesslabs.momo.common.exceptions.MomoException;

public interface MomoBase {
    void open(final Options options, Object... params) throws MomoException;

    void put(final WriteOptions writeOptions, final byte[] key, final byte[] value) throws MomoException;

    byte[] get(final ReadOptions readOptions, final byte[] key) throws MomoException;

    void delete(final WriteOptions writeOptions, final byte[] key) throws MomoException;

    MomoIterator getIterator() throws MomoException;

    DbStatus getDbStatus() throws MomoException;

    void close() throws MomoException;

    Snapshot snapshot() throws MomoException;

    void destroyDb() throws MomoException;
}
