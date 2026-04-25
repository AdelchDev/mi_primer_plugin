package me.adelch.Items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class ItemUtils {

    public static void setAttributePorcentaje(ItemMeta meta, NamespacedKey key, double ammount, Attribute genericAttribute,
            EquipmentSlotGroup slotGroup) {

        if (meta != null) {

            AttributeModifier modifier = new AttributeModifier(
                    key,
                    ammount,
                    AttributeModifier.Operation.ADD_SCALAR,
                    slotGroup);

            meta.addAttributeModifier(genericAttribute, modifier);
        }

    }

    /*
     * public void SetEffect(ItemStack item, EquipmentSlotGroup slotGroup,
     * LivingEntity player,
     * PotionEffectType... lines) {
     * 
     * ItemMeta meta = item.getItemMeta();
     * if (meta != null) {
     * 
     * Collection<PotionEffect> effects = new ArrayList<>();
     * 
     * for (PotionEffectType potionEffectType : lines) {
     * PotionEffect potionEffect = new PotionEffect(potionEffectType, 100, 100);
     * effects.add(potionEffect);
     * }
     * 
     * player.addPotionEffects​(effects);
     * }
     * 
     * }
     */

    public static void setName(ItemMeta meta, String text, TextColor color,
            boolean isBold, boolean isItalic,
            boolean isUnderlined, boolean isStrikethrough) {

        if (meta != null) {
            Component nameComponent = Component.text(text)
                    .color(color)
                    .decoration(TextDecoration.BOLD, isBold)
                    .decoration(TextDecoration.ITALIC, isItalic)
                    .decoration(TextDecoration.UNDERLINED, isUnderlined)
                    .decoration(TextDecoration.STRIKETHROUGH, isStrikethrough);

            meta.displayName(nameComponent);
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
    public static void setLore(ItemMeta meta, String... lines) {

        if (meta != null) {

            List<Component> loreComponents = new ArrayList<>();
            for (String line : lines) {
                Component component = MiniMessage.miniMessage().deserialize(line);
                component.decoration(TextDecoration.ITALIC, false);

                loreComponents.add(component);
            }
            meta.lore(loreComponents);
        }
    }

    public static void addEnchant(ItemMeta meta, Enchantment ench, int level) {
        if (meta != null) {
            meta.addEnchant(ench, level, true);
        }
    }

    // Funciones de verificación de Items

    public static boolean isValidAttack(Entity entity, NamespacedKey itemKey) {
        return entity instanceof Player jugador && isHoldingItem(jugador, itemKey)
                && isAttackFullyCharged(jugador);
    }

    public static boolean isAttackFullyCharged(Player p) {
        return p.getAttackCooldown() >= 1.0f;
    }

    public static boolean isHoldingItem(Player p, NamespacedKey key) {
        ItemStack item = p.getInventory().getItemInMainHand();
        return item != null
                && item.hasItemMeta()
                && item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.BYTE);
    }

    public static void setAddItemFlags(ItemMeta palitroque, ItemFlag hideAttributes) {
        palitroque.addItemFlags(hideAttributes);
    }

    public static void setSetEnchantmentGlintOverride(ItemMeta palitroque, boolean bool) {
        palitroque.setEnchantmentGlintOverride(bool);
    }

    public static void setPDC(ItemMeta palitroque, NamespacedKey key) {
        if (palitroque != null) {
            palitroque.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);
        }
    }

    public static void rayo(Entity victim) {
        victim.getWorld().strikeLightning(victim.getLocation());
    }

}
