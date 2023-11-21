package sign_in_and_sign_up;

import appending_object_output_stream.ReadClient;
import client_seller.Client;

import java.util.Map;

public class SignInAsClient {
    private Map <String, Client> clientMap;
    private boolean status = false;

    public SignInAsClient() {
    }

    public boolean isStatus() {
        return status;
    }

    public Client signIn(String username, String password) {
        clientMap = ReadClient.readClient();
        if (clientMap == null) {
            System.out.println("Check your password or username again");
            return null;
        }
        Client client = checkValidAccount(username, password);
        if (client != null) {
            System.out.println("Sign In success!");
            return client;
        } else {
            System.out.println("Check your password or username again");
            return null;
        }
    }

    private Client checkValidAccount(String username, String password) {
        if (clientMap.containsKey(username)) {
            Client client = clientMap.get(username);
            if (password.equals(client.getPassword())) {
                this.status = true;
                return client;
            } else {
                return null;
            }
        } else return null;
    }
}
