package org.javacommunity.utilitiez;

import org.javacommunity.utilitiez.console.ConsoleInit;
import org.javacommunity.utilitiez.fx.FxInit;
import org.javacommunity.utilitiez.services.analyzer.AnalyzerService;
import org.javacommunity.utilitiez.services.analyzer.hyperbeast.Analyzer;
import org.javacommunity.utilitiez.services.reporting.ReportingService;
import org.javacommunity.utilitiez.services.reporting.cinghiamenisco.CsvReportingServiceImpl;
import org.javacommunity.utilitiez.services.scavenger.ScavengerService;
import org.javacommunity.utilitiez.services.scavenger.hyperbeast.Scavenger;

import java.io.IOException;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.getDefault());

    /** 
     * Treat this method as it was your Main.
     * The code inside the startDebug method, is just a sample,
     * feel free to delete it and write your own.
     */
    
    private static void startDebug(String[] args) throws NoSuchAlgorithmException, IOException {

        // Testing my scavenger.
        ScavengerService myTestScavenger = new Scavenger();

        final List<Path> filesFound = myTestScavenger.findAll();

        System.out.println("I'm gonna print all the files I found!");
        filesFound.forEach(System.out::println);

        System.out.println();

        // Testing my analyzer
        AnalyzerService myTestAnalyzer = new Analyzer();

        int amountOfFilesToRetrieve = 10;
        final List<Path> biggestFiles = myTestAnalyzer.getBiggestFiles(filesFound, amountOfFilesToRetrieve);
        System.out.println("I'm gonna print the " + amountOfFilesToRetrieve + " biggest files: ");
        biggestFiles.forEach(System.out::println);

        System.out.println();

        final Set<Path> duplicates = myTestAnalyzer.getDuplicates(filesFound);
        System.out.println("I'm gonna print the duplicated files found: ");
        duplicates.forEach(System.out::println);


//        final Map<Path, String> unknownFiles = myTestAnalyzer.getUnknownFiles(filesFound);
//        System.out.println("I'm gonna print a map of the unknown files, and their most probable type");
//        unknownFiles.entrySet().forEach(System.out::println);

        // Testing my reporting service
//        ReportingService myTestReporting = new CsvReportingServiceImpl();
//        myTestReporting.generateReportForBiggestFile(biggestFiles);
//        myTestReporting.generateReportForDuplicates(duplicates);
//        myTestReporting.generateReportForUnknownFiles(unknownFiles);
    }

    /**************************************/
    /*** Ignore stuff over this comment ***/
    /**************************************/
    
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        logger.info(() -> messages.getString("main.start"));

        if (args.length == 0) {
            startDebug(args);
        } else if ("FX".equalsIgnoreCase(args[0])) {
            FxInit.main(args);
        } else if ("CONSOLE".equalsIgnoreCase(args[0])) {
            ConsoleInit.main(args);
        } else {
            throw new IllegalArgumentException(messages.getString("exception.unsupported.not-implemented"));
        }
    }

}
