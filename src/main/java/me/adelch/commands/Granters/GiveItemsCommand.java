package me.adelch.commands.Granters;

import java.util.Collection;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import me.adelch.Items.CustomItem;
import me.adelch.Items.ItemManager;

public class GiveItemsCommand implements CommandExecutor {

    private final ItemManager manager;

    public GiveItemsCommand(ItemManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
            @NotNull String[] args) {

        if (label.equalsIgnoreCase("getItems")) {

            if (!(sender instanceof Player player)) {
                sender.sendMessage("§cEste comando solo puede ser usado por jugadores.");
                return true;
            }

            Collection<CustomItem> moldes = manager.getItems();

            for (CustomItem molde : moldes) {
                player.getInventory().addItem(molde.createItem());
            }

            player.sendMessage("§a¡Has recibido todos los items del registro!");
            return true;
        }
        return false;
    }
}
