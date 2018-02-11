/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        for (int i = 0; i < qualResume; i++) {
            storage[i] = null;
        }

    }

    public void save(Resume r) {
        if (storage.length == qualResume) {
            System.out.println("База данных переполнена");
        } else {
            storage[qualResume] = r;
            qualResume++;
        }

    }

    public void update(Resume r) {
        for (int i = 0; i < qualResume; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                storage[i].setUuid(r.getUuid());
            } else {
                System.out.println("Resume " + r.getUuid() + " нет в базе.");
            }

        }


    }

    public void delete(String uuid) {
        for (int i = 0; i < qualResume; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                storage[i] = storage[qualResume - 1];
                storage[i].setUuid(null);
                qualResume--;
            } else {
                System.out.println("Resume " + uuid + " нет в базе.");
            }

        }


    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] storage = new Resume[qualResume];
        for (int i = 0; i < qualResume; i++) {
            storage[i] = this.storage[i];
        }
        return storage;
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < qualResume; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
