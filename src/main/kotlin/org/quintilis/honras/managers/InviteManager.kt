package org.quintilis.honras.managers

import org.quintilis.honras.types.ClanInvite
import java.util.UUID

class InviteManager{
    private val inviteMap: MutableMap<UUID, MutableList<ClanInvite>>  = mutableMapOf()
    
    fun sendInvite(invite:ClanInvite) {
        inviteMap.computeIfAbsent(invite.sender) { mutableListOf() }.add(invite)
    }
    fun rejectInvite(invite:ClanInvite) {
        inviteMap[invite.receiver]?.remove(invite)
        if(inviteMap[invite.receiver]?.isEmpty() == true) {
            inviteMap.remove(invite.receiver)
        }
    }
    fun acceptInvite(invite:ClanInvite) {
        inviteMap[invite.receiver]?.remove(invite)
        if(inviteMap[invite.receiver]?.isEmpty() == true) {
            inviteMap.remove(invite.receiver)
        }
    }
    fun getInviteByReceiver(receiver: UUID): MutableList<ClanInvite>? {
        return inviteMap[receiver]
    }
    fun hasInvite(receiver: UUID):Boolean{
        return inviteMap[receiver]?.isNotEmpty() == true
    }
}