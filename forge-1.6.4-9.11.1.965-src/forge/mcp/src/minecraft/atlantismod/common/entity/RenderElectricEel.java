package atlantismod.common.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderElectricEel extends RenderLiving {

	protected ModelElectricEel model;
	
	public RenderElectricEel(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		this.model = (ModelElectricEel)this.mainModel;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("atlantismod:textures/entity/ElectricEel.png");
	}
	
	public void renderTutorial(EntityElectricEel entity, double par2, double par4, double par6, float par8, float par9) {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        renderTutorial((EntityElectricEel)par1EntityLiving, par2, par4, par6, par8, par9);
    }

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        renderTutorial((EntityElectricEel)par1Entity, par2, par4, par6, par8, par9);
    }

}
