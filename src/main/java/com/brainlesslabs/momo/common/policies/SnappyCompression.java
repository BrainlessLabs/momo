package com.brainlesslabs.momo.common.policies;

import com.brainlesslabs.momo.common.exceptions.CompressionException;
import com.brainlesslabs.momo.common.utils.ByteSlice;
import org.xerial.snappy.Snappy;
import lombok.NonNull;

import java.io.IOException;

public class SnappyCompression implements CompressionPolicy {
    @Override
    public ByteSlice compress(@NonNull ByteSlice data) throws CompressionException {
        if (data.getLength() == 0) {
            throw new CompressionException("Empty data for compression");
        }

        ByteSlice byteSlice;
        try {
            final byte[] compressed = Snappy.compress(data.getBytes());
            byteSlice = new ByteSlice(compressed, compressed.length);
        } catch (IOException e) {
            throw new CompressionException(String.format("Could not compress with error: %s", e.getMessage()));
        }
        return byteSlice;
    }

    @Override
    public ByteSlice decompress(@NonNull ByteSlice compressed) throws CompressionException {
        if (compressed.getLength() == 0) {
            throw new CompressionException("Empty data for decompression");
        }
        ByteSlice byteSlice;
        try {
            final byte[] uncompressed = Snappy.uncompress(compressed.getBytes());
            byteSlice = new ByteSlice(uncompressed, uncompressed.length);
        } catch (IOException e) {
            throw new CompressionException(String.format("Could not decompress with error: %s", e.getMessage()));
        }
        return byteSlice;
    }
}
