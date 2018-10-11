import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.net.ssl.*;
import java.security.Security;
import com.sun.net.ssl.internal.ssl.Provider;

public class Server 
{
    public static void main(String args[])
    {
    	//Specify the port number where the server accepts the client connections
        int port = 7007;
        
        Security.addProvider(new Provider());
        //specify the keystore file with the certificate/public key and the private key, and its password
        System.setProperty("javax.net.ssl.keyStore","myKeyStore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword","1tsBritneyBi$h");
        
        try
        {
        	//create SSLSocket for  the server in the given port
            SSLServerSocket sslServerSocket = (SSLServerSocket)SSLServerSocketFactory.getDefault().createServerSocket(port);
            System.out.println("The server is ready to accept a client connection.");
            
            //wait for a client connection to our server
            SSLSocket sslSocket = (SSLSocket)sslServerSocket.accept();
            
            //create an input and an output stream to send and receive messages
            DataInputStream inStream = new DataInputStream(sslSocket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(sslSocket.getOutputStream());
            
            //send the first message to the client to let them know of the successful connection
            //and how they can terminate it
            outStream.writeUTF("Your connection is established. Leave a message. \n"
            		+ "When you no longer want to use this connection, send a 'Bye Server' message.");
            
            //Keep sending the client the message you receive from them until they send "Bye Server"
            while(true)
            {
            	//get the client's message from the input stream and print it
                String receivedMsg = inStream.readUTF();
                System.out.println("Client wrote : " + receivedMsg);
                
                if(receivedMsg.equals("Bye Server"))
                {
                	System.out.println("Closing connection.");
                	//let the Client know the connection will no longer be open
                    outStream.writeUTF("The connection was terminated.");
                    
                    //close both Streams of communication
                    outStream.close();
                    inStream.close();
                    
                    //close the Sockets in order to no longer accept any packets
                    sslSocket.close();
                    sslServerSocket.close();
                    break;
                }
                else
                {
                    outStream.writeUTF("You wrote: "+receivedMsg);
                }
            }
        }
        catch(Exception e)
        {
            System.err.println("An error has happened on the server's side: "+ e.toString());
        }
    }
}
