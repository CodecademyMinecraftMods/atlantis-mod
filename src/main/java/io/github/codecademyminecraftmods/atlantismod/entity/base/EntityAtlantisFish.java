package io.github.codecademyminecraftmods.atlantismod.entity.base;

import io.github.codecademyminecraftmods.atlantismod.AtlantisMod;
import io.github.codecademyminecraftmods.atlantismod.entity.ai.EntityAIAtlantisSwim;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityAtlantisFish extends EntityWaterMob {

	public EntityAtlantisFish(World par1World) {
		super(par1World);
		this.experienceValue = 2;
		this.tasks.addTask(0, new EntityAIAtlantisSwim(this, 1.0D));
        this.tasks.addTask(1, new EntityAILookIdle(this));
	}
	
	protected boolean isAIEnabled() {
		return true;
	}
	
	protected String getLivingSound() {
		return "";
	}
	
	protected String getHurtSound() {
		return "";
	}
	
	protected String getDeathSound() {
		return "";
	}
	
    protected void playStepSound(int par1, int par2, int par3, int par4) {}
	
    protected void dropFewItems(boolean par1, int par2) {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2), k;
        for (k = 0; k < j; ++k) this.dropItem(AtlantisMod.fishHead, j);
    }
	
}
