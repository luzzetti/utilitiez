package org.javacommunity.utilitiez.console;

import org.javacommunity.utilitiez.services.analyzer.AnalyzerService;
import org.javacommunity.utilitiez.services.reporting.ReportingService;
import org.javacommunity.utilitiez.services.scavenger.ScavengerService;
import org.reflections.Reflections;

import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * @author Christian Luzzetti
 * @created 2021/11/26 - 19:55
 */

public class ConsoleInit {

    private static ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.getDefault());

    private static final Logger logger = Logger.getLogger(ConsoleInit.class.getName());

    private static List<ScavengerService> scavengers = initScavengers();
    private static List<AnalyzerService> analyzers = initAnalyzers();
    private static List<ReportingService> reporters = initReporters();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        ScavengerService selectedScavenger;
        AnalyzerService selectedAnalyzer;
        ReportingService selectedReporter;

        System.out.println(messages.getString("console.choose.scavenger"));
        IntStream.range(0, scavengers.size())
                        .forEach(i -> printIndexAndName(i, scavengers.get(i).getClass().getSimpleName()));
        int userChoice;
        userChoice = Integer.parseInt(scanner.nextLine().trim());
        selectedScavenger = scavengers.get(userChoice);

        System.out.println(messages.getString("console.choose.analyzer"));
        IntStream.range(0, analyzers.size())
                .forEach(i -> printIndexAndName(i, analyzers.get(i).getClass().getSimpleName()));
        userChoice = Integer.parseInt(scanner.nextLine().trim());
        selectedAnalyzer = analyzers.get(userChoice);

        System.out.println(messages.getString("console.choose.reporter"));
        IntStream.range(0, reporters.size())
                .forEach(i -> printIndexAndName(i, reporters.get(i).getClass().getSimpleName()));
        userChoice = Integer.parseInt(scanner.nextLine().trim());
        selectedReporter = reporters.get(userChoice);

        final List<Path> allFiles = selectedScavenger.findAll();
        final List<Path> biggestFiles = selectedAnalyzer.getBiggestFiles(allFiles, 10);
        selectedReporter.generateReportForBiggestFile(biggestFiles);

        logger.warning(() -> messages.getString("console.terminated"));

    }

    private static void printIndexAndName(int i, String simpleName) {
        System.out.println(String.format("%d. %s", i, simpleName));
    }

    private static List<AnalyzerService> initAnalyzers() {
        Reflections reflections = new Reflections(AnalyzerService.class.getPackageName());
        return reflections.getSubTypesOf(AnalyzerService.class)
                .stream()
                .map(ConsoleInit::instantiateAnalyzer)
                .toList();
    }

    private static List<ReportingService> initReporters() {
        Reflections reflections = new Reflections(ReportingService.class.getPackageName());
        return reflections.getSubTypesOf(ReportingService.class)
                .stream()
                .map(ConsoleInit::instantiateReporter)
                .toList();
    }

    private static List<ScavengerService> initScavengers() {
        Reflections reflections = new Reflections(ScavengerService.class.getPackageName());
        return reflections.getSubTypesOf(ScavengerService.class)
                .stream()
                .map(ConsoleInit::instantiateScavenger)
                .toList();
    }

    private static ScavengerService instantiateScavenger(Class<? extends ScavengerService> aClass) {
        try {
            return aClass.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            return null;
        }
    }

    private static AnalyzerService instantiateAnalyzer(Class<? extends AnalyzerService> aClass) {
        try {
            return aClass.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            return null;
        }
    }

    private static ReportingService instantiateReporter(Class<? extends ReportingService> aClass) {
        try {
            return aClass.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            return null;
        }
    }

}
