package org.quintilis.honras.managers

import org.quintilis.honras.Honras
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import org.bukkit.event.Listener

class HonrasManager(val mongoClient: MongoDatabase,val plugin:Honras) : Listener {

}