package org.quintilis.honras.commands.invite

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import org.quintilis.honras.handlers.CommandErrorHandler

class SendInvite: CommandExecutor, TabCompleter {
    override fun onTabComplete(
        p0 :CommandSender,
        p1 :Command,
        p2 :String,
        p3 :Array<out String>?
    ) :List<String> {
       return listOf()
    }
    val errorHandler:CommandErrorHandler = CommandErrorHandler()
    override fun onCommand(sender :CommandSender, command :Command, s :String, args :Array<out String>) :Boolean {
        if(sender !is Player){
            return errorHandler.notPlayer(sender)
        }
        if(args.size != 1){
            return errorHandler.wrongArgument(sender)
        }
        val player = Bukkit.getPlayer(args[0])
        if(player == null){
            return errorHandler.playerNotFound(sender)
        }
        return true
    }
}