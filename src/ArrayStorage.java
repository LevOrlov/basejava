/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        storage = null;

    }

    void save(Resume r) {
        int sizeStorage = storage.length;


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
        return new Resume[0];
    }

    int size() {
        return 0;
    }
}
