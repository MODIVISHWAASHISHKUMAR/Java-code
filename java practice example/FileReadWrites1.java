import java.io.*;

public class FileReadWrites1{
    public static void writeToFile(String filePath, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(text);
            writer.newLine(); 
            System.out.println("Text written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    public static void readFromFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                System.out.println("Reading from the file:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line  );
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading from the file: " + e.getMessage());
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }
    public static void main(String[] args) {
        String filePath = "example.txt"; 
        writeToFile(filePath, "\n Hello, this is a test text.\nthis is java program.\ngood afternoon.\nwhat's your today's goal.");
        readFromFile(filePath );
    }
}

