package atlantismod.common.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import atlantismod.common.entity.base.EntityMermaid;
import atlantismod.common.entity.model.ModelMermaid;

public class RenderMermaid extends RenderLiving {

	protected ModelMermaid model;
	
	public RenderMermaid(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		this.model = (ModelMermaid)this.mainModel;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("atlantismod:textures/entity/Mermaid.png");
	}

	public void renderMermaid(EntityMermaid entity, double par2, double par4, double par6, float par8, float par9) {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        renderMermaid((EntityMermaid)par1EntityLiving, par2, par4, par6, par8, par9);
    }

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        renderMermaid((EntityMermaid)par1Entity, par2, par4, par6, par8, par9);
    }
	
}