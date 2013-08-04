package halliom.client.render;

import halliom.client.gui.special.Gui3DHandler;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class QuartzCauldronRenderer extends TileEntitySpecialRenderer 
{
	
	private IModelCustom cauldronModel = AdvancedModelLoader.loadModel("/model/cauldron_quartz.obj");
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		{
//			FMLClientHandler.instance().getClient().renderEngine.func_110577_a(new ResourceLocation("backpacked", "texture/cauldron_quartz.png"));
			GL11.glTranslatef((float)x, (float)y, (float)z + 1.05f);
			cauldronModel.renderAll();
		}
		GL11.glPopMatrix();
		
		if (Gui3DHandler.has3DGuiOpen(FMLClientHandler.instance().getClient().thePlayer))
		{
			GL11.glPushMatrix();
			
			Gui3DHandler.getOpenGui(FMLClientHandler.instance().getClient().thePlayer).draw(x, y, z, f);
			GL11.glPopMatrix();
		}
	}

}
