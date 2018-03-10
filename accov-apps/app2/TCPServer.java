/**
 *
 * @package  app2
 * @version  1.0
 * @developer  Peter Bardawil
 *
 *
 */
package app2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private static BufferedReader getInput(Socket p) throws IOException {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    private static PrintWriter getoutput(Socket p) throws IOException {
        return new PrintWriter(new OutputStreamWriter(p.getOutputStream()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket l = new ServerSocket(2000);
        System.out.println(l.getLocalSocketAddress());
        while (true) {
            try (Socket serviceSocket = l.accept()) {
                System.out.println(serviceSocket.getRemoteSocketAddress());
                BufferedReader ir = getInput(serviceSocket);
                PrintWriter reply = getoutput(serviceSocket);
                String line;
                System.out.println("Before loop");
                while ((line = ir.readLine()) != null) {
                    System.out.println("Inside Loop");
                    System.out.printf("Ping %s\n", line);
                    reply.printf("Ping %s\n", line);
                    reply.flush();
                }
            }
        }
    }
}
