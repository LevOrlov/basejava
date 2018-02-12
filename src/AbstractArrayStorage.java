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

    public void clear() {
        for (int i = 0; i < qualResume; i++) {
            storage[i] = null;
        }

    }

    public void save(Resume r) {
        if (storage.length == qualResume) {
            System.out.println("База данных переполнена");
        } else {
            storage[qualResume] = r;
            qualResume++;
        }

    }

    public void update(Resume r) {
        for (int i = 0; i < qualResume; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                storage[i].setUuid(r.getUuid());
            } else {
                System.out.println("Resume " + r.getUuid() + " нет в базе.");
            }

        }


    }

    public void delete(String uuid) {
        for (int i = 0; i < qualResume; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                storage[i] = storage[qualResume - 1];
                storage[i].setUuid(null);
                qualResume--;
            } else {
                System.out.println("Resume " + uuid + " нет в базе.");
            }

        }


    }

    public Resume[] getAll() {
        Resume[] storage = new Resume[qualResume];
        for (int i = 0; i < qualResume; i++) {
            storage[i] = this.storage[i];
        }
        return storage;
    }

    protected abstract int getIndex(String uuid);

}
