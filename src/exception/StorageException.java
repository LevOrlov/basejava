package exception;

public class StorageException extends RuntimeException {
    private final String uuid;

    public StorageException(String uuid) {
        this.uuid = uuid;
    }

    public StorageException(String message, String uuid) {
        System.out.println(message + " " + uuid);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
