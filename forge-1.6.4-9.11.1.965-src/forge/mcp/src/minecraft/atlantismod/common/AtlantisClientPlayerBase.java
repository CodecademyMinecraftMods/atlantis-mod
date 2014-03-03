package atlantismod.common;

import api.player.client.ClientPlayerAPI;
import api.player.client.ClientPlayerBase;

public class AtlantisClientPlayerBase extends ClientPlayerBase {

	public AtlantisClientPlayerBase(ClientPlayerAPI playerAPI) {
		super(playerAPI);
	}

	public boolean canBreatheUnderwater() {
		//player.inventory.armorInventory[0];
		return super.canBreatheUnderwater();
	}
	
}
