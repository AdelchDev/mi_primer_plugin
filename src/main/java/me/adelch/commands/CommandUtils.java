package me.adelch.commands;

import org.bukkit.command.*;

public class CommandUtils {

    public static boolean isCommand(Command command, String commandName) {
        return command.getName().equalsIgnoreCase(commandName);
    }
    
}
