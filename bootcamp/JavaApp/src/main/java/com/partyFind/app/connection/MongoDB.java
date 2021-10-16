package com.partyFind.app.connection;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;

public class MongoDB {


    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient();
        DB database = mongoClient.getDB("partyDB");

        //print existing databases
        mongoClient.getDatabaseNames().forEach(System.out::println);
        database.createCollection("customers", null);

        //print all collections
        database.getCollectionNames().forEach((System.out::println));

//        //create data
//        DBCollection collection = database.getCollection("customers");
//        BasicDBObject document = new BasicDBObject();
//        document.put("name", "FestaBarra");
//        document.put("city", "Rio de Janeiro");
//        collection.insert(document);
//
//        //update data
//        BasicDBObject query = new BasicDBObject();
//        query.put("name", "FestaBarra");
//        BasicDBObject newDocument = new BasicDBObject();
//        newDocument.put("name", "Festa na Barra");
//        BasicDBObject updateObject = new BasicDBObject();
//        updateObject.put("$set", newDocument);
//        collection.update(query, updateObject);
//
//        //read data
//        BasicDBObject searchQuery = new BasicDBObject();
//        searchQuery.put("name", "Festa na Barra");
//        DBCursor cursor = collection.find(searchQuery);
//        while(cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }
//
//        //delete data
//        BasicDBObject deleteQuery = new BasicDBObject();
//        deleteQuery.put("name", "Festa na Barra");
//        collection.remove(deleteQuery);
    }
}
