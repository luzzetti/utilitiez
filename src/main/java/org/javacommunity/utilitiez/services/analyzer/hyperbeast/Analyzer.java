package org.javacommunity.utilitiez.services.analyzer.hyperbeast;

import org.javacommunity.utilitiez.services.analyzer.AnalyzerService;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Analyzer implements AnalyzerService {
    @Override
    public List<Path> getBiggestFiles(List<Path> files, int amountOfFiles) {
        if(files.isEmpty() || amountOfFiles > files.size()) return new ArrayList<>();

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
    public Map<Path, String> getUnknownFiles(List<Path> files) throws NoSuchAlgorithmException, IOException {
        LinkedHashMap<Path, String> listOfUnknownFiles = new LinkedHashMap<>();

        LinkedHashMap<String, String> listOfFileSignature = new LinkedHashMap<>();
        Path pathOfFileSignatureList = Paths.get("C:", "Users", "serge", "OneDrive", "Desktop", "JavaProjects", "Utilitiez", "List of file signatures.txt");
        List<String> fileOfSignatures = Files.readAllLines(pathOfFileSignatureList);

        for (String s : fileOfSignatures) {
            StringBuilder signature = new StringBuilder();
            String extension = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ';') {
                    extension = s.substring(i + 1).trim();
                    break;
                }
                signature.append(s.charAt(i));
            }

            listOfFileSignature.put(signature.toString(), extension);
        }

        for (int i = 0; i < files.size(); i++) {
            String fileExtension = getFileExtension(files.get(i));

            if (fileExtension.isEmpty()) {
                String extension = getUnknownFileExtension(files.get(i), listOfFileSignature, files.size());
                listOfUnknownFiles.put(files.get(i), extension);
            }
        }

        return listOfUnknownFiles;
    }

    private String getFileExtension(Path path) {
        StringBuilder fileName = new StringBuilder(new File(String.valueOf(path)).getName()).reverse();
        String fileExtension = "";

        for (int i = 0; i < fileName.length(); i++) {
            if (fileName.charAt(i) == '.') {
                fileExtension = fileName.substring(0, i);
                break;
            }
        }

        return fileExtension;
    }

    private String getUnknownFileExtension(Path filePath, LinkedHashMap<String, String> listOfFileSignature, int fileSize) throws NoSuchAlgorithmException, IOException {
        String signature = "";

        byte[] arrayOfBytesOfFile = Files.readAllBytes(filePath);
        StringBuilder bytesOfF = new StringBuilder();

        for (byte j : arrayOfBytesOfFile) {
            bytesOfF.append(Integer.toHexString(j & 0xff)).append(" ");
            if (bytesOfF.length() > 35) break;
        }

        String bytesOfFile = bytesOfF.toString().toUpperCase().trim();

        for (String s : listOfFileSignature.keySet()) {
            for (int i = 3; i <= bytesOfFile.length(); i += 2) {
                if (s.equals(bytesOfFile.substring(0, i).trim())) {
                    signature = listOfFileSignature.get(s);
                    break;
                }
            }
        }

        return signature;
    }
}
