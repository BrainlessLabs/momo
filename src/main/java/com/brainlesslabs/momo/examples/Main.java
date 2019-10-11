package com.brainlesslabs.momo.examples;

import com.brainlesslabs.momo.common.exceptions.CompressionException;
import com.brainlesslabs.momo.common.exceptions.HashException;
import com.brainlesslabs.momo.common.options.Options;
import com.brainlesslabs.momo.common.policies.*;
import com.brainlesslabs.momo.common.utils.ByteSlice;
import com.brainlesslabs.momo.common.utils.ConversionUtils;
import com.brainlesslabs.momo.common.utils.StopWatch;
import com.brainlesslabs.momo.impl.simplefilelinklist.LinkListOptions;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;
import net.jpountz.lz4.LZ4SafeDecompressor;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Main {
    private static void print(String string, Object... options) {
        out.printf(string, options);
        out.println();
    }

    public static void main(String... options) {
        singleLinkedList();
        final String dataStr = "12345345234572testingtestingtestingtestinghello";
        compressionExample(dataStr);
        compressionExampleOrg(dataStr);
        hashExample();
    }

    private static void singleLinkedList(String... options) {
        final Options opt = new LinkListOptions();
        print("%s", opt);
    }

    private static void hashExample() {
        final Random random = new Random();
        final int MAX_VALUE = 1000;
        final int MIN_VALUE = 0;
//        final int MODULO_VALUE = 127; // https://en.wikipedia.org/wiki/Mersenne_prime
        final int MODULO_VALUE = 257; // https://en.wikipedia.org/wiki/Fermat_number
        final IntStream intStream = IntStream.range(MIN_VALUE, MAX_VALUE);
        final PrimitiveIterator.OfInt ofInt = intStream.iterator();
        final StopWatch stopWatch = new StopWatch();
        final ByteSlice byteSlice = new ByteSlice();
        final HashPolicy xxHashing = new XXHashing();
        long v = 0;
        int m = 0;
        final int[] counts = new int[MODULO_VALUE];
        while (ofInt.hasNext()) {
            final int next = ofInt.nextInt();
            final byte[] bytes = new byte[next];
            random.nextBytes(bytes);
            byteSlice.setBytes(bytes, bytes.length);
            try {
                v = xxHashing.hashToLong(byteSlice);
                m = (int)Math.abs(v % MODULO_VALUE);
                counts[m] += 1;
                print("Modulo: %d, Hash Value: %d",m , v);
            } catch (HashException e) {
                print("Exception: %s", e.getMessage());
            }
        }
        stopWatch.stop();
        print("Values: %s", Arrays.toString(counts));
        print("Max Values: %s", Arrays.stream(counts).max().getAsInt());
        print("Time in mili: %s%n", stopWatch.durationMillis());
    }

    private static void compressionExample(final String dataStr) {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        CompressionPolicy compressionPolicy = new LZ4Compression();
        compressionExample(dataStr, compressionPolicy);
        stopWatch.stop();
        print("Time in mili: %s\n", stopWatch.durationMillis());
        stopWatch.start();
        compressionPolicy = new SnappyCompression();
        compressionExample(dataStr, compressionPolicy);
        stopWatch.stop();
        print("Time in mili: %s%n", stopWatch.durationMillis());
    }

    private static void compressionExample(final String dataStr, final CompressionPolicy compressionPolicy) {
        try {
            print("====compressionExample==== %s", compressionPolicy);
            final byte[] data = dataStr.getBytes(StandardCharsets.UTF_8);
            print("Original String: %s with length: %s", dataStr, dataStr.length());
            print("Original String: %s with length: %s", data, data.length);
            final ByteSlice orgData = new ByteSlice(data, data.length);
            final ByteSlice compressed = compressionPolicy.compress(orgData);
            print("Compressed: %s with length: %s", ConversionUtils.toString(compressed), compressed.getBytes().length);
            final ByteSlice decompressed = compressionPolicy.decompress(compressed);
            final String decompressedStr = ConversionUtils.toString(decompressed);
            print("Decompressed: %s with length: %s", decompressedStr, decompressedStr.length());
        } catch (CompressionException e) {
            print("Exception: %s", e.getMessage());
        }
    }

    private static void compressionExampleOrg(final String dataStr) {
        try {
            print("====compressionExampleOrg====");
            LZ4Factory factory = LZ4Factory.fastestInstance();
            byte[] data = dataStr.getBytes(StandardCharsets.UTF_8);
            final int decompressedLength = data.length;
            print("Original String: %s with length: %s", dataStr, dataStr.length());
            print("Original String: %s with length: %s", data, data.length);
            // compress data
            LZ4Compressor compressor = factory.fastCompressor();
            int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
            byte[] compressed = new byte[maxCompressedLength];
            int compressedLength = compressor.compress(data, 0, decompressedLength, compressed, 0, maxCompressedLength);
            print("Compressed: %s with length: %s", ConversionUtils.toString(compressed), compressedLength);
            // decompress data
            // - method 1: when the decompressed length is known
            LZ4FastDecompressor decompressor = factory.fastDecompressor();
            byte[] restored = new byte[decompressedLength];
            int compressedLength2 = decompressor.decompress(compressed, 0, restored, 0, decompressedLength);
            // compressedLength == compressedLength2
            String decompressedStr = ConversionUtils.toString(restored);
            print("Decompressed: %s with length: %s", decompressedStr, decompressedStr.length());
            // - method 2: when the compressed length is known (a little slower)
            // the destination buffer needs to be over-sized
            restored = new byte[decompressedLength];
            LZ4SafeDecompressor decompressor2 = factory.safeDecompressor();
            int decompressedLength2 = decompressor2.decompress(compressed, 0, compressedLength, restored, 0);
            decompressedStr = ConversionUtils.toString(restored);
            print("Decompressed: %s with length: %s", decompressedStr, decompressedStr.length());
            // decompressedLength == decompressedLength2
        } catch (Exception e) {
            print("Exception: %s", e);
        }
    }
}
