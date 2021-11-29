package org.javacommunity.utilitiez.services.reporting.hyperbeast;

import org.javacommunity.utilitiez.services.reporting.ReportingService;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Reporting implements ReportingService {
    @Override
    public void generateReportForBiggestFile(List<Path> biggestFiles) {

    }

    @Override
    public void generateReportForDuplicates(Set<Path> duplicates) {

    }

    @Override
    public void generateReportForUnknownFiles(Map<Path, String> unknownFiles) {

    }
}
