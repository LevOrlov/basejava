/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public int qualResume = 0;
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < qualResume; i++) {
            storage[i] = null;
        }

    }

    void save(Resume r) {
        if (storage.length == qualResume){
           System.out.println("База данных переполнена");
        }
        else {
        storage[qualResume] = r;
        qualResume++;
        }

    }

    void update(String uuid) {
        for (int i = 0; i < qualResume; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i].uuid = uuid;
            }
            else {System.out.println("Resume " + uuid + " нет в базе.");}

        }


    }
    public Resume get(String uuid) {
        for (int i = 0; i < qualResume; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
            else {System.out.println("Resume " + uuid + " нет в базе.");}

        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < qualResume; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = storage[qualResume - 1];
                storage[qualResume - 1] = null;
                qualResume--;
            }
            else {System.out.println("Resume " + uuid + " нет в базе.");}

        }



    }



    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storage = new Resume[qualResume];
        for (int i = 0; i < qualResume; i++) {
            storage[i] = this.storage[i];
        }
        return storage;
    }

    int size() {
        return qualResume;
    }
}
