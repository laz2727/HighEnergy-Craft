package lazmod.crystal;

import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class ModelCrystal extends ModelBase
	{
    public String Type;
    public float size = 2;
    
	private IModelCustom modelCrystal;
    
    public ModelCrystal(String s)
    	{
    	Type = s;
    	modelCrystal = AdvancedModelLoader.loadModel("/assets/lazmod/models/crystal"+Type+".obj");
    	}
    
    public void render()
    	{
    	modelCrystal.renderAll();
    	}
    
    public void render(TileCrystal crystal, double x, double y, double z)
    	{
        GL11.glPushMatrix();
       
        GL11.glTranslatef((float)x, (float)y, (float)z + 1f);

		GL11.glScalef(0.5f*size, 0.5f*size, 0.5f*size);

	    FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation("lazmod:textures/crystals/crystal"+Type+".png"));

        this.render();

        GL11.glPopMatrix();
    	}
	}
