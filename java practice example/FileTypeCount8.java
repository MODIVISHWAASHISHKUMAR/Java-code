import java.util.*;
import java.util.HashMap;
import java.io.*;

public class FileTypeCount8 {
    public static void main(String[] arg){
        String directoryPath="C:\\Users\\sspl1486\\Desktop";
        Map<String,Integer> fileTypeCount=new HashMap<>();
        countFiles(new File(directoryPath),fileTypeCount);
        System.out.println("File Type in Dir");
        for(Map.Entry<String,Integer> entry:fileTypeCount.entrySet()){
            System.out.println("."+entry.getKey()+":"+entry.getValue());
        }
    }
    public static void  countFiles(File dir,Map<String,Integer>fileTypeCount){
        if(!dir.exists()||!dir.isDirectory()){
            System.out.println("Invalid Directiry:"+dir.getPath());
            return;
        }File[] files=dir.listFiles();
        if (files==null)
        return;
        for(File file:files){
            if(file.isDirectory()){
                countFiles(file,fileTypeCount);
            }else{
                String fileName=file.getName();
                int dotIndex=fileName.lastIndexOf('.');
                if(dotIndex>0 && dotIndex<fileName.length()-1){
                    String extension =fileName.substring(dotIndex+1);
                    fileTypeCount.put(extension,fileTypeCount.getOrDefault(extension , 0)+1);
                }
            }
        }
    }
}
