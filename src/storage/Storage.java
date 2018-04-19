package storage;

import model.Resume;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface Storage {


    void clear();

    void update(Resume r);

    void save(Resume r) throws FileNotFoundException, UnsupportedEncodingException;

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();
    List<Resume> getAllSorted();

    int size();
}
