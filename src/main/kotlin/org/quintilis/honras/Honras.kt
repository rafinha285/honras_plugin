package org.quintilis.honras

import org.bukkit.plugin.java.JavaPlugin
import com.mongodb.kotlin.client.coroutine.MongoClient
import org.quintilis.honras.honras.HonrasManager
import org.bukkit.event.Listener

class Honras : JavaPlugin() {
    val mongoUri = "mongodb://localhost:27017";
    val mongoConnection:MongoClient = MongoClient.create(mongoUri);
    val mineDatabase = mongoConnection.getDatabase("minecraft")


    override fun onEnable() {
        HonrasManager(mineDatabase,Honras())

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
