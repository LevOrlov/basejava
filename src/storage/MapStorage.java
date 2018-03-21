package storage;

import model.Resume;

import java.util.ArrayList;

public class MapStorage  extends AbstractStorage implements  Comparable<Resume>  {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public void save(Resume r) {

    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    protected void fillDeletedElement(int index) {

    }

    @Override
    protected void insertElement(Resume r, int index) {

    }
}
