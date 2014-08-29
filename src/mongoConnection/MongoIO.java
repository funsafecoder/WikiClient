package mongoConnection;

import java.net.UnknownHostException;

import org.bson.BasicBSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
<<<<<<< HEAD

import dataLayer.Page;
public class MongoIO {
	
	private MongoClient mongoClient;
	private DB db;
	private DBCollection coll;
	
=======
import dataLayer.Page;

public class MongoIO {

	private MongoClient mongoClient;
	private DB db;
	private DBCollection coll;

>>>>>>> 33d03b1fab5366170f49a71068a7fbcc5acccb65
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
<<<<<<< HEAD
	
	public Page findPage(String search){
		DBCursor page = coll.find(new BasicDBObject("page.title", search));
		String title = "";
		String content = "";
		
		try {
			   while(page.hasNext()) {
				   DBObject pagee = page.next();
				   title += ((BasicBSONObject) pagee.get("page")).get("title");
				   content += ((BasicBSONObject) ((BasicBSONObject) ((BasicBSONObject) pagee.get("page")).get("revision")).get("text")).get("content");   
=======

	public Page findPage(String search){
		DBCursor page = coll.find(new BasicDBObject("title", search));
		   System.out.println(page + "page");
		String title = "";
		String content = "";
		System.out.println("hello before try");
		try {
			   while(page.hasNext()) {
				   System.out.println("Found");
				   DBObject pagee = page.next();
				   System.out.println(pagee);
				   title += (BasicBSONObject) pagee.get("title");
				   content += (BasicBSONObject) pagee.get("text");
>>>>>>> 33d03b1fab5366170f49a71068a7fbcc5acccb65
			   }
			} finally {
			   page.close();
			}
<<<<<<< HEAD
=======
		
>>>>>>> 33d03b1fab5366170f49a71068a7fbcc5acccb65
		return new Page(title, content);
	}
}
