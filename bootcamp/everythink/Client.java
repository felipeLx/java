import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        String host;
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("host?");
        host = bReader.readLine();

        int port;
        BufferedReader bPort = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("port?");
        port = Integer.parseInt(bPort.readLine());

        System.out.println("Client starting the Connection");
        Socket clientSocket = new Socket(host, port);


            OutputStreamWriter os = new OutputStreamWriter(clientSocket.getOutputStream());
            PrintWriter writer = new PrintWriter(os, true);
            os.write(String.valueOf(writer));

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            in.readLine();

            InputStreamReader cin = new InputStreamReader(System.in);
            char c;

            do {
                c = (char) cin.read();

            } while (c != 'q');

            cin.close();
    }
}



