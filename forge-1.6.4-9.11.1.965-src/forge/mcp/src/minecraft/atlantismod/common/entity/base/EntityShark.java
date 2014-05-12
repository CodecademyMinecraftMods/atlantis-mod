package atlantismod.common.entity.base;

import atlantismod.common.entity.ai.EntityAIAtlantisSwim;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityShark extends EntityAtlantisMob {

	public EntityShark(World par1World) {
		super(par1World);
		this.experienceValue = 10;
        this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(1, new EntityAIAtlantisSwim(this, 1.0D));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.25332148902D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(15.0D);
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
    
    public int getDropItemId() {
    	return Item.bone.itemID;
    }
	
}