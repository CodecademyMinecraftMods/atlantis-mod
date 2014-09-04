package atlantismod.common.entity.render;

import atlantismod.common.entity.base.EntitySquidman;
import atlantismod.common.entity.model.ModelSquidman;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.util.ResourceLocation;

public class RenderSquidman extends RenderLiving {

	protected ModelSquidman model;
	
	public RenderSquidman(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		this.model = (ModelSquidman)this.mainModel;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("atlantismod:textures/entity/Squidman.png");
	}
    
	public void renderSquidman(EntitySquidman entity, double par2, double par4, double par6, float par8, float par9) {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        renderSquidman((EntitySquidman)par1EntityLiving, par2, par4, par6, par8, par9);
    }

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        renderSquidman((EntitySquidman)par1Entity, par2, par4, par6, par8, par9);
    }

}
