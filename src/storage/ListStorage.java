package storage;
import model.Resume;

import java.util.ArrayList;
import java.util.Arrays;

public class ListStorage  extends AbstractStorage implements  Comparable<Resume>  {
    public static void main (String[] args){
        ListStorage list  =new ListStorage();
        list.storage.add(new Resume("Lev"));
        list.storage.add(new Resume("Lev1"));
        System.out.println(list.size());

       System.out.println(list.getAll());

    }

     protected ArrayList<Resume> storage = new ArrayList();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public Resume get(String uuid) {

        return storage.get(storage.indexOf( new Resume(uuid)));
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void save(Resume r) {
    storage.add(r);
    }

    @Override
    public void update(Resume r) {
     storage.add(storage.indexOf( r.getUuid()), r);
    }

    @Override
    public void delete(String uuid) {
        storage.remove(new Resume(uuid));
    }

    @Override
    public Resume[] getAll() {

        System.out.println(Arrays.toString(storage.toArray()));
        return null;
    }

    @Override
    protected int getIndex(String uuid) {
        return storage.indexOf( new Resume(uuid));
    }

    @Override
    protected void fillDeletedElement(int index) {

    }

    @Override
    protected void insertElement(Resume r, int index) {

    }
}
