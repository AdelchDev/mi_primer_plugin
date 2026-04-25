package me.adelch.Items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public abstract class CustomItem {
    protected final NamespacedKey key;
    protected final Material material;
    protected final String name;
    protected final EquipmentSlotGroup slot;

    public CustomItem(NamespacedKey key, Material material, String name,
            EquipmentSlotGroup slot) {
        this.key = key;
        this.material = material;
        this.name = name;
        this.slot = slot;
    }

    public NamespacedKey getKey() {
        return this.key;
    }

    public Material getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public EquipmentSlotGroup getSlot() {
        return slot;
    }

    public abstract ItemStack createItem();

    public abstract ShapedRecipe getRecipe();

    public void onHit(Entity victim) {
    }

}
