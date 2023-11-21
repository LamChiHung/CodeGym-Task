package appending_object_output_stream;

import client_seller.Client;

import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class WriteClient {
    private static WriteClient writeClient;
    private static Map <String, Client> clientMap;

    public static void writeClient(Map <String, Client> clientMap1) {
        if (writeClient == null) {
            writeClient = new WriteClient();
        }
        clientMap = clientMap1;
        File file = new File(".\\database\\client.csv");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            clientMap.forEach((key, value) -> {
                try {
                    oos.writeObject(value);
                } catch (EOFException ignored) {

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (EOFException ignored) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
