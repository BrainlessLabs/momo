package com.brainlesslabs.momo.common.policies;

import com.brainlesslabs.momo.common.exceptions.HashException;
import com.brainlesslabs.momo.common.utils.ByteSlice;
import net.jpountz.xxhash.XXHash64;
import net.jpountz.xxhash.XXHashFactory;

public class XXHashing implements HashPolicy {
    private static final XXHashFactory xxHashFactory = XXHashFactory.fastestInstance();
    private static final int SEED = 0x9747b28c;
    private final XXHash64 xxHash64 = xxHashFactory.hash64();

    @Override
    public long hashToLong(final ByteSlice valueToHash) throws HashException {
        return xxHash64.hash(valueToHash.getBytes(), 0, valueToHash.getLength(), SEED);
    }
}
