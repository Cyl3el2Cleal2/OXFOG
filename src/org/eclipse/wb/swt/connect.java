package org.eclipse.wb.swt;

import java.net.UnknownHostException;

import org.bson.BSON;

import com.mongodb.*;
import com.mongodb.util.JSON;
public class connect {
private String url = "mongodb://ox:oxox@125.27.10.67:27017/OX";
private MongoClient mongo =null;
DB db;
	public DB getConnect() {
		
		try {
			mongo = new MongoClient(new MongoClientURI(url));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db = mongo.getDB("OX");
		
		return db;
	}
	public String testConnect() {
		getConnect();
		return 	db.toString() + "\nStatus : Connected+\n" + db.getCollectionNames().toString();
		
	}
	public 	void InsertUser(String user,String pass,String email) {
		getConnect();
		DBCollection coll  = db.getCollection("USER");
		DBObject x = (DBObject) JSON
				.parse("{'USERNAME':'"+user+"', 'PASSWORD':'"+pass+"', 'email':'"+email+"'}");
		
		coll.insert(x);
		

		
	}

}
