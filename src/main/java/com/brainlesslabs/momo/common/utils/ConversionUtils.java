package com.brainlesslabs.momo.common.utils;

import lombok.NonNull;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Code taken from
 * http://www.java2s.com/Code/Java/File-Input-Output/Convertobjecttobytearrayandconvertbytearraytoobject.htm
 */
public class ConversionUtils {
    private ConversionUtils() {
    }

    public static byte[] toByteArray(@NonNull final Object obj) throws IOException {
        byte[] bytes;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
        }
        return bytes;
    }

    public static Object toObject(@NonNull final byte[] bytes) throws IOException, ClassNotFoundException {
        Object obj;
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            obj = ois.readObject();
        }
        return obj;
    }

    public static String toString(@NonNull byte[] bytes) {
        return new String(bytes);
    }

    public static String toString(@NonNull ByteSlice bytes) {
        return new String(bytes.getBytes(), 0, bytes.getLength());
    }

    public static byte[] toByteArray(@NonNull final String string) {
        return string.getBytes(StandardCharsets.UTF_8);
    }

    public static ByteSlice toByteSlice(@NonNull final String string) {
        final byte[] bytes = toByteArray(string);
        final ByteSlice byteSlice = new ByteSlice(bytes, bytes.length);
        return byteSlice;
    }
}
