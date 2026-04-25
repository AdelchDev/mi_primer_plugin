package me.adelch;

import me.adelch.Items.CustomItem;
import me.adelch.Items.ItemManager;
import me.adelch.Items.ListenerUtils;
import me.adelch.commands.*;
import me.adelch.commands.Granters.GiveItemCommand;
import me.adelch.commands.Granters.GiveItemsCommand;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {
    private static App instance;
    private ItemManager ItemManager;

    @Override
    public void onEnable() {
        PluginKeys.init(this);
        instance = this;
        this.ItemManager = new ItemManager();

        // Recetas
        // el remove esta para poder testear con el plugin de PlugmanX
        for (CustomItem weapon : ItemManager.getItems()) {
            Bukkit.removeRecipe(weapon.getKey());
            ShapedRecipe receta = weapon.getRecipe();
            if (receta != null) {
                Bukkit.addRecipe(receta);
            }
        }

        // Eventos
        getServer().getPluginManager().registerEvents(new ListenerUtils(this.ItemManager), this);

        // Comandos
        GiveItemCommand giveCommand = new GiveItemCommand(this.ItemManager);
        getCommand("getitem").setExecutor(giveCommand);
        getCommand("getitem").setTabCompleter(giveCommand);
        GiveItemsCommand giveAllCommand = new GiveItemsCommand(this.ItemManager);
        getCommand("getItems").setExecutor(giveAllCommand);

        getCommand("tocar").setExecutor(new Tocar());
        getCommand("soltartodos").setExecutor(new SoltarTodos());

        getLogger().info("¡El plugin se ha habilitado!.");
    }

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
    }
}