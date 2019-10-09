package com.brainlesslabs.momo.common.policies;

import com.brainlesslabs.momo.common.exceptions.CompressionException;
import com.brainlesslabs.momo.common.utils.ByteSlice;

public interface CompressionPolicy {
    ByteSlice compress(final ByteSlice decompressedBytes) throws CompressionException;

    ByteSlice decompress(final ByteSlice compressedBytes) throws CompressionException;
}
