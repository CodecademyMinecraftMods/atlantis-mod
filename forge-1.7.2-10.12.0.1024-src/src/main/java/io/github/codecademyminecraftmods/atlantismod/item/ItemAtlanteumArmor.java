package io.github.codecademyminecraftmods.atlantismod.item;

import io.github.codecademyminecraftmods.atlantismod.AtlantisMod;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemAtlanteumArmor extends ItemArmor {

	public ItemAtlanteumArmor(ArmorMaterial par1ArmorMaterial, int par2, int par3) {
		super(par1ArmorMaterial, par2, par3);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String stype) {
		if (stack.getItem() == AtlantisMod.legsAtlanteum) return "atlantismod:textures/models/armor/atlanteum_layer_2.png";
		return "atlantismod:textures/models/armor/atlanteum_layer_1.png";
	}
}
