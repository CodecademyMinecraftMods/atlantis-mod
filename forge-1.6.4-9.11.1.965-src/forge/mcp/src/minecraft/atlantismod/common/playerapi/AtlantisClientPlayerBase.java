package atlantismod.common.playerapi;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.StatList;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import api.player.client.ClientPlayerAPI;
import api.player.client.ClientPlayerBase;
import atlantismod.common.AtlantisMod;

public class AtlantisClientPlayerBase extends ClientPlayerBase {

	public AtlantisClientPlayerBase(ClientPlayerAPI playerapi) {
		super(playerapi);
	}

	@Override
    public void addMovementStat(double par1, double par3, double par5) {
        if (this.player.ridingEntity == null) {
            int i;
            if (this.player.isInsideOfMaterial(Material.water)) {
            	ItemStack x = this.player.inventory.armorItemInSlot(0);
                i = Math.round(MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5) * 100.0F);
                if(i > 0 && x != null && x.itemID == AtlantisMod.flippers.itemID) {
                	this.player.addStat(StatList.distanceDoveStat, i);
                	this.player.addExhaustion(0.01F * (float)i * 0.01F);
            	} else if (i > 0) {
                    this.player.addStat(StatList.distanceDoveStat, i);
                    this.player.addExhaustion(0.015F * (float)i * 0.01F);
                }
            } else if (this.player.isInWater()) {
            	ItemStack x = this.player.inventory.armorItemInSlot(0);
                i = Math.round(MathHelper.sqrt_double(par1 * par1 + par5 * par5) * 100.0F);
                if(i > 0 && x != null && x.itemID == AtlantisMod.flippers.itemID) {
                	this.player.addStat(StatList.distanceSwumStat, i);
                	this.player.addExhaustion(0.01F * (float)i * 0.01F);
            	} else if (i > 0) {
                    this.player.addStat(StatList.distanceSwumStat, i);
                    this.player.addExhaustion(0.015F * (float)i * 0.01F);
                }
            } else if (this.player.isOnLadder()) {
                if (par3 > 0.0D) {
                    this.player.addStat(StatList.distanceClimbedStat, (int)Math.round(par3 * 100.0D));
                }
            } else if (this.player.onGround) {
                i = Math.round(MathHelper.sqrt_double(par1 * par1 + par5 * par5) * 100.0F);
                if (i > 0) {
                    this.player.addStat(StatList.distanceWalkedStat, i);

                    if (this.player.isSprinting()) {
                        this.player.addExhaustion(0.099999994F * (float)i * 0.01F);
                    } else {
                        this.player.addExhaustion(0.01F * (float)i * 0.01F);
                    }
                }
            } else {
                i = Math.round(MathHelper.sqrt_double(par1 * par1 + par5 * par5) * 100.0F);
                if (i > 25) {
                    this.player.addStat(StatList.distanceFlownStat, i);
                }
            }
        }
    }

	@Override
	public float getCurrentPlayerStrVsBlock(Block par1Block, boolean par2) {
		return getCurrentPlayerStrVsBlock(par1Block, par2, 0);
	}
	
    public float getCurrentPlayerStrVsBlock(Block par1Block, boolean par2, int meta) {
        ItemStack stack = this.player.inventory.getCurrentItem();
        float f = (stack == null ? 1.0F : stack.getItem().getStrVsBlock(stack, par1Block));
        if (f > 1.0F) {
            int i = EnchantmentHelper.getEfficiencyModifier(this.player);
            ItemStack itemstack = this.player.inventory.getCurrentItem();
            if (i > 0 && itemstack != null) {
                float f1 = (float)(i * i + 1);
                boolean canHarvest = ForgeHooks.canToolHarvestBlock(par1Block, meta, itemstack);
                if (!canHarvest && f <= 1.0F) f += f1 * 0.08F;
                else f += f1;
            }
        }

        if (this.player.isPotionActive(Potion.digSpeed))
        {
            f *= 1.0F + (float)(this.player.getActivePotionEffect(Potion.digSpeed).getAmplifier() + 1) * 0.2F;
        }

        if (this.player.isPotionActive(Potion.digSlowdown))
        {
            f *= 1.0F - (float)(this.player.getActivePotionEffect(Potion.digSlowdown).getAmplifier() + 1) * 0.2F;
        }

        if (this.isInsideOfMaterial(Material.water) && !EnchantmentHelper.getAquaAffinityModifier(this.player))
        {
        	if(!(stack != null && (stack.itemID == AtlantisMod.pickaxePearl.itemID || stack.itemID == AtlantisMod.axePearl.itemID || stack.itemID == AtlantisMod.shovelPearl.itemID))) f /= 5.0F;
        }

        f = ForgeEventFactory.getBreakSpeed(this.player, par1Block, meta, f);
        return (f < 0 ? 0 : f);
    }
	
}