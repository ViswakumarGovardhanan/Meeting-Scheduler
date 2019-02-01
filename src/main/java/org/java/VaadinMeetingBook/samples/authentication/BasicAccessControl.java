package org.java.VaadinMeetingBook.samples.authentication;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Set;



/**
 * Default mock implementation of {@link AccessControl}. This implementation
 * accepts any string as a password, and considers the user "admin" as the only
 * administrator.
 */
public class BasicAccessControl implements AccessControl {

	@Override
	public boolean signIn(String username, String password) {

		String auth_user="viswa", auth_pwd = "viswa@123";
		String encoded_pwd = "";
		try {
			encoded_pwd = URLEncoder.encode(auth_pwd, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String client_url =
				"mongodb://" + auth_user + ":" + encoded_pwd 
				+ "@" + "ds163764.mlab.com" + ":" + 63764 + ""
				+ "/" + "pickmeeting";



		//  mongodb://<dbuser>:<dbpassword>@ds031902.mlab.com:31902/checkvaadintest

//		MongoClientURI uri = new MongoClientURI(client_url);
//
//		MongoClient mongoClient = new MongoClient(uri);
//
//		DB viswadbconnection = mongoClient.getDB("pickmeeting");
//
//
//		DBCollection collection = viswadbconnection.getCollection("PickMeeting");
//		/**** Insert ****/
//		// create a document to store key and value
//		BasicDBObject document = new BasicDBObject();
		//       document.put("userName", meetingpurposefield.getValue());
		//       document.put("password", meetingpurposefieldtwo.getValue());
//		collection.insert(document);
//
//		Set<String> collectionname = viswadbconnection.getCollectionNames();

		//System.out.println(collectionname +"collectionnamecollectionname");

		/**** Get database ****/
		// if database doesn't exists, MongoDB will create it for you
		// DB db = mongoClient.getDB("testdb");
		//  mongoClient.getDatabaseNames().forEach(System.out::println);
		/**** Get collection / table from 'testdb' ****/
		// if collection doesn't exists, MongoDB will create it for you
		//  DBCollection collection = db.getCollection("users");
		/**** Insert ****/
		// create a document to store key and value
		// BasicDBObject document = new BasicDBObject();
		//         document.put("firstName", "Dharam");
		//         document.put("lastName", "Rajput");
		// collection.insert(document);


		///////////////









		return false;

	}


	@Override
	public boolean isUserSignedIn() {
		// return !CurrentUser.get().isEmpty();
		return false;
	}


	@Override
	public void createAccount(String userName, String password) {

		if(!userName.isEmpty() && !password.isEmpty()){

			String auth_user="viswa", auth_pwd = "viswa@123";
			String encoded_pwd = "";
			try {
				encoded_pwd = URLEncoder.encode(auth_pwd, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String client_url =
					"mongodb://" + auth_user + ":" + encoded_pwd 
					+ "@" + "ds163764.mlab.com" + ":" + 63764 + ""
					+ "/" + "pickmeeting";



			//  mongodb://<dbuser>:<dbpassword>@ds031902.mlab.com:31902/checkvaadintest

//			MongoClientURI uri = new MongoClientURI(client_url);
//
//			MongoClient mongoClient = new MongoClient(uri);
//
//			DB viswadbconnection = mongoClient.getDB("pickmeeting");
//
//
//			DBCollection collection = viswadbconnection.getCollection("UserNames");
//			/**** Insert ****/
//			// create a document to store key and value
//			BasicDBObject document = new BasicDBObject();
//			document.put("userName",userName);
//			document.put("password",password);
//			collection.insert(document);
//
//			Set<String> collectionname = viswadbconnection.getCollectionNames();

			//System.out.println(collectionname +"collectionnamecollectionname");

			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			// DB db = mongoClient.getDB("testdb");
			//  mongoClient.getDatabaseNames().forEach(System.out::println);
			/**** Get collection / table from 'testdb' ****/
			// if collection doesn't exists, MongoDB will create it for you
			//  DBCollection collection = db.getCollection("users");
			/**** Insert ****/
			// create a document to store key and value
			// BasicDBObject document = new BasicDBObject();
			//		         document.put("firstName", "Dharam");
			//		         document.put("lastName", "Rajput");
			// collection.insert(document);


			///////////////







		}


	}

}
