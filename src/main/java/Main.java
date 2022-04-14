import com.npg005.network.Network;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Network net = new Network();
        try {
            net.connectToServer();
        }catch (IOException e){
            System.out.println("Connection Error.");
        }
    }
}
