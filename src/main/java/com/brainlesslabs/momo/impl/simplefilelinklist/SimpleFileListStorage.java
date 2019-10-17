package com.brainlesslabs.momo.impl.simplefilelinklist;

import com.brainlesslabs.momo.common.exceptions.FileOperationException;
import com.brainlesslabs.momo.common.exceptions.MomoException;
import com.brainlesslabs.momo.common.options.Options;
import com.brainlesslabs.momo.common.options.ReadOptions;
import com.brainlesslabs.momo.common.options.WriteOptions;
import com.brainlesslabs.momo.common.policies.StoragePolicy;
import com.brainlesslabs.momo.common.utils.ByteSlice;
import com.brainlesslabs.momo.common.utils.MomoIterator;
import com.brainlesslabs.momo.common.utils.SimpleLRUCache;
import com.brainlesslabs.momo.common.utils.Snapshot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class SimpleFileListStorage implements StoragePolicy {
    private static final int MAX_HASH_INDEX_SIZE = 257;
    private static final String OBJECTS_DIRECTORY = "objects";
    private static final String HEAD = "HEAD";
    private static final String REFS = "REFS";
    private static final String VERSION = "1";

    private SimpleLRUCache<Long, FileOutputStream> indexFiles;
    private Path rootDbPath;
    private Map<Long, Path> indexKeysPresent = new HashMap<>();

    @Getter
    private final String dbName;

    @Override
    public void put(@NonNull WriteOptions writeOptions, @NonNull ByteSlice key, @NonNull ByteSlice value) throws MomoException {

    }

    @Override
    public ByteSlice get(@NonNull ReadOptions readOptions, @NonNull ByteSlice key) throws MomoException {
        return null;
    }

    @Override
    public void open(Options options, Object... params) throws MomoException {
        createStructure();
    }

    @Override
    public void delete(@NonNull WriteOptions writeOptions, @NonNull byte[] key) throws MomoException {

    }

    @Override
    public void close() throws MomoException {
        indexFiles.clear();
    }

    @Override
    public void destroyDb() throws MomoException {
        if(Files.exists(rootDbPath)){
            try {
                Files.delete(rootDbPath);
            } catch (IOException e) {
                throw new FileOperationException("Cannot destroy db with cause: " + e.getMessage());
            }
        }
    }

    @Override
    public MomoIterator getIterator() throws MomoException {
        return null;
    }

    @Override
    public Snapshot snapshot() throws MomoException {
        return null;
    }

    private void createStructure() throws FileOperationException {
        final Path dbPath = Paths.get(dbName);
        if(Files.exists(dbPath)){
            try {
                rootDbPath = Files.createDirectories(dbPath);
            } catch (IOException e) {
               throw new FileOperationException("Cannot create db structure with reason: " + e.getMessage());
            }
        }
    }
}
