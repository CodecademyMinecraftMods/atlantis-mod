package atlantismod.common;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import api.player.client.ClientPlayerAPI;
import api.player.client.ClientPlayerBase;

public class AtlantisClientPlayerBase extends ClientPlayerBase {

	public AtlantisClientPlayerBase(ClientPlayerAPI playerAPI) {
		super(playerAPI);
	}

	public boolean canBreatheUnderwater() {
		ItemStack helmet = player.inventory.armorInventory[0];
		ItemStack chest = player.inventory.armorInventory[1];
		ItemStack legs = player.inventory.armorInventory[2];
		ItemStack boots = player.inventory.armorInventory[3];
		if((helmet != null && chest != null && legs != null && boots != null) && (helmet.itemID == AtlantisMod.divingHelmet.itemID && chest.itemID == AtlantisMod.scubaSuit.itemID && legs.itemID == AtlantisMod.oxygenTank.itemID && boots.itemID == AtlantisMod.flippers.itemID)) {
			player.inventory.armorInventory[2].damageItem(1,player);
			return true;
		}
		return super.canBreatheUnderwater();
	}
	
}
