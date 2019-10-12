package com.brainlesslabs.momo.impl.simplefilelinklist;

import com.brainlesslabs.momo.common.MomoBase;
import com.brainlesslabs.momo.common.exceptions.MomoException;
import com.brainlesslabs.momo.common.options.Options;
import com.brainlesslabs.momo.common.options.ReadOptions;
import com.brainlesslabs.momo.common.options.WriteOptions;
import com.brainlesslabs.momo.common.utils.DbStatus;
import com.brainlesslabs.momo.common.utils.MomoIterator;
import com.brainlesslabs.momo.common.utils.Snapshot;

public class MomoSimpleFileLinkedList implements MomoBase {
    @Override
    public void open(Options options, Object... params) throws MomoException {

    }

    @Override
    public void put(WriteOptions writeOptions, byte[] key, byte[] value) throws MomoException {

    }

    @Override
    public byte[] get(ReadOptions readOptions, byte[] key) throws MomoException {
        return new byte[0];
    }

    @Override
    public void delete(WriteOptions writeOptions, byte[] key) throws MomoException {

    }

    @Override
    public MomoIterator getIterator() throws MomoException {
        return null;
    }

    @Override
    public DbStatus getDbStatus() throws MomoException {
        return null;
    }

    @Override
    public void close() throws MomoException {

    }

    @Override
    public Snapshot snapshot() throws MomoException {
        return null;
    }

    @Override
    public void destroyDb() throws MomoException {

    }
}
