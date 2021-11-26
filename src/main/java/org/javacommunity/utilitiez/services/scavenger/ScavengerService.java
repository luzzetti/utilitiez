package org.javacommunity.utilitiez.services.scavenger;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Christian Luzzetti
 * @created 2021/11/25 - 20:26
 */

public interface ScavengerService {

    /***
     *
     * @return a List of all the regular files that have been found
     */
    List<Path> findAll();

    /***
     *  Overloaded method. Scavenge all the files that matches the filter predicate
     *
     * @return a List of all the regular files matching the predicate
     */
    List<Path> findAll(Predicate<Path> filter);

}
