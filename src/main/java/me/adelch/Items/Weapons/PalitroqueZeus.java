package me.adelch.Items.Weapons;

import me.adelch.PluginKeys;
import me.adelch.Items.ItemUtils;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class PalitroqueZeus extends CustomWeapon {

    public PalitroqueZeus() {
        super(PluginKeys.ZEUS_ITEM, Material.MACE, "Palitroque de Zeus", WeaponTierTypes.EPIC, EquipmentSlotGroup.MAINHAND);
    }

    @Override
    public ItemStack createItem() {
        ItemStack Armapalitroque = new ItemStack(this.material);
        ItemMeta palitroque = Armapalitroque.getItemMeta();

        ItemUtils.setName(palitroque, name, this.tipo.getColor(), true, false,
                false, false);
        ItemUtils.setLore(palitroque,
                "<gradient:red:#ff5555>Un poderoso palitroque que otorga el poder de Zeus.</gradient>",
                "", // Línea vacía para dar aire y que no se vea todo amontonado
                "<gray>• Al golpear con toda su fuerza genera un rayo",
                "<gray>• Daño masivo",
                "<gray>• Lentitud enorme");

        ItemUtils.setAttributePorcentaje(palitroque, this.key, 15.0,
                Attribute.GENERIC_ATTACK_DAMAGE,
                this.slot);
        ItemUtils.setAttributePorcentaje(palitroque, this.key, -0.90,
                Attribute.GENERIC_ATTACK_SPEED,
                this.slot);

        ItemUtils.setAddItemFlags(palitroque, ItemFlag.HIDE_ATTRIBUTES);
        ItemUtils.setSetEnchantmentGlintOverride(palitroque, true);
        ItemUtils.setPDC(palitroque, this.key);

        Armapalitroque.setItemMeta(palitroque);
        return Armapalitroque;
    }

    @Override
    public void onHit(Entity victim) {
        ItemUtils.rayo(victim);
    }

    @Override
    public ShapedRecipe getRecipe() {

        ShapedRecipe receta = new ShapedRecipe(PluginKeys.ZEUS_RECIPE, createItem());

        receta.shape(" N ", " N ", " P ");

        receta.setIngredient('N', Material.FLINT_AND_STEEL);
        receta.setIngredient('P', Material.STICK);

        return receta;
    }

}
