import java.io.*;

public class MainFile {
    static File file1;
    static File[] contents1;
    static File file;
    public static void main(String[] args) throws Exception {
        file = new File("C:\\Users\\Lev\\basejava");

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

        recursion(file.getAbsolutePath().toString());

    //}
//Сделать рекурсивный обход и вывод имени файлов в каталогах и подкаталогах (корневой каталог- ваш проект)
    }
    public static void recursion(String s)
    { File fileS = new File(s);
        File[] contents = fileS.listFiles();
        for ( File f : contents) {
            file1 = new File(f.getAbsolutePath().toString());
            if (file1.isDirectory()==true){
                System.out.println(file1.getAbsolutePath());
                recursion(file1.getAbsolutePath().toString());

            }
            else {System.out.println("  else "+file1.getName());}
            }

        contents1=null;
    }

}
