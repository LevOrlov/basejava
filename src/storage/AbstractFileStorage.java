package storage;

import model.Resume;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

 public class   AbstractFileStorage extends AbstractStorage<File> {
     //create folder for storage resume
    static {
        File theDir = new File("C:\\Users\\Lev\\basejava\\Storage_Resume");

        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir.getName());
            boolean result = false;
            try{
                theDir.mkdir();
                result = true;
            }
            catch(SecurityException se){
                //handle it
            }
            if(result) {
                System.out.println("DIR created");
            }
        }
    }
    static ArrayList<String> LibrFileResume  = new ArrayList<>();

    @Override
    protected File getSearchKey(String uuid) {
        return new File(uuid);
    }

    @Override
    protected void doUpdate(Resume r, File searchKey) {

    }

    @Override
    protected boolean isExist(File searchKey) {
        for (String s:LibrFileResume) {
            if (searchKey.getName().equals(s)){
                return true;
            }

        }
        return false;
    }

    @Override
    protected void doSave(Resume r, File searchKey) throws FileNotFoundException, UnsupportedEncodingException {
        String res = "C:\\Users\\Lev\\basejava\\Storage_Resume\\"+r.toString();
        PrintWriter writer = new PrintWriter(res+".txt", "UTF-8");
        LibrFileResume.add(r.toString()+".txt");
        System.out.println(LibrFileResume.get(0));
    }

    @Override
    protected Resume doGet(File searchKey) {
       // System.out.println(searchKey.getAbsolutePath());
        if(searchKey.exists()) {
           System.out.println(searchKey.getName()); // do something
        }
        else {System.out.println("else");}

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
