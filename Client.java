package Send_TXT;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import jitpack.io.*;

public class Client {

    public static void main(String[] args) throws IOException {

        try {
            // Create a client socket and connect to the server at IP 127.0.0.1 and port 45000
            Socket client = new Socket("127.0.0.1", 45000);

            // Display a message indicating successful connection
            System.out.println("We got in");
            /*
            //inputstream :  Set up input stream components
            InputStream inStream = client.getInputStream();
            InputStreamReader reader = new InputStreamReader(inStream);
            BufferedReader buffin = new BufferedReader(reader);

            //outputstream : Set up output stream components
            OutputStream outStream = client.getOutputStream();
            PrintWriter out = new PrintWriter(outStream, true);

            //write to socket : Prompt the user for input and send it to the server
            Scanner sc = new Scanner(System.in);
            System.out.println("Your message :");
            String message = sc.nextLine();
            out.println(message);

            //read from socket : Read a line from the server and print it
            String line = buffin.readLine();
            System.out.println(line);
*/
            // Set up DataOutputStream to send binary data
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            // Open a FileInputStream for the file to be sent
            FileInputStream fis = new FileInputStream("C:/Client/Alarm.mp3");


            byte[] buffer = new byte[4096];
            int bytesRead;

            // Read file in chunks and send to the server
            while ((bytesRead = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
