import java.io.*;
import java.util.Scanner;

public class fileCount2 {
    static int count=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Directory path:");
        String dirPath=sc.nextLine();
        System.out.println("Enter File Name:");
        String fileName=sc .nextLine();
        searchFile(new File(dirPath),fileName);
        System.out.println("the count of :"+ fileName+":"+count);
    }
    public static void searchFile(File directory,String fileName){
        if(directory.isDirectory()){
            File[] files=directory.listFiles();
            if(files!=null){
                for(File file:files){
                    if(file.isDirectory()){
                        searchFile(file,fileName);
                    }else if(file.getName().equals(fileName)){
                        System.out.println("path:"+file.getAbsolutePath());
                        count++;
                    }
                }
            }
        }
    }
}
