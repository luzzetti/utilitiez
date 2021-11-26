package org.javacommunity.utilitiez.services.analyzer;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Christian Luzzetti
 * @created 2021/11/25 - 20:21
 */

public interface AnalyzerService {

    /***
     * The method should look for duplicated files
     *
     * @return a Set of all the duplicated files.
     */
    Set<Path> getDuplicates(List<Path> files);

    /***
     *
     * @param  amountOfFiles: the amount of files you want in output
     *                      Example: 10
     *                      Will return the 10 biggest file found
     * @return the biggest files
     */
    List<Path> getBiggestFiles(List<Path> files, int amountOfFiles);

    /***
     *
     * Info: https://en.wikipedia.org/wiki/List_of_file_signatures
     *
     * @return all the files without extensions, and a string with the most probable type
     *
     */
    Map<Path, String> getUnknownFiles(List<Path> files);

}
