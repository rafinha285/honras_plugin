package org.quintilis.honras.handlers

import org.bukkit.command.CommandSender

class CommandErrorHandler {
    
    fun notPlayer(sender:CommandSender):Boolean{
        sender.sendMessage("Comando somente para players")
        return false
    }
    fun notOwner(sender:CommandSender):Boolean{
        sender.sendMessage("Você não é o dono do clã")
        return false
    }
    fun playerNotFound(sender:CommandSender):Boolean{
        sender.sendMessage("Player não encontrado")
        return false
    }
    fun wrongArgument(sender:CommandSender):Boolean{
        sender.sendMessage("Argumentos errados")
        return false
    }
}