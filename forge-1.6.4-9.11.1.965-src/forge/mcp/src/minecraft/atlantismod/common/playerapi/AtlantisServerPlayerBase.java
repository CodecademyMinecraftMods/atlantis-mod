package atlantismod.common.playerapi;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import api.player.server.ServerPlayerAPI;
import api.player.server.ServerPlayerBase;
import atlantismod.common.AtlantisMod;

public class AtlantisServerPlayerBase extends ServerPlayerBase {

	public AtlantisServerPlayerBase(ServerPlayerAPI playerapi) {
		super(playerapi);
	}

	@Override
	public boolean canBreatheUnderwater() {
		ItemStack helmet = this.player.inventory.armorItemInSlot(3);
		ItemStack chest = this.player.inventory.armorItemInSlot(2);
		ItemStack legs = this.player.inventory.armorItemInSlot(1);
		if((helmet != null && chest != null && legs != null) && (helmet.itemID == AtlantisMod.divingHelmet.itemID && chest.itemID == AtlantisMod.scubaSuit.itemID && legs.itemID == AtlantisMod.oxygenTank.itemID) && !super.canBreatheUnderwater()) {
			this.player.inventory.armorInventory[1].damageItem(1, this.player);
			if(this.player.inventory.armorInventory[1].stackSize == 0) this.player.inventory.armorInventory[1] = null;
			return true;
		}
		return false;
	}
	
}