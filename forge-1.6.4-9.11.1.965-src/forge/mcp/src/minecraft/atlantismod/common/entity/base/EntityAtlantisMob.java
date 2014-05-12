package atlantismod.common.entity.base;

import atlantismod.common.entity.ai.EntityAIAtlantisSwim;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityAtlantisMob extends EntityMob {
	
	public EntityAtlantisMob(World par1World) {
		super(par1World);
	}

	public boolean canBreatheUnderwater() {
		return true;
	}
	
	public boolean getCanSpawnHere() {
		return this.worldObj.checkNoEntityCollision(this.boundingBox);
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
        }
        else {
            this.setAir(300);
        }
    }
	
}
