/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    public int qualResume = 0;


    void clear() {
        for (int i = 0; i < qualResume;i++){
            storage[i] = null;
        }

    }

    void save(Resume r) {

        storage[qualResume] = r;
        qualResume++;

    }

    public Resume get(String uuid) {
        for (int i = 0; i < qualResume ; i++) {
                     if (uuid.equals(storage[i].uuid))
                         {return storage[i];}

            }
        return null;}

    void delete(String uuid) {
        for (int i = 0; i < qualResume ; i++) {
            if (uuid.equals(storage[i].uuid))
            {storage[i] = null;}

        }


    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storage = new Resume[qualResume];
        for (int i = 0; i < qualResume;i++){
            storage[i] = this.storage[i];
        }
        return storage;
    }

    int size() {
        return storage.length;
    }
}
