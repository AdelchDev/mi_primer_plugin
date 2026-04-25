package me.adelch.commands.Granters;

import me.adelch.Items.CustomItem;
import me.adelch.Items.ItemManager;
import me.adelch.commands.CommandUtils;
import me.adelch.PluginKeys;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AttackBoostCommand implements CommandExecutor {

    private final ItemManager manager;

    public AttackBoostCommand(ItemManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
            @NotNull String[] args) {

        if (!CommandUtils.isCommand(command, "attackboost"))
            return false;

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Comando exclusivo para jugadores.");
            return true;
        }

        CustomItem trinket = manager.getItemByKey(PluginKeys.ATTACK_SPEED_KEY);

        if (trinket != null) {
            player.getInventory().addItem(trinket.createItem());

            player.sendMessage(MiniMessage.miniMessage().deserialize("<green>¡Has recibido el Attack Boost!"));
            return true;
        }

        player.sendMessage("§cError: El Attack Boost no se encuentra registrado en el sistema.");
        return true;
    }
}