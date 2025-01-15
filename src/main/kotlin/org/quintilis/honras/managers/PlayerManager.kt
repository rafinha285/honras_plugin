package org.quintilis.honras.managers

import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters.*
import kotlinx.coroutines.flow.*
import org.bson.Document
import org.bson.types.ObjectId
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.quintilis.honras.types.PlayerCollection

class PlayerManager(val playerCollection: MongoCollection<PlayerCollection>,val clanManager :ClansManager){
    val logger = Bukkit.getLogger()
    fun isInDatabase(player: Player) : Boolean{
        return playerCollection.find(eq("_id",player.uniqueId.toString())).firstOrNull()!=null
    }
    
    fun setClan(player: Player, clanId:ObjectId?) {
        val document = Document()
            .append("clanId", clanId ?: "")
        playerCollection.updateOne(eq("_id",player.uniqueId.toString()),document)
    }
    
    fun isInClan(player: Player) : Boolean{
        val isInClanPlayer:Boolean = playerCollection.find(eq("_id",player.uniqueId.toString())).first().clanId!=null
        val isInClanClan:Boolean = clanManager.getFromPlayer(player)!=null
        return isInClanPlayer&&isInClanClan
    }
    
    fun getClanId(player :Player):ObjectId?{
        val doc = playerCollection.find(eq("_id",player.uniqueId.toString())).first()
        return doc.clanId
    }
    
    fun addPlayer(player: Player){
        val playerDoc = PlayerCollection(player.uniqueId.toString(),player.name,ObjectId())
        playerCollection.insertOne(playerDoc)
        logger.info("Player ${player.name} added to database")
    }
}