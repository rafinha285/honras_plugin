package org.quintilis.honras.commands.clans

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import org.quintilis.honras.handlers.CommandErrorHandler
import org.quintilis.honras.managers.ClansManager
import org.quintilis.honras.managers.PlayerManager
import org.quintilis.honras.types.ClansCollection

class DisbandClan(val clansManager :ClansManager, val playerManager :PlayerManager): CommandExecutor, TabCompleter {
	override fun onTabComplete(sender:CommandSender, command:Command, string: String, args: Array<String>): List<String> {
		return listOf()
	}
	val errorHandler:CommandErrorHandler = CommandErrorHandler()
	override fun onCommand(sender :CommandSender, command :Command, string :String, args :Array<out String>?) :Boolean {
		if(sender !is Player) {
			return errorHandler.notPlayer(sender)
		}
		if(!clansManager.isOwner(sender)) {
			return errorHandler.notOwner(sender)
		}
		val clanId = playerManager.getClanId(sender) ?: return errorHandler.notInAClan(sender)
		val clan:ClansCollection = clansManager.getClan(clanId)
		//seta os clans dos participantes para nulo ou "" (string vazia)
		for (member in clan.members){
			val playerMember = Bukkit.getPlayer(member)
			if(playerMember != null){
				playerManager.setClan(playerMember,null)
			}
		}
		//deleta o clan
		clansManager.deleteClan(clan)
//		sender.sendMessage("Clã ${clan.name} foi desfeito")
		for(player in Bukkit.getOnlinePlayers()){
			player.sendMessage("${player.name} foi desfeito")
		}
		return true
	}
}