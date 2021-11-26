package org.javacommunity.utilitiez.services.reporting.cinghiamenisco;

import org.javacommunity.utilitiez.services.reporting.ReportingService;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Christian Luzzetti
 * @created 2021/11/26 - 20:28
 */

public class TxtReportingServiceImpl implements ReportingService {
    @Override
    public void generateReportForBiggestFile(List<Path> biggestFiles) {
        // Write a report into a txt files
    }

    @Override
    public void generateReportForDuplicates(Set<Path> duplicates) {
        // Write a report into a txt files
    }

    @Override
    public void generateReportForUnknownFiles(Map<Path, String> unknownFiles) {
        // Write a report into a txt files
    }
}
