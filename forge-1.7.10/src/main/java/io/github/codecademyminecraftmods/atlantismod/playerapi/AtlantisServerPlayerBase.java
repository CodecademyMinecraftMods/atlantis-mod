package io.github.codecademyminecraftmods.atlantismod.playerapi;

import io.github.codecademyminecraftmods.atlantismod.AtlantisMod;
import io.github.codecademyminecraftmods.atlantismod.dimension.TeleporterAtlantis;
import io.github.codecademyminecraftmods.atlantismod.thedeep.TeleporterTheDeep;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import api.player.server.ServerPlayerAPI;
import api.player.server.ServerPlayerBase;

public class AtlantisServerPlayerBase extends ServerPlayerBase {

	public AtlantisServerPlayerBase(ServerPlayerAPI playerapi) {
		super(playerapi);
	}

	@Override
	public boolean canBreatheUnderwater() {
		ItemStack helmet = this.player.inventory.armorItemInSlot(3);
		ItemStack chest = this.player.inventory.armorItemInSlot(2);
		ItemStack legs = this.player.inventory.armorItemInSlot(1);
		if((helmet != null && chest != null && legs != null) && (helmet.getItem() == AtlantisMod.divingHelmet && chest.getItem() == AtlantisMod.scubaSuit && legs.getItem() == AtlantisMod.oxygenTank) && !super.canBreatheUnderwater()) {
			this.player.inventory.armorInventory[1].damageItem(1, this.player);
			if(this.player.inventory.armorInventory[1].stackSize == 0) this.player.inventory.armorInventory[1] = null;
			return true;
		} else if(chest != null && chest.getItem() == AtlantisMod.necklace && !super.canBreatheUnderwater()) {
			this.player.inventory.armorInventory[2].damageItem(1, this.player);
			if(this.player.inventory.armorInventory[2].stackSize == 0) this.player.inventory.armorInventory[1] = null;
			return true;
		}
		return false;
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		ItemStack chest = this.player.inventory.armorItemInSlot(2);
		if(!this.player.isInsideOfMaterial(Material.water) && chest != null && chest.getItem() == AtlantisMod.necklace) {
			this.player.inventory.armorInventory[2].damageItem(-5, this.player);
		}
		if(this.player.posY < 7 && this.player.isInsideOfMaterial(Material.water)) {
			MinecraftServer server = MinecraftServer.getServer();
			if(this.player.dimension == AtlantisMod.dimensionID) {
				this.player.mcServer.getConfigurationManager().transferPlayerToDimension(this.player, AtlantisMod.dimensionDeepID, new TeleporterTheDeep(server.worldServerForDimension(AtlantisMod.dimensionDeepID)));
			}
		} else if(this.player.posY > 60 && this.player.isInsideOfMaterial(Material.water)) {
			MinecraftServer server = MinecraftServer.getServer();
			if(this.player.dimension == AtlantisMod.dimensionDeepID) {
				this.player.mcServer.getConfigurationManager().transferPlayerToDimension(this.player, AtlantisMod.dimensionID, new TeleporterAtlantis(server.worldServerForDimension(AtlantisMod.dimensionID)));
			}
		}
	}
	
	@Override
	public float getCurrentPlayerStrVsBlock(Block par1Block, boolean par2) {
		return getCurrentPlayerStrVsBlockForge(par1Block, par2, 0);
	}

	@Override
	public float getCurrentPlayerStrVsBlockForge(Block par1Block, boolean par2, int meta) {
        ItemStack stack = player.inventory.getCurrentItem();
        float f = (stack == null ? 1.0F : stack.getItem().getDigSpeed(stack, par1Block, meta));
        if (f > 1.0F) {
            int i = EnchantmentHelper.getEfficiencyModifier(this.player);
            ItemStack itemstack = this.player.inventory.getCurrentItem();
            if (i > 0 && itemstack != null) {
                float f1 = (float)(i * i + 1);
                boolean canHarvest = ForgeHooks.canToolHarvestBlock(par1Block, meta, itemstack);
                if (!canHarvest && f <= 1.0F) {
                    f += f1 * 0.08F;
                } else {
                    f += f1;
                }
            }
        }

        if (this.player.isPotionActive(Potion.digSpeed)) f *= 1.0F + (float)(this.player.getActivePotionEffect(Potion.digSpeed).getAmplifier() + 1) * 0.2F;
        if (this.player.isPotionActive(Potion.digSlowdown)) f *= 1.0F - (float)(this.player.getActivePotionEffect(Potion.digSlowdown).getAmplifier() + 1) * 0.2F;
        if (this.player.isInsideOfMaterial(Material.water) && !EnchantmentHelper.getAquaAffinityModifier(this.player)) {
        	Item tool = stack.getItem();
        	if(tool == AtlantisMod.axePearl || tool == AtlantisMod.pickaxePearl || tool == AtlantisMod.shovelPearl || tool == AtlantisMod.hoePearl) {
        		f *= 2.0F;
        	} else {
        		f /= 5.0F;
        	}
        }
        if (!this.player.onGround) f /= 5.0F;
        f = ForgeEventFactory.getBreakSpeed(this.player, par1Block, meta, f);
        return (f < 0 ? 0 : f);
	}
	
}