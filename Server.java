package Send_TXT;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class Server {

    public static void main(String[] args) {

        try {
            // Create a server socket on port 45000
            ServerSocket server = new ServerSocket(45000);
            // Display a message indicating the server is listening
            System.out.println("Server is listening on port 45000");
            // Wait for a client to connect and accept the connection
            Socket exchangeSocket = server.accept();
            System.out.println("We got a connection");
            /*
            //inputstream : Set up input stream components
            InputStream inStream = exchangeSocket.getInputStream();
            InputStreamReader reader = new InputStreamReader(inStream);
            BufferedReader buffin = new BufferedReader(reader);

            //outputstream : Set up output stream components
            OutputStream outStream = exchangeSocket.getOutputStream();
            PrintWriter out = new PrintWriter(outStream, true);

            //read from socket : Read a line from the client and print it
             String line = buffin.readLine();
             System.out.println(line);

            //write to socket : Prompt the user for input and send it to the client
            Scanner sc = new Scanner(System.in);
            System.out.println("Your message :");
            String message = sc.nextLine();
            out.println(message);
             */

            DataInputStream dis = new DataInputStream(exchangeSocket.getInputStream());
            FileOutputStream fos = new FileOutputStream("C:/Server/Alarm.mp3");

            System.out.println("Client connected");

            int bytesRead;
            byte[] buffer = new byte[4096];
            while ((bytesRead = dis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File received");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}