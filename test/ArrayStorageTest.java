import exception.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Test;
import storage.ArrayStorage;

public class ArrayStorageTest extends AbstractStorageTest {

    public ArrayStorageTest() {
        super(new ArrayStorage());
    }
    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= 10000; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume());
    }

}