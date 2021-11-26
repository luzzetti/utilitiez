package org.javacommunity.utilitiez.services.analyzer.cinghiamenisco;

import org.javacommunity.utilitiez.services.analyzer.AnalyzerService;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Christian Luzzetti
 * @created 2021/11/25 - 21:45
 */

public class NoOpAnalyzerServiceImpl implements AnalyzerService {

    @Override
    public Set<Path> getDuplicates(List<Path> files) {
        // This is a NoOp implementation. So, it does No Operations at all.
        return Collections.emptySet();
    }

    @Override
    public List<Path> getBiggestFiles(List<Path> files, int amountOfFiles) {
        // This is a NoOp implementation. So, it does No Operations at all.
        return Collections.emptyList();
    }

    @Override
    public Map<Path, String> getUnknownFiles(List<Path> files) {
        // This is a NoOp implementation. So, it does No Operations at all.
        return Collections.emptyMap();
    }
}
