/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author ANA COTRADO
 */
public class ConexionMongoDB {
    static String db = "dbFerreteria";
    
    public ConexionMongoDB(){
    }
    public MongoDatabase conexion(){
        MongoDatabase conexion = new MongoClient().getDatabase(db);
        return conexion;
    }
}
