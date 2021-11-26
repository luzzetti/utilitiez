package org.javacommunity.utilitiez.services.scavenger.cinghiamenisco;

import org.javacommunity.utilitiez.services.scavenger.ScavengerService;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Christian Luzzetti
 * @created 2021/11/25 - 20:28
 */

public class NoOpScavengerServiceImpl implements ScavengerService {

    @Override
    public List<Path> findAll() {
        // This is a NoOp implementation. So, it does No Operations at all.
        return Collections.emptyList();
    }

    @Override
    public List<Path> findAll(Predicate<Path> filter) {
        // This is a NoOp implementation. So, it does No Operations at all.
        return Collections.emptyList();
    }

}
