package me.adelch.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import net.kyori.adventure.text.minimessage.MiniMessage;

public class CommandUtils {

    public static boolean isCommand(Command command, String commandName) {
        return command.getName().equalsIgnoreCase(commandName);
    }

    /**
     * Verifica si el ejecutor tiene un permiso.
     * Si no lo tiene, envía un mensaje de error automáticamente.
     * @return true si NO tiene permiso (para activar el return del comando).
     */
    public static boolean lacksPermission(CommandSender sender, String permission) {
        if (!sender.hasPermission(permission)) {
            sender.sendMessage(MiniMessage.miniMessage().deserialize(
                    "<red><bold>![!]</bold> No tienes permiso para ejecutar esta acción."));
            return true;
        }
        return false;
    }
}
