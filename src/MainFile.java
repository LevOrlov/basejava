

import storage.AbstractFileStorage;

import java.io.*;


public class MainFile {
    public static void main(String[] args) {



      String filePath ;


       try (BufferedInputStream fis =new BufferedInputStream( new FileInputStream("C:\\Users\\Lev\\basejava\\Storage_Resume\\_String.txt"))) {
           while(fis.available()>0){
           System.out.println(new String( fis.readAllBytes()));}
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedOutputStream fos =new BufferedOutputStream( new FileOutputStream("C:\\Users\\Lev\\basejava\\Storage_Resume\\_String.txt"))) {

           fos.write("Hello".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    // TODO: make pretty output
    public static void printDirectoryDeeply(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printDirectoryDeeply(file);
                }
            }
        }
    }
}
