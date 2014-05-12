package atlantismod.common.entity.base;

import atlantismod.common.entity.ai.EntityAIAtlantisSwim;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;


public class EntitySquidman extends EntityAtlantisMob {
	
	public EntitySquidman(World par1World) {
		super(par1World);
		this.experienceValue = 4;
        this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(1, new EntityAIAtlantisSwim(this, 1.0D));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	public boolean isAIEnabled() {
		return true;
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(3.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.6D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(8.0D);
	}
	
    protected void dropFewItems(boolean par1, int par2) {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2), k;
        for (k = 0; k < j; ++k) this.dropItem(Item.dyePowder.itemID, j);
    }
    
    public EnumCreatureAttribute getCreatureAttribute() {
    	return EnumCreatureAttribute.UNDEAD;
    }
    
    protected String getLivingSound() {
        return "atlantismod:sounds/mob/squidman/idle";
    }

    protected String getHurtSound() {
        return "atlantismod:sounds/mob/squidman/hurt";
    }
    
    protected String getDeathSound() {
        return "atlanitsmod:sounds/mob/squidman/death";
    }

    protected void playStepSound(int par1, int par2, int par3, int par4) {}
    	
}