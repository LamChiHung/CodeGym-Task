package appending_object_output_stream;

import client_seller.Client;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class ReadClient {
    private static ReadClient readClient;
    private static Map <String, Client> clientMap;

    public static Map <String, Client> readClient() {
        if (readClient == null) {
            readClient = new ReadClient();
            clientMap = new HashMap <>();
        }
        File file = new File(".\\database\\client.csv");
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Client client = null;
            while ((client = (Client) ois.readObject()) != null) {
                clientMap.put(client.getUsername(), client);
            }
        } catch (EOFException ignored) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return clientMap;
    }
}
