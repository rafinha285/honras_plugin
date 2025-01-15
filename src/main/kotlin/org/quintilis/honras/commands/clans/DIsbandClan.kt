package org.quintilis.honras.commands.clans

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import org.quintilis.honras.managers.ClansManager
import org.quintilis.honras.managers.PlayerManager

class DIsbandClan(val clansManager :ClansManager,val playerManager :PlayerManager): CommandExecutor, TabCompleter {
	override fun onTabComplete(sender:CommandSender, command:Command, string: String, args: Array<String>): List<String> {
		return listOf()
	}
	
	override fun onCommand(sender :CommandSender, command :Command, string :String, args :Array<out String>?) :Boolean {
		if(sender !is Player) {
			sender.sendMessage("Comando só pode ser executado por um player")
			return false
		}
		if(!clansManager.isOwner(sender as Player)) {
			sender.sendMessage("VOcê nao é o dono do clã")
			return false
		}
		val clan = clansManager.getClan(playerManager.getClanId(sender))
		for ()
		return true
	}
}