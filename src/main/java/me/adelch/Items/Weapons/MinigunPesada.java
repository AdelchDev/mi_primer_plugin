package me.adelch.Items.Weapons;

import me.adelch.PluginKeys;
import me.adelch.Items.ItemUtils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class MinigunPesada extends CustomWeapon {

    public MinigunPesada() {
        super(PluginKeys.MINIGUN_KEY, Material.CROSSBOW, "MINIGUN PESADA.", WeaponTierTypes.UNCOMMON, EquipmentSlotGroup.HAND);
    }

    @Override
    public ItemStack createItem() {
        ItemStack item = new ItemStack(this.material);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            ItemUtils.setName(meta, this.name, this.tipo.getColor() , true, false, false, false);
            ItemUtils.setLore(meta,
                    "<gradient:red:#ff5555>Una maravilla de la ingeniería destructiva.</gradient>",
                    "",
                    "<gray>• Velocidad de disparo extremadamente alta",
                    "<gray>• Disparo de múltiples proyectiles a la vez",
                    "<gray>• Daño moderado pero compensado por su rapidez");
            ItemUtils.addEnchant(meta, Enchantment.QUICK_CHARGE, 5);
            ItemUtils.addEnchant(meta, Enchantment.MULTISHOT, 1);
            ItemUtils.setAddItemFlags(meta, ItemFlag.HIDE_ATTRIBUTES);
            ItemUtils.setSetEnchantmentGlintOverride(meta, true);
            ItemUtils.setPDC(meta, this.key); 
            item.setItemMeta(meta);
        }

        return item;
    }

    @Override
    public void onHit(Entity victim) {

    }

    @Override
    public ShapedRecipe getRecipe() {
        ShapedRecipe receta = new ShapedRecipe(this.key, createItem());
        receta.shape("III", "ICI", "R R");
        receta.setIngredient('I', Material.IRON_INGOT);
        receta.setIngredient('C', Material.CROSSBOW);
        receta.setIngredient('R', Material.REPEATER);
        return receta;
    }
}