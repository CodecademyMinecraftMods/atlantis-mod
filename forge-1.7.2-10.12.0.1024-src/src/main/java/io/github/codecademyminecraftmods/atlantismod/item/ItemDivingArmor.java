package atlantismod.common.item;

import atlantismod.common.AtlantisMod;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemDivingArmor extends ItemArmor {

	public ItemDivingArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		if (stack.itemID == AtlantisMod.oxygenTank.itemID) return "atlantismod:textures/models/armor/oxygen_tank.png";
		return "atlantismod:textures/models/armor/diving_suit.png";
	}
}
