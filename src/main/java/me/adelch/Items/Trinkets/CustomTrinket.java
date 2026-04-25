package me.adelch.Items.Trinkets;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.EquipmentSlotGroup;

import me.adelch.Items.CustomItem;

public abstract class CustomTrinket extends CustomItem {

    EquipmentSlotGroup Activa;
    TrinketTierType tipo;

    public CustomTrinket(NamespacedKey key, Material material, String name, TrinketTierType tipo,
            EquipmentSlotGroup pasivo, EquipmentSlotGroup slotActiva) {
        super(key, material, name, pasivo);
        this.Activa = slotActiva;
        this.tipo = tipo;
    }

}
