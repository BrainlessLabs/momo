package com.brainlesslabs.momo.common.policies;

import com.brainlesslabs.momo.common.exceptions.CompressionException;
import com.brainlesslabs.momo.common.utils.ByteSlice;
import lombok.NonNull;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

public class LZ4Compression implements CompressionPolicy {
    private static LZ4Factory factory = LZ4Factory.fastestInstance();

    @Override
    public ByteSlice compress(@NonNull final ByteSlice data) throws CompressionException {
        if (data.getLength() == 0) {
            throw new CompressionException("Empty data for compression");
        }

        ByteSlice byteSlice;
        try {
            final LZ4Compressor compressor = factory.fastCompressor();
            final int maxCompressedLength = compressor.maxCompressedLength(data.getLength());
            byte[] compressed = new byte[maxCompressedLength];
            compressor.compress(data.getBytes(), 0, data.getLength(),
                    compressed, 0, maxCompressedLength);
            byteSlice = new ByteSlice(compressed, data.getLength());
        } catch (LZ4Exception e) {
            throw new CompressionException(String.format("Could not compress with error: %s", e.getMessage()));
        }

        return byteSlice;
    }

    @Override
    public ByteSlice decompress(@NonNull ByteSlice compressed) throws CompressionException {
        if (compressed.getLength() == 0) {
            throw new CompressionException("Empty data for decompression");
        }
        final LZ4FastDecompressor decompressor = factory.fastDecompressor();
        ByteSlice byteSlice;
        try {
            byte[] restored = new byte[compressed.getLength()];
            decompressor.decompress(compressed.getBytes(), 0,
                    restored, 0, compressed.getLength());
            byteSlice = new ByteSlice(restored, compressed.getLength());
        } catch (LZ4Exception e) {
            throw new CompressionException(String.format("Could not decompress with error: %s", e.getMessage()));
        }
        return byteSlice;
    }
}
