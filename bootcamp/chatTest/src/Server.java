import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        int port = 6666;

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server has started on port " + port);

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client is connected");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        String str = in.readLine();
        out.println(str);
        out.flush();
     }
}
