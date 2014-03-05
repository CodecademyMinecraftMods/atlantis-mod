package atlantismod.common;

import api.player.client.ClientPlayerAPI;
import api.player.client.ClientPlayerBase;

public class AtlantisClientPlayerBase extends ClientPlayerBase {

	public AtlantisClientPlayerBase(ClientPlayerAPI playerAPI) {
		super(playerAPI);
	}

	@Override
	public boolean canBreatheUnderwater() {
		if(player.inventory.armorInventory[0].getItem().itemID == AtlantisMod.divingHelmet.itemID && player.inventory.armorInventory[2].getItem().itemID == AtlantisMod.oxygenTank.itemID) {
			player.inventory.armorInventory[2].damageItem(1,player);
			return true;
		}
		return super.canBreatheUnderwater();
	}
	
}
