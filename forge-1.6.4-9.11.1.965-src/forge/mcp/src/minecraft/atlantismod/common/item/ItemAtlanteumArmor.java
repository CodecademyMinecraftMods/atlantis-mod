package atlantismod.common.item;

import atlantismod.common.AtlantisMod;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemAtlanteumArmor extends ItemArmor {

	public ItemAtlanteumArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		if (stack.itemID == AtlantisMod.legsAtlanteum.itemID) return "atlantismod:textures/models/armor/atlanteum_layer_2.png";
		return "atlantismod:textures/models/armor/atlanteum_layer_1.png";
	}
}
