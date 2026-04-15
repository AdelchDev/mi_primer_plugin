package me.adelch.Items;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class ItemUtils {


   
    public static void SetAttribute(ItemStack item, NamespacedKey key, double speed, Attribute genericAttribute, EquipmentSlotGroup slotGroup) {

        ItemMeta meta = item.getItemMeta();
        if (meta != null) {

            AttributeModifier modifier = new AttributeModifier(
                    key,
                    speed,
                    AttributeModifier.Operation.ADD_NUMBER,
                    slotGroup);

            meta.addAttributeModifier(genericAttribute, modifier);
            item.setItemMeta(meta);
        }

    }

    public static void setName(ItemStack item, String text, TextColor color,
            boolean isBold, boolean isItalic,
            boolean isUnderlined, boolean isStrikethrough) {

        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
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

    public static void addEnchant(ItemStack item, Enchantment ench, int level) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.addEnchant(ench, level, true);
            item.setItemMeta(meta);
        }
    }
}
