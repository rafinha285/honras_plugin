package org.quintilis.honras.managers

import com.mongodb.kotlin.client.coroutine.MongoCollection
import com.mongodb.client.model.Filters
import kotlinx.coroutines.flow.*
import org.bson.types.ObjectId
import org.bukkit.entity.Player
import org.quintilis.honras.types.ClansCollection

class ClansManager(val mongoCollection: MongoCollection<ClansCollection>){
	suspend fun getClan(clanName:String):ClansCollection?{
		val clan:ClansCollection? = mongoCollection.find(Filters.eq("name",clanName)).firstOrNull()
		return clan
	}
	
	suspend fun getFromPlayer(player:Player):ClansCollection?{
		val clan:ClansCollection? = mongoCollection.find(Filters.`in`("members",player.uniqueId.toString())).firstOrNull()
		return clan
	}
	
	
}