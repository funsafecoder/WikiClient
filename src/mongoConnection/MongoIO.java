package mongoConnection;

import java.net.UnknownHostException;

import org.bson.BasicBSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import dataLayer.Page;
public class MongoIO {
	
	private MongoClient mongoClient;
	private DB db;
	private DBCollection coll;
	
	public MongoIO(String IP, int port, String database, String collection) {
		try {
			mongoClient = new MongoClient( IP , port );
			System.out.println("Connecting");
			db = mongoClient.getDB(database);
			coll = db.getCollection(collection);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public boolean verifyAuth(String username, String password){
//		DB database = mongoClient.getDB("test");
//		boolean isValid = database.authenticate(username, password.toCharArray());
//		return isValid;
//	}
	
	public Page findPage(String search){
		DBCursor page = coll.find(new BasicDBObject("page.title", search));
		String title = "";
		String content = "";
		
		try {
			   while(page.hasNext()) {
				   DBObject pagee = page.next();
				   title += ((BasicBSONObject) pagee.get("page")).get("title");
				   content += ((BasicBSONObject) ((BasicBSONObject) ((BasicBSONObject) pagee.get("page")).get("revision")).get("text")).get("content");   
			   }
			} finally {
			   page.close();
			}
		return new Page(title, content);
	}
}
