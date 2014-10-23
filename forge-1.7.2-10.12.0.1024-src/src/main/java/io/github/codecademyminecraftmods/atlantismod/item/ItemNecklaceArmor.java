package io.github.codecademyminecraftmods.atlantismod.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemNecklaceArmor extends ItemArmor {

	public ItemNecklaceArmor(ArmorMaterial par1ArmorMaterial, int par2, int par3) {
		super(par1ArmorMaterial, par2, par3);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String stype) {
		return "atlantismod:textures/models/armor/necklace_armor.png";
	}
	
}
