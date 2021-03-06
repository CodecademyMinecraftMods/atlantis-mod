package io.github.codecademyminecraftmods.atlantismod.entity.base;

import io.github.codecademyminecraftmods.atlantismod.entity.ai.EntityAIAtlantisSwim;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMermaid extends EntityVillager implements IMerchant {

	public EntityMermaid(World par1World) {
		super(par1World);
		this.tasks.addTask(0, new EntityAIAtlantisSwim(this, 1.0D));
        this.tasks.addTask(1, new EntityAILookIdle(this));
		this.experienceValue = 8;
	}
	
	public boolean isAIEnabled() {
		return true;
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(6.0D);
	}
	
    protected void dropFewItems(boolean par1, int par2) {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2), k;
        for (k = 0; k < j; ++k) this.dropItem(Items.fish, j);
    }
	
	public boolean canBreatheUnderwater() {
		return true;
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}
	
    public void onEntityUpdate() {
        int i = this.getAir();
        super.onEntityUpdate();
        if (this.isEntityAlive() && !this.isInWater()) {
            --i;
            this.setAir(i);
            if (this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.drown, 2.0F);
            }
        } else {
            this.setAir(300);
        }
    }
    
    public EntityVillager func_90012_b(EntityAgeable par1EntityAgeable) {
        EntityVillager entityvillager = new EntityMermaid(this.worldObj);
        entityvillager.onSpawnWithEgg((IEntityLivingData)null);
        return entityvillager;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return null;
    }
    
    protected String getDeathSound() {
        return null;
    }

    protected void playStepSound(int par1, int par2, int par3, int par4) {}
    
}