package org.quintilis.honras.managers

import org.quintilis.honras.types.ClanInvite
import java.util.UUID

class InviteManager {
    val inviteMap:HashMap<UUID,ClanInvite> = HashMap<UUID,ClanInvite>()
    
    fun addInvite(invite:ClanInvite) {
        inviteMap.put(invite.receiver, invite)
    }
    fun removeInvite(invite:ClanInvite) {
        inviteMap.put(invite.receiver, invite)
    }
    fun getInviteByReceiver(receiver: UUID): ClanInvite? {
        return inviteMap.get(receiver)
    }
    fun hasInvite(receiver: UUID):Boolean{
        return inviteMap.containsKey(receiver)
    }
}