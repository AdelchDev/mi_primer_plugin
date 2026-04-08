package me.adelch;

//import java.time.zone.ZoneRules;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        PluginKeys.init(this);
        getServer().getPluginManager().registerEvents(new ZeusListener(), this);
        
        Bukkit.addRecipe(PalitroqueZeus.getReceta());
        getLogger().info("¡Receta del Palitroque registrada!");
        getCommand("tocar").setExecutor(this);
        getCommand("zeus").setExecutor(this);
        getLogger().info("¡El plugin se ha habilitado!.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        boolean resultado = false;

        // Usamos command.getName() para identificar qué comando se activó
        if (command.getName().equalsIgnoreCase("tocar")) {
            if (sender instanceof Player) {
                sender.sendMessage("§a¡Has tocado el plugin 912312!");
            } else {
                sender.sendMessage("Solo jugadores pueden usar esto.");
            }
            resultado = true;
        }

        // Aquí añadimos el nuevo comando sin que choque con el anterior
        else if (command.getName().equalsIgnoreCase("zeus")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;

                // 2. Llamamos al método estático directamente
                ItemStack item = PalitroqueZeus.getPalitroque();    

                // 3. Le damos el item al inventario del jugador
                p.getInventory().addItem(item);

                p.sendMessage("§e¡Has invocado el poder de Zeus!");
            }
            resultado = true;
        }

        return resultado;
    }

    @Override
    public void onDisable() {
        getLogger().info("¡Adiós, mundo! El plugin se ha deshabilitado.");
    }
}