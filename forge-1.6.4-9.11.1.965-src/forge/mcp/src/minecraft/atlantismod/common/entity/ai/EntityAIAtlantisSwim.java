package atlantismod.common.entity.ai;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class EntityAIAtlantisSwim extends EntityAIBase {

    private EntityCreature entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private double speed;

    public EntityAIAtlantisSwim(EntityCreature par1EntityCreature, double par2) {
        this.entity = par1EntityCreature;
        this.speed = par2;
        this.setMutexBits(1);
        this.entity.getNavigator().setCanSwim(true);
    }

    public boolean shouldExecute() {
    	if(this.entity.isInsideOfMaterial(Material.water)) {
		    Vec3 vec3 = RandomPositionGenerator.findRandomTarget(this.entity, 22, 12);
		    if (vec3 == null) return false;
		    else {
		        this.xPosition = vec3.xCoord;
		        this.yPosition = vec3.yCoord;
		        this.zPosition = vec3.zCoord;
		        return true;
		    }
    	}
    	return false;
    }

    public void updateTask() {
    	if(this.entity.getRNG().nextFloat() < 0.4F) {
    		this.entity.setJumping(true);
    	} else {
    		this.entity.setJumping(false);
    	}
    }
    
    public boolean continueExecuting() {
        return !this.entity.getNavigator().noPath();
    }

    public void startExecuting() {
        this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }

}
