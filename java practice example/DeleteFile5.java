import java.io.*;
import java.util.Scanner;

public class DeleteFile5 {
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the path of file  delete:");
        String filePath=sc.nextLine();

        File file=new File(filePath);

        if(file.exists() && file.isFile()){
            if(file.delete()){
                System.out.println("File deleted succesfully");
            }else{
                System.out.println("Failed to delet the file");
            }
        }else{
            System.out.println("the file does not exsit or is not valid");}}}