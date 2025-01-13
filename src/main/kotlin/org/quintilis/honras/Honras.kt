package org.quintilis.honras

import org.bukkit.plugin.java.JavaPlugin
import com.mongodb.kotlin.client.coroutine.MongoClient
import kotlinx.coroutines.flow.firstOrNull
import org.quintilis.honras.types.ClansCollection
import org.quintilis.honras.types.PlayerCollection
import org.quintilis.honras.types.PointsCollection


class Honras : JavaPlugin() {
    val mongoUri = "mongodb://localhost:27017"
    val mongoConnection:MongoClient = MongoClient.create(mongoUri)
    val mineDatabase = mongoConnection.getDatabase("minecraft")

    val pointsCollection = mineDatabase.getCollection<PointsCollection>("points")
    val playerCollection = mineDatabase.getCollection<PlayerCollection>("players")
    val clansCollection = mineDatabase.getCollection<ClansCollection>("clans")

    override fun onEnable() {
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
