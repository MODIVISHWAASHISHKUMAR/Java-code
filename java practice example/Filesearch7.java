import java.io.*;
import java.util.Scanner;

public class Filesearch7 {
    public static int countFileOccurrences(File directory, String targetFileName) {
        int count = 0;

        File[] files = directory.listFiles();
        if (files != null) {
            
            for (File file : files) {
                
                if (file.isDirectory()) {
                    count += countFileOccurrences(file, targetFileName); 
                } else {
                    
                    if (file.getName().equals(targetFileName)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directoryPath: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the targetFileName : ");
        String targetFileName = scanner.nextLine();
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }
        int occurrences = countFileOccurrences(directory, targetFileName);
        System.out.println("The file '" + targetFileName + "' appeared " + occurrences + " times in the directory and its subdirectories.");
    }
}
