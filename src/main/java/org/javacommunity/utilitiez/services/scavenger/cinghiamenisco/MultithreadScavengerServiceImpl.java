package org.javacommunity.utilitiez.services.scavenger.cinghiamenisco;

import org.javacommunity.utilitiez.services.scavenger.ScavengerService;

import java.io.File;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

/**
 * @author Christian Luzzetti
 * @created 2021/11/26 - 20:28
 */

public class MultithreadScavengerServiceImpl implements ScavengerService {

    private static String RESET = "\u001B[0m";
    private static String ROSSO = "\u001B[31m";
    private static String VERDE = "\u001B[32m";
    private static String BLU = "\u001b[34m";
    private static String CIANO = "\u001b[36m";
    private static String MAGENTA = "\u001b[35m";
    private static String GIALLO = "\u001b[33m";
    private static String NERO = "\u001b[30m";
    private static String BIANCO = "\u001b[37m";

    private static final int SIZE_OF_THINGS = 12;
    final static ExecutorService executorService = Executors.newFixedThreadPool(Math.max(SIZE_OF_THINGS, 100),
            (Runnable r) -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            });

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final List<CompletableFuture<List<File>>> completableFutures = Arrays.stream(File.listRoots())
                .map(f -> CompletableFuture.supplyAsync(() -> scavenge(f), executorService))
                .toList();

        final Optional<List<File>> first = completableFutures.stream()
                .map(CompletableFuture::join)
                .findFirst();


    }

    private static List<File> scavenge(File f) {
        if (f == null) {
            return Collections.emptyList();
        } else if (f.isFile()) {
            String threadId = String.valueOf(Thread.currentThread().getId());
            Integer lastNumber = Integer.parseInt(String.valueOf(threadId.charAt(threadId.length() - 1)));
            System.out.println(colore(lastNumber) + f.getName() + RESET);
            return new ArrayList<>(Collections.singleton(f));
        } else if (f.listFiles() == null) {
            return Collections.emptyList();
        } else {
            List<File> files = new ArrayList<>();
            for (File next : f.listFiles()) {
                files.addAll(scavenge(next));
            }
            return files;
        }
    }

    @Override
    public List<Path> findAll() {

        Arrays.stream(File.listRoots())
                .flatMap(f -> Arrays.stream(Objects.requireNonNull(f.listFiles())))
//                .map(path -> CompletableFuture.supplyAsync(path.))
                .forEach(System.out::println);

//        final ExecutorService executorService = Executors.newFixedThreadPool(Math.min(SIZE_OF_THINGS, 100),
//                (Runnable r) -> {
//                    Thread t = new Thread(r);
//                    t.setDaemon(true);
//                    return t;
//                });
//
//        CompletableFuture.supplyAsync(() -> )


        return Collections.emptyList();
    }

    @Override
    public List<Path> findAll(Predicate<Path> filter) {
        // Write an implementation that goes to scavenge the files in the filesystem, by using parallel processing


        return Collections.emptyList();
    }


    private static String colore(int i) {
        switch (i) {
            case 0:
            case 1:
                return ROSSO;
            case 2:
            case 3:
                return VERDE;
            case 4:
            case 5:
                return BLU;
            case 6:
            case 7:
                return CIANO;
            case 8:
                return MAGENTA;
            case 9:
                return GIALLO;
            default:
                return RESET;
        }
    }

}
