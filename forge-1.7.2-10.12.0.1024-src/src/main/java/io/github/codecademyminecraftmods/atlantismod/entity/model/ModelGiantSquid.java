package atlantismod.common.entity.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class ModelGiantSquid extends ModelBase
{
  //fields
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer head;
    ModelRenderer leg4;
    ModelRenderer leg5;
    ModelRenderer leg6;
    ModelRenderer body2;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
  
  public ModelGiantSquid()
  {
    textureWidth = 256;
    textureHeight = 64;
    
      leg1 = new ModelRenderer(this, 80, 0);
      leg1.addBox(-1F, -1F, -1F, 2, 2, 26);
      leg1.setRotationPoint(7F, 5F, 12F);
      leg1.setTextureSize(256, 256);
      leg1.mirror = true;
      setRotation(leg1, 0.2617994F, 0.2617994F, 0F);
      leg2 = new ModelRenderer(this, 80, 0);
      leg2.addBox(-1F, -1F, -1F, 2, 2, 26);
      leg2.setRotationPoint(-7F, 5F, 12F);
      leg2.setTextureSize(256, 256);
      leg2.mirror = true;
      setRotation(leg2, 0.2617994F, -0.2617994F, 0F);
      leg3 = new ModelRenderer(this, 80, 0);
      leg3.addBox(-1F, -1F, -1F, 2, 2, 26);
      leg3.setRotationPoint(7F, 19F, 12F);
      leg3.setTextureSize(256, 256);
      leg3.mirror = true;
      setRotation(leg3, -0.2617994F, 0.2617994F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(0F, 0F, 0F, 16, 16, 20);
      head.setRotationPoint(-8F, 4F, -9F);
      head.setTextureSize(256, 256);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 80, 0);
      leg4.addBox(-1F, -1F, -1F, 2, 2, 26);
      leg4.setRotationPoint(0F, 19F, 12F);
      leg4.setTextureSize(256, 256);
      leg4.mirror = true;
      setRotation(leg4, -0.2617994F, 0F, 0F);
      leg5 = new ModelRenderer(this, 80, 0);
      leg5.addBox(-1F, -1F, -1F, 2, 2, 26);
      leg5.setRotationPoint(-7F, 19F, 12F);
      leg5.setTextureSize(256, 256);
      leg5.mirror = true;
      setRotation(leg5, -0.2617994F, -0.2617994F, 0F);
      leg6 = new ModelRenderer(this, 80, 0);
      leg6.addBox(-1F, -1F, -1F, 2, 2, 26);
      leg6.setRotationPoint(-7F, 12F, 12F);
      leg6.setTextureSize(256, 256);
      leg6.mirror = true;
      setRotation(leg6, 0F, -0.2617994F, 0F);
      body2 = new ModelRenderer(this, 0, 36);
      body2.addBox(2F, 2F, 20F, 12, 12, 5);
      body2.setRotationPoint(-8F, 4F, -9F);
      body2.setTextureSize(256, 256);
      body2.mirror = true;
      setRotation(body2, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 80, 0);
      Shape1.addBox(-1F, -1F, -1F, 2, 2, 26);
      Shape1.setRotationPoint(0F, 5F, 12F);
      Shape1.setTextureSize(256, 256);
      Shape1.mirror = true;
      setRotation(Shape1, 0.2617994F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 80, 0);
      Shape2.addBox(-1F, -1F, -1F, 2, 2, 26);
      Shape2.setRotationPoint(7F, 12F, 12F);
      Shape2.setTextureSize(256, 256);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0.2617994F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    head.render(f5);
    leg4.render(f5);
    leg5.render(f5);
    leg6.render(f5);
    body2.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
	  
  }
}
