package org.quintilis.honras.honras

import org.quintilis.honras.Honras
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import org.bukkit.event.Listener
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.PlayerDeathEvent

class HonrasManager(val mongoClient: MongoDatabase,val plugin:Honras) : Listener {

}