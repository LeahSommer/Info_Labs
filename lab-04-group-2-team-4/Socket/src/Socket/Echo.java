package Socket;

import java.net.*;
import java.io.*;

public class Echo {
    public static void main (String[] args) {

        String[] serverArgs = new String[]{"7"};
        String[] clientArgs = new String[]{"localhost", "7"};

        try {
            EchoServer.main(serverArgs);
            EchoClient.main(clientArgs);
        } catch (Exception e) {

        }


        for (String s: args) {
            System.out.println(s);
        }
    }
}


