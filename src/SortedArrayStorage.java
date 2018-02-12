import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {


    @Override
    protected int getIndex(String uuid) {
        Resume[] storageCopySort = new Resume[qualResume];
        for (int i = 0;i < qualResume; i++){
            storageCopySort[i] = storage[i];
        }

        Arrays.sort(storageCopySort);
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, qualResume, searchKey);
    }

}
