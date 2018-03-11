package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {


    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[qualResume - 1];
    }

    @Override
    protected void insertElement(Resume r, int index) {
        storage[qualResume] = r;
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
