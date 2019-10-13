package com.brainlesslabs.momo.impl.simplefilelinklist;

import com.brainlesslabs.momo.common.MomoBase;
import com.brainlesslabs.momo.common.options.Options;
import com.brainlesslabs.momo.common.policies.CompressionPolicy;
import com.brainlesslabs.momo.common.policies.StoragePolicy;

public class MomoSimpleFileLinkedList extends MomoBase {
    public MomoSimpleFileLinkedList(StoragePolicy storagePolicy, Options options, CompressionPolicy compressionPolicy) {
        super(storagePolicy, options, compressionPolicy);
    }
}
