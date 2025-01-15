package org.quintilis.honras.commands.clans

import org.bson.types.ObjectId
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player
import org.quintilis.honras.managers.ClansManager
import org.quintilis.honras.managers.PlayerManager
import org.quintilis.honras.types.ClansCollection

class CreateClan(val clansManager: ClansManager,val playerManager: PlayerManager): CommandExecutor, TabExecutor {
    override fun onCommand(sender: CommandSender,command: Command,string: String,args: Array<String>):Boolean {
        val clanName:String = args[0]
        if(sender !is Player) {
            sender.sendMessage("Somente jogadores podem criar clãs")
            return false;
        }
        if(playerManager.isInClan(sender as Player)) {
            sender.sendMessage("Você ja esta em um clã")
            return false
        }
        if(clansManager.getClanFromName(clanName) != null) {
            sender.sendMessage("Clã ja existe")
            return false;
        }
        val clan = ClansCollection(ObjectId(),clanName)
        clansManager.createClan(clan)
        return true;
    }
    
    
    override fun onTabComplete(sender: CommandSender,command: Command,string: String,args: Array<String>): List<String> {
        return listOf()
    }
}