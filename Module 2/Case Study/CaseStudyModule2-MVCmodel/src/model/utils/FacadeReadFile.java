package model.utils;

import model.utils.read_write_file.ReadClient;
import model.utils.read_write_file.ReadSeller;

public class FacadeReadFile {
    public static void facadeReadFile(String clientOrseller, String username) {
        if (clientOrseller.equals("client")) {
            ReadClient.readClient(username);
            ReadSeller.readSeller();
        } else if (clientOrseller.equals("seller")) {
            ReadClient.readClient();
            ReadSeller.readSeller(username);
        }
    }
}
