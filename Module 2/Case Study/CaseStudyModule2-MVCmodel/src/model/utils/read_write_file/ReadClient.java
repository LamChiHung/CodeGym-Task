package model.utils.read_write_file;


import main.StoreMain;
import model.models.imp.Client;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class ReadClient {
    public static Map <String, Client> readClient() {
        File file = new File(".\\src\\database\\Client.txt");
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            StoreMain.currentClientMap = (Map <String, Client>) ois.readObject();
        } catch (EOFException ignored) {

        } catch (IOException |
                 ClassNotFoundException e) {
            e.printStackTrace();
        }
        return StoreMain.currentClientMap;
    }

    public static Client readClient(String username) {
        File file = new File(".\\src\\database\\Client.txt");
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            StoreMain.currentClientMap = (Map <String, Client>) ois.readObject();
        } catch (EOFException ignored) {

        } catch (IOException |
                 ClassNotFoundException e) {
            e.printStackTrace();
        }
        StoreMain.currenClient = StoreMain.currentClientMap.get(username);
        return StoreMain.currenClient;
    }
}
