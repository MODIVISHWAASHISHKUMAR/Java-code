import java.io.*;
import java.util.Scanner;

public class FileValidation9 {
    public static boolean isValidFileName(String fileNameWithoutExtension) {
        return fileNameWithoutExtension.matches("^[a-z-]+$");
    }
    public static boolean isValidFilePath(String filePath) {
        return filePath.length() <= 230;
    }
    public static boolean isValidFileNameLength(String finalFileName) {
        return finalFileName.length() <= 64;
    }
    public static boolean isValidFileExtension(String finalFileName) {
        String[] allowedExtensions = {".pdf", ".xpt", ".doc", ".docx", ".xml", ".xsl", ".txt", ".rtf"};
        for (String ext : allowedExtensions) {
            if (finalFileName.endsWith(ext)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isValidFileSize(File file) {
        long maxFileSize = 100 * 1024 * 1024;
        return file.length() < maxFileSize;
    }
    public static boolean validateFile(String filePath) {
        File file = new File(filePath);
        String fileName = file.getName();
        int lastDotIndex = fileName.lastIndexOf(".");
        String extension = " " ;
        if(lastDotIndex>0)
    {
        extension = fileName.substring(lastDotIndex); }
        String fileNameWithoutExtension = fileName.substring(0, lastDotIndex);
        System.out.println("File Name Without Extension: "+fileNameWithoutExtension);
        if (!isValidFileName( fileNameWithoutExtension)) {
            System.out.println("Error: The file name should only contain lowercase letters and hyphens.");
            return false;
        }
        if (!isValidFilePath(filePath)) {
            System.out.println("Error: The file path should not exceed 230 characters.");
            return false;
        }
        String finalFileName = fileNameWithoutExtension + extension;
        System.out.println("Final File Name: " + finalFileName);
        if (!isValidFileNameLength(finalFileName)) {
            System.out.println("Error: The file name should not exceed 64 characters.");
            return false;
        }
        if (!isValidFileExtension(finalFileName)) {
            System.out.println("Error: Invalid file extension. Allowed extensions are: .pdf, .xpt, .doc, .docx, .xml, .xsl, .txt, .rtf");
            return false;
        }
        if (!isValidFileSize(file)) {
            System.out.println("Error: The file size should be less than 100MB.");
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the source file path:");
        String filePath=sc.nextLine();  
        if (validateFile(filePath)) {
            System.out.println("File validation passed!");
        } else {
            System.out.println("File validation failed.");
        }
    }
}
