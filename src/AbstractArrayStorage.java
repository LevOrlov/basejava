public abstract class AbstractArrayStorage implements Storage {
    protected int qualResume = 0;
    protected Resume[] storage = new Resume[10000];

    public int size() {
        return qualResume;

    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

}
