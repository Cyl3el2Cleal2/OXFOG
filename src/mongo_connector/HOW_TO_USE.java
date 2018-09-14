package mongo_connector;

import com.mongodb.client.MongoDatabase;

public class HOW_TO_USE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
new dbmanage();
		//		test connection
		System.out.println(dbmanage.testConnect());
		
new dbmanage();
		//		create DB for query data
		MongoDatabase x = dbmanage.getConnect();
		
	}

}
