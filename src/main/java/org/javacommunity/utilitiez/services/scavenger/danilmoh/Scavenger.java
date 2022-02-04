package org.javacommunity.utilitiez.services.scavenger.danilmoh;

import org.javacommunity.utilitiez.services.scavenger.ScavengerService;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Scavenger implements ScavengerService {
    private static final Path root = Paths.get(System.getProperty("user.home"));

    @Override
    public List<Path> findAll() { // returns only the files from the home directory
        return findAll(root);
    }

    private static List<Path> findAll(Path path) {
        List<Path> currentFiles = new ArrayList<>();
        for(File file : Objects.requireNonNull(path.toFile().listFiles())) {
            if(file.exists())
                if(file.isDirectory()) {
                    currentFiles.addAll(findAll(file.toPath()));
                } else {
                    currentFiles.add(file.toPath());
                }
        }
        return currentFiles;
    }

    @Override
    public List<Path> findAll(Predicate<Path> filter) {
        return findAll(root, filter);
    }

    private static List<Path> findAll(Path path, Predicate<Path> filter) {
        List<Path> currentFiles = new ArrayList<>();
        for(File file : Objects.requireNonNull(path.toFile().listFiles())) {
            if(file.exists())
                if(file.isDirectory()) {
                    currentFiles.addAll(findAll(file.toPath(), filter));
                } else if(filter.test(file.toPath())){
                    currentFiles.add(file.toPath());
                }
        }

        return currentFiles;
    }
}
