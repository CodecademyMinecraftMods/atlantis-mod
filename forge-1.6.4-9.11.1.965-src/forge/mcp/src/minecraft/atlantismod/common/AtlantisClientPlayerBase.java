package atlantismod.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import api.player.client.ClientPlayerAPI;
import api.player.client.ClientPlayerBase;

public class AtlantisClientPlayerBase extends ClientPlayerBase {

	public AtlantisClientPlayerBase(ClientPlayerAPI arg0) {
		super(arg0);
	}

	public boolean canBreatheUnderwater() {
		/*player.inventory.armorItemInSlot(0);*/
		return super.canBreatheUnderwater();
	}
	
}
