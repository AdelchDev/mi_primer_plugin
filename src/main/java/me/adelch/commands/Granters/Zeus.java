package me.adelch.commands.Granters;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.adelch.Items.Weapons.PalitroqueZeus;
import me.adelch.commands.CommandUtils;

public class Zeus implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String commandName, String[] args) {
        boolean resultado = false;

        if (CommandUtils.isCommand(command, "zeus")) {

            if (commandSender instanceof Player) {
                Player p = (Player) commandSender;
                ItemStack item = PalitroqueZeus.getArma();
                p.getInventory().addItem(item);
                p.sendMessage("§e¡Has invocado el poder de Zeus!");                
                resultado = true;   
                
            }
        }
        return resultado;
    }

}
