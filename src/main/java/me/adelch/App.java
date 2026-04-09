package me.adelch;

import me.adelch.Items.PalitroqueZeus;
import me.adelch.Items.ZeusListener;
import me.adelch.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginKeys.init(this);
        getServer().getPluginManager().registerEvents(new ZeusListener(), this);
        Bukkit.addRecipe(PalitroqueZeus.getReceta());
        getLogger().info("¡Receta del Palitroque registrada!");

        getCommand("minigun").setExecutor(new Minigun());
        getCommand("tocar").setExecutor(new Tocar());
        getCommand("zeus").setExecutor(new Zeus());
        getLogger().info("¡El plugin se ha habilitado!.");
    }

    @Override
    public void onDisable() {
        getLogger().info("¡Adiós, mundo! El plugin se ha deshabilitado.");
    }
}