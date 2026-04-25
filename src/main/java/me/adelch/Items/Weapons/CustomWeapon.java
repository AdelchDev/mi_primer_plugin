package me.adelch.Items.Weapons;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.EquipmentSlotGroup;

import me.adelch.Items.CustomItem;

public abstract class CustomWeapon extends CustomItem {

    WeaponTierTypes tipo;

    public CustomWeapon(NamespacedKey key, Material material, String name, WeaponTierTypes tipo,
            EquipmentSlotGroup slot) {
        super(key, material, name, slot);
        this.tipo = tipo;
    }

}
