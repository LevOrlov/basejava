import java.io.*;

public class MainFile {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Lev\\basejava");
        File file1;
       /*
        BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Lev\\basejava\\.gitignore")));
        DataOutputStream write = new DataOutputStream(new FileOutputStream("file.txt"));
        String line;
        while((line=read.readLine())!=null){
            System.out.println(line);
            write.writeChar(line.toCharArray()[0]);
        }

        write.close();*/


      // for (int i=0; i< file.list().length;i++){
        //рекурсия для корневой папки. Чтобы узнать все внутренние катаологи.
        File[] contents = file.listFiles();
        File[] contents1;
        for ( File f : contents) {
            file1 = new File(f.getAbsolutePath().toString());
            if (file1.isDirectory()==true){
                contents1 = file1.listFiles();
                {for ( File f1 : contents1){
                    System.out.println(f1.getAbsolutePath());
                }

                }
            System.out.println();}
          //  System.out.println(f.getAbsolutePath());
        contents1=null;}
    //}

    }
}
