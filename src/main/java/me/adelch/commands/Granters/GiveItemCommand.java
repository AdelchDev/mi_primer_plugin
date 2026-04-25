package me.adelch.commands.Granters;

import me.adelch.Items.CustomItem;
import me.adelch.Items.ItemManager;
import me.adelch.Items.Weapons.CustomWeapon;
import me.adelch.Items.Weapons.WeaponTierTypes;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter; 
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GiveItemCommand implements CommandExecutor, TabCompleter {

    private final ItemManager manager;

    public GiveItemCommand(ItemManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
            @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Solo jugadores pueden usar este comando.");
            return true;
        }

        if (args.length == 0) {
            player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Uso: /getitem <id>"));
            return true;
        }

        CustomItem objeto = manager.getItemByID(args[0]);

        if (objeto != null) {
            
            player.getInventory().addItem(objeto.createItem());
            player.sendMessage(MiniMessage.miniMessage().deserialize(
                    "<green>¡Has recibido: <yellow>" + objeto.getKey().getKey() + "<green>!"));
        } else {
            player.sendMessage(MiniMessage.miniMessage().deserialize("<red>El objeto '" + args[0] + "' no existe."));
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command,
            @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            return manager.getItems().stream()
                    .map(w -> w.getKey().getKey())
                    .filter(id -> id.toLowerCase().startsWith(args[0].toLowerCase()))
                    .collect(Collectors.toList());
        }

        return new ArrayList<>(); 
    }
}