package me.adelch.Items.Trinkets;

import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.attribute.Attribute;

import me.adelch.PluginKeys;
import me.adelch.Items.ItemUtils;
import net.kyori.adventure.text.format.NamedTextColor;

public class AttackBoost {

    public static ItemStack getTrinket() {
        ItemStack AttackBoost = new ItemStack(Material.WOODEN_HOE);

        ItemUtils.SetAttribute(AttackBoost, PluginKeys.ATTACK_SPEED_KEY, 10.0, Attribute.GENERIC_ATTACK_SPEED, EquipmentSlotGroup.OFFHAND);

        ItemUtils.setName(AttackBoost, "Attack Boost", NamedTextColor.GREEN, true, false, false, false);
        ItemUtils.setLore(AttackBoost,
                "<gradient:green:#00ff00>Un poderoso boost de ataque.</gradient>",
                "", // Línea vacía para dar aire y que no se vea todo amontonado
                "<gray>• Podras librar batallas a una velocidad vertiginosa",
                "<gray>• Nadie te vera venir",
                "<gray>• El poder de la velocidad en tus manos");

        // No quise meter esto en ItemUtils lmao
        ItemMeta meta = AttackBoost.getItemMeta();
        if (meta != null) {
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.setEnchantmentGlintOverride(true);
            meta.getPersistentDataContainer().set(PluginKeys.ATTACK_SPEED_KEY, PersistentDataType.BYTE, (byte) 1);
            AttackBoost.setItemMeta(meta);
        }

        return AttackBoost;
    }

    public static ShapedRecipe getReceta() {
        ShapedRecipe receta = new ShapedRecipe(PluginKeys.ATTACK_SPEED_RECIPE, getTrinket());

        receta.shape("NNN", "NPN", "NNN");
        receta.setIngredient('N', Material.BLAZE_POWDER);
        receta.setIngredient('P', Material.FEATHER);

        return receta;
    }
}
