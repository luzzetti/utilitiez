package org.javacommunity.utilitiez.services.scavenger.hyperbeast;

import org.javacommunity.utilitiez.services.scavenger.ScavengerService;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

public class Scavenger implements ScavengerService {
    final private List<Path> list = new ArrayList<>();

    @Override
    public List<Path> findAll() {
        Path path = Paths.get("C:", "Users", "serge", "OneDrive", "Desktop", "test");

        File dir = new File(String.valueOf(path));

        searchFiles(dir);

        return list;
    }

    private void searchFiles(File dir) {
        if(dir.isDirectory()) {
            for(File item : Objects.requireNonNull(dir.listFiles())) {
                if (item.isDirectory()) {
                    searchFiles(item);
                } else {
                    list.add(item.toPath());
                }
            }
        }
    }

    @Override
    public List<Path> findAll(Predicate<Path> filter) {
        File dir = new File(String.valueOf(filter));

        searchFiles(dir);

        return list;
    }
}
