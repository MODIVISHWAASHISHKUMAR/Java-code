import java.io.*;
import java.util.Scanner;

public class FileReadsWrite{
    public static void main(String[] arg){
        System.out.println("Enter file name:");
        Scanner sc=new Scanner(System.in);
        String fileName=sc.nextLine();

        try(FileWriter write=new FileWriter(fileName)){
            write.write("Hello,this is a simple code to written in file\n");
            System.out.println("Data enter sucessfully");
        }catch(IOException e){
            System.out.println("Error Occur while enter file");
            e.printStackTrace();

        }

        try(BufferedReader reader=new BufferedReader(new FileReader(fileName))){
            String line;
            System.out.println("Reading from file");
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
        }catch(IOException e){
            System.out.println("error occur");
            e.printStackTrace();
        }
    }
}