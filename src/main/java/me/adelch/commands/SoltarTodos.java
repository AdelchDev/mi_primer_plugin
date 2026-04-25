package me.adelch.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SoltarTodos implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
            @NotNull String[] args) {

        if (!CommandUtils.isCommand(command, "soltartodos"))
            return false;
        if (CommandUtils.lacksPermission(sender, "miprimerplugin.admin.soltartodos"))
            return true;
        soltarTodoElServidor();
        return true;
    }

    private void soltarTodoElServidor() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.dropItem(true);
        }
    }
}