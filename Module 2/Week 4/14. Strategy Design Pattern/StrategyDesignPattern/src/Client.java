public class Client {
    private Storage storage;

    public void useStorage(Storage storage) {
        this.storage = storage;
        storage.store();
    }
}
