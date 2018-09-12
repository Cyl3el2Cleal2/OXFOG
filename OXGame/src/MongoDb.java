import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

class MongoDb {
   MongoClient client = new MongoClient(new MongoClientURI("mongodb://ox:oxox@125.27.10.67:27017/OX"));

     //MongoClient client = new MongoClient(new MongoClientURI("mongodb://chain:chain555@ds018538.mlab.com:18538/ox"));
     MongoDatabase db = client.getDatabase("OX");
     MongoCollection <Document> col = db.getCollection("USER");

     

     public boolean addMember(String a,String b,String c,String d) {
    
    	Document doc1=new Document("username",a).append("password", b).append("picture",c).append("Email",d);
    	Document findQuery=new Document("username",a);
    	MongoCursor<Document>  cursor = col.find(findQuery).iterator();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                if(doc.get("username").equals(a))
                	return true;
            }
        } finally {
            cursor.close();
        }
        col.insertOne(doc1);      
        return false;
 
     }
     
}
