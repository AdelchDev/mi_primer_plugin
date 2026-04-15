package me.adelch;

import me.adelch.Items.Trinkets.AttackBoost;
import me.adelch.Items.Weapons.PalitroqueZeus;
import me.adelch.Items.Weapons.ZeusListener;
import me.adelch.commands.*;
import me.adelch.commands.Granters.AttackBoostCommand;
import me.adelch.commands.Granters.Minigun;
import me.adelch.commands.Granters.Zeus;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginKeys.init(this);
        getServer().getPluginManager().registerEvents(new ZeusListener(), this);
        Bukkit.addRecipe(PalitroqueZeus.getReceta());
        Bukkit.addRecipe(AttackBoost.getReceta());

        getLogger().info("¡Receta del Palitroque registrada!");

        getCommand("minigun").setExecutor(new Minigun());
        getCommand("tocar").setExecutor(new Tocar());
        getCommand("zeus").setExecutor(new Zeus());
        getCommand("soltartodos").setExecutor(new SoltarTodos());
        getCommand("attackboost").setExecutor(new AttackBoostCommand());

        getLogger().info("¡El plugin se ha habilitado!.");
    }

    @Override
    public void onDisable() {
        getLogger().info("¡Adiós, mundo! El plugin se ha deshabilitado.");
    }
}