package org.quintilis.honras

import org.bukkit.plugin.java.JavaPlugin
import com.mongodb.kotlin.client.coroutine.MongoClient

class Honras : JavaPlugin() {
    val mongoUri = "mongodb://localhost:27017";
    val mongoConnection:MongoClient = MongoClient.create(mongoUri);
    val mineDatabase = mongoConnection.getDatabase("minecraft")

    override fun onEnable() {

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
