package com.brainlesslabs.momo.common.utils;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString
public class ByteSlice {
    @Getter
    private byte[] bytes;
    @Getter
    private int length;

    public ByteSlice(@NonNull final byte[] bytes, final int length) {
        setBytes(bytes, length);
    }

    public void setBytes(final byte[] bytes, int length) {
        this.bytes = bytes;
        this.length = length;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ByteSlice)) return false;
        final ByteSlice other = (ByteSlice) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.length != other.length) return false;
        return java.util.Arrays.equals(this.bytes, 0, length, other.bytes, 0, length);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ByteSlice;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + java.util.Arrays.hashCode(this.bytes);
        result = result * PRIME + this.length;
        return result;
    }
}
