package atlantismod.common.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSquidman extends ModelBase {
//fieldss
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer leg5;
    public ModelRenderer leg6;
    public ModelRenderer leg7;
    public ModelRenderer leg8;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer rightarm;
    public ModelRenderer leftarm;
  
  public ModelSquidman()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      leg1 = new ModelRenderer(this, 56, 0);
      leg1.addBox(0F, 0F, 0F, 2, 18, 2);
      leg1.setRotationPoint(-5F, 11F, 0F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0.2617994F, 0.0872665F, 0.2617994F);
      leg2 = new ModelRenderer(this, 56, 0);
      leg2.addBox(0F, 0F, 0F, 2, 18, 2);
      leg2.setRotationPoint(0F, 11F, 0F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0.1745329F, 0F, 0F);
      leg3 = new ModelRenderer(this, 56, 0);
      leg3.addBox(0F, 0F, 0F, 2, 18, 2);
      leg3.setRotationPoint(-2F, 11F, 0F);
      leg3.setTextureSize(64, 32);
      leg3.mirror = true;
      setRotation(leg3, 0.2617994F, 0F, 0F);
      leg4 = new ModelRenderer(this, 56, 0);
      leg4.addBox(0F, 0F, 0F, 2, 18, 2);
      leg4.setRotationPoint(3F, 11F, 0F);
      leg4.setTextureSize(64, 32);
      leg4.mirror = true;
      setRotation(leg4, 0.2617994F, -0.0872665F, -0.2617994F);
      leg5 = new ModelRenderer(this, 56, 0);
      leg5.addBox(0F, 0F, 0F, 2, 18, 2);
      leg5.setRotationPoint(-5F, 11F, -2F);
      leg5.setTextureSize(64, 32);
      leg5.mirror = true;
      setRotation(leg5, -0.2617994F, -0.0872665F, 0.2617994F);
      leg6 = new ModelRenderer(this, 56, 0);
      leg6.addBox(0F, 0F, 0F, 2, 18, 2);
      leg6.setRotationPoint(-2F, 11F, -2F);
      leg6.setTextureSize(64, 32);
      leg6.mirror = true;
      setRotation(leg6, -0.1745329F, 0F, 0F);
      leg7 = new ModelRenderer(this, 56, 0);
      leg7.addBox(0F, 0F, 0F, 2, 18, 2);
      leg7.setRotationPoint(0F, 11F, -2F);
      leg7.setTextureSize(64, 32);
      leg7.mirror = true;
      setRotation(leg7, -0.2617994F, 0F, 0F);
      leg8 = new ModelRenderer(this, 56, 0);
      leg8.addBox(0F, 0F, 0F, 2, 18, 2);
      leg8.setRotationPoint(3F, 11F, -2F);
      leg8.setTextureSize(64, 32);
      leg8.mirror = true;
      setRotation(leg8, -0.2617994F, 0.0872665F, -0.2617994F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 0, 16);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
	super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    leg1.render(par7);
    leg2.render(par7);
    leg3.render(par7);
    leg4.render(par7);
    leg5.render(par7);
    leg6.render(par7);
    leg7.render(par7);
    leg8.render(par7);
    head.render(par7);
    body.render(par7);
    rightarm.render(par7);
    leftarm.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
    super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
  }

}
