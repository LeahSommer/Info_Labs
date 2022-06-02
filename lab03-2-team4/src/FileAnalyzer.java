import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FileAnalyzer {
    String filePath;
    String targetPath;
    HashMap<Character, Integer> results = new HashMap<>();

    public FileAnalyzer(String filePath, String targetPath) {
        this.filePath = filePath;
        this.targetPath = targetPath;
    }

    public void countChars() {
        System.out.println("Starting to read file " + this.filePath);

        BufferedReader objReader = null;
        try {
            int currentChar;
            objReader = new BufferedReader(new FileReader(this.filePath));
            while ((currentChar = objReader.read()) != -1) {
                if (!Character.isLetter((char) currentChar)) {
                    continue;
                }
                if (results.get((char) currentChar) == null) {
                    results.put((char) currentChar, 1);
                } else {
                    results.put(
                            (char) currentChar,
                            results.get((char) currentChar) + 1
                    );
                }
            }
            System.out.println("analyzed files...");
            objReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printResults() {
        File newFile = new File(this.targetPath);
        try {
            FileWriter writer = new FileWriter(this.targetPath);
            String prettyPrinted = "";
            for (Character key : results.keySet()) {
                String starString = "";
                for (int i = 0; i < results.get(key); i++) {
                    starString += "*";
                }
                prettyPrinted += key + ": " + starString + "\n";
            }
            writer.write(prettyPrinted);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void printMostPopular () {
        Character key = Collections.max(results.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Highest occurence is " + key + " with " + results.get(key) + " occurences.");
    }
}
