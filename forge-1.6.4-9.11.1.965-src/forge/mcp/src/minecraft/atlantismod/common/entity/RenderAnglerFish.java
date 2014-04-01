package atlantismod.common.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderAnglerFish extends RenderLiving {

	protected ModelAnglerFish model;
	
	public RenderAnglerFish(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		this.model = (ModelAnglerFish)this.mainModel;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("atlantismod:textures/entity/AnglerFish.png");
	}
	
	public void renderTutorial(EntityAnglerFish entity, double par2, double par4, double par6, float par8, float par9) {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        renderTutorial((EntityAnglerFish)par1EntityLiving, par2, par4, par6, par8, par9);
    }

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        renderTutorial((EntityAnglerFish)par1Entity, par2, par4, par6, par8, par9);
    }

}
