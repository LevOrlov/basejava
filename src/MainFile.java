import java.io.*;

public class MainFile {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Lev\\basejava\\.gitignore");
        BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Lev\\basejava\\.gitignore")));
        DataOutputStream write = new DataOutputStream(new FileOutputStream("file.txt"));
        String line;
        while((line=read.readLine())!=null){
            System.out.println(line);
            write.writeChar(line.toCharArray()[0]);
        }

        write.close();

       // System.out.println(dir.isDirectory());

    }
}
