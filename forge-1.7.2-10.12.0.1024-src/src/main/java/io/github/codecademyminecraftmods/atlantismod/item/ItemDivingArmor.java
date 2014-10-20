package io.github.codecademyminecraftmods.atlantismod.item;

import io.github.codecademyminecraftmods.atlantismod.AtlantisMod;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemDivingArmor extends ItemArmor {

	public ItemDivingArmor(ArmorMaterial par1ArmorMaterial, int par2, int par3) {
		super(par1ArmorMaterial, par2, par3);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		if (stack.getItem() == AtlantisMod.oxygenTank) return "atlantismod:textures/models/armor/oxygen_tank.png";
		return "atlantismod:textures/models/armor/diving_suit.png";
	}
}
