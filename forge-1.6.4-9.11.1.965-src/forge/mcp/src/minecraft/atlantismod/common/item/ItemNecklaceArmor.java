package atlantismod.common.item;

import atlantismod.common.AtlantisMod;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemNecklaceArmor extends ItemArmor {

	public ItemNecklaceArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		return "atlantismod:textures/models/armor/necklace_armor.png";
	}
	
}
