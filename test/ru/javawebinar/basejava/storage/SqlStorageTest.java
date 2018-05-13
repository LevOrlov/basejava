package ru.javawebinar.basejava.storage;

import org.junit.After;
import org.junit.Test;
import ru.javawebinar.basejava.Config;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/*public class SqlStorageTest extends AbstractStorageTest {

    public SqlStorageTest() {
        super(Config.get().getStorage());
    }
}*/

public class SqlStorageTest {
    protected static final File STORAGE_DIR = Config.get().getStorageDir();


    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";


  /*  private static final Resume R2;
    private static final Resume R3;
    private static final Resume R4;*/


    private static final SqlStorage sql;

    static {
        sql = new SqlStorage("jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "qazxswedc123");
   //     sql.save( new Resume(UUID_1, "Name1"));

    }

    @Test
    public void update() throws Exception {
        System.out.println(sql.get(UUID_1));
        sql.update( new Resume(UUID_1, "Lev"));
        System.out.println(sql.get(UUID_1));
        //System.out.println(sql.get(UUID_2));

        // assertTrue(sql.get(UUID_1).equals(UUID_1));

    }
    @Test
    public void clear(){       sql.clear();}

/*    @Test
    public void save() throws Exception {
       // sql.save( new Resume(UUID_2, "Name1"));
        System.out.println(sql.get(UUID_1));
        System.out.println(sql.get(UUID_2));

       // assertTrue(sql.get(UUID_1).equals(UUID_1));

    }
    @Test
    public void update() throws Exception {
        System.out.println(sql.get(UUID_1));
         sql.update( new Resume(UUID_1, "Name3"));
        System.out.println(sql.get(UUID_1));
        //System.out.println(sql.get(UUID_2));

        // assertTrue(sql.get(UUID_1).equals(UUID_1));

    }
    @Test
     public void clear(){       sql.clear();}

    @Test
    public void delete(){       sql.delete(UUID_1);}*/


}
