package io.github.codecademyminecraftmods.atlantismod.entity.render;

import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityKraken;
import io.github.codecademyminecraftmods.atlantismod.entity.model.ModelKraken;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderKraken extends RenderLiving {

	protected ModelKraken model;
	
	public RenderKraken(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		this.model = (ModelKraken)this.mainModel;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("atlantismod:textures/entity/Kraken.png");
	}
    
	public void renderKraken(EntityKraken entity, double par2, double par4, double par6, float par8, float par9) {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        renderKraken((EntityKraken)par1EntityLiving, par2, par4, par6, par8, par9);
    }

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        renderKraken((EntityKraken)par1Entity, par2, par4, par6, par8, par9);
    }

}