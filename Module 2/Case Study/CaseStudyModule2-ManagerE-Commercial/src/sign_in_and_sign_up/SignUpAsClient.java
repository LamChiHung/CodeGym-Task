package sign_in_and_sign_up;

import appending_object_output_stream.ReadClient;
import appending_object_output_stream.WriteClient;
import client_seller.Client;

import java.util.Map;

public class SignUpAsClient {
    private Map <String, Client> clientMap;

    public void signUp(String username, String password) {
        clientMap = ReadClient.readClient();
        if (clientMap == null | checkValidAccount(username) == null) {
            Client client = new Client(username, password);
            clientMap.put(client.getUsername(), client);
            WriteClient.writeClient(clientMap);
            System.out.println("Register sucess!");
        } else {
            System.out.println("User was registered!");
        }

    }

    private Client checkValidAccount(String username) {
        if (clientMap == null) {
            return null;
        }
        if (clientMap.containsKey(username)) {
            return clientMap.get(username);
        } else {
            return null;
        }
    }
}
