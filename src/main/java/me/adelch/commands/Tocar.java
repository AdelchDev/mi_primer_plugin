package me.adelch.commands;

import org.bukkit.command.*;

public class Tocar implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String commandName, String[] args) {
        boolean resultado = false;
        
        if (CommandUtils.isCommand(command, "tocar")) {
            commandSender.sendMessage("§a¡Has tocado el plugin SARASA!");
            resultado = true;
        }
        return resultado;
    }

}
