package me.adelch.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import me.adelch.PluginKeys;
import net.kyori.adventure.text.format.NamedTextColor;

public class MinigunPesada {


    public static ItemStack getMinigun() {
        ItemStack minigun = new ItemStack(Material.CROSSBOW);

        ItemUtils.setName(minigun, "MINIGUN PESADA.", NamedTextColor.GOLD, true, false, false, false);
        ItemUtils.setLore(minigun,
                "<gradient:red:#ff5555>Descripcion generica Lmao.</gradient>",
                "", // Línea vacía para dar aire y que no se vea todo amontonado
                "<gray>• Velocidad de disparo extremadamente alta",
                "<gray>• Disparo de múltiples proyectiles a la vez",
                "<gray>• Daño moderado pero compensado por su rapidez");
        ItemUtils.addEnchant(minigun, org.bukkit.enchantments.Enchantment.QUICK_CHARGE, 5);
        ItemUtils.addEnchant(minigun, org.bukkit.enchantments.Enchantment.MULTISHOT, 1);

        ItemMeta meta = minigun.getItemMeta();
        if (meta != null) {
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.setEnchantmentGlintOverride(true);
            meta.getPersistentDataContainer().set(PluginKeys.MINIGUN_KEY, PersistentDataType.BYTE, (byte) 1);
            minigun.setItemMeta(meta);
        }

        return minigun;
    }

}
