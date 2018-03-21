package storage;

import model.Resume;

import java.util.ArrayList;

public abstract class AbstractStorage implements Storage, Comparable<Resume> {
   // protected static int qualResume = 0;
   // protected Resume[] storage = new Resume[10000];

    public abstract int size();

    public abstract Resume get(String uuid);

    public abstract void clear() ;

    public abstract void save(Resume r);
    public abstract void update(Resume r);

    public abstract void delete(String uuid);

    public abstract Resume[] getAll();
    protected abstract int getIndex(String uuid);
    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);
    @Override
    public int compareTo(Resume o) {
        return this.compareTo(o);
    }
}
