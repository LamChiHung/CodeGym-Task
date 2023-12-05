package model.utils.read_write_file;

import main.StoreMain;
import model.models.imp.Client;

import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteClient {
    public static void writeClient() {
        File file = new File(".\\src\\database\\Client.txt");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(StoreMain.currentClientMap);
        } catch (EOFException ignored) {

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeClient(Client client) {
        StoreMain.currentClientMap.put(client.getUsername(), client);
        writeClient();
    }
}
