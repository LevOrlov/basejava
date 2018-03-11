package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage, Comparable<Resume> {

    protected int qualResume = 0;
    protected Resume[] storage = new Resume[10000];

    public int size() {
        return qualResume;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("model.Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public void clear() {
        Arrays.fill(storage, 0, qualResume, null);
        qualResume = 0;
    }

    public void save(Resume r) {
        if (storage.length == qualResume) {
            System.out.println("База данных переполнена");
        } else {
            int indexRtoInsert = getIndex(r.getUuid());
            insertElement(r, indexRtoInsert);
            qualResume++;
        }
    }

    public void update(Resume r) {
        for (int i = 0; i < qualResume; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                storage[i].setUuid(r.getUuid());
            } else {
                System.out.println("model.Resume " + r.getUuid() + " нет в базе.");
            }

        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            fillDeletedElement(index);
            storage[qualResume - 1] = null;
            qualResume--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, qualResume);
    }

    protected abstract int getIndex(String uuid);
    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);
    @Override
    public int compareTo(Resume o) {
        return this.compareTo(o);
    }
}
