package org.javacommunity.utilitiez.services.reporting.cinghiamenisco;

/**
 * @author Christian Luzzetti
 * @created 2021/11/25 - 21:45
 */

import org.javacommunity.utilitiez.services.reporting.ReportingService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***
 * This is a No-Op class
 */
public class CsvReportingServiceImpl implements ReportingService {

    @Override
    public void generateReportForBiggestFile(List<Path> biggestFiles) {
        // Write the report into a .csv file
    }

    @Override
    public void generateReportForDuplicates(Set<Path> duplicates) {
        // Write the report into a .csv file
    }

    @Override
    public void generateReportForUnknownFiles(Map<Path, String> unknownFiles) {
        // Write the report into a .csv file
    }
}
