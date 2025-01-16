package org.quintilis.honras.managers

import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import kotlinx.coroutines.flow.*
import org.bson.types.ObjectId
import org.bukkit.entity.Player
import org.quintilis.honras.types.ClansCollection
import java.util.*

class ClansManager(val mongoCollection: MongoCollection<ClansCollection>){
	fun getClanFromName(clanName:String):ClansCollection?{
		val clan:ClansCollection? = mongoCollection.find(Filters.eq("name",clanName)).firstOrNull()
		return clan
	}

	fun getFromOwner(owner:UUID):ClansCollection?{
		 return mongoCollection.find(Filters.eq("owner",owner)).firstOrNull()
	}
	
	fun getClan(clanId: ObjectId): ClansCollection{
		 return mongoCollection.find(Filters.eq("_id", clanId)).first()
	}
	
	fun getFromPlayer(player:Player):ClansCollection? {
		val clan :ClansCollection? =
			mongoCollection.find(Filters.`in`("members", player.uniqueId.toString())).firstOrNull()
		return clan
	}
	
	fun setClanName(id:ObjectId,clanName:String) {
		val clan :ClansCollection = mongoCollection.find(Filters.eq("_id", id)).first()
		clan.name = clanName
	}
	
	fun setOwner(player:Player,id:ObjectId) {
		val clan :ClansCollection = mongoCollection.find(Filters.eq("_id", id)).first()
		clan.owner = player.uniqueId;
	}
	
	fun isOwner(player:Player):Boolean {
		val clan = mongoCollection.find(Filters.`in`("members", player.uniqueId.toString())).first()
		return clan.owner.equals(player.uniqueId)
	}
	
	fun addPlayerToClan(player:Player) {
		val clan = mongoCollection.find(Filters.eq("_id", player.uniqueId.toString())).first()
	}
	
	fun createClan(clan:ClansCollection){
		mongoCollection.insertOne(clan)
	}
	
	fun deleteClan(clan: ClansCollection){
		mongoCollection.deleteOne(Filters.eq("_id", clan.id))
	}
}