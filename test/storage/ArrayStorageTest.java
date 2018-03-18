package storage;

import model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStorageTest {
    public SortedArrayStorage storage = new SortedArrayStorage();


    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void fillDeletedElement1() throws  Exception{

        storage.delete("uuid1");
        System.out.println( storage.getAll()[0]);
        System.out.println( storage.getAll()[1]);
        System.out.println( storage.getAll()[2]);
    }

    @Test
    public void insertElement()throws  Exception {

    }

    @Test
    public void getIndex()throws  Exception {

    }
}