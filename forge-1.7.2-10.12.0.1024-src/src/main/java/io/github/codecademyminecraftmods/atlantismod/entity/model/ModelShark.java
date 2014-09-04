package atlantismod.common.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelShark extends ModelBase
{
  //fields
    ModelRenderer tail;
    ModelRenderer body1;
    ModelRenderer fin1;
    ModelRenderer fin2;
    ModelRenderer fin3;
    ModelRenderer jaw1;
    ModelRenderer jaw2;
  
  public ModelShark()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      tail = new ModelRenderer(this, 0, 0);
      tail.addBox(-6F, -3F, -1F, 12, 6, 16);
      tail.setRotationPoint(0F, 8F, 15F);
      tail.setTextureSize(128, 128);
      tail.mirror = true;
      setRotation(tail, 0F, 0F, 0F);
      body1 = new ModelRenderer(this, 46, 31);
      body1.addBox(-8F, -5F, 0F, 16, 10, 25);
      body1.setRotationPoint(0F, 8F, -10F);
      body1.setTextureSize(128, 128);
      body1.mirror = true;
      setRotation(body1, 0F, 0F, 0F);
      fin1 = new ModelRenderer(this, 73, 17);
      fin1.addBox(-2F, -3F, -1F, 4, 4, 10);
      fin1.setRotationPoint(0F, 3F, -3F);
      fin1.setTextureSize(128, 128);
      fin1.mirror = true;
      setRotation(fin1, 0F, 0F, 0F);
      fin2 = new ModelRenderer(this, 76, 8);
      fin2.addBox(-2F, -5F, 1F, 4, 2, 7);
      fin2.setRotationPoint(0F, 3F, -3F);
      fin2.setTextureSize(128, 128);
      fin2.mirror = true;
      setRotation(fin2, 0F, 0F, 0F);
      fin3 = new ModelRenderer(this, 79, 0);
      fin3.addBox(-1F, -7F, 2F, 2, 2, 6);
      fin3.setRotationPoint(0F, 3F, -3F);
      fin3.setTextureSize(128, 128);
      fin3.mirror = true;
      setRotation(fin3, 0F, 0F, 0F);
      jaw1 = new ModelRenderer(this, 2, 31);
      jaw1.addBox(-6F, -1F, -9F, 12, 2, 10);
      jaw1.setRotationPoint(0F, 6F, -10F);
      jaw1.setTextureSize(128, 128);
      jaw1.mirror = true;
      setRotation(jaw1, 0.3490659F, 0F, 0F);
      jaw2 = new ModelRenderer(this, 2, 54);
      jaw2.addBox(-6F, -1F, -9F, 12, 2, 10);
      jaw2.setRotationPoint(0F, 12F, -10F);
      jaw2.setTextureSize(128, 128);
      jaw2.mirror = true;
      setRotation(jaw2, 0.0698132F, 0F, 0F);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
	super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    tail.render(par7);
    body1.render(par7);
    fin1.render(par7);
    fin2.render(par7);
    fin3.render(par7);
    jaw1.render(par7);
    jaw2.render(par7);
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