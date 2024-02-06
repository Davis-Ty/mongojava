# mongojava
Connect to MongoDB Atlas with Java This Java code establishes a connection to MongoDB Atlas using the Java driver. It creates a nested class connectMongo to manage the connection, verifies it with a ping command, and closes it when done.

# Import Statements:
Necessary classes and interfaces from the com.mongodb and org.bson packages are imported.

# mongojava Class: 
This is the main class serving as the entry point for the program.

# connectMongo Class:
- A nested class encapsulating connection logic:
Instance Variables: uri, mongoClient, and database are initialized for connecting to the MongoDB server and handling the database.

- Constructor: Establishes the connection to MongoDB Atlas, verifies the connection with a ping command, and handles exceptions.

# closeConnection() Method:
Closes the MongoDB client connection.

# main Method:
- The entry point where an instance of connectMongo is created to establish the MongoDB connection. Additional operations with the database can be added here.

This code serves as a template for connecting to MongoDB Atlas, performing operations, and properly closing the connection.
