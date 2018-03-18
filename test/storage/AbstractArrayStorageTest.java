package storage;

import exception.NotExistStorageException;
import model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractArrayStorageTest {

    private Storage storage = new ArrayStorage();


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

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }

    @Test
    public void get() throws Exception {
        assertEquals(new Resume("uuid1"), storage.get("uuid1"));
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, ArrayStorage.qualResume);
    }

    @Test
    public void save() {
        Resume levOrlov = new Resume("Lev_Orlov");
        //Resume levOrlov1 = new Resume("Lev_Orlov1");
        storage.save(levOrlov);
        assertEquals(levOrlov, storage.get("Lev_Orlov"));
    }

    @Test
    public void update() {
        Resume levOrlov = new Resume("Lev_Orlov");
        storage.clear();
        storage.save(levOrlov);
        System.out.println(storage.get("Lev_Orlov"));
        storage.update(levOrlov);
        System.out.println(storage.get("Lev_Orlov"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete("uuid3");
        assertEquals(2, ArrayStorage.qualResume);

        storage.get("uuid3");
    }

    @Test
    public void getAll() {
        Resume[] all = storage.getAll();
        assertEquals(3, all.length);
        assertEquals(new Resume("uuid1"), all[0]);
        assertEquals(new Resume("uuid2"), all[1]);
        assertEquals(new Resume("uuid3"), all[2]);
    }



    @Test
    public void compareTo() {
        assertEquals(0, storage.get("uuid1").compareTo(new Resume("uuid1")));
    }
}