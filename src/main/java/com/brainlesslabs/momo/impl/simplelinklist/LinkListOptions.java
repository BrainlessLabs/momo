package com.brainlesslabs.momo.impl.simplelinklist;

import com.brainlesslabs.momo.common.options.Options;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString(callSuper = true)
public class LinkListOptions extends Options {
    @Override
    public boolean ok() {
        boolean result = true;
        if (getFlushDataSize() < 0 || getKeySize() < 0) {
            result = false;
        }
        return result;
    }
}
