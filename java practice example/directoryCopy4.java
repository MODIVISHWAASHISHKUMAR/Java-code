import java.io.*;
import java.util.Scanner;

public class directoryCopy4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the path of source directory:");
        String sourceDirPath=sc.nextLine();
        System.out.println("Enter the path of destination directory:");
        String destinationDirPath=sc.nextLine();
        File sourceDir=new File(sourceDirPath);
        File destinationDir=new File(destinationDirPath);

        if(!sourceDir.exists() || !sourceDir.isDirectory()){
            System.out.println("Source directory is invalid");
            
        }
        if(!destinationDir.exists()){
            destinationDir.mkdirs();
        }
        try{
            copyDirectory(sourceDir,destinationDir);
            System.out.println("Directory copied succesfully");
        }catch(IOException e){
            System.out.println("Error occured while coping directory");
            e.printStackTrace();
        }
    }
    public static void copyDirectory(File source, File destination) throws IOException { 

        if(source.isDirectory()) {
            if (!destination.exists()) {
                destination.mkdirs();
            }
            String[] files = source.list();
            if (files != null) {
                for (String file : files) {
                    
                    File sourceFile = new File(source, file);
                    File destFile = new File(destination, file);
                    copyDirectory(sourceFile, destFile);
                }
            }
        }else{
            try(InputStream in=new FileInputStream(source);
             OutputStream out=new FileOutputStream(destination)) {
                byte[] buffer=new byte[1024];
                int bytesRead;
                while((bytesRead=in.read(buffer))!=-1){
                    out.write(buffer,0,bytesRead);
                }
            }
        }
    }
}
