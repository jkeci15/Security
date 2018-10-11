## Assignment 1 

### Setting up Connection:

The assignment is about establishing a securte connection between a client and a server using the defined port 7007. 

Our implemenentation makes use of the provider defined in the JSSE (Java Secure Socket Extension).

We chose this provider because is supports both SSL and TLS protocols. This way, they add a level of security when we establish a connection between the two entities. The security consist of:

-  Data encryption

- Server authentication

- Client authentication

- Message integrity 

  ​																

  After this secure connection is established TCP protocol is used to transmit messages between them.

The steps neede to make the connection are as follow:

- Firstly we generate a certificate for both entities as they are needed for the Handshake part of the connection. In this part, both entities agree on the parameters required to make the connection such as : 
  - Session ID
  - Compression method
  - Cipher Suite etc.

- After the handshake phase is completed, the two entities can exchange messages using the Secure Socket Layer as long as the client wishes to terminate the connection.

- During the communication, the client writes a message and the server receives the message which it later sends back to the client to verify what the message was.
