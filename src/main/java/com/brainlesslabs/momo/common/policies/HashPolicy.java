package com.brainlesslabs.momo.common.policies;

import com.brainlesslabs.momo.common.exceptions.HashException;
import com.brainlesslabs.momo.common.utils.ByteSlice;
import com.brainlesslabs.momo.common.utils.ConversionUtils;

import java.io.IOException;

public interface HashPolicy {
    default long hashToLong(final Object valueToHash) throws HashException {
        long hashLong;
        try {
            final byte[] value = ConversionUtils.toByteArray(valueToHash);
            hashLong = hashToLong(value);
        } catch (IOException e) {
            throw new HashException(String.format("Could not hash due to exception: %s", e.getMessage()));
        }
        return hashLong;
    }

    long hashToLong(final ByteSlice valueToHash) throws HashException;
}
