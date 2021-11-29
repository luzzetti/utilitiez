package org.javacommunity.utilitiez.services.analyzer.hyperbeast;

import org.javacommunity.utilitiez.services.analyzer.AnalyzerService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Analyzer implements AnalyzerService {

    @Override
    public List<Path> getBiggestFiles(List<Path> files, int amountOfFiles) {
        if(files.isEmpty()) return new ArrayList<>();
        if(amountOfFiles > files.size()) return new ArrayList<>();

        List<Path> list = new ArrayList<>();

        List<File> ls = new ArrayList<>();
        for (Path item : files) {
            ls.add(new File(String.valueOf(item)));
        }

        ls.sort((a, b) -> (int) (a.length() - b.length()));

        for (int i = files.size() - amountOfFiles; i < files.size(); i++) {
            list.add(ls.get(i).toPath());
        }

        return list;
    }

    @Override
    public Set<Path> getDuplicates(List<Path> files) throws NoSuchAlgorithmException, IOException {
        LinkedHashSet<Path> list = new LinkedHashSet<>();
        byte[][] digest = new byte[files.size()][];

        for (int i = 0; i < files.size(); i++) {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(Files.readAllBytes(files.get(i)));
            digest[i] = md.digest();
        }

        for (int i = 0; i < digest.length; i++) {
            for (int j = 0; j < digest.length; j++) {
                if(i == j) continue;

                if (Arrays.equals(digest[i], digest[j])) {
                    list.add(files.get(i));
                }
            }
        }
        return list;
    }

    @Override
    public Map<Path, String> getUnknownFiles(List<Path> files) {

        return null;
    }
}
