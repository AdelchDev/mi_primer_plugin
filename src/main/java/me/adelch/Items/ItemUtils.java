package me.adelch.Items;

import me.adelch.PluginKeys;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlotGroup;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class ItemUtils {

    public static void SetDamage(ItemStack item, double damage) {

        ItemMeta meta = item.getItemMeta();
        if (meta != null) {

            AttributeModifier modifier = new AttributeModifier(
                    PluginKeys.ZEUS_ITEM,
                    damage,
                    AttributeModifier.Operation.ADD_NUMBER,
                    EquipmentSlotGroup.MAINHAND);

            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
            item.setItemMeta(meta);
        }

    }

    public static void SetAttackSpeed(ItemStack item, double speed) {

        ItemMeta meta = item.getItemMeta();
        if (meta != null) {

            AttributeModifier modifier = new AttributeModifier(
                    PluginKeys.ZEUS_ITEM,
                    speed,
                    AttributeModifier.Operation.ADD_NUMBER,
                    EquipmentSlotGroup.MAINHAND);

            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
            item.setItemMeta(meta);
        }

    }

    public static void setName(ItemStack item, String text, TextColor color,
            boolean isBold, boolean isItalic,
            boolean isUnderlined, boolean isStrikethrough) {

        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            // Debes encadenar los métodos porque cada uno devuelve un NUEVO objeto
            Component nameComponent = Component.text(text)
                    .color(color)
                    .decoration(TextDecoration.BOLD, isBold)
                    .decoration(TextDecoration.ITALIC, isItalic)
                    .decoration(TextDecoration.UNDERLINED, isUnderlined)
                    .decoration(TextDecoration.STRIKETHROUGH, isStrikethrough);

            meta.displayName(nameComponent);
            item.setItemMeta(meta);
        }
    }

    /**
     * Define el Lore (descripción) del ítem.
     * Soporta múltiples líneas y formato MiniMessage.
     * * Ejemplo de uso:
     * ItemUtils.setLore(item,
     * "<gray>Línea de texto simple",
     * "<red><bold>Línea con estilo",
     * "<gradient:blue:white>Línea con degradado</gradient>"
     * );
     * * @param item El ItemStack a modificar.
     * 
     * @param lines Cadenas de texto (una por cada línea del lore).
     */
    public static void setLore(ItemStack item, String... lines) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {

            List<Component> loreComponents = new ArrayList<>();
            for (String line : lines) {
                Component component = MiniMessage.miniMessage().deserialize(line);
                component.decoration(TextDecoration.ITALIC, false);

                loreComponents.add(component);
            }

            meta.lore(loreComponents);
            item.setItemMeta(meta);
        }
    }

    public static void addTag(ItemStack item, NamespacedKey key) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);
            item.setItemMeta(meta);
        }
    }

    public static void addEnchant(ItemStack item, Enchantment ench, int level) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {

            meta.addEnchant(ench, level, true);
            item.setItemMeta(meta);
        }
    }

}
