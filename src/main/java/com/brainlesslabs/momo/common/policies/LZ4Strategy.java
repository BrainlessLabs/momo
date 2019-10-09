package com.brainlesslabs.momo.common.policies;

import com.brainlesslabs.momo.common.exceptions.CompressionException;
import com.brainlesslabs.momo.common.utils.ByteSlice;
import lombok.NonNull;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4SafeDecompressor;

public class LZ4Strategy implements CompressionPolicy {
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
            final int compressedLength =
                    compressor.compress(data.getBytes(), 0, data.getLength(),
                            compressed, 0, maxCompressedLength);
            byteSlice = new ByteSlice(compressed, compressedLength);
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
        final LZ4SafeDecompressor decompressor = factory.safeDecompressor();
        ByteSlice byteSlice;
        try {
            byte[] restored = new byte[compressed.getLength()];
            final int decompressedLength =
                    decompressor.decompress(compressed.getBytes(), 0,
                            compressed.getLength(), restored, 0);
            byteSlice = new ByteSlice(restored, decompressedLength);
        } catch (LZ4Exception e) {
            throw new CompressionException(String.format("Could not decompress with error: %s", e.getMessage()));
        }
        return byteSlice;
    }
}
