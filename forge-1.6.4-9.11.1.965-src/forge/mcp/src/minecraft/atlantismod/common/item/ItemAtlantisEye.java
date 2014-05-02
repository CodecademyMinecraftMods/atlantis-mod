package atlantismod.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemAtlantisEye extends ItemFood {

	public ItemAtlantisEye(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
	}

    protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 10000));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 10000));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 10000));
        } else {
            super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
        }
    }
    
}