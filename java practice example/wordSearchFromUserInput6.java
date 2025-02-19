import java.io.*;
import java.util.Scanner;

public class wordSearchFromUserInput6 {
   public static void searchWordInFile(String fileName, String searchWord) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;
            boolean found = false;

           while ((line = reader.readLine()) != null) {
                lineNumber++;
                
                if (line.toLowerCase().contains(searchWord.toLowerCase())) {
                    System.out.println("Line " + lineNumber + ": " + line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("The word '" + searchWord + "' was not found in the file.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file to search in: ");
        String fileName = scanner.nextLine();
        System.out.print("Enter the word to search for: ");
        String searchWord = scanner.nextLine();
        searchWordInFile(fileName, searchWord);
        
    }
}


