package me.adelch.Items;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.adelch.Items.Trinkets.AttackBoost;
import me.adelch.Items.Weapons.CustomWeapon;
import me.adelch.Items.Weapons.MinigunPesada;
import me.adelch.Items.Weapons.PalitroqueZeus;

public class ItemManager {
    private final Map<NamespacedKey, CustomItem> registry = new HashMap<>();

    public ItemManager() {

        // Registro las armas una sola vez
        register(new PalitroqueZeus());
        register(new MinigunPesada());
        register(new AttackBoost());
        // register(new otra...
    }

    private void register(CustomItem weapon) {
        registry.put(weapon.getKey(), weapon);
    }

    public CustomItem getWeapon(ItemStack item) {
        if (item == null || !item.hasItemMeta())
            return null;

        PersistentDataContainer pdc = item.getItemMeta().getPersistentDataContainer();
        for (NamespacedKey key : registry.keySet()) {
            if (pdc.has(key, PersistentDataType.BYTE)) {
                return registry.get(key);
            }
        }
        return null;
    }

    public Collection<CustomItem> getItems() {
        return registry.values();
    }

    public CustomItem getItemByKey(NamespacedKey key) {
        return registry.get(key);
    }

    public CustomItem getItemByID(String id) {
        for (CustomItem Item : registry.values()) {
            if (Item.getKey().getKey().equalsIgnoreCase(id)) {
                return Item;
            }
        }
        return null;
    }

    public List<ItemStack> getAllStacks() {
        List<ItemStack> stacks = new ArrayList<>();

        for (CustomItem custom : getItems()) {
            stacks.add(custom.createItem());
        }

        return stacks;
    }
}
