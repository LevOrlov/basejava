package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.Resume;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage implements  Comparable<Resume> {

    protected static int qualResume = 0;
    protected Resume[] storage = new Resume[10000];

    public int size() {
        return qualResume;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            throw new NotExistStorageException(uuid);
           // return null;
        }
        return storage[index];
    }

    public void clear() {
        Arrays.fill(storage, 0, qualResume, null);
        qualResume = 0;
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else if (qualResume == 10000) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement(r, index);
            qualResume++;
        }
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage[index] = r;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
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
