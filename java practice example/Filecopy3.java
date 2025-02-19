import java.io.*;
import java.util.Scanner;


public class Filecopy3 {
    public static void main(String[] arg){
        try(Scanner sc=new Scanner(System.in)){
            System.out.println("Enter the source file path:");
            String sourcePath=sc.nextLine();
            System.out.println("Enter the destination file path:");
            String destinationpath=sc.nextLine();
            File sourceFile=new File(sourcePath);
            File destinationFile=new File(destinationpath);

            if(!sourceFile.exists() || !sourceFile.isFile()){
                System.out.println("source file does not valid file");
            }

            File destinationDir=new File(destinationFile.getParent());
            if(!destinationFile.exists()){
                destinationDir.mkdirs();
            }
        try(InputStream in=new FileInputStream(sourceFile);
             OutputStream out=new FileOutputStream(destinationFile)) {
                byte[] buffer=new byte[1024];
                int bytesRead;
                while((bytesRead=in.read(buffer))!=-1){
                    out.write(buffer,0,bytesRead);
                }
                System.out.println("File copied");
             }    catch(IOException e){
                System.out.println("An erro occured while copying file");
                e.printStackTrace();
             }}}}
