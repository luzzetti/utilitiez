package org.javacommunity.utilitiez.services.reporting;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Christian Luzzetti
 * @created 2021/11/25 - 20:23
 */

public interface ReportingService {

    void generateReportForBiggestFile(List<Path> biggestFiles);

    void generateReportForDuplicates(Set<Path> duplicates);

    void generateReportForUnknownFiles(Map<Path, String> unknownFiles);

}
