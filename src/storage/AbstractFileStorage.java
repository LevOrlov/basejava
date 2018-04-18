package storage;

import model.Resume;

import java.io.File;
import java.util.List;

abstract public class   AbstractFileStorage extends AbstractStorage<File> {

    @Override
    protected File getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected void doUpdate(Resume r, File searchKey) {

    }

    @Override
    protected boolean isExist(File searchKey) {
        return false;
    }

    @Override
    protected void doSave(Resume r, File searchKey) {

    }

    @Override
    protected Resume doGet(File searchKey) {
        return null;
    }

    @Override
    protected void doDelete(File searchKey) {

    }

    @Override
    public List<Resume> getAllSorted() {
        return null;
    }

    @Override
    public List<Resume> doCopyAll() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
