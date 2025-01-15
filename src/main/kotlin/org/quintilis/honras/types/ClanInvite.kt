package org.quintilis.honras.types

import org.bson.types.ObjectId
import org.bukkit.entity.Player
import java.util.UUID

class ClanInvite(val sender:UUID,val receiver:UUID,val clanId:ObjectId,val inviteTime:Long) {
    fun getSender():UUID{
        return sender;
    }
    fun getReceiver():UUID{
        return receiver;
    }
    fun getClanId():ObjectId{
        return clanId;
    }
}