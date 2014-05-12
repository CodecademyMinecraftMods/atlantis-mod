package atlantismod.common.entity.base;

import atlantismod.common.AtlantisMod;
import atlantismod.common.entity.ai.EntityAIAtlantisSwim;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityKraken extends EntityAtlantisMob implements IBossDisplayData {

	public EntityKraken(World par1World) {
		super(par1World);
		this.setSize(11.0F, 1.0F);
        this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(1, new EntityAIAtlantisSwim(this, 1.0D));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.experienceValue = 50;
	}
	
	public boolean isAIEnabled() {
		return true;
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(8.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.65D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(250.0D);
	}
	
    protected void dropFewItems(boolean par1, int par2) {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
        this.dropItem(Item.bone.itemID, j);
        this.dropItem(AtlantisMod.atlantisEye.itemID, 2);
        this.dropItem(Item.diamond.itemID, 1);
    }

    public void onLivingUpdate() {
    	super.onLivingUpdate();
    	BossStatus.setBossStatus(this, true);
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

    public int getTotalArmorValue() {
        return 4;
    }

}