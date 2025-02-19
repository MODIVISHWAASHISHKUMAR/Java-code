import java.io.File;
import java.util.Scanner;

public class DirectoryTreeDisplay10 {
    public static void listFilesAndDirectories(File directory, String indent) {
        if (directory.exists() && directory.isDirectory()) {
            File[] fileList = directory.listFiles();
            if (fileList != null && fileList.length > 0) {
                for (File file : fileList) {
                    System.out.println(indent + (file.isDirectory() ? "[DIR] " : "[FILE] ") + file.getName());
                    if (file.isDirectory()) {
                        listFilesAndDirectories(file, "");
                    }
                }
            } else {
                System.out.println(indent + "No files in this directory.");
            }
        } else {
            System.out.println("The specified path is not a valid directory.");
        }
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the source directory path:");
        String directoryPath = sc.nextLine();
        File directory = new File(directoryPath);
        System.out.println("Directory tree structure:");
        listFilesAndDirectories(directory, " ");
    }
}
