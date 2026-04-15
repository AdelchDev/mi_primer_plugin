package me.adelch.commands.Granters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.adelch.Items.Trinkets.AttackBoost;
import me.adelch.commands.CommandUtils;

public class AttackBoostCommand implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String commandName, String[] args) {
        boolean resultado = false;

        if (CommandUtils.isCommand(command, "attackboost")) {

            if (commandSender instanceof Player) {
                Player p = (Player) commandSender;
                ItemStack item = AttackBoost.getTrinket();
                p.getInventory().addItem(item);
                p.sendMessage("§e¡Attack Boost!");
                resultado = true;
            }
        }
        return resultado;
    }
    
}
