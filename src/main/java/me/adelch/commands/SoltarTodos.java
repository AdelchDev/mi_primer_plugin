package me.adelch.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;


public class SoltarTodos implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String commandName, String[] args) {
        boolean resultado = false;

        if (CommandUtils.isCommand(command, "soltartodos")) {
            soltarTodoElServidor();
            resultado = true;
        }

        return resultado;
    }

    public void soltarTodoElServidor() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.dropItem(true);
        }

    }
}
