package org.quintilis.honras.commands.invite

import org.bukkit.command.Command
import org.bukkit.command.TabCompleter
import org.bukkit.command.CommandSender
import org.bukkit.command.CommandExecutor
import org.bukkit.entity.Player
import org.quintilis.honras.handlers.CommandErrorHandler
import org.quintilis.honras.managers.ClansManager
import org.quintilis.honras.managers.InviteManager
import org.quintilis.honras.managers.PlayerManager
// NAO USAR FAZENDO COMANDO MAIS BONITO NO Invite
class AcceptInvite(clansManager:ClansManager, playerManager: PlayerManager,inviteManager :InviteManager):CommandExecutor, TabCompleter {
    override fun onTabComplete(sender:CommandSender, command:Command, string: String, args: Array<String>): List<String> {
        return listOf()
    }
    val errorHandler = CommandErrorHandler()
    override fun onCommand(sender :CommandSender, command :Command, s :String, args :Array<String>?) :Boolean {
        if(sender !is Player) {
            return errorHandler.notPlayer(sender)
        }
        return true
    }
}