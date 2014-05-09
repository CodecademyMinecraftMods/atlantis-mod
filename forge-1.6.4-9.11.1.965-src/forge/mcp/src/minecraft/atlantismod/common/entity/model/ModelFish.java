package atlantismod.common.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFish extends ModelBase
{
  //fields
    ModelRenderer Shape2;
    ModelRenderer Shape1;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
  
  public ModelFish()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape2.setRotationPoint(-2F, 13F, 0F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 4, 0);
      Shape1.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape1.setRotationPoint(-1F, 14F, 0F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 8, 0);
      Shape3.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape3.setRotationPoint(0F, 13F, 0F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 12, 0);
      Shape4.addBox(0F, 0F, 0F, 1, 5, 1);
      Shape4.setRotationPoint(1F, 12F, 0F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 16, 0);
      Shape5.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape5.setRotationPoint(2F, 13F, 0F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 20, 0);
      Shape6.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape6.setRotationPoint(3F, 14F, 0F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
	super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    Shape2.render(par7);
    Shape1.render(par7);
    Shape3.render(par7);
    Shape4.render(par7);
    Shape5.render(par7);
    Shape6.render(par7);
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