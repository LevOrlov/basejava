/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    public int qualResume = 0;


    void clear() {
       // storage = null;

    }

    void save(Resume r) {

        storage[qualResume] = r;
        qualResume++;

    }

    public Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
                     if (uuid.equals(storage[i].uuid))
                         {return storage[i];}

            }
        return null;}

    void delete(String uuid) {


    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return storage;
    }

    int size() {
        return 0;
    }
}
