import java.io.*;
import java.util.Scanner;

public class DirectoryInformation {
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the path of directory:");
        String directoryPath=sc.nextLine();

        File directory=new File(directoryPath);

        if(directory.exists() && directory.isDirectory()){
            int fileCount=countFiles(directory);
            long totalSizeByte=calculateSize(directory);
            double totalSizeMB=totalSizeByte/(1024.0*1024.0);
            System.out.println("\nDirectory:"+directoryPath);
            System.out.println("\nTotal Files:"+fileCount);
            System.out.println("\nTotal File Size:"+totalSizeMB);
        }else{
            System.out.println("Invalid directory path");
        }
    }

    public static int countFiles(File directory){
        int count=0;
        File[] files=directory.listFiles();
        if(files!=null){
            for(File file:files){
                if(file.isFile()){
                    count++;

                }else if(file.isDirectory()){
                    count=count+countFiles(file);
                }
            }
        }
        return count;
    }

    public static long calculateSize(File directory){
        long totalSize=0;
        File[] files=directory.listFiles();
        if(files!=null){
            for(File file:files){
                if(file.isFile()){
                    totalSize=totalSize+file.length();

                }else if(file.isDirectory()){
                    totalSize=totalSize+calculateSize(file);
                }
            }
        }
        return totalSize;
    }

    
}
