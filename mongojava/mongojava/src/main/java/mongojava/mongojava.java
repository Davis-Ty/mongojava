package mongojava;

import com.mongodb.*;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class mongojava {

    static class connectMongo {
        // Replace the placeholder with (mongodb) Atlas connection string
        String uri = "";
        MongoClient mongoClient;
        MongoDatabase database;

        public connectMongo() {
            // Construct a ServerApi instance using the ServerApi.builder() method
            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(uri))
                    .serverApi(serverApi)
                    .build();
            // Create a new client and connect to the server
            mongoClient = MongoClients.create(settings);
            database = mongoClient.getDatabase("admin");

            try {
                // Send a ping to confirm a successful connection
                Bson command = new BsonDocument("ping", new BsonInt64(1));
                Document commandResult = database.runCommand(command);
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException me) {
                System.err.println(me);
            }
        }

        public void closeConnection() {
            mongoClient.close();
            System.out.println("Connection closed.");
        }
    }

    public static void main(String[] args) {
        connectMongo mongoConnection = new connectMongo();


        // Close the connection 
        mongoConnection.closeConnection();
    }
}
