import java.net.UnknownHostException;

import javax.swing.JOptionPane;

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
		BasicDBObject searchQuery  = new BasicDBObject();
		searchQuery.put("USERNAME", user);
		DBCursor cursor = coll.find(searchQuery);
		int i=0;
		while (cursor.hasNext()) {
                    i++;
			cursor.next();
		} if(i!=0){  
			JOptionPane.showMessageDialog(null, "Username ของท่านซ่ำกับผู้อื่นกรุณาใช้ Username อื่น", "เกิดข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
                }            
        
			if(i==0){
        		DBObject x = (DBObject) JSON
				.parse("{'USERNAME':'"+user+"', 'PASSWORD':'"+pass+"', 'email':'"+email+"'}");
		
		coll.insert(x);
        }
        	
        
	}
			

}
