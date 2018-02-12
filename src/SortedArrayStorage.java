import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    protected Resume[] storageCopySort = new Resume[10000];

    @Override
    protected int getIndex(String uuid) {
        storageCopySort = storage.clone();
        Arrays.sort(storageCopySort);
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, qualResume, searchKey);
    }

}
