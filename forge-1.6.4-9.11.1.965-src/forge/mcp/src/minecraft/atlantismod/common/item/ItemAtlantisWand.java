package atlantismod.common.item;

import java.util.Random;

import atlantismod.common.AtlantisMod;
import atlantismod.common.dimension.TeleporterAtlantis;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemAtlantisWand extends Item {

	private Random rand = new Random();
	
	public ItemAtlantisWand(int par1) {
		super(par1);
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if(par2EntityPlayer instanceof EntityPlayerMP && par2EntityPlayer.isInsideOfMaterial(Material.water)) {
			if(rand.nextInt(5) == 1) par2EntityPlayer.inventory.setInventorySlotContents(par2EntityPlayer.inventory.currentItem, (ItemStack)(null));
			EntityPlayerMP player = (EntityPlayerMP) par2EntityPlayer;
			MinecraftServer server = MinecraftServer.getServer();
			if(player.dimension != AtlantisMod.dimensionID) {
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, AtlantisMod.dimensionID, new TeleporterAtlantis(server.worldServerForDimension(AtlantisMod.dimensionID)));
			} else {
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterAtlantis(server.worldServerForDimension(0)));
			}
			return true;
		}
		return false;
	}

}