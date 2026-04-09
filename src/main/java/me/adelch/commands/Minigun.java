package me.adelch.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.adelch.Items.MinigunPesada;

public class Minigun implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String commandName, String[] args) {
        boolean resultado = false;

        if (CommandUtils.isCommand(command, "minigun")) {

            if (commandSender instanceof Player) {
                Player p = (Player) commandSender;
                ItemStack item = MinigunPesada.getMinigun();
                p.getInventory().addItem(item);
                p.sendMessage("§e¡Heavy machine gun!");
                resultado = true;
            }
        }
        return resultado;
    }
}
