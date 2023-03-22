import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class serverTEST {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started");

        while (true) {
            try (Socket socket = server.accept()) {
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = input.readLine();
                while (line != null && !line.isEmpty()) {
                    //System.out.println(line);
                    line = input.readLine();
                }
                StringBuilder requestBody = new StringBuilder();
                while (input.ready()) {
                    requestBody.append((char) input.read());
                }
                String message = requestBody.toString();
                //System.out.println("Message received: " + message);

                /*PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                /*output.println("HTTP/1.1 200 OK");
                output.println("Content-Type: text/plain");
                output.println();
                
                output.println("Message received: " + message);
                output.flush();*/

                System.out.println("USERNAME is " + message);
            }
        }
    }
}
