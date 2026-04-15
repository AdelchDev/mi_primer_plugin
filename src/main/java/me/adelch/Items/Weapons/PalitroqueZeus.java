package me.adelch.Items.Weapons;

import me.adelch.PluginKeys;
import me.adelch.Items.ItemUtils;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;


public class PalitroqueZeus {

    final static private String nombre = "Palitroque de Zeus";

    public static ItemStack getArma() {
        ItemStack palitroque = new ItemStack(Material.MACE);

        ItemUtils.SetAttribute(palitroque, PluginKeys.ZEUS_ITEM, 15.0, Attribute.GENERIC_ATTACK_DAMAGE, EquipmentSlotGroup.MAINHAND);
        ItemUtils.SetAttribute(palitroque, PluginKeys.ZEUS_ITEM, -3.5, Attribute.GENERIC_ATTACK_SPEED, EquipmentSlotGroup.MAINHAND);

        ItemUtils.setName(palitroque, nombre, NamedTextColor.GOLD, true, false, false, false);
        ItemUtils.setLore(palitroque,
                "<gradient:red:#ff5555>Un poderoso palitroque que otorga el poder de Zeus.</gradient>",
                "", // Línea vacía para dar aire y que no se vea todo amontonado
                "<gray>• Al golpear con toda su fuerza genera un rayo",
                "<gray>• Daño masivo",
                "<gray>• Lentitud enorme");

        // No quise meter esto en ItemUtils lmao
        ItemMeta meta = palitroque.getItemMeta();
        if (meta != null) {
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.setEnchantmentGlintOverride(true);
            meta.getPersistentDataContainer().set(PluginKeys.ZEUS_ITEM, PersistentDataType.BYTE, (byte) 1);
            palitroque.setItemMeta(meta);
        }

        return palitroque;
    }

    public static ShapedRecipe getReceta() {
        ShapedRecipe receta = new ShapedRecipe(PluginKeys.ZEUS_RECIPE, getArma());

        receta.shape(" N ", " N ", " P ");
        receta.setIngredient('N', Material.FLINT_AND_STEEL);
        receta.setIngredient('P', Material.STICK);

        return receta;
    }
}
