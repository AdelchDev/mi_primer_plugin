package me.adelch;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("tocar").setExecutor(this);
        getLogger().info("¡Hola, mundo! El plugin se ha habilitado.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("tocar")) {
            if (sender instanceof Player) {
                Player jugador = (Player) sender;
                jugador.sendMessage("§a¡Has tocado el plugin y el plugin te ha respondido!");
            } else {
                sender.sendMessage("Este comando solo lo puede usar un jugador.");
            }
            return true;
        }
        return false;
    }
    
    @Override
    public void onDisable() {
        getLogger().info("¡Adiós, mundo! El plugin se ha deshabilitado.");
    }
}