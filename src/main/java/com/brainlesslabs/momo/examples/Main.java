package com.brainlesslabs.momo.examples;

import com.brainlesslabs.momo.common.exceptions.CompressionException;
import com.brainlesslabs.momo.common.options.Options;
import com.brainlesslabs.momo.common.policies.LZ4Strategy;
import com.brainlesslabs.momo.common.utils.ByteSlice;
import com.brainlesslabs.momo.common.utils.ConversionUtils;
import com.brainlesslabs.momo.impl.simplelinklist.LinkListOptions;

import java.nio.charset.StandardCharsets;

import static java.lang.System.out;

public class Main {
    private static void print(String string, Object... options) {
        out.printf(string, options);
        out.println();
    }

    public static void main(String... options) {
        singleLinkedList();
        compressionExample();
    }

    private static void singleLinkedList(String... options) {
        final Options opt = new LinkListOptions();
        print("%s", opt);
    }

    private static void compressionExample() {
        try {
            final String dataStr = "12345345234572testingtestingtestingtestinghello";
            final byte[] data = dataStr.trim().getBytes(StandardCharsets.UTF_8);
            print("Original String: %s with length: %s", dataStr, dataStr.length());
            final LZ4Strategy lz4Strategy = new LZ4Strategy();
            final ByteSlice orgData = new ByteSlice(data, data.length);
            final ByteSlice compressed = lz4Strategy.compress(orgData);
            print("Compressed: %s with length: %s", ConversionUtils.toString(compressed), compressed.getLength());
            final ByteSlice decompressed = lz4Strategy.decompress(compressed);
            final String decompressedStr = ConversionUtils.toString(decompressed);
            print("Decompressed: %s with length: %s", decompressedStr, decompressedStr.length());
        } catch (CompressionException e) {
            print("Exception: %s", e.getMessage());
        }
    }
}
