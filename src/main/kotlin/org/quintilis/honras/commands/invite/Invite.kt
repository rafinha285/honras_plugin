package org.quintilis.honras.commands.invite

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player
import org.quintilis.honras.managers.ClansManager
import org.quintilis.honras.managers.InviteManager
import org.quintilis.honras.managers.PlayerManager

class Invite(
        val clansManager:ClansManager,
        val playerManager:PlayerManager,
        val inviteManager:InviteManager
): CommandExecutor, TabExecutor {
    override fun onTabComplete(sender:CommandSender, command:Command, s:String,args:Array<String>):List<String>? {
        if (args.isEmpty()) {
            return null
        }
        if (args.size == 1){
            val completion = listOf("accept", "send", "reject")
            return completion
        }
        if(args.size == 2){
            when (args[0]) {
                "send"->{
                    return Bukkit
                        .getOnlinePlayers().map { it.name }
                        .filter{it.startsWith(args[1], ignoreCase = true)}
                }
                "accept","reject"->{
                    if(sender is Player){
                        val playerUUID = sender.uniqueId
                        val invitesList = inviteManager.getInviteByReceiver(playerUUID)
                        if(invitesList != null){
                            return invitesList.map { it.clanName }
                        }
                    }
                }
            }
        }
        return emptyList()
    }
    
    override fun onCommand(sender:CommandSender,command:Command, s:String, args:Array<String>):Boolean{
        return true
    }
}