package org.javacommunity.utilitiez.services.scavenger.cinghiamenisco;

import org.javacommunity.utilitiez.services.scavenger.ScavengerService;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Christian Luzzetti
 * @created 2021/11/26 - 20:28
 */

public class MultithreadScavengerServiceImpl implements ScavengerService {
    @Override
    public List<Path> findAll() {
        // Write an implementation that goes to scavenge the files in the filesystem, by using parallel processing
        return Collections.emptyList();
    }

    @Override
    public List<Path> findAll(Predicate<Path> filter) {
        // Write an implementation that goes to scavenge the files in the filesystem, by using parallel processing
        return Collections.emptyList();
    }
}
