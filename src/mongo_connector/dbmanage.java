package mongo_connector;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
public class dbmanage {
static private String url = "mongodb://ox:oxox@125.27.10.67:27017/OX";
static private MongoClient mongo =null;
static MongoDatabase db;
	public static MongoDatabase getConnect() {
		
		mongo = new MongoClient(new MongoClientURI(url));
		db = mongo.getDatabase("OX");
		
		return db;
	}
	public static String testConnect() {
		getConnect();
		return 	db.toString() + "\nStatus : Connected";
	}
	
	public static MongoDatabase getDatabase() { return db; };

}
