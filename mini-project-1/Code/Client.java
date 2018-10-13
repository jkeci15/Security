import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.net.ssl.*;
import java.security.Security;
import java.util.Scanner;
import com.sun.net.ssl.internal.ssl.Provider;

public class Client
{
    public static void main(String args[])
    {
        //We provide the port and name of the Server with which the client will attempt to connect
    	int port = 7007;
        String name = "localhost";

        Security.addProvider(new Provider());
        //specifying the trustStore file which contains the certificate & public of the server
        System.setProperty("javax.net.ssl.trustStore","myTrustStore.jts");
        //specifying the password of the trustStore file
        System.setProperty("javax.net.ssl.trustStorePassword","1tsBritneyBi$h");
        try
        {
            //Create SSLSocket and connect to server
            SSLSocket sslSocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket(name,port);
           
            //create an output stream through which we send messages to the server
            DataOutputStream outStream = new DataOutputStream(sslSocket.getOutputStream());
            //create an inputStream from which we read messages sent to us by the server
            DataInputStream inStream = new DataInputStream(sslSocket.getInputStream());
            
            
            //read the first message sent by the server as soon as connection is established
            System.out.println(inStream.readUTF());
            
            Scanner sc = new Scanner(System.in);
            
            //Keep sending sending the server the message entered by the client
            //until the server terminates the connection
            while (true)
            {
                System.out.println("Enter a message to the server:");
                String message = sc.nextLine();
                
                //send the message to the output stream
                outStream.writeUTF(message);
                
                //read the incoming message form the server
                String serverMsg = inStream.readUTF();
                System.out.println("The server says: \""+serverMsg+"\"");
                
                //check if server has notified that the connection will be terminated
                if(serverMsg.equals("The connection was terminated."))
                {
                    sc.close();
                    break;
                }
            }
        }
        catch(Exception e)
        {
        	//in case of an exception let the client know what went wrong
        	System.out.println("Something wrong has happened! " + e.toString());
            System.out.println("Mission aborted");
        }
    }
}