package me.adelch;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginKeys {
    public static NamespacedKey ZEUS_ITEM;
    public static NamespacedKey ZEUS_RECIPE;

    public static NamespacedKey MINIGUN_KEY;

    public static NamespacedKey ARMOR_KEY;
    public static NamespacedKey ATTACK_SPEED_KEY;
    public static NamespacedKey ATTACK_SPEED_RECIPE;

    public static void init(JavaPlugin plugin) {
        ZEUS_ITEM = new NamespacedKey(plugin, "es_zeus");
        ZEUS_RECIPE = new NamespacedKey(plugin, "palitroque_zeus");

        MINIGUN_KEY = new NamespacedKey(plugin, "es_minigun");

        ARMOR_KEY = new NamespacedKey(plugin, "armor");
        ATTACK_SPEED_KEY = new NamespacedKey(plugin, "attack_speed");
        ATTACK_SPEED_RECIPE = new NamespacedKey(plugin, "attack_speed_recipe");
    }
}