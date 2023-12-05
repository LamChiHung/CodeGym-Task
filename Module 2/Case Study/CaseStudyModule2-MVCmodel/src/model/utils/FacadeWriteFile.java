package model.utils;

import model.models.imp.Client;
import model.models.imp.Seller;
import model.utils.read_write_file.WriteClient;
import model.utils.read_write_file.WriteSeller;

public class FacadeWriteFile {
    public static void facadeWriteFile() {
        WriteClient.writeClient();
        WriteSeller.writeSeller();
    }

    public static void facadeWriteFile(Client client) {
        WriteClient.writeClient(client);
        WriteSeller.writeSeller();
    }

    public static void facadeWriteFile(Seller seller) {
        WriteClient.writeClient();
        WriteSeller.writeSeller(seller);
    }

    public static void facadeWriteFile(Seller seller, Client client) {
        WriteClient.writeClient(client);
        WriteSeller.writeSeller(seller);
    }
}
